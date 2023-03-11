package com.nwq.function.scheduling.executer.fight.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/2 10:15
Function description:
 */

object NotRedRule : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return !(red > 100 && red - blue > 60 && red - blue > 50)
    }
}