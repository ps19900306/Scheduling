package com.nwq.function.scheduling.core_code.img

/**
create by: 86136
create time: 2023/3/2 10:49
Function description:
 */

interface TwoPointComparison {
    fun verificationRule(
        red: Int,
        blue: Int,
        green: Int,
        red2: Int,
        blue2: Int,
        green2: Int
    ): Boolean
}