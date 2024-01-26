package com.android.schedule.corelibrary.img.img_rule

import android.graphics.Bitmap
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint

//这个可以用来读取数据
class NumberRecognitionTask(
    val list: List<NumberImgTask>, val findArea: CoordinateArea, //初始图片的寻找范围
    val isHorizontal: Boolean = true,
) : BasicImgTask() {


    var resultInt = 0
    var hasResult = false
    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        if (bitmap == null)
            return false

        var nowFindArea: CoordinateArea? = findArea;
        while (nowFindArea != null) {
            nowFindArea = findImgByColor(bitmap, nowFindArea)
        }

        return hasResult
    }

    private suspend fun findImgByColor(bitmap: Bitmap, area: CoordinateArea): CoordinateArea? {
        val pixels = IntArray(area.width * area.height)
        bitmap.getPixels(
            pixels, 0, area.width, area.x, area.y, area.width, area.height
        )
        pixels.forEachIndexed { offset, colorInt ->
            val result = list.find {
                it.checkImg(bitmap,colorInt) {
                    val c = findPoint(area, offset)
                    c
                }
            }
            if (result != null) {
                resultInt = resultInt * 10 + result.numberCount
                hasResult = true
                val newArea = if (isHorizontal) {
                    CoordinateArea(
                        area.x + result.width,
                        area.y,
                        area.width - result.width,
                        area.height
                    )
                } else {
                    CoordinateArea(
                        area.x,
                        area.y + result.height,
                        area.width,
                        area.height - result.height
                    )
                }
                if (newArea.width > 3 && newArea.height > 3) {
                    return newArea
                }
            }
        }
        return null
    }


    private fun findPoint(area: CoordinateArea, offset: Int): CoordinatePoint {
        return if (area.width > 1 && area.height > 1) {
            val x = area.x + offset % area.width
            val y = area.y + offset / area.width
            CoordinatePoint(x.toFloat(), y.toFloat())
        } else if (area.width > 1 && area.height == 1) {
            val x = area.x + offset
            val y = area.y
            CoordinatePoint(x.toFloat(), y.toFloat())
        } else if (area.width == 1 && area.height > 1) {
            val x = area.x
            val y = area.y + offset
            CoordinatePoint(x.toFloat(), y.toFloat())
        } else {
            CoordinatePoint(area.x, area.y)
        }
    }

}