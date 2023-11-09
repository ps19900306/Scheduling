package com.nwq.function.autocodeapp

import com.nwq.function.autocodeapp.data.FeatureCoordinatePoint
import java.lang.StringBuilder

object GenerateCodeUtils {


    private fun autoImgCode(sx: Int, sy: Int, data: List<FeatureCoordinatePoint>) {
        if (data.isNullOrEmpty() || data.size == 1) {
            return
        }

        val datums = data.subList(0, 1)
        val points = data.subList(1, data.size)

        //这里进行代码生成
        val stringBuilder = StringBuilder()
        stringBuilder.append("val isOpenTask by lazy {  \n")
        stringBuilder.append("val tag = \"isOpen\" \n")

        stringBuilder.append("val list = mutableListOf<PointRule>()   \n")
        datums.forEach {
            stringBuilder.append(it.toColorRuleStr(sx, sy))
        }
        stringBuilder.append("val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)\n")

        stringBuilder.append(" val pointList = mutableListOf<IPR>()\n")
        points.forEach {
            stringBuilder.append(
                "pointList.add(${it.toColorRuleStr(sx, sy)})\n"
            )
        }
        stringBuilder.append(" ImgTaskImpl1(pointList, tag, correctPositionModel)   \n")
        stringBuilder.append("}  \n")
        stringBuilder.toString()
    }


    private fun getOffset(a: Int, b: Int): Int {
        val d = a - b
        return if (d < -90) {
            -30
        } else if (d < -60) {
            -20
        } else if (d < -30) {
            -15
        } else if (d < 0) {
            -10
        } else if (d > 90) {
            30
        } else if (d > 60) {
            20
        } else if (d > 30) {
            15
        } else {
            10
        }
    }

    //这里将点变成字符串
    fun FeatureCoordinatePoint.toColorRuleStr(
        sx: Int, sy: Int,
    ): String {
        return if (mDirectorPoint != null) {
            val redD = getOffset(mDirectorPoint!!.red, red)
            val greenD = getOffset(mDirectorPoint!!.green, green)
            val blueD = getOffset(mDirectorPoint!!.blue, blue)
            "TwoPointRule(CoordinatePoint(${sx + mDirectorPoint!!.x}, ${sy + mDirectorPoint!!.y}),CoordinatePoint(${sx + x}, ${sy + y}), CompareDifferenceRuleImpl.getSimple($redD,$greenD,$blueD))"
        } else {
            "PointRule(CoordinatePoint(${startX + x}, ${startY + y}), ColorRuleRatioImpl.getSimple(${red},${green},${blue}))\n"
        }
    }
}