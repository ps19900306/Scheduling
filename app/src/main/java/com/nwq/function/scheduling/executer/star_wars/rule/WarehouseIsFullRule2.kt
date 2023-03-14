package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

object WarehouseIsFullRule2 : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return !checkColor(listOf(65, 104, 108), red, green, blue,8)
    }
}