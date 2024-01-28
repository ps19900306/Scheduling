package com.android.system.calendar.excuter.nomarl

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.controller.ClickSpeedControl
import com.android.schedule.corelibrary.process_control.StuckJudePoint
import com.android.schedule.corelibrary.process_control.StuckPointMonitoring
import com.android.schedule.corelibrary.utils.L
import com.android.system.calendar.constant.GameStuckPoint

//打图任务
class TreasureMapFunction(
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
                if (en.findTreasureMapTaskTask.check()) {
                    en.startTreasureMapTaskArea.c(en.findTreasureMapTaskTask, repeatedClickInterval)
                } else if (en.isHuodongDiloagTask.check()) {
                    en.huodongDiloag1Area.c()
                    flag = false
                }else if( en.isSkipPlotFlowTask.check()){
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
                clickSpeedControl.clearTag()
                mAutoFightingRecorder.updateInfo()
                mAutoPathfindingRecorder.updateInfo()
                if (mAutoFightingRecorder.isCloseErrorThresholds() && mAutoFightingRecorder.isCloseErrorThresholds()) {
                    mainStuckPoint.trustThreshold = 5
                } else if (mAutoFightingRecorder.isCloseTrustThresholds() && mAutoFightingRecorder.isCloseTrustThresholds()) {
                    mainStuckPoint.trustThreshold = 10
                } else {
                    mainStuckPoint.recordNoChange = 0
                }
                if (mainStuckPoint.gameIsStuck(screenBitmap!!)) { //如果卡点
                    //結束打图任务
                    runSwitch = false
                }
            } else {
                L.d("不在主界面")
                mainStuckPoint.recordNoChange = 0
                mAutoFightingRecorder.clearUp()
                mAutoPathfindingRecorder.clearUp()
                clickSpeedControl.cc()
            }
        }

    }


}