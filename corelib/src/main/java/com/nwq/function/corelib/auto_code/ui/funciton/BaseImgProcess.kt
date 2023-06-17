package com.nwq.function.corelib.auto_code.ui.funciton

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.auto_code.ui.data.FeatureCoordinatePoint
import com.nwq.function.corelib.auto_code.ui.data.FeaturePointKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

/**
create by: 86136
create time: 2023/5/22 13:43
Function description:
suspend标记耗时操作
 */

class BaseImgProcess(
    private val with: Int,
    private val height: Int,
    private val imgArray: List<IntArray>,
) {

    private val pointNumberThreshold = 20 //如果特征值的点数过少则无视掉
    private val picking_Interval=10 //这里是间隔多少个点进行一次取值
    var colorMaps = mutableMapOf<FeaturePointKey, MutableList<FeatureCoordinatePoint>>()
    val featureKeyList = mutableListOf<FeaturePointKey>()
    private var brightestKey: FeaturePointKey = FeaturePointKey(0, 0, 0)
    private var differenceKey: FeaturePointKey = FeaturePointKey(0, 0, 0)
    private var darkestKey: FeaturePointKey = FeaturePointKey(255, 255, 255)
    private lateinit var featureArray: Array<Array<FeatureCoordinatePoint>>


    //开始前必须调用此方法，且在非主线程调用，耗时
    suspend fun preprocessData() {
        val dataList = mutableListOf<Array<FeatureCoordinatePoint>>()
        var data = mutableListOf<FeatureCoordinatePoint>()
        imgArray.forEachIndexed { y, arry ->
            if (y != 0) {//因为y=0时候第一组数据还未写入
                dataList.add(data.toTypedArray())
                data.clear()
            }
            arry.forEachIndexed { x, colorInt ->
                val point = FeatureCoordinatePoint(x, y, colorInt)
                groupPoint(point, colorInt)
                data.add(point)
            }
        }
        dataList.add(data.toTypedArray())
        featureArray = dataList.toTypedArray()
        organizeColorMaps()
    }

    /**
     * 自动对点进行分组 找到三个特征最高的关键
     */
    private fun groupPoint(point: FeatureCoordinatePoint, colorInt: Int) {
        val key = featureKeyList.find { it.isInRange(point) }
        if (key != null) {
            point.mFeaturePointKey = key
            colorMaps[key]?.add(point)
        } else {
            val newKey = FeaturePointKey(colorInt)
            point.mFeaturePointKey = newKey
            val list = mutableListOf<FeatureCoordinatePoint>()
            list.add(point)
            featureKeyList.add(newKey)
            colorMaps[newKey] = list
        }
    }


    private suspend fun organizeColorMaps() {
        Timber.d("${colorMaps.size} 过滤前大小 BaseImgProcess NWQ_ 2023/6/7");
        colorMaps = colorMaps.filter {
            it.key.pointCount = it.value.size
            it.value.size > pointNumberThreshold
        }.toMutableMap()
        Timber.d("${colorMaps.size} 过滤后大小 BaseImgProcess NWQ_ 2023/6/7");
        featureKeyList.clear()
        featureKeyList.addAll(colorMaps.keys.sortedByDescending { it.pointCount })
        colorMaps.forEach {
            brightestKey = brightestKey.getBrightest(it.key)
            differenceKey = differenceKey.getDifference(it.key)
            darkestKey = darkestKey.getDarkest(it.key)
        }
        brightestKey.isKeyMember = true
        differenceKey.isKeyMember = true
        darkestKey.isKeyMember = true
    }


    /**
     *对特定特质值进行获取图片
     */
    //根据色值对颜色进行分组
    suspend fun groupFeatureCoordinatePoint(list: List<FeaturePointKey>) {
        featureArray.forEach { array ->
            array.forEach { point ->
                list.forEach { featureKey ->
                    if (featureKey.isInRange(point)) {
                        point.mFeaturePointKey = featureKey
                        (colorMaps[featureKey] ?: mutableListOf<FeatureCoordinatePoint>().apply {
                            colorMaps[featureKey] = this
                        }).add(point)
                    }
                }
            }
        }
    }

    fun autoExc() {
        GlobalScope.launch(Dispatchers.Default) {
            colorMaps.forEach {
                if (darkestKey != it.key && it.key.isChecked) {
                    markBoundaryInternal(it.value)
                    val result = obtainFeaturePoints(it.value)
                    Timber.d("${result.size} autoExc BaseImgProcess NWQ_ 2023/6/7");
                }
            }
        }
    }


    //标记每个点的位置,标记为内部点或者是边界点
    suspend fun markBoundaryInternal(originalList: MutableList<FeatureCoordinatePoint>) {
        originalList.forEach { point ->
            if (!point.hasJudeType()) {
                var isBoundary = false
                //left
                if (!isBoundary && point.x > 1) {
                    val leftPoint = featureArray[point.y][point.x - 1]
                    if (point.mFeaturePointKey != leftPoint.mFeaturePointKey) {
                        isBoundary = true
                        point.setBoundary()
                    }
                }

                //top
                if (!isBoundary && point.y > 1) {
                    val topPoint = featureArray[point.y - 1][point.x]
                    if (point.mFeaturePointKey != topPoint.mFeaturePointKey) {
                        isBoundary = true
                        point.setBoundary()
                    }
                }

                //right
                if (!isBoundary && point.x < with - 1) {
                    val rightPoint = featureArray[point.y][point.x + 1]
                    if (point.mFeaturePointKey != rightPoint.mFeaturePointKey) {
                        isBoundary = true
                        point.setBoundary()
                    }
                }

                //bottom
                if (!isBoundary && point.y < height - 1) {
                    val bottomPoint = featureArray[point.y + 1][point.x]
                    if (point.mFeaturePointKey != bottomPoint.mFeaturePointKey) {
                        isBoundary = true
                        point.setBoundary()
                    }
                }

                if (!isBoundary) {
                    point.setInternal()
                }
            }
        }

        Timber.d("总点:${originalList.size}  外部点:${originalList.filter { it.isBoundary() }.size}  内部点:${originalList.filter { it.isInternal() }.size}  markBoundaryInternal BaseImgProcess NWQ_ 2023/6/17");
    }


    //获取特征点，这里使用边界点
    fun obtainFeaturePoints(
        originalList: MutableList<FeatureCoordinatePoint>,
        pickingInterval: Int = picking_Interval
    ): List<FeatureCoordinatePoint> {
        originalList.forEach {
            it.hasContinuousSet = false
        }
        val list = mutableListOf<FeatureCoordinatePoint>()
        var startPoint = originalList.find { !it.hasContinuousSet }
        var i = 0
        while (startPoint != null) {
            Timber.d("第${i++}个块 obtainFeaturePoints BaseImgProcess NWQ_ 2023/6/7");
            startPoint.setStartPosition()
            val extremePoints = groupBlock(startPoint, pickingInterval)
            list.addAll(extremePoints)
            startPoint = originalList.find { !it.hasContinuousSet }
        }
        Timber.d("取得端点数1  ${list.size} obtainFeaturePoints BaseImgProcess NWQ_ 2023/6/17");
        filterExtremePoint(list, list)
        Timber.d("取得端点数2  ${list.size} obtainFeaturePoints BaseImgProcess NWQ_ 2023/6/17");

        //尽量选择内部点进行判定，这样可以减少一点范围误差
       val result = list.map { point ->
            var result: FeatureCoordinatePoint? = null
            if (result == null && point.x > 1) {
                val leftPoint = featureArray[point.y][point.x - 1]
                if (point.mFeaturePointKey == leftPoint.mFeaturePointKey && leftPoint.isInternal()) {
                    result = leftPoint
                }
            }
            if (result == null && point.y > 1) {
                val topPoint = featureArray[point.y - 1][point.x]
                if (point.mFeaturePointKey == topPoint.mFeaturePointKey && topPoint.isInternal()) {
                    result = topPoint
                }
            }
            if (result == null && point.x < with - 1) {
                val rightPoint = featureArray[point.y][point.x + 1]
                if (point.mFeaturePointKey == rightPoint.mFeaturePointKey && rightPoint.isInternal()) {
                    result = rightPoint
                }
            }

            if (result == null && point.y < height - 1) {
                val bottomPoint = featureArray[point.y + 1][point.x]
                if (point.mFeaturePointKey == bottomPoint.mFeaturePointKey && bottomPoint.isInternal()) {
                    result = bottomPoint
                }
            }
            result ?: point
        }

        result.forEach { it.isIdentificationKey = true }
        return result
    }

    //对相同的特征色值的 根据连接度对组进行分块
    private fun groupBlock(//这里是根据起始点进行眼神
        startPoint: FeatureCoordinatePoint,
        pickingInterval: Int = picking_Interval
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
                val result = dynamicSearchAround(it, blockList)
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

//        //过滤掉一些端点
//        filterExtremePoint(extremePoints, extremePoints)
//        filterExtremePoint(extremePoints, listOf(startPoint))
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
        originalList: MutableList<FeatureCoordinatePoint>, //需要过滤的点
        filterList: List<FeatureCoordinatePoint>     //过滤规则
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
    private fun dynamicSearchAround(
        point: FeatureCoordinatePoint,
        blockList: MutableList<FeatureCoordinatePoint>,
    ): List<FeatureCoordinatePoint> {
        val list = mutableListOf<FeatureCoordinatePoint>()
        if (point.x > 1) {
            val leftPoint = featureArray[point.y][point.x - 1]
            if (point.mFeaturePointKey == leftPoint.mFeaturePointKey) {
                if (leftPoint.continuePath(point)
                        ?.let { list.add(it) } != null && !blockList.contains(leftPoint)
                ) {
                    blockList.add(leftPoint)
                }
            }
        }

        //top
        if (point.y > 1) {
            val topPoint = featureArray[point.y - 1][point.x]
            if (point.mFeaturePointKey == topPoint.mFeaturePointKey) {
                if (topPoint.continuePath(point)
                        ?.let { list.add(it) } != null && !blockList.contains(topPoint)
                ) {
                    blockList.add(topPoint)
                }
            }
        }


        //right
        if (point.x < with - 1) {
            val rightPoint = featureArray[point.y][point.x + 1]
            if (point.mFeaturePointKey == rightPoint.mFeaturePointKey) {
                if (rightPoint.continuePath(point)
                        ?.let { list.add(it) } != null && !blockList.contains(rightPoint)
                ) {
                    blockList.add(rightPoint)
                }
            }
        }

        //bottom
        if (point.y < height - 1) {
            val bottomPoint = featureArray[point.y + 1][point.x]
            if (point.mFeaturePointKey == bottomPoint.mFeaturePointKey) {
                if (bottomPoint.continuePath(point)
                        ?.let { list.add(it) } != null && !blockList.contains(bottomPoint)
                ) {
                    blockList.add(bottomPoint)
                }
            }
        }

        if (point.x > 1 && point.y > 1) {
            val tPoint = featureArray[point.y - 1][point.x - 1]
            if (point.mFeaturePointKey == tPoint.mFeaturePointKey) {
                if (tPoint.continuePath(point)?.let { list.add(it) } != null &&
                    !blockList.contains(tPoint)
                ) {
                    blockList.add(tPoint)
                }
            }
        }

        if (point.x > 1 && point.y < height - 1) {
            val tPoint = featureArray[point.y + 1][point.x - 1]
            if (point.mFeaturePointKey == tPoint.mFeaturePointKey) {
                if (tPoint.continuePath(point)?.let { list.add(it) } != null && !blockList.contains(
                        tPoint
                    )
                ) {
                    blockList.add(tPoint)
                }
            }
        }

        if (point.x < with - 1 && point.y > 1) {
            val tPoint = featureArray[point.y - 1][point.x + 1]
            if (point.mFeaturePointKey == tPoint.mFeaturePointKey) {
                if (tPoint.continuePath(point)?.let { list.add(it) } != null && !blockList.contains(
                        tPoint
                    )
                ) {
                    blockList.add(tPoint)
                }
            }
        }

        if (point.x < with - 1 && point.y < height - 1) {
            val tPoint = featureArray[point.y + 1][point.x + 1]
            if (point.mFeaturePointKey == tPoint.mFeaturePointKey) {
                if (tPoint.continuePath(point)?.let { list.add(it) } != null && !blockList.contains(
                        tPoint
                    )
                ) {
                    blockList.add(tPoint)
                }
            }
        }
        return list
    }


    /**
     * 手动设置特征值
     */
    fun setBrightestIntFeature(data: FeaturePointKey) {
        if (colorMaps.contains(brightestKey)) {
            colorMaps.remove(brightestKey)
        }
        brightestKey.isKeyMember = false
        brightestKey = data
        brightestKey.isKeyMember = true
        colorMaps.put(brightestKey, mutableListOf())
    }

    fun setDifferenceFeature(data: FeaturePointKey) {
        if (colorMaps.contains(differenceKey)) {
            colorMaps.remove(differenceKey)
        }
        differenceKey.isKeyMember = false
        differenceKey = data
        differenceKey.isKeyMember = true
        colorMaps.put(differenceKey, mutableListOf())
    }

    fun setDarkestFeature(data: FeaturePointKey) {
        if (colorMaps.contains(darkestKey)) {
            colorMaps.remove(darkestKey)
        }
        darkestKey.isKeyMember = false
        darkestKey = data
        darkestKey.isKeyMember = true
        colorMaps.put(darkestKey, mutableListOf())
    }


    //多点选择平均色
    fun addFeatureKey(vararg colorInt: Int) {
        var redTotal = 0
        var greenTotal = 0
        var blueTotal = 0
        colorInt.forEach {
            redTotal += it.red
            greenTotal += it.green
            blueTotal += it.blue
        }
        val featurePointKey = FeaturePointKey(
            redTotal / colorInt.size,
            greenTotal / colorInt.size,
            blueTotal / colorInt.size
        )

        colorMaps[featurePointKey] = mutableListOf()
        featureKeyList.add(featurePointKey)
        GlobalScope.launch(Dispatchers.Default) {
            groupFeatureCoordinatePoint(listOf(featurePointKey))
        }
    }

    //添加附近选中的特征点
    fun addFeaturePoint(x: Int, y: Int) {
        CoordinatePoint(x, y).divergentPoint(3).forEach {
            featureArray[it.yI][it.xI].let { point ->
                var result: FeatureCoordinatePoint? = null
                if (point.mFeaturePointKey?.isChecked == true) {
                    if (result == null && point.x > 0) {
                        val leftPoint = featureArray[point.y][point.x - 1]
                        if (point.mFeaturePointKey == leftPoint.mFeaturePointKey && leftPoint.isInternal()) {
                            result = leftPoint
                        }
                    }
                    if (result == null && point.y > 0) {
                        val topPoint = featureArray[point.y - 1][point.x]
                        if (point.mFeaturePointKey == topPoint.mFeaturePointKey && topPoint.isInternal()) {
                            result = topPoint
                        }
                    }
                    if (result == null && point.x < with) {
                        val rightPoint = featureArray[point.y][point.x + 1]
                        if (point.mFeaturePointKey == rightPoint.mFeaturePointKey && rightPoint.isInternal()) {
                            result = rightPoint
                        }
                    }

                    if (result == null && point.y < height) {
                        val bottomPoint = featureArray[point.y + 1][point.x]
                        if (point.mFeaturePointKey == bottomPoint.mFeaturePointKey && bottomPoint.isInternal()) {
                            result = bottomPoint
                        }
                    }
                }
                if (result != null) {
                    result.isIdentificationKey = true
                    return
                }
            }
        }
    }

    //删除附件选中的特征点
    fun deleteFeaturePoint(x: Int, y: Int) {
        CoordinatePoint(x, y).divergentPoint(3).forEach {
            featureArray[it.yI][it.xI].let {
                if (it.mFeaturePointKey?.isChecked == true && it.isIdentificationKey) {
                    it.isIdentificationKey = false
                    return
                }
            }
        }
    }

    fun deleteSelectFeatureKey() {
        val iterator = featureKeyList.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item.isChecked) {
                iterator.remove()
            }
        }
    }

    fun getPreview(showFeature: Boolean, showBoundary: Boolean): List<FeatureCoordinatePoint> {
        val pointList = mutableListOf<FeatureCoordinatePoint>()
        featureKeyList.forEach {
            if (it.isChecked) {
                colorMaps[it]?.forEach {
                    if (showFeature && it.isIdentificationKey) {
                        pointList.add(it)
                    } else if (showBoundary && it.isBoundary()) {
                        pointList.add(it)
                    }
                }
            }
        }
        Timber.d("预览点数 ${pointList.size} getPreview BaseImgProcess NWQ_ 2023/6/17");
        return pointList
    }


}