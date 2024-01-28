package com.android.system.calendar.excuter.nomarl

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.process_control.StuckJudePoint
import com.android.schedule.corelibrary.process_control.StuckPointMonitoring
import com.android.schedule.corelibrary.utils.L
import com.android.system.calendar.constant.GameStuckPoint
import kotlinx.coroutines.delay


//这个是挖图的
class XunLongFenJinFunction(
    acService: AccessibilityService, en: ImageEnvironment
) : BasicFunction(acService, en) {


    override suspend fun startFunction() {
        if (openActivityXianXia()) {
            var flag = true
            var count = 40
            while (flag && count > 0 && runSwitch) {
                if (!taskScreenL(screenshotIntervalF)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }
                if (en.isXunLongFenJinTask.check()) {
                    en.xunLongFenJinArea.c(en.isXunLongFenJinTask, repeatedClickInterval)
                } else if (en.isTotalCombatPowerTask.check()) {
                    en.clickUseArea.c()
                    flag = false
                }
                count--
            }
            if (!flag) {
                processListening()
            }
        }
    }


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
                if (en.isDungeonExitBtnTask.check()) {//這個正在副本立面
                    mAutoFightingRecorder.updateInfo()
                    if (mAutoFightingRecorder.isCloseErrorThresholds()) {
                        en.switchAutoFightArea.c()
                        mAutoFightingRecorder.clearUp()
                    }
                } else {
                    mAutoFightingRecorder.updateInfo()
                    mAutoPathfindingRecorder.updateInfo()
                    if (mAutoFightingRecorder.isCloseErrorThresholds() && mAutoFightingRecorder.isCloseErrorThresholds()) {
                        mainStuckPoint.trustThreshold = 4
                    } else if (mAutoFightingRecorder.isCloseTrustThresholds() && mAutoFightingRecorder.isCloseTrustThresholds()) {
                        mainStuckPoint.trustThreshold = 8
                    } else {
                        mainStuckPoint.recordNoChange = 0
                    }
                    if (mainStuckPoint.gameIsStuck(screenBitmap!!)) { //如果卡点
                        runSwitch = false
                        return
                    }
                }

            } else if (en.isOpenTreasureChestsTask.check()) {
                var cout = 3
                val list = mutableListOf<Int>()
                while (cout > 0){
                    val tD = (Math.random()*en.treasureChestsList.size).toInt()
                    if(tD!=null && !list.contains(tD)){
                        en.treasureChestsList.getOrNull(tD)?.c()
                        delay(clickInterval)
                        cout--
                    }
                }
                en.closeTreasureChestsArea.c()
                mAutoFightingRecorder.clearUp()
                mAutoPathfindingRecorder.clearUp()
            }

            clickSpeedControl.cc()
        }
    }




}