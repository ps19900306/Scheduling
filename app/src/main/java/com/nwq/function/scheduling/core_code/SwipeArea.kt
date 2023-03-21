package com.nwq.function.scheduling.core_code

import com.nwq.function.scheduling.core_code.click.ClickTask
import com.nwq.function.scheduling.utils.JsonUtil
import timber.log.Timber

data class SwipeArea(
    val startX: Double,
    val startY: Double,
    val endX: Double,
    val endY: Double,
    val duration: Double=(Math.random()+1)*1000,
    val delayTime: Long = 0L
) {

    fun toClickTask(midpointCount: Int = 0): ClickTask {
        val list = mutableListOf<Coordinate>()
        val startCoordinate = Coordinate(startX.toFloat(), startY.toFloat())
        list.add(startCoordinate)
        if (midpointCount > 0) {
            val xLength = endX - startX
            val yLength = endY - startY
            val xPercent = xLength / (midpointCount + 2)
            val yPercent = yLength / (midpointCount + 2)
            for (i in 0 until  midpointCount) {
                val midX = startX + xPercent * (i + 1) + (Math.random() * 0.03 - 0.01) * xLength
                val midY = startY + yPercent * (i + 1) + (Math.random() * 0.03 - 0.01) * yLength
                list.add(Coordinate(midX.toFloat(), midY.toFloat()))
            }
        }
        val endCoordinate = Coordinate(endX.toFloat(), endY.toFloat())
        list.add(endCoordinate)
        Timber.d("${JsonUtil.objectToString(list)} toClickTask SwipeArea NWQ_ 2023/3/15");
        return ClickTask(listOf(startCoordinate, endCoordinate), delayTime, duration.toLong())
    }
}
