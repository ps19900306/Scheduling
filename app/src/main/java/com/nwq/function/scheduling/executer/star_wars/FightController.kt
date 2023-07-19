package com.nwq.function.scheduling.executer.star_wars


import com.nwq.function.scheduling.core_code.Constant
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.star_wars.data.OptSlotInfo
import com.nwq.function.scheduling.utils.JsonUtil
import com.nwq.function.scheduling.utils.sp.SpConstant
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
    private val CHECK_SHIP = 10//检查船只

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


    private val mOptSlotInfoList1 by lazy {
        JsonUtil.anyToJsonObject<List<Int>>(spReo.timeOnList1)?.mapIndexed { p, d ->
            OptSlotInfo(d, constant.listInterval1, 0, p, constant.offsetInterval * 30)
        } ?: listOf<OptSlotInfo>()
    }

    private val mOptSlotInfoList2 by lazy {
        JsonUtil.anyToJsonObject<List<Int>>(spReo.timeOnList2)?.mapIndexed { p, d ->
            OptSlotInfo(d, constant.listInterval2, 0, p, constant.offsetInterval * 30)
        } ?: listOf<OptSlotInfo>()
    }
    private val mOptSlotInfoList3 by lazy {
        JsonUtil.anyToJsonObject<List<Int>>(spReo.timeOnList3)?.mapIndexed { p, d ->
            OptSlotInfo(d, constant.listInterval3, 0, p, constant.offsetInterval * 30)
        } ?: listOf<OptSlotInfo>()
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
                if (openHarvestVegetablesSP && System.currentTimeMillis() - spReo.resourcesCollectTime > spReo.collectInterval * Constant.Hour) {
                    harvestVegetableController.startCollectVegetables()
                    delay(normalClickInterval)
                } else if (celestialList.isNotEmpty() && System.currentTimeMillis() - spReo.resourcesAddTime > spReo.addInterval * Constant.Hour) {
                    harvestVegetableController.addPlanetaryTime()
                    delay(normalClickInterval)
                }
                nowStep = CHECK_SHIP
            }
        } else {
            onComplete.invoke()
        }
    }

    private suspend fun exitGame() {
        theOutCheck()
        if (!visual.isInSpaceStation()) {
            clickJumpCollectionAddress(warehouseIndex, false)
        }
        delay(doubleClickInterval)
        optExitGame()
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
                    exitGame()
                }
                CHECK_SHIP -> {
                    checkShip()
                }
            }
        }
    }

    private suspend fun checkShip() {
        if (spReo.lastStatus != SpConstant.VEGETABLE && spReo.lastStatus != SpConstant.VEGETABLES) {
            nowStep = PICK_UP_TASK
            spReo.lastStatus = SpConstant.UNUSUAL
            return
        }

        if (!visual.isInSpaceStation()) {
            if (visual.isDamage()) {
                needChangeShip = true
                clickJumpCollectionAddress(warehouseIndex)
                nowStep = MONITORING_RETURN_STATUS
            } else {
                nowStep = PICK_UP_TASK
            }
            spReo.lastStatus = SpConstant.UNUSUAL
            return
        }

        if (outSpaceStation()) {
            if (visual.isDamage()) {
                needChangeShip = true
                clickJumpCollectionAddress(warehouseIndex)
                nowStep = MONITORING_RETURN_STATUS
            } else {
                nowStep = PICK_UP_TASK
            }
            spReo.lastStatus = SpConstant.UNUSUAL
        } else {
            nowStep = EXIT_OPT
            spReo.lastStatus = SpConstant.DAMAGE
            Timber.d("已经损毁 lookingForMineralStars MinerController NWQ_ 2023/3/10");
            return
        }
    }

    private suspend fun onAllComplete() {
        spReo.lastStatus = SpConstant.ACCOMPLISH
        theOutCheck()
        if (celestialList.isNotEmpty() && System.currentTimeMillis() - spReo.resourcesAddTime > spReo.addInterval * Constant.Hour) {
            harvestVegetableController.addPlanetaryTime()
            delay(normalClickInterval)
        }
        nowStep = EXIT_OPT
    }


    private suspend fun pickUpTask() {
        Timber.d("准备接取任务 pickUpTask FightController NWQ_ 2023/3/12");
        nowStep = BATTLE_NAVIGATION_MONITORING

        //这里要等待打开任务栏目
        ensureOpenMenuArea(JiyuPosition)

        //等待进入接取任务的
        var flag = true
        var count = 3
        var hasTask = true
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
                    if (visual.hasTask() || !visual.isOpenBigMenu() || visual.isShowDetermine() || visual.hasLeftDialogue()) {//这里表示任务没有超时去走战斗导航就可以了
                        Timber.d("点击打开按钮 点击流程 NWQ_ 2023/3/26");
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

        flag = true
        count = 6
        var positon = -1
        var pickSuccess = false
        var hasPickUpTask = false
        if (spReo.receiveSpecificTask) { //这个是接取特殊任务
            while (flag && count > 0 && runSwitch) {
                if (!takeScreen(normalClickInterval)) {
                    runSwitch = false
                    return
                }
                positon = visual.checkIsCommonTaskV2(spReo.specificStatus)
                if (neeForceRefresh) {
                    if (visual.canRefresh()) {
                        click(constant.refreshTaskListArea)
                        neeForceRefresh = false
                        spReo.lastRefreshTime = System.currentTimeMillis()
                        count = 6
                        if (!spReo.specificStatus) {
                            changSpecialJiYu()
                            spReo.specificStatus = true
                        }
                    } else if (count == 1) {
                        (System.currentTimeMillis() + constant.REFRESH_INTERVAL - spReo.lastRefreshTime).let {
                            if (it > 0) {
                                delay(it)
                            }
                            click(constant.refreshTaskListArea)
                            spReo.lastRefreshTime = System.currentTimeMillis()
                            count = 6
                            if (!spReo.specificStatus) {
                                changSpecialJiYu()
                                spReo.specificStatus = true
                            }
                        }
                        neeForceRefresh = false
                    }
                } else if (needRefreshTask() && positon > 0) {
                    click(constant.refreshTaskListArea)
                    spReo.lastRefreshTime = System.currentTimeMillis()
                    count = 6
                    if (!spReo.specificStatus) {
                        changSpecialJiYu()
                        spReo.specificStatus = true
                    }
                } else if ((spReo.hasLegionnaires && visual.hasPickUpSuccessL()) || (!spReo.hasLegionnaires && visual.hasPickUpSuccess()) || (visual.hasLeftDialogue() || visual.hasRightDialogue() || visual.isShowDetermine())) {
                    //这里表示接取任务成功
                    Timber.d("接取任务成功  pickUpTask FightController NWQ_ 2023/3/25");
                    flag = false
                    pickSuccess = true
                } else if (spReo.specificStatus && count == 3 && !hasPickUpTask && !visual.canRefresh()) {
                    count = 6
                    changCommonJiYu()
                    spReo.specificStatus = false
                } else if (visual.isShowTaskOpt()) {
                    click(constant.openTaskDetermineArea, fastClickInterval)
                } else {
                    when (positon) {
                        1 -> {
                            if (visual.jiYuTask1canAccpet()) {
                                click(constant.pickUpTask1Area)
                                delay(normalClickInterval)//这样做是为了保证最多点击二次
                                hasPickUpTask = true
                                if (count > 3) count = 3

                            } else {
                                click(constant.pickUpTask1AreaV2)
                                delay(normalClickInterval)//这样做是为了保证最多点击二次
                                hasPickUpTask = true
                                if (count > 3) count = 3
                            }
                        }
                        2 -> {
                            click(constant.pickUpTask2Area)
                            delay(normalClickInterval)
                            hasPickUpTask = true
                            if (count > 2) count = 2
                        }
                    }
                }
                count--
            }
        } else {
            if (spReo.specificStatus) {
                spReo.specificStatus = false
                changCommonJiYu()
            }
            while (flag && count > 0 && runSwitch) {
                if (!takeScreen(normalClickInterval)) {
                    runSwitch = false
                    return
                }
                positon = visual.checkIsCommonTask(spReo.receiveSpecificTask1)
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
                } else if (visual.isShowTaskOpt()) {
                    click(constant.openTaskDetermineArea, fastClickInterval)
                } else {
                    when (positon) {
                        1 -> {
                            if (visual.jiYuTask1canAccpet()) {
                                click(constant.pickUpTask1Area)
                                delay(normalClickInterval)//这样做是为了保证最多点击二次
                                hasPickUpTask = true
                                if (count > 2) count = 2
                            } else {
                                click(constant.pickUpTask1AreaV2)
                                delay(normalClickInterval)//这样做是为了保证最多点击二次
                                hasPickUpTask = true
                                if (count > 2) count = 2
                            }
                        }
                        2 -> {
                            click(constant.pickUpTask2Area)
                            delay(normalClickInterval)
                            hasPickUpTask = true
                            if (count > 2) count = 2
                        }
                        3 -> {
                            click(constant.pickUpTask3Area)
                            delay(normalClickInterval)
                            hasPickUpTask = true
                            if (count > 2) count = 2
                        }
                    }
                }
                count--
            }
        }




        if (spReo.specificStatus) {//接取运输任务后 需要监听空间站导航
            flag = true
            count = 4
            while (flag && count > 0 && runSwitch) {
                if (!takeScreen(fastClickInterval)) {
                    runSwitch = false
                    return
                }
                if (visual.hasLeftDialogue() || visual.hasRightDialogue() || visual.isShowDetermine()) {
                    clickTheDialogueCloseYunShu(4)
                    nowStep = MONITORING_RETURN_STATUS
                    return
                }
                count--
            }
        }

        //这里为点开流程
        if (!pickSuccess) {//全部的任务已经完成
            if (spReo.specificStatus && (visual.hasLeftDialogue() || visual.hasRightDialogue() || visual.isShowDetermine())) {//接取运输任务后 需要监听空间站导航
                clickTheDialogueCloseYunShu(4)
                nowStep = MONITORING_RETURN_STATUS
            } else if (hasPickUpTask) {
                Timber.d("ALL_COMPLETE  pickUpTask FightController NWQ_ 2023/3/25");
                nowStep = ALL_COMPLETE
                return
            } else {
                Timber.d("未成功哦给接取  ABNORMAL_STATE  pickUpTask FightController NWQ_ 2023/3/25");
                nowStep = ABNORMAL_STATE
                return
            }
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
                Timber.d("还有左侧未点击的 startNavigationMonitoring FightController NWQ_ 2023/3/10");
                click(constant.dialogDetermineArea)
                count = 20
            } else if (visual.isOpenBigMenu()) {
                Timber.d("打开任务栏 startNavigationMonitoring FightController NWQ_ 2023/3/10");
                click(constant.closeBigMenuArea)
                count = 20
            } else if (visual.isClosePositionMenu() && visual.hasEyesMenu()) {
                if (visual.isDamage()) {
                    nowStep = EXIT_OPT
                    return
                }
                count--
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
            } else {

            }
        }
        if (!takeScreen(quadrupleClickInterval)) {
            runSwitch = false
            return
        }
        if (ensureCloseDetermine()) {//这里大概率用不到了
            return
        }
        if (visual.isClosePositionMenuGray()) {///这个是关闭长按导致的信息
            Timber.d("长按导致的信息 combatMonitoring FightController NWQ_ 2023/4/11");
            click(constant.closetAlert)
            return
        }
        if (!mEnterCombatStatus) {
            if (visual.hasGroupLock()) {
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
                    intoCount = 3
                } else if (intoCount < 0) {
                    useUnlock = false
                    nowStep = ABNORMAL_STATE
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
                Timber.d("长时间未能进行锁定  combatMonitoring FightController NWQ_ 2023/3/10");
                useUnlock = false
                nowStep = PICK_UP_TASK
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


                    //打开定时开启的
                    checkTimingOnList(needCheckOpenList)

                    //这个是判断是否需要开关维修
                    bloodVolumeMonitoring(needCheckOpenList, needCheckCloseList)

                    //这里是判断点击
                    val list = checkEquipTimes(2, needCheckOpenList, needCheckCloseList)

                    clickEquipArray(list)

                    if (!hasOpenCatch && needCheckOpenList.contains(0) && checkEquipTimes(
                            2, listOf(), catchFoodList
                        ).isNotEmpty()
                    ) {
                        Timber.d("hasOpenCatch:$hasOpenCatch combatMonitoring FightController NWQ_ 2023/3/13");
                        hasOpenCatch = true
                    }

                    //如果多次开修失败
                    if (list.contains(maintenanceDevicePosition)) {
                        val nowTime = System.currentTimeMillis()
                        if (nowTime - maintenanceTimeStartStamp < MAINTENANCE_INTERVAL) {
                            maintenanceOpenCount-- //表示上次没有开启成功
                        } else {
                            maintenanceOpenCount = 5
                        }
                        if (maintenanceOpenCount <= 0) {
                            Timber.d("开启失败需要返回 cmbatMonitoring FightController NWQ_ 2023/3/30");
                            maintenanceOpenCount = 5
                            needBackStation = true
                        }
                        maintenanceTimeStartStamp = System.currentTimeMillis()
                    }

                } else {
                    needCheckOpenList.add(weaponPosition)
                    needCheckOpenList.add(cellPosition)
                    val closeList = checkEquipTimes(2, needCheckOpenList, null)
                    if (closeList.contains(weaponPosition) && closeList.contains(cellPosition)) {//这里表示已经关闭的
                        if (visual.hasLeftDialogue() || visual.hasRightDialogue()) {
                            //这里要做异常处理了 这里表示战斗结束了
                            clickTheDialogueClose()
                            closeTheWholeBattle()
                            if (needBackStation || needBack() || isWarehouseIsFull()) {
                                nowStep = ABNORMAL_STATE
                            } else {
                                nowStep = PICK_UP_TASK
                            }
                        } else if (targetReduceTime - System.currentTimeMillis() > Constant.MINUTE) {//防止卡住
                            closeTheWholeBattle()
                            if (needBackStation || needBack() || isWarehouseIsFull()) {
                                nowStep = ABNORMAL_STATE
                            } else {
                                nowStep = PICK_UP_TASK
                            }
                        }
                    }
                }
            }
        }
    }

    fun isWarehouseIsFull(): Boolean {
        return isPickupBox && visual.warehouseIsFull()
    }


    //监听是否已经抵达空间战  numberCount是循环监听次数  failedCode是失败时候执行的命令码  successCode是成功过时候执行的命令码
    private suspend fun monitoringReturnStatus() {
        Timber.d("monitoringReturnStatus FightController NWQ_ 2023/4/11");
        var flag = true
        val maxCount = 15 * 60
        var unSailingCount = 10
        var count = maxCount
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.isOpenBigMenu()) {
                click(constant.closeBigMenuArea)
            } else if (visual.isShowDetermine()) {
                click(constant.dialogDetermineArea)
            } else if (needCancel && visual.isClosePositionMenu() && visual.hasRightDialogue()) {
                if (spReo.receiveSpecificTask && spReo.specificStatus) {
                    clickTheDialogueCloseYunShu(4)
                } else {
                    clickTheDialogueClose(4)
                }
            } else if (visual.getTagNumber() > 2 || visual.hasGroupLock()) {
                nowStep = COMBAT_MONITORING
                flag = false
            } else if (visual.isInSpaceStation()) {
                flag = false //抵达结束 开启下一轮
                if (spReo.receiveSpecificTask && spReo.specificStatus) {
                    if (clickTheDialogueCloseYunShu(4)) {
                        needCancel = false
                        needBackStation = false
                        nowStep = PICK_UP_TASK
                    }
                    if (count == maxCount - 2) {//过快抵达这里再次接取
                        nowStep = PICK_UP_TASK
                    }
                } else {
                    if (needChangeShip) {
                        needChangeShip = false
                        changeTrainShip()
                        nowStep = CHECK_SHIP
                    } else {
                        if (isPickupBox) {
                            unloadingCargo()
                        }
                        needBackStation = false
                        nowStep = PICK_UP_TASK
                    }
                }
            } else if (!visual.isSailing() && visual.hasPositionMenu() && visual.hasEyesMenu()) {
                unSailingCount--
                if (count <= 0) {
                    nowStep = ABNORMAL_STATE
                    flag = false
                }
            } else {
                unSailingCount = 10
            }
            count--
        }
        if (count == 0 && flag) {
            runSwitch = false
            return
        }
    }


    private fun checkTimingOnList(needCheckOpenList: MutableList<Int>) {
        if (targetCount <= 1) {
            Timber.d("目标是 checkTimingOnList FightController NWQ_ 2023/3/10");
            return
        }
        var nowTime = System.currentTimeMillis()
        checkTimeOn(nowTime, mOptSlotInfoList1, needCheckOpenList)
        checkTimeOn(nowTime, mOptSlotInfoList2, needCheckOpenList)
        checkTimeOn(nowTime, mOptSlotInfoList3, needCheckOpenList)
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
                click(constant.leftDialogueArea)
                flag = count
            } else if (visual.hasRightDialogue()) {
                click(constant.rightDialogueArea)
                rightClickTimes++
                flag = count
            } else if (visual.isShowDetermine()) {
                click(constant.dialogDetermineArea)
                flag = 0
            } else {
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

    //pickUp 是否是接取任务
    private suspend fun clickTheDialogueCloseYunShu(count: Int = 4): Boolean {
        var hasClickConversation = false
        var flag = count

        Timber.d("clickTheDialogueClose clickTheDialogueCloseYunShu NWQ_ 2023/3/10");
        while (flag > 0 && runSwitch) {
            takeScreen(fastClickInterval)
            if (visual.hasLeftDialogue()) {
                click(constant.leftDialogueArea)
                flag = count
            } else if (visual.hasRightDialogue()) {
                click(constant.rightDialogueArea)
                flag = count
            } else if (visual.isShowDetermine()) {
                click(constant.dialogDetermineArea)
            } else if (visual.isSubmitGoods()) {
                click(constant.submitGoodsArea)
                hasClickConversation = true
                flag = count
            } else {
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

    //这里切换到普通际遇模式
    private suspend fun changCommonJiYu(): Boolean {
        var flag = true
        var count = 4
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (visual.isOpenGaoAn()) {
                flag = false
            } else {
                click(constant.openJiYuMenu)
            }
            count--
        }
        if (count == 0) {
            return false
        }

        flag = true
        count = 6
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (!visual.isOpenYunShu() && !visual.isOpenDiAn() && visual.isOpenZhanDou()) {
                flag = false
            }
            if (visual.isOpenYunShu()) {
                click(constant.YunShuMenuArea)
                delay(fastClickInterval)
            }
            if (visual.isOpenDiAn()) {
                click(constant.DiAnMenuArea)
                delay(fastClickInterval)
            }
            if (!visual.isOpenZhanDou()) {
                click(constant.ZhanDouMenuArea)
            }
            count--
        }
        if (count == 0) {
            return false
        }

        flag = true
        count = 4
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (!visual.isOpenGaoAn()) {
                return true
            } else {
                click(constant.openJiYuMenu)
            }
            count--
        }
        return false
    }

    //这里切换到运输际遇模式
    private suspend fun changSpecialJiYu(): Boolean {
        var flag = true
        var count = 4
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (visual.isOpenGaoAn()) {
                flag = false
            } else {
                click(constant.openJiYuMenu)
            }
            count--
        }
        if (count == 0) {
            return false
        }

        flag = true
        count = 6
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (visual.isOpenYunShu() && visual.isOpenDiAn() && !visual.isOpenZhanDou()) {
                flag = false
            }
            if (!visual.isOpenYunShu()) {
                click(constant.YunShuMenuArea)
                delay(fastClickInterval)
            }
            if (!visual.isOpenDiAn()) {
                click(constant.DiAnMenuArea)
                delay(fastClickInterval)
            }
            if (visual.isOpenZhanDou()) {
                click(constant.ZhanDouMenuArea)
            }
            count--
        }
        if (count == 0) {
            return false
        }

        flag = true
        count = 4
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (!visual.isOpenGaoAn()) {
                return true
            } else {
                click(constant.openJiYuMenu)
            }
            count--
        }
        return false
    }
}