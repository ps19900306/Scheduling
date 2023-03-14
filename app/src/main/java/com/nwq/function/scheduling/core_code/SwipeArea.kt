package com.nwq.function.scheduling.core_code

import com.nwq.function.scheduling.core_code.click.ClickTask

data class SwipeArea(
    val startX: Double,
    val startY: Double,
    val endX: Double,
    val endY: Double,
    val duration: Double,
    val delayTime: Long = 0L
) {

    fun toClickTask(midpointCount: Int = 0): ClickTask {
        val list = mutableListOf<Coordinate>()
        val startCoordinate = Coordinate(startX.toFloat(), startY.toFloat())
        list.add(startCoordinate)
        if (midpointCount > 0) {
            val xLength = endX - startX
            val yLength = startY - endY
            val xPercent = xLength / (midpointCount + 2)
            val yPercent = yLength / (midpointCount + 2)
            for (i in 0..midpointCount) {
                val midX = startX + xPercent * (i + 1) + (Math.random() * 0.1 - 0.03) * xLength
                val midY = startY + yPercent * (i + 1) + (Math.random() * 0.1 - 0.03) * yLength
                list.add(Coordinate(midX.toFloat(), midY.toFloat()))
            }
        }
        val endCoordinate = Coordinate(endX.toFloat(), endY.toFloat())
        list.add(endCoordinate)
        return ClickTask(listOf(startCoordinate, endCoordinate), delayTime, duration.toLong())
    }
}
