package com.android.schedule.corelibrary.click

import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint

//这个是单词固定滑动 是为了保证滑动到一个固定为止时候使用
data class SwipeArea(
    val startX: Double,
    val startY: Double,
    val endX: Double,
    val endY: Double,
    val duration: Double=(Math.random()+1)*1000,
    val delayTime: Long = 0L
) {

    fun toClickTask(): ClickTask {
        val list = mutableListOf<CoordinatePoint>()
        val startCoordinate = CoordinatePoint(startX.toFloat(), startY.toFloat())
        list.add(startCoordinate)
        val endCoordinate = CoordinatePoint(endX.toFloat(), endY.toFloat())
        list.add(endCoordinate)
        return ClickTask(listOf(startCoordinate, endCoordinate), delayTime, duration.toLong())
    }
}