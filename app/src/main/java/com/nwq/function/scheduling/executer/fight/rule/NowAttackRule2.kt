package com.nwq.function.scheduling.executer.fight.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/7 9:32
Function description:
 */

object NowAttackRule2 : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return red < 80 && blue < 80 && green < 80
    }
}