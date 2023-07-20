package com.nwq.function.corelib.excuter.star_wars

import android.accessibilityservice.AccessibilityService
import com.nwq.function.corelib.Constant.doubleClickInterval
import com.nwq.function.corelib.Constant.normalClickInterval
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.excuter.EndLister
import com.nwq.function.corelib.img.task.ImgTaskImpl1
import kotlinx.coroutines.delay
import timber.log.Timber

/**
create by: 86136
create time: 2023/7/17 19:45
Function description:
 */

class AdventureTaskController(acService: AccessibilityService, endLister: EndLister? = null) :
    StarWarController(acService, endLister) {


    private val DAMAGE = -100 //飞船已经损毁
    private val START_GAME = 0  //开始游戏
    private val PICK_UP_TASK = 1 //接取任务
    private val BATTLE_NAVIGATION_MONITORING = 2//战斗飞行导航监控
    private val COMBAT_MONITORING = 3 //战斗监控阶段
    private val MONITORING_RETURN_STATUS = 4//返回空间站监听
    private val ALL_COMPLETE = 9//全部完成
    private val CHECK_SHIP = 10//检查船只

    private val ABNORMAL_STATE = Int.MAX_VALUE //异常状态修复
    private val EXIT_GAME = 400//正常退出
    private val RESTART_GAME = 401//退出重新进入
    private val EXIT_GAME_ERROR = 1000//异常退出
    private var nowTask = START_GAME

    private lateinit var topTargetMonitor: TopTargetMonitor
    private lateinit var bottomDeviceMonitor: BottomDeviceMonitor
    private lateinit var isNotTask: ImgTaskImpl1

    //    var mEnterCombatStatus = false //这个是进入战斗的时间
    private var needBack = false
    private var needCancel = false


    override suspend fun generalControlMethod() {
        while (runSwitch) {
            when (nowTask) {
                START_GAME->{
                    startGame()
                }
                PICK_UP_TASK->{
                    pickTask()
                }
                BATTLE_NAVIGATION_MONITORING->{
                    startNavigationMonitoring()
                }
                COMBAT_MONITORING->{
                    combatMonitoring()
                }
                MONITORING_RETURN_STATUS->{
                    monitoringReturnStatus()
                }
                ALL_COMPLETE->{

                }
                CHECK_SHIP->{

                }
                RESTART_GAME->{//这里先退出游戏再出去
                    outGame()
                    delay(doubleClickInterval)
                    intoGame()
                }
                ABNORMAL_STATE->{
                    theOutCheck()
                    clickPositionMenu(warehouseIndex)
                    nowTask = MONITORING_RETURN_STATUS
                }
            }
        }
    }


    private fun startGame(){

    }



    private suspend fun pickTask() {
        ensureOpenBigMenuArea(TASK_BIG_MUNU_P)
        val isNoTask = waitImgTask(isNotTask)
        //TODO 点击去领取任务的区域
        val goClickArea = CoordinateArea(0, 0, 0, 0)
        if (isNoTask) {
            needCancel = false
            click(goClickArea)
            pickUpTask2()
        } else {
            if (needCancel) {
                aboundTask()
                click(goClickArea)//这里点击左边的进入任务
                pickUpTask2()
            } else if (waitImgTask2(en.isShowLeftDialogBox, goClickArea)) {//这里要点击接任务的区域
                //这里点击前往了
                clickTheDialogueClose()
                nowTask = BATTLE_NAVIGATION_MONITORING
            }else{
                nowTask = ABNORMAL_STATE
                return
            }
        }
    }

    private suspend fun pickUpTask2() {
        val list = getPickUpArea()
        //TODO 这里要判断是否完成的

        if (list == null) {
            //没有刷出来数据
            nowTask = ABNORMAL_STATE
            return
        } else if (list.isEmpty()) {
            //没有可以领取的任务
            if (waitImgTask(en.isCanRefreshTask, 30 * 30)) {
                takeScreen(doubleClickInterval)
                val list1 = getPickUpArea()
                if (list1.isNullOrEmpty()) {
                    nowTask = ABNORMAL_STATE
                    return
                }
                list.addAll(list1)
            } else {
                nowTask = ABNORMAL_STATE
                return
            }
        }
        click(list)//这里接受全部的任务
        takeScreen(doubleClickInterval)
        //TODO 点击领取任务区域
        val rightClickArea = CoordinateArea(0, 0, 0, 0)
        if (waitImgTask2(en.isQianWangTask, rightClickArea)) {
            delay(normalClickInterval)
            click(en.qianWangArea)
            clickTheDialogueClose()
            nowTask = BATTLE_NAVIGATION_MONITORING
            return
        } else {
            nowTask = ABNORMAL_STATE
            return
        }
    }

    //pickUp 是否是接取任务
    private suspend fun clickTheDialogueClose(count: Int = 3): Boolean {
        return true
    }


    //放弃任务
    private fun aboundTask() {

    }

    private suspend fun getPickUpArea(): MutableList<CoordinateArea>? {
        val clickArea = mutableListOf<CoordinateArea>()
        val list = waitImgTaskList(en.IsNormalTaskList)
        if (list.isEmpty()) {
            //卡住了没有刷出来任务
            return null
        }
        list.forEach {
            if (en.IsZeroDistanceList[it].verificationRule(screenBitmap) || en.IsZeroDistanceList[it].verificationRule(
                    screenBitmap
                )
            ) {
                en.pickUpItemList[it].let {
                    if (it.verificationRule(screenBitmap)) {
                        it.getOfsArea()?.let {
                            clickArea.add(it)
                        }
                    }
                }
            }
        }
        return clickArea
    }


    private suspend fun startNavigationMonitoring() {
        Timber.d("monitoringReturnStatus FightController NWQ_ 2023/4/11");
        var flag = true
        val maxCount =20
        var count = maxCount
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (en.isCanLockTask.verificationRule(screenBitmap)) {
                nowTask = COMBAT_MONITORING
                flag = false
            } else if (en.isConfirmDialogTask.verificationRule(screenBitmap)) {
                click(en.confirmDialogEnsureArea)
            } else if (en.isClosePositionMenuT.verificationRule(screenBitmap)) {
                count--
            }
        }
        if (count == 0 && flag) {
            nowTask =  PICK_UP_TASK
            return
        }
    }

    private suspend fun combatMonitoring() {
        var flag = true
        var count = 200
        nowTask = PICK_UP_TASK
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (en.isCanLockTask.verificationRule(screenBitmap)) {
                click(en.isCanLockTask)
                if (topTargetMonitor.onNewLock()) {
                    bottomDeviceMonitor.openReducer()
                }
            } else if (hasTaskDialogBox(screenBitmap)) { //这里表示任务已经结束了
                nowTask = PICK_UP_TASK
                return
            } else if (needBack && (isInSailing(screenBitmap) || en.isInSpaceStationT.verificationRule(
                    screenBitmap
                ))
            ) {//这里一般是血量异常或者卡住了
                nowTask = MONITORING_RETURN_STATUS
                return
            } else {
                topTargetMonitor.updateInfo(screenBitmap!!)
                if (topTargetMonitor.needOpenReducer) {
                    bottomDeviceMonitor.openReducer()
                }
                if (!needBack && topTargetMonitor.isNeedAbnormal()) {
                    emergencyEvacuation()
                    nowTask = MONITORING_RETURN_STATUS
                    needCancel = true
                    needBack = true
                }
                if (topTargetMonitor.lastTargetNumber > 0) {
                    val listArea = bottomDeviceMonitor.updateInfo(screenBitmap!!)
                    click(listArea)
                    if (bottomDeviceMonitor.isNeedAbnormal()) {
                        emergencyEvacuation()
                        nowTask = RESTART_GAME
                        needCancel = true
                        needBack = true
                    }
                } else if (needBack) { //如果没有目标 需要撤离则进行紧急撤了
                    emergencyEvacuation()
                }
            }
        }

        if (count < 0) {
            emergencyEvacuation()
            nowTask = MONITORING_RETURN_STATUS
            needCancel = true
            needBack = true
        }
    }


    private suspend fun monitoringReturnStatus() {
        Timber.d("monitoringReturnStatus FightController NWQ_ 2023/4/11");
        var flag = true
        val maxCount = 15 * 60
        var count = maxCount
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (en.isInSpaceStationT.verificationRule(screenBitmap)) {
                if (spReo.isPickupBox) {
                    unloadingCargo()
                }
            } else if (en.isOpenBigMenuT.verificationRule(screenBitmap)) {
                click(en.closeBigMenuArea)
            } else if (en.isConfirmDialogTask.verificationRule(screenBitmap)) {
                click(en.confirmDialogEnsureArea)
            } else if (count < maxCount - 10 && !en.isSailingT.verificationRule(screenBitmap)
                && en.isCloseEyeMenuT.verificationRule(screenBitmap) && en.isOpenEyeMenuT.verificationRule(
                    screenBitmap
                )
            ) {
                clickPositionMenu(warehouseIndex)
            }
            count--
        }
        if (count == 0 && flag) {
            runSwitch = false
            return
        }
    }


}