package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.Constant
import com.nwq.function.scheduling.core_code.click.DirectionType
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.utils.JsonUtil
import com.nwq.function.scheduling.utils.TimeUtils
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SPRepoPrefix
import com.nwq.function.scheduling.utils.sp.SpConstant
import com.nwq.function.scheduling.utils.sp.SpConstant.DAMAGE
import com.nwq.function.scheduling.utils.sp.SpConstant.NORMAL
import com.nwq.function.scheduling.utils.sp.SpConstant.UNUSUAL
import com.nwq.function.scheduling.utils.sp.SpConstant.VEGETABLE
import com.nwq.function.scheduling.utils.sp.SpConstant.VEGETABLES
import kotlinx.coroutines.delay
import timber.log.Timber

/**
create by: 86136
create time: 2023/3/16 18:00
Function description:
 */

class MinerController(p: AccessibilityHelper, c: () -> Boolean) : BaseController(p, c) {


    private val START_GAME = 0  //开始游戏
    private val MONITORING_RETURN_STATUS = 1//返回空间站监听
    private val WAIT_FOR_SAFE = 2//安全等待期
    private val OUT_SPAE = 3 //出空间站
    private val LOOKING_FOR_PLANETARY_GROUPS = 4//寻找资源行星
    private val MINING_MONITORING = 5//采矿监控期间


    private val ABNORMAL_STATE = 1000 //异常状态
    private val EXIT_OPT = 10000 //退出

    private var nowStep = START_GAME
    private var hasCorrected = false //是否修正坐标
    val warehouseIndex = spReo.miningBaseLocation

    private val isAlarm = false


    private val miningGunList by lazy {
        JsonUtil.anyToJsonObject(spReo.miningGunList) ?: listOf<Int>()
    }//这里是采矿的
    private val miningInertiaList by lazy {
        JsonUtil.anyToJsonObject(spReo.miningInertiaList) ?: listOf<Int>()
    }//这个放皮球的 或者  这个放推子
    private val miningStabilizerList by lazy {
        JsonUtil.anyToJsonObject(spReo.miningStabilizerList) ?: listOf<Int>()
    }//放圣光


    // 这个放皮球的
    val Inertia_INTERVAL = 60 * 1000L

    // 放圣光
    val Stabilizer_INTERVAL = 70 * 1000L

    // 默认是武器的
    var InertiaStamp = 0L

    // 默认是转速的
    var StabilizerStamp = 0L

    //
    val startTime = System.currentTimeMillis()
    val maxTime = Constant.Hour * 8

    override suspend fun generalControlMethod() {
        while (runSwitch) {
            when (nowStep) {
                START_GAME -> {
                    startGame()
                }
                MONITORING_RETURN_STATUS -> {
                    monitoringReturnStatus()
                }
                WAIT_FOR_SAFE -> {
                    waitForSafe()
                }
                OUT_SPAE -> {
                    outSpace()
                }
                LOOKING_FOR_PLANETARY_GROUPS -> {
                    lookingForMineralStars()
                }
                MINING_MONITORING -> {
                    monitoringDuringMining()
                }
                EXIT_OPT -> {
                    exitGame()
                }
            }
        }
    }

    private suspend fun startGame() {
        delay(2000)
        click(constant.getAppArea())
        delay(doubleClickInterval * 2)
        if (intoGame()) {
            if (visual.isInSpaceStation()) {
                nowStep = MONITORING_RETURN_STATUS
            } else if (visual.warehouseIsFull()) {
                clickJumpCollectionAddress(warehouseIndex, false)
                nowStep = MONITORING_RETURN_STATUS
            } else {
                ensureOpenLocalList()
                if (correctedCoordinate()) {
                    hasCorrected = true
                    nowStep = LOOKING_FOR_PLANETARY_GROUPS
                } else {
                    clickJumpCollectionAddress(warehouseIndex, false)
                    nowStep = MONITORING_RETURN_STATUS
                }
            }
        } else {
            onComplete.invoke()
        }
    }


    //监听是否已经抵达空间战  numberCount是循环监听次数  failedCode是失败时候执行的命令码  successCode是成功过时候执行的命令码
    private suspend fun monitoringReturnStatus() {
        Timber.d("返回监控阶段 monitoringReturnStatus MinerController NWQ_ 2023/3/21");
        var flag = true
        var count = 60
        nowStep = WAIT_FOR_SAFE
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return
            }
            if (isAlarm) {
                if (count < 15 && visual.shieldTooLow()) {
                    val needOpenList = mutableListOf<Int>()
                    checkTimingOnList(needOpenList)
                }
            }
            if (System.currentTimeMillis() - startTime > maxTime) {
                val spReo = if (SPRepo.role == SpConstant.PREFIX_ROLE1) {
                    SPRepo.role = SpConstant.PREFIX_ROLE2
                    SPRepoPrefix.getSPRepo(SpConstant.PREFIX_ROLE2)
                } else {
                    SPRepo.role = SpConstant.PREFIX_ROLE1
                    SPRepoPrefix.getSPRepo(SpConstant.PREFIX_ROLE1)
                }
                if (spReo.nowSelectMode == SpConstant.MINER_MODEL || TimeUtils.isNewTaskDay(spReo.lastCompleteTime)) {
                    nowStep = EXIT_OPT
                    return
                }
            } else if (System.currentTimeMillis() - startTime > maxTime * 1.4) {
                nowStep = EXIT_OPT
                return
            }

            if (visual.isInSpaceStation() && visual.hasPositionMenu()) {
                if (needChangeShip) {
                    changeTrainShip()
                }
                delay(doubleClickInterval)
                unloadingCargo(false)
                delay(doubleClickInterval)
                flag = false
            } else if (count <= 10 && !visual.isSailing()) {
                clickJumpCollectionAddress(warehouseIndex, false)
                count = 60
            }
            count--
        }
    }


    var lastSafeTime = 0L
    var LastDangerousTime = 0L
    var lastIsSafe = true
    private suspend fun waitForSafe() {
        //先打开本地保证数据是正确的
        ensureOpenLocalList()
        //修正数据
        if (!hasCorrected) {
            if (correctedCoordinate()) {
                hasCorrected = true
            } else {
                delay(normalClickInterval)
                slide(
                    screenBitmap.width / 2 - 50,
                    screenBitmap.height / 2 - 50,
                    150,
                    100,
                    DirectionType.RIGHT
                )
                if (!correctedCoordinate()) {
                    nowStep = EXIT_OPT
                    return
                }
            }
        }

        if (lastIsSafe) {
            if (openHarvestVegetablesSP && System.currentTimeMillis() - spReo.resourcesCollectTime > spReo.collectInterval * Constant.Hour) {
                harvestVegetableController.startCollectVegetables()
            } else if (celestialList.isNotEmpty() && System.currentTimeMillis() - spReo.resourcesAddTime > spReo.addInterval * Constant.Hour) {
                harvestVegetableController.addPlanetaryTime()
            }
        }
        if (!takeScreen(normalClickInterval)) {
            runSwitch = false
            return
        }
        val nowIsSafe = !visual.isDangerous(localOffsetX, localOffsetY)
        if (nowIsSafe == true && lastIsSafe == true) {
            if (System.currentTimeMillis() - lastSafeTime > getWaitTime()) {
                nowStep = OUT_SPAE
                wait_Time = 0L
            }
            Timber.d("准备出  waitForSafe MinerController NWQ_ 2023/3/21");
        } else if (nowIsSafe == true && lastIsSafe != true) {
            lastSafeTime = System.currentTimeMillis()
            Timber.d("等待期  waitForSafe MinerController NWQ_ 2023/3/21");
        } else if (nowIsSafe != true && lastIsSafe == true) {
            LastDangerousTime = System.currentTimeMillis()
            Timber.d("发现敌军  waitForSafe MinerController NWQ_ 2023/3/21");
        } else {
            Timber.d("敌军一直存在  waitForSafe MinerController NWQ_ 2023/3/21");
        }
        lastIsSafe = nowIsSafe
    }

    var wait_Time = 0L
    private fun getWaitTime(): Long {
        if (wait_Time == 0L) {
            wait_Time = ((Math.random() * 20 + 10) * 60 * 1000L).toLong()
        }
        return wait_Time
    }


    //这里处理出战，包括飞点等，这里先只做简单流程
    private suspend fun outSpace() {
        if (outSpaceStation()) {
            if (visual.isDamageM()) {
                if (spReo.lastStatus == VEGETABLES || spReo.lastStatus == VEGETABLE) {
                    needChangeShip = true
                    clickJumpCollectionAddress(warehouseIndex)
                    nowStep = MONITORING_RETURN_STATUS
                    spReo.lastStatus = NORMAL
                } else {
                    nowStep = EXIT_OPT
                    spReo.lastStatus = DAMAGE
                    Timber.d("已经损毁 lookingForMineralStars MinerController NWQ_ 2023/3/10");
                }
                return
            }
        } else {
            nowStep = EXIT_OPT
            spReo.lastStatus = UNUSUAL
            Timber.d("已经损毁 lookingForMineralStars MinerController NWQ_ 2023/3/10");
            return
        }
        ensureOpenPositionMenu()
        nowStep = LOOKING_FOR_PLANETARY_GROUPS
    }

    private suspend fun lookingForMineralStars() {
        var flag = true
        var startCount = (Math.random() * 3 + 1).toInt()
        var count = startCount
        var canRefresh = true
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return
            }
            if (isDangerous()) {
                clickJumpCollectionAddress(warehouseIndex, false)
                nowStep = MONITORING_RETURN_STATUS
                flag = false
            }
            ensureOpenEyeMenu()
            delay(normalClickInterval)

            //这里表示已经锁定上目标了 可以进行采矿监控了
            if (visual.getOreTargetNumber() > 0) {
                nowStep = MINING_MONITORING
                click(constant.getTopClickArea(0))
                click(constant.getTopSurroundArea(0), normalClickInterval)
                flag = false
                return
            }


            if (visual.IsTheResourceNotTop()) {
                swipe(constant.eyeMenuSwipeToTopArea(), 1)
                count = 4
                Timber.d("IsTheResourceNotTop lookingForMineralStars MinerController NWQ_ 2023/3/20");
                continue
            }

            click(constant.clickEyesMenuItemArea(count))
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return
            }
            when (visual.judeResourceType(count)) {
                visual.REMOTE_PLANETARY_GROUP -> {
                    Timber.d("REMOTE_PLANETARY_GROUP  lookingForMineralStars MinerController NWQ_ 2023/3/21");
                    click(constant.getTransitionArea(count))
                    delay(quadrupleClickInterval * 5)
                    val max = Math.random() * 3 + 1
                    for (i in 0 until max.toInt()) {
                        swipe(constant.eyeMenuSwipeToTopArea(), (Math.random() * 1 + 1).toInt())
                        delay(normalClickInterval)
                    }
                    count = 4
                    canRefresh = true
                }
                visual.RESOURCE_PLANET -> {
                    Timber.d("RESOURCE_PLANET  lookingForMineralStars MinerController NWQ_ 2023/3/21");
                    click(constant.getLockingArea(count))
                    count = (Math.random() * 2 + 2).toInt()
                    canRefresh = true
                }
                visual.MENU_NOT_OPEN -> {
                    Timber.d("MENU_NOT_OPEN  lookingForMineralStars MinerController NWQ_ 2023/3/21");
                    if (count == 1) {
                        if (canRefresh) {
                            swipe(constant.eyeMenuSwipeToTopArea(), 1)
                            canRefresh = false
                            count = 4
                        } else {
                            clickJumpCollectionAddress(warehouseIndex, false)
                            lastIsSafe = false
                            nowStep = MONITORING_RETURN_STATUS
                            flag = false
                        }
                    }
                }
            }
            count--
        }
    }

    //这个是开采监控阶段
    private suspend fun monitoringDuringMining() {
        Timber.d("采矿监控阶段 monitoringDuringMining MinerController NWQ_ 2023/3/20");
        var flag = true
        var lastTargetCount = 0
        var count = 65
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.shieldTooLow() || isDangerous() || visual.warehouseIsFull()) {
                Timber.d("返回基地了  monitoringDuringMining MinerController NWQ_ 2023/3/21");
                clickJumpCollectionAddress(warehouseIndex, false)
                nowStep = MONITORING_RETURN_STATUS
                flag = false
            }
            val count = visual.getOreTargetNumber()
            if (count <= 0) {
                Timber.d("没有矿石了  monitoringDuringMining MinerController NWQ_ 2023/3/21");
                nowStep = LOOKING_FOR_PLANETARY_GROUPS
                flag = false
            }
            if (lastTargetCount > count) {
                click(constant.getTopClickArea(0))
                click(constant.getTopSurroundArea(0), normalClickInterval)
            }
            lastTargetCount = count
            clickEquipArray(openCheckEquipTimes(3, miningGunList))
        }
        if (count <= 0) {
            Timber.d("采矿超时返回 monitoringDuringMining MinerController NWQ_ 2023/3/20");
            clickJumpCollectionAddress(warehouseIndex, false)
            nowStep = MONITORING_RETURN_STATUS
        }

    }

    private fun isDangerous(): Boolean {
        return if (visual.isDangerous(localOffsetX, localOffsetY)) {
            lastIsSafe = false
            LastDangerousTime = System.currentTimeMillis()
            Timber.d("isDangerous MinerController NWQ_ 2023/3/20");
            true
        } else {
            false
        }
    }


    private fun checkTimingOnList(needCheckOpenList: MutableList<Int>) {
        var nowTime = System.currentTimeMillis()
        if (checkTimeOn(
                miningInertiaList,
                nowTime,
                StabilizerStamp,
                Stabilizer_INTERVAL,
                needCheckOpenList
            )
        ) {
            StabilizerStamp = nowTime
        }
        if (checkTimeOn(
                miningStabilizerList,
                nowTime,
                InertiaStamp,
                Inertia_INTERVAL,
                needCheckOpenList
            )
        ) {
            InertiaStamp = nowTime
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
        if (intervalTime > combatInterval) {
            needCheckOpenList.addAll(list)
            flag = true
        }
        return flag
    }

    private suspend fun exitGame() {
        theOutCheck()
        clickJumpCollectionAddress(warehouseIndex, false)
        delay(doubleClickInterval)
        optExitGame()
    }
}