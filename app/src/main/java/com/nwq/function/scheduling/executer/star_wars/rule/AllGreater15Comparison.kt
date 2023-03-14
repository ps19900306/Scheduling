package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.TwoPointComparison

/**
create by: 86136
create time: 2023/3/2 10:15
Function description:
 */

object AllGreater15Comparison : TwoPointComparison {

    override fun verificationRule(
        red: Int, green: Int, blue: Int, red2: Int, green2: Int, blue2: Int
    ): Boolean {
        return (red - red2 > 15) && (blue - blue2 > 15) && (green - green2 > 15)
    }
}