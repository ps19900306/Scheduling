package com.android.schedule.corelibrary.click

import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.exhaustion.ClickParameter
import com.android.schedule.corelibrary.exhaustion.ExhaustionControl
import com.android.schedule.corelibrary.exhaustion.OptRange
import com.android.schedule.corelibrary.exhaustion.OptSlide

/**
create by: 86136
create time: 2023/8/31 14:55
Function description:
 */

class ClickArea(
    x: Int,
    y: Int,
    width: Int,
    height: Int,
    var isRotundity: Boolean = false,
) : CoordinateArea(x, y, width, height) {


    var offsetX: Int = 0
    var offsetY: Int = 0

    fun setOffset(ofstX: Int, ofstY: Int) {
        offsetX = ofstX
        offsetY = ofstY
    }

    private val centerPoint = CoordinatePoint(x + width / 2, y + height / 2) //中心点
    private val minimumDiameter = (if (width > height) height else width) / 2  //最小半径

    fun toClickTask(delayTime: Long = 0L, ofstX: Int = 0, ofstY: Int = 0): ClickTask {
        val parameter = ExhaustionControl.getClickParameter()
        return if (!isRotundity) {
            builderSquare(delayTime, parameter, offsetX + ofstX, offsetY + ofstY)
        } else {
            builderRotundity(delayTime, parameter, offsetX + ofstX, offsetY + ofstY)
        }
    }


    private fun builderSquare(
        delayTime: Long, parameter: ClickParameter, ofstX: Int, ofstY: Int
    ): ClickTask {
        val list = mutableListOf<CoordinatePoint>()
        val point1 = when (parameter.optRange) {
            OptRange.SMALL_PRECISION -> {
                CoordinatePoint(
                    (x + (Math.random() * 0.6 + 0.2) * width).toFloat() + ofstX,
                    (y + (Math.random() * 0.6 + 0.2) * height).toFloat() + ofstY
                )
            }
            OptRange.WIDE_RANGE -> {
                CoordinatePoint(
                    (x + (Math.random() * 0.8 + 0.1) * width).toFloat() + ofstX,
                    (y + (Math.random() * 0.8 + 0.1) * height).toFloat() + ofstY
                )
            }
            OptRange.FULL_RANGE -> {
                CoordinatePoint(
                    (x + Math.random() * width).toFloat() + ofstX,
                    (y + Math.random() * height).toFloat() + ofstY
                )
            }
            OptRange.ALL_OPT_RANGE -> {
                CoordinatePoint(
                    (x + Math.random() * 1.2 * width).toFloat() + ofstX,
                    (y + Math.random() * 1.2 * height).toFloat() + ofstY
                )
            }
            OptRange.BEYOND_RANGE -> {
                CoordinatePoint(
                    (x + (Math.random() * 0.2 + 1) * width).toFloat() + ofstX,
                    (y + (Math.random() * 0.2 + 1) * height).toFloat() + ofstY
                )
            }
            else -> {
                CoordinatePoint(
                    (x + Math.random() * width).toFloat() + ofstX,
                    (y + Math.random() * height).toFloat() + ofstY
                )
            }
        }
        list.add(point1)


        when (parameter.optSlide) {
            OptSlide.NOT_SLIDE -> {

            }
            OptSlide.SLIDE_ONE -> {
                list.add(
                    CoordinatePoint(
                        point1.xD + (Math.random() - 0.5) * 0.05 * width,
                        point1.yD + (Math.random() - 0.5) * 0.05 * height
                    )
                )
            }
            OptSlide.SLIDE_TWO -> {
                list.add(
                    CoordinatePoint(
                        point1.xD + (Math.random() - 0.5) * 0.05 * width,
                        point1.yD + (Math.random() - 0.5) * 0.05 * height
                    )
                )
                list.add(
                    CoordinatePoint(
                        point1.xD + (Math.random() - 0.5) * 0.05 * width,
                        point1.yD + (Math.random() - 0.5) * 0.05 * height
                    )
                )
            }
        }


        return ClickTask(list, delayTime, ExhaustionControl.getClickDuration(parameter.optSlide))
    }


    private fun builderRotundity(
        delayTime: Long, parameter: ClickParameter, ofstX: Int, ofstY: Int
    ): ClickTask {
        val du = Math.random() * 2 * Math.PI
        val list = mutableListOf<CoordinatePoint>()
        val point1 = when (parameter.optRange) {
            OptRange.SMALL_PRECISION -> {
                val length = Math.random() * 0.6 * minimumDiameter
                CoordinatePoint(
                    x + Math.cos(du) * length + ofstX, y + +Math.sin(du) * length + ofstY
                )
            }
            OptRange.WIDE_RANGE -> {
                val length = Math.random() * 0.8 * minimumDiameter
                CoordinatePoint(
                    x + Math.cos(du) * length + ofstX, y + +Math.sin(du) * length + ofstY
                )
            }
            OptRange.FULL_RANGE -> {
                val length = Math.random() * minimumDiameter
                CoordinatePoint(
                    x + Math.cos(du) * length + ofstX, y + +Math.sin(du) * length + ofstY
                )
            }
            OptRange.ALL_OPT_RANGE -> {
                val length = Math.random() * 1.2 * minimumDiameter
                CoordinatePoint(
                    x + Math.cos(du) * length + ofstX, y + +Math.sin(du) * length + ofstY
                )
            }
            OptRange.BEYOND_RANGE -> {
                val length = (Math.random() * 0.2 + 1) * minimumDiameter
                CoordinatePoint(
                    x + Math.cos(du) * length + ofstX, y + +Math.sin(du) * length + ofstY
                )
            }
            else -> {
                val length = Math.random() * 0.8 * minimumDiameter
                CoordinatePoint(
                    x + Math.cos(du) * length + ofstX, y + +Math.sin(du) * length + ofstY
                )
            }
        }
        list.add(point1)


        when (parameter.optSlide) {
            OptSlide.NOT_SLIDE -> {

            }
            OptSlide.SLIDE_ONE -> {
                list.add(
                    CoordinatePoint(
                        point1.xD + (Math.random() - 0.5) * 0.05 * width,
                        point1.yD + (Math.random() - 0.5) * 0.05 * height
                    )
                )
            }
            OptSlide.SLIDE_TWO -> {
                list.add(
                    CoordinatePoint(
                        point1.xD + (Math.random() - 0.5) * 0.05 * width,
                        point1.yD + (Math.random() - 0.5) * 0.05 * height
                    )
                )
                list.add(
                    CoordinatePoint(
                        point1.xD + (Math.random() - 0.5) * 0.05 * width,
                        point1.yD + (Math.random() - 0.5) * 0.05 * height
                    )
                )
            }
        }

        return ClickTask(list, delayTime, ExhaustionControl.getClickDuration(parameter.optSlide))
    }


    //根据偏差值构造新的找寻任务
    fun copyOffset(offsetX: Int, offsetY: Int): ClickArea {
        return ClickArea(x + offsetX, y + offsetY, width, height, isRotundity)
    }
}