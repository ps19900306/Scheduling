package com.nwq.function.corelib.img.task

import android.graphics.Bitmap

/**
create by: 86136
create time: 2023/7/4 11:07
Function description:
 */

class MultiImgTask(val list: Array<ImgTaskImpl1>) : BasicImgTask() {

    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        return list.find { it.verificationRule(bitmap) } != null
    }

    fun copyOffset(tag: String, offsetX: Int, offsetY: Int): MultiImgTask {
        val newImgTaskImpl1 = mutableListOf<ImgTaskImpl1>()
        list.forEach {
            newImgTaskImpl1.add(it.copyOffset(tag, offsetX, offsetY))
        }
        return MultiImgTask(newImgTaskImpl1.toTypedArray())
    }
}