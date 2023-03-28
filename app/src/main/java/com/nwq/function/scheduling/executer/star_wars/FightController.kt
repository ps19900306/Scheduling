package com.nwq.function.scheduling.executer.star_wars


import com.nwq.function.scheduling.core_code.Constant
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
    private val PICK_UP_TASK = 1 //接取任务
    private val BATTLE_NAVIGATION_MONITORING = 2//战斗飞行导航监控
    private val COMBAT_MONITORING = 3 //战斗监控阶段
    private val MONITORING_RETURN_STATUS = 4//返回空间站监听
    private val ALL_COMPLETE = 9//返回空间站监听
    private val ABNORMAL_STATE = 1000 //异常状态
    private val EXIT_OPT = 10000 //异常状态


    private val STATUS_DETERMINATION = 1000000//这个是进行状态判定
    private val receiveAdvancedTasks = false //是否接受高级任务

    val UNKNOWN_STATE = 0
    val OFF_STATE = 1
    val ON_STATE = 2
    var maintenanceStatus = UNKNOWN_STATE


    val warehouseIndex = spReo.fightBaseLocation

    /**
     * 这个是控制变量
     */
    private var nowStep = START_GAME


    val isPickupBox = spReo.isPickupBox

    //后面这里由外部读取数据进行初始化
    private val wholeBattleOpenList by lazy {
        JsonUtil.anyToJsonObject(spReo.wholeBattleList) ?: listOf<Int>()
    }
    private val roundBattleOpenList by lazy {
        JsonUtil.anyToJsonObject(spReo.roundBattleList) ?: listOf<Int>()
    }
    var isCatchFoodSp = spReo.isCatchFood
    private val catchFoodList by lazy {
        if (isCatchFoodSp) listOf<Int>(1 + BotOfst, 4 + BotOfst)
        else listOf<Int>()
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


    /*******************************************************************
     *                        下面都是方法
     * *****************************************************************
     */
    private suspend fun startGame() {
        takeScreen(normalClickInterval)
        delay(2000)
        click(constant.getAppArea())
        delay(doubleClickInterval * 2)
        if (intoGame()) {
            if (visual.hasGroupLock() || visual.getTagNumber() > 1) {
                nowStep = COMBAT_MONITORING
            } else {
                nowStep = PICK_UP_TASK
                if (openHarvestVegetablesSP && System.currentTimeMillis() - spReo.resourcesAddTime > spReo.addInterval * Constant.Hour) {
                    harvestVegetableController.addPlanetaryTime()
                    delay(normalClickInterval)
                }
            }
        }
    }

    private suspend fun exitGame() {
        theOutCheck()
        dailyGiftPack()
        clickJumpCollectionAddress(warehouseIndex, false)
        delay(doubleClickInterval)
//        pressBackBtn()
//        delay(helper.defultClickDuration * 2)
//        click((1371 - 20).toFloat(), (708 - 20).toFloat(), 40, 40)
//        takeScreen(doubleClickInterval)
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
                BATTLE_NAVIGATION_MONITORING -> {
                    startNavigationMonitoring()
                }
                COMBAT_MONITORING -> {
                    combatMonitoring()
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
            if (openHarvestVegetablesSP && System.currentTimeMillis() - spReo.resourcesCollectTime > spReo.collectInterval * Constant.Hour) {
                harvestVegetableController.startCollectVegetables()
            } else {
                harvestVegetableController.addPlanetaryTime()
            }
            delay(normalClickInterval)
        }
        nowStep = EXIT_OPT
    }


    private suspend fun pickUpTask() {
        Timber.d("准备接取任务 pickUpTask FightController NWQ_ 2023/3/12");

        nowStep = BATTLE_NAVIGATION_MONITORING
        //点开任务栏目
        var flag = true
        var count = 2
        click(constant.getTopMenuArea(2))
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.isOpenBigMenu()) {
                flag = false
            } else if (visual.isOpenWallet()) {
                click(constant.closeWalletArea)
                count = 2
            } else if (count % 2 == 1) {
                click(constant.getTopMenuArea(2))
            }
            count--
        }

        //等待进入接取任务的
        flag = true
        count = 3
        var hasTask = false
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return
            }

            if (spReo.hasLegionnaires) {//有军团任务
                if (visual.hasLegionnaires()) {
                    hasTask = visual.hasLegionnairesTask()
                    flag = false
                }
            } else {//没有军团任务
                if (visual.showNotTask()) {
                    flag = false
                    hasTask = false
                }
                if (visual.hasTask()) {
                    Timber.d("hasTask pickUpTask FightController NWQ_ 2023/3/26");
                    flag = false
                    hasTask = true
                }
            }
            count--
        }

        if (count <= 0 && flag) {//没有进入
            Timber.d("没有进入 pickUpTask FightController NWQ_ 2023/3/26");
            theOutCheck()
            if (needBackStation) {
                nowStep = EXIT_OPT
            } else {
                nowStep = PICK_UP_TASK
                needBackStation = true
            }
            return
        }
        needBackStation = false

        if (hasTask) {//如果已经有任务
            clickTheDialogueClose()
            if (spReo.hasLegionnaires) {//
                Timber.d("点击打开按钮 hasLegionnaires  pickUpTask FightController NWQ_ 2023/3/26");
                click(constant.optTaskArea2)
                takeScreen(normalClickInterval)
                if (visual.hasLegionnairesTask() || !visual.isOpenBigMenu()) {//这里表示任务没有超时去走战斗导航就可以了
                    clickTheDialogueClose()
                    return
                }
            } else {
                if (needCancel) {
                    Timber.d("needCancel pickUpTask FightController NWQ_ 2023/3/26");
                    cancelTask()
                    count = 0
                } else {
                    Timber.d("点击打开按钮 FightController NWQ_ 2023/3/26");
                    click(constant.optTaskArea)
                    takeScreen(normalClickInterval)
                    if (visual.hasTask() || !visual.isOpenBigMenu()) {//这里表示任务没有超时去走战斗导航就可以了
                        clickTheDialogueClose()
                        return
                    } else {
                        count = 0
                    }
                }
            }
        }

        needCancel = false
        //下面是走没有任务的流程
        //打开新闻公告版本
        click(constant.newTaskListArea(spReo.hasLegionnaires || count == 0))
        nowStep = BATTLE_NAVIGATION_MONITORING
        flag = true
        count = 4
        var positon = -1
        var pickSuccess = false
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            positon = visual.checkIsCommonTask()
            if (neeForceRefresh) {
                if (visual.canRefresh()) {
                    click(constant.refreshTaskListArea)
                    spReo.lastRefreshTime = System.currentTimeMillis()
                    neeForceRefresh = false
                } else if (count == 1) {
                    (System.currentTimeMillis() + constant.REFRESH_INTERVAL - spReo.lastRefreshTime).let {
                        if (it > 0) {
                            delay(it)
                        }
                        click(constant.refreshTaskListArea)
                        spReo.lastRefreshTime = System.currentTimeMillis()
                    }
                    neeForceRefresh = false
                }
            } else if (needRefreshTask() && positon > 0) {
                count = 4
                click(constant.refreshTaskListArea)
                spReo.lastRefreshTime = System.currentTimeMillis()
            } else if ((spReo.hasLegionnaires && visual.hasPickUpSuccessL()) || (!spReo.hasLegionnaires && visual.hasPickUpSuccess())) {
                //这里表示接取任务成功
                Timber.d("接取任务成功  pickUpTask FightController NWQ_ 2023/3/25");
                flag = false
                pickSuccess = true
            } else {
                when (positon) {
                    1 -> {
                        click(constant.pickUpTask1Area)
                        delay(normalClickInterval)//这样做是为了保证最多点击二次
                        if (count > 2) count = 2
                    }
                    2 -> {
                        click(constant.pickUpTask2Area)
                        delay(normalClickInterval)
                        if (count > 2) count = 2
                    }
                }
            }
            count--
        }

        //这里为点开流程
        if (!pickSuccess) {//全部的任务已经完成
            Timber.d("ALL_COMPLETE  pickUpTask FightController NWQ_ 2023/3/25");
            nowStep = ALL_COMPLETE
            return
        }

        if (!spReo.hasLegionnaires && visual.isHighTaskRight())//如果右边是高级任务也进行取消
        {
            Timber.d("发现高级任务右侧  pickUpTask FightController NWQ_ 2023/3/12");
            click(constant.openTaskRightArea)
            click(constant.cancelTaskArea, doubleClickInterval)
            takeScreen(doubleClickInterval)
            ensureCloseDetermine()
            theOutCheck()
            nowStep = PICK_UP_TASK
            needCancel = true
            return
        }


        if (spReo.hasLegionnaires) {
            click(constant.openTaskRightArea2)
        } else {
            click(constant.openTaskRightArea)
        }

        //这里是为了等到弹出选择按钮再进行点击确定保证操作正确
        flag = true
        count = 4
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(fastClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.isShowTaskOpt()) {
                flag = false
            }
            count--
        }
        click(constant.openTaskDetermineArea, fastClickInterval)

        if (!clickTheDialogueClose(4)) {
            Timber.d("接任务出现问题 needCancel:$needCancel  pickUpTask FightController NWQ_ 2023/3/10");
            needCancel = true
            nowStep = PICK_UP_TASK
            theOutCheck()
        }
    }

    private suspend fun startNavigationMonitoring() {
        spReo.lastPickUpTaskTime = System.currentTimeMillis()
        nowStep = PICK_UP_TASK //这里转接任务
        var flag = true
        var count = 20
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
            }
            if (visual.hasGroupLock() || visual.getTagNumber() > 1) {
                Timber.d("hasGroupLock startNavigationMonitoring FightController NWQ_ 2023/3/10");
                nowStep = COMBAT_MONITORING
                battleStartTime = System.currentTimeMillis()
                flag = false
            } else if ((visual.hasRightDialogue() || visual.hasLeftDialogue()) && visual.isClosePositionMenu()) {
                needCancel = true
                clickTheDialogueClose()
                Timber.d("还有左侧未点击的 startNavigationMonitoring FightController NWQ_ 2023/3/10");
                nowStep = PICK_UP_TASK
                flag = false
            } else if (visual.isShowDetermine()) {
                click(constant.dialogDetermineArea)
                count = 20
            } else if (visual.isOpenBigMenu()) {
                click(constant.closeBigMenuArea)
                count = 20
            }
            else if (visual.isClosePositionMenu() && visual.hasEyesMenu()) {
                count--
                if (visual.isDamage()) {
                    nowStep = EXIT_OPT
                    flag = false
                }
            } else if (!spReo.hasLegionnaires && System.currentTimeMillis() - spReo.lastPickUpTaskTime > constant.NAVIGATING_EXCEPTION) {
                Timber.d("导航时间过长 startNavigationMonitoring FightController NWQ_ 2023/3/10");
                needBackStation = true
                needCancel = true
                neeForceRefresh = true
                //flag = false
            }
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
    var intoCount = 3
    private suspend fun combatMonitoring() {
        Timber.d("进入战斗监控 combatMonitoring FightController NWQ_ 2023/3/10");
        if (System.currentTimeMillis() - battleStartTime > constant.MAX_BATTLE_TIME) {
            nowStep = ABNORMAL_STATE
            if (mEnterCombatStatus) {
                nowStep = ABNORMAL_STATE
                Timber.d("进入战斗超时 combatMonitoring FightController NWQ_ 2023/3/10");
                return
            }
        }
        if (!takeScreen(quadrupleClickInterval)) {
            runSwitch = false
            return
        }
        if (ensureCloseDetermine()) {//这里大概率用不到了
            return
        }
        if (!mEnterCombatStatus) {
            if (canLockTargetDelay()) {
                ensureCloseEyeMenu()
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
                } else if (intoCount < 0) {
                    Timber.d("进入战斗失败 combatMonitoring FightController NWQ_ 2023/3/10");
                    if (visual.isDamage()) {//损毁了才进行推出
                        useUnlock = false
                        nowStep = EXIT_OPT
                    } else {
                        useUnlock = false
                        nowStep = ABNORMAL_STATE
                    }
                    intoCount = 3
                } else {
                    intoCount--
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
                if (visual.isDamage()) {//损毁了才进行推出
                    useUnlock = false
                    nowStep = EXIT_OPT
                } else {
                    useUnlock = false
                    nowStep = PICK_UP_TASK
                }
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
                        if ((System.currentTimeMillis() - targetReduceTime > DESTROY_INTERVAL && nowTargetCount >= targetCount)) {
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

                    //如果多次开修失败
                    if (list.contains(1 + TopOfst)) {
                        val nowTime = System.currentTimeMillis()
                        if (maintenanceTimeStartStamp - nowTime < MAINTENANCE_INTERVAL) {
                            maintenanceOpenCount-- //表示上次没有开启成功
                        } else {
                            maintenanceOpenCount = 3
                        }
                        if (maintenanceOpenCount <= 0) {
                            needExit = true
                        }
                        maintenanceTimeStartStamp = System.currentTimeMillis()
                    }

                } else {
                    needCheckOpenList.addAll(wholeBattleOpenList)
                    needCheckOpenList.addAll(roundBattleOpenList)
                    needCheckOpenList.add(weaponPosition)
                    val closeList = checkEquipTimes(2, needCheckOpenList, null)
                    if (closeList.contains(weaponPosition) && closeList.contains(cellPosition)) {//这里表示已经关闭的
                        if (visual.hasLeftDialogue() || visual.hasRightDialogue()) {
                            //这里要做异常处理了 这里表示战斗结束了
                            clickTheDialogueClose()
                            closeTheWholeBattle()
                            if (needExit) {
                                nowStep = EXIT_OPT
                            } else if (needBackStation) {
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
        if (!takeScreen(quadrupleClickInterval * 2)) {
            runSwitch = false
            return
        }
        if (System.currentTimeMillis() - spReo.lastBackSpaceStation > constant.MAX_BATTLE_TIME * 2) {
            if (visual.isSailing()) {
                spReo.lastBackSpaceStation = System.currentTimeMillis() - constant.MAX_BATTLE_TIME
            } else {
                nowStep = ABNORMAL_STATE
            }
            return
        }
        if (visual.getTagNumber() > 2 || visual.hasGroupLock()) {
            nowStep = COMBAT_MONITORING
        } else if (visual.isInSpaceStation()) {
            if (isPickupBox) {
                unloadingCargo()
            }
            needBackStation = false
            nowStep = PICK_UP_TASK
        } else if (needCancel && visual.isClosePositionMenu() && visual.hasRightDialogue()) {
            clickTheDialogueClose(4)
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
    private suspend fun clickTheDialogueClose(count: Int = 2): Boolean {
        var hasClickConversation = true
        var rightClickTimes = 0
        var flag = count

        Timber.d("clickTheDialogueClose clickTheDialogueClose NWQ_ 2023/3/10");
        while (flag > 0 && runSwitch) {
            takeScreen(fastClickInterval)
            if (visual.hasLeftDialogue()) {
                Timber.d("hasLeftDialogue clickTheDialogueClose NWQ_ 2023/3/10");
                click(constant.leftDialogueArea)
                flag = count
            } else if (visual.hasRightDialogue()) {
                Timber.d("hasRightDialogue clickTheDialogueClose NWQ_ 2023/3/10");
                click(constant.rightDialogueArea)
                rightClickTimes++
                flag = count
            } else {
                Timber.d("Nothing clickTheDialogueClose NWQ_ 2023/3/10");
                flag--
            }
        }
        if (needCancel || (rightClickTimes >= 1 && !receiveAdvancedTasks)) {
            needCancel = true
            needBackStation = true
            hasClickConversation = false
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
        nowStep = MONITORING_RETURN_STATUS
    }

    //determine 是否需要点击确定按钮，一般出舱是需要的


    //战斗开始时候需要开启的
    private fun closeTheWholeBattle() {
        intoCount = 3
        mEnterCombatStatus = false
        useUnlock = true
        DESTROY_INTERVAL = 50 * 1000
    }


}