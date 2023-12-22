package com.android.schedule.corelibrary.click

import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.area.DirectionType
import com.android.schedule.corelibrary.exhaustion.ExhaustionControl
import com.android.schedule.corelibrary.exhaustion.OptRange
import com.android.schedule.corelibrary.exhaustion.OptSlide

//这里的滑动只能保证方向但是完全不能保证距离，当需要滑动到顶部或者底部的时候可以用此方法
class SlidingArea(@DirectionType val direction: Int, val area: CoordinateArea) {

    companion object {
        private val du = Math.PI / 180  //用于计算角度的
    }

    fun toClickTask(delayTime: Long = 0L): ClickTask {
        val parameter = ExhaustionControl.getClickParameter()
        val list = mutableListOf<CoordinatePoint>()

        var pointStart: CoordinatePoint
        var pointEnd: CoordinatePoint

        var mPointRange: Double
        var fPointRange: Double
        var mDPointRange: Double
        var fDPointRange: Double


        when (parameter.optRange) {
            OptRange.SMALL_PRECISION -> {
                mPointRange = Math.random() * 0.4
                fPointRange = Math.random()
                mDPointRange = Math.random() * (1 - mPointRange - 0.4) + 0.2
                fDPointRange = Math.random() * 0.1 - 0.05
            }

            OptRange.WIDE_RANGE -> {
                mPointRange = Math.random() * 0.3
                fPointRange = Math.random()
                mDPointRange = Math.random() * (1 - mPointRange - 0.2) + 0.2
                fDPointRange = Math.random() * 0.2 - 0.06
            }

            OptRange.FULL_RANGE -> {
                mPointRange = Math.random() * 0.8
                fPointRange = Math.random()
                mDPointRange = Math.random() * (1 - mPointRange - 0.2) + 0.2
                fDPointRange = Math.random() * mDPointRange
            }

            OptRange.BEYOND_RANGE -> {
                mPointRange = Math.random() * 0.8
                fPointRange = Math.random()
                mDPointRange = Math.random() * (1 - mPointRange - 0.1) + 0.2
                fDPointRange = Math.random() * mDPointRange
            }

            else -> {
                mPointRange = Math.random() * 0.4
                fPointRange = Math.random()
                mDPointRange = Math.random() * (1 - mPointRange - 0.4) + 0.2
                fDPointRange = Math.random() * 0.1
            }
        }

        when (direction) {
            DirectionType.BOTTOM -> {
                pointStart = CoordinatePoint(
                    area.x + fPointRange * area.width,
                    area.y + mPointRange * area.height
                )
                var endX = pointStart.xI + fDPointRange * area.width
                val endY = area.y + (mDPointRange + mPointRange) * area.height
                if (endX < area.x) {
                    pointEnd = CoordinatePoint(area.xD, endY)
                } else if (endX > area.x + area.width) {
                    pointEnd = CoordinatePoint(area.x + area.width, endY.toInt())
                } else {
                    pointEnd = CoordinatePoint(endX, endY)
                }
            }

            DirectionType.RIGHT -> {
                pointStart = CoordinatePoint(
                    area.x + mPointRange * area.width,
                    area.y + fPointRange * area.height
                )
                var endX = area.x + (mDPointRange + mPointRange) * area.width
                val endY = pointStart.yI + fDPointRange * area.height
                if (endY < area.y) {
                    pointEnd = CoordinatePoint(endX, area.yD)
                } else if (endY > area.y + area.height) {
                    pointEnd = CoordinatePoint(endX.toInt(), area.y + area.height)
                } else {
                    pointEnd = CoordinatePoint(endX, endY)
                }
            }

            DirectionType.TOP -> {
                pointStart = CoordinatePoint(
                    area.x + fPointRange * area.width,
                    area.y + (1 - mPointRange) * area.height
                )
                var endX = pointStart.xI + fDPointRange * area.width
                val endY = area.y + (1 - mDPointRange - mPointRange) * area.height
                if (endX < area.x) {
                    pointEnd = CoordinatePoint(area.xD, endY)
                } else if (endX > area.x + area.width) {
                    pointEnd = CoordinatePoint(area.x + area.width, endY.toInt())
                } else {
                    pointEnd = CoordinatePoint(endX, endY)
                }
            }

            DirectionType.LEFT -> {
                pointStart = CoordinatePoint(
                    area.x + (1 - mPointRange) * area.width,
                    area.y + fPointRange * area.height
                )
                var endX = area.x + (1 - mDPointRange - mPointRange) * area.width
                val endY = pointStart.yI + fDPointRange * area.height
                if (endY < area.y) {
                    pointEnd = CoordinatePoint(endX, area.yD)
                } else if (endY > area.y + area.height) {
                    pointEnd = CoordinatePoint(endX.toInt(), area.y + area.height)
                } else {
                    pointEnd = CoordinatePoint(endX, endY)
                }
            }

            else -> {
                pointStart = CoordinatePoint(
                    area.x + fPointRange * area.width,
                    area.y + (1 - mPointRange) * area.height
                )
                var endX = pointStart.xI + fDPointRange * area.width
                val endY = area.y + (1 - mDPointRange - mPointRange) * area.height
                if (endX < area.x) {
                    pointEnd = CoordinatePoint(area.xD, endY)
                } else if (endX > area.x + area.width) {
                    pointEnd = CoordinatePoint(area.x + area.width, endY.toInt())
                } else {
                    pointEnd = CoordinatePoint(endX, endY)
                }
            }
        }

        list.add(pointStart)
        //TODO 这里考虑需要补充中间点吗
        list.add(pointEnd)
        return ClickTask(list, delayTime, ExhaustionControl.getSwipDuration(parameter.optSlide))
    }


}