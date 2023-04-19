package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.TwoPointComparison

class SimpleComparisonRule(
    val red: Int, val green: Int, val blue: Int, val difference: Int, private val checkPoint: Boolean = true
)//difference 是因为颜色灰度导致的差值
    : TwoPointComparison {

    companion object {
        private const val range = 0.7
        val list = mutableListOf<SimpleComparisonRule>()
        fun getSimpleComparison(
            red: Int,
            green: Int,
            blue: Int,
            red2: Int,
            green2: Int,
            blue2: Int,
            checkPoint: Boolean = true
        ): SimpleComparisonRule {
            val redD = red - red2
            val greenD = green - green2
            val blueD = blue - blue2
            var difference = 255
            if (redD < difference) {
                difference = redD
            }
            if (greenD < difference) {
                difference = greenD
            }
            if (blueD < difference) {
                difference = blueD
            }
            difference = (difference * range).toInt()
            return list.find { it.red == red && it.green == green && it.blue == blue && it.difference == difference }
                ?: SimpleComparisonRule(red, green, blue, difference, checkPoint).apply {
                    list.add(this)
                }
        }
    }


    override fun verificationRule(
        red1: Int, green1: Int, blue1: Int, red2: Int, green2: Int, blue2: Int
    ): Boolean {
        val flag1 =
            red1 - red2 > difference && green1 - green2 > difference && blue1 - blue2 > difference
        if (!checkPoint) {
            return flag1
        }
        val flag2 = checkColor(listOf(red, green, blue), red1, green1, blue1)
        return flag1 && flag2
    }



}