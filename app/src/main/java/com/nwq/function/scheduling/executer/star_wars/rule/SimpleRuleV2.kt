package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

class SimpleRuleV2(
    val redMin: Int,
    val greenMin: Int,
    val blueMin: Int,
    val redMax: Int,
    val greenMax: Int,
    val blueMax: Int
) :
    ColorIdentificationRule {


    companion object {
        val list = mutableListOf<SimpleRuleV2>()

        fun getSimple(
            redMin: Int,
            greenMin: Int,
            blueMin: Int,
            redMax: Int,
            greenMax: Int,
            blueMax: Int
        ): SimpleRuleV2 {
            return list.find { it.redMin == redMin && it.greenMin == greenMin && it.blueMin == blueMin && it.redMax == redMin && it.greenMax == greenMax && it.blueMax == blueMax }
                ?: SimpleRuleV2(redMin, greenMin, blueMin, redMax, greenMax, blueMax)
        }
    }

    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        val result1 = redMin <= red && red <= redMax
        val result2 = greenMin <= green && green <= greenMax
        val result3 = blueMin <= blue && blue <= blueMax
        return result1 && result2 && result3
    }


}