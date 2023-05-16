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

    //标记每个点的位置,标记为内部点或者是边界点
    fun markBoundaryInternal(originalList: MutableList<FeatureCoordinatePoint>) {
        originalList.forEach { point ->
            if (!point.hasJudeType()) {
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
    }

    //获取特征点，这里建议使用边界点
    fun obtainFeaturePoints(
        originalList: MutableList<FeatureCoordinatePoint>,
        pickingInterval: Int = 20
    ): List<FeatureCoordinatePoint> {
        val list = mutableListOf<FeatureCoordinatePoint>()
        var startPoint = originalList.find { it.hasContinuousSet }
        while (startPoint != null) {
            startPoint.setStartPosition()
            val extremePoints = groupBlock(startPoint, originalList, pickingInterval)
            list.addAll(extremePoints)
            startPoint = originalList.find { it.hasContinuousSet }
        }
        return list
    }

    //对组进行分块
    fun groupBlock(
        startPoint: FeatureCoordinatePoint,
        originalList: MutableList<FeatureCoordinatePoint>,
        pickingInterval: Int = 20
    ): List<FeatureCoordinatePoint> {
        val blockList = mutableListOf<FeatureCoordinatePoint>()
        var step = 0 //这里用于记录最大步数
        val oldList = mutableListOf(startPoint)
        val newList = mutableListOf<FeatureCoordinatePoint>()
        val extremePoints = mutableListOf<FeatureCoordinatePoint>()//端点，就是找不延续的点了
        val endList = mutableListOf<FeatureCoordinatePoint>()
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
            if (newList.isEmpty()) {
                endList.addAll(oldList)
            }
            oldList.clear()
            oldList.addAll(newList)
            filterExtremePoint(extremePoints, newList)
        }

        //过滤掉一些端点
        filterExtremePoint(extremePoints, extremePoints)
        filterExtremePoint(extremePoints, listOf(startPoint))

        var point = step / pickingInterval //取点数目
        if (point < 4) { //一块至少取点四个
            point = 4
        }

        oldList.getOrNull(0)?.let {
            //增加首尾点
            extremePoints.add(startPoint)
            extremePoints.add(it)

            val part = it.sequenceNumber / 4
            var data = it
            var i = point - 1
            var number = part * i
            while (data.previousPoint != null && i > 0) {
                data = data.previousPoint!!
                if (data.sequenceNumber == number) {
                    extremePoints.add(data)
                    i--
                    number = part * i
                }
            }
        }
        return extremePoints
    }


    //这里是为了优化过滤掉端点，去掉一些不必要的点
    private fun filterExtremePoint(
        originalList: MutableList<FeatureCoordinatePoint>,
        filterList: List<FeatureCoordinatePoint>
    ) {
        val iterator = originalList.iterator()
        while (iterator.hasNext()) {//去除近的端点
            val item = iterator.next()
            if (filterList.find {
                    (it.x != item.x || it.y != item.y) //保证不是同一个点
                            && (Math.abs(it.x - item.x) < 3 && Math.abs(it.x - item.x) < 3)//发现二点过近
                } != null) {
                iterator.remove()
            }
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