package com.nwq.function.scheduling.executer.fight

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController
import com.nwq.function.scheduling.executer.base.VisualEnvironment
import com.nwq.function.scheduling.utils.JsonUtil
import com.nwq.function.scheduling.utils.log.L
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SPRepo.lastRefreshTimeSp
import com.nwq.function.scheduling.utils.sp.SpConstant
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

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
    private val START_BATTLE_NAVIGATION_MONITORING = 4//战斗飞行导航监控
    private val BATTLE_NAVIGATION_MONITORING = 5//战斗飞行导航监控
    private val COMBAT_MONITORING = 6 //战斗监控阶段
    private val START_MONITORING_RETURN_STATUS = 7//返回空间站监听
    private val MONITORING_RETURN_STATUS = 8//返回空间站监听
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
    var DEFAULT_DESTROY_INTERVAL = 60 * 1000 //能够容忍的最大击毁间隔
    var DESTROY_INTERVAL = DEFAULT_DESTROY_INTERVAL //能够容忍的最大击毁间隔

    /**
     * 这个是控制变量
     */
    private var nowStep = PICK_UP_TASK
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
        listOf<Int>(4 + TopOfst)
    }

    // 默认是武器的
    var CombatStamp_1 = 0L
    val BASIC_COMBAT_INTERVAL_1 = 165 * 1000L

    // 默认是武器的
    var CombatStamp_2 = 0L
    val BASIC_COMBAT_INTERVAL_2 = 170 * 1000L

    // 默认是转速的
    var CombatStamp_3 = 0L
    val BASIC_COMBAT_INTERVAL_3 = 75 * 1000L

    val Equipment_Interval = 30 * 1000L

    private val catchFoodList by lazy {
        listOf<Int>(1 + BotOfst, 4 + BotOfst)
    }
    private val maintenanceDevicePosition = TopOfst + 1
    private val weaponPosition = BotOfst + 3
    private val cellPosition = BotOfst + 5
    var isShieldResistance = false//是否护盾抗


    /*******************************************************************
     *                        下面都是方法
     * *****************************************************************
     */
    override suspend fun generalControlMethod() {
        while (runSwitch) {
            Timber.d("nowStep:$nowStep generalControlMethod FightController NWQ_ 2023/3/10");
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
                START_BATTLE_NAVIGATION_MONITORING -> {
                    Timber.d("开始导航 generalControlMethod FightController NWQ_ 2023/3/10");
                    SPRepo.lastPickUpTaskTimeSp = System.currentTimeMillis()
                    nowStep = BATTLE_NAVIGATION_MONITORING
                }
                BATTLE_NAVIGATION_MONITORING -> {
                    startNavigationMonitoring()
                }
                COMBAT_MONITORING -> {
                    combatMonitoring()
                }
                START_MONITORING_RETURN_STATUS -> {
                    SPRepo.lastBackSpaceStation = System.currentTimeMillis()
                    nowStep = MONITORING_RETURN_STATUS
                }
                MONITORING_RETURN_STATUS -> {
                    monitoringReturnStatus()
                }
                ABNORMAL_STATE -> {
                    abnormalStateRepair()
                }
            }
        }
    }

    fun startGame() {
        GlobalScope.launch {
            pressHomeBtn()
            delay(2000)
            helper.click(
                (82 + (constant.APP_LOCATION_X - 1) * 254).toFloat(),
                (185 + (constant.APP_LOCATION_Y - 1) * 291).toFloat(),
                154,
                153
            )
            delay(doubleClickInterval * 2)
            generalControlMethod()
        }
//        takeScreen()
//        if (visual.hasIntoGame()) {
//            nowStep = STATUS_DETERMINATION
//        }
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
        takeScreen(2000)
        mNumberOfTasksReceived--
        var inSpaceStation = visual.isInSpaceStation()
        L.i(
            "准备接取任务  inSpaceStation: $inSpaceStation",
            "pickUpTask",
            "FightController",
            "nwq",
            "2023/3/2"
        );
        click(constant.getTopMenuArea(2))
        takeScreen(tripleClickInterval)
        if (visual.hasReceivedTask()) {
            Timber.d("已经存在任务 pickUpTask FightController NWQ_ 2023/3/10");
            if (needCancel) {
                cancelTask()
                Timber.d("需要取消已经存在的任务 pickUpTask FightController NWQ_ 2023/3/10");
                delay(normalClickInterval)
                return
            } else {
                click(constant.optTaskArea)
                clickTheDialogueClose(false)
                takeScreen(doubleClickInterval)
                ensureCloseDetermine()
                theOutCheck()
                nowStep = START_BATTLE_NAVIGATION_MONITORING
                return
            }
        }
        needCancel = false
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
            needCancel = true
            return
        }

        click(constant.openTaskRightArea)
        click(constant.openTaskDetermineArea, doubleClickInterval)

        //到这里就结束了
        if (!clickTheDialogueClose(true)) {
            Timber.d("接任务出现问题 needCancel:$needCancel  pickUpTask FightController NWQ_ 2023/3/10");
            theOutCheck()
        } else if (inSpaceStation) {
            click(constant.dialogDetermineArea, normalClickInterval)
            takeScreen(doubleClickInterval)
            ensureCloseDetermine()
            takeScreen(doubleClickInterval)
            ensureCloseDetermine()
            nowStep = START_BATTLE_NAVIGATION_MONITORING
        } else {
            takeScreen(doubleClickInterval)
            ensureCloseDetermine()
            takeScreen(doubleClickInterval)
            ensureCloseDetermine()
            nowStep = START_BATTLE_NAVIGATION_MONITORING
        }
    }

    suspend fun startNavigationMonitoring() {
        takeScreen(quadrupleClickInterval)
        if (visual.isShowDetermine()) {
            Timber.d("isShowDetermine startNavigationMonitoring FightController NWQ_ 2023/3/10");
            click(constant.dialogDetermineArea)
        } else if (visual.hasGroupLock()) {
            Timber.d("hasGroupLock startNavigationMonitoring FightController NWQ_ 2023/3/10");
            if (System.currentTimeMillis() - SPRepo.lastPickUpTaskTimeSp > constant.NAVIGATING_TOO_LONG) {
                needBackStation = true
            }
            nowStep = COMBAT_MONITORING
            battleStartTime = System.currentTimeMillis()
        } else if (System.currentTimeMillis() - SPRepo.lastPickUpTaskTimeSp > constant.NAVIGATING_EXCEPTION) {
            Timber.d("导航时间过长 startNavigationMonitoring FightController NWQ_ 2023/3/10");
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
            Timber.d("进入战斗超时 combatMonitoring FightController NWQ_ 2023/3/10");
            return
        }
        Timber.d("进入战斗监控 combatMonitoring FightController NWQ_ 2023/3/10");
        takeScreen(quadrupleClickInterval)
        if (ensureCloseDetermine()) {
            return
        }
        if (!mEnterCombatStatus) {
            if (canLockTargetDelay()) {
                click(constant.lockTargetGroupArea)
                takeScreen(doubleClickInterval)
                targetCount = visual.getTagNumber()
                if (targetCount > 1) {//锁定成功了
                    Timber.d("锁定成功了 combatMonitoring FightController NWQ_ 2023/3/10");
                    System.currentTimeMillis().let {
                        roundStartTime = it
                        targetReduceTime = it
                    }
                    mEnterCombatStatus = true
                    hasNewLock = true
                    openTheWholeBattle()
                    useUnlock = true
                } else {
                    Timber.d("没有锁定上继续导航 combatMonitoring FightController NWQ_ 2023/3/10");
                    //没有锁定上继续导航
                    useUnlock = false
                }
            } else if (System.currentTimeMillis() - battleStartTime > constant.INTO_BATTLE_EXCEPTION) {//进入战斗失败
                Timber.d("进入战斗失败 combatMonitoring FightController NWQ_ 2023/3/10");
                nowStep = ABNORMAL_STATE
            }
        } else {
            if (canLockTarget()) {//可以进行锁定
                Timber.d("可以进行锁定 combatMonitoring FightController NWQ_ 2023/3/10");
                click(constant.lockTargetGroupArea, normalClickInterval)
                takeScreen(doubleClickInterval)
                val nowTargetCount = visual.getTagNumber()
                System.currentTimeMillis().let {
                    roundStartTime = it
                    targetReduceTime = it
                }
                if (targetCount <= 1 && nowTargetCount >= 1) {
                    DESTROY_INTERVAL += DEFAULT_DESTROY_INTERVAL
                    hasNewLock = true
                    openTheWholeBattle()
                    targetCount = nowTargetCount
                } else if (targetCount >= 4 && hasNewLock) {
                    openDecelerationNet()
                    hasNewLock = false
                } else {//这里要做异常处理了 先不做处理

                }
            } else {//状态监控
                Timber.d("状态监控 combatMonitoring FightController NWQ_ 2023/3/10");
                val needCheckOpenList = mutableListOf<Int>()
                val needCheckCloseList = mutableListOf<Int>()
                val nowTargetCount = visual.getTagNumber()
                if (nowTargetCount > 0) {
                    if (catchFoodList.isNullOrEmpty()) {//这里就需要判断是否需要开启网子
                    } else if (nowTargetCount < targetCount) {
                        targetReduceTime = System.currentTimeMillis()
                        if (hasNewLock) {
                            hasNewLock = false
                            needCheckOpenList.addAll(catchFoodList)
                            DESTROY_INTERVAL = DEFAULT_DESTROY_INTERVAL + 80 * 1000
                        }
                    } else if (System.currentTimeMillis() - targetReduceTime > DESTROY_INTERVAL && nowTargetCount == targetCount || isAttackSmallShip()) {
                        targetReduceTime = System.currentTimeMillis()
                        needCheckOpenList.addAll(catchFoodList)
                        DESTROY_INTERVAL = DEFAULT_DESTROY_INTERVAL + 80 * 1000
                    }
                    //这里是为了一块检测
                    needCheckOpenList.addAll(wholeBattleOpenList)
                    needCheckOpenList.addAll(roundBattleOpenList)
                    needCheckOpenList.add(weaponPosition)

                    //打开定时开启的
                    checkTimingOnList(needCheckOpenList)

                    //这个是判断是否需要开关维修
                    bloodVolumeMonitoring(needCheckOpenList, needCheckCloseList)

                    //这里是判断点击
                    clickEquipArray(checkEquipTimes(2, needCheckOpenList, needCheckCloseList))
                } else {
                    needCheckOpenList.addAll(wholeBattleOpenList)
                    needCheckOpenList.addAll(roundBattleOpenList)
                    needCheckOpenList.add(weaponPosition)
                    val closeList = checkEquipTimes(2, needCheckOpenList, null)
                    if (closeList.contains(weaponPosition) && closeList.contains(cellPosition)) {//这里表示已经关闭的
                        if (visual.hasLeftDialogue() || visual.hasRightDialogue()) {
                            //这里要做异常处理了 这里表示战斗结束了
                            if (clickTheDialogueClose(false)) {
                                closeTheWholeBattle()
                                if (needBackStation) {
                                    nowStep = ABNORMAL_STATE
                                } else {
                                    nowStep = PICK_UP_TASK
                                }
                            }
                        }

                    } else {
                        clickEquipArray(closeList)
                    }
                }
            }
        }
    }

    //监听是否已经抵达空间战  numberCount是循环监听次数  failedCode是失败时候执行的命令码  successCode是成功过时候执行的命令码
    suspend fun monitoringReturnStatus() {
        if (System.currentTimeMillis() - SPRepo.lastBackSpaceStation > constant.MAX_BATTLE_TIME) {
            nowStep = ABNORMAL_STATE
            return
        }
        takeScreen(quadrupleClickInterval)
        if (visual.getTagNumber() > 4 || visual.hasGroupLock()) {
            nowStep = COMBAT_MONITORING
        } else if (visual.isInSpaceStation()) {
            if (needBackStation) {
                (System.currentTimeMillis() + constant.REFRESH_INTERVAL - lastRefreshTimeSp).let {
                    if (it > 0) {
                        delay(it)
                    }
                }
            }
            needBackStation = false
            nowStep = PICK_UP_TASK
        }
    }


    fun checkTimingOnList(needCheckOpenList: MutableList<Int>) {
        if (targetCount <= 1) {
            return
        }
        var nowTime = System.currentTimeMillis()
        if (checkTimeOn(
                timeOnOpenList3, nowTime, CombatStamp_3, BASIC_COMBAT_INTERVAL_3, needCheckOpenList
            )
        ) {
            CombatStamp_3 = nowTime
        }
        if (checkTimeOn(
                timeOnOpenList2, nowTime, CombatStamp_2, BASIC_COMBAT_INTERVAL_2, needCheckOpenList
            )
        ) {
            CombatStamp_2 = nowTime
        }
        if (checkTimeOn(
                timeOnOpenList1, nowTime, CombatStamp_1, BASIC_COMBAT_INTERVAL_1, needCheckOpenList
            )
        ) {
            CombatStamp_1 = nowTime
        }
    }


    fun checkTimeOn(
        list: List<Int>,
        nowtime: Long,
        lastTime: Long,
        combatInterval: Long,
        needCheckOpenList: MutableList<Int>
    ): Boolean {
        var flag = false
        if (list.isNullOrEmpty()) { //true
            return flag
        }
        val intervalTime = nowtime - lastTime
        list.forEachIndexed { i, d ->
            if (i == 0) {
                if (intervalTime > combatInterval) {
                    needCheckOpenList.add(0, d)
                    flag = true
                }
            } else if (intervalTime in (i * Equipment_Interval)..(i + 1 * Equipment_Interval)) {
                needCheckOpenList.add(0, d)
            }
        }
        return flag
    }

    suspend fun bloodVolumeMonitoring(
        needCheckOpenList: MutableList<Int>, needCheckCloseList: MutableList<Int>
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


    suspend fun checkEquipTimes(
        times: Int, closeData: List<Int>?, openData: List<Int>?
    ): List<Int> {
        var list = mutableListOf<Int>()
        var list2 = mutableListOf<Int>()
        for (i in 0 until times) {
            takeScreen(normalClickInterval)
            closeData?.let {
                val result = checkEquipStatusClose(closeData)
                list = if (i == 0) {
                    result
                } else {
                    list.filter { result.contains(it) }.toMutableList()
                }
            }
            openData?.let {
                val result2 = checkEquipStatusOpen(openData)
                list2 = if (i == 0) {
                    result2
                } else {
                    list2.filter { result2.contains(it) }.toMutableList()
                }
            }
        }
        list.addAll(list2)
        return list
    }


    suspend fun openCheckEquipTimes(times: Int, vararg data: List<Int>): List<Int> {
        var list = listOf<Int>()
        for (i in 0 until times) {
            takeScreen(normalClickInterval)
            val result = checkEquipStatusClose(*data)
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
        Timber.d("clickTheDialogueClose clickTheDialogueClose NWQ_ 2023/3/10");
        while (flag > 0) {
            takeScreen(normalClickInterval)
            if (visual.hasLeftDialogue()) {
                Timber.d("hasLeftDialogue clickTheDialogueClose NWQ_ 2023/3/10");
                click(constant.leftDialogueArea)
                click(constant.leftDialogueArea, fastClickInterval)
                hasClickConversation = true
                flag = 10
            } else if (visual.hasRightDialogue()) {
                Timber.d("hasRightDialogue clickTheDialogueClose NWQ_ 2023/3/10");
                click(constant.rightDialogueArea)
                rightClickTimes++
                flag = 10
            } else if (visual.isShowDetermine()) {
                Timber.d("isShowDetermine clickTheDialogueClose NWQ_ 2023/3/10");
                if (pickUp && rightClickTimes > 3 && !receiveAdvancedTasks) {
                    needCancel = true
                    hasClickConversation = false
                    click(constant.dialogCancleArea)
                } else {
                    click(constant.dialogDetermineArea)
                    hasClickConversation = true
                }
                flag = 0
            } else {
                Timber.d("isShowDetermine clickTheDialogueClose NWQ_ 2023/3/10");
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
        Timber.d("取消任务 cancelTask FightController NWQ_ 2023/3/10");
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
        L.i("", "theOutCheck", "FightController", "nwq", "2023/3/8");
        var count = 3
        var flag = true
        do {
            takeScreen(doubleClickInterval)
            count--
            var flag = visual.isInSpaceStation() || visual.hasEyesMenu()
            if (visual.isOpenBigMenu()) {
                click(constant.closeBigMenuArea)
            } else {
                ensureCloseDetermine()
            }
        } while (!flag && count > 0)
    }

    //获取是关闭的状态
    private fun checkEquipStatusClose(vararg data: List<Int>): MutableList<Int> {
        val unOpenList = mutableListOf<Int>()
        data.forEach {
            it.forEach { index ->
                if (!judgeIsOpen(index)) {
                    unOpenList.add(index)
                }
            }
        }
        return unOpenList
    }


    //获取是开启的状态
    private fun checkEquipStatusOpen(vararg data: List<Int>): MutableList<Int> {
        val unOpenList = mutableListOf<Int>()
        data.forEach {
            it.forEach { index ->
                if (judgeIsOpen(index)) {
                    unOpenList.add(index)
                }
            }
        }
        return unOpenList
    }

    suspend fun clickEquipArray(list: List<Int>, delay: Long = fastClickInterval) {
        Timber.d("${JsonUtil.objectToString(list)} 点击数组有 FightController NWQ_ 2023/3/10");
        list.forEach {
            clickEquip(it, delay)
        }
    }

    private suspend fun clickEquip(index: Int, delay: Long) {
        if (index < TopOfst) {
            click(constant.getBottomEquipArea(index), delay)
        } else {
            click(constant.getTopEquipArea(index - TopOfst - 1), delay)
        }
    }

    fun judgeIsOpen(index: Int): Boolean {
        return if (index < TopOfst) {
            visual.judgeIsOpenBottom(index)
        } else {
            visual.judgeIsOpenTop(index - TopOfst - 1)
        }
    }

    fun isAttackSmallShip(): Boolean {
        var position = getNowAttackPosition()
        if (position > 0) {
            var result = visual.judgeIsSmall(position - 1)
            // log("正在攻击目标" + position + "是否是小船" + result)
            return result
        } else {
            return false
        }
    }

    fun getNowAttackPosition(): Int {
        var index = targetCount
        var flag = false
        do {
            index--
            flag = !visual.judgeNowAttackPosition(index)
        } while (!flag && index >= 0)
        return index + 1
    }


    suspend fun exit() {
        theOutCheck()
        clickJumpCollectionAddress(constant.WAREHOUSE_INDEX, false)
        runSwitch = false
    }

    suspend fun ensureOpenPositionMenu() {
        var flag = 3
        while (!visual.hasPositionMenu() && flag > 0) {
            click(constant.eraseWarningArea)
            takeScreen(doubleClickInterval)
        }
        if (visual.isClosePositionMenu()) {
            click(constant.eraseWarningArea)
        } else if (!visual.isDefaultCoordinateMenu()) {
            click(constant.defaultCoordinateMenuArea)
        }
    }


    suspend fun abnormalStateRepair() {
        Timber.d("abnormalStateRepair FightController NWQ_ 2023/3/10");
        theOutCheck()
        needCancel = true
        needBackStation = true
        clickJumpCollectionAddress(constant.WAREHOUSE_INDEX, false)
        nowStep = MONITORING_RETURN_STATUS
    }

    //determine 是否需要点击确定按钮，一般出舱是需要的
    suspend fun clickJumpCollectionAddress(index: Int, determine: Boolean) {
        ensureOpenPositionMenu()
        click(constant.getAddressArea(index), normalClickInterval)
        if (determine) {
            click(constant.dialogDetermineArea, normalClickInterval)
        }
    }

    //战斗开始时候需要开启的
    fun closeTheWholeBattle() {
        mEnterCombatStatus = false
        useUnlock = true
        DESTROY_INTERVAL = 50 * 1000
    }
}