package com.android.system.calendar.excuter.nomarl

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.controller.ClickSpeedControl
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.process_control.StuckJudePoint
import com.android.schedule.corelibrary.process_control.StuckPointMonitoring
import com.android.schedule.corelibrary.utils.L
import com.android.system.calendar.constant.GameStuckPoint
import kotlinx.coroutines.delay

class MountainsRiversPaintingFunction(
    acService: AccessibilityService, en: ImageEnvironment
) : BasicFunction(acService, en) {


    override suspend fun startFunction() {
        if (openActivityNeed()) {
            var flag = true
            var count = 40
            while (flag && count > 0 && runSwitch) {
                if (!taskScreenL(screenshotIntervalF)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }
                if (en.findMountainsAndRiversTaskTask.check()) {
                    en.startMountainsAndRiversTaskArea.c(
                        en.findMountainsAndRiversTaskTask,
                        repeatedClickInterval
                    )
                } else if (en.isHuodongDiloagTask.check()) {
                    en.huodongDiloag1Area.c()
                    flag = false
                } else if (en.isSkipPlotFlowTask.check()) {
                    en.skipPlotFlowArea.c()
                    flag = false
                }
                count--
            }
            if (!flag) {
                processListening()
            }
        }
    }


    //這裏需要
    private suspend fun clickMountainsRiversPaintingTypeTask() {
        var flag = true
        var count = 5
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.isTotalCombatPowerTask.check()) {
                if (en.isMountainsRiversPaintingTypeTask.check()) {
                    en.mountainsRiversPaintingTypeArea.c(en.isMountainsRiversPaintingTypeTask)
                    flag = false
                } else {
                    delay(clickInterval)
                }
                count--
            } else {
                flag = false
            }
        }
        //这里如果没有任务就会结束
        runSwitch = !flag
    }


    //执行过程监听
    private suspend fun processListening() {
        L.d("执行监听")
        val mainStuckPoint = getMainStuckPointMonitoring()

        val clickSpeedControl = getNormalClickSpeedControl()

        var hasOpt = false
        while (runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.isTotalCombatPowerTask.check()) {//正在主界面

                L.d("正在主界面")
                clickSpeedControl.clearTag()
                mAutoFightingRecorder.updateInfo()
                mAutoPathfindingRecorder.updateInfo()
                if (en.isFindAViewBtnTask.check()) {
                    en.findAViewBtnArea.c(en.isFindAViewBtnTask)
                    mainStuckPoint.recordNoChange = 0
                } else {
                    if (hasOpt) {
                        runSwitch = false
                    }
                }
                if (mAutoFightingRecorder.isCloseErrorThresholds() && mAutoPathfindingRecorder.isCloseErrorThresholds()) {
                    mainStuckPoint.trustThreshold = 3
                } else if (mAutoFightingRecorder.isCloseTrustThresholds() && mAutoPathfindingRecorder.isCloseTrustThresholds()) {
                    mainStuckPoint.trustThreshold = 5
                } else {
                    mainStuckPoint.recordNoChange = 0
                }

                if (mainStuckPoint.gameIsStuck(screenBitmap!!)) { //如果卡点
                    //結束幫派任務
                    clickMountainsRiversPaintingTypeTask()
                }
            } else {
                if (en.isFindAViewBtn2Task.check()) {
                    hasOpt = true
                    en.findAViewBtn2Area.c()
                    delay(jumpClickInterval)
                    en.closeViewShareArea.c()
                    delay(jumpClickInterval)
                    en.closeBtnArea.c()
                    clickMountainsRiversPaintingTypeTask()
                } else {
                    if(hasOpt &&           en.findCloseBtnTask.check()){
                       en.closeBtnArea.c(en.findCloseBtnTask)
                    }
                }
            }
            clickSpeedControl.cc()
        }

    }


}