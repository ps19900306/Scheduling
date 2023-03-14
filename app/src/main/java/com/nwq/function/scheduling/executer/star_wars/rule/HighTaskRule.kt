package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/13 18:29
Function description:
 */

object HighTaskRule : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return red > 60 && green > 50 && blue > 105 &&
                red < 85 && green < 77 && blue < 130
                && red - 5 > green && blue - green > 40
    }
}