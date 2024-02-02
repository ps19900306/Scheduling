package com.android.schedule.corelibrary.img.img_rule

import android.graphics.Bitmap

/**
create by: 86136
create time: 2023/7/4 11:07
Function description:
 */

class MultiImgTask(var list: Array<ImgTaskImpl1>?, var everyRevalidation: Boolean = true) :
    BasicImgTask() {
    var containmentTask: ImgTask? = null
    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        return if (everyRevalidation || containmentTask == null) {
            containmentTask = list?.find { it.verificationRule(bitmap) }
            if (containmentTask != null) {
                list = null
                return true
            } else {
                return false
            }
        } else {
            containmentTask!!.verificationRule(bitmap)
        }
    }

    fun copyOffset(tag: String, offsetX: Int, offsetY: Int): MultiImgTask {
        val newImgTaskImpl1 = mutableListOf<ImgTaskImpl1>()
        list?.forEach {
            newImgTaskImpl1.add(it.copyOffset(tag, offsetX, offsetY))
        }
        return MultiImgTask(newImgTaskImpl1.toTypedArray())
    }
}