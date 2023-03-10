package com.nwq.function.scheduling.core_code.img

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

//这里定义颜色的校验规则
interface ColorIdentificationRule {

    fun optInt(colorInt: Int): Boolean {
        return verificationRule(colorInt.red, colorInt.blue, colorInt.green)
    }

    fun verificationRule(red: Int, blue: Int, green: Int): Boolean

}