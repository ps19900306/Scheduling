package com.nwq.function.scheduling.core_code.img

import com.nwq.function.scheduling.core_code.Coordinate

/**
create by: 86136
create time: 2023/2/27 14:01
Function description:
 */

sealed class PointColorVerification() {
    data class CoordinateColor(
        val coordinate: Coordinate,
        val colorRule: String,
        val tolerance: Int = 0,
        val range:Int =0, //这个是为了范围取点
    ) : PointColorVerification()

    data class CoordinateRule(val coordinate: Coordinate, val rule: ColorIdentificationRule,val range:Int =0,) :
        PointColorVerification()
}