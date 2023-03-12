package com.nwq.function.scheduling.core_code.img

import android.graphics.Bitmap
import android.graphics.Color
import androidx.core.graphics.red
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.PixelsInfo
import timber.log.Timber
import kotlin.math.abs


object ImgUtils {

    //通过颜色去找颜色最接近的点
    fun findPointByColor(
        data: FindPointByColorTask,
        bitmap: Bitmap,
        colorRule: String,
        tolerance: Int = 0
    ): Coordinate {
        return findPointByColor(data.toPixelsInfo(), bitmap, colorRule, tolerance)
    }

    //通过颜色去找颜色最接近的点
    fun findPointByColor(
        data: FindPointByColorTask,
        bitmap: Bitmap,
        baseRed: Int,
        baseBlue: Int,
        baseGreen: Int,
        tolerance: Int = 0
    ): Coordinate {
        return findPointByColor(
            data.toPixelsInfo(),
            bitmap,
            baseRed,
            baseBlue,
            baseGreen,
            tolerance
        )
    }

    //多点多规则颜色判断
    fun performTwoPointTask(
        data: List<TwoPointTask>,
        bitmap: Bitmap,
        toleranceErrorNumber: Int = 0,//能够容忍几个点颜色不一致
    ): Boolean {
        var nowErrorCount = 0
        data.forEach {
            if (!performTwoPointTask(it, bitmap)) {
                nowErrorCount++
            }
            if (nowErrorCount > toleranceErrorNumber)
                return false
        }
        return true
    }


    //多点多规则颜色判断
    fun performTwoPointTask(
        data: TwoPointTask,
        bitmap: Bitmap,
    ): Boolean {
        val pixel = bitmap.getPixel(data.coordinate1.x.toInt(), data.coordinate1.y.toInt())
        val pixel1 = bitmap.getPixel(data.coordinate2.x.toInt(), data.coordinate2.y.toInt())
        return data.twoPointComparison.optInt(
            pixel,
            pixel1)
    }

    //多个点找一个颜色 如果一个符合则返回True
    fun performPointsColorVerificationV2(
        data: List<PointColorVerification>,
        bitmap: Bitmap
    ): Boolean {
        return data.find {
            performPointColorVerification(it, bitmap)
        } != null
    }


    //多点多规则颜色判断
    fun performPointsColorVerification(
        data: List<PointColorVerification>,
        bitmap: Bitmap,
        toleranceErrorNumber: Int = 0,//能够容忍几个点颜色不一致
    ): Boolean {
        var nowErrorCount = 0
        data.forEach {
            if (!performPointColorVerification(it, bitmap)) {
                nowErrorCount++
            }
            if (nowErrorCount > toleranceErrorNumber)
                return false
        }
        return true
    }


    //单点单规则判断
    fun performPointColorVerification(
        data: PointColorVerification,
        bitmap: Bitmap
    ): Boolean {
        return if (data is PointColorVerification.CoordinateColor) {
            if (data.range > 0) {
                findColorLike(
                    PixelsInfo.buildPixelsInfo(data.coordinate, data.range),
                    bitmap,
                    data.colorRule,
                    data.tolerance
                )
            } else {
                judgeColorLike(data.coordinate, bitmap, data.colorRule, data.tolerance)
            }
        } else if (data is PointColorVerification.CoordinateRule) {
            if (data.range > 0) {
                findColorRule(
                    PixelsInfo.buildPixelsInfo(data.coordinate, data.range),
                    bitmap,
                    data.rule
                )
            } else {
                judgeColorRule(data.coordinate, bitmap, data.rule)
            }
        } else {
            false
        }
    }

    /**
     * 单点颜色判断 相似度
     */
    fun judgeColorLike(
        coordinate: Coordinate,
        bitmap: Bitmap,
        colorRule: String,
        tolerance: Int = 0
    ): Boolean {
        val color = bitmap.getPixel(coordinate.x.toInt(), coordinate.y.toInt())
        val baseColor = Color.parseColor(colorRule)
        return checkColor(
            baseColor,
            color,
            tolerance
        )
    }

    /**
     * 单点颜色判断 规则约束
     */
    fun judgeColorRule(
        coordinate: Coordinate,
        bitmap: Bitmap,
        colorRule: ColorIdentificationRule
    ): Boolean {
        val color = bitmap.getPixel(coordinate.x.toInt(), coordinate.y.toInt())
        Timber.d("x:${coordinate.x}  y:${coordinate.y} red: ${Color.red(color)}  , green: ${Color.green(color)}  , blue: ${Color.blue(color)} judgeColorRule ImgUtils NWQ_ 2023/3/12");
        return colorRule.optInt(color)
    }


    /**
     * 区块找颜色 找到颜色则返回true
     */
    fun findColorRule(
        pixelsInfo: PixelsInfo,
        bitmap: Bitmap,
        colorRule: ColorIdentificationRule
    ): Boolean {
        val pixels = IntArray(pixelsInfo.width * pixelsInfo.height)
        bitmap.getPixels(
            pixels,
            pixelsInfo.offset,
            pixelsInfo.stride,
            pixelsInfo.startX,
            pixelsInfo.startY,
            pixelsInfo.width,
            pixelsInfo.height
        )
        return pixels.find {
            colorRule.optInt(it)
        } != null
    }

    /**
     * 区块找颜色 找到颜色则返回true
     */
    fun findColorLike(
        pixelsInfo: PixelsInfo,
        bitmap: Bitmap,
        colorRule: String,
        tolerance: Int = 0
    ): Boolean {
        val pixels = IntArray(pixelsInfo.width * pixelsInfo.height)
        val baseColor = Color.parseColor(colorRule)
        bitmap.getPixels(
            pixels,
            pixelsInfo.offset,
            pixelsInfo.stride,
            pixelsInfo.startX,
            pixelsInfo.startY,
            pixelsInfo.width,
            pixelsInfo.height
        )
        return pixels.find {
            checkColor(
                it,
                baseColor,
                tolerance
            )
        } != null
    }

    /**
     * 区块找颜色 找到颜色则返回true
     */
    private fun findPointByColor(
        pixelsInfo: PixelsInfo,
        bitmap: Bitmap,
        colorRule: String,
        tolerance: Int = 0
    ): Coordinate {
        val baseColor = Color.parseColor(colorRule)
        val baseRed = Color.red(baseColor)
        val baseBlue = Color.blue(baseColor)
        val baseGreen = Color.green(baseColor)
        return findPointByColor(pixelsInfo, bitmap, baseRed, baseBlue, baseGreen, tolerance)
    }

    private fun findPointByColor(
        pixelsInfo: PixelsInfo,
        bitmap: Bitmap,
        baseRed: Int,
        baseBlue: Int,
        baseGreen: Int,
        tolerance: Int = 0
    ): Coordinate {
        val pixels = IntArray(pixelsInfo.width * pixelsInfo.height)
        bitmap.getPixels(
            pixels,
            pixelsInfo.offset,
            pixelsInfo.stride,
            pixelsInfo.startX,
            pixelsInfo.startY,
            pixelsInfo.width,
            pixelsInfo.height
        )
        var lastIndex = -1
        var lastDeviationValue = 100
        pixels.forEachIndexed { i, it ->
            val deviationValue = judgeColorSqrt(
                Color.red(it),
                Color.blue(it),
                Color.green(it),
                baseRed,
                baseBlue,
                baseGreen
            )
            if (deviationValue <= tolerance && deviationValue < lastDeviationValue) {
                lastDeviationValue = deviationValue
                lastIndex = i
            }
        }
        return if (lastIndex > 0) {
            if (pixelsInfo.width > 1 && pixelsInfo.height > 1) {
                val x = pixelsInfo.startX + lastIndex % pixelsInfo.width
                val y = pixelsInfo.startX + lastIndex / pixelsInfo.width
                Coordinate(x.toFloat(), y.toFloat())
            } else if (pixelsInfo.width > 1 && pixelsInfo.height == 1) {
                val x = pixelsInfo.startX + lastIndex
                val y = pixelsInfo.startY
                Coordinate(x.toFloat(), y.toFloat())
            } else if (pixelsInfo.width == 1 && pixelsInfo.height > 1) {
                val x = pixelsInfo.startX
                val y = pixelsInfo.startY + lastIndex
                Coordinate(x.toFloat(), y.toFloat())
            } else {
                Coordinate(pixelsInfo.startX.toFloat(), pixelsInfo.startY.toFloat())
            }
        } else {
            Coordinate(pixelsInfo.startX.toFloat(), pixelsInfo.startY.toFloat())
        }
    }


    /******  下面的都是私有方法 ******************/
    private fun checkColor(pixelsInt: Int, ColorInt: Int, tolerance: Int): Boolean {
        return abs(pixelsInt.red - ColorInt.red) < tolerance &&
                abs(pixelsInt.red - ColorInt.red) < tolerance &&
                abs(pixelsInt.red - ColorInt.red) < tolerance
    }

    private fun checkColor(
        pixelsInt: Int, imgRed: Int, imgBlue: Int,
        imgGreen: Int, tolerance: Int
    ): Boolean {
        return abs(pixelsInt.red - imgRed) < tolerance &&
                abs(pixelsInt.red - imgBlue) < tolerance &&
                abs(pixelsInt.red - imgGreen) < tolerance
    }

    private fun judgeColorSqrt(
        imgRed: Int,
        imgBlue: Int,
        imgGreen: Int,
        baseRed: Int,
        baseBlue: Int,
        baseGreen: Int,
    ): Int {
        return abs(baseRed - imgRed) + abs(baseBlue - imgBlue) + abs(baseGreen - imgGreen)
    }

}