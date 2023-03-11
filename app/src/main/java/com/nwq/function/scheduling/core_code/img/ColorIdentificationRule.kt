package com.nwq.function.scheduling.core_code.img

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

//这里定义颜色的校验规则
interface ColorIdentificationRule {

    fun optInt(colorInt: Int): Boolean {
        return verificationRule(colorInt.red, colorInt.green, colorInt.blue)
    }

    fun verificationRule(red: Int, green: Int, blue: Int): Boolean

    fun checkColor(rule: Array<Int>, red: Int, green: Int, blue: Int, range: Int = 10): Boolean {
        return red in (rule[0] - range)..(rule[0] + range) && blue in (rule[1] - range)..(rule[1] + range)
        green in (rule[2] - range)..(rule[2] + range)
    }

}