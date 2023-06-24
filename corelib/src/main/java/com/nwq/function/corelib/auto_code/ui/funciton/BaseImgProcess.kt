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
    private val picking_Interval = 10 //这里是间隔多少个点进行一次取值
    private val minPointInterval = 5 //最小取点间隔
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
            var newKey = FeaturePointKey(colorInt)
            point.mFeaturePointKey = newKey
            val list = mutableListOf<FeatureCoordinatePoint>()
            list.add(point)
            featureKeyList.add(newKey)
            colorMaps[newKey] = list
        }
    }


    private fun organizeColorMaps() {
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
        brightestKey.isChecked = true
        differenceKey.isKeyMember = true
        differenceKey.isChecked = true
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

    fun autoExc(useBackground: Boolean) {
        GlobalScope.launch(Dispatchers.Default) {
            colorMaps.forEach {
                if (darkestKey != it.key && it.key.isChecked) {
                    markBoundaryInternal(it.value, true)
                    val result = obtainFeaturePoints(it.value)
                    if (useBackground) addBackground(result)
                    Timber.d("${result.size} autoExc BaseImgProcess NWQ_ 2023/6/7");
                }
            }
        }
    }

    fun addBackground(result: List<FeatureCoordinatePoint>) {
        result.forEach { point ->
            Timber.d("进行背景点添加  addBackground BaseImgProcess NWQ_ 2023/6/23");
            getPointSurround(point, 3, true, false) { nextPoint ->
                if (nextPoint.mFeaturePointKey == darkestKey) {
                    nextPoint.isIdentificationKey = true
                    nextPoint.mDirectorPointKey = point.mFeaturePointKey
                    Timber.d("添加背景点数  addBackground BaseImgProcess NWQ_ 2023/6/23");
                    true
                } else {
                    false
                }
            }
        }

    }


    //标记每个点的位置,标记为内部点或者是边界点
    suspend fun markBoundaryInternal(
        originalList: MutableList<FeatureCoordinatePoint>, redo: Boolean = true
    ) {
        originalList.forEach { point ->
            if (redo || !point.hasJudeType()) {
                var isBoundary = false
                //left
                getPointSurround(point, 1, false, false) {
                    if (point.mFeaturePointKey != it.mFeaturePointKey) {
                        isBoundary = true
                        point.setBoundary()
                        true
                    } else {
                        false
                    }
                }
                if (!isBoundary) {
                    point.setInternal()
                }
            }
        }

        Timber.d("总点:${originalList.size}  外部点:${originalList.filter { it.isBoundary() }.size}  内部点:${originalList.filter { it.isInternal() }.size}  BaseImgProcess NWQ_ 2023/6/17");
    }


    private fun getPointSurround(
        point: FeatureCoordinatePoint, range: Int, allDirection: Boolean,//这个是只寻找找四周还是寻找全部
        includeSelf: Boolean = false, next: (p: FeatureCoordinatePoint) -> Boolean
    ) {

        var startX = point.x - range
        var endX = point.x + range
        var startY = point.y - range
        var endY = point.y + range

        if (startX < 0) {
            startX = 0
        }
        if (endX > with - 1) {
            endX = with - 1
        }
        if (startY < 0) {
            startY = 0
        }
        if (endY > height - 1) {
            endY = height - 1
        }

        if (allDirection) {
            for (iy in startY..endY) {
                for (ix in startX..endX) {
                    val p = if (::featureArray.isInitialized) {
                        featureArray.getOrNull(iy)?.getOrNull(ix) ?: FeatureCoordinatePoint(
                            ix, iy, imgArray[iy][ix]
                        )
                    } else {
                        FeatureCoordinatePoint(
                            ix, iy, imgArray[iy][ix]
                        )
                    }
                    if (p != point || includeSelf) {
                        if (next.invoke(p)) {
                            return
                        }
                    }
                }
            }
        } else {
            for (iy in startY..endY) {
                val p = if (::featureArray.isInitialized) {
                    featureArray.getOrNull(iy)?.getOrNull(point.x) ?: FeatureCoordinatePoint(
                        point.x, iy, imgArray[iy][point.x]
                    )
                } else {
                    FeatureCoordinatePoint(
                        point.x, iy, imgArray[iy][point.x]
                    )
                }
                if (p != point || includeSelf) {
                    if (next.invoke(p)) {
                        return
                    }
                }
            }
            for (ix in startX..endX) {
                val p = if (::featureArray.isInitialized) {
                    featureArray.getOrNull(point.y)?.getOrNull(ix) ?: FeatureCoordinatePoint(
                        ix, point.y, imgArray[point.y][ix]
                    )
                } else {
                    FeatureCoordinatePoint(
                        ix, point.y, imgArray[point.y][ix]
                    )
                }
                if (p != point || includeSelf) {
                    if (next.invoke(p)) {
                        return
                    }
                }
            }
        }
    }


    //获取特征点，这里使用边界点
    fun obtainFeaturePoints(
        originalList: MutableList<FeatureCoordinatePoint>, pickingInterval: Int = picking_Interval
    ): List<FeatureCoordinatePoint> {
        originalList.forEach {
            it.hasContinuousSet = false
            it.hasFindRound = false
            it.isAdd = false
        }

        val list = mutableListOf<FeatureCoordinatePoint>()
        var startPoint = originalList.find { !it.hasContinuousSet && it.isBoundary() }

        var i = 0
        while (startPoint != null) {
            Timber.d("第${i++}个块 obtainFeaturePoints BaseImgProcess NWQ_ 2023/6/7");
            startPoint.setStartPosition()
            val extremePoints = groupBlock(startPoint, list, pickingInterval)
            list.addAll(extremePoints)
            startPoint = originalList.find { !it.hasContinuousSet && it.isBoundary() }
        }

//      这个方法要进行优化
        Timber.d("截取特征数  ${list.size}  BaseImgProcess NWQ_ 2023/6/17");

        //尽量选择内部点进行判定，这样可以减少一点范围误差
        val result = list.map { point ->
            var result = point
            getPointSurround(point, 1, true, true) { nextPoint ->
                if (nextPoint.isInternal()) {
                    result = nextPoint
                    true
                } else {
                    false
                }
            }
            result
        }
        result.forEach { it.isIdentificationKey = true }
        return result
    }

    //对相同的特征色值的 根据连接度对组进行分块
    private fun groupBlock(//这里是根据起始点进行眼神
        startPoint: FeatureCoordinatePoint,
        keyList: List<FeatureCoordinatePoint>,
        pickingInterval: Int = picking_Interval
    ): List<FeatureCoordinatePoint> {

        val blockList = mutableListOf<FeatureCoordinatePoint>()
        blockList.add(startPoint)

        val oldList = mutableListOf(startPoint)
        val newList = mutableListOf<FeatureCoordinatePoint>()
        val extremePoints = mutableListOf<FeatureCoordinatePoint>()//端点，就是找不延续的点了

        var step = 0
        while (!oldList.isEmpty()) {
            step++
            newList.clear()
            oldList.forEach { point ->
                getPointSurround(point, 1, true, false) { nextPoint ->
                    if (nextPoint.continuePath(point)
                            ?.let { newList.add(it) } != null && !blockList.contains(nextPoint)
                    ) {
                        blockList.add(nextPoint)
                    }
                    false
                }
            }
            oldList.clear()
            oldList.addAll(newList)
        }


        for (i in 0..step step pickingInterval) {
            blockList.filter { it.sequenceNumber == i }.let { stepList ->
                var startPoint = stepList.find { !it.isAdd }
                while (startPoint != null) {
                    //这里防止单快过多添加
                    if (keyList.find {
                            (Math.abs(startPoint!!.x - it.x) < minPointInterval && Math.abs(
                                startPoint!!.y - it.y
                            ) < minPointInterval)
                        } == null) {
                        getPointSurround(startPoint, 4, true, true) { nextPoint ->
                            if (startPoint!!.mFeaturePointKey == nextPoint.mFeaturePointKey) {
                                nextPoint.isAdd = true
                            }
                            false
                        }
                        extremePoints.add(startPoint)
                    }
//                    stepList.forEach { item ->
//                        if ((Math.abs(startPoint!!.x - item.x) < minPointInterval && Math.abs(
//                                startPoint!!.y - item.y
//                            ) < minPointInterval)
//                        ) {
//                            item.isAdd = true
//                        }
//                    }
                    startPoint = stepList.find { !it.isAdd }
                }
                Timber.d(" step:$i size${stepList.size} extremePoints${extremePoints.size} groupBlock BaseImgProcess NWQ_ 2023/6/22");
            }
        }
        return extremePoints
    }


    private fun needAdd(
        item: FeatureCoordinatePoint, filterList: List<FeatureCoordinatePoint>
    ): Boolean {
        return filterList.find {
            (it.x != item.x || it.y != item.y) //保证不是同一个点
                    && (Math.abs(it.x - item.x) < minPointInterval && Math.abs(it.x - item.x) < minPointInterval)//发现二点过近
        } == null
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

    fun setDarkestFeature() {
        darkestKey.isKeyMember = false
        featureKeyList.find { it.isChecked }?.let {
            darkestKey = it
            darkestKey.isKeyMember = true
        }
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
            redTotal / colorInt.size, greenTotal / colorInt.size, blueTotal / colorInt.size
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

    fun getPreview(
        showFeature: Boolean, showBoundary: Boolean, useBackground: Boolean
    ): List<FeatureCoordinatePoint> {
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
        if (useBackground && darkestKey.isChecked == false) {
            colorMaps[darkestKey]?.forEach {
                if (showFeature && it.isIdentificationKey) {
                    pointList.add(it)
                }
            }
        }
        Timber.d("预览点数 ${pointList.size} getPreview BaseImgProcess NWQ_ 2023/6/17");
        return pointList
    }


    fun getDatumPoint(datumPointSize: Int = 1): List<FeatureCoordinatePoint>? {
        var list = colorMaps[differenceKey]?.filter { it.isIdentificationKey }
        if (list.isNullOrEmpty()) {
            list = colorMaps[brightestKey]?.filter { it.isIdentificationKey }
        }
        if (list.isNullOrEmpty()) return null
        val resultList = list.sortedBy { it.x + it.y }
        if (resultList.size > datumPointSize) {
            return resultList.subList(0, datumPointSize - 1)
        } else {
            return resultList
        }
    }

    fun getKeyPoint(): List<FeatureCoordinatePoint> {
        val result = mutableListOf<FeatureCoordinatePoint>()

        featureKeyList.filter { it.isChecked }.forEach { baseKey ->
            colorMaps[baseKey]?.forEach { point ->
                if (point.isIdentificationKey) result.add(point)
            }
        }
        if (darkestKey.isChecked == false) {
            colorMaps[darkestKey]?.forEach { point ->
                if (point.isIdentificationKey) result.add(point)
            }
        }
        return result
    }


    fun mergeKey() {//对特征值进行合并
        val needList = featureKeyList.filter {
            it.isChecked
        }
        if (needList.size <= 1) {
            return
        }
        val baseKey = needList.find { it.isKeyMember } ?: needList[0]
        val baseList = colorMaps[baseKey]
        needList.forEach {
            if (it != baseKey) {
                colorMaps[it]?.let {
                    it.forEach { item ->
                        item.mOriginalPointKey = item.mFeaturePointKey
                        item.mFeaturePointKey = baseKey
                    }
                    baseList?.addAll(it)
                }
                colorMaps.remove(it)
                featureKeyList.remove(it)
            }
        }
    }


}