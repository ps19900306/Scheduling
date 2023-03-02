package com.nwq.function.scheduling.executer.fight.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/2 10:17
Function description:
 */

class AllLess50Rule: ColorIdentificationRule {
    override fun verificationRule(red: Int, blue: Int, green: Int): Boolean {
        return red < 50 && blue < 50 && green < 50
    }
}