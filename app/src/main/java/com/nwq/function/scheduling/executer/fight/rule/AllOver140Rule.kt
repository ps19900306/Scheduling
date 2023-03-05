package com.nwq.function.scheduling.executer.fight.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/2 10:15
Function description:
 */

object AllOver140Rule : ColorIdentificationRule {
    override fun verificationRule(red: Int, blue: Int, green: Int): Boolean {
        return red > 140 && blue > 140 && green > 140
    }
}