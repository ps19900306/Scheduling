package com.android.schedule.corelibrary.click

import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.area.DirectionType
import com.android.schedule.corelibrary.area.TwoFingerType
import com.android.schedule.corelibrary.exhaustion.ExhaustionControl
import com.android.schedule.corelibrary.exhaustion.OptRange
import com.android.schedule.corelibrary.exhaustion.OptSlide

class TwoFingerArea(@TwoFingerType val direction: Int, val area: CoordinateArea) {

    companion object {
        private val du = Math.PI / 180  //用于计算角度的
    }

    fun toClickTask(delayTime: Long = 0L): List<ClickTask> {

        val parameter = ExhaustionControl.getClickParameter()

        val centerX = area.x + (Math.random() * 0.2 + 0.4) * area.width
        val centerY = area.y + (Math.random() * 0.2 + 0.4) * area.height
        val centrCoordinatePoint = CoordinatePoint(centerX, centerY)

        val offsetLeftDu = Math.random() * 10
        val offsetRightDu = -(Math.random() * 10)

        val shortSide = Math.min(area.width, area.height)


        val point1 = getEndCoordinate(
            DirectionType.LEFT,
            centrCoordinatePoint,
            shortSide * (Math.random() * 0.2 + 0.6),
            offsetLeftDu
        )
        val point2 = getEndCoordinate(
            DirectionType.LEFT,
            centrCoordinatePoint,
            shortSide * (Math.random() * 0.1 + 0.1),
            offsetLeftDu
        )

        val point3 = getEndCoordinate(
            DirectionType.RIGHT,
            centrCoordinatePoint,
            shortSide * (Math.random() * 0.1 + 0.1),
            offsetRightDu
        )
        val point4 = getEndCoordinate(
            DirectionType.RIGHT,
            centrCoordinatePoint,
            shortSide * (Math.random() * 0.2 + 0.6),
            offsetRightDu
        )


        val clickList = mutableListOf<ClickTask>()


        val duration = ExhaustionControl.getSwipDuration(parameter.optSlide)
        when (direction) {
            TwoFingerType.PULL_OPEN -> {
                clickList.add(  ClickTask(
                    listOf(point2,point2, point1),
                    delayTime + (Math.random() * 5).toLong(),
                    duration
                ))
                clickList.add( ClickTask(
                    listOf(point3,point3, point4),
                    delayTime + (Math.random() * 5).toLong(),
                    duration
                ))
            }

            TwoFingerType.REDUCE_CLOSE -> {
                clickList.add(  ClickTask(
                    listOf(point1,point1, point2),
                    delayTime + (Math.random() * 5).toLong(),
                    duration
                ))
                clickList.add(ClickTask(
                    listOf(point4,point4, point3),
                    delayTime + (Math.random() * 5).toLong(),
                    duration
                ))
            }
        }

        return clickList
    }


    private fun getEndCoordinate(
        type: Int,
        startPs: CoordinatePoint,
        slidingLength: Double,
        offset: Double,
    ): CoordinatePoint {
        var offsetX = 0.0
        var offsetY = 0.0

        when (type) {
            DirectionType.RIGHT -> {
                offsetX = Math.cos((0 + offset) * du)
                offsetY = Math.sin((0 + offset) * du)
            }

            DirectionType.BOTTOM_RIGHT -> {
                offsetX = Math.cos((45 + offset) * du)
                offsetY = Math.sin((45 + offset) * du)
            }

            DirectionType.BOTTOM -> {
                offsetX = Math.cos((90 + offset) * du)
                offsetY = Math.sin((90 + offset) * du)
            }

            DirectionType.BOTTOM_LEFT -> {
                offsetX = Math.cos((135 + offset) * du)
                offsetY = Math.sin((135 + offset) * du)
            }

            DirectionType.LEFT -> {
                offsetX = Math.cos((180 + offset) * du)
                offsetY = Math.sin((180 + offset) * du)
            }

            DirectionType.TOP_LEFT -> {
                offsetX = Math.cos((225 + offset) * du)
                offsetY = Math.sin((225 + offset) * du)
            }

            DirectionType.TOP -> {
                offsetX = Math.cos((270 + offset) * du)
                offsetY = Math.sin((270 + offset) * du)
            }

            DirectionType.TOP_RIGHT -> {
                offsetX = Math.cos((315 + offset) * du)
                offsetY = Math.sin((315 + offset) * du)
            }
        }

        val x = startPs.xD + offsetX * slidingLength
        val y = startPs.yD + offsetY * slidingLength

        return CoordinatePoint(x, y)
    }
}