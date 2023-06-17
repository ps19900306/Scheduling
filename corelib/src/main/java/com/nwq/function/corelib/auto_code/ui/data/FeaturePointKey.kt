package com.nwq.function.corelib.auto_code.ui.data

import android.graphics.Color
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import timber.log.Timber

/**
create by: 86136
create time: 2023/5/16 10:13
Function description:
 */

class FeaturePointKey(var colorInt: Int) {
    var ignoreRatio = false //是否忽略比例
    var red: Int = colorInt.red
    var green: Int = colorInt.green
    var blue: Int = colorInt.blue

    var redD = 30
    var greenD = 30
    var blueD = 30

    var maxRed = red + redD
    var minRed = red - redD
    var maxGreen = green + greenD
    var minGreen = green - greenD
    var maxBlue = blue + blueD
    var minBlue = blue - blueD

    var rToG = red.toFloat() / green.toFloat()
    var rToB = red.toFloat() / blue.toFloat()
    var gToB = green.toFloat() / blue.toFloat()

    val rangRatio = 0.2
    var maxRToG = rToG * (1 + rangRatio)
    var minRToG = rToG * (1 - rangRatio)
    var maxRToB = rToB * (1 + rangRatio)
    var minRToB = rToB * (1 - rangRatio)
    var maxGToB = gToB * (1 + rangRatio)
    var minGToB = gToB * (1 - rangRatio)

    //这个特征共有多少特征点
    var pointCount = 1

//    //当有一个新的点加入分组则进行处理 这里保证取平均值
//    fun updateByAdd(newColorInt: Int) {
//        val redA: Int = newColorInt.red
//        val greenA: Int = newColorInt.green
//        val blueA: Int = newColorInt.blue
//        Timber.d("old $red:$green:$blue updateByAdd FeaturePointKey NWQ_ 2023/6/17");
//        red = (red * pointCount + redA) / (pointCount + 1)
//        green = (green * pointCount + greenA) / (pointCount + 1)
//        blue = (blue * pointCount + blueA) / (pointCount + 1)
//
//        maxRed = red + redD
//        minRed = red - redD
//        maxGreen = green + greenD
//        minGreen = green - greenD
//        maxBlue = blue + blueD
//        minBlue = blue - blueD
//
//        rToG = red.toFloat() / green.toFloat()
//        rToB = red.toFloat() / blue.toFloat()
//        gToB = green.toFloat() / blue.toFloat()
//
//        maxRToG = rToG * (1 + rangRatio)
//        minRToG = rToG * (1 - rangRatio)
//        maxRToB = rToB * (1 + rangRatio)
//        minRToB = rToB * (1 - rangRatio)
//        maxGToB = gToB * (1 + rangRatio)
//        minGToB = gToB * (1 - rangRatio)
//        Timber.d("new $red:$green:$blue updateByAdd FeaturePointKey NWQ_ 2023/6/17");
//        pointCount++
//    }


    var isExpend = false //这个给Adapter使用的
    var isChecked = false //这个给Adapter使用的
    var isKeyMember = false //是否是三大特征值


    constructor(
        red: Int,
        green: Int,
        blue: Int
    ) : this(Color.rgb(red, green, blue))

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FeaturePointKey) return false

        if (colorInt != other.colorInt) return false

        return true
    }

    override fun hashCode(): Int {
        return colorInt
    }


    fun getBrightest(featurePointKey: FeaturePointKey): FeaturePointKey {
        val newColorInt = featurePointKey.colorInt
        val newRed = newColorInt.red
        val newGreen = newColorInt.green
        val newBlue = newColorInt.blue
        return if (red + green + blue < newRed + newGreen + newBlue) {
            featurePointKey
        } else {
            this
        }
    }


    fun getBrightest(newColorInt: Int) {
        val newRed = newColorInt.red
        val newGreen = newColorInt.green
        val newBlue = newColorInt.blue
        if (red + green + blue < newRed + newGreen + newBlue) {
            red = newColorInt
            green = newGreen
            blue = newBlue
            colorInt = newColorInt
        }
    }


    fun getDifference(featurePointKey: FeaturePointKey): FeaturePointKey {
        val newColorInt = featurePointKey.colorInt
        val newRed = newColorInt.red
        val newGreen = newColorInt.green
        val newBlue = newColorInt.blue
        var i1 = Math.abs(red - green) + Math.abs(red - blue) + Math.abs(green - blue)
        var i2 =
            Math.abs(newRed - newGreen) + Math.abs(newRed - newBlue) + Math.abs(newGreen - newBlue)
        return if (i2 > i1) {
            featurePointKey
        } else {
            this
        }
    }


    fun getDifference(newColorInt: Int) {
        val newRed = newColorInt.red
        val newGreen = newColorInt.green
        val newBlue = newColorInt.blue
        var i1 = Math.abs(red - green) + Math.abs(red - blue) + Math.abs(green - blue)
        var i2 =
            Math.abs(newRed - newGreen) + Math.abs(newRed - newBlue) + Math.abs(newGreen - newBlue)
        if (i2 > i1) {
            red = newColorInt
            green = newGreen
            blue = newBlue
            colorInt = newColorInt
        }
    }

    fun getDarkest(featurePointKey: FeaturePointKey): FeaturePointKey {
        val newColorInt = featurePointKey.colorInt
        val newRed = newColorInt.red
        val newGreen = newColorInt.green
        val newBlue = newColorInt.blue
        return if (red + green + blue > newRed + newGreen + newBlue) {
            featurePointKey
        } else {
            this
        }
    }


    fun getDarkest(newColorInt: Int) {
        val newRed = newColorInt.red
        val newGreen = newColorInt.green
        val newBlue = newColorInt.blue
        if (red + green + blue > newRed + newGreen + newBlue) {
            red = newColorInt
            green = newGreen
            blue = newBlue
            colorInt = newColorInt
        }
    }

    fun isInRange(point: FeatureCoordinatePoint): Boolean {
        return isInRange(point.red, point.green, point.blue)
    }

    fun isInRange(r: Int, g: Int, b: Int): Boolean {
        val rToG = r.toFloat() / g.toFloat()
        val rToB = r.toFloat() / b.toFloat()
        val gToB = g.toFloat() / b.toFloat()
        val radio = if (ignoreRatio) { //这里只验证值最大值和其他色值的比例
            true
        } else if (red >= green && red >= blue) {
            rToG in minRToG..maxRToG
                    && rToB in minRToB..maxRToB
        } else if (green >= red && green >= blue) {
            rToG in minRToG..maxRToG
                    && gToB in minGToB..maxGToB
        } else {
            rToB in minRToB..maxRToB
                    && gToB in minGToB..maxGToB
        }

        return r in minRed..maxRed
                && g in minGreen..maxGreen
                && b in minBlue..maxBlue && radio
    }


}