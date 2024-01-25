package com.android.system.calendar.excuter.nomarl

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.controller.ClickSpeedControl
import com.android.schedule.corelibrary.controller.TurnBaseController

abstract class BasicFunction(
    acService: AccessibilityService, val en: ImageEnvironment
) : TurnBaseController(acService) {

    protected val ABNORMAL_SCREENO_ORIENTATION = ""
    protected suspend fun reportingError(s: String) {

    }

    //打开活动任务必做
    protected suspend fun openActivityNeed(): Boolean {
        var flag = true
        var count = 20
        val clickSpeedControl = ClickSpeedControl()
        clickSpeedControl.addUnit(en.isActivityMenuBtnTask, en.activityMenuBtnArea)
        clickSpeedControl.addUnit(en.isActivityNeedTask, en.activityNeedArea)

        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isActivityMenuBtnTask.check()) {
                en.activityMenuBtnArea.c(jumpClickInterval)
            } else if (en.isOpenActivityMenuTask.check()) {
                if (en.isActivityNeedTask.check()) {
                    en.activityNeedArea.c(jumpClickInterval)
                } else {
                    flag = false
                }
            }else if(en.findCloseBtnTask.check()){
                en.closeBtnArea.c(en.findCloseBtnTask,jumpClickInterval)
            }else{
                pressBackBtn()
            }
            count--
        }
        return !flag
    }


    abstract suspend fun startFunction()
}