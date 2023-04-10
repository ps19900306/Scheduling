package com.nwq.function.scheduling.auto_code.task


import com.nwq.function.scheduling.auto_code.data.SinglePointColorValue
import com.nwq.function.scheduling.auto_code.data.TwoPointColorValue
import com.nwq.function.scheduling.core_code.Area
import java.lang.StringBuilder

/**
create by: 86136
create time: 2023/4/10 11:26
Function description:
 */

class MultiPointColorTask(val methodName: String) {
    val singlePointList = mutableListOf<SinglePointColorValue>()
    val twoPointColorValue = mutableListOf<TwoPointColorValue>()
    var clickArea: Area? = null

    val getColorMethod = "${methodName}Color"
    val getAreaMethod = "${methodName}Area"

    fun builderString() {
        val stringBuilder = StringBuilder()

        //这里构造颜色判断
        stringBuilder.append("fun $getColorMethod():Boolean { \n")
        stringBuilder.append("val list1 = listOf(\n")
        singlePointList.forEach {
            stringBuilder.append("buildSinglePointTask(${it.x},${it.y},${it.red}, ${it.green}, ${it.blue}),")
        }
        twoPointColorValue.forEach {
            stringBuilder.append("buildSinglePointTask(${it.point1.x},${it.point1.y},${it.point1.red}, ${it.point1.green}, ${it.point1.blue} , ${it.point2.x},${it.point2.y},${it.point2.red}, ${it.point2.green}, ${it.point2.blue} ),")
        }
        stringBuilder.append(") \n")
        stringBuilder.append("return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)")
        stringBuilder.append("} \n")


        //这里构造点击区域
        clickArea?.let { area ->
            stringBuilder.append("var $getAreaMethod = Area(${area.x}, ${area.y}, ${area.with}, ${area.height})")
        }


        //这里为循环判断方法
        stringBuilder.append("suspend fun $methodName():Boolean{ \n")
        stringBuilder.append("var flag = true \n")
        stringBuilder.append("var count = 40 \n")
        stringBuilder.append("while (flag && count > 0 && runSwitch) \n")
        stringBuilder.append("{ \n")

        stringBuilder.append("if (!takeScreen(doubleClickInterval)) {\n")
        stringBuilder.append(" runSwitch = false\n")
        stringBuilder.append("return\n")
        stringBuilder.append(" }\n")

        stringBuilder.append(" if (visual.${getColorMethod}()) {")
        stringBuilder.append(" flag = false")
        stringBuilder.append("  }else {")
        if (clickArea != null)
            stringBuilder.append(" click(constant.${getAreaMethod})")

        stringBuilder.append(" }\n")

        stringBuilder.append("count--\n")
        stringBuilder.append(" }\n")

        stringBuilder.append("return count != 0")

        stringBuilder.append(" }\n")
    }


}