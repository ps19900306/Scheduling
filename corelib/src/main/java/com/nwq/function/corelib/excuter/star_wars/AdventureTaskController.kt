package com.nwq.function.corelib.excuter.star_wars

import android.accessibilityservice.AccessibilityService
import com.nwq.function.corelib.Constant.doubleClickInterval
import com.nwq.function.corelib.Constant.fastClickInterval
import com.nwq.function.corelib.Constant.normalClickInterval
import com.nwq.function.corelib.Constant.tripleClickInterval
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.excuter.EndLister
import com.nwq.function.corelib.excuter.star_wars.data.QuickBigMenu
import com.nwq.function.corelib.excuter.star_wars.function.BottomDeviceMonitor
import com.nwq.function.corelib.excuter.star_wars.function.TopTargetMonitor
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
    private val PICK_UP_TASK = 1 //接取任务
    private val BATTLE_NAVIGATION_MONITORING = 2//战斗飞行导航监控
    private val COMBAT_MONITORING = 3 //战斗监控阶段
    private val ALL_COMPLETE = 9//全部完成
    private val CHECK_SHIP = 10//检查船只
    private val EXIT_GAME = 400//正常退出
    private val RESTART_GAME = 401//退出重新进入
    private val EXIT_GAME_ERROR = 1000//异常退出
    private val topTargetMonitor by lazy {
        TopTargetMonitor(
            en.topLockTargetList1, en.topTargetHpList1, en.topLockTargetList2, en.topTargetHpList2
        )
    }
    private val bottomDeviceMonitor by lazy {
        BottomDeviceMonitor(en.topDeviceList, en.bottomDeviceList)
    }


    //    var mEnterCombatStatus = false //这个是进入战斗的时间
    private var needBack = false
    private var needCancel = false
    private var needRestart = false

    override suspend fun generalControlMethod() {
        while (runSwitch) {
            when (nowTask) {
                START_GAME -> {
                    startGame()
                }
                PICK_UP_TASK -> {
                    pickTask()
                }
                BATTLE_NAVIGATION_MONITORING -> {
                    startNavigationMonitoring()
                }
                COMBAT_MONITORING -> {
                    combatMonitoring()
                }
                MONITORING_RETURN_STATUS -> {
                    monitoringReturnStatus()
                }
                ALL_COMPLETE -> {
                    onComplete()
                }
                CHECK_SHIP -> {

                }
                RESTART_GAME -> {//这里先退出游戏再出去
                    restartGame()
                }
                ABNORMAL_STATE -> {
                    theOutCheck()
                    clickPositionMenu(warehouseIndex)
                    nowTask = MONITORING_RETURN_STATUS
                }
            }
        }
    }

    private suspend fun startGame() {
        topTargetMonitor.updateInfo(screenBitmap!!)
        if (topTargetMonitor.lastTargetNumber > 0 || en.isCanLockTask.check()) {
            nowTask = COMBAT_MONITORING
        } else {
            nowTask = PICK_UP_TASK
        }
    }


    private suspend fun pickTask() {
        ensureOpenBigMenuArea(QuickBigMenu.TASK_BIG_MUNU_P)
        val isNoTask = isHasJiyuTask()
        if (isNoTask) {
            needCancel = false
            click(en.goJiyuListMenuArea)
            pickUpTask2()
        } else {
            if (needCancel) {
                aboundTask()
                needCancel = false
//                click(en.goJiyuListMenuArea)//这里点击左边的进入任务
//                pickUpTask2()
            } else {
                //这里点击前往了
                en.startJiyuBigArea.clickA()
                if (clickTheDialogueClose()) {
                    nowTask = BATTLE_NAVIGATION_MONITORING
                } else {
                    nowTask = PICK_UP_TASK
                }
            }
        }
    }

    private suspend fun aboundTask() {
        if (waitImgTask2(en.isQianWangTask, en.openJiyuBigArea)) {
            en.abandonTaskArea.clickA()
            delay(normalClickInterval)
            en.confirmDialogEnsureArea.clickA()
            theOutCheck()
        } else {
            theOutCheck()
        }
    }

    private suspend fun isHasJiyuTask(): Boolean {
        var flag = true
        var count = 3
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (en.isNojiYuTask.check()) {
                return true
            } else if (en.isBigNormalList.find { it.check() } != null) {
                return false
            }
            count--
        }
        return false
    }


    private suspend fun pickUpTask2() {
        val list = getPickUpArea()
        if (list == null) {
            //没有刷出来数据
            nowTask = ABNORMAL_STATE
            return
        } else if (list.isEmpty()) {
            //没有可以领取的任务
            if (waitImgTask(en.isCanRefreshTask, 30 * 30)) {
                takeScreen(tripleClickInterval)
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
        if (list.isEmpty()) {
            nowTask = ABNORMAL_STATE
            return
        }

        click(list)//这里接受全部的任务
        if (en.isCanRefreshTask.check()) {
            en.refreshTaskArea.clickA()
        }


        var flag = true
        var count = 10
        var hasEndNormal = false
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return
            }
            if (en.isEndNormalList.find { it.check() } != null) {
                click(en.endNormalArea)
                hasEndNormal = true
            } else if (en.isQianWangTask.check()) {
                delay(normalClickInterval)
                click(en.qianWangArea)
                flag = false
            } else if (en.isShowLeftDialogBox.check() || en.isConfirmDialogTask.check()) {
                flag = false
            }
            count--
        }

        if (!flag) {
            clickTheDialogueClose()
            nowTask = BATTLE_NAVIGATION_MONITORING
            return
        } else if (!hasEndNormal) {
            nowTask = ALL_COMPLETE
            return
        } else {
            nowTask = ABNORMAL_STATE
        }

    }

    //pickUp 是否是接取任务
    private suspend fun clickTheDialogueClose(dCount: Int = 5): Boolean {
        var flag = true
        var count = dCount
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(fastClickInterval)) {
                runSwitch = false
                return false
            }
            if (en.isShowLeftDialogBox.check()) {
                en.leftDialogArea.clickA()
                count = dCount
            } else if (en.isShowRightDialogBox.check()) {
                en.rightDialogArea.clickA()
                count = dCount
            } else if (en.isConfirmDialogTask.check()) {
                en.confirmDialogEnsureArea.clickA()
                flag = false
            }
            count--
        }
        return !flag
    }


    //
    private suspend fun getPickUpArea(): MutableList<CoordinateArea>? {
        val clickArea = mutableListOf<CoordinateArea>()
        val list = waitImgTaskList(en.IsNormalTaskList)
        if (list.isEmpty()) {
            //卡住了没有刷出来任务
            return null
        }
        val isCanClickArea = list.filter { en.pickUpItemList[it].check() }

        val zeroList = mutableListOf<CoordinateArea>()
        isCanClickArea.forEach {
            if (en.IsZeroDistanceList[it].check()) {
                en.pickUpItemList[it].let {
                    it.containmentTask?.getOfsArea()?.let { area ->
                        zeroList.add(area)
                    }
                }
            }
        }
        if (zeroList.size > 1) {
            zeroList.shuffle()
        }
        clickArea.addAll(zeroList)

        val oneList = mutableListOf<CoordinateArea>()
        isCanClickArea.forEach {
            if (en.IsOneDistanceList[it].check()) {
                en.pickUpItemList[it].let {
                    it.containmentTask?.getOfsArea()?.let { area ->
                        zeroList.add(area)
                    }
                }
            }
        }
        if (oneList.size > 1) {
            oneList.shuffle()
        }
        clickArea.addAll(oneList)

        return clickArea
    }


    private suspend fun startNavigationMonitoring() {
        Timber.d("startNavigationMonitoring AdventureTaskController NWQ_ 2023/4/11");
        var flag = true
        val maxCount = 20
        var count = maxCount
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (en.isCanLockTask.check()) {
                topTargetMonitor.clearData()
                bottomDeviceMonitor.clearData()
                nowTask = COMBAT_MONITORING
                flag = false
            } else if (en.isConfirmDialogTask.check()) {
                click(en.confirmDialogEnsureArea)
            } else if (en.isClosePositionMenuT.check()) {
                count--
            }
        }
        if (flag && runSwitch) {
            nowTask = PICK_UP_TASK
            return
        }
    }

    private suspend fun combatMonitoring() {;
        var flag = true
        while (flag && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (en.isCanLockTask.check()) {
                en.lockTargetArea.clickA()
                delay(doubleClickInterval)
                if (topTargetMonitor.onNewAgainLock()) {
                    bottomDeviceMonitor.openReducer()
                } else {
                    bottomDeviceMonitor.closeReducer()
                }
            } else if (topTargetMonitor.isEndData() && hasTaskDialogBox()) { //这里表示任务已经结束了
                Timber.d("任务已经结束 AdventureTaskController NWQ_ 2023/7/23");
                nowTask = PICK_UP_TASK
                clickTheDialogueClose()
                topTargetMonitor.clearData()
                bottomDeviceMonitor.clearData()
                return
            } else if (needBack && (isInSailing(screenBitmap) || en.isInSpaceStationT.check())) {//这里一般是血量异常或者卡住了
                nowTask = MONITORING_RETURN_STATUS
                return
            } else {
                topTargetMonitor.updateInfo(screenBitmap!!)
                if (topTargetMonitor.needOpenReducer) {
                    bottomDeviceMonitor.openReducer()
                } else {
                    bottomDeviceMonitor.closeReducer()
                }
                if (topTargetMonitor.isWaitEnd()) {
                    if (!needBack) {
                        Timber.d("topTargetMonitor isWaitEnd NWQ_ 2023/7/22");
                        topTargetMonitor.clearData()
                        bottomDeviceMonitor.clearData()
                        nowTask = PICK_UP_TASK
                        clickTheDialogueClose()
                        return
                    } else {
                        clickPositionMenu(warehouseIndex)
                        nowTask = MONITORING_RETURN_STATUS
                        return
                    }
                }

                if (!needBack && topTargetMonitor.isNeedAbnormal()) {
                    Timber.d("topTargetMonitor emergencyEvacuation NWQ_ 2023/7/22");
                    emergencyEvacuation()
                    nowTask = MONITORING_RETURN_STATUS
                    needCancel = true
                    needBack = true
                }
                if (topTargetMonitor.lastTargetNumber > 0) {
                    val listArea = bottomDeviceMonitor.updateInfo(screenBitmap!!)
                    click(listArea)
                    if (bottomDeviceMonitor.isNeedAbnormal()) {
                        Timber.d("bottomDeviceMonitor emergencyEvacuation NWQ_ 2023/7/22");
                        emergencyEvacuation()
                        nowTask = RESTART_GAME
                        needBack = true
                        needRestart = true
                    }
                } else if (needBack) { //如果没有目标 需要撤离则进行紧急撤了
                    emergencyEvacuation()
                }
            }
        }
    }


    private suspend fun monitoringReturnStatus() {
        Timber.d("monitoringReturnStatus AdventureTaskController NWQ_ 2023/4/11");
        var flag = true
        val maxCount = 15 * 60
        var count = maxCount
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (en.isInSpaceStationT.check()) {
                if (spReo.isPickupBox) {
                    unloadingCargo()
                }
                nowTask = PICK_UP_TASK
                needBack = false
                if (needRestart == true) {
                    nowTask = RESTART_GAME
                }
                flag = false
            } else if (en.isOpenBigMenuT.check()) {
                click(en.closeBigMenuArea)
            } else if (en.isConfirmDialogTask.check()) {
                click(en.confirmDialogEnsureArea)
            } else if (en.isCanLockTask.check()) {
                needBack = false
                needCancel = false
                nowTask = COMBAT_MONITORING
                flag = false
            } else if (count < maxCount - 10 && !en.isSailingT.check() && en.isCloseEyeMenuT.check() && en.isOpenEyeMenuT.check()
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