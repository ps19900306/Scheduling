package com.nwq.function.corelib.img.task

import android.graphics.Bitmap

/**
create by: 86136
create time: 2023/7/4 11:07
Function description:
 */

class MultiImgTask(val list: List<ImgTask>) : BasicImgTask() {
    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        return list.find { it.verificationRule(bitmap) } != null
    }
}