package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.TwoPointComparison

class SimpleComparisonRule(val redDValue: Int, val greenDValue: Int, val blueDValue: Int) :
    TwoPointComparison {


    companion object {
        private const val range = 0.6
        val list = mutableListOf<SimpleComparisonRule>()
        fun getSimpleComparison(
            red: Int,
            green: Int,
            blue: Int,
            red2: Int,
            green2: Int,
            blue2: Int
        ): SimpleComparisonRule {
            val redD = red - red2
            val greenD = green - green2
            val blueD = blue - blue2
            return list.find { it.redDValue == redD * range.toInt() && it.greenDValue == greenD * range.toInt() && it.blueDValue == blueD * range.toInt() }
                ?: SimpleComparisonRule(red, green, blue).apply {
                    list.add(this)
                }
        }
    }


    override fun verificationRule(
        red: Int,
        green: Int,
        blue: Int,
        red2: Int,
        green2: Int,
        blue2: Int
    ): Boolean {
        val flag1 = if (redDValue > 0) {
            red - red2 >= redDValue
        } else {
            red - red2 <= redDValue
        }

        val flag2 = if (greenDValue > 0) {
            green - green2 >= greenDValue
        } else {
            green - green2 <= greenDValue
        }

        val flag3 = if (blueDValue > 0) {
            blue - blue2 >= blueDValue
        } else {
            blue - blue2 <= blueDValue
        }
        return flag1 && flag2 && flag3
    }
}