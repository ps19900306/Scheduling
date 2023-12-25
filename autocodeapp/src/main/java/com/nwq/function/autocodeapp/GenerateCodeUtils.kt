package com.nwq.function.autocodeapp

import android.content.ClipData
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinateLine
import com.android.schedule.corelibrary.img.color_rule.ColorRuleRatioImpl
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
        isText: Boolean = false,
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
        if (isText) {
            stringBuilder.append(allMaxRange(data.filter { it.mDirectorPoint == null }))
        }
        stringBuilder.append("val list = mutableListOf<PointRule>()   \n")
        datums.forEach {
            stringBuilder.append("list.add(${it.toColorRuleStr(sx, sy, isText)}) \n")
        }
        stringBuilder.append("val correctPositionModel =CorrectPositionModel(list, tag, $rangX, $rangY, $everyRevalidation)\n")

        stringBuilder.append(" val pointList = mutableListOf<IPR>()\n")
        points.forEach {
            stringBuilder.append(
                "pointList.add(${it.toColorRuleStr(sx, sy, isText)})\n"
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
        findArea: CoordinateArea,
        isText: Boolean = false
    ): String? {
        if (data.isNullOrEmpty() || data.size == 1) {
            return null
        }

        val datums = data.subList(0, 1)
        val points = data.subList(1, data.size)

        val datum = datums.get(0)
        // 当找寻的上下浮动很小的时候对范围进行修正 以减少不必要的找寻
        if (findArea.height < 6) {
            findArea.y = datum.y + sy - 3
            findArea.height = 7
        } else if (findArea.width < 6) {
            findArea.x = datum.x + sx - 3
            findArea.width = 7
        }
        //这里进行代码生成
        val stringBuilder = StringBuilder()
        stringBuilder.append("val isOpenTask by lazy {  \n")
        stringBuilder.append("val tag = \"isOpen\" \n")

        if (isText) {
            stringBuilder.append(allMaxRange(data.filter { it.mDirectorPoint == null }))
        }
        stringBuilder.append(" val pr  = ${datums.get(0).toColorRuleStr(sx, sy, isText)}")

        findArea.apply {
            stringBuilder.append(" val findArea = CoordinateArea($xI,$yI,$width,$height) \n")
        }

        stringBuilder.append(" val pointList = mutableListOf<IPR>()\n")
        points.forEach {
            stringBuilder.append(
                "pointList.add(${it.toColorRuleStr(sx, sy, isText)})\n"
            )
        }

        stringBuilder.append("FindImgTask(pr, findArea,pointList, tag)   \n")
        stringBuilder.append("}  \n")
        return stringBuilder.toString()
    }


    private fun getOffset(a: Int, b: Int): Int {
        val d = a - b
        return if (d < -200) {
            -50
        } else if (d < -150) {
            -40
        } else if (d < -90) {
            -30
        } else if (d < -60) {
            -20
        } else if (d < -30) {
            -15
        } else if (d < -10) {
            -10
        } else if (d < 10) { //这里将差值在10以内的忽略掉
            0
        } else if (d < 30) {
            10
        } else if (d < 60) {
            15
        } else if (d < 90) {
            20
        } else if (d < 150) {
            30
        } else if (d < 200) {
            40
        } else {
            50
        }
    }

    //这里将点变成字符串
    fun FeatureCoordinatePoint.toColorRuleStr(
        sx: Int, sy: Int, usUnit: Boolean = false
    ): String {
        return if (mDirectorPoint != null) {
            val redD = getOffset(mDirectorPoint!!.red, red)
            val greenD = getOffset(mDirectorPoint!!.green, green)
            val blueD = getOffset(mDirectorPoint!!.blue, blue)
            "TwoPointRule(CoordinatePoint(${sx + mDirectorPoint!!.x}, ${sy + mDirectorPoint!!.y}),CoordinatePoint(${sx + x}, ${sy + y}), CompareDifferenceRuleImpl.getSimple($redD,$greenD,$blueD)) // sequenceNumber:${mDirectorPoint!!.sequenceNumber}sequenceNumber blockNumber: $${mDirectorPoint!!.blockNumber}  positionType:$${mDirectorPoint!!.blockNumber} \n"
        } else {
            if (usUnit) {
                "PointRule(CoordinatePoint(${sx + x}, ${sy + y}), colorRule1)\n //red$red,green$green,blue$blue sequenceNumber:$sequenceNumber blockNumber: $blockNumber  positionType:$positionType \n"
            } else {
                "PointRule(CoordinatePoint(${sx + x}, ${sy + y}), ColorRuleRatioImpl.getSimple(${red},${green},${blue}))\n // sequenceNumber:$sequenceNumber blockNumber: $blockNumber  positionType:$positionType \n"
            }
        }
    }


    fun builderClickArea(coordinateArea: CoordinateArea?, list: List<CoordinateLine>): String? {
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


    private fun allMaxRange(list: List<FeatureCoordinatePoint>): String {
        var maxRed = 0
        var minRed = 255
        var maxGreen = 0
        var minGreen = 255
        var maxBlue = 0
        var minBlue = 255

        var maxRToG = 0F
        var minRToG = 255F
        var maxRToB = 0F
        var minRToB = 255F
        var maxGToB = 0F
        var minGToB = 255F

        list.forEach {
            maxRed = Math.max(it.red, maxRed)
            minRed = Math.min(it.red, minRed)
            maxGreen = Math.max(it.green, maxGreen)
            minGreen = Math.min(it.green, minGreen)
            maxBlue = Math.max(it.blue, maxBlue)
            minBlue = Math.min(it.blue, minBlue)

            maxRToG = Math.max(it.red.toFloat() / it.green.toFloat(), maxRToG)
            minRToG = Math.min(it.red.toFloat() / it.green.toFloat(), minRToG)
            maxRToB = Math.max(it.red.toFloat() / it.blue.toFloat(), maxRToB)
            minRToB = Math.min(it.red.toFloat() / it.blue.toFloat(), minRToB)
            maxGToB = Math.max(it.green.toFloat() / it.blue.toFloat(), maxGToB)
            minGToB = Math.min(it.green.toFloat() / it.blue.toFloat(), minGToB)
        }

        val maxD = 1.05
        val minD = 0.9
        val data = ColorRuleRatioImpl(
            Math.min(255, (maxRed * maxD).toInt()),
            Math.max(0, (minRed * minD).toInt()),
            Math.min(255, (maxGreen * maxD).toInt()),
            Math.max(0, (minGreen * minD).toInt()),
            Math.min(255, (maxBlue * maxD).toInt()),
            Math.max(0, (minBlue * minD).toInt()),
            (maxRToG * maxD).toFloat(),
            (minRToG * minD).toFloat(),
            (maxRToB * maxD).toFloat(),
            (minRToB * minD).toFloat(),
            (maxGToB * maxD).toFloat(),
            (minGToB * minD).toFloat(),
        )

        return "val colorRule1=ColorRuleRatioImpl.getSimple(${data.maxRed},${data.minRed},${data.maxGreen},${data.minGreen},${data.maxBlue},${data.minBlue},${data.redToGreenMax}F,${data.redToGreenMin}F,${data.redToBlueMax}F,${data.redToBlueMin}F,${data.redToGreenMax}F, ${data.redToGreenMin}F)\n"

    }
}