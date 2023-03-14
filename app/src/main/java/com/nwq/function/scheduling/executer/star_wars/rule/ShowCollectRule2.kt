package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

object ShowCollectRule2 : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return red < 67
                && green < 72
                && blue < 73
    }
}