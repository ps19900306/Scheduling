package com.android.system.calendar.excuter.nomarl

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.process_control.StuckJudePoint
import com.android.schedule.corelibrary.process_control.StuckPointMonitoring
import com.android.schedule.corelibrary.utils.L
import com.android.system.calendar.constant.GameStuckPoint
import kotlinx.coroutines.delay

//帮会跑商
class BangMerchantFunction(
    acService: AccessibilityService, en: ImageEnvironment
) : BasicFunction(acService, en) {
    var mCount = 3;
    private val mAutoPathfindingRecorder = en.isAutomaticPathfindingTask.toStatusRecorder(5, 20)
    override suspend fun startFunction() {
        while (mCount > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                pickTask()
            }
        }

    }

    private suspend fun pickTask() {
        if (mCount == 3) {
            openByActivity()
        } else {
            openByTaker()
        }
    }


    private suspend fun openByTaker() {
        var flag = true
        var count = 40
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.findDivisionTaskTask.check()) {
                en.startDivisionArea.c(en.findDivisionTaskTask, repeatedClickInterval)
            } else if (en.isHuodongDiloagTask.check() && en.isHuodongDiloagTopTask.check()) {
                en.huodongDiloag1Area.c()
                flag = false
            } else if (en.isSkipPlotFlowTask.check()) {
                en.skipPlotFlowArea.c()
            } else if (en.isTipsDetermineTask.check()) {
                en.tipsDetermineArea.c()
            }
            count--
        }
    }

    private suspend fun openByActivity() {
        if (openActivityNeed()) {
            var flag = true
            var count = 40
            while (flag && count > 0 && runSwitch) {
                if (!taskScreenL(screenshotIntervalF)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }
                if (en.findDivisionTaskTask.check()) {
                    en.startDivisionArea.c(en.findDivisionTaskTask, repeatedClickInterval)
                } else if (en.isHuodongDiloagTask.check() && en.isHuodongDiloagTopTask.check()) {
                    en.huodongDiloag1Area.c()
                    flag = false
                } else if (en.isSkipPlotFlowTask.check()) {
                    en.skipPlotFlowArea.c()
                } else if (en.isTipsDetermineTask.check()) {
                    en.tipsDetermineArea.c()
                }
                count--
            }
        }
    }




    suspend fun processListening() {
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
                clickSpeedControl.clearTag()

                mAutoPathfindingRecorder.updateInfo()
                if (mAutoPathfindingRecorder.isCloseErrorThresholds()) {
                    mainStuckPoint.trustThreshold = 4
                } else if (mAutoPathfindingRecorder.isCloseTrustThresholds()) {
                    mainStuckPoint.trustThreshold = 6
                } else {
                    mainStuckPoint.recordNoChange = 0
                }
                if (mainStuckPoint.gameIsStuck(screenBitmap!!)) { //如果卡点
                    if(!clickMerchantTypeTask())
                        return
                }
            } else {
                L.d("不在主界面")
                mainStuckPoint.recordNoChange = 0
                mAutoPathfindingRecorder.clearUp()

                if (en.isPurchaseItemTask.check()) {
                    en.isPurchaseItemArea.c()
                    delay(jumpClickInterval)
                    if(!clickMerchantTypeTask())
                    return
                } else {
                    clickSpeedControl.cc()
                }
            }
        }
    }

    //这里如果没有师门任务就会 点击失败
    private suspend fun clickMerchantTypeTask():Boolean {
        var flag = true
        var count = 5
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.isTotalCombatPowerTask.check()) {
                if (en.isMerchantTypeTask.check()) {
                    en.startMerchantTypeArea.c(en.isMerchantTypeTask)
                    flag = false
                } else {
                    delay(clickInterval)
                }
                count--
            } else {
                flag = false
            }
        }
        if (flag) {
            mCount--
        }
        return !flag
    }

}