package com.nwq.function.scheduling.core_code.click

import com.nwq.function.scheduling.core_code.Area
import kotlin.math.abs

/**
create by: 86136
create time: 2023/4/25 10:52
Function description:
 */
data class SwipeTask(val startArea: Area, val endArea: Area, val angleAdd: Boolean) {

//    fun convertToClick(): ClickTask {
//
//        val startCoordinate = startArea.fullCoordinate
//        val endCoordinate = endArea.coordinate
//
////        val xL = abs(endCoordinate.x-startCoordinate.x)
////        val yL = abs(endCoordinate.y-startCoordinate.y)
//
//        Math.atan2((endCoordinate.y-startCoordinate.y).toDouble(),
//            (endCoordinate.x-startCoordinate.x).toDouble()
//        )
//
//   //     private val du = Math.PI / 180  //用于计算角度的
//
//    }
}