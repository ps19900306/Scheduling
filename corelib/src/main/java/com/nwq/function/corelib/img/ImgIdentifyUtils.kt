package com.nwq.function.corelib.img

import android.graphics.Bitmap
import com.nwq.function.corelib.img.pcheck.PointRule
import com.nwq.function.corelib.img.task.ImgTask
import com.nwq.function.corelib.img.task.ImgTaskImpl1
import com.nwq.function.corelib.img.task.ImgTaskImpl2
import com.nwq.function.corelib.img.task.ImgTaskImpl3

/**
create by: 86136
create time: 2023/5/5 10:36
Function description:
 */

object ImgIdentifyUtils {

    fun verifyTheImageRule(bitmap: Bitmap, imgTask: ImgTask): Boolean {
        if (imgTask is ImgTaskImpl1) {

        } else if (imgTask is ImgTaskImpl2) {

        } else if (imgTask is ImgTaskImpl3) {

        }
        return true
    }


    private fun verifyImgTaskImpl1(bitmap: Bitmap, task: ImgTaskImpl1): Boolean {
        val first = task.iprList[0]
        if ((!task.isCorrect() || task.faultTolerance) && first is PointRule) {

        } else {

        }
        return true
    }


    private fun verifyTaskRange(bitmap: Bitmap, pr: PointRule, task: ImgTaskImpl1) {
        if (task.xRange > 0 || task.yRange > 0) {
            val width = if (task.xRange > 0) {
                task.xRange * 2 + 1
            } else {
                1
            }

            val height = if (task.yRange > 0) {
                task.yRange * 2 + 1
            } else {
                1
            }
            val size = width * height
            val startX = pr.getCoordinatePoint().xI - task.xRange
            val startY = pr.getCoordinatePoint().yI - task.yRange

            val pixels = IntArray(size)
            bitmap.getPixels(
                pixels,
                0,
                width,
                startX,
                startY,
                width,
                1
            )
            pixels.forEachIndexed { index, colorInt ->
                if (pr.rule.optInt(colorInt)) {
                    if (width > 1 && height > 1) {
                        val offsetX = startX + index % width - pr.getCoordinatePoint().xI
                        val offsetY = startY + index / width - pr.getCoordinatePoint().yI
                    } else if (width > 1 && height == 1) {
                        val offsetX = startX + index - pr.getCoordinatePoint().xI
                        val offsetY = 0
                    } else if (width == 1 && height > 1) {
                        val offsetX = 0
                        val offsetY = startY + index - pr.getCoordinatePoint().yI
                    } else {
                        val offsetX = 0
                        val offsetY = 0
                    }
                }
            }
        }
    }

    private fun verifyTaskRange(
        bitmap: Bitmap,
        offsetX: Int,
        offsetY: Int,
        task: ImgTask
    ): Boolean {
        return true
    }


}