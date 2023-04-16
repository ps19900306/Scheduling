package com.nwq.function.scheduling.auto_code.task


import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.google.android.material.internal.ContextUtils
import com.luck.picture.lib.utils.ToastUtils
import com.nwq.function.scheduling.App
import com.nwq.function.scheduling.auto_code.data.SinglePointColorValue
import com.nwq.function.scheduling.auto_code.data.TwoPointColorValue
import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.utils.ContextUtil
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

    val getColorMethod = "${methodName}Color"
    val getAreaMethod = "${methodName}Area"


    fun addSinglePoint(coordinate: Coordinate, int: Int) {
        val data = SinglePointColorValue(
            coordinate.x.toInt(), coordinate.y.toInt(), int.red, int.green, int.blue
        )
        singlePointList.add(data)
        ToastHelper.showToast("添加单点 一")
    }

    var lastSinglePointColorValue: SinglePointColorValue? = null


    fun addTwoPoint(coordinate: Coordinate, int: Int) {
        if (lastSinglePointColorValue == null) {
            lastSinglePointColorValue = SinglePointColorValue(
                coordinate.x.toInt(), coordinate.y.toInt(), int.red, int.green, int.blue
            )
            ToastHelper.showToast("添加对比点 一")
        } else {
            val data = SinglePointColorValue(
                coordinate.x.toInt(), coordinate.y.toInt(), int.red, int.green, int.blue
            )
            val two = TwoPointColorValue(lastSinglePointColorValue!!, data)
            lastSinglePointColorValue = null
            twoPointColorValue.add(two)
            ToastHelper.showToast("添加对比点 二")
        }
    }

    fun buildResultString(): String {
        val stringBuilder = StringBuilder()

        descriptiveInformation?.let {
            stringBuilder.append("// $descriptiveInformation \n")
        }
        stringBuilder.append("// $pictureName \n")
        //这里构造颜色判断
        stringBuilder.append("fun $getColorMethod():Boolean { \n")
        stringBuilder.append("val list = listOf(\n")
        singlePointList.forEach {
            stringBuilder.append("buildSinglePointTask(${it.x},${it.y},${it.red}, ${it.green}, ${it.blue}),\n")
        }
        twoPointColorValue.forEach {
            stringBuilder.append("buildTwoPointTask(${it.point1.x},${it.point1.y},${it.point1.red}, ${it.point1.green}, ${it.point1.blue} , ${it.point2.x},${it.point2.y},${it.point2.red}, ${it.point2.green}, ${it.point2.blue} ),\n")
        }
        stringBuilder.append(") \n")
        stringBuilder.append("return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)")
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

        stringBuilder.append(" if (visual.${getColorMethod}()) {")
        stringBuilder.append(" Timber.d(\"$getColorMethod MultiPointColorTask NWQ_ 2023/4/16\")\n")//这里为了添加注释
        stringBuilder.append(" flag = false")
        stringBuilder.append("  }else {")
        if (clickArea != null) stringBuilder.append(" click(constant.${getAreaMethod})")
        stringBuilder.append(" }\n")

        stringBuilder.append("count--\n")
        stringBuilder.append(" }\n")

        stringBuilder.append("return count != 0")

        stringBuilder.append(" }\n")

        return stringBuilder.toString()
    }


}