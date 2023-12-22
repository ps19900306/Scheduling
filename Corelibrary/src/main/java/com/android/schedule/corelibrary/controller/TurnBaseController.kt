package com.android.schedule.corelibrary.controller

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.click.ClickTask
import com.android.schedule.corelibrary.click.SimpleClickUtils
import com.android.schedule.corelibrary.exhaustion.*
import com.android.schedule.corelibrary.img.img_rule.BasicImgTask
import com.android.schedule.corelibrary.img.img_rule.ImgTask
import com.android.schedule.corelibrary.img.img_rule.ImgTaskImpl1
import com.android.schedule.corelibrary.utils.L
import kotlinx.coroutines.delay

/**
create by: 86136
create time: 2023/8/28 10:06
Function description:
 */
abstract class TurnBaseController(
    acService: AccessibilityService,
) : BaseController(acService) {

    val STANDARD_CLICK_INTERVAL = 2000


    //这个是不需要跳转的点击间隔 但是非连续点击
    val clickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.4 + 0.4)).toLong()


    //这个是需要跳转的点击间隔
    val jumpClickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 1 + 1.6)).toLong()


    //这个是截屏的间隔
    val screenshotIntervalF
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.5 + 1)).toLong()

    //这个是截屏的间隔
    val screenshotInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 1 + 1.6)).toLong()


    //这个是需要等待时间多一些
    val tripleClickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.8 + 2.4)).toLong()

    override fun start() {

    }

    override fun end() {

    }

    override fun onPause() {

    }

    override fun onResume() {

    }

    protected suspend fun click(imgTask: BasicImgTask, clickArea: ClickArea) {
        click(clickArea, imgTask.getOffsetX(), imgTask.getOffsetY())
    }


    protected suspend fun click(
        clickArea: ClickArea,
        offsetX: Int = 0,
        offsetY: Int = 0,
    ) {
        optClickTask(clickArea.toClickTask(0, offsetX, offsetY))
    }

    protected suspend fun click(
        listArea: List<ClickArea>?,
        offsetX: Int = 0,
        offsetY: Int = 0,
        canMiss: Boolean = false,
    ) {
        if (listArea.isNullOrEmpty()) return
        mOptAsynch?.getOptInfo()
        val list = areaToClickTask(listArea, offsetX, offsetY, canMiss)
        optClickTask(list)
    }


    protected suspend fun optClickTask(
        clickTask: ClickTask, offsetX: Int = 0, offsetY: Int = 0
    ) {
        if (mOptAsynch == null) {
            SimpleClickUtils.optClickTasks(acService, 0, 0, clickTask)
        } else if (mOptAsynch is OptAsynchNet) {
            mOptAsynch!!.requestedOperation()
            SimpleClickUtils.optClickTasks(acService, 0, 0, clickTask)
            mOptAsynch!!.operationEnded()
        } else if (mOptAsynch is OptAsynchTime) {
            val waitTime = mOptAsynch?.getOptInfo()?.waitTime ?: 0
            if (waitTime > 0) {
                delay(waitTime)
                SimpleClickUtils.optClickTasks(acService, 0, 0, clickTask)
            }
        }
    }

    protected suspend fun optClickTask(
        list: List<ClickTask>, offsetX: Int = 0, offsetY: Int = 0
    ) {
        if (mOptAsynch == null) {
            SimpleClickUtils.optClickTasks(acService, 0, 0, *list.toTypedArray())
        } else if (mOptAsynch is OptAsynchNet) {
            mOptAsynch!!.requestedOperation()
            SimpleClickUtils.optClickTasks(acService, 0, 0, *list.toTypedArray())
            mOptAsynch!!.operationEnded()
        } else if (mOptAsynch is OptAsynchTime) {
            val optInfo = mOptAsynch!!.getOptInfo()!!
            val taskList = list.filter { it.delayTime + it.duration < optInfo.optTimeLong }
            if (optInfo.waitTime > 0) {
                delay(optInfo.waitTime)
            }
            SimpleClickUtils.optClickTasks(acService, 0, 0, *taskList.toTypedArray())
        }
    }

    fun areaToClickTask(
        list: List<ClickArea>,
        offsetX: Int = 0,
        offsetY: Int = 0,
        canMiss: Boolean = false,
    ): List<ClickTask> {
        val resultList = mutableListOf<ClickTask>()
        var delayTime = 0L
        list.forEach {
            if (canMiss && ExhaustionControl.getOptInterval() < OptInterval.FAILURE) {
                val task = it.toClickTask(delayTime, offsetX, offsetY)
                delayTime = delayTime + task.delayTime + task.duration
                resultList.add(task)
            }
        }
        return resultList
    }


    protected var mOptAsynch: BasicOptAsynch? = null

    //这个是设置时间的的设置
    protected fun setOptAsynchTime(SecondSize: Int, denominator: Int, numerator: Int) {
        mOptAsynch = OptAsynchTime(SecondSize, denominator, numerator)
    }

    protected fun setOptAsynch(optAsynch: BasicOptAsynch) {
        mOptAsynch = optAsynch
    }


    protected suspend fun optTaskOperation(
        pTask: BasicImgTask? = null,//前置图片
        clickArea: ClickArea? = null,//点击区域
        eTask: BasicImgTask,//结束图片，出现这样的情况结束
        endClickArea: ClickArea? = null,//结束的店家
        times: Int = 5
    ): Boolean {
        var flag = true
        var count = times
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            if (eTask.check()) {
                endClickArea?.let { click(eTask, it) }
                flag = false
            }
            if (pTask != null) {
                if (pTask.check()) {
                    clickArea?.let {
                        click(pTask, it)
                        delay(clickInterval)
                    }
                }
            } else {
                clickArea?.let {
                    click(it)
                    delay(clickInterval)
                }
            }
        }
        return !flag
    }

    protected suspend fun optTaskOperationList(
        list: List<TaskOperation>,
        endTask: BasicImgTask,
        times: Int = 5
    ): Boolean {
        var flag = true
        var count = times
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            if (endTask.check()) {
                flag = false
                return true
            }
            list.forEach { taskOpt ->
                if (taskOpt.eTask?.check() == true) {
                    taskOpt.endClickArea?.let { click(taskOpt.eTask, it) }
                }
                if (taskOpt.pTask != null) {
                    if (taskOpt.pTask.check()) {
                        taskOpt.clickArea?.let { click(taskOpt.pTask, it) }
                    }
                } else {
                    taskOpt.clickArea?.let { click(it) }
                }
            }
            count--
        }
        return false
    }


}
