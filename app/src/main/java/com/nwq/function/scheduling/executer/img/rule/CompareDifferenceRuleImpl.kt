package com.nwq.function.scheduling.executer.img.rule

import com.nwq.function.scheduling.executer.img.rule.ColorCompareRule

/**
create by: 86136
create time: 2023/5/29 9:44
Function description:
 */

class CompareDifferenceRuleImpl(
    val redDifference: Int,
    val GreenDifference: Int,
    val BlueDifference: Int,
    ) : ColorCompareRule {

    override fun verificationRule(
        red1: Int, green1: Int, blue1: Int, red2: Int, green2: Int, blue2: Int
    ): Boolean {
        val red = red1 - red2
        val green = green1 - green2
        val blue = blue1 - blue2


        val flag1 = if (redDifference > 0) {
            red > redDifference
        } else {
            red < redDifference
        }

        val flag2 = if (GreenDifference > 0) {
            green > GreenDifference
        } else {
            green < GreenDifference
        }

        val flag3 = if (BlueDifference > 0) {
            blue > BlueDifference
        } else {
            blue < BlueDifference
        }
        return flag1 && flag2 && flag3
    }

    companion object {
        private val list = mutableListOf<CompareDifferenceRuleImpl>()

        fun getSimple(
            red: Int,
            green: Int,
            blue: Int,
        ): CompareDifferenceRuleImpl {
            return list.find {
                it.redDifference == red && it.GreenDifference == green && it.BlueDifference == blue
            } ?: CompareDifferenceRuleImpl(
                red,
                green,
                blue,
            ).apply {
                list.add(this)
            }
        }
    }
}