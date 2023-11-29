package com.nwq.function.autocodeapp

import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.img.img_rule.FindImgTask
import com.android.schedule.corelibrary.img.point_rule.PointRule
import com.nwq.function.autocodeapp.data.FeatureCoordinatePoint
import java.lang.StringBuilder

object GenerateCodeUtils {


    fun autoImgCode(
        sx: Int,
        sy: Int,
        data: List<FeatureCoordinatePoint>,
        rangX: Int = 3,
        rangY: Int = 3,
        everyRevalidation:Boolean =false,
    ): String? {
        if (data.isNullOrEmpty() || data.size == 1) {
            return null
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
        stringBuilder.append("val correctPositionModel =CorrectPositionModel(list, tag, $rangX, $rangY, $everyRevalidation)\n")

        stringBuilder.append(" val pointList = mutableListOf<IPR>()\n")
        points.forEach {
            stringBuilder.append(
                "pointList.add(${it.toColorRuleStr(sx, sy)})\n"
            )
        }
        stringBuilder.append(" ImgTaskImpl1(pointList, tag, correctPositionModel)   \n")
        stringBuilder.append("}  \n")
        return stringBuilder.toString()
    }


    fun autoImgCodeArea(
        sx: Int,
        sy: Int,
        data: List<FeatureCoordinatePoint>,
        findArea: CoordinateArea
    ): String? {
        if (data.isNullOrEmpty() || data.size == 1) {
            return null
        }

        // 当找寻的上下浮动很小的时候对范围进行修正 以减少不必要的找寻
        if (findArea.height < 6) {
            val rangX = findArea.width / 2
            val startX = findArea.x + rangX
            return autoImgCode(startX, sy, data, rangX, 3,true)
        } else if (findArea.width < 6) {
            val rangY = findArea.height / 2
            val startY = findArea.y + rangY
            return autoImgCode(sx, startY, data, 3, rangY,true)
        }


        val datums = data.subList(0, 1)
        val points = data.subList(1, data.size)

        //这里进行代码生成
        val stringBuilder = StringBuilder()
        stringBuilder.append("val isOpenTask by lazy {  \n")
        stringBuilder.append("val tag = \"isOpen\" \n")


        stringBuilder.append(" val pr  = ${datums.get(0).toColorRuleStr(sx, sy)}")

        findArea.apply {
            stringBuilder.append(" val findArea = CoordinateArea($xI,$yI,$width,$height)")
        }



        stringBuilder.append(" val pointList = mutableListOf<IPR>()\n")
        points.forEach {
            stringBuilder.append(
                "pointList.add(${it.toColorRuleStr(sx, sy)})\n"
            )
        }


        stringBuilder.append("FindImgTask(pr, findArea,pointList, tag)   \n")
        stringBuilder.append("}  \n")
        return stringBuilder.toString()
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
            "TwoPointRule(CoordinatePoint(${sx + mDirectorPoint!!.x}, ${sy + mDirectorPoint!!.y}),CoordinatePoint(${sx + x}, ${sy + y}), CompareDifferenceRuleImpl.getSimple($redD,$greenD,$blueD)) // sequenceNumber:${mDirectorPoint!!.sequenceNumber}sequenceNumber blockNumber: $${mDirectorPoint!!.blockNumber}  positionType:$${mDirectorPoint!!.blockNumber} \n"
        } else {
            "PointRule(CoordinatePoint(${sx + x}, ${sy + y}), ColorRuleRatioImpl.getSimple(${red},${green},${blue}))\n // sequenceNumber:$sequenceNumber blockNumber: $blockNumber  positionType:$positionType \n"
        }
    }
}