package com.nwq.function.corelib.img.rule

/**
create by: 86136
create time: 2023/5/12 20:19
Function description:
这个根据色值范围进行规则校验：同时增加比例特征值以求保证颜色的特性
 */

class ColorRuleRatioImpl(
    val maxRed: Int, val minRed: Int, val maxGreen: Int,
    val minGreen: Int, val maxBlue: Int, val minBlue: Int,
    val redToGreenMax: Float, val redToGreenMin: Float,
    val redToBlueMax: Float, val redToBlueMin: Float,
    val greenToBlueMax: Float, val greenToBlueMin: Float,
) : ColorIdentificationRule {


    constructor(
        maxRed: Int, minRed: Int, maxGreen: Int,
        minGreen: Int, maxBlue: Int, minBlue: Int
    ) : this(
        maxRed, minRed, maxGreen,
        minGreen, maxBlue, minBlue,
        maxRed.toFloat() / minGreen, minRed.toFloat() / maxGreen,
        maxRed.toFloat() / minBlue, minRed.toFloat() / maxBlue,
        maxGreen.toFloat() / minBlue, minGreen.toFloat() / maxBlue,
    )


    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        val redF = red.toFloat()
        val greenF = red.toFloat()
        val blueF = red.toFloat()

        val redToGreen = redF / greenF
        val redToBlue = redF / blueF
        val greenToBlue = greenF / blueF

        return red in minRed..maxRed && green in minGreen..maxGreen && blue in minBlue..maxBlue &&
                redToGreen in redToGreenMin..redToGreenMax
                && redToBlue in redToBlueMin..redToBlueMax
                && greenToBlue in greenToBlueMin..greenToBlueMax
    }

    companion object {
        private val list = mutableListOf<ColorRuleRatioImpl>()

        fun getSimple(
            maxRed: Int, minRed: Int,
            maxGreen: Int, minGreen: Int,
            maxBlue: Int, minBlue: Int,
            redToGreenMax: Float, redToGreenMin: Float,
            redToBlueMax: Float, redToBlueMin: Float,
            greenToBlueMax: Float, greenToBlueMin: Float,
        ): ColorRuleRatioImpl {
            return list.find {
                it.maxRed == maxRed && it.minRed == minRed && it.maxGreen == maxGreen && it.minGreen == minGreen && it.maxBlue == maxBlue && it.minBlue == minBlue &&
                        it.redToGreenMax == redToGreenMax && it.redToGreenMin == redToGreenMin && it.redToBlueMax == redToBlueMax && it.redToBlueMin == redToBlueMin && it.greenToBlueMax == greenToBlueMax && it.greenToBlueMin == greenToBlueMin
            }
                ?: ColorRuleRatioImpl(
                    maxRed,
                    minRed,
                    maxGreen,
                    minGreen,
                    maxBlue,
                    minBlue,
                    redToGreenMax,
                    redToGreenMin,
                    redToBlueMax,
                    redToBlueMin,
                    greenToBlueMax,
                    greenToBlueMin
                ).apply {
                    list.add(this)
                }
        }
    }


}