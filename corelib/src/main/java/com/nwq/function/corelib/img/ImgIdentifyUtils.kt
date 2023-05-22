package com.nwq.function.corelib.img

import android.graphics.Bitmap
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
        return true
    }
}