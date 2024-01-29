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


    private val minitiateDialogRecorder = en.findInitiateDialogueBtnTask.toStatusRecorder(2, 20)
    private val mFindMerchantDestination = FindMerchantDestination(en.isFindMerchantMapLocationTask)
    override suspend fun startFunction() {
        while (mCount > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            } else {
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
        while (mCount > -1 && flag && count > 0 && runSwitch) {
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
                } else if (en.isSkipPlotFlowTask.check()) {
                    en.skipPlotFlowArea.c()
                } else if (en.isTipsDetermineTask.check()) {
                    flag = false
                    en.tipsDetermineArea.c()
                } else if (en.findCloseBtnTask.check()) {
                    en.closeBtnArea.c(en.findCloseBtnTask)
                }
            }
        }
        return !flag
    }

    private suspend fun openByActivity(): Boolean {
        if (openActivityXianXia()) {
            var flag = true
            var count = 40
            while (mCount > -1 && flag && count > 0 && runSwitch) {
                if (!taskScreenL(screenshotIntervalF)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }
                if (en.findBangShangTaskTask.check()) {
                    en.startBangShangTaskArea.c(
                        en.findBangShangTaskTask,
                        repeatedClickInterval
                    )
                } else if (en.isHuodongDiloagTask.check() && en.isHuodongDiloagTopTask.check()) {
                    en.huodongDiloag1Area.c()
                    mCount--
                } else if (en.isSkipPlotFlowTask.check()) {
                    en.skipPlotFlowArea.c()
                } else if (en.isTipsDetermineTask.check()) {
                    flag = false
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
        val mainStuckPoint = getMainStuckPointMonitoring()

        var hasByGood = false
        val clickSpeedControl = getNormalClickSpeedControl()
        clickSpeedControl.removeUnit(en.isPurchaseItem2Task.tag)
        clickSpeedControl.removeUnit(en.isPurchaseItemTask.tag)
        while (mCount > -1 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.isTotalCombatPowerTask.check()) {//正在主界面
                L.d("正在主界面")
                minitiateDialogRecorder.updateInfo()
                mAutoPathfindingRecorder.updateInfo()

                if (hasByGood) {
                    clickTransportTreasureTask()
                    hasByGood = false
                    continue
                }
                //对话框出来次数够了就进行下一个
                if (minitiateDialogRecorder.isOpenTrustThresholds()) {
                    en.initiateDialogueBtnArea.c(en.findInitiateDialogueBtnTask)
                    continue
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
            } else if (en.isHuodongDiloagTask.check()) {
                if (en.isHuodongDiloagTopTask.check()) {//这里表示又进入跑商任务了
                    en.huodongDiloag1Area.c()
                    mCount--
                    continue
                } else {
                    en.huodongDiloag2Area.c()
                    continue
                }
            } else if (en.isMerchantShopTask.check()) {//跑商商店
                if (en.isMerchantNoSellGoodTask.check()) {
                    en.swtitchMerchantBuyArea.c()
                } else if (en.isMerchantSellAllTask.check()) {
                    en.merchantSellAllArea.c()
                } else {
                    val rand = Math.random()
                    if (rand > 0.7) {
                        en.clickArea12.c()
                    } else if (rand > 0.05) {
                        en.clickArea21.c()
                    } else {
                        en.clickArea11.c()
                    }
                }
            } else if (en.isListOfAcquisitionsTask.check()) {
                en.maxBuyNumberArea.c()
                delay(clickInterval)
                en.buyGodArea.c()
                delay(clickInterval)
                en.closeMerchantShop.c()
                delay(clickInterval)
                hasByGood = true
            } else if (en.isMerchantMapTask.check()) {
                if (mFindMerchantDestination.verificationRule(screenBitmap)) {
                    mFindMerchantDestination.resultMerchantLocation?.clickArea?.c(
                        repeatedClickInterval
                    )
                }
            } else if (en.isMerchantQianWangTask.check()) {
                en.merchantQianWangArea.c()
            } else {
                L.d("不在主界面")
                mainStuckPoint.recordNoChange = 0
                mAutoPathfindingRecorder.clearUp()
                minitiateDialogRecorder.clearUp()
            }
            clickSpeedControl.cc()
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
        return flag
    }

}