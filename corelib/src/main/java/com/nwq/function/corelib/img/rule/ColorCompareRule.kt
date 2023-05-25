package com.nwq.function.corelib.img.rule

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

//这里定义颜色的校验规则
interface ColorCompareRule {

    fun optInt(colorInt1: Int,colorInt2: Int): Boolean {
        return verificationRule(colorInt1.red, colorInt1.green, colorInt1.blue,colorInt2.red, colorInt2.green, colorInt2.blue)
    }

    fun verificationRule(red: Int, green: Int, blue: Int, red1: Int, green1: Int, blue1: Int): Boolean




}