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

        return true
    }


    private fun verifyTaskRange(bitmap: Bitmap, pr: PointRule, task: ImgTaskImpl1) {

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