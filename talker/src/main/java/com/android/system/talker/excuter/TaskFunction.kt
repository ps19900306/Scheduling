package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import android.text.TextUtils
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
        L.i("$TAG startFunction")
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
    private var nowStep = startAi
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
                    restartGame()
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
        en.topDeviceList[2].clickArea?.c()
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
                || bottomDeviceOpenRecorder.isOpenTrustThresholds()
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


    private val topLockTartRecorder = StatusRecorder("hasTopLockTart", 5, 30) {
        hasTopLockTart()
    }

    private val bottomDeviceOpenRecorder = StatusRecorder("bottomDevice", 5, 60 * 20) {
        hasBottomDeviceOpen()
    }


    private val openPositionMenuRecorder = StatusRecorder("openPosition", 3, 60) {
        en.isOpenPositionMenuT.check()
    }

    private val openJiyuBigMenuRecorder = StatusRecorder("openPosition", 10, 60) {
        en.isOpenJiyuBigMenuTask.check()
    }

    private val canLockRecorder = StatusRecorder("canLock", 5, 60) {
        en.isCanLockTask.check()
    }


    private suspend fun monitorAllStatuses() {
        L.d("monitorAllStatuses")
        while (runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return
            }
            updateInfo()

            //安全 这里锁定按钮和出现时间很长 且设备一直未能开启
//            if (canLockRecorder.isOpenTrustThresholds() && topLockTartRecorder.isCloseTrustThresholds()) {
//                    en.topDeviceList[2].clickArea?.c(repeatedClickInterval)
//            }

            // 這個用用于判断游戏进不去的
            if (canLockRecorder.isCloseErrorThresholds()
                && topLockTartRecorder.isCloseErrorThresholds()
                && openJiyuBigMenuRecorder.isCloseTrustThresholds() //且没有打开际遇菜单
                && openPositionMenuRecorder.isCloseErrorThresholds()//这个是判断结束导航的
            ) {
                canLockRecorder.clearUp()
                if (openJiyuBigMenuRecorder.isCloseErrorThresholds() && bottomDeviceOpenRecorder.isCloseErrorThresholds()) {
                    reportingError("执行任务卡住了")
                } else {            // 这个是用于判断引力波导致的关闭
                    en.topDeviceList[2].clickArea?.c()
                }
            }

            //这个是用于判断无任务导致的关闭执行逻辑的
            if (openJiyuBigMenuRecorder.isOpenErrorThresholds()) {
                if (en.isCompleteAllTask.check()) {//这里已经全部执行完毕
                    end()
                    L.d("isCompleteAllTask")
                    return
                } else if (en.isCanRefreshTask.check()) {
                    nowStep = startAi
                    return
                }
            }


        }
    }


    private suspend fun updateInfo() {
        topLockTartRecorder.updateInfo()
        bottomDeviceOpenRecorder.updateInfo()
        openPositionMenuRecorder.updateInfo()
        openJiyuBigMenuRecorder.updateInfo()
        canLockRecorder.updateInfo()
    }
}




