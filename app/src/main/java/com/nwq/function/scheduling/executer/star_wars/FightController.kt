package com.nwq.function.scheduling.executer.star_wars


import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.utils.JsonUtil
import kotlinx.coroutines.delay
import timber.log.Timber

/**
create by: 86136
create time: 2023/2/28 10:43
Function description:
这个是逻辑控制流程,保证能复用
弹出的活动窗口需要处理
 */

class FightController(p: AccessibilityHelper, c: () -> Boolean) : BaseController(p, c) {

    /**
     * 这个是状态常规量
     */
    private val DAMAGE = -100 //飞船已经损毁
    private val START_GAME = 0  //开始游戏

    //  private val INTO_GAME = 1 //进入游戏
    private val PICK_UP_TASK = 2 //接取任务
    private val START_BATTLE_NAVIGATION_MONITORING = 4//战斗飞行导航监控
    private val BATTLE_NAVIGATION_MONITORING = 5//战斗飞行导航监控
    private val COMBAT_MONITORING = 6 //战斗监控阶段
    private val START_MONITORING_RETURN_STATUS = 7//返回空间站监听
    private val MONITORING_RETURN_STATUS = 8//返回空间站监听
    private val ALL_COMPLETE = 9//返回空间站监听
    private val ABNORMAL_STATE = 1000 //异常状态
    private val EXIT_OPT = 10000 //异常状态


    private val STATUS_DETERMINATION = 1000000//这个是进行状态判定
    private val receiveAdvancedTasks = false //是否接受高级任务

    val UNKNOWN_STATE = 0
    val OFF_STATE = 1
    val ON_STATE = 2
    var maintenanceStatus = UNKNOWN_STATE

    var DEFAULT_DESTROY_INTERVAL = 80 * 1000 //能够容忍的最大击毁间隔
    var DESTROY_INTERVAL = DEFAULT_DESTROY_INTERVAL //能够容忍的最大击毁间隔
    val warehouseIndex = spReo.fightBaseLocation

    /**
     * 这个是控制变量
     */
    private var nowStep = START_GAME
    var needCancel = false
    var neeForceRefresh = false
    var needBackStation = false
    var mNumberOfTasksReceived = 50

    val isPickupBox = spReo.isPickupBox

    //后面这里由外部读取数据进行初始化
    private val wholeBattleOpenList by lazy {
        JsonUtil.anyToJsonObject(spReo.wholeBattleList) ?: listOf<Int>()
    }
    private val roundBattleOpenList by lazy {
        JsonUtil.anyToJsonObject(spReo.roundBattleList) ?: listOf<Int>()
    }
    private val timeOnOpenList1 by lazy {
        JsonUtil.anyToJsonObject(spReo.timeOnList1) ?: listOf<Int>()
    }
    private val timeOnOpenList2 by lazy {
        JsonUtil.anyToJsonObject(spReo.timeOnList2) ?: listOf<Int>()
    }
    private val timeOnOpenList3 by lazy {
        JsonUtil.anyToJsonObject(spReo.timeOnList3) ?: listOf<Int>()
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
    var isCatchFoodSp =spReo.isCatchFood
    private val catchFoodList by lazy {
        if (isCatchFoodSp) listOf<Int>(1 + BotOfst, 4 + BotOfst)
        else listOf<Int>()
    }


    /*******************************************************************
     *                        下面都是方法
     * *****************************************************************
     */
    private suspend fun startGame() {
        mNumberOfTasksReceived = 50
        takeScreen(normalClickInterval)
        delay(2000)
        click(constant.getAppArea())
        delay(doubleClickInterval * 2)
        intoGame()
        nowStep = PICK_UP_TASK
        spReo.lastBackSpaceStation = 0
        spReo.lastRefreshTime = 0
        spReo.lastPickUpTaskTime = 0
    }

    private suspend fun exitGame() {
        theOutCheck()
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
                PICK_UP_TASK -> {
                    pickUpTask()
                }
                START_BATTLE_NAVIGATION_MONITORING -> {
                    Timber.d("开始导航 generalControlMethod FightController NWQ_ 2023/3/10");
                    spReo.lastPickUpTaskTime = System.currentTimeMillis()
                    nowStep = BATTLE_NAVIGATION_MONITORING
                }
                BATTLE_NAVIGATION_MONITORING -> {
                    startNavigationMonitoring()
                }
                COMBAT_MONITORING -> {
                    combatMonitoring()
                }
                START_MONITORING_RETURN_STATUS -> {
                    spReo.lastBackSpaceStation = System.currentTimeMillis()
                    nowStep = MONITORING_RETURN_STATUS
                }
                MONITORING_RETURN_STATUS -> {
                    monitoringReturnStatus()
                }
                ABNORMAL_STATE -> {
                    abnormalStateRepair()
                }
                ALL_COMPLETE -> {
                    onAllComplete()
                }
                EXIT_OPT -> {
                    runSwitch = false
                    exitGame()
                }
            }
        }
    }

    private suspend fun onAllComplete() {
        if (openHarvestVegetablesSP) {
            theOutCheck()
            if (openHarvestVegetablesSP && System.currentTimeMillis() - resourcesCollectTimeSp > constant.COLLECT_INTERVAL) {
                harvestVegetableController.startCollectVegetables()
            } else {
                harvestVegetableController.addPlanetaryTime()
            }
            delay(normalClickInterval)
        }
        nowStep = EXIT_OPT
    }


    private suspend fun pickUpTask() {
        if (mNumberOfTasksReceived <= 0) {
            nowStep = ALL_COMPLETE
            return
        }
        takeScreen(2000)

        var inSpaceStation = visual.isInSpaceStation()
        Timber.d("准备接取任务  inSpaceStation: $inSpaceStation pickUpTask FightController NWQ_ 2023/3/12");
        click(constant.getTopMenuArea(2))
        takeScreen(tripleClickInterval)
        if (visual.hasReceivedTask()) {
            clickTheDialogueClose(false)
            takeScreen(doubleClickInterval)
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
        }
        needCancel = false
        //打开新闻公告板
        delay(normalClickInterval)
        click(constant.newTaskListArea)
        takeScreen(doubleClickInterval)

        if (visual.isCompleteAllTask()) {//全部的任务已经完成
            nowStep = ALL_COMPLETE
            return
        }

        if (neeForceRefresh) {
            if (visual.canRefresh()) {
                click(constant.refreshTaskListArea)
                spReo.lastRefreshTime = System.currentTimeMillis()
                takeScreen(doubleClickInterval)
            } else {
                (System.currentTimeMillis() + constant.REFRESH_INTERVAL - spReo.lastRefreshTime).let {
                    if (it > 0) {
                        delay(it)
                    }
                }
            }
            neeForceRefresh = false
        } else if (needRefreshTask()) {
            click(constant.refreshTaskListArea)
            spReo.lastRefreshTime = System.currentTimeMillis()
            takeScreen(doubleClickInterval)
        }

        if (!receiveAdvancedTasks && visual.isHighTask()) {
            Timber.d("发现高级任务  pickUpTask FightController NWQ_ 2023/3/12");
            mNumberOfTasksReceived--
            click(constant.pickUpTask2Area)
        } else {
            mNumberOfTasksReceived--
            click(constant.pickUpTask1Area)
        }
        takeScreen(normalClickInterval)
        ensureCloseDetermine()//低安要点确定
        takeScreen(normalClickInterval)
        if (!receiveAdvancedTasks && visual.isHighTaskRight())//如果右边是高级任务也进行取消
        {
            Timber.d("发现高级任务右侧  pickUpTask FightController NWQ_ 2023/3/12");
            click(constant.openTaskRightArea)
            click(constant.cancelTaskArea, doubleClickInterval)
            takeScreen(doubleClickInterval)
            ensureCloseDetermine()
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

    private suspend fun startNavigationMonitoring() {
        takeScreen(quadrupleClickInterval)
        if (visual.isShowDetermine()) {
            Timber.d("isShowDetermine startNavigationMonitoring FightController NWQ_ 2023/3/10");
            click(constant.dialogDetermineArea)
        } else if (visual.hasGroupLock() || visual.getTagNumber() > 1) {
            Timber.d("hasGroupLock startNavigationMonitoring FightController NWQ_ 2023/3/10");
            if (System.currentTimeMillis() - spReo.lastPickUpTaskTime > constant.NAVIGATING_TOO_LONG) {
                needBackStation = true
                neeForceRefresh = true
            }
            nowStep = COMBAT_MONITORING
            battleStartTime = System.currentTimeMillis()
        } else if (System.currentTimeMillis() - spReo.lastPickUpTaskTime > constant.NAVIGATING_EXCEPTION) {
            Timber.d("导航时间过长 startNavigationMonitoring FightController NWQ_ 2023/3/10");
            needBackStation = true
            needCancel = true
            neeForceRefresh = true
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
    private suspend fun combatMonitoring() {
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
                nowStep = EXIT_OPT
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
                            2, listOf(), catchFoodList
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
                    } else if (isAttackSmallShip()) {
                        needCheckOpenList.addAll(catchFoodList)
                        hasNewLock = false
                    } else if (!hasNewLock) {
                        if ((System.currentTimeMillis() - targetReduceTime > DESTROY_INTERVAL * 2 && nowTargetCount >= targetCount)) {
                            targetReduceTime = System.currentTimeMillis()
                            needCheckOpenList.addAll(catchFoodList)
                        } else if ((System.currentTimeMillis() - targetReduceTime > DESTROY_INTERVAL && nowTargetCount >= targetCount)) {
                            targetReduceTime = System.currentTimeMillis() - DESTROY_INTERVAL / 2
                            needCheckOpenList.addAll(catchFoodList)
                        }
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
                            2, listOf(), catchFoodList
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
    private suspend fun monitoringReturnStatus() {
        takeScreen(quadrupleClickInterval * 2)
        if (System.currentTimeMillis() - spReo.lastBackSpaceStation > constant.MAX_BATTLE_TIME * 2) {
            if (visual.isSailing()) {
                spReo.lastBackSpaceStation = System.currentTimeMillis() - constant.MAX_BATTLE_TIME
            } else {
                nowStep = ABNORMAL_STATE
            }
            return
        }
        if (visual.getTagNumber() > 4 || visual.hasGroupLock()) {
            nowStep = COMBAT_MONITORING
        } else if (visual.isInSpaceStation()) {
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


    private fun checkTimingOnList(needCheckOpenList: MutableList<Int>) {
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


    private fun checkTimeOn(
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
            } else if (i * Equipment_Interval < intervalTime && intervalTime < (i + 1) * Equipment_Interval) {
                needCheckOpenList.add(0, d)
            }
        }
        return flag
    }


    //战斗开始时候需要开启的
    private suspend fun openDecelerationNet() {
        clickEquipArray(openCheckEquipTimes(2, catchFoodList))
    }

    //战斗开始时候需要开启的
    private suspend fun openTheWholeBattle() {
        if (isPickupBox) {
            clickEquipArray(
                openCheckEquipTimes(
                    2, wholeBattleOpenList, roundBattleOpenList, listOf(pickUpPosition)
                )
            )
        } else {
            clickEquipArray(openCheckEquipTimes(2, wholeBattleOpenList, roundBattleOpenList))
        }

    }


    //pickUp 是否是接取任务
    private suspend fun clickTheDialogueClose(pickUp: Boolean): Boolean {
        var hasClickConversation = false
        var rightClickTimes = 0
        var count = if (pickUp) {
            10
        } else {
            2
        }
        var flag = count

        Timber.d("clickTheDialogueClose clickTheDialogueClose NWQ_ 2023/3/10");
        while (flag > 0 && runSwitch) {
            takeScreen(normalClickInterval)
            if (visual.hasLeftDialogue()) {
                Timber.d("hasLeftDialogue clickTheDialogueClose NWQ_ 2023/3/10");
                click(constant.leftDialogueArea)
                click(constant.leftDialogueArea, fastClickInterval)
                flag = count
            } else if (visual.hasRightDialogue()) {
                Timber.d("hasRightDialogue clickTheDialogueClose NWQ_ 2023/3/10");
                click(constant.rightDialogueArea)
                rightClickTimes++
                count = 10
                flag = count
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
        return System.currentTimeMillis() - spReo.lastRefreshTime > constant.REFRESH_INTERVAL && visual.canRefresh()
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

    private suspend fun cancelTask() {
        Timber.d("取消任务 cancelTask FightController NWQ_ 2023/3/10");
        click(constant.openTaskArea)
        delay(normalClickInterval)
        click(constant.cancelTaskArea)
        delay(normalClickInterval)
        click(constant.dialogDetermineArea)
        delay(normalClickInterval)
        takeScreen(doubleClickInterval)
        ensureCloseDetermine()
    }


    var judgeSmallShipTargetCount = 0
    var lastJudgeIsSmallShip = 0L

    var newLockAttackPosition = 0
    var newLockTargetCount = 0
    private fun isAttackSmallShip(): Boolean {
        if (targetCount <= 0) return false
        var position = getNowAttackPosition()
        if (position > 0) {
            if (hasNewLock) {
                newLockTargetCount = targetCount
                newLockAttackPosition = targetCount
                return false
            } else {
                if (newLockTargetCount == targetCount + 1 && newLockAttackPosition + 1 >= targetCount && position < newLockAttackPosition) {
                    Timber.d("position:$position result:锁定目标改变，且开始锁定为最大位置所以  isAttackSmallShip FightController NWQ_ 2023/3/11");
                    newLockAttackPosition = -100
                    return true
                } else {
                    judgeSmallShipTargetCount = targetCount
                    var result = visual.judgeIsSmall(position)
                    lastJudgeIsSmallShip = System.currentTimeMillis()
                    Timber.d("position:$position result:$result  isAttackSmallShip FightController NWQ_ 2023/3/11");
                    return result
                }
            }
        } else {
            if (!hasOpenCatch && !hasNewLock && judgeSmallShipTargetCount == targetCount && System.currentTimeMillis() - lastJudgeIsSmallShip > 30 * 1000L) {
                lastJudgeIsSmallShip = System.currentTimeMillis()
                Timber.d("无法识别船 认定位小船  isAttackSmallShip FightController NWQ_ 2023/3/11");
                return true
            }
            lastJudgeIsSmallShip = System.currentTimeMillis()
            judgeSmallShipTargetCount = targetCount
            return false
        }
    }

    private fun getNowAttackPosition(): Int {
        for (index in targetCount - 1 downTo 0) {
            if (visual.judgeNowAttackPosition(index)) {
                return index
            }
        }
        return -1
    }

    private suspend fun abnormalStateRepair() {
        Timber.d("abnormalStateRepair FightController NWQ_ 2023/3/10");
        theOutCheck()
        needCancel = true
        needBackStation = true
        clickJumpCollectionAddress(warehouseIndex, false)
        nowStep = START_MONITORING_RETURN_STATUS
    }

    //determine 是否需要点击确定按钮，一般出舱是需要的


    //战斗开始时候需要开启的
    private fun closeTheWholeBattle() {
        mEnterCombatStatus = false
        useUnlock = true
        DESTROY_INTERVAL = 50 * 1000
    }


}