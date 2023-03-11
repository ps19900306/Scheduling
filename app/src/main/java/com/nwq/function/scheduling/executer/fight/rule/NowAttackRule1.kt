package com.nwq.function.scheduling.executer.fight.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/7 9:32
Function description:
 */

object NowAttackRule1 : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return red in 161..184 &&
                blue in 161..184 &&
                green in 161..184
    }
}