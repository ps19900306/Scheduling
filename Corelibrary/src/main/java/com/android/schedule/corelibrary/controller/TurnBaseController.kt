package com.android.schedule.corelibrary.controller

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.click.ClickTask
import com.android.schedule.corelibrary.click.SimpleClickUtils
import com.android.schedule.corelibrary.exhaustion.*
import kotlinx.coroutines.delay

/**
create by: 86136
create time: 2023/8/28 10:06
Function description:
 */

abstract class TurnBaseController(
    acService: AccessibilityService,
    onEnd: () -> Unit,
) : BaseController(acService, onEnd) {


    override fun start() {

    }

    override fun end() {

    }

    override fun onPause() {

    }

    override fun onResume() {

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
}
