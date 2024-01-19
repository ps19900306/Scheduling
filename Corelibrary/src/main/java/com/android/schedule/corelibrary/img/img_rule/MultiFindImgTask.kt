package com.android.schedule.corelibrary.img.img_rule

import android.graphics.Bitmap

/**
create by: 86136
create time: 2023/7/4 11:07
Function description:
 */

class MultiFindImgTask(val list: Array<FindImgTask>) : BasicImgTask() {

     var lastResult: FindImgTask? = null

    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        lastResult = list.find { it.verificationRule(bitmap) }
        return lastResult != null
    }

    override fun getOffsetX(): Int {
        return lastResult?.getOffX()?:0
    }

    override fun getOffsetY(): Int {
        return lastResult?.getOffY()?:0
    }

//    constructor(vararg imgTaskImpl1: FindImgTask) : this(mutableListOf<FindImgTask>().apply {
//        this.addAll(imgTaskImpl1)
//    }.toTypedArray())
}