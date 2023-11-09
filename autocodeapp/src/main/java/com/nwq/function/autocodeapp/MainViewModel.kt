package com.nwq.function.autocodeapp

import android.graphics.Bitmap
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.expand.runOnIO
import com.android.schedule.corelibrary.expand.runOnUI
import com.android.schedule.corelibrary.utils.ToastHelper
import com.luck.picture.lib.utils.ToastUtils
import com.nwq.function.autocodeapp.data.FeatureCoordinatePoint
import com.nwq.function.autocodeapp.data.FeaturePointBlock
import com.nwq.function.autocodeapp.data.FeaturePointKey
import kotlinx.coroutines.launch
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
    var featureKeyLiveData = MutableLiveData<List<FeaturePointKey>>(listOf())
    var colorMaps = mutableMapOf<FeaturePointKey, MutableList<FeatureCoordinatePoint>>()
    private lateinit var featureArray: Array<Array<FeatureCoordinatePoint>>
    private var brightestKey: FeaturePointKey = FeaturePointKey(0, 0, 0)
    private var differenceKey: FeaturePointKey = FeaturePointKey(0, 0, 0)
    private var darkestKey: FeaturePointKey = FeaturePointKey(255, 255, 255)



    //选择区域
    fun preprocessData() {
        val are = coordinateArea ?: return
        val bitmap = srcBitmap ?: return

        viewModelScope.launch {
            runOnIO {
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
                featureKeyLiveData.postValue(featureKeyList)
                ToastHelper.showLongToastSafe("数据预处理完成")
            }
        }
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
        featureKeyLiveData.postValue(featureKeyList)
    }


    fun setDarkestFeature() {
        darkestKey.isKeyMember = false
        featureKeyList.find { it.isChecked }?.let {
            darkestKey = it
            darkestKey.isKeyMember = true
        }
    }

    //生成普通图片特征值
    fun autoCodeNormalImg() {
        viewModelScope.launch {
            colorMaps.forEach { it ->
                if (it.key.isChecked) {
                    markBoundaryInternal(it.value)
                    val list = getPointBlock(it.value, 5, false)
                    obtainFeatureImg(list.sortedByDescending { it.perimeter })
                    ToastHelper.showLongToastSafe("自动处理图片完成")
                }
            }
        }
    }


    private fun addBackground(result: MutableList<FeatureCoordinatePoint>) {
        val backList = mutableListOf<FeatureCoordinatePoint>()
        if (result.size > 1) {
            for (i in result.indices step result.size / 2) {
                result.getOrNull(i)?.let { point ->
                    val list = getPointSurround(point, 5, true, false, true)
                    list.find { it.mFeaturePointKey == darkestKey }?.let { darkPoint ->
                        darkPoint.isIdentificationKey = true
                        darkPoint.mDirectorPointKey = point.mFeaturePointKey
                        darkPoint.mDirectorPoint = point
                        backList.add(darkPoint)
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
                    backList.add(darkPoint)
                }
            }
        }
        result.addAll(backList)
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

        //这里标记内部点的层数
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


    //这里根据颜色是否联通进行分块
    private fun getPointBlock(
        allList: MutableList<FeatureCoordinatePoint>, minStep: Int = 5, hasInternal: Boolean = false
    ): MutableList<FeaturePointBlock> {
        val originalList = allList.filter { it.isBoundary() }

        val result = mutableListOf<FeaturePointBlock>()
        //将所有位置置为空
        allList.forEach {
            it.hasContinuousSet = false
            it.hasFindRound = false
            it.isAdd = false
        }


        var startPoint = originalList.find { !it.hasContinuousSet }//&& it.isBoundary()

        var i = 0
        while (startPoint != null) {
            startPoint.setStartPosition()

            groupBlock(startPoint, i, minStep, hasInternal)?.let {
                result.add(it)
            }
            startPoint = originalList.find { !it.hasContinuousSet }//&& it.isBoundary()
            i++
        }
        return result
    }


    //也是对点进行分类
    private fun groupBlock(
        startPoint: FeatureCoordinatePoint,//开始的起点
        sortNumber: Int,//排序的序列号
        minPerimeter: Int = 5,//最小路径 ，如果边界小于这个则不进行添加
        includeInternal: Boolean = false,//是否包含内部点
    ): FeaturePointBlock? {
        //这里先根据边界点进行分界限 添加外部点
        val boundaryList = mutableListOf<FeatureCoordinatePoint>()
        boundaryList.add(startPoint)
        val oldList = mutableListOf(startPoint)
        val newList = mutableListOf<FeatureCoordinatePoint>()
        var perimeter = 0
        while (!oldList.isEmpty()) {
            perimeter++
            newList.clear()
            oldList.forEach { point ->
                getPointSurround(point, 1, true, false).forEach { nextPoint ->
                    if (nextPoint.mFeaturePointKey == point.mFeaturePointKey) {
                        nextPoint.continuePath(point)?.apply {
                            newList.add(nextPoint)
                            boundaryList.add(nextPoint)
                        }
                    }
                }
            }
            oldList.clear()
            oldList.addAll(newList)
        }

        //如果边框过于小这个点就没有什么意义
        if (perimeter > minPerimeter) {
            if (includeInternal) {
                var depth = 0  //这个用于找深度最高的点

                oldList.clear()
                oldList.addAll(boundaryList)
                val internalList = mutableListOf<FeatureCoordinatePoint>()


                while (!oldList.isEmpty()) {
                    depth++
                    newList.clear()
                    oldList.forEach { point ->
                        getPointSurround(point, 1, true, false).forEach { nextPoint ->
                            if (nextPoint.mFeaturePointKey == point.mFeaturePointKey) {
                                nextPoint.continuePathInternal(point)?.apply {
                                    newList.add(nextPoint)
                                    internalList.add(nextPoint)
                                }
                            }
                        }
                    }

                    oldList.clear()
                    oldList.addAll(newList)
                }

                boundaryList.forEach {
                    it.blockNumber = sortNumber
                }

                internalList.forEach {
                    it.blockNumber = sortNumber
                }

                return FeaturePointBlock(boundaryList, perimeter, internalList, depth)
            } else {
                boundaryList.forEach {
                    it.blockNumber = sortNumber
                }
                return FeaturePointBlock(boundaryList, perimeter)
            }
        } else {
            return null
        }
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


    /**
     * 这里提取特征点
     * 这里默认取五个点
     */
    private fun obtainFeatureImg(list: List<FeaturePointBlock>): MutableList<FeatureCoordinatePoint> {
        val keyPointList = mutableListOf<FeatureCoordinatePoint>()

        list.forEach {
            obtainBoundaryPoint(it, 5, keyPointList)
        }
        addBackground(keyPointList)
        return keyPointList
    }

    //取外部点
    private fun obtainBoundaryPoint(
        block: FeaturePointBlock,
        number: Int,
        keyPointList: MutableList<FeatureCoordinatePoint>,
    ) {
        val times = (number - 1) / 2

        val result = mutableListOf<FeatureCoordinatePoint>()
        //先添加首点
        block.boundaryList.find { it.sequenceNumber == 0 }?.let {
            result.add(it)
        }


        val distance = block.perimeter / times
        //这里添加中间点
        if (distance >= 5) {
            for (i in distance..block.perimeter - distance step distance) {
                block.boundaryList.filter { it.sequenceNumber == i }.let {
                    result.addAll(it)
                }
            }
        }

        //最后添加尾点
        block.boundaryList.find { it.sequenceNumber == block.perimeter }
            ?: block.boundaryList.find { it.sequenceNumber == block.perimeter - 1 }?.let {
                result.add(it)
            }


        //这里添加深度最高的点，是为了考虑透明度
        result.forEach { point ->
            if (!point.isAdd) {
                val list = getPointSurround(
                    point, 3, true, true
                ).filter { it.mFeaturePointKey == point.mFeaturePointKey }
                    .sortedByDescending { it.positionType }
                list.getOrNull(0)?.let {
                    keyPointList.add(it)
                }
                list.forEach { it.isAdd = true }
            }
        }

    }

    //取内部点
    private fun obtainInternalPoint(
        block: FeaturePointBlock, keyPointList: MutableList<FeatureCoordinatePoint>
    ) {

        block.internalList?.sortedByDescending { it.positionType }?.getOrNull(0)?.let {
            keyPointList.add(it)
        }

    }

}