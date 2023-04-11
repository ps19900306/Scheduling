package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/2 10:17
Function description:
 */

object JiYuItemOpenRule : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        val flag1 = red in 201..239
        val flag2 = green in 180..212
        val flag3 = blue in 130..155
        return flag2 && flag1 && flag3
    }
}