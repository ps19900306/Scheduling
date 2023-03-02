package com.nwq.function.scheduling.executer.fight.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule
import com.nwq.function.scheduling.core_code.img.TwoPointComparison

/**
create by: 86136
create time: 2023/3/2 10:15
Function description:
 */

object AllGreater10Comparison : TwoPointComparison {


    override fun verificationRule(
        red: Int,
        blue: Int,
        green: Int,
        red2: Int,
        blue2: Int,
        green2: Int
    ): Boolean {
        return (red - red2 > 10) && (blue - blue2 > 10) && (green - green2 > 10)
    }
}