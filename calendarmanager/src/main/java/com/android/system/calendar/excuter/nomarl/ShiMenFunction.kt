package com.android.system.calendar.excuter.nomarl

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.controller.ClickSpeedControl
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.process_control.StuckJudePoint
import com.android.schedule.corelibrary.process_control.StuckPointMonitoring
import com.android.schedule.corelibrary.utils.L
import com.android.system.calendar.constant.GameStuckPoint
import kotlinx.coroutines.delay

class ShiMenFunction(
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
                if (en.findDivisionTaskTask.check()) {
                    en.startDivisionArea.c(en.findDivisionTaskTask, repeatedClickInterval)
                } else if (en.isHuodongDiloagTask.check()) {
                    en.huodongDiloag2Area.c()
                    flag = false
                } else if (en.isSkipPlotFlowTask.check()) {
                    en.skipPlotFlowArea.c()
                    flag = false
                } else if (en.isShiMenTypeTask.check()) {
                    en.clickShiMenTypeArea.c(en.isShiMenTypeTask)
                    flag = false
                }
                count--
            }
            if (!flag) {
                processListening()
            }
        }
    }


    //这里如果没有师门任务就会 点击失败
    private suspend fun clickShiMenTypeTask() {
        var flag = true
        var count = 5
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.isTotalCombatPowerTask.check()) {
                if (en.isShiMenTypeTask.check()) {
                    en.clickShiMenTypeArea.c(en.isShiMenTypeTask)
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
        val mainStuckPoint = StuckPointMonitoring(
            GameStuckPoint.HOME_SCREEN_REMAIN, { true }, listOf(
                StuckJudePoint(1152, 34),
                StuckJudePoint(1256, 28),
                StuckJudePoint(1150, 83),
            ), 5
        )

        val clickSpeedControl = getNormalClickSpeedControl()
        while (runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }


            if (en.isTotalCombatPowerTask.check()) {//正在主界面
                L.d("正在主界面")
                if (en.isShiMenBuyTask.check()) {
                    en.shiMenBuyArea.c(en.isShiMenBuyTask)
                    L.d("點擊商會購買")
                    continue
                }
                mAutoFightingRecorder.updateInfo()
                mAutoPathfindingRecorder.updateInfo()
                if (mAutoFightingRecorder.isCloseErrorThresholds() && mAutoFightingRecorder.isCloseErrorThresholds()) {
                    mainStuckPoint.trustThreshold = 3
                } else if (mAutoFightingRecorder.isCloseTrustThresholds() && mAutoFightingRecorder.isCloseTrustThresholds()) {
                    mainStuckPoint.trustThreshold = 5
                } else {
                    mainStuckPoint.recordNoChange = 0
                }
                if (mainStuckPoint.gameIsStuck(screenBitmap!!)) { //如果卡点
                    clickShiMenTypeTask()
                    continue
                }
            } else {
                L.d("不在主界面")
                mainStuckPoint.recordNoChange = 0
                mAutoFightingRecorder.clearUp()
                mAutoPathfindingRecorder.clearUp()

                if (en.isPurchaseItemTask.check()) {
                    en.isPurchaseItemArea.c()
                    delay(jumpClickInterval)
                    clickShiMenTypeTask()
                    continue
                }
            }

            clickSpeedControl.cc()
        }
    }


}