package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/2 10:17
Function description:
 */

object AllLess90Rule : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return red < 90 && blue < 90 && green < 90
    }
}