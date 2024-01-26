package com.android.schedule.corelibrary.controller

import android.graphics.Bitmap
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.click.ClickTask
import com.android.schedule.corelibrary.img.img_rule.ImgTask
import com.android.schedule.corelibrary.img.img_rule.MultiFindImgTask
import com.android.schedule.corelibrary.utils.L

class ClickSpeedControl {

    val list = mutableListOf<ClickControlImpl>()


    fun addUnit(task: ImgTask, area: ClickArea, singleFlag: Boolean = false) {
        list.add(ClickControlUnit(task, area, singleFlag))
    }

    fun addUnit(task: ImgTask, clickList: List<ClickArea>, singleFlag: Boolean = false) {
        list.add(ClickControlUnitV2(task, clickList, singleFlag))
    }

    fun addUnit(task: MultiFindImgTask, area: ClickArea) {
        task.list.forEach {
            list.add(ClickControlUnit(it, it.clickArea ?: area))
        }
    }


    var maxCount = 3

    private var count = maxCount
    private var lastTAG = ""

    fun clearTag() {
        lastTAG = ""
    }

    private var isSingleUseLapse: ClickControlImpl? = null

    suspend fun checkImg(bitmap: Bitmap): ClickControlResult {
        val result = ClickControlResult()
        list.find { it.task.verificationRule(bitmap) }?.let {
            result.tag = it.task.tag
            //这里是单次使用的
            if (isSingleUseLapse != null && isSingleUseLapse!!.task.tag != it.task.tag) {
                isSingleUseLapse = null
                list.remove(isSingleUseLapse)
            }
            if (lastTAG == it.task.tag) {
                if (count <= 0) {
                    L.d(it.task.tag)
                    if (it.isSingleUse()) {
                        isSingleUseLapse = it
                    }
                    count = maxCount
                    result.clickTask = it.getClickArea().toClickTask(it.task)
                } else {
                    count--
                }
            } else {
                L.d(it.task.tag)
                if (it.isSingleUse()) {
                    isSingleUseLapse = it
                }
                lastTAG = it.task.tag
                count = maxCount
                result.clickTask = it.getClickArea().toClickTask(it.task)
            }
        } ?: let {
            lastTAG = ""
        }
        return result
    }

     fun removeUnit(tag: String) {
        val unit = list.find { it.task.tag == tag }
        list.remove(unit)
    }

}

abstract class ClickControlImpl(val task: ImgTask) {

    abstract fun getClickArea(): ClickArea

    abstract fun isSingleUse(): Boolean
}

class ClickControlUnit(task: ImgTask, val area: ClickArea, val singleFlag: Boolean = false) :
    ClickControlImpl(task) {
    override fun getClickArea(): ClickArea {
        return area
    }

    override fun isSingleUse(): Boolean {
        return singleFlag
    }
}

class ClickControlUnitV2(
    task: ImgTask,
    val areas: List<ClickArea>,
    val singleFlag: Boolean = false
) : ClickControlImpl(task) {
    override fun getClickArea(): ClickArea {
        return areas.getOrNull((Math.random() * areas.size).toInt()) ?: areas[0]
    }

    override fun isSingleUse(): Boolean {
        return singleFlag
    }
}

class ClickControlResult(var tag: String? = null, var clickTask: ClickTask? = null)