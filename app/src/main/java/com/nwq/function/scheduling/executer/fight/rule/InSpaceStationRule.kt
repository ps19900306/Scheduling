package com.nwq.function.scheduling.executer.fight.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/2 10:17
Function description:
 */

object InSpaceStationRule : ColorIdentificationRule {
    override fun verificationRule(red: Int, blue: Int, green: Int): Boolean {
        return checkColor(arrayOf(160, 35, 137), red, blue, green)
    }
}