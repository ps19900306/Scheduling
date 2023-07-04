package com.nwq.function.corelib.excuter.star_wars

import android.accessibilityservice.AccessibilityService
import com.nwq.function.corelib.Constant.normalClickInterval
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.excuter.BaseController
import com.nwq.function.corelib.excuter.EndLister
import com.nwq.function.corelib.img.task.BasicImgTask
import com.nwq.function.corelib.img.task.ImgTaskImpl1
import com.nwq.function.corelib.utils.sp.SPRepo
import com.nwq.function.corelib.utils.sp.SpConstant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
create by: 86136
create time: 2023/6/28 14:52
Function description:
 */

abstract class StarWarController(acService: AccessibilityService, endLister: EndLister? = null) :
    BaseController(acService, endLister) {


    var APP_LOCATION_Y = 1 //APP位于当前页的第一行
    val APP_LOCATION_X
        get() = if (SPRepo.role == SpConstant.PREFIX_ROLE1) {
            1
        } else {
            2
        }

    fun getAppArea(): CoordinateArea {
        return CoordinateArea(
            82 + (APP_LOCATION_X - 1) * 254,
            185 + (APP_LOCATION_Y - 1) * 291,
            154,
            153
        )
    }

    override fun startWork() {
        GlobalScope.launch(Dispatchers.Default) {
            // intoGame()
        }
    }

    //进入游戏的进入逻辑
    private suspend fun intoGame(endTask: ImgTaskImpl1, midList: List<ImgTaskImpl1>): Boolean {
        var flag = true
        var count = 300
        while (flag && count > 0 && runSwitch) {
            val bitmap = takeScreenBitmap(normalClickInterval)
            if (!bitmap.isOrientation()) {
                click(getAppArea().toClickTask())
                count--
            } else if (endTask.verificationRule(bitmap)) {
                flag = false
            } else {
                val nowTask = midList.find { it.verificationRule(bitmap) }
                if (nowTask == null) {
                    count--
                } else {
                    nowTask.clickArea?.toClickTask()?.let {
                        click(nowTask, it)
                    }
                }
            }
        }
        return !flag
    }

    private suspend fun executionResults(endTask: List<BasicImgTask>, midList: List<ImgTaskImpl1>): Boolean  {
        var flag = true
        var count = 300
        while (flag && count > 0 && runSwitch) {
            val bitmap = takeScreenBitmap(normalClickInterval)
            if (!bitmap.isOrientation()) {
                click(getAppArea().toClickTask())
                count--
            } else if (endTask.find { !it.verificationRule(bitmap) } == null) {
                flag = false
            } else {
                val nowTask = midList.find { it.verificationRule(bitmap) }
                if (nowTask == null) {
                    count--
                } else {
                    nowTask.clickArea?.toClickTask()?.let {
                        click(nowTask, it)
                    }
                }
            }
        }
        return !flag
    }
}