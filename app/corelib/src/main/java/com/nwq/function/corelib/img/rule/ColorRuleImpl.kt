package com.nwq.function.corelib.img.rule

/**
create by: 86136
create time: 2023/5/12 20:19
Function description:
这个根据色值范围进行规则校验
 */

class ColorRuleImpl(
    val maxRed: Int,
    val minRed: Int,
    val maxGreen: Int,
    val minGreen: Int,
    val maxBlue: Int,
    val minBlue: Int
) : ColorIdentificationRule {

    constructor(red: Int, green: Int, blue: Int, range: Int) : this(
        red + range,
        red - range,
        green + range,
        green - range,
        blue + range,
        blue - range
    )

    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return red in minRed..maxRed && green in minGreen..maxGreen && blue in minBlue..maxBlue
    }

    companion object {
        private val list = mutableListOf<ColorRuleImpl>()

        fun getSimple(
            maxRed: Int,
            minRed: Int,
            maxGreen: Int,
            minGreen: Int,
            maxBlue: Int,
            minBlue: Int
        ): ColorRuleImpl {
            return list.find { it.maxRed == maxRed && it.minRed == minRed && it.maxGreen == maxGreen && it.minGreen == minGreen && it.maxBlue == maxBlue && it.minBlue == minBlue }
                ?: ColorRuleImpl(maxRed, minRed, maxGreen, minGreen, maxBlue, minBlue).apply {
                    list.add(this)
                }
        }
    }


}