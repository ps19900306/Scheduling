package com.nwq.function.autocodeapp

import android.content.ClipData
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinateLine
import com.android.schedule.corelibrary.img.img_rule.FindImgTask
import com.android.schedule.corelibrary.img.point_rule.PointRule
import com.nwq.function.autocodeapp.data.FeatureCoordinatePoint
import java.lang.StringBuilder
import kotlin.math.abs

object GenerateCodeUtils {


    fun autoImgCode(
        sx: Int,
        sy: Int,
        data: List<FeatureCoordinatePoint>,
        rangX: Int = 3,
        rangY: Int = 3,
        everyRevalidation: Boolean = false,
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
            stringBuilder.append("list.add(${it.toColorRuleStr(sx, sy)})" )
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

        val datums = data.subList(0, 1)
        val points = data.subList(1, data.size)

        val datum = datums.get(0)
        // 当找寻的上下浮动很小的时候对范围进行修正 以减少不必要的找寻
        if (findArea.height < 6) {
            findArea.y = datum.y+sy - 3
            findArea.height = 7
        } else if (findArea.width < 6) {
            findArea.x = datum.x+sx - 3
            findArea.width = 7
        }
        //这里进行代码生成
        val stringBuilder = StringBuilder()
        stringBuilder.append("val isOpenTask by lazy {  \n")
        stringBuilder.append("val tag = \"isOpen\" \n")


        stringBuilder.append(" val pr  = ${datums.get(0).toColorRuleStr(sx, sy)}")

        findArea.apply {
            stringBuilder.append(" val findArea = CoordinateArea($xI,$yI,$width,$height) \n")
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


    fun builderClickArea(coordinateArea: CoordinateArea?, list: List<CoordinateLine>):String? {
        val builder = StringBuilder()
        if (list.isEmpty() && coordinateArea == null) {
            return null
        } else if (list.isEmpty()) {
            coordinateArea!!.apply {
                builder.append("val clickArea by lazy {\n ClickArea($xI,$yI,$width,$height,$isRound)}")
            }
        } else if (coordinateArea == null) {
            var spaceDistance = 0
            var distanceCount = 0
            builder.append("//")
            list.forEach {
                val desX = abs(it.startP.xI - it.endP.xI)
                val desY = abs(it.startP.yI - it.endP.yI)
                distanceCount += it.distance
                spaceDistance += Math.max(desX, desY)
                builder.append("desX:$desX desY:$desY  distance${it.distance}")

            }
            builder.append("\n")
            builder.append("val standardDistance = ${spaceDistance / distanceCount}")

        } else {
            var spaceDistance = 0
            var distanceCount = 0
            builder.append("//")
            list.forEach {
                val desX = abs(it.startP.xI - it.endP.xI)
                val desY = abs(it.startP.yI - it.endP.yI)
                distanceCount += it.distance
                spaceDistance += Math.max(desX, desY)
                builder.append("desX:$desX desY:$desY  distance${it.distance}")

            }
            builder.append("\n")
            //builder.append("val standardDistance = ${spaceDistance / distanceCount}")

            var isLan = false
            list.getOrNull(0)?.let {
                val desX = abs(it.startP.xI - it.endP.xI)
                val desY = abs(it.startP.yI - it.endP.yI)
                if (desX > desY) {
                    isLan = true
                }
            }

            coordinateArea.apply {
                builder.append(" fun getClickArea(offset: Int): ClickArea { \n")
                if (isLan) {
                    builder.append("return  ClickArea($xI + offset* ${spaceDistance / distanceCount},$yI,$width,$height,$isRound) \n")
                } else {
                    builder.append("return  ClickArea($xI,$yI+ offset* ${spaceDistance / distanceCount},$width,$height,$isRound) \n")
                }
                builder.append("}")
            }
        }
        return builder.toString()
    }
}