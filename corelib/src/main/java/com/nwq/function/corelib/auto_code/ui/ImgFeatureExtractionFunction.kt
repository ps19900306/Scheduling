package com.nwq.function.corelib.auto_code.ui

import com.nwq.function.corelib.auto_code.FeatureCoordinatePoint
import com.nwq.function.corelib.auto_code.FeaturePointKey
import com.nwq.function.corelib.auto_code.FunctionBlock

/**
create by: 86136
create time: 2023/5/16 9:34
Function description:
 */

class ImgFeatureExtractionFunction(
    val startX: Int,
    val startY: Int,
    val with: Int,
    val height: Int,
    val imgArray: List<IntArray>
) : FunctionBlock {


    private var targetColorMap = hashMapOf<FeaturePointKey, MutableList<FeatureCoordinatePoint>>()
    private var brightestKey: FeaturePointKey = FeaturePointKey(0, 0, 0)
    private var differenceKey: FeaturePointKey = FeaturePointKey(0, 0, 0)
    private var darkestKey: FeaturePointKey = FeaturePointKey(255, 255, 255)
    var autoDiscoverFeature = true //自动寻找特征值

    private val featureArray: Array<Array<FeatureCoordinatePoint>> by lazy {
        val dataList = mutableListOf<Array<FeatureCoordinatePoint>>()
        var data = mutableListOf<FeatureCoordinatePoint>()
        imgArray.forEachIndexed { y, arry ->
            if (y != 0) {
                dataList.add(data.toTypedArray())
                data.clear()
            }
            arry.forEachIndexed { x, colorInt ->
                autoFindTargetColor(colorInt)
                data.add(FeatureCoordinatePoint(x, y, colorInt))
            }
        }
        if (autoDiscoverFeature) {
            targetColorMap.put(brightestKey, mutableListOf())
            targetColorMap.put(differenceKey, mutableListOf())
            targetColorMap.put(darkestKey, mutableListOf())
            brightestKey.update()
            differenceKey.update()
            darkestKey.update()
            brightestKey.ignoreRatio = true
            darkestKey.ignoreRatio = true

        }
        dataList.add(data.toTypedArray())
        dataList.toTypedArray()
    }

    private fun autoFindTargetColor(colorInt: Int) {
        if (!autoDiscoverFeature)
            return
        brightestKey.getBrightest(colorInt)
        differenceKey.getDifference(colorInt)
        darkestKey.getDarkest(colorInt)
    }


    //对外暴露的方法
    fun addFeatureKey(colorInt: Int) {
        targetColorMap.put(FeaturePointKey(colorInt), mutableListOf())
    }


    //根据色值对颜色进行分组
    fun groupFeatureCoordinatePoint() {
        featureArray.forEach { array ->
            array.forEach { point ->
                targetColorMap.forEach {
                    if (it.key.isInRange(point.red, point.green, point.blue)) {
                        it.value.add(point)
                    }
                }
            }
        }
    }

    //获取是边界的位置
    fun markBoundary(originalList: MutableList<FeatureCoordinatePoint>) {
        originalList.forEach { point ->
            var isBoundary = false

            //left
            if (!isBoundary && point.x > 0) {
                val leftPoint = featureArray[point.y][point.x - 1]
                if (!originalList.contains(leftPoint)) {
                    isBoundary = true
                    point.setBoundary()
                }
            }

            //top
            if (!isBoundary && point.y > 0) {
                val topPoint = featureArray[point.y - 1][point.x]
                if (!originalList.contains(topPoint)) {
                    isBoundary = true
                    point.setBoundary()
                }
            }

            //right
            if (!isBoundary && point.x < with) {
                val rightPoint = featureArray[point.y][point.x + 1]
                if (!originalList.contains(rightPoint)) {
                    isBoundary = true
                    point.setBoundary()
                }
            }

            //bottom
            if (!isBoundary && point.y < height) {
                val bottomPoint = featureArray[point.y + 1][point.x]
                if (!originalList.contains(bottomPoint)) {
                    isBoundary = true
                    point.setBoundary()
                }
            }

            if (!isBoundary) {
                point.setInternal()
            }
        }
    }


    fun obtainFeaturePoints(originalList: MutableList<FeatureCoordinatePoint>) {
        var startPoint = originalList.find { it.hasContinuousSet }
        while (startPoint != null) {
            startPoint.setStartPosition()


            startPoint = originalList.find { it.hasContinuousSet }
        }
    }

    //对组进行分块
    fun groupBlock(
        startPoint: FeatureCoordinatePoint,
        originalList: MutableList<FeatureCoordinatePoint>
    ) {
        val blockList = mutableListOf<FeatureCoordinatePoint>()
        var step = 0
        val oldList = mutableListOf(startPoint)
        val newList = mutableListOf<FeatureCoordinatePoint>()
        val extremePoints = mutableListOf<FeatureCoordinatePoint>()//端点，就是找不延续的点了

        while (!oldList.isEmpty()) {
            step++
            newList.clear()
            oldList.forEach {
                val result = dynamicSearchAround(it, originalList, blockList)
                if (result.isEmpty()) {
                    extremePoints.add(it)
                } else {
                    newList.addAll(result)
                }
            }
            oldList.clear()
            oldList.addAll(newList)
        }


    }


    //动态向八方进行延展，同时进行排序
    fun dynamicSearchAround(
        point: FeatureCoordinatePoint,
        originalList: MutableList<FeatureCoordinatePoint>,
        blockList: MutableList<FeatureCoordinatePoint>,
    ): List<FeatureCoordinatePoint> {
        val list = mutableListOf<FeatureCoordinatePoint>()
        if (point.x > 0) {
            val leftPoint = featureArray[point.y][point.x - 1]
            if (originalList.contains(leftPoint)) {
                leftPoint.continuePath(point)?.let { list.add(it) }
                if (!blockList.contains(leftPoint)) {
                    blockList.add(leftPoint)
                }
            }
        }

        //top
        if (point.y > 0) {
            val topPoint = featureArray[point.y - 1][point.x]
            if (originalList.contains(topPoint)) {
                topPoint.continuePath(point)?.let { list.add(it) }
                if (!blockList.contains(topPoint)) {
                    blockList.add(topPoint)
                }
            }
        }


        //right
        if (point.x < with) {
            val rightPoint = featureArray[point.y][point.x + 1]
            if (originalList.contains(rightPoint)) {
                rightPoint.continuePath(point)?.let { list.add(it) }
                if (!blockList.contains(rightPoint)) {
                    blockList.add(rightPoint)
                }
            }
        }

        //bottom
        if (point.y < height) {
            val bottomPoint = featureArray[point.y + 1][point.x]
            if (originalList.contains(bottomPoint)) {
                bottomPoint.continuePath(point)?.let { list.add(it) }
                if (!blockList.contains(bottomPoint)) {
                    blockList.add(bottomPoint)
                }
            }
        }

        if (point.x > 0 && point.y > 0) {
            val point = featureArray[point.y - 1][point.x - 1]
            if (originalList.contains(point)) {
                point.continuePath(point)?.let { list.add(it) }
                if (!blockList.contains(point)) {
                    blockList.add(point)
                }
            }
        }

        if (point.x > 0 && point.y < height) {
            val point = featureArray[point.y + 1][point.x - 1]
            if (originalList.contains(point)) {
                point.continuePath(point)?.let { list.add(it) }
                if (!blockList.contains(point)) {
                    blockList.add(point)
                }
            }
        }

        if (point.x < with && point.y > 0) {
            val point = featureArray[point.y - 1][point.x + 1]
            if (originalList.contains(point)) {
                point.continuePath(point)?.let { list.add(it) }
                if (!blockList.contains(point)) {
                    blockList.add(point)
                }
            }
        }

        if (point.x < with && point.y < height) {
            val point = featureArray[point.y + 1][point.x + 1]
            if (originalList.contains(point)) {
                point.continuePath(point)?.let { list.add(it) }
                if (!blockList.contains(point)) {
                    blockList.add(point)
                }
            }
        }
        return list
    }


    fun setBrightestIntFeature(data: FeaturePointKey) {
        if (targetColorMap.contains(brightestKey)) {
            targetColorMap.remove(brightestKey)
        }
        brightestKey = data
        targetColorMap.put(brightestKey, mutableListOf())
    }

    fun setDifferenceFeature(data: FeaturePointKey) {
        if (targetColorMap.contains(differenceKey)) {
            targetColorMap.remove(differenceKey)
        }
        differenceKey = data
        targetColorMap.put(differenceKey, mutableListOf())
    }

    fun setDarkestFeature(data: FeaturePointKey) {
        if (targetColorMap.contains(darkestKey)) {
            targetColorMap.remove(darkestKey)
        }
        darkestKey = data
        targetColorMap.put(darkestKey, mutableListOf())
    }

}