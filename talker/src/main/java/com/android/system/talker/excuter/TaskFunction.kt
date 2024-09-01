package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import android.text.TextUtils
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import com.android.schedule.corelibrary.SetConstant
import com.android.schedule.corelibrary.controller.StatusRecorder
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.TimeUtils
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.TaskDb
import com.android.system.talker.database.UserDb
import com.android.system.talker.enums.MenuType
import kotlinx.coroutines.delay


class TaskFunction(
    val taskDb: TaskDb, userDb: UserDb, dataBase: AppDataBase, acService: AccessibilityService
) : BaseFunctionControl(userDb, dataBase, acService) {

    val TAG = "际遇任务"

    override suspend fun endGame(eroMsg: String?) {
        if (TextUtils.isEmpty(eroMsg)) {
            taskDb.lastCompletionTime = System.currentTimeMillis()
            taskDb.errorStr = ""
        } else {
            taskDb.errorStr = TimeUtils.getNowTime() + eroMsg
        }
        dataBase.getTaskDao().update(taskDb)
    }

    override suspend fun getTag(): String {
        return TAG
    }


    override suspend fun startFunction() {
        L.d("$TAG startFunction")
        //先判断是不是新的一天需要做任务
        if (TimeUtils.isNewDay(taskDb.lastCompletionTime)) {
            var result = intoGame()
            if (!result) return
            if (checkCloneLocation(taskDb.baseMenuLocation, taskDb.baseCloneLocation)) {
                if (userDb.shipType != taskDb.shipType) {//如果船不一致则需要进行换船处理
                    var result = returnSpaceStation(taskDb.baseMenuLocation)
                    if (!result) return

                    result = checkShip(taskDb.shipType)
                    if (!result) return

                    delay(jumpClickInterval)
                }
                conditionMonitoring()
            } else {
                reportingError(ABNORMAL_CAN_CLONE)
            }
        } else {
            L.d("当天你任务已经完成")
        }
    }


    private val startAi = 1
    private val conditionStatus = 2
    private val restartGame = 4
    private val end = 8
    private var nowStep =startAi
    private suspend fun conditionMonitoring() {
        while (runSwitch) {
            when (nowStep) {
                startAi -> {
                    startAi()
                }

                conditionStatus -> {
                    monitorAllStatuses()
                }

                restartGame -> {
                    // restartGame()
                }

                end -> {
                    end()
                }
            }
        }
    }


    private suspend fun startAi() {
        L.d("开启AI")
        theOutCheck()
        outSpaceStation()
        if (!en.isOpenAiTask.check()) {
            en.topDeviceList[2].clickArea?.c(SetConstant.MINUTE)
        }
        nowStep = conditionStatus
    }


    var hasCancle = false
    private suspend fun restartGame() {
        var flag = true
        var count = 20 * 20
        clickPositionMenu(taskDb.baseMenuLocation)
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return
            }
            updateInfo()
            //这个过程中只要有一个战斗因素判断成功就进入战斗
            if (canLockRecorder.isOpenTrustThresholds() || topLockTartRecorder.isOpenTrustThresholds()
            ) {
                nowStep = conditionStatus
                return
            }

            //这个是返回逻辑的
            if (en.isInSpaceStationT.check()) {
                flag = false
            }
            count--
        }

        //上面表示已经成功关闭了Ai
        if (flag) {
            reportingError("返回空间站失败了")
            return
        }

        delay(jumpClickInterval)
        if (hasCancle) {
            if (exitGame()) {
                delay(jumpClickInterval)
                if (intoGame()) {
                    delay(tripleClickInterval)
                    cancelFirstTask()
                    nowStep = startAi
                } else {
                    reportingError("restartGame into")
                    return
                }
            } else {
                reportingError("restartGame exitGame")
            }
        } else {
            cancelFirstTask()
            nowStep = startAi
        }
    }


    override suspend fun getBaseCloneLocation(): Int {
        return taskDb.baseCloneLocation
    }


    //这里取消第一个际遇任务
    private suspend fun cancelFirstTask() {
        ensureOpenBigMenuArea(MenuType.TASK)
        if (isHasJiyuTask()) {
            if (optTaskOperation(eTask = en.isQianWangTask, clickArea = en.openJiyuBigArea)) {
                en.abandonTaskArea.c()
                delay(clickInterval)
                en.confirmDialogEnsureArea.c()
                theOutCheck()
            } else {
                theOutCheck()
            }
        }
        theOutCheck()
    }


    private suspend fun isHasJiyuTask(): Boolean {
        var flag = true
        var count = 3
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isNojiYuTask.check()) {
                return false
            } else if (en.isBigNormalList.find { it.check() } != null) {
                return true
            }
            count--
        }
        return false
    }


    private val topLockTartRecorder = StatusRecorder("hasTopLockTart", 3, 60) {
        hasTopLockTart()
    }


    private val isOpenAiRecorder = en.isOpenAiTask.toStatusRecorder(10, 60)

    //这里的Error用来判断卡主的
    private val isHasEysMenu = StatusRecorder("hasEysMenu", 5, 5 * 30) {
        en.isCloseEyeMenuT.check() || en.isOpenEyeMenuT.check()
    }


    private val openPositionMenuRecorder = en.isOpenPositionMenuT.toStatusRecorder(3, 30)

    private val openJiyuBigMenuRecorder = en.isOpenJiyuBigMenuTask.toStatusRecorder(10, 60)

    private val canLockRecorder = en.isCanLockTask.toStatusRecorder(10, 20)

    private val inSpaceStation = en.isInSpaceStationT.toStatusRecorder(5, 10)

    private val isShipStopStation = en.isShipStopTask.toStatusRecorder(30*2, 30*5)

    private suspend fun monitorAllStatuses() {
        L.d("monitorAllStatuses")

        while (runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return
            }
            updateInfo()
         //   updateByScan()
            if (isHasEysMenu.isOpenTrustThresholds()) {//表示在外太空
                if (isOpenAiRecorder.isOpenErrorThresholds() && openJiyuBigMenuRecorder.isCloseErrorThresholds()
                    && canLockRecorder.isCloseErrorThresholds() && openPositionMenuRecorder.isCloseErrorThresholds()
                    && isHasEysMenu.isOpenErrorThresholds()  && topLockTartRecorder.isCloseErrorThresholds()
                ) {
                    reportingError("卡住了")
                    return
                }

                if(isOpenAiRecorder.isOpenTrustThresholds() && isShipStopStation.isOpenTrustThresholds()){
                    isShipStopStation.clearUp()
                    en.topDeviceList[2].clickArea?.c(SetConstant.MINUTE)
                    // 这里卡住了
                }


                //这个为了保证安全
                if (canLockRecorder.isOpenTrustThresholds() && topLockTartRecorder.isCloseTrustThresholds()
                    && isOpenAiRecorder.isCloseTrustThresholds() && openPositionMenuRecorder.isCloseTrustThresholds()
                    && openJiyuBigMenuRecorder.isCloseTrustThresholds()
                ) {
                    isOpenAiRecorder.clearUp()
                    en.topDeviceList[2].clickArea?.c(repeatedClickInterval * 2)
                }

                //这个是引力波
                if (canLockRecorder.isCloseErrorThresholds() && topLockTartRecorder.isCloseErrorThresholds()
                    && isOpenAiRecorder.isCloseErrorThresholds() && openPositionMenuRecorder.isCloseErrorThresholds()
                    && openJiyuBigMenuRecorder.isCloseTrustThresholds()
                ) {
                    if(en.isAiTimeOutTask.check()){
                        reportingError("Ai时间已经消耗")
                        return
                    }
                    isOpenAiRecorder.clearUp()
                    en.topDeviceList[2].clickArea?.c(SetConstant.MINUTE)
                }



            } else if (openJiyuBigMenuRecorder.isOpenErrorThresholds()) {//在接取界面
                L.d("接取界面超時")
                //这个是用于判断无任务导致的关闭执行逻辑的
                isOpenAiRecorder.clearUp()
                if (en.isCompleteAllTask.check()) {//这里已经全部执行完毕
                    end()
                    L.d("isCompleteAllTask")
                    return
                } else if (en.isCanRefreshTask.check()) {
                    nowStep = startAi
                    return
                }
            } else if (isHasEysMenu.isCloseErrorThresholds() && openJiyuBigMenuRecorder.isCloseTrustThresholds()) {
                theOutCheck()
            }else if(inSpaceStation.isOpenErrorThresholds()){
                nowStep = startAi
                return
            }
        }
    }


    private suspend fun updateInfo() {
        topLockTartRecorder.updateInfo()
        openPositionMenuRecorder.updateInfo()
        openJiyuBigMenuRecorder.updateInfo()
        canLockRecorder.updateInfo()
        isOpenAiRecorder.updateInfo()
        isHasEysMenu.updateInfo()
        inSpaceStation.updateInfo()
        isShipStopStation.updateInfo()
    }


//    var lastCompleteScanTime = 0L
//    private suspend fun updateByScan() {
//        if (en.isScanTipBtnTask.check()) {
//            en.scanTipArea.c(repeatedClickInterval)
//            lastCompleteScanTime = System.currentTimeMillis()
//        }
//        if ((System.currentTimeMillis() - lastCompleteScanTime < SetConstant.MINUTE) && en.isScanCompleteTask.check()) {
//            en.closeScanCompleteArea.c(en.isScanCompleteTask, repeatedClickInterval)
//            lastCompleteScanTime = System.currentTimeMillis()
//        }
//        if ((System.currentTimeMillis() - lastCompleteScanTime < SetConstant.MINUTE) && topLockTartRecorder.isOpenTrustThresholds()) {
//            if (en.isShowLeftDialogBox.check()) {
//                en.leftDialogArea.c()
//            } else if (en.isShowRightDialogBox.check()) {
//                en.rightDialogArea.c()
//            }
//        }
//    }
}




