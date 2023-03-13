package com.nwq.function.scheduling.executer.fight

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController
import com.nwq.function.scheduling.utils.JsonUtil
import com.nwq.function.scheduling.utils.sp.SP
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
弹出的活动窗口需要处理
 */

class FightController(p: AccessibilityHelper, c: () -> Boolean) : TravelController(p, c) {

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
    private val EXIT_OPT = 10000 //异常状态

    private val TopOfst = SpConstant.TopOfst//顶部的偏移量
    private val BotOfst = SpConstant.BotOfst//底部的便宜量

    val prefixRole by lazy { SPRepo.role }


    private val STATUS_DETERMINATION = 1000000//这个是进行状态判定
    private val receiveAdvancedTasks = false //是否接受高级任务

    val UNKNOWN_STATE = 0
    val OFF_STATE = 1
    val ON_STATE = 2
    var maintenanceStatus = UNKNOWN_STATE
    var maintenanceTimeStartStamp = 0L
    var MAINTENANCE_INTERVAL = 30000L //维修间隔
    var DEFAULT_DESTROY_INTERVAL = 80 * 1000 //能够容忍的最大击毁间隔
    var DESTROY_INTERVAL = DEFAULT_DESTROY_INTERVAL //能够容忍的最大击毁间隔
    val warehouseIndex by lazy {
        SP.getValue(prefixRole + SpConstant.BASE_LOCATION, 0)
    }

    /**
     * 这个是控制变量
     */
    private var nowStep = INTO_GAME
    var needCancel = false
    var needBackStation = false
    var mNumberOfTasksReceived = 51
    private val visual by lazy {
        FightVisualEnvironment(helper)
    }
    private val constant by lazy {
        FightConstant()
    }
    val isPickupBox by lazy {
        SP.getValue(prefixRole + SpConstant.IS_PICKUP_BOX, false)
    }

    //后面这里由外部读取数据进行初始化
    private val wholeBattleOpenList by lazy {
        val listStr = SP.getValue(prefixRole + SpConstant.WHOLE_BATTLE_LIST, "[1,8]")
        JsonUtil.anyToJsonObject(listStr) ?: listOf<Int>(BotOfst + 2, TopOfst + 2)
    }
    private val roundBattleOpenList by lazy {
        val listStr = SP.getValue(prefixRole + SpConstant.ROUND_BATTLE_LIST, "[4,5]")
        JsonUtil.anyToJsonObject(listStr) ?: listOf<Int>(BotOfst + 5, BotOfst + 6)
    }
    private val timeOnOpenList1 by lazy {
        val listStr = SP.getValue(prefixRole + SpConstant.TIME_ON_LIST1, "[11,12]")
        JsonUtil.anyToJsonObject(listStr) ?: listOf(TopOfst + 5, TopOfst + 6)
    }
    private val timeOnOpenList2 by lazy {
        val listStr = SP.getValue(prefixRole + SpConstant.TIME_ON_LIST2, "")
        JsonUtil.anyToJsonObject(listStr) ?: listOf<Int>()
    }
    private val timeOnOpenList3 by lazy {
        val listStr = SP.getValue(prefixRole + SpConstant.TIME_ON_LIST3, "[10]")
        JsonUtil.anyToJsonObject(listStr) ?: listOf<Int>(4 + TopOfst)
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
    var isCatchFoodSp by SP(prefixRole + SpConstant.IS_CATCH_FOOD, true)
    private val catchFoodList by lazy {
        if (isCatchFoodSp) listOf<Int>(1 + BotOfst, 4 + BotOfst)
        else listOf<Int>()
    }
    private val maintenanceDevicePosition = TopOfst + 1
    private val weaponPosition = BotOfst + 3
    private val cellPosition = BotOfst + 5
    private val pickUpPosition = BotOfst + 6
    val isShieldResistance by lazy {
        SP.getValue(prefixRole + SpConstant.CRESISTANCE_MODE, false)
    }//是否护盾抗


    /*******************************************************************
     *                        下面都是方法
     * *****************************************************************
     */
    fun startGame() {
        GlobalScope.launch {
            takeScreen(normalClickInterval)
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
    }

    suspend fun exitGame() {
        theOutCheck()
        //clickJumpCollectionAddress(warehouseIndex, false) 退出游戏导航也没有用
        pressBackBtn()
        delay(helper.defultClickDuration * 2)
        click((1371 - 20).toFloat(), (708 - 20).toFloat(), 40, 40)
        takeScreen(doubleClickInterval)
        runSwitch = false
        onComplete.invoke()
    }

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
                EXIT_OPT -> {
                    runSwitch = false
                    exitGame()
                }
            }
        }
    }


    suspend fun intoGame() {
        var flag = true
        do {
            takeScreen(doubleClickInterval)
            if (visual.showAnnouncement()) {
                click(constant.closeAnnouncementArea)
            } else if (visual.readStartGame()) {
                click(constant.startGameArea)
            } else if (visual.selectRole()) {
                click(constant.selectRoleArea)
            } else if (visual.isOpenBigMenu()) {
                click(constant.closeBigMenuArea)
            } else if (visual.hasIntoGame()) {
                flag = false
                nowStep = PICK_UP_TASK
            }
        } while (flag)
    }


    suspend fun pickUpTask() {
        if (mNumberOfTasksReceived <= 0) {
            nowStep = EXIT_OPT
            return
        }
        clickTheDialogueClose(false)
        takeScreen(2000)
        mNumberOfTasksReceived--
        var inSpaceStation = visual.isInSpaceStation()
        Timber.d("准备接取任务  inSpaceStation: $inSpaceStation pickUpTask FightController NWQ_ 2023/3/12");
        click(constant.getTopMenuArea(2))
        takeScreen(tripleClickInterval)
        if (visual.hasReceivedTask()) {
            Timber.d("已经存在任务 pickUpTask FightController NWQ_ 2023/3/10");
            if (needCancel) {
                cancelTask()
                needCancel = false
                Timber.d("需要取消已经存在的任务 pickUpTask FightController NWQ_ 2023/3/10");
                delay(normalClickInterval)
                return
            } else {
                click(constant.optTaskArea)
                takeScreen(doubleClickInterval)
                if (visual.hasReceivedTask()) {
                    clickTheDialogueClose(true)
                    takeScreen(doubleClickInterval)
                    ensureCloseDetermine()
                    theOutCheck()
                    nowStep = START_BATTLE_NAVIGATION_MONITORING
                    return
                }//有可能任务红了就继续走
            }
        }
        needCancel = false
        //打开新闻公告板
        click(constant.newTaskListArea, doubleClickInterval)
        takeScreen(doubleClickInterval)

        if (visual.isCompleteAllTask()) {//全部的任务已经完成
            nowStep = EXIT_OPT
            return
        }

        if (needRefreshTask()) {
            click(constant.refreshTaskListArea, doubleClickInterval)
            lastRefreshTimeSp = System.currentTimeMillis()
            takeScreen(doubleClickInterval)
        }
        if (!receiveAdvancedTasks && visual.isHighTask()) {
            Timber.d("发现高级任务  pickUpTask FightController NWQ_ 2023/3/12");
            click(constant.pickUpTask2Area)
        } else {
            click(constant.pickUpTask1Area)
        }
        takeScreen(doubleClickInterval)
        ensureCloseDetermine()//低安要点确定
        takeScreen(doubleClickInterval)
        if (!receiveAdvancedTasks && visual.isHighTaskRight())//如果右边是高级任务也进行取消
        {
            Timber.d("发现高级任务右侧  pickUpTask FightController NWQ_ 2023/3/12");
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
            needCancel = true
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
        } else if (visual.hasGroupLock() || visual.getTagNumber() > 1) {
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
        } else if ((visual.hasRightDialogue() || visual.hasLeftDialogue()) && visual.isClosePositionMenu()) {
            needCancel = true
            clickTheDialogueClose(false)
            Timber.d("还有左侧未点击的 startNavigationMonitoring FightController NWQ_ 2023/3/10");
            nowStep = PICK_UP_TASK
        }


    }

    var battleStartTime = 0L //这个是开始战斗监控的时间
    var mEnterCombatStatus = false //这个是进入战斗的时间
    var roundStartTime = 0L  //这个是新的一轮开始的时间
    var targetReduceTime = 0L //这个是上次目标减少的时间
    var targetCount = 0
    var hasNewLock = false
    var useUnlock = true //是否使用右上角的未锁定数进行锁定
    var hasOpenCatch = false
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
                    hasOpenCatch = false
                    openTheWholeBattle()
                    useUnlock = true
                } else {
                    Timber.d("没有锁定上继续导航 combatMonitoring FightController NWQ_ 2023/3/10");
                    //没有锁定上继续导航
                    useUnlock = false
                }
            } else if (visual.getTagNumber() > 0 || judgeIsOpen(weaponPosition)) {
                Timber.d("存在锁定目标 combatMonitoring FightController NWQ_ 2023/3/10");
                System.currentTimeMillis().let {
                    roundStartTime = it
                    targetReduceTime = it
                }
                mEnterCombatStatus = true
                hasNewLock = true
                hasOpenCatch = false
                openTheWholeBattle()
                useUnlock = true
            } else if (System.currentTimeMillis() - battleStartTime > constant.INTO_BATTLE_EXCEPTION) {//进入战斗失败
                Timber.d("进入战斗失败 combatMonitoring FightController NWQ_ 2023/3/10");
                useUnlock = false
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
                if (targetCount <= 1 && nowTargetCount > 3) {
                    hasNewLock = true
                    hasOpenCatch = false
                    openTheWholeBattle()
                    targetCount = nowTargetCount
                    useUnlock = true
                } else if (targetCount >= 3 && (hasNewLock || nowTargetCount > targetCount)) {
                    targetCount = nowTargetCount
                    openDecelerationNet()
                    if (checkEquipTimes(
                            2,
                            listOf(),
                            catchFoodList
                        ).isNotEmpty()
                    ) {
                        hasOpenCatch = true
                    }
                    hasNewLock = false
                    useUnlock = true
                } else {//这里要做异常处理了 先不做处理
                    useUnlock = false
                }
            } else {//状态监控
                Timber.d("状态监控 combatMonitoring FightController NWQ_ 2023/3/10");
                val needCheckOpenList = mutableListOf<Int>()
                val needCheckCloseList = mutableListOf<Int>()
                val nowTargetCount = visual.getTagNumber()
                if (nowTargetCount > 0) {
                    if (catchFoodList.isNullOrEmpty()) {//这里就需要判断是否需要开启网子
                    } else if (nowTargetCount > targetCount && hasNewLock == true) {
                        targetCount = nowTargetCount
                    } else if (nowTargetCount < targetCount) {
                        targetReduceTime = System.currentTimeMillis()
                        if (hasNewLock) {
                            hasNewLock = false
                            needCheckOpenList.addAll(catchFoodList)
                        } else if (isAttackSmallShip()) {
                            needCheckOpenList.addAll(catchFoodList)
                        }
                        targetCount = nowTargetCount
                    } else if (hasOpenCatch) {
                        if ((System.currentTimeMillis() - targetReduceTime > DESTROY_INTERVAL * 4 && nowTargetCount >= targetCount)) {
                            targetReduceTime = System.currentTimeMillis()
                            needCheckOpenList.addAll(catchFoodList)
                        }
                    } else if ((System.currentTimeMillis() - targetReduceTime > DESTROY_INTERVAL && nowTargetCount >= targetCount) || isAttackSmallShip()) {
                        targetReduceTime = System.currentTimeMillis() - DESTROY_INTERVAL / 2
                        needCheckOpenList.addAll(catchFoodList)
                    }
                    //这里是为了一块检测
                    needCheckOpenList.addAll(wholeBattleOpenList)
                    needCheckOpenList.addAll(roundBattleOpenList)
                    needCheckOpenList.add(weaponPosition)
                    if (isPickupBox && !needBackStation)//这里为了校验开关清空
                        needCheckOpenList.add(pickUpPosition)

                    //打开定时开启的
                    checkTimingOnList(needCheckOpenList)

                    //这个是判断是否需要开关维修
                    bloodVolumeMonitoring(needCheckOpenList, needCheckCloseList)

                    //这里是判断点击
                    val list = checkEquipTimes(2, needCheckOpenList, needCheckCloseList)
                    if (isPickupBox) {
                        if (list.contains(pickUpPosition)) {
                            if (visual.warehouseIsFull()) {
                                needBackStation = true
                            }
                            list.remove(pickUpPosition)
                        }
                    }
                    clickEquipArray(list)


                    if (!hasOpenCatch && needCheckOpenList.contains(0) && checkEquipTimes(
                            2,
                            listOf(),
                            catchFoodList
                        ).isNotEmpty()
                    ) {
                        Timber.d("hasOpenCatch:$hasOpenCatch combatMonitoring FightController NWQ_ 2023/3/13");
                        hasOpenCatch = true
                    }

                } else {
                    needCheckOpenList.addAll(wholeBattleOpenList)
                    needCheckOpenList.addAll(roundBattleOpenList)
                    needCheckOpenList.add(weaponPosition)
                    val closeList = checkEquipTimes(2, needCheckOpenList, null)
                    if (closeList.contains(weaponPosition) && closeList.contains(cellPosition)) {//这里表示已经关闭的
                        if (visual.hasLeftDialogue() || visual.hasRightDialogue()) {
                            //这里要做异常处理了 这里表示战斗结束了
                            clickTheDialogueClose(false)
                            closeTheWholeBattle()
                            if (needBackStation) {
                                nowStep = ABNORMAL_STATE
                            } else {
                                nowStep = PICK_UP_TASK
                            }
                        } else if (targetReduceTime - System.currentTimeMillis() > 60 * 1000L) {//防止卡住
                            closeTheWholeBattle()
                            nowStep = PICK_UP_TASK
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
        takeScreen(quadrupleClickInterval * 2)
        if (System.currentTimeMillis() - SPRepo.lastBackSpaceStation > constant.MAX_BATTLE_TIME * 2) {
            if (visual.isSailing()) {
                SPRepo.lastBackSpaceStation = System.currentTimeMillis() - constant.MAX_BATTLE_TIME
            } else {
                nowStep = ABNORMAL_STATE
            }
            return
        }
        if (visual.getTagNumber() > 4 || visual.hasGroupLock()) {
            nowStep = COMBAT_MONITORING
        } else if (visual.isInSpaceStation()) {
            if (needBackStation && needCancel) {
                (System.currentTimeMillis() + constant.REFRESH_INTERVAL - lastRefreshTimeSp).let {
                    if (it > 0) {
                        delay(it)
                    }
                }
            }
            if (isPickupBox) {
                unloadingCargo()
            }
            needBackStation = false
            nowStep = PICK_UP_TASK
        } else if (needCancel && visual.isClosePositionMenu() && visual.hasRightDialogue()) {
            clickTheDialogueClose(true)
        } else if (visual.isOpenBigMenu()) {
            click(constant.closeBigMenuArea)
        }
    }


    fun checkTimingOnList(needCheckOpenList: MutableList<Int>) {
        if (targetCount <= 1) {
            Timber.d("目标是 checkTimingOnList FightController NWQ_ 2023/3/10");
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
            } else if (intervalTime in (i * Equipment_Interval)..((i + 1) * Equipment_Interval)) {
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
        if (isPickupBox) {
            clickEquipArray(
                openCheckEquipTimes(
                    2,
                    wholeBattleOpenList,
                    roundBattleOpenList,
                    listOf(pickUpPosition)
                )
            )
        } else {
            clickEquipArray(openCheckEquipTimes(2, wholeBattleOpenList, roundBattleOpenList))
        }

    }


    suspend fun checkEquipTimes(
        times: Int, closeData: List<Int>?, openData: List<Int>?
    ): MutableList<Int> {
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
        var flag = 2
        Timber.d("clickTheDialogueClose clickTheDialogueClose NWQ_ 2023/3/10");
        while (flag > 0) {
            takeScreen(normalClickInterval)
            if (visual.hasLeftDialogue()) {
                Timber.d("hasLeftDialogue clickTheDialogueClose NWQ_ 2023/3/10");
                click(constant.leftDialogueArea)
                click(constant.leftDialogueArea, fastClickInterval)
                hasClickConversation = true
                flag = 2
            } else if (visual.hasRightDialogue()) {
                Timber.d("hasRightDialogue clickTheDialogueClose NWQ_ 2023/3/10");
                click(constant.rightDialogueArea)
                rightClickTimes++
                flag = 2
            } else if (visual.isShowDetermine()) {
                Timber.d("isShowDetermine clickTheDialogueClose NWQ_ 2023/3/10");
                if (needCancel || (rightClickTimes >= 1 && !receiveAdvancedTasks)) {
                    needCancel = true
                    needBackStation = true
                    hasClickConversation = false
                    click(constant.dialogCancleArea)
                } else {
                    click(constant.dialogDetermineArea)
                    hasClickConversation = true
                }
                flag = 0
            } else {
                Timber.d("Nothing clickTheDialogueClose NWQ_ 2023/3/10");
                flag--
            }
        }

        return hasClickConversation
    }

    private fun needRefreshTask(): Boolean {
        return System.currentTimeMillis() - lastRefreshTimeSp > constant.REFRESH_INTERVAL && visual.canRefresh()
    }


    private fun canLockTarget(): Boolean {
        return visual.hasGroupLock() || (useUnlock && visual.isClosePositionMenu() && visual.getUnTagNumber() > 3 && visual.getTagNumber() < 2)
    }

    private suspend fun canLockTargetDelay(): Boolean {
        return if (visual.hasGroupLock()) {
            true
        } else if (useUnlock && visual.isClosePositionMenu() && visual.getUnTagNumber() > 3 && visual.getTagNumber() < 2) {
            delay(5 * 1000)
            true
        } else {
            false
        }
    }

    suspend fun cancelTask() {
        Timber.d("取消任务 cancelTask FightController NWQ_ 2023/3/10");
        click(constant.openTaskArea, normalClickInterval)
        click(constant.cancelTaskArea, doubleClickInterval)
        click(constant.dialogDetermineArea, doubleClickInterval)
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
        Timber.d("  theOutCheck FightController NWQ_ 2023/3/12");
        var flag = true
        while (flag) {
            takeScreen(doubleClickInterval)
            if (visual.isOpenBigMenu()) {
                click(constant.closeBigMenuArea)
            } else if (visual.hasIntoGame()) {
                flag = false
            } else if (visual.hasPositionMenu() && visual.hasRightDialogue()) {
                flag = false
            } else if (visual.isShowDetermine()) {
                click(constant.dialogDetermineArea)
            } else {
                click(constant.closeBigMenuArea)
            }
        }
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

    suspend fun clickEquipArray(list: List<Int>) {
        Timber.d("${JsonUtil.objectToString(list)} 点击数组有 FightController NWQ_ 2023/3/10");
        if (list.isNullOrEmpty()) {
            return
        }
        click(list.map { index ->
            if (index < TopOfst) {
                constant.getBottomEquipArea(index)
            } else {
                constant.getTopEquipArea(index - TopOfst - 1)
            }
        })
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


    var judgeSmallShipTargetCount = 0
    var lastJudgeIsSmallShip = 0L

    fun isAttackSmallShip(): Boolean {
        if (targetCount <= 0) return false
        var position = getNowAttackPosition()
        if (position > 0) {
            judgeSmallShipTargetCount = targetCount
            var result = visual.judgeIsSmall(position)
            lastJudgeIsSmallShip = System.currentTimeMillis()
            Timber.d("position:$position result:$result  isAttackSmallShip FightController NWQ_ 2023/3/11");
            return result
        } else {
            if (!hasOpenCatch && judgeSmallShipTargetCount == targetCount && System.currentTimeMillis() - lastJudgeIsSmallShip > 30 * 1000L) {
                lastJudgeIsSmallShip = System.currentTimeMillis()
                Timber.d("无法识别船 认定位小船  isAttackSmallShip FightController NWQ_ 2023/3/11");
                return true
            }
            lastJudgeIsSmallShip = System.currentTimeMillis()
            judgeSmallShipTargetCount = targetCount
            return false
        }
    }

    fun getNowAttackPosition(): Int {
        for (index in targetCount - 1 downTo 0) {
            if (visual.judgeNowAttackPosition(index)) {
                return index
            }
        }
        return -1
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
        clickJumpCollectionAddress(warehouseIndex, false)
        nowStep = START_MONITORING_RETURN_STATUS
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

    //卸载货物
    suspend fun unloadingCargo() {
        click(constant.getTopMenuArea(1))
        click(constant.generalWarehouseArea, quadrupleClickInterval)
        takeScreen(quadrupleClickInterval)
        if (visual.isEmptyWarehouse()) {
            theOutCheck()
        } else {
            click(constant.warehouseSelectAllArea, quadrupleClickInterval)
            click(constant.warehouseMoveArea, quadrupleClickInterval)
            click(constant.warehouseAllArea, quadrupleClickInterval)
            theOutCheck()
        }
    }

}