package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

class SimpleRule(val redB: Int, val greenB: Int, val blueB: Int, val range: Int = 3) :
    ColorIdentificationRule {


    companion object {
        val list = mutableListOf<SimpleRule>()

        fun getSimple(red: Int, green: Int, blue: Int, range: Int = 3): SimpleRule {
            return list.find { it.redB == red && it.greenB == green && it.blueB == blue }
                ?: SimpleRule(red, green, blue, range).apply {
                    list.add(this)
                }
        }
    }

    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return checkColor(listOf(redB, greenB, blueB), red, green, blue, range)
    }
}