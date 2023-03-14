package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

object LaunchCompleteRule : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return green - red > 40 && blue - red > 35 && green > blue
    }
}