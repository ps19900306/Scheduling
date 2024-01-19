package com.android.schedule.corelibrary.controller

import android.graphics.Bitmap
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.click.ClickTask
import com.android.schedule.corelibrary.img.img_rule.ImgTask
import com.android.schedule.corelibrary.img.img_rule.MultiFindImgTask
import com.android.schedule.corelibrary.utils.L

class ClickSpeedControl {

    val list = mutableListOf<ClickControlImpl>()


    fun addUnit(task: ImgTask, area: ClickArea) {
        list.add(ClickControlUnit(task, area))
    }

    fun addUnit(task: ImgTask, clickList: List<ClickArea>) {
        list.add(ClickControlUnitV2(task, clickList))
    }

    fun addUnit(task: MultiFindImgTask, area: ClickArea) {
        task.list.forEach {
            list.add(ClickControlUnit(it, it.clickArea ?: area))
        }
    }

    var maxCount = 3

    private var count = maxCount
    private var lastTAG = ""

    suspend fun checkImg(bitmap: Bitmap): ClickControlResult {
        val result = ClickControlResult()
        list.find { it.task.verificationRule(bitmap) }?.let {
            result.tag = it.task.tag
            if (lastTAG == it.task.tag) {
                if (count <= 0) {
                    L.d(it.task.tag)
                    count = maxCount
                    result.clickTask = it.getClickArea().toClickTask(it.task)
                } else {
                    count--
                }
            } else {
                L.d(it.task.tag)
                lastTAG = it.task.tag
                count = maxCount
                result.clickTask = it.getClickArea().toClickTask(it.task)
            }
        }
        return result
    }



}

abstract class ClickControlImpl(val task: ImgTask) {

    abstract fun getClickArea(): ClickArea
}

class ClickControlUnit(task: ImgTask, val area: ClickArea) : ClickControlImpl(task) {
    override fun getClickArea(): ClickArea {
        return area
    }
}

class ClickControlUnitV2(task: ImgTask, val areas: List<ClickArea>) : ClickControlImpl(task) {
    override fun getClickArea(): ClickArea {
        return areas.getOrNull((Math.random() * areas.size).toInt()) ?: areas[0]
    }
}

class ClickControlResult(var tag: String? = null, var clickTask: ClickTask? = null)