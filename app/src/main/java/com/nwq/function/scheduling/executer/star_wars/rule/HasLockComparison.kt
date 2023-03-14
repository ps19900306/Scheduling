package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.TwoPointComparison

object HasLockComparison : TwoPointComparison {

    override fun verificationRule(
        red: Int, green: Int, blue: Int, red2: Int, green2: Int, blue2: Int
    ): Boolean {
        return (red - red2 > 50) && (blue - blue2 > 50) && (green - green2 > 50) && red > 110 && blue > 110 && green > 110
    }
}