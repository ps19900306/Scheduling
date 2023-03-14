package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

object ShowCollectRule1 : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return red > 37 && red < 57
                && green > 84 && green < 104
                && blue > 78 && blue < 100
    }
}