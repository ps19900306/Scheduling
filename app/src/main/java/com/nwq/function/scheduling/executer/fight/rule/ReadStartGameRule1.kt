package com.nwq.function.scheduling.executer.fight.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule
import timber.log.Timber

object ReadStartGameRule1 : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return checkColor(listOf(251, 181, 64), red, green, blue)
    }
}