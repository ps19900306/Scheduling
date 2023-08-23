package com.android.schedule.corelibrary.img.color_rule

import com.android.schedule.corelibrary.expand.toRgbInt

/**
create by: 86136
create time: 2023/5/12 20:19
Function description:
这个根据色值范围进行规则校验：同时增加比例特征值以求保证颜色的特性
 */

open class ColorRuleRatioImpl(
    val maxRed: Int, val minRed: Int, val maxGreen: Int,
    val minGreen: Int, val maxBlue: Int, val minBlue: Int,
    val redToGreenMax: Float, val redToGreenMin: Float,
    val redToBlueMax: Float, val redToBlueMin: Float,
    val greenToBlueMax: Float, val greenToBlueMin: Float,
) : ColorIdentificationRule {


    constructor(
        maxRed: Int, minRed: Int, maxGreen: Int, minGreen: Int, maxBlue: Int, minBlue: Int
    ) : this(
        maxRed, minRed, maxGreen,
        minGreen, maxBlue, minBlue,
        maxRed.toFloat() / minGreen, minRed.toFloat() / maxGreen,
        maxRed.toFloat() / minBlue, minRed.toFloat() / maxBlue,
        maxGreen.toFloat() / minBlue, minGreen.toFloat() / maxBlue,
    )


    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        val redF = red.toFloat()
        val greenF = green.toFloat()
        val blueF = blue.toFloat()

        val flag1 = if (redToGreenMin > 0 && redToGreenMax > 0 && red > 0 && green > 0) {
            val redToGreen = redF / greenF
            redToGreen in redToGreenMin..redToGreenMax
        } else {
            true
        }

        val flag2 = if (redToBlueMin > 0 && redToBlueMax > 0 && blue > 0 && red > 0) {
            val redToBlue = redF / blueF
            redToBlue in redToBlueMin..redToBlueMax
        } else {
            true
        }

        val flag3 = if (greenToBlueMin > 0 && greenToBlueMax > 0 && blue > 0 && green > 0) {
            val greenToBlue = greenF / blueF
            greenToBlue in greenToBlueMin..greenToBlueMax
        } else {
            true
        }
        val resultFlag =red in minRed..maxRed && green in minGreen..maxGreen && blue in minBlue..maxBlue && flag1 && flag2 && flag3
//        if(!resultFlag){
//             Timber.d("red: $red, green: $green, blue: $blue verificationRule  \n ${toString()}NWQ_ 2023/7/9");
//        }
        return resultFlag
    }

    override fun toString(): String {
        return "ColorRuleRatioImpl(maxRed=$maxRed, minRed=$minRed, maxGreen=$maxGreen, minGreen=$minGreen, maxBlue=$maxBlue, minBlue=$minBlue, redToGreenMax=$redToGreenMax, redToGreenMin=$redToGreenMin, redToBlueMax=$redToBlueMax, redToBlueMin=$redToBlueMin, greenToBlueMax=$greenToBlueMax, greenToBlueMin=$greenToBlueMin)"
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
                it.maxRed == maxRed && it.minRed == minRed && it.maxGreen == maxGreen && it.minGreen == minGreen && it.maxBlue == maxBlue && it.minBlue == minBlue && it.redToGreenMax == redToGreenMax && it.redToGreenMin == redToGreenMin && it.redToBlueMax == redToBlueMax && it.redToBlueMin == redToBlueMin && it.greenToBlueMax == greenToBlueMax && it.greenToBlueMin == greenToBlueMin
            } ?: ColorRuleRatioImpl(
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

        fun getSimple(
            red: Int,
            green: Int,
            blue: Int,
            range: Int = 35,
        ): ColorRuleRatioImpl {
            var rangRatio = 0.2F
            var maxRed = (red + range).toRgbInt()
            var minRed = (red - range).toRgbInt()
            var maxGreen = (green + range).toRgbInt()
            var minGreen = (green - range).toRgbInt()
            var maxBlue = (blue + range).toRgbInt()
            var minBlue = (blue - range).toRgbInt()


            var redToGreenMax = 0F
            var redToGreenMin = 0F
            var redToBlueMax = 0F
            var redToBlueMin = 0F
            var greenToBlueMax = 0F
            var greenToBlueMin = 0F


            if (green > 0 && red > 0) {
                var rToG = red.toFloat() / green.toFloat()
                redToGreenMax = rToG * (1 + rangRatio)
                redToGreenMin = rToG * (1 - rangRatio)
            }
            if (blue > 0 && red > 0) {
                var rToB = red.toFloat() / blue.toFloat()
                redToBlueMax = rToB * (1 + rangRatio)
                redToBlueMin = rToB * (1 - rangRatio)
            }
            if (green > 0 && blue > 0) {
                var gToB = green.toFloat() / blue.toFloat()
                greenToBlueMax = gToB * (1 + rangRatio)
                greenToBlueMin = gToB * (1 - rangRatio)
            }

            return list.find {
                it.maxRed == maxRed && it.minRed == minRed && it.maxGreen == maxGreen && it.minGreen == minGreen && it.maxBlue == maxBlue && it.minBlue == minBlue && it.redToGreenMax == redToGreenMax && it.redToGreenMin == redToGreenMin && it.redToBlueMax == redToBlueMax && it.redToBlueMin == redToBlueMin && it.greenToBlueMax == greenToBlueMax && it.greenToBlueMin == greenToBlueMin
            } ?: ColorRuleRatioImpl(
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