package com.nwq.function.scheduling.core_code.click

import com.nwq.function.scheduling.core_code.Constant
import com.nwq.function.scheduling.core_code.Constant.DURATION_TIME_UNIT
import com.nwq.function.scheduling.core_code.Coordinate

/**
create by: 86136
create time: 2023/2/27 14:50
Function description:
 */

data class SlideScreenTask(
    val startX: Int,
    val startY: Int,
    val with: Int,
    val height: Int,
    @DirectionType val direction: Int,
    val delayTime: Long = 0,
    var duration: Long = 0
) {
    fun convertToClick(): ClickTask {
        val coordinates = mutableListOf<Coordinate>()
        var directionVaryType: Int = 0
        //根据数据生成操作的起始坐标和最后的坐标
        var sX: Double = 0.0
        var sY: Double = 0.0
        var endX: Double = 0.0
        var endY: Double = 0.0
        when (direction) {
            DirectionType.LEFT -> {
                sX = startX - (Math.random() * 0.1 + 0.05) * with
                sY = startY + (Math.random() * 0.6 + 0.2) * height
                endX = startX - (Math.random() * 0.2 + 0.65) * with
                endY = startY + (Math.random() * 0.6 + 0.2) * height
                directionVaryType = if (Math.random() > 0.5) {
                    DirectionVaryType.INCREASE_Y
                } else {
                    DirectionVaryType.REDUCE_Y
                }
            }
            DirectionType.RIGHT -> {
                sX = startX + (Math.random() * 0.1 + 0.05) * with
                sY = startY + (Math.random() * 0.6 + 0.2) * height
                endX = startX + (Math.random() * 0.2 + 0.65) * with
                endY = startY + (Math.random() * 0.6 + 0.2) * height
                directionVaryType = if (Math.random() > 0.5) {
                    DirectionVaryType.INCREASE_Y
                } else {
                    DirectionVaryType.REDUCE_Y
                }
            }
            DirectionType.TOP -> {
                sY = startX - (Math.random() * 0.1 + 0.05) * height
                sX = startY + (Math.random() * 0.6 + 0.2) * with
                endY = startX - (Math.random() * 0.2 + 0.65) * height
                endX = startY + (Math.random() * 0.6 + 0.2) * with
                directionVaryType = if (Math.random() > 0.5) {
                    DirectionVaryType.INCREASE_X
                } else {
                    DirectionVaryType.REDUCE_X
                }
            }
            DirectionType.BOTTOM -> {
                sY = startX + (Math.random() * 0.1 + 0.05) * height
                sX = startY + (Math.random() * 0.6 + 0.2) * with
                endY = startX + (Math.random() * 0.2 + 0.65) * height
                endX = startY + (Math.random() * 0.6 + 0.2) * with
                directionVaryType = if (Math.random() > 0.5) {
                    DirectionVaryType.INCREASE_X
                } else {
                    DirectionVaryType.REDUCE_X
                }
            }
        }
        val diffX = endX - sX
        val diffY = endY - sY
        //这里获取到滑动长度
        val slideLen = kotlin.math.sqrt((diffX * diffX + diffY * diffY))
        if (duration.toInt() == 0) {//如果没有确定时间则根据距离确定时间
            val distanceCount = (slideLen / Constant.DISTANCE_UNIT).toInt()
            duration = if (distanceCount > 0) {
                (Constant.SLIDE_BASE_TIME + distanceCount * Constant.DISTANCE_TIME_UNIT * 5 + distanceCount * Constant.DISTANCE_TIME_UNIT * 10 * Math.random()).toLong()
            } else {
                (Constant.SLIDE_BASE_TIME * (1 + Math.random())).toLong()
            }
        }
        coordinates.add(Coordinate(sX.toFloat(), sY.toFloat()))
        if (duration > 400) {//如果时间少于300毫米则不进行补充点
            var pointCount = (duration / DURATION_TIME_UNIT).toInt() + 1
            if (pointCount <= 1) {
                pointCount = 2
            }
            var lastX = sX
            var lastY = sY
            for (i in 1 until pointCount) {
                val percentage = 1 / (pointCount - i + 1).toFloat()
                val percentageTotal = (Math.random() * 0.1 + percentage)
                val diffX = endX - lastX
                val diffY = endY - lastY
                var tempX = lastX + (diffX) * percentageTotal
                var tempY = lastY + (diffY) * percentageTotal
                when (directionVaryType) {
                    DirectionVaryType.INCREASE_X -> {
                        tempX += diffX * Math.random() * percentage * diffX
                    }
                    DirectionVaryType.REDUCE_X -> {
                        tempX -= diffX * Math.random() * percentage * diffX
                    }
                    DirectionVaryType.INCREASE_Y -> {
                        tempY += diffY * Math.random() * percentage * diffY
                    }
                    DirectionVaryType.REDUCE_Y -> {
                        tempY -= diffY * Math.random() * percentage * diffY
                    }
                }
                coordinates.add(Coordinate(tempX.toFloat(), tempY.toFloat()))
                lastX = tempX
                lastY = tempY
            }
        }
        coordinates.add(Coordinate(endX.toFloat(), endY.toFloat()))
        return ClickTask(coordinates, delayTime, duration)
    }
}