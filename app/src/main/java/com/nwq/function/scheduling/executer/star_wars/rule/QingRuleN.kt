package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

/**
create by: 86136
create time: 2023/3/2 10:15
Function description:青色的颜色
 */

object QingRuleN : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return green > 80 && green - red > 40 && green > blue && green < 150
    }
}