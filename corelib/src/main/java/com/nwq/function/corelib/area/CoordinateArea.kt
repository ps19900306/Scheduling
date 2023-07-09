package com.nwq.function.corelib.area

import android.graphics.Bitmap
import com.nwq.function.corelib.Constant.clickIntervals
import com.nwq.function.corelib.click.task.ClickTask

/**
create by: 86136
create time: 2023/5/5 10:47
Function description:
 */

class CoordinateArea(
    var x: Int,
    var y: Int,
    var width: Int,
    var height: Int,
    var offsetX: Int = 0,
    var offsetY: Int = 0
) {


    constructor(
        x: Float,
        y: Float,
        endX: Float,
        endY: Float,
    ) : this(x.toInt(), y.toInt(), (endX - x).toInt(), (endY - y).toInt(), 0, 0)

    fun setOffset(ofstX: Int, ofstY: Int) {
        offsetX = ofstX
        offsetY = ofstY
    }


    fun toClickTask(): ClickTask {
        return ClickTask(listOf(coordinate), 0, clickIntervals)
    }


    fun getBitmapPix(bitmap: Bitmap): IntArray {
        val pixels = IntArray(width * height)
        bitmap.getPixels(
            pixels,
            0,
            width,
            x,
            y,
            width,
            height
        )
        return pixels
    }


    //到底要不要帮扩边框
    fun getBitmapPixList(bitmap: Bitmap): MutableList<IntArray> {
        val list= mutableListOf<IntArray>()
        for (i in 0 until height)
        {
            val pixels = IntArray(width)
            bitmap.getPixels(
                pixels,
                0,
                width,
                x,
                y+i,
                width,
                1
            )
            list.add(pixels)
        }
        return list
    }


    val coordinate
        get() = CoordinatePoint(
            (x + (Math.random() * 0.6 + 0.2) * width).toFloat() + offsetX,
            (y + (Math.random() * 0.6 + 0.2) * height).toFloat() + offsetY
        )


    val fullCoordinate
        get() = CoordinatePoint(
            (x + Math.random() * width).toFloat() + offsetX,
            (y + Math.random() * height).toFloat() + offsetY
        )

}