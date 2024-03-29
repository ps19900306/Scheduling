package com.nwq.function.corelib.img.task

import android.graphics.Bitmap
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.img.pcheck.PointRule

/**
create by: 86136
create time: 2023/7/4 11:07
Function description:
这里主要是对文字识别，不同的可能不一样，但是确定后又不会变，这样减少一些不必要的
 */
class MultiImgContainmentTask(var list: Array<ImgTaskImpl1>?) : BasicImgTask() {

    var containmentTask: ImgTask? = null

    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        return if (containmentTask == null) {
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


    //根据偏差值构造新的找寻任务
    fun copyOffset(tag: String, offsetX: Int, offsetY: Int): MultiImgContainmentTask {
        val newImgTaskImpl1 = mutableListOf<ImgTaskImpl1>()
        list?.forEach {
            newImgTaskImpl1.add(it.copyOffset(tag, offsetX, offsetY))
        }
        return MultiImgContainmentTask(newImgTaskImpl1.toTypedArray())
    }


}