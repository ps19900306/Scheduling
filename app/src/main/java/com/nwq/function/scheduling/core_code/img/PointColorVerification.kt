package com.nwq.function.scheduling.core_code.img

import com.nwq.function.scheduling.core_code.Coordinate

/**
create by: 86136
create time: 2023/2/27 14:01
Function description:
这个是验点是否符合颜色的
 */
sealed class PointColorVerification() {
    //以颜色找颜色
    data class CoordinateColor(
        val coordinate: Coordinate,
        val colorRule: String,
        val tolerance: Int = 0,
        val range: Int = 0, //这个是为了范围取点
    ) : PointColorVerification()

    //以规则找颜色
    data class CoordinateRule(
        val coordinate: Coordinate,
        val rule: ColorIdentificationRule,
        val range: Int = 0,
    ) : PointColorVerification()

    //二点对比找颜色
    data class TwoPointTask(
        val coordinate1: Coordinate,
        val coordinate2: Coordinate,
        val twoPointComparison: TwoPointComparison,
    ) : PointColorVerification() {
        constructor(
            x: Int,
            y: Int,
            x1: Int,
            y1: Int,
            twoPointComparison: TwoPointComparison
        ) : this(
            Coordinate(x, y), Coordinate(x1, y1), twoPointComparison
        )
    }
}