package com.nwq.function.scheduling.core_code.img

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.PixelsInfo


@RequiresApi(Build.VERSION_CODES.Q)
object ImgUtils {

    //多点多规则颜色判断
    suspend fun performPointsColorVerification(
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
    suspend fun performPointColorVerification(
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
    suspend fun judgeColorLike(
        coordinate: Coordinate,
        bitmap: Bitmap,
        colorRule: String,
        tolerance: Int = 0
    ): Boolean {
        val color = bitmap.getColor(coordinate.x.toInt(), coordinate.y.toInt())
        val baseColor = Color.parseColor(colorRule)
        return judgeColorSqrt(
            Color.red(baseColor),
            Color.blue(baseColor),
            Color.green(baseColor),
            color
        ) <= tolerance
    }

    /**
     * 单点颜色判断 规则约束
     */
    suspend fun judgeColorRule(
        coordinate: Coordinate,
        bitmap: Bitmap,
        colorRule: ColorIdentificationRule
    ): Boolean {
        val color = bitmap.getColor(coordinate.x.toInt(), coordinate.y.toInt())
        return colorRule.verificationRule(
            color.red().toInt(),
            color.blue().toInt(),
            color.green().toInt()
        )
    }


    /**
     * 区块找颜色 找到颜色则返回true
     */
    suspend fun findColorRule(
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
            colorRule.verificationRule(Color.red(it), Color.red(it), Color.red(it))
        } != null
    }

    /**
     * 区块找颜色 找到颜色则返回true
     */
    suspend fun findColorLike(
        pixelsInfo: PixelsInfo,
        bitmap: Bitmap,
        colorRule: String,
        tolerance: Int = 0
    ): Boolean {
        val pixels = IntArray(pixelsInfo.width * pixelsInfo.height)
        val baseColor = Color.parseColor(colorRule)
        val baseRed = Color.red(baseColor)
        val baseBlue = Color.blue(baseColor)
        val baseGreen = Color.green(baseColor)
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
            judgeColorSqrt(
                Color.red(it),
                Color.blue(it),
                Color.green(it),
                baseRed,
                baseBlue,
                baseGreen
            ) <= tolerance
        } != null
    }


    /******  下面的都是私有方法 ******************/
    //判断颜色的相似度,越相似值越小 最大是100
    private suspend fun judgeColorSqrt(
        imgRed: Int,
        imgBlue: Int,
        imgGreen: Int,
        imgColor: Color
    ): Int {
        val red = (imgColor.red() - imgRed) / 255
        val blue = (imgColor.blue() - imgBlue) / 255
        val green = (imgColor.green() - imgGreen) / 255
        val diff = kotlin.math.sqrt((red * red + blue * blue + green * green).toDouble())
        return (diff * 100).toInt()
    }

    private suspend fun judgeColorSqrt(
        imgRed: Int,
        imgBlue: Int,
        imgGreen: Int,
        baseRed: Int,
        baseBlue: Int,
        baseGreen: Int,
    ): Int {
        val red = (baseRed - imgRed) / 255
        val blue = (baseBlue - imgBlue) / 255
        val green = (baseGreen - imgGreen) / 255
        val diff = kotlin.math.sqrt((red * red + blue * blue + green * green).toDouble())
        return (diff * 100).toInt()
    }

    //判断颜色的相似度,越相似值越小 最大是100
    private suspend fun judgeColorSqrt(baseColor: Color, imgColor: Color): Int {
        val red = (imgColor.red() - baseColor.red()) / 255
        val blue = (imgColor.blue() - baseColor.blue()) / 255
        val green = (imgColor.green() - baseColor.green()) / 255
        val diff = kotlin.math.sqrt((red * red + blue * blue + green * green).toDouble())
        return diff.toInt()
    }


}