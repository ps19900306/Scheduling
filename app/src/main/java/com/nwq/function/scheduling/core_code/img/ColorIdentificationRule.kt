package com.nwq.function.scheduling.core_code.img

//这里定义颜色的校验规则
interface ColorIdentificationRule {

    fun verificationRule(red: Int, blue: Int, green: Int): Boolean

}