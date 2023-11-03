package com.nwq.function.autocodeapp

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.android.schedule.corelibrary.area.CoordinateArea
import com.nwq.function.autocodeapp.data.FeatureCoordinatePoint
import com.nwq.function.autocodeapp.data.FeaturePointKey
import kotlin.math.abs


class MainViewModel : ViewModel() {

    //原图
    var srcBitmap: Bitmap? = null

    //选择区域
    var coordinateArea: CoordinateArea? = null


    /**
     * 这里对数据进行最简单的基本处理
     */
    private val pointNumberThreshold = 20 //如果特征值的点数过少则无视掉
    val featureKeyList = mutableListOf<FeaturePointKey>()
    var colorMaps = mutableMapOf<FeaturePointKey, MutableList<FeatureCoordinatePoint>>()
    private lateinit var featureArray: Array<Array<FeatureCoordinatePoint>>
    private var brightestKey: FeaturePointKey = FeaturePointKey(0, 0, 0)
    private var differenceKey: FeaturePointKey = FeaturePointKey(0, 0, 0)
    private var darkestKey: FeaturePointKey = FeaturePointKey(255, 255, 255)

    //选择区域
    suspend fun preprocessData() {
        val are = coordinateArea ?: return
        val bitmap = srcBitmap ?: return
        val dataList = mutableListOf<Array<FeatureCoordinatePoint>>()
        var data = mutableListOf<FeatureCoordinatePoint>()

        are.getBitmapPixList(bitmap).forEachIndexed { y, arry ->
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

    private fun CoordinateArea.getBitmapPixList(bitmap: Bitmap): MutableList<IntArray> {
        val list = mutableListOf<IntArray>()
        for (i in 0 until height) {
            val pixels = IntArray(width)
            bitmap.getPixels(
                pixels, 0, width, x, y + i, width, 1
            )
            list.add(pixels)
        }
        return list
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
        colorMaps = colorMaps.filter {
            it.key.pointCount = it.value.size
            it.value.size > pointNumberThreshold
        }.toMutableMap()
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


    //对特征值进行合并
    fun mergeKey() {
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
                it.isChecked = false
            }
        }
    }


    fun setDarkestFeature() {
        darkestKey.isKeyMember = false
        featureKeyList.find { it.isChecked }?.let {
            darkestKey = it
            darkestKey.isKeyMember = true
        }
    }

    //生成普通图片特征值
    suspend fun autoCodeNormalImg() {
//        colorMaps.forEach { it ->
//            if (it.key.isChecked) {
//                markBoundaryInternal(it.value)
//                val result = obtainFeaturePoints(
//                    it.value,
//                    if (takePointCount > 0) takePointCount else TAKE_POINT_COUNT
//                )
//                if (useBackground) addBackground(result)
//            }
//        }
//
    }


    private fun addBackground(result: List<FeatureCoordinatePoint>) {
        if (result.size > 1) {
            for (i in result.indices step result.size / 2) {
                result.getOrNull(i)?.let { point ->
                    val list = getPointSurround(point, 5, true, false, true)
                    list.find { it.mFeaturePointKey == darkestKey }?.let { darkPoint ->
                        darkPoint.isIdentificationKey = true
                        darkPoint.mDirectorPointKey = point.mFeaturePointKey
                        darkPoint.mDirectorPoint = point
                    }
                }
            }
        } else {
            result.getOrNull(0)?.let { point ->
                val list = getPointSurround(point, 5, true, false, true)
                list.find { it.mFeaturePointKey == darkestKey }?.let { darkPoint ->
                    darkPoint.isIdentificationKey = true
                    darkPoint.mDirectorPointKey = point.mFeaturePointKey
                    darkPoint.mDirectorPoint = point
                }
            }
        }
    }


    //标记每个点的位置,标记为内部点或者是边界点
    suspend fun markBoundaryInternal(
        originalList: MutableList<FeatureCoordinatePoint>
    ) {
        //先标记出来外部点
        originalList.forEach { point ->
            if (getPointSurround(point, 1, false, false).find {
                    point.mFeaturePointKey != it.mFeaturePointKey
                } != null) {
                point.setBoundary()
            } else {
                point.setNone()
            }
        }

        //这里
        var number = FeatureCoordinatePoint.BOUNDARY_TYPE
        var list = originalList.filter { it.positionType == FeatureCoordinatePoint.BOUNDARY_TYPE }
        number++
        while (list.isNotEmpty()) {
            list.forEach { point ->
                getPointSurround(point, 1, false, false).forEach {
                    if (!it.hasJudeType()) {
                        it.setInternal(number)
                    }
                }
            }
            list = originalList.filter { it.positionType == number }
            number++
        }
    }


    //获取特征点，这里使用边界点
    private fun obtainFeaturePoints(
        allList: MutableList<FeatureCoordinatePoint>, takePointCount: Int
    ): List<FeatureCoordinatePoint> {

        val originalList = allList.filter { it.isBoundary() }

        //将所有位置置为空
        originalList.forEach {
            it.hasContinuousSet = false
            it.hasFindRound = false
            it.isAdd = false
        }

        val list = mutableListOf<FeatureCoordinatePoint>()
        var startPoint = originalList.find { !it.hasContinuousSet }//&& it.isBoundary()

        var i = 0
        while (startPoint != null) {
            startPoint.setStartPosition()
            val extremePoints = groupBlock(startPoint, i, originalList.size, takePointCount)
            list.addAll(extremePoints)
            startPoint = originalList.find { !it.hasContinuousSet }//&& it.isBoundary()
        }

        //尽量选择内部点进行判定，这样可以减少一点范围误差
        val result = list.map { point ->
            getPointSurround(
                point, 2, true, true
            ).filter { it.mFeaturePointKey == point.mFeaturePointKey }//过滤为同一个类型的图
                .sortedByDescending { it.positionType }//这里设置深度最高的点 避免边界点的透明度
                .get(0)
        }
        result.forEach { it.isIdentificationKey = true }
        return result
    }


    //这里根据颜色是否联通进行分块
    private fun getPointBlock(
        allList: MutableList<FeatureCoordinatePoint>, minStep: Int = 5, hasInternal: Boolean = false
    ) {


        val originalList = allList.filter { it.isBoundary() }

        //将所有位置置为空
        allList.forEach {
            it.hasContinuousSet = false
            it.hasFindRound = false
            it.isAdd = false
        }


        val list = mutableListOf<FeatureCoordinatePoint>()
        var startPoint = originalList.find { !it.hasContinuousSet }//&& it.isBoundary()

        var i = 0
        while (startPoint != null) {
            startPoint.setStartPosition()


            val extremePoints = groupBlock(startPoint, i, originalList.size, minStep)
            list.addAll(extremePoints)
            startPoint = originalList.find { !it.hasContinuousSet }//&& it.isBoundary()
            i++
        }
    }

    private fun groupBlock(
        startPoint: FeatureCoordinatePoint,
        sortNumber: Int,
        minStep: Int = 5,
        includeInternal: Boolean = false,
    ) {
        val result = mutableListOf<List<FeatureCoordinatePoint>>()

        //这里先根据边界点进行分界限
        val blockList = mutableListOf<FeatureCoordinatePoint>()
        blockList.add(startPoint)
        val oldList = mutableListOf(startPoint)
        val newList = mutableListOf<FeatureCoordinatePoint>()
        var step = 0
        while (!oldList.isEmpty()) {
            step++
            newList.clear()
            oldList.forEach { point ->
                getPointSurround(point, 1, true, false).forEach { nextPoint ->
                    if (nextPoint.mFeaturePointKey == point.mFeaturePointKey) {
                        nextPoint.continuePath(point)?.apply {
                            newList.add(nextPoint)
                            blockList.add(nextPoint)
                        }
                    }
                }
            }
            oldList.clear()
            oldList.addAll(newList)
        }

        //如果边框过于小这个点就没有什么意义
        if (step > minStep) {

            if (includeInternal) {
                oldList.clear()
                oldList.addAll(blockList)
                while (!oldList.isEmpty()) {
                    oldList.forEach { point ->
                        getPointSurround(point, 1, true, false).forEach { nextPoint ->
                            if (nextPoint.mFeaturePointKey == point.mFeaturePointKey) {
                                nextPoint.continuePathInternal(point)?.apply {
                                    newList.add(nextPoint)
                                    blockList.add(nextPoint)
                                }
                            }
                        }
                    }
                }

                blockList.forEach {
                    it.blockNumber = sortNumber
                }

            } else {

                blockList.forEach {
                    it.blockNumber = sortNumber
                }
            }
        }


    }


    //对相同的特征色值的 根据连接度对组进行分块
    private fun groupBlock(
//这里是根据起始点进行眼神
        startPoint: FeatureCoordinatePoint,
        sortNumber: Int,
        allSize: Int, //这个是已经作为关键点添加了的
        takePoints: Int,
        minStep: Int = 5,
    ): List<FeatureCoordinatePoint> {

        //当前的一个连续的块
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
                getPointSurround(point, 1, true, false).forEach { nextPoint ->
                    nextPoint.continuePath(point)?.apply {
                        newList.add(nextPoint)
                        blockList.add(nextPoint)
                    }
                }
            }
            oldList.clear()
            oldList.addAll(newList)
        }


        val temp = (allSize * step) / (takePoints * blockList.size)
        val pickingInterval = if (temp > 1) {
            if (temp > step) {
                step - 1
            } else {
                temp
            }
        } else {
            1
        }

        // 单独的孤点这里不做处理
        if (step >= minStep) for (i in 0..step step pickingInterval) {
            blockList.filter { it.sequenceNumber == i }.forEach {
                if (!it.isAdd) {
                    extremePoints.add(it)
                    it.isAdd = true
                    getPointSurround(
                        it,
                        (pickingInterval / 2 + 1).coerceAtMost(5),
                        true,
                        false,
                    ).forEach { nextPoint ->
                        if (it.mFeaturePointKey == nextPoint.mFeaturePointKey && nextPoint.hasContinuousSet && (abs(
                                nextPoint.x - it.x
                            ) + abs(nextPoint.y - it.y) < 6)
                        ) {
                            nextPoint.isAdd = true
                        }
                        false
                    }
                }
            }
        }
        extremePoints.forEach {
            it.blockNumber = sortNumber
        }

        return extremePoints
    }


    //下面这个是都要用的方法
    private fun getPointSurround(
        point: FeatureCoordinatePoint, range: Int, allDirection: Boolean,//这个是只寻找找四周还是寻找全部
        includeSelf: Boolean = false,//是否包含自己
        sortDistance: Boolean = false//是否进行排序
    ): List<FeatureCoordinatePoint> {
        val aree = coordinateArea ?: return listOf()
        val list = mutableListOf<FeatureCoordinatePoint>()
        var startX = point.x - range
        var endX = point.x + range
        var startY = point.y - range
        var endY = point.y + range

        if (startX < 0) {
            startX = 0
        }
        if (endX > aree.width - 1) {
            endX = aree.width - 1
        }
        if (startY < 0) {
            startY = 0
        }
        if (endY > aree.height - 1) {
            endY = aree.height - 1
        }

        if (allDirection) {
            for (iy in startY..endY) {
                for (ix in startX..endX) {
                    val p = featureArray.getOrNull(iy)?.getOrNull(ix)
                    if (p != point || includeSelf) {
                        p?.let { list.add(it) }
                    }
                }
            }
        } else {
            for (iy in startY..endY) {
                val p = featureArray.getOrNull(iy)?.getOrNull(point.x)
                if (p != point || includeSelf) {
                    p?.let { list.add(it) }
                }
            }
            for (ix in startX..endX) {
                val p = featureArray.getOrNull(point.y)?.getOrNull(ix)
                if (p != point || includeSelf) {
                    p?.let { list.add(it) }
                }
            }
        }
        return if (sortDistance) list.sortedBy { abs(it.x - point.x) + abs(it.y - point.y) }
        else list
    }

}