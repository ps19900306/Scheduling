package com.nwq.function.scheduling.executer.star_wars.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

class SimpleRule(val redB: Int, val greenB: Int, val blueB: Int, val range: Int = 3) :
    ColorIdentificationRule {

    var redD = range
    var greenD = range
    var blueD = range

    var maxRed = redB + redD
    var minRed = redB - redD
    var maxGreen = greenB + greenD
    var minGreen = greenB - greenD
    var maxBlue = blueB + blueD
    var minBlue = blueB - blueD


    var rToG = redB.toFloat() / greenB.toFloat()
    var rToB = redB.toFloat() / blueB.toFloat()
    var gToB = greenB.toFloat() / blueB.toFloat()

    var maxRToG = rToG * 1.1
    var minRToG = rToG * 0.9
    var maxRToB = rToB * 1.1
    var minRToB = rToB * 0.9
    var maxGToG = gToB * 1.1
    var minGToG = gToB * 0.9

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
        return isInRange(red, green, blue)
    }

    fun isInRange(r: Int, g: Int, b: Int): Boolean {
        val rToG = redB.toFloat() / greenB.toFloat()
        val rToB = redB.toFloat() / blueB.toFloat()
        val gToB = greenB.toFloat() / blueB.toFloat()
        return r in minRed..maxRed && g in minGreen..maxGreen && b in minBlue..maxBlue
                && rToG < maxRToG && rToG > minRToG
                && rToB < maxRToB && rToB > minRToB
                && gToB < maxGToG && gToB > minGToG
    }

}