package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import android.text.TextUtils
import android.text.format.Time
import com.android.schedule.corelibrary.SetConstant
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
                    conditionAiStatus()
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
        var flag = true
        var count = 20
        var record = 100
        var recordErro = 0
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return
            }
            if (!en.isCloseAiTask.check()||en.isOpenJiyuBigMenuTask.check()) {//开启成功
                flag = false
            } else if (hasTopLockTart()) {//顶部有锁定的
                if (recordErro < count) {
                    recordErro = count
                }
                if (recordErro - count > 5) {
                    clickPositionMenu(taskDb.baseMenuLocation)
                    reportingError("hasTopLockTart")
                    return
                }
            } else if(isInSpace()){
                if (record - count > 5) {
                    en.topDeviceList[2].clickArea?.c()
                    record = count
                }
            }
            count--
        }
        if(!flag){
            nowStep = -10000
            clickPositionMenu(taskDb.baseMenuLocation)
            reportingError("startAi")
            return
        }else{
            nowStep = conditionStatus
        }

    }

    val ai_unkown = -1
    val isOpenTaskManu = 1
    val ai_nomarl = 2
    val ai_close = 3
    val ai_open = 4

    var aiStatus = ai_unkown

    var lastNoTask = 0L


    private suspend fun conditionAiStatus() {
        L.d("conditionAiStatus")
        var startTime = System.currentTimeMillis()
        //这个是判断异常冗余时间
        var redundantWaitTime = ((Math.random() * 3 + 2) * SetConstant.MINUTE).toLong()
        aiStatus = ai_unkown
        var flag = true
        while (flag && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            val nowTime = System.currentTimeMillis()

            if (hasTopLockTart()) {//如果有锁定的目标则认为是正常的
                startTime = nowTime
                aiStatus = ai_nomarl
            } else if (en.isCloseAiTask.check()) {//如果有锁定的目标则认为是正常的
                if (en.isCanLockTask.check()) { //这里表示已经可以锁定 则直接进行锁定
                    en.topDeviceList[2].clickArea?.c()
                } else {
                    if (aiStatus != ai_close) {
                        startTime = nowTime
                        aiStatus = ai_close
                    } else if (TimeUtils.judgingTheInterval(
                            nowTime, startTime, redundantWaitTime
                        )
                    ) {
                        flag = false
                        nowStep = startAi
                    }
                }
            } else if (isInSpace()) {//进入这里坑定是ai不是关闭的状态
                if (aiStatus != ai_open) {
                    startTime = nowTime
                    aiStatus = ai_open
                } else if (TimeUtils.judgingTheInterval(nowTime, startTime, SetConstant.halfHour)) {
                    if (taskScreenL(screenshotInterval)) {
                        if (!en.isCloseAiTask.check()) {
                            en.topDeviceList[2].clickArea?.c()
                        }
                        nowStep = restartGame
                    } else {
                        reportingError(ABNORMAL_SCREENO_ORIENTATION)
                    }
                    return
                }
            } else if (en.isOpenJiyuBigMenuTask.check()) {//这里是打开际遇的开关
                if (aiStatus != isOpenTaskManu) {
                    L.d("aiStatus == isOpenTaskManu")
                    aiStatus = isOpenTaskManu
                    startTime = nowTime
                } else if (TimeUtils.judgingTheInterval(nowTime, startTime, redundantWaitTime)) {
                    if (en.isCompleteAllTask.check()) {
                        theOutCheck()
                        end()
                        flag = false
                    } else if (!TimeUtils.judgingTheInterval(nowTime, lastNoTask, SetConstant.halfHour)) {
                        reportingError("过快原因没有任务 进入删除")
                        flag = false
                    } else if (en.isCanRefreshTask.check()) {//这里需要等到能刷新再去启动游戏
                        lastNoTask = nowTime
                        L.d("isCanRefreshTask")
                        flag = false
                        nowStep = startAi
                    }
                }
            }
        }
    }


    private suspend fun restartGame() {
        L.d("restartGame")
        if (exitGame()) {
            delay(jumpClickInterval)
            if (intoGame()) {
                delay(tripleClickInterval)
                returnSpaceStation(taskDb.baseMenuLocation)
                //01
                cancelFirstTask()
                nowStep = startAi
            } else {
                reportingError("restartGame")
            }
        } else {
            reportingError("restartGame")
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
}