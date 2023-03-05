package com.nwq.function.scheduling.executer.fight

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController
import com.nwq.function.scheduling.utils.log.L
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SPRepo.lastRefreshTimeSp
import com.nwq.function.scheduling.utils.sp.SpConstant
import kotlinx.coroutines.delay

/**
create by: 86136
create time: 2023/2/28 10:43
Function description:
这个是逻辑控制流程,保证能复用
 */

class FightController(p: AccessibilityHelper) : TravelController(p) {

    /**
     * 这个是状态常规量
     */
    private val DAMAGE = -100 //飞船已经损毁
    private val START_GAME = 0  //开始游戏
    private val INTO_GAME = 1 //进入游戏
    private val PICK_UP_TASK = 2 //接取任务
    private val BATTLE_NAVIGATION_MONITORING = 3//战斗飞行导航监控
    private val COMBAT_MONITORING = 4 //战斗监控阶段
    private val MONITORING_RETURN_STATUS = 5//返回空间站监听
    private val ABNORMAL_STATE = 1000 //异常状态

    private val TopOfst = SpConstant.TopOfst//顶部的偏移量
    private val BotOfst = SpConstant.BotOfst//底部的便宜量

    //下面是进入游戏的的一些判断条件
    private val LOADING = 11;
    private val ANNOUNCEMENT = 12;
    private val START_GAME_MENU = 13
    private val SELECT_ROLE = 14
    private val BIG_MENU = 15

    private val STATUS_DETERMINATION = 1000000//这个是进行状态判定
    private val receiveAdvancedTasks = false //是否接受高级任务


    /**
     * 这个是控制变量
     */
    private var nowStep = START_GAME
    var runSwitch = true
    var intoGameStep = LOADING
    var needCancel = false
    var needBackStation = false
    var mNumberOfTasksReceived = 51
    private val visual by lazy {
        FightVisualEnvironment(helper)
    }
    private val constant by lazy {
        FightConstant()
    }

    /*******************************************************************
     *                        下面都是方法
     * *****************************************************************
     */
    override suspend fun generalControlMethod() {
        while (runSwitch) {
            when (nowStep) {
                START_GAME -> {
                    startGame()
                }
                INTO_GAME -> {
                    intoGame()
                }
                PICK_UP_TASK -> {
                    pickUpTask()
                }
                BATTLE_NAVIGATION_MONITORING -> {
                    SPRepo.lastPickUpTaskTimeSp = System.currentTimeMillis()
                    startNavigationMonitoring()
                }
                ABNORMAL_STATE -> {

                }
            }
        }
    }

    suspend fun startGame() {
        pressHomeBtn()
        delay(2000)
        helper.click(
            (82 + (constant.APP_LOCATION_X - 1) * 254).toFloat(),
            (185 + (constant.APP_LOCATION_Y - 1) * 291).toFloat(),
            154,
            153
        )
        delay(doubleClickInterval * 2)
        takeScreen()
        if (visual.hasIntoGame()) {
            nowStep = STATUS_DETERMINATION
        }
    }

    suspend fun intoGame() {
        when (intoGameStep) {
            LOADING -> {

            }
            ANNOUNCEMENT -> {

            }
            START_GAME_MENU -> {

            }
            SELECT_ROLE -> {

            }
            BIG_MENU -> {

            }
        }
    }

    suspend fun pickUpTask() {
        if (mNumberOfTasksReceived <= 0) {
            exit()
            return
        }

        mNumberOfTasksReceived--
        var inSpaceStation = visual.isInSpaceStation()
        L.i(
            "准备接取任务  inSpaceStation: $inSpaceStation ",
            "pickUpTask",
            "FightController",
            "nwq",
            "2023/3/2"
        );
        click(constant.MenuArea)
        click(constant.FightTaskMenuArea, doubleClickInterval)
        takeScreen(tripleClickInterval)
        if (visual.hasReceivedTask()) {
            if (needCancel) {
                cancelTask()
                delay(normalClickInterval)
            } else {
                click(constant.optTaskArea)
                takeScreen(doubleClickInterval)
                if (visual.hasReceivedTask()) {
                    clickTheDialogueClose(true)
                    takeScreen(doubleClickInterval)
                    ensureCloseDetermine()
                    theOutCheck()
                    return
                }
            }
        }

        //打开新闻公告板
        click(constant.newTaskListArea, doubleClickInterval)
        takeScreen(doubleClickInterval)
        if (needRefreshTask()) {
            click(constant.refreshTaskListArea, doubleClickInterval)
            lastRefreshTimeSp = System.currentTimeMillis()
            takeScreen(doubleClickInterval)
        }
        if (!receiveAdvancedTasks && visual.isHighTask()) {
            L.i(
                "发现高级任务 ", "pickUpTask", "FightController", "nwq", "2023/3/2"
            );
            click(constant.pickUpTask2Area)
        } else {
            click(constant.pickUpTask1Area)
        }
        takeScreen(doubleClickInterval)
        ensureCloseDetermine()//低安要点确定
        takeScreen(doubleClickInterval)
        if (!receiveAdvancedTasks && visual.isHighTaskRight())//如果右边是高级任务也进行取消
        {
            L.i(
                "发现高级任务右侧 ", "pickUpTask", "FightController", "nwq", "2023/3/2"
            );
            click(constant.openTaskRightArea)
            click(constant.cancelTaskArea)
            theOutCheck()
            return
        }

        click(constant.openTaskRightArea)
        click(constant.openTaskDetermineArea, doubleClickInterval)

        //到这里就结束了
        if (!clickTheDialogueClose(true)) {
            L.i(
                "接任务出现问题 needCancel:$needCancel ",
                "pickUpTask",
                "FightController",
                "nwq",
                "2023/3/2"
            );
            theOutCheck()
        } else if (inSpaceStation) {
            click(constant.dialogDetermineArea, normalClickInterval)
            takeScreen(doubleClickInterval)
            ensureCloseDetermine()
            takeScreen(doubleClickInterval)
            ensureCloseDetermine()
            nowStep = BATTLE_NAVIGATION_MONITORING
        } else {
            takeScreen(doubleClickInterval)
            ensureCloseDetermine()
            takeScreen(doubleClickInterval)
            ensureCloseDetermine()
            nowStep = BATTLE_NAVIGATION_MONITORING
        }
    }

    suspend fun startNavigationMonitoring() {
        takeScreen(doubleClickInterval)
        if (visual.isShowDetermine()) {
            click(constant.dialogDetermineArea)
        } else if (canLockTarget()) {
            if (System.currentTimeMillis() - SPRepo.lastPickUpTaskTimeSp > constant.NAVIGATING_TOO_LONG) {
                needBackStation = true
            }
            nowStep = COMBAT_MONITORING
        } else if (System.currentTimeMillis() - SPRepo.lastPickUpTaskTimeSp > constant.NAVIGATING_EXCEPTION) {
            needBackStation = true
            needCancel = true
            nowStep = ABNORMAL_STATE
        }
    }

    var battleStartTime = 0L //这个是开始战斗监控的时间
    var mEnterCombatStatus = false //这个是进入战斗的时间
    var roundStartTime = 0L  //这个是新的一轮开始的时间
    var targetReduceTime = 0L //这个是上次目标减少的时间
    var targetCount = 0
    var hasNewLock = false
    suspend fun combatMonitoring() {
        if (System.currentTimeMillis() - battleStartTime > constant.MAX_BATTLE_TIME) {
            nowStep = ABNORMAL_STATE
            return
        }
        takeScreen(doubleClickInterval)
        if (ensureCloseDetermine()) {
            return
        }
        if (!mEnterCombatStatus) {
            if (canLockTargetDelay()) {
                click(constant.lockTargetGroupArea)
                takeScreen(doubleClickInterval)
                targetCount = visual.getTagNumber()
                if (targetCount > 1) {//锁定成功了
                    mEnterCombatStatus = true
                    System.currentTimeMillis().let {
                        roundStartTime = it
                        targetReduceTime = it
                    }
                    hasNewLock = true

                }
            } else if (System.currentTimeMillis() - battleStartTime > constant.INTO_BATTLE_EXCEPTION) {
                nowStep = ABNORMAL_STATE
            }
        } else {

        }
    }


    //pickUp 是否是接取任务
    suspend fun clickTheDialogueClose(pickUp: Boolean): Boolean {
        var hasClickConversation = false
        var rightClickTimes = 0
        var flag = 10
        while (flag > 0) {
            takeScreen(normalClickInterval)
            if (visual.hasLeftDialogue()) {
                click(constant.leftDialogueArea)
                click(constant.leftDialogueArea, fastClickInterval)
                hasClickConversation = true
                flag = 10
            } else if (visual.hasRightDialogue()) {
                click(constant.rightDialogueArea)
                rightClickTimes++
                flag = 10
            } else if (visual.isShowDetermine()) {
                if (rightClickTimes > 3 && pickUp && !receiveAdvancedTasks) {
                    needCancel = true
                    hasClickConversation = false
                    click(constant.dialogCancleArea)
                } else {
                    click(constant.dialogCancleArea)
                    hasClickConversation = true
                }
                flag--
            } else {
                flag--
            }
        }
        return hasClickConversation
    }

    private fun needRefreshTask(): Boolean {
        return System.currentTimeMillis() - lastRefreshTimeSp > constant.REFRESH_INTERVAL
    }


    private fun canLockTarget(): Boolean {
        return visual.hasGroupLock() || (visual.isClosePositionMenu() && visual.getTagNumber() > 2 && visual.getTagNumber() < 2)
    }

    suspend private fun canLockTargetDelay(): Boolean {
        return if (visual.hasGroupLock()) {
            true
        } else if (visual.isClosePositionMenu() && visual.getTagNumber() > 2 && visual.getTagNumber() < 2) {
            delay(10 * 1000)
            true
        } else {
            false
        }
    }

    suspend fun cancelTask() {
        click(constant.openTaskArea, normalClickInterval)
        click(constant.cancelTaskArea, doubleClickInterval)
        takeScreen(doubleClickInterval)
        ensureCloseDetermine()
    }

    suspend fun ensureCloseDetermine(): Boolean {
        if (visual.isShowDetermine()) {
            click(constant.dialogDetermineArea)
            return true
        }
        return false
    }


    suspend fun theOutCheck() {
        takeScreen(doubleClickInterval)
        var flag = visual.isInSpaceStation() || visual.hasEyesMenu()
        if (!flag) {
            if (visual.isOpenBigMenu()) {
                click(constant.closeBigMenuArea)
            } else {
                ensureCloseDetermine()
            }
            theOutCheck()
        }
    }

    //战斗开始时候需要开启的
    fun openTheWholeBattle() {
//        openArrayJudeFirst(wholeBattleOpen)
//        if (mNeedPickUpBox) {
//            openBottom(5)
//        }
    }

//    fun openArrayJudeOne(list: List<Int>?) {
//        if (list.isNullOrEmpty()) {
//            return
//        }
//        list.find { data ->
//            if (data < TopOfst) {
//                judeTimes(data)) {//已经开启所以
//
//            } else {
//                if (judeTopTimes(data - TopOfst - 1)) {//已经开启所以
//                    return
//                }
//            }
//        }
//
//        var data = arry[0];
//        if (data < TopOfst) {
//            if (judeTimes(data)) {//已经开启所以
//                return
//            }
//        } else {
//            if (judeTopTimes(data - TopOfst - 1)) {//已经开启所以
//                return
//            }
//        }
//        for (let i = 0, len = arry.length; i < len; i++) {
//            data = arry[i]
//            if (data < TopOfst && (!mNeedPickUpBox || data != 5)) {
//                openBottom(data)
//            } else {
//                openTop(data - TopOfst - 1)
//            }
//        }
//    }

//    suspend fun judeTimes(): Boolean {
//        takeScreen(normalClickInterval) {
//
//        }
//        var flag1 = judeIsOpen(captureScreen(), indx)
//        if (flag1) {
//            return flag1
//        }
//        sleep(clickInterval())
//        flag1 = judeIsOpen(captureScreen(), indx)
//        return flag1
//    }


    suspend fun exit() {
        runSwitch = false
    }

}