package com.nwq.function.scheduling.core_code.img

import android.graphics.Bitmap
import android.graphics.Color
import androidx.core.graphics.red
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.PixelsInfo
import com.nwq.function.scheduling.utils.JsonUtil
import timber.log.Timber
import kotlin.math.abs


object ImgUtils {


    //通过颜色去找颜色最接近的点
    fun findPointByColor(
        bitmap: Bitmap,
        data: FindPointByColorTask,
        colorList: List<Int>,
        tolerance: Int = 25,
    ): Coordinate? {
        return findPointByColor(
            data.toPixelsInfo(),
            bitmap,
            colorList[0],
            colorList[1],
            colorList[2],
            tolerance
        )
    }

    //通过颜色去找颜色最接近的点
    suspend fun findImgByColor(
        bitmap: Bitmap,
        task: FindImgTask,
    ): Boolean {
        return if (task.pixelsInfo.width == 1 || task.pixelsInfo.height == 1) {
            findImgByColorLinear(bitmap, task)
        } else {
            findImgByColorBig(bitmap, task)
        }
    }


    private fun findImgByColorBig(
        bitmap: Bitmap,
        task: FindImgTask
    ): Boolean {
        val pixelsInfo = task.pixelsInfo
        val pixelsArray = mutableListOf<IntArray>()
        for (i in 0 until pixelsInfo.height) {
            val pixels = IntArray(pixelsInfo.width)
            bitmap.getPixels(
                pixels,
                pixelsInfo.offset,
                pixelsInfo.stride,
                pixelsInfo.startX,
                pixelsInfo.startY + i,
                pixelsInfo.width,
                1
            )
            pixelsArray.add(pixels)
        }

        pixelsArray.forEachIndexed { offsetY, pixels ->
            pixels.forEachIndexed { offsetX, colorInt ->
                val deviationValue = judgeColorSqrt(
                    Color.red(colorInt),
                    Color.blue(colorInt),
                    Color.green(colorInt),
                    task.colorList.getOrNull(0) ?: 0,
                    task.colorList.getOrNull(1) ?: 0,
                    task.colorList.getOrNull(2) ?: 0
                )

                if (deviationValue <= task.tolerance) {
                    val oX = (pixelsInfo.startX + offsetX - task.baseCoordinate.x).toInt()
                    val oY = (pixelsInfo.startY + offsetY - task.baseCoordinate.y).toInt()
                    if (performPointsColorVerification(
                            task.verifyList,
                            bitmap,
                            0,
                            oX,
                            oY
                        )
                    ) {
                        task.clickArea.forEach {
                            it.x = it.x + oX
                            it.y = it.y + oY
                        }
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun findImgByColorLinear(
        bitmap: Bitmap,
        task: FindImgTask
    ): Boolean {
        val pixelsInfo = task.pixelsInfo
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
        pixels.forEachIndexed { offset, colorInt ->
            val deviationValue = judgeColorSqrt(
                Color.red(colorInt),
                Color.blue(colorInt),
                Color.green(colorInt),
                task.colorList.getOrNull(0) ?: 0,
                task.colorList.getOrNull(1) ?: 0,
                task.colorList.getOrNull(2) ?: 0
            )

            if (deviationValue <= task.tolerance) {
                var oX = (pixelsInfo.startX - task.baseCoordinate.x).toInt()
                var oY = (pixelsInfo.startY - task.baseCoordinate.y).toInt()
                if (pixelsInfo.width == 1) {
                    oY = +offset
                } else {
                    oX = +offset
                }
                if (performPointsColorVerification(
                        task.verifyList,
                        bitmap,
                        0,
                        oX,
                        oY
                    )
                ) {
                    task.clickArea.forEach {
                        it.x = it.x + oX
                        it.y = it.y + oY
                    }
                    return true
                }
            }
        }
        return false
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
        return pixels.find { colorRule.optInt(it) } != null
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
        offsetX: Int = 0,
        offsetY: Int = 0,
    ): Boolean {
        var nowErrorCount = 0
        data.forEach {
            if (!performPointColorVerification(it, bitmap, offsetX, offsetY)) {
                nowErrorCount++
            }
            if (nowErrorCount > toleranceErrorNumber)
                return false
        }
        return true
    }


    //单点单规则判断
    private fun performPointColorVerification(
        data: PointColorVerification,
        bitmap: Bitmap,
        offsetX: Int = 0,
        offsetY: Int = 0,
    ): Boolean {
        return if (data is PointColorVerification.CoordinateColor) {
            if (data.range > 0) {
                findColorLike(
                    PixelsInfo.buildPixelsInfo(data.coordinate, data.range, offsetX, offsetY),
                    bitmap,
                    data.colorRule,
                    data.tolerance
                )
            } else {
                judgeColorLike(
                    data.coordinate,
                    bitmap,
                    data.colorRule,
                    data.tolerance,
                    offsetX,
                    offsetY
                )
            }
        } else if (data is PointColorVerification.CoordinateRule) {
            if (data.range > 0) {
                findColorRule(
                    PixelsInfo.buildPixelsInfo(data.coordinate, data.range, offsetX, offsetY),
                    bitmap,
                    data.rule
                )
            } else {
                judgeColorRule(data.coordinate, bitmap, data.rule, offsetX, offsetY)
            }
        } else if (data is PointColorVerification.TwoPointTask) {
            return performTwoPointTask(data, bitmap)
        } else {
            false
        }
    }


    //多点多规则颜色判断
    private fun performTwoPointTask(
        data: PointColorVerification.TwoPointTask,
        bitmap: Bitmap,
    ): Boolean {
        if (data.range > 0) {
            val width = data.range * 2 + 1
            val height = data.range * 2 + 1

            val startX1 = (data.coordinate1.x - data.range).toInt()
            val startY1 = (data.coordinate1.y - data.range).toInt()

            val startX2 = (data.coordinate2.x - data.range).toInt()
            val startY2 = (data.coordinate2.y - data.range).toInt()

            val pixels1 = IntArray(width * height)
            val pixels2 = IntArray(width * height)

            bitmap.getPixels(pixels1, 0, width, startX1, startY1, width, height)
            bitmap.getPixels(pixels2, 0, width, startX2, startY2, width, height)

            for (i in pixels1.indices) {
                if (data.twoPointComparison.optInt(
                        pixels1[i],
                        pixels1[i]
                    )
                ) {
                    return true
                }
            }
            return false
        } else {
            val pixel = bitmap.getPixel(data.coordinate1.x.toInt(), data.coordinate1.y.toInt())
            val pixel1 = bitmap.getPixel(data.coordinate2.x.toInt(), data.coordinate2.y.toInt())
            return data.twoPointComparison.optInt(
                pixel,
                pixel1
            )
        }
    }

    /**
     * 单点颜色判断 相似度
     */
    private fun judgeColorLike(
        coordinate: Coordinate,
        bitmap: Bitmap,
        colorRule: String,
        tolerance: Int = 0,
        offsetX: Int = 0,
        offsetY: Int = 0,
    ): Boolean {
        val color = bitmap.getPixel(coordinate.x.toInt() + offsetX, coordinate.y.toInt() + offsetY)
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
    private fun judgeColorRule(
        coordinate: Coordinate,
        bitmap: Bitmap,
        colorRule: ColorIdentificationRule,
        offsetX: Int = 0,
        offsetY: Int = 0,
    ): Boolean {
        val color = bitmap.getPixel(coordinate.x.toInt() + offsetX, coordinate.y.toInt() + offsetY)
        Timber.d(
            "x:${coordinate.x}  y:${coordinate.y} red: ${Color.red(color)}  , green: ${
                Color.green(
                    color
                )
            }  , blue: ${Color.blue(color)} judgeColorRule ImgUtils NWQ_ 2023/3/12"
        );
        return colorRule.optInt(color)
    }


    /**
     * 区块找颜色 找到颜色则返回true
     */
    private fun findColorLike(
        pixelsInfo: PixelsInfo,
        bitmap: Bitmap,
        colorRule: String,
        tolerance: Int = 0,
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
    ): Coordinate? {
        val baseColor = Color.parseColor(colorRule)
        val baseRed = Color.red(baseColor)
        val baseBlue = Color.blue(baseColor)
        val baseGreen = Color.green(baseColor)
        return findPointByColor(pixelsInfo, bitmap, baseRed, baseBlue, baseGreen, tolerance)
    }

    //通过颜色找坐标
    private fun findPointByColor(
        pixelsInfo: PixelsInfo,
        bitmap: Bitmap,
        baseRed: Int,
        baseBlue: Int,
        baseGreen: Int,
        tolerance: Int = 0
    ): Coordinate? {
        Timber.d(" ${JsonUtil.objectToString(pixelsInfo)}  tolerance:$tolerance  findPointByColor ImgUtils NWQ_ 2023/3/20");
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
        var lastDeviationValue = 255
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
                val y = pixelsInfo.startY + lastIndex / pixelsInfo.width
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
            null
        }
    }

    //判断长度血条位置
    fun judeLengthStatus(list: List<Coordinate>, rule: ColorIdentificationRule, bitmap: Bitmap): Int {
        list.forEachIndexed { index, coordinate ->
            val pixel = bitmap.getPixel(coordinate.x.toInt(), coordinate.y.toInt())
            if (rule.optInt(pixel)) {
                return index
            }
        }
        return list.size
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