package com.android.schedule.corelibrary.click

import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.area.DirectionType
import com.android.schedule.corelibrary.exhaustion.ExhaustionControl
import com.android.schedule.corelibrary.exhaustion.OptRange
import com.android.schedule.corelibrary.exhaustion.OptSlide

//这里的滑动只能保证方向但是完全不能保证距离，当需要滑动到顶部或者底部的时候可以用此方法
class SlidingArea(@DirectionType val direction: Int, val area: CoordinateArea) {

    companion object{
        private val du = Math.PI / 180  //用于计算角度的
    }

    fun toClickTask(delayTime: Long = 0L): ClickTask {

        val parameter = ExhaustionControl.getClickParameter()
        val list = mutableListOf<CoordinatePoint>()
        var d1: Double;
        var d2: Double;
        when (parameter.optRange) {
            OptRange.SMALL_PRECISION -> {
                d1 = Math.random() * 0.4 + 0.6
                d2 = Math.random() * 0.2 + 0.1
            }

            OptRange.WIDE_RANGE -> {
                d1 = Math.random() * 0.5 + 0.5
                d2 = Math.random() * 0.4 + 0.05
            }

            OptRange.FULL_RANGE -> {
                d1 = Math.random() * 0.8 + 0.2
                d2 = Math.random() * 0.6 + 0.1
            }

            OptRange.BEYOND_RANGE -> {
                d1 = Math.random() * 1.1 - 0.2
                d2 = Math.random() * 0.8 + 0.1
            }

            else -> {
                d1 = Math.random() * 1.1 - 0.2
                d2 = Math.random() * 0.8 + 0.1
            }
        }

        var startPoint: CoordinatePoint //滑动开始的点
        var endPoint: CoordinatePoint   //滑动结束的点
        val slidingDistance = when (parameter.optSlide) {
            OptSlide.NOT_SLIDE -> {
                (Math.random() * 0.1 + 0.1)
            }

            OptSlide.SLIDE_ONE -> {
                (Math.random() * 0.2 + 0.2)
            }

            OptSlide.SLIDE_TWO -> {
                (Math.random() * 0.3 + 0.3)
            }

            else -> {
                (Math.random() * 0.2 + 0.2)
            }
        }

        val offsetDu = Math.random() * 5 - 10

        //这里确地滑动的开始的点
        when (direction) {
            DirectionType.BOTTOM -> {
                startPoint = CoordinatePoint(area.x + d1 * area.width, area.y + d2 * area.height)
                val  offsetXD = Math.cos((90 + offsetDu) * du)
                val  offsetYD = Math.sin((90 + offsetDu) * du)
                val  offsetLength = slidingDistance * (1 - d2) * area.height

                val x = startPoint.xD + offsetXD * offsetLength
                val y = startPoint.yD + offsetYD * offsetLength
                endPoint=CoordinatePoint(x,y)
            }

            DirectionType.RIGHT -> {
                startPoint = CoordinatePoint(area.x + d2 * area.width, area.y + d1 * area.height)
                val  offsetXD = Math.cos((360 + offsetDu) * du)
                val  offsetYD = Math.sin((360 + offsetDu) * du)
                val  offsetLength = slidingDistance * (1 - d2) * area.width

                val x = startPoint.xD + offsetXD * offsetLength
                val y = startPoint.yD + offsetYD * offsetLength
                endPoint=CoordinatePoint(x,y)

            }

            DirectionType.TOP -> {
                startPoint =
                    CoordinatePoint(area.x + d1 * area.width, area.y + (1 - d2) * area.height)
                val  offsetXD = Math.cos((270 + offsetDu) * du)
                val  offsetYD = Math.sin((270 + offsetDu) * du)
                val  offsetLength = slidingDistance * (1 - d2) * area.height

                val x = startPoint.xD + offsetXD * offsetLength
                val y = startPoint.yD + offsetYD * offsetLength
                endPoint=CoordinatePoint(x,y)
            }

            DirectionType.LEFT -> {
                startPoint =
                    CoordinatePoint(area.x + (1 - d2) * area.width, area.y + d1 * area.height)
                val  offsetXD = Math.cos((180 + offsetDu) * du)
                val  offsetYD = Math.sin((180 + offsetDu) * du)
                val  offsetLength = slidingDistance * (1 - d2) * area.width

                val x = startPoint.xD + offsetXD * offsetLength
                val y = startPoint.yD + offsetYD * offsetLength
                endPoint=CoordinatePoint(x,y)
            }

            else -> {
                startPoint = CoordinatePoint(
                    area.x + (Math.random() * 0.1 + 0.5) * area.width,
                    +area.y + (Math.random() * 0.1 + 0.5) * area.height
                )
                endPoint = startPoint
            }
        }


        list.add(startPoint)
        //TODO 这里考虑需要补充中间点吗
        list.add(endPoint)
        return ClickTask(list, delayTime, ExhaustionControl.getSwipDuration(parameter.optSlide))
    }

}