package com.nwq.function.scheduling.executer.fight.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/2 10:15
Function description:
 */

object AllOver170Rule : ColorIdentificationRule {
    override fun verificationRule(red: Int, blue: Int, green: Int): Boolean {
        return red > 170 && blue > 170 && green > 170
    }
}