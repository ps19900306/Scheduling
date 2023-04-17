package com.nwq.function.scheduling.auto_code.utils

import android.graphics.Bitmap
import android.graphics.Color
import com.nwq.function.scheduling.core_code.Coordinate
import timber.log.Timber

object AutoUtils {

    //这里找周围单值颜色最高店用于颜色判断
    fun findPointByHighestSingle(
        coordinate: Coordinate,
        bitmap: Bitmap,
        range: Int = 2,
    ): Coordinate? {
        val width = range*2 + 1
        val height = range*2 + 1
        val startX = coordinate.x.toInt() - range
        val startY = coordinate.y.toInt() - range

        val pixels = IntArray(width * height)
        bitmap.getPixels(
            pixels, 0, width, startX, startY, width, height
        )
        var lastIndex = -1
        var lastDeviationValue = 0
        pixels.forEachIndexed { i, it ->
            val red = Color.red(it)
            val blue = Color.blue(it)
            val green = Color.green(it)
            Timber.d("$i red:$red  green:$green blue:$blue    findPointByHighestSingle AutoUtils NWQ_ 2023/4/16");
            if (red > lastDeviationValue) {
                lastDeviationValue = red
                lastIndex = i
                Timber.d("赋值 red $lastDeviationValue findPointByHighestSingle AutoUtils NWQ_ 2023/4/16");
            }
            if (blue > lastDeviationValue) {
                lastDeviationValue = blue
                lastIndex = i
                Timber.d("赋值 blue $lastDeviationValue findPointByHighestSingle AutoUtils NWQ_ 2023/4/16");
            }
            if (green > lastDeviationValue) {
                lastDeviationValue = green
                lastIndex = i
                Timber.d("赋值 green $lastDeviationValue findPointByHighestSingle AutoUtils NWQ_ 2023/4/16");
            }
        }
        Timber.d("lastIndex $lastIndex findPointByHighestSingle AutoUtils NWQ_ 2023/4/16");
        return if (lastIndex > 0) {
            if (width > 1 && height > 1) {
                val x = startX + lastIndex % width
                val y = startY + lastIndex / width
                Coordinate(x.toFloat(), y.toFloat())
            } else if (width > 1 && height == 1) {
                val x = startX + lastIndex
                val y = startY
                Coordinate(x.toFloat(), y.toFloat())
            } else if (width == 1 && height > 1) {
                val x = startX
                val y = startY + lastIndex
                Coordinate(x.toFloat(), y.toFloat())
            } else {
                Coordinate(startX.toFloat(), startY.toFloat())
            }
        } else {
            null
        }
    }


    //这里找周围全部值颜色最高店用于颜色判断
    fun findPointByHighestAll(
        coordinate: Coordinate,
        bitmap: Bitmap,
        range: Int = 2,
    ): Coordinate? {
        val width = range*2 + 1
        val height = range*2 + 1
        val startX = coordinate.x.toInt() - range
        val startY = coordinate.y.toInt() - range

        val pixels = IntArray(width * height)
        bitmap.getPixels(
            pixels, 0, width, startX, startY, width, height
        )
        var lastIndex = -1
        var lastDeviationValue = 0
        pixels.forEachIndexed { i, it ->
            val all = Color.red(it) + Color.blue(it) + Color.green(it)
            Timber.d("$i all:$all  findPointByHighestAll AutoUtils NWQ_ 2023/4/16");
            if (all > lastDeviationValue) {
                Timber.d("赋值 all $lastDeviationValue findPointByHighestAll AutoUtils NWQ_ 2023/4/16");
                lastDeviationValue = all
                lastIndex = i
            }
        }
        return if (lastIndex > 0) {
            if (width > 1 && height > 1) {
                val x = startX + lastIndex % width
                val y = startY + lastIndex / width
                Coordinate(x.toFloat(), y.toFloat())
            } else if (width > 1 && height == 1) {
                val x = startX + lastIndex
                val y = startY
                Coordinate(x.toFloat(), y.toFloat())
            } else if (width == 1 && height > 1) {
                val x = startX
                val y = startY + lastIndex
                Coordinate(x.toFloat(), y.toFloat())
            } else {
                Coordinate(startX.toFloat(), startY.toFloat())
            }
        } else {
            null
        }
    }


    fun findPointByLowestAll(
        coordinate: Coordinate,
        bitmap: Bitmap,
        range: Int = 2,
    ): Coordinate? {
        val width = range*2 + 1
        val height = range*2 + 1
        val startX = coordinate.x.toInt() - range
        val startY = coordinate.y.toInt() - range

        val pixels = IntArray(width * height)
        bitmap.getPixels(
            pixels, 0, width, startX, startY, width, height
        )
        var lastIndex = -1
        var lastDeviationValue = 255
        pixels.forEachIndexed { i, it ->
            val all = Color.red(it) + Color.blue(it) + Color.green(it)
            Timber.d("$i all:$all  findPointByLowestAll AutoUtils NWQ_ 2023/4/16");
            if (all < lastDeviationValue) {
                Timber.d("赋值 all $lastDeviationValue findPointByLowestAll AutoUtils NWQ_ 2023/4/16");
                lastDeviationValue = all
                lastIndex = i
            }
        }
        return if (lastIndex > 0) {
            if (width > 1 && height > 1) {
                val x = startX + lastIndex % width
                val y = startY + lastIndex / width
                Coordinate(x.toFloat(), y.toFloat())
            } else if (width > 1 && height == 1) {
                val x = startX + lastIndex
                val y = startY
                Coordinate(x.toFloat(), y.toFloat())
            } else if (width == 1 && height > 1) {
                val x = startX
                val y = startY + lastIndex
                Coordinate(x.toFloat(), y.toFloat())
            } else {
                Coordinate(startX.toFloat(), startY.toFloat())
            }
        } else {
            null
        }
    }
}