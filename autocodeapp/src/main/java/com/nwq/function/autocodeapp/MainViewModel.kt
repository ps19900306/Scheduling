package com.nwq.function.autocodeapp

import android.content.ClipData
import android.content.ClipboardManager
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinateLine
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.expand.runOnUI
import com.android.schedule.corelibrary.img.color_rule.ColorRuleRatioImpl
import com.android.schedule.corelibrary.img.img_rule.ImgTask
import com.android.schedule.corelibrary.img.img_rule.ImgTaskImpl1
import com.android.schedule.corelibrary.img.point_rule.IPR
import com.android.schedule.corelibrary.img.point_rule.PointRule
import com.android.schedule.corelibrary.utils.L
import com.nwq.function.autocodeapp.data.FeatureCoordinatePoint
import com.nwq.function.autocodeapp.data.FeaturePointBlock
import com.nwq.function.autocodeapp.data.FeaturePointKey
import com.nwq.function.autocodeapp.function.PreviewImageView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.StringBuilder
import kotlin.math.abs


class MainViewModel : ViewModel() {

    val TAG = "MainViewModel"

    //原图
    var srcBitmap: Bitmap? = null

    //选择区域
    var coordinateArea: CoordinateArea? = null

    //选择区域
    var findArea: CoordinateArea? = null


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

    //这个如果图标变小需要调整位置
    private val minStep = 4
    private val obtainDistance = 4
    lateinit var manager: ClipboardManager

    //选择区域
    fun preprocessData() {
        featureKeyList.clear()
        colorMaps.clear()


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
        featureKeyLiveData.postValue(featureKeyList)
        // ToastHelper.showLongToastSafe("数据预处理完成")
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
        //不再自动筛选颜色
//        colorMaps.forEach {
//            brightestKey = brightestKey.getBrightest(it.key)
//            differenceKey = differenceKey.getDifference(it.key)
//            darkestKey = darkestKey.getDarkest(it.key)
//        }
//        brightestKey.isKeyMember = true
//        brightestKey.isChecked = true
//        differenceKey.isKeyMember = true
//        differenceKey.isChecked = true
//        darkestKey.isKeyMember = true
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


    fun allFeatureExtraction(
        previewView: PreviewImageView,
        isText: Boolean,
        taskName: String? = null
    ) {
        val result = mutableListOf<FeatureCoordinatePoint>()
        colorMaps.forEach { t, u ->
            if (t.isChecked) {
                result.addAll(u)
            }
        }

        val str = GenerateCodeUtils.autoImgCode(
            taskName = taskName,
            sx = coordinateArea?.x ?: 0,
            sy = coordinateArea?.y ?: 0,
            data = result,
            isText = isText
        )
        viewModelScope.launch(Dispatchers.IO) {
            str?.let { resultStr ->
                val clipData = ClipData.newPlainText("autoCode", resultStr)
                manager.setPrimaryClip(clipData)
                runOnUI {
                    result.forEach {
                        previewView.addDot(
                            CoordinatePoint(
                                (coordinateArea?.x ?: 0) + it.x,
                                (coordinateArea?.y ?: 0) + it.y
                            )
                        )
                    }
                }
                Log.i(TAG, "自动代码生成完成")
            }
        }
    }

    //生成普通图片特征值
    fun autoCodeNormalImg(
        previewView: PreviewImageView,
        isText: Boolean = false,
        taskName: String? = null
    ) {
        previewView.clearPoint()
        viewModelScope.launch(Dispatchers.IO) {
            val result = mutableListOf<FeatureCoordinatePoint>()
            //这里每个模块单独找颜色
            colorMaps.forEach { it ->
                if (it.key.isChecked) {
                    markBoundaryInternal(it.value)
                    val list = getPointBlockList(it.value, minStep, true)
                    result.addAll(obtainFeatureImg(list, obtainDistance, true))
                    Log.i(TAG, "自动处理图片完成")
                }
            }
            val str = if (findArea != null) {
                GenerateCodeUtils.autoImgCodeArea(
                    taskName = taskName,
                    coordinateArea?.x ?: 0,
                    coordinateArea?.y ?: 0,
                    result,
                    findArea!!,
                    isText,
                )
            } else {
                GenerateCodeUtils.autoImgCode(
                    taskName = taskName,
                    sx = coordinateArea?.x ?: 0,
                    sy = coordinateArea?.y ?: 0,
                    data = result,
                    isText = isText
                )
            }
            str?.let { resultStr ->
                val clipData = ClipData.newPlainText("autoCode", resultStr)
                manager.setPrimaryClip(clipData)
                runOnUI {
                    result.forEach {
                        previewView.addDot(
                            CoordinatePoint(
                                (coordinateArea?.x ?: 0) + it.x,
                                (coordinateArea?.y ?: 0) + it.y
                            )
                        )
                    }
                }
            }
            Log.i(TAG, "自动代码生成完成")
        }
    }


    //這個富顔色不知道什麽意思了
    fun autoCodeNormalRichImg(previewView: PreviewImageView, taskName: String? = null) {
        previewView.clearPoint()
        viewModelScope.launch(Dispatchers.IO) {
            val result = mutableListOf<FeatureCoordinatePoint>()
            //这里每个模块单独找颜色
            colorMaps.forEach { it ->
                if (it.key.isChecked) {
                    markBoundaryInternal(it.value)
                    val list = getPointBlockList(it.value, 5, true)

                    if (list.size > 3) {
                        list.sortedByDescending {
                            it.perimeter
                        }.apply {
                            for (i in 0..2) {
                                list.getOrNull(i)?.let { pointBlock ->
                                    obtainInternalPoint(pointBlock, result)
                                }
                            }
                        }
                    } else {
                        list.forEach { pointBlock ->
                            obtainInternalPoint(pointBlock, result)
                        }
                    }
                    Log.i(TAG, "自动处理图片完成")
                }

            }


            val str = if (findArea != null) {
                GenerateCodeUtils.autoImgCodeArea(
                    taskName,
                    coordinateArea?.x ?: 0,
                    coordinateArea?.y ?: 0,
                    result,
                    findArea!!,
                )
            } else {
                GenerateCodeUtils.autoImgCode(
                    taskName,
                    coordinateArea?.x ?: 0,
                    coordinateArea?.y ?: 0,
                    result
                )
            }
            str?.let { resultStr ->
                val clipData = ClipData.newPlainText("autoCode", resultStr)
                manager.setPrimaryClip(clipData)
                runOnUI {
                    result.forEach {
                        previewView.addDot(
                            CoordinatePoint(
                                (coordinateArea?.x ?: 0) + it.x,
                                (coordinateArea?.y ?: 0) + it.y
                            )
                        )
                    }
                }
            }
            Log.i(TAG, "自动代码生成完成")
        }
    }

    fun builderClickArea(coordinateArea: CoordinateArea?, list: List<CoordinateLine>) {
        GenerateCodeUtils.builderClickArea(coordinateArea, list)?.let {
            val clipData = ClipData.newPlainText("autoCode", it)
            manager.setPrimaryClip(clipData)
            Log.i(TAG, "自动代码生成完成")
        }
    }


    private fun addBackground(result: MutableList<FeatureCoordinatePoint>, count: Int) {
        if (count <= 0)
            return

        val backList = mutableListOf<FeatureCoordinatePoint>()
        if (result.size > 1) {
            if (count == 1) {
                result.getOrNull(result.size / 2)?.let { point ->
                    val list = getPointSurround(point, 5, true, false, true)
                    list.find { it.mFeaturePointKey == darkestKey }?.let { darkPoint ->
                        darkPoint.isIdentificationKey = true
                        darkPoint.mDirectorPointKey = point.mFeaturePointKey
                        darkPoint.mDirectorPoint = point
                        backList.add(darkPoint)
                    }
                }
            } else {
                val step = if (count < result.size) (result.size / count) else 1
                for (i in result.indices step step) {
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
    private fun getPointBlockList(
        allList: MutableList<FeatureCoordinatePoint>, minStep: Int = 5, hasInternal: Boolean = false
    ): MutableList<FeaturePointBlock> {


        val result = mutableListOf<FeaturePointBlock>()
        //将所有位置置为空
        allList.forEach {
            it.hasContinuousSet = false
            it.hasFindRound = false
            it.isAdd = false
        }

        val boundaryList = allList.filter { it.isBoundary() }
        var startPoint = boundaryList.find { !it.hasContinuousSet }//&& it.isBoundary()

        var i = 0
        while (startPoint != null) {
            startPoint.setStartPosition()

            groupBlock(startPoint, i, minStep, hasInternal)?.let {
                result.add(it)
            }
            startPoint = boundaryList.find { !it.hasContinuousSet }//&& it.isBoundary()
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
    private fun obtainFeatureImg(
        list: List<FeaturePointBlock>,
        distance: Int = 8,
        addBack: Boolean = false,
    ): MutableList<FeatureCoordinatePoint> {
        val keyPointList = mutableListOf<FeatureCoordinatePoint>()

        val addBackgroundCount = if (!addBack) {
            0
        } else if (list.size > 3) {
            1
        } else if (list.size > 1) {
            2
        } else {
            3
        }
        list.forEach {
            obtainBoundaryPoint(it, distance, keyPointList, addBackgroundCount)
        }
        return filterNearPoints(keyPointList)
    }


    private fun filterNearPoints(list: MutableList<FeatureCoordinatePoint>): MutableList<FeatureCoordinatePoint> {
        val oldList = list.filter { it.mDirectorPoint == null }
        val newList = mutableListOf<FeatureCoordinatePoint>()
        oldList.forEach { point ->
            if (newList.find { abs(it.x - point.x) + abs(it.y - point.y) <= 3 } == null) {
                //L.d("添加点")
                newList.add(point)
            } else {
                //L.d("过滤点")
            }
        }

        val oldList1 = list.filter { it.mDirectorPoint != null }
        val newList1 = mutableListOf<FeatureCoordinatePoint>()
        oldList1.forEach { point ->
            if (newList1.find { abs(it.x - point.x) + abs(it.y - point.y) <= 3 } == null) {
                //L.d("添加w")
                newList1.add(point)
            } else {
                //L.d("过滤点")
            }
        }
        newList.addAll(newList1)
        return newList
    }


    //取外部点
    private fun obtainBoundaryPoint(
        block: FeaturePointBlock,
        distance: Int,
        keyPointList: MutableList<FeatureCoordinatePoint>,
        addBackgroundCount: Int = 0
    ) {
        L.d("length  ${block.boundaryList.size}")
        val correctDistance = if (block.boundaryList.size > 400) {
            distance * 2
        } else if (block.boundaryList.size > 200) {
            distance * 3
        } else if (block.boundaryList.size > 100) {
            distance * 2
        } else if (block.boundaryList.size > 80) {
            distance + 3
        } else if (block.boundaryList.size > 40) {
            distance + 2
        } else if (block.boundaryList.size > 20) {
            distance + 1
        } else {
            distance
        }
        val result = mutableListOf<FeatureCoordinatePoint>()
        //先添加首点
        block.boundaryList.find { it.sequenceNumber == 0 }?.let {
            result.add(it)
        }
        val jian = (correctDistance + 1) / 2
        //这里添加中间点
        if (block.perimeter > correctDistance) {
            for (i in correctDistance..block.perimeter - correctDistance step correctDistance) {
                block.boundaryList.filter { it.sequenceNumber == i }.forEach { point ->
                    //如果附近的点已经添加则不进行添加
                    if (keyPointList.find { abs(it.x - point.x) < jian && abs(it.y - point.y) < jian } == null
                        && result.find { abs(it.x - point.x) < jian && abs(it.y - point.y) < jian } == null
                    ) {
                        result.add(point)
                    }
                }
            }
        }


        //最后添加尾点
        block.boundaryList.find { it.sequenceNumber == block.perimeter }
            ?: block.boundaryList.find { it.sequenceNumber == block.perimeter - 1 }?.let {
                result.add(it)
            }


        val result1 = mutableListOf<FeatureCoordinatePoint>()
        //这里添加深度最高的点，是为了考虑透
        result.forEach { point ->
            if (!point.isAdd) {
                val list = getPointSurround(
                    point, 2, true, true
                ).filter { it.mFeaturePointKey == point.mFeaturePointKey && it.blockNumber == point.blockNumber }
                    .sortedByDescending { it.positionType }
                list.getOrNull(0)?.let {
                    it.sequenceNumber = point.sequenceNumber
                    result1.add(it)
                }
                list.forEach { it.isAdd = true }
            }
        }

        addBackground(result1, addBackgroundCount)
        keyPointList.addAll(result1)


    }

    //取内部点
    private fun obtainInternalPoint(
        block: FeaturePointBlock, keyPointList: MutableList<FeatureCoordinatePoint>
    ) {

        block.internalList?.sortedByDescending { it.positionType }?.getOrNull(0)?.let {
            keyPointList.add(it)
        }

    }


    fun fiterImgTask(imgTask: ImgTaskImpl1) {
        val newIprList = mutableListOf<IPR>()
        imgTask.iprList.forEach { resourIpr ->
            if (newIprList.find { newIpr ->
                    val nco = newIpr.getCoordinatePoint()
                    val oco = resourIpr.getCoordinatePoint()
                    abs(oco.xI - nco.xI) < 3 && abs(oco.xI - nco.xI) < 3
                } == null) {
                newIprList.add(resourIpr)
            }
        }
        val stringBuilder = StringBuilder()
        newIprList.forEach {
            stringBuilder.append("pointList.add(PointRule(CoordinatePoint(${it.getCoordinatePoint().xI},${it.getCoordinatePoint().yI}),RadioRule1))\n")
        }

        stringBuilder.toString().let { resultStr ->
            val clipData = ClipData.newPlainText("autoCode", resultStr)
            manager.setPrimaryClip(clipData)
        }
    }



}