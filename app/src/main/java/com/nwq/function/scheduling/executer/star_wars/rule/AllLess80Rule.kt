package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/2 10:17
Function description:
 */

object AllLess80Rule : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        val flag1 = red < 80 && blue < 80 && green < 80
        val flag2 = red + blue + green < 240
        return flag2 || flag1
    }
}