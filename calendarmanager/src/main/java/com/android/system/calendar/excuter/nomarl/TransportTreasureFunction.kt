package com.android.system.calendar.excuter.nomarl

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.process_control.StuckJudePoint
import com.android.schedule.corelibrary.process_control.StuckPointMonitoring
import com.android.schedule.corelibrary.utils.L
import com.android.system.calendar.constant.GameStuckPoint
import kotlinx.coroutines.delay

// 跑標 完成待测试
class TransportTreasureFunction(
    acService: AccessibilityService, en: ImageEnvironment
) : BasicFunction(acService, en) {

    var mCount = 3;
    private val minitiateDialogRecorder = en.findInitiateDialogueBtnTask.toStatusRecorder(2, 5)

    override suspend fun startFunction() {
        while (mCount > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }else{
                if (pickTask()) {
                    processListening()
                } else {
                    L.d("pickTask Faild")
                    runSwitch = false
                }
            }
        }

    }

    private suspend fun pickTask(): Boolean {
        L.d("pickTask")
        return if (mCount == 3) {
            openByActivity()
        } else {
            if (!openByTaker()) {
                openByActivity()
            } else {
                true
            }
        }
    }


    private suspend fun openByTaker(): Boolean {
        var flag = true
        var count = 30
        while (mCount>-2 && flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.isTotalCombatPowerTask.check()) {
                if (en.findInitiateDialogueBtnTask.check()) {
                    en.initiateDialogueBtnArea.c(
                        en.findInitiateDialogueBtnTask,
                        repeatedClickInterval
                    )
                } else {
                    count -= 10
                }
            } else {
                if (en.isHuodongDiloagTask.check() && en.isHuodongDiloagTopTask.check()) {
                    en.huodongDiloag1Area.c()
                    mCount--
                } else if (en.isTransportTreasureMenuTask.check()) {
                    flag = false
                    en.refreshTransportTreasureArea.c()
                    delay(clickInterval)
                    en.startTransportTreasureArea.c()
                } else if (en.isSkipPlotFlowTask.check()) {
                    en.skipPlotFlowArea.c()
                } else if (en.isTipsDetermineTask.check()) {
                    en.tipsDetermineArea.c()
                } else if (en.findCloseBtnTask.check()) {
                    en.closeBtnArea.c(en.findCloseBtnTask)
                }
            }
        }
        return !flag
    }

    private suspend fun openByActivity(): Boolean {
        if (openActivityTiaoZhan()) {
            var flag = true
            var count = 40
            while (mCount>-2 && flag && count > 0 && runSwitch) {
                if (!taskScreenL(screenshotIntervalF)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }
                if (en.findTransportTreasureTaskTask.check()) {
                    en.startTransportTreasureTaskArea.c(
                        en.findTransportTreasureTaskTask,
                        repeatedClickInterval
                    )
                } else if (en.isHuodongDiloagTask.check() && en.isHuodongDiloagTopTask.check()) {
                    en.huodongDiloag1Area.c()
                    mCount--
                } else if (en.isTransportTreasureMenuTask.check()) {
                    flag = false
                    en.refreshTransportTreasureArea.c()
                    delay(clickInterval)
                    en.startTransportTreasureArea.c()
                } else if (en.isSkipPlotFlowTask.check()) {
                    en.skipPlotFlowArea.c()
                } else if (en.isTipsDetermineTask.check()) {
                    en.tipsDetermineArea.c()
                }
                count--
            }
            return !flag
        }
        return false
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
        clickSpeedControl.removeUnit(en.isHuodongDiloagTask.tag)
        while (runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.isTotalCombatPowerTask.check()) {//正在主界面
                L.d("正在主界面")
                clickSpeedControl.clearTag()
                minitiateDialogRecorder.updateInfo()
                mAutoPathfindingRecorder.updateInfo()

                //对话框出来次数够了就进行下一个
                if (minitiateDialogRecorder.isOpenTrustThresholds()) {
                    if (clickTransportTreasureTask())
                        return
                }

                if (mAutoPathfindingRecorder.isCloseErrorThresholds()) {
                    mainStuckPoint.trustThreshold = 3
                } else if (mAutoPathfindingRecorder.isCloseTrustThresholds()) {
                    mainStuckPoint.trustThreshold = 5
                } else {
                    mainStuckPoint.recordNoChange = 0
                }
                if (mainStuckPoint.gameIsStuck(screenBitmap!!)) { //如果卡点
                    if (clickTransportTreasureTask())
                        return
                }
            } else {
                L.d("不在主界面")
                mainStuckPoint.recordNoChange = 0
                mAutoPathfindingRecorder.clearUp()
                minitiateDialogRecorder.clearUp()
                clickSpeedControl.cc()
            }
        }
    }

    //如果没有运镖任务就默认这一次完成
    private suspend fun clickTransportTreasureTask(): Boolean {
        var flag = true
        var count = 5
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.isTotalCombatPowerTask.check()) {
                if (en.isTransportTreasureTypeTask.check()) {
                    en.transportTreasureTypeArea.c(en.isTransportTreasureTypeTask)
                    flag = false
                } else {
                    delay(clickInterval)
                }
                count--
            } else {
                flag = false
            }
        }
        return flag
    }


}