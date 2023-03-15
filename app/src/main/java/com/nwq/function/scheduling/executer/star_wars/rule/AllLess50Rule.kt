package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/2 10:17
Function description:
 */

object AllLess50Rule: ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        val flag1 = red < 50 && blue < 50 && green < 50
        val flag2 = red + blue + green < 120
        return flag2 || flag1
    }
}