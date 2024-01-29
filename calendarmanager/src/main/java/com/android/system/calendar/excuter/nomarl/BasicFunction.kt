package com.android.system.calendar.excuter.nomarl

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.controller.ClickSpeedControl
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.process_control.StuckJudePoint
import com.android.schedule.corelibrary.process_control.StuckPointMonitoring
import com.android.system.calendar.constant.GameStuckPoint
import kotlinx.coroutines.delay

abstract class BasicFunction(
    acService: AccessibilityService, val en: ImageEnvironment
) : TurnBaseController(acService) {


    protected val mAutoFightingRecorder = en.isAutoFightingTask.toStatusRecorder(3, 10)
    protected val mAutoPathfindingRecorder = en.isAutomaticPathfindingTask.toStatusRecorder(3, 10)
    protected val ABNORMAL_SCREENO_ORIENTATION = ""
    protected suspend fun reportingError(s: String) {
        runSwitch = false
    }

    //打开活动任务必做
    protected suspend fun openActivityNeed(): Boolean {
        var flag = true
        var count = 20
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
            } else if (en.findCloseBtnTask.check()) {
                en.closeBtnArea.c(en.findCloseBtnTask, jumpClickInterval)
            } else {
                pressBackBtn()
            }
            count--
        }
        return !flag
    }


    //打开活动任务必做
    protected suspend fun openActivityXianXia(): Boolean {
        var flag = true
        var count = 20
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isActivityMenuBtnTask.check()) {
                en.activityMenuBtnArea.c(jumpClickInterval)
            } else if (en.isOpenActivityMenuTask.check()) {
                if (en.isActivityXianXiaTask.check()) {
                    en.activityXianXiaArea.c(jumpClickInterval)
                } else {
                    flag = false
                }
            } else if (en.findCloseBtnTask.check()) {
                en.closeBtnArea.c(en.findCloseBtnTask, jumpClickInterval)
            } else {
                pressBackBtn()
            }
            count--
        }
        return !flag
    }


    protected suspend fun openActivityTiaoZhan(): Boolean {
        var flag = true
        var count = 20
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isActivityMenuBtnTask.check()) {
                en.activityMenuBtnArea.c(jumpClickInterval)
            } else if (en.isOpenActivityMenuTask.check()) {
                if (en.isActivityChallengeTask.check()) {
                    en.activityChallengeBtnArea.c(jumpClickInterval)
                } else {
                    flag = false
                }
            } else if (en.findCloseBtnTask.check()) {
                en.closeBtnArea.c(en.findCloseBtnTask, jumpClickInterval)
            } else {
                pressBackBtn()
            }
            count--
        }
        return !flag
    }

    protected fun getNormalClickSpeedControl(): ClickSpeedControl {
        val clickSpeedControl = ClickSpeedControl()
        clickSpeedControl.addUnit(en.isSkipPlotFlowTask, en.skipPlotFlowArea)
        clickSpeedControl.addUnit(en.isClickUseTask, en.clickUseArea)
        clickSpeedControl.addUnit(en.isClickUse2Task, en.clickUseArea)
        clickSpeedControl.addUnit(en.isClickEquipTask, en.clickUseArea)
        clickSpeedControl.addUnit(en.isTipsDetermineTask, en.tipsDetermineArea)
        clickSpeedControl.addUnit(en.isHuodongDiloagTask, en.huodongDiloag2Area)
        clickSpeedControl.addUnit(en.isItemsInDemandTask, en.itemsInDemandArea)
        clickSpeedControl.addUnit(en.isANewFriendshipTask, en.closeFriendshipArea)
        clickSpeedControl.addUnit(en.isEnableNewFeaturesTask, en.isEnableNewFeaturesArea)

        clickSpeedControl.addUnit(en.isTaskGoShopTask, en.taskGoShopArea)
        clickSpeedControl.addUnit(en.isShenDianMoShiTask, en.closeShenDianMoShiArea)

        // clickSpeedControl.addUnit(en.isPurchaseItem2Task, en.closePurchaseItem2Area)
        clickSpeedControl.addUnit(en.isPurchaseItem2Task, en.isPurchaseItem2Area)

        clickSpeedControl.addUnit(en.isPlayShopMenuTask, en.closePlayShopMenuArea)


        clickSpeedControl.addUnit(en.isSubmitItemsTask, en.submitItemArea)
        clickSpeedControl.addUnit(
            en.hasDialogueSelectionBoxTask,
            listOf(en.dialogueSelectionBox1Area, en.dialogueSelectionBox2Area)
        )
        clickSpeedControl.addUnit(en.isTradeMenuTask, en.closeTradeMenuArea)
        return clickSpeedControl
    }


    suspend fun switchRole(roleNumber: Int): Boolean {
        var flag = true
        var count = 20
        var hasSelect = false
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isTotalCombatPowerTask.check()) {
                if (hasSelect)
                    return true
                if (en.isSystemSetBtnTask.check()) {
                    en.systemSetBtnArea.c(repeatedClickInterval)
                } else {
                    en.switchMainMenuBtnArea.c(repeatedClickInterval)
                }
            } else if (en.isOpenSettingMenuTask.check()) {
                if (en.isSystemSetMenuTask.check()) {
                    en.systemSetMenuBtnArea.c(repeatedClickInterval)
                } else {
                    en.switchRoleArea.c()
                }
            } else if (en.isDeleteRoleTask.check()) {
                en.selcetRoleAreaList.getOrNull(roleNumber - 1)?.c()
                delay(jumpClickInterval)
                en.roleEnterGameArea.c()
                hasSelect = true
            }
            count--
        }
        return !flag
    }


   protected fun getMainStuckPointMonitoring(): StuckPointMonitoring {
        return StuckPointMonitoring(
            GameStuckPoint.HOME_SCREEN_REMAIN, { true }, listOf(
                StuckJudePoint(1152, 34),
                StuckJudePoint(1256, 28),
                StuckJudePoint(1150, 83),
            ), 5
        )
    }


    abstract suspend fun startFunction()
}