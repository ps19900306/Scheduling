package com.nwq.function.scheduling.core_code.img

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import timber.log.Timber

//这里定义颜色的校验规则
interface ColorIdentificationRule {

    fun optInt(colorInt: Int): Boolean {
        return verificationRule(colorInt.red, colorInt.green, colorInt.blue)
    }

    fun verificationRule(red: Int, green: Int, blue: Int): Boolean

    fun checkColor(rule: List<Int>, red: Int, green: Int, blue: Int, range: Int = 6): Boolean {
        val result1 = (rule[0] - range) <= red && red <= (rule[0] + range)
        val result2 = (rule[1] - range) <= green && green <= (rule[1] + range)
        val result3 = (rule[2] - range) <= blue && blue <= (rule[2] + range)
        return result1 && result2 && result3
    }

}