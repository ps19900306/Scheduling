package com.nwq.function.scheduling.auto_code.task


import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

import com.nwq.function.scheduling.auto_code.data.SinglePointColorValue
import com.nwq.function.scheduling.auto_code.data.TwoPointColorValue
import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.PixelsInfo
import com.nwq.function.scheduling.core_code.PositionLength
import com.nwq.function.scheduling.core_code.img.ImgUtils
import com.nwq.function.scheduling.core_code.img.PointColorVerification
import com.nwq.function.scheduling.executer.star_wars.rule.SimpleRuleV2
import com.nwq.function.scheduling.utils.ToastHelper
import java.lang.StringBuilder

/**
create by: 86136
create time: 2023/4/10 11:26
Function description:
 */

class MultiPointColorTask(
    val methodName: String,
    val pictureName: String,
    var descriptiveInformation: String? = null//这里是信息描述
) {
    val singlePointList = mutableListOf<SinglePointColorValue>()
    val twoPointColorValue = mutableListOf<TwoPointColorValue>() //点灰度图

    var clickArea: Area? = null
    var searchScopeArea: Area? = null

    val getColorMethod = "${methodName}Color"
    val getAreaMethod = "${methodName}Area"
    val getTaskMethod = "${methodName}Task"

    fun addSinglePoint(coordinate: Coordinate, int: Int) {
        val data = SinglePointColorValue(
            coordinate.x.toInt(), coordinate.y.toInt(), int.red, int.green, int.blue
        )
        if (singlePointList.contains(data))
            singlePointList.add(data)
        ToastHelper.showToast("添加单点 一")
    }

    var lastSinglePointColorValue: SinglePointColorValue? = null


    fun addTwoPoint(coordinate: Coordinate, int: Int, checkPoint1: Boolean) {
        if (lastSinglePointColorValue == null) {
            lastSinglePointColorValue = SinglePointColorValue(
                coordinate.x.toInt(), coordinate.y.toInt(), int.red, int.green, int.blue
            )
            ToastHelper.showToast("添加对比点 一")
        } else {
            val data = SinglePointColorValue(
                coordinate.x.toInt(), coordinate.y.toInt(), int.red, int.green, int.blue
            )
            val two = TwoPointColorValue(lastSinglePointColorValue!!, data, checkPoint1)
            lastSinglePointColorValue = null
            twoPointColorValue.add(two)
            ToastHelper.showToast("添加对比点 二")
        }
    }


    fun buildResultString(): String {
        return if (searchScopeArea == null) {
            builderNormal()
        } else {
            builderFindImg()
        }
    }


    fun buildJudeLengthStr(): String {
        var redMin = 255
        var redMax = 0
        var greenMin = 255
        var greenMax = 0
        var blueMin = 255
        var blueMax = 0

        val stringBuilder = StringBuilder()
        stringBuilder.append("val ${getTaskMethod} =\n")
        stringBuilder.append(" { \n")
        stringBuilder.append(" val list = listOf( \n")

        singlePointList.forEach {
            stringBuilder.append(" Coordinate(${it.x}, ${it.y}),\n")
            if (it.red < redMin) {
                redMin = it.red
            }
            if (it.red > redMax) {
                redMax = it.red
            }
            if (it.green < greenMin) {
                greenMin = it.green
            }
            if (it.green > greenMax) {
                greenMax = it.green
            }
            if (it.blue < blueMin) {
                blueMin = it.blue
            }
            if (it.blue > blueMax) {
                blueMax = it.blue
            }
        }

        stringBuilder.append(" ) \n")
        stringBuilder.append("val rule = SimpleRuleV2.getSimple($redMin, $redMax, $greenMin, $greenMax, $blueMin,$blueMax) \n")
        stringBuilder.append("val result = ImgUtils.judeLengthStatus(list, rule, screenBitmap) \n")
        stringBuilder.append(" PositionLength(list.size - result, list.size) \n")
        stringBuilder.append("   } \n")
        return stringBuilder.toString()
    }


    private fun builderFindImg(): String {
        val stringBuilder = StringBuilder()
        val area = searchScopeArea!!
        val tolerance = 6
        stringBuilder.append("fun ${getColorMethod}Task():Boolean { \n")

        stringBuilder.append("val pixelsInfo = PixelsInfo(${area.x}, ${area.y}, ${area.with}, ${area.height}) \n")
        stringBuilder.append("val coordinate = Coordinate(${singlePointList[0].x} ,${singlePointList[0].y}) \n")
        stringBuilder.append("val colorList = listOf(${singlePointList[0].red}, ${singlePointList[0].green}, ${singlePointList[0].blue}) \n")

        stringBuilder.append("val list = listOf(\n")
        singlePointList.forEach {
            stringBuilder.append("buildSinglePointTask(${it.x},${it.y},${it.red}, ${it.green}, ${it.blue}),\n")
        }
        stringBuilder.append(") \n")

        clickArea?.let {
            stringBuilder.append("var area = Area(${area.x}, ${area.y}, ${area.with}, ${area.height})\n")
            stringBuilder.append("var areaList = listOf(area)\n")
        } ?: let {
            stringBuilder.append("var areaList = listOf()\n")
        }

        stringBuilder.append("var areaList = FindImgTask(pixelsInfo,coordinate,colorList,$tolerance,list,areaList)\n")
        stringBuilder.append("return areaList  \n")
        stringBuilder.append(" }\n")


        stringBuilder.append("fun ${getColorMethod}():Boolean { \n")
        stringBuilder.append("constant.${getColorMethod}Task().apply { \n")
        stringBuilder.append(" if(ImgUtils.findImgByColor(screenBitmap,this)){ \n")
        stringBuilder.append(" return true \n")
        stringBuilder.append(" } \n")
        stringBuilder.append(" } \n")
        stringBuilder.append("return false \n")
        stringBuilder.append(" } \n")
        return stringBuilder.toString()
    }

    private fun builderNormal(): String {
        val stringBuilder = StringBuilder()

        descriptiveInformation?.let {
            stringBuilder.append("// $descriptiveInformation \n")
        }?.let {
            stringBuilder.append("// $pictureName \n")
        }
        //这里构造颜色判断
        stringBuilder.append("fun $getColorMethod():Boolean { \n")
        stringBuilder.append("val list = listOf(\n")
        singlePointList.forEach {
            stringBuilder.append("buildSinglePointTask(${it.x},${it.y},${it.red}, ${it.green}, ${it.blue}),\n")
        }
        twoPointColorValue.forEach {
            stringBuilder.append("buildTwoPointTask(${it.point1.x},${it.point1.y},${it.point1.red}, ${it.point1.green}, ${it.point1.blue} , ${it.point2.x},${it.point2.y},${it.point2.red}, ${it.point2.green}, ${it.point2.blue}, ${it.checkPoint1} ),\n")
        }
        stringBuilder.append(") \n")
        stringBuilder.append("return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)\n")
        stringBuilder.append("} \n")

        stringBuilder.append("\n")
        stringBuilder.append("\n")
        //这里构造点击区域
        clickArea?.let { area ->
            stringBuilder.append("var $getAreaMethod = Area(${area.x}, ${area.y}, ${area.with}, ${area.height})")
        }

        stringBuilder.append("\n")
        stringBuilder.append("\n")

        //这里为循环判断方法
        stringBuilder.append("suspend fun $methodName():Boolean{ \n")
        stringBuilder.append("var flag = true \n")
        stringBuilder.append("var count = 40 \n")
        stringBuilder.append("while (flag && count > 0 && runSwitch) \n")
        stringBuilder.append("{ \n")

        stringBuilder.append("if (!takeScreen(normalClickInterval)) {\n")
        stringBuilder.append(" runSwitch = false\n")
        stringBuilder.append("return  false\n")
        stringBuilder.append(" }\n")

        stringBuilder.append(" if (visual.${getColorMethod}()) { \n")
        stringBuilder.append(" Timber.d(\"$getColorMethod MultiPointColorTask NWQ_ 2023/4/16\")\n")//这里为了添加注释
        stringBuilder.append(" flag = false \n")
        stringBuilder.append("  }else { \n")
        if (clickArea != null) stringBuilder.append(" click(constant.${getAreaMethod}) \n")
        stringBuilder.append(" }\n")

        stringBuilder.append("count--\n")
        stringBuilder.append(" }\n")

        stringBuilder.append("return count != 0 \n")

        stringBuilder.append(" }\n")

        return stringBuilder.toString()
    }


}