package com.android.schedule.corelibrary.controller

import android.graphics.Bitmap
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.click.ClickTask
import com.android.schedule.corelibrary.img.img_rule.ImgTask
import com.android.schedule.corelibrary.img.img_rule.MultiFindImgTask
import com.android.schedule.corelibrary.utils.L

class ClickSpeedControl {

    val list = mutableListOf<ClickControlUnit>()


    fun addUnit(task: ImgTask, area: ClickArea) {
        list.add(ClickControlUnit(task, area))
    }

    fun addUnit(task: MultiFindImgTask, area: ClickArea) {
        task.list.forEach {
            list.add(ClickControlUnit(it, it.clickArea?:area))
        }
    }

    var maxCount = 3

    private var count = maxCount
    private var lastTAG = ""

    suspend fun checkImg(bitmap: Bitmap): ClickTask? {
        var clickTask: ClickTask? = null
        list.find { it.task.verificationRule(bitmap) }?.let {
            if (lastTAG == it.task.tag) {
                if (count <= 0) {
                    L.d( it.task.tag)
                    count = maxCount
                    clickTask = it.area.toClickTask(it.task)
                } else {
                    count--
                }
            } else {
                L.d( it.task.tag)
                lastTAG = it.task.tag
                count = maxCount
                clickTask = it.area.toClickTask(it.task)
            }
        }
        return clickTask
    }

}


class ClickControlUnit(val task: ImgTask, val area: ClickArea)