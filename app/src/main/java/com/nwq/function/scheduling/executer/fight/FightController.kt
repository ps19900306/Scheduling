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

    val UNKNOWN_STATE = 0
    val OFF_STATE = 1
    val ON_STATE = 2
    var maintenanceStatus = UNKNOWN_STATE
    var maintenanceTimeStartStamp = 0L
    var MAINTENANCE_INTERVAL = 30000L //维修间隔

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

    //后面这里由外部读取数据进行初始化
    private val wholeBattleOpenList by lazy {
        listOf(2 + BotOfst, TopOfst + 2)
    }
    private val roundBattleOpenList by lazy {
        listOf(5 + BotOfst, 6 + BotOfst)
    }
    private val timeOnOpenList1 by lazy {
        listOf(TopOfst + 5, TopOfst + 6)
    }
    private val timeOnOpenList2 by lazy {
        listOf<Int>()
    }
    private val timeOnOpenList3 by lazy {
        listOf<Int>(1 + BotOfst, 4 + BotOfst)
    }
    private val catchFoodList by lazy {
        listOf<Int>(1 + BotOfst, 4 + BotOfst)
    }
    private val maintenanceDevicePosition = TopOfst + 1
    private val weaponPosition = BotOfst + 3
    var isShieldResistance = false//是否护盾抗


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
                COMBAT_MONITORING -> {
                    combatMonitoring()
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
    var useUnlock = true //是否使用右上角的未锁定数进行锁定
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
                    System.currentTimeMillis().let {
                        roundStartTime = it
                        targetReduceTime = it
                    }
                    mEnterCombatStatus = true
                    hasNewLock = true
                    openTheWholeBattle()
                    useUnlock = true
                } else if (visual.getTagNumber() > 3) {
                    System.currentTimeMillis().let {
                        roundStartTime = it
                        targetReduceTime = it
                    }
                    openTheWholeBattle()
                    mEnterCombatStatus = true
                    useUnlock = true
                } else {
                    //没有锁定上继续导航
                    useUnlock = false
                }
            } else if (System.currentTimeMillis() - battleStartTime > constant.INTO_BATTLE_EXCEPTION) {
                nowStep = ABNORMAL_STATE
            }
        } else {
            if (canLockTarget()) {//可以进行锁定
                click(constant.lockTargetGroupArea, normalClickInterval)
                takeScreen(doubleClickInterval)
                val nowTargetCount = visual.getTagNumber()
                System.currentTimeMillis().let {
                    roundStartTime = it
                    targetReduceTime = it
                }
                if (targetCount <= 1 && nowTargetCount >= 1) {
                    hasNewLock = true
                    openTheWholeBattle()
                    targetCount = nowTargetCount
                } else if (targetCount >= 4 && hasNewLock) {
                    openDecelerationNet()
                    hasNewLock = false
                } else {//这里要做异常处理了

                }
            } else {//状态监控
                val needCheckOpenList = mutableListOf<Int>()
                val needCheckCloseList = mutableListOf<Int>()
                val nowTargetCount = visual.getTagNumber()
                if (nowTargetCount > 0) {
                    if (nowTargetCount < targetCount) {
                        targetReduceTime = System.currentTimeMillis()
                        if (hasNewLock) {
                            hasNewLock = false
                            needCheckOpenList.addAll(catchFoodList)
                        }
                    } else if (nowTargetCount == targetCount && System.currentTimeMillis() - targetReduceTime > 60 * 1000L) {
                        needCheckOpenList.addAll(catchFoodList)
                    }
                    needCheckOpenList.addAll(wholeBattleOpenList)
                    needCheckOpenList.addAll(roundBattleOpenList)
                    needCheckOpenList.add(weaponPosition)
                    bloodVolumeMonitoring(needCheckOpenList, needCheckCloseList)
                } else {

                }
            }
        }
    }

    suspend fun bloodVolumeMonitoring(
        needCheckOpenList: MutableList<Int>,
        needCheckCloseList: MutableList<Int>
    ) {
        if (System.currentTimeMillis() - maintenanceTimeStartStamp < MAINTENANCE_INTERVAL) {
            return
        }
        if (isShieldResistance) {
            if (visual.shieldTooLow()) {
                needCheckOpenList.add(maintenanceDevicePosition)
            } else if (visual.shieldFull()) {
                needCheckCloseList.add(maintenanceDevicePosition)
            } else {

            }
        } else {
            if (visual.armorTooLow()) {
                needCheckOpenList.add(maintenanceDevicePosition)
            } else if (visual.armorFull()) {
                needCheckCloseList.add(maintenanceDevicePosition)
            } else {

            }
        }
    }


    //战斗开始时候需要开启的
    suspend fun openDecelerationNet() {
        clickEquipArray(openCheckEquipTimes(2, catchFoodList))
    }

    //战斗开始时候需要开启的
    suspend fun openTheWholeBattle() {
        clickEquipArray(openCheckEquipTimes(2, wholeBattleOpenList, roundBattleOpenList))
    }

    suspend fun openCheckEquipTimes(times: Int, vararg data: List<Int>): List<Int> {
        var list = listOf<Int>()
        for (i in 0 until times) {
            val result = checkEquipStatusClose(wholeBattleOpenList, roundBattleOpenList)
            list = if (i == 0) {
                result
            } else {
                list.filter { result.contains(it) }
            }
        }
        return list
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
        return System.currentTimeMillis() - lastRefreshTimeSp > constant.REFRESH_INTERVAL && visual.canRefresh()
    }


    private fun canLockTarget(): Boolean {
        return visual.hasGroupLock() || (visual.isClosePositionMenu() && visual.getTagNumber() > 2 && visual.getTagNumber() < 2)
    }

    private suspend fun canLockTargetDelay(): Boolean {
        return if (visual.hasGroupLock()) {
            true
        } else if (useUnlock && visual.isClosePositionMenu() && visual.getTagNumber() > 2 && visual.getTagNumber() < 2) {
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

    //获取是关闭的状态
    fun checkEquipStatusClose(vararg data: List<Int>): List<Int> {
        val unOpenList = mutableListOf<Int>()
        data.forEach {
            it.forEach { index ->
                if (!judeIsOpen(index)) {
                    unOpenList.add(index)
                }
            }
        }
        return unOpenList
    }

    //获取是开启的状态
    fun checkEquipStatusOpen(vararg data: List<Int>): List<Int> {
        val unOpenList = mutableListOf<Int>()
        data.forEach {
            it.forEach { index ->
                if (judeIsOpen(index)) {
                    unOpenList.add(index)
                }
            }
        }
        return unOpenList
    }

    suspend fun clickEquipArray(list: List<Int>) {
        list.forEach {
            clickEquip(it)
        }
    }

    private suspend fun clickEquip(index: Int) {
        if (index < TopOfst) {
            click(constant.getBottomEquipArea(index), fastClickInterval)
        } else {
            click(constant.getTopEquipArea(index - TopOfst - 1), fastClickInterval)
        }
    }

    fun judeIsOpen(index: Int): Boolean {
        return if (index < TopOfst) {
            visual.judeIsOpenBottom(index)
        } else {
            visual.judeIsOpenTop(index - TopOfst - 1)
        }
    }

    suspend fun exit() {
        runSwitch = false
    }

}