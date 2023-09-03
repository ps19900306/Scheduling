package com.android.schedule.corelibrary.click

import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.exhaustion.ExhaustionControl
import com.android.schedule.corelibrary.exhaustion.OptStatusType.Companion.CARELESS
import com.android.schedule.corelibrary.exhaustion.OptStatusType.Companion.PRECISION
import com.android.schedule.corelibrary.exhaustion.OptStatusType.Companion.REDUNDANCY

/**
create by: 86136
create time: 2023/8/31 14:55
Function description:
 */

class ClickArea(
    var x: Int,
    var y: Int,
    var width: Int,
    var height: Int,
    //var isKeyArea: Boolean = false,
    var isRotundity: Boolean = false,
) {

    var offsetX: Int = 0
    var offsetY: Int = 0

    fun setOffset(ofstX: Int, ofstY: Int) {
        offsetX = ofstX
        offsetY = ofstY
    }

    private val centerPoint = CoordinatePoint(x + width / 2, y + height / 2) //中心点
    private val minimumDiameter = (if (width > height) height else width) / 2  //最小半径

    fun toClickTask(delayTime: Long = 0L, ofstX: Int = 0, ofstY: Int = 0): ClickTask {
        return if (!isRotundity) {
            builderSquare(delayTime,offsetX+ofstX,offsetY+ofstY)
        } else {
            builderRotundity(delayTime,offsetX+ofstX,offsetY+ofstY)
        }
    }


    private fun builderSquare(delayTime: Long,ofstX:Int,ofstY:Int): ClickTask {
        val type = ExhaustionControl.getOptStatusType()
        val list = when (type) {
            PRECISION -> {
                val point1 = CoordinatePoint(
                    (x + (Math.random() * 0.8 + 0.1) * width).toFloat() + ofstX,
                    (y + (Math.random() * 0.8 + 0.1) * height).toFloat() + ofstY
                )
                listOf(point1)
            }
            CARELESS -> {
                val point1 = CoordinatePoint(
                    (x + (Math.random() * 1.05 - 0.1) * width).toFloat() + ofstX,
                    (y + (Math.random() * 1.05 - 0.1) * height).toFloat() + ofstY
                )
                listOf(point1)
            }
            else -> {
                val point1 = CoordinatePoint(
                    (x + Math.random() * width).toFloat() + ofstX,
                    (y + Math.random() * height).toFloat() + ofstY
                )
                val point2 = CoordinatePoint(
                    point1.xD + (Math.random() - 0.5) * 0.05 * width,
                    point1.yD + (Math.random() - 0.5) * 0.05 * height
                )
                listOf(point1, point2)
            }
        }
        return ClickTask(list, delayTime, ExhaustionControl.getClickDuration())
    }


    private fun builderRotundity(delayTime: Long,ofstX:Int,ofstY:Int): ClickTask {
        val type = ExhaustionControl.getOptStatusType()
        val du = Math.random() * 2 * Math.PI
        val list = when (type) {
            PRECISION -> {
                val length = Math.random() * 0.8 * minimumDiameter
                val point1 = CoordinatePoint(
                    x + Math.cos(du) * length + ofstX, y + +Math.sin(du) * length + ofstY
                )
                listOf(point1)
            }
            CARELESS -> {
                val length = Math.random() * 1.1 * minimumDiameter
                val point1 = CoordinatePoint(
                    x + Math.cos(du) * length + ofstX, y + +Math.sin(du) * length + ofstY
                )
                listOf(point1)
            }
            else -> {
                val length = Math.random() * minimumDiameter
                val point1 = CoordinatePoint(
                    x + Math.cos(du) * length + ofstX, y + +Math.sin(du) * length + ofstY
                )
                val point2 = CoordinatePoint(
                    point1.xD + (Math.random() - 0.5) * 0.05 * width,
                    point1.yD + (Math.random() - 0.5) * 0.05 * height
                )
                listOf(point1, point2)
            }
        }
        return ClickTask(list, delayTime, ExhaustionControl.getClickDuration())
    }

}