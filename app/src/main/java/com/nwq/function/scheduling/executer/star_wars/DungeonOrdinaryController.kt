package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.star_wars.data.OptSlotInfo
import com.nwq.function.scheduling.utils.JsonUtil
import timber.log.Timber

/**
create by: 86136
create time: 2023/3/23 15:18
Function description:
普通成员
 */

class DungeonOrdinaryController(p: AccessibilityHelper, c: () -> Boolean) : BaseController(p, c) {

    val isHasPropeller = spReo.isHasPropellerF

    private var completedCount = 0 //记录激活了几塔
    private var aWaveOfRat = 0//记录第几波怪
    private var needStopShip = false
    private val IN_SPACE_STATION = 0  //在空间站
    private val IN_PREPARATION_INTERFACE = 1 //在准备界面
    private val BATTLE_NAVIGATION_MONITORING = 2//战斗监控阶段

    var nowStep = IN_SPACE_STATION
    var targetCount = 0;
    var hasNewLock = true
    var targetReduceTime = 0L //这个是上次目标减少的时间
    var hasOpenCatch = false


    //后面这里由外部读取数据进行初始化
    private val wholeBattleOpenList by lazy {
        JsonUtil.anyToJsonObject(spReo.wholeBattleListF) ?: listOf<Int>()
    }
    private val roundBattleOpenList by lazy {
        JsonUtil.anyToJsonObject(spReo.roundBattleListF) ?: listOf<Int>()
    }
    var isCatchFoodSp = spReo.isCatchFoodF
    private val catchFoodList by lazy {
        if (isCatchFoodSp) listOf<Int>(1 + BotOfst, 4 + BotOfst)
        else listOf<Int>()
    }

    private val mOptSlotInfoList1 by lazy {
        JsonUtil.anyToJsonObject<List<Int>>(spReo.timeOnList1F)?.mapIndexed { p, d ->
            OptSlotInfo(d, constant.listInterval1, 0, p, constant.offsetInterval * 30)
        } ?: listOf<OptSlotInfo>()
    }

    private val mOptSlotInfoList2 by lazy {
        JsonUtil.anyToJsonObject<List<Int>>(spReo.timeOnList2F)?.mapIndexed { p, d ->
            OptSlotInfo(d, constant.listInterval2, 0, p, constant.offsetInterval * 30)
        } ?: listOf<OptSlotInfo>()
    }

    private val mOptSlotInfoList3 by lazy {
        JsonUtil.anyToJsonObject<List<Int>>(spReo.timeOnList3F)?.mapIndexed { p, d ->
            OptSlotInfo(d, constant.listInterval3, 0, p, constant.offsetInterval * 30)
        } ?: listOf<OptSlotInfo>()
    }

    private val COMBAT_MONITORING = 1 //战斗监控阶段
    override suspend fun generalControlMethod() {
        while (runSwitch) {
            Timber.d("nowStep:$nowStep generalControlMethod FightController NWQ_ 2023/3/10");
            when (nowStep) {
                IN_SPACE_STATION -> {
                    stationMonitoring()
                }
                IN_PREPARATION_INTERFACE -> {
                    preparationMonitoring()
                }
                BATTLE_NAVIGATION_MONITORING -> {
                    combatMonitoring()
                }
            }
        }
    }


    suspend fun stationMonitoring() {
        nowStep++
        var flag = true
        var count = 40
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                if (count < 30) {
                    runSwitch = false
                    return
                } else {
                    continue
                }
            }
            if (visual.isDungeonWaiting()) {
                false
            }
            if (visual.isShowDetermine()) {
                click(constant.dialogDetermineArea)
            }
            count--
        }
        if (count == 0 && flag) {
            runSwitch = false
            return
        }
    }


    suspend fun preparationMonitoring() {
        nowStep++
        var flag = true
        var count = 40
        click(constant.preparationDungeonArea, doubleClickInterval)
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.isDungeonFight()) {
                false
            }
            count--
        }
        if (count == 0 && flag) {
            runSwitch = false
            return
        }
    }


    suspend fun combatMonitoring() {
        if (completedCount == 0 && aWaveOfRat == 0) {
            selectRightEvacuationTarget()
            click(constant.clickEyesMenuItemArea(0), doubleClickInterval)
            click(constant.getTransitionArea(0), doubleClickInterval)
            selectRightImportTarget()
            clickEquipArray(listOf(propellerPosition))
        } else if (completedCount == 1 && aWaveOfRat == 0) {
            click(constant.clickEyesMenuItemArea(0), doubleClickInterval)
            click(constant.getLockingArea(0), doubleClickInterval)
            clickEquipArray(listOf(propellerPosition))
        } else if (completedCount == 2 && aWaveOfRat == 0) {
            needStopShip = true
            click(constant.clickEyesMenuItemArea(4), doubleClickInterval)
            click(constant.getLockingArea(0), doubleClickInterval)
            clickEquipArray(listOf(propellerPosition))
        }

        //打开选中第一个条目进行接近
        var flag = true
        var count = 1200
        var hasIntoAction = false//是否已经进入战斗
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.isInSpaceStation()) {
                nowStep = IN_SPACE_STATION
                flag = false
                continue
            }
            if (visual.isDungeonComplete()) {
                click(constant.completeDungeonArea)
                continue
            }

            if (visual.hasGroupLock()) {
                click(constant.lockTargetGroupArea)
                if (spReo.isCatchFoodF) {
                    if (targetCount <= 0) {
                        targetReduceTime = System.currentTimeMillis()
                        hasNewLock = true
                    } else if (hasNewLock && targetCount > 4) {
                        openDecelerationNet()
                        targetReduceTime = System.currentTimeMillis()
                    }
                }
                continue
            }
            val nowTarget = visual.getOpenTargetNumber()
            if (nowTarget <= 0) {
                if (hasIntoAction) {
                    aWaveOfRat++
                    if (aWaveOfRat == 2) {
                        aWaveOfRat = 0
                        completedCount++
                    }
                    flag = false //进入下一轮
                }
                targetCount = nowTarget
                continue
            }

            hasIntoAction = true
            val needCheckOpenList = mutableListOf<Int>()
            needCheckOpenList.addAll(wholeBattleOpenList)
            needCheckOpenList.addAll(roundBattleOpenList)
            val needCheckCloseList = mutableListOf(propellerPosition)
            if (spReo.isCatchFoodF) {
                if (targetCount >= nowTarget) {
                    if (hasNewLock && System.currentTimeMillis() - targetReduceTime > DESTROY_INTERVAL * 2) {
                        hasNewLock = false
                        targetReduceTime = System.currentTimeMillis()
                        needCheckOpenList.addAll(catchFoodList)
                    } else if (!hasNewLock && System.currentTimeMillis() - targetReduceTime > DESTROY_INTERVAL) {
                        targetReduceTime = System.currentTimeMillis()
                        needCheckOpenList.addAll(catchFoodList)
                    }
                } else {
                    targetReduceTime = System.currentTimeMillis()
                }
            }
            targetCount = nowTarget
            //打开定时开启的
            checkTimingOnList(needCheckOpenList)
            val list = checkEquipTimes(2, needCheckOpenList, needCheckCloseList)
            clickEquipArray(list)
            count--
        }


        if (count == 0 && flag) {
            runSwitch = false
            return
        }
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
}