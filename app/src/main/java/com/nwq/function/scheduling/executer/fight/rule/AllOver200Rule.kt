package com.nwq.function.scheduling.executer.fight.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule
import com.nwq.function.scheduling.utils.log.L

/**
create by: 86136
create time: 2023/3/2 10:15
Function description:
 */

object AllOver200Rule : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return red > 200 && blue > 200 && green > 200
    }
}