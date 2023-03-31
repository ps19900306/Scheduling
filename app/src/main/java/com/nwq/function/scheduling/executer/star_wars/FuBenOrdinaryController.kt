package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.utils.JsonUtil
import timber.log.Timber

/**
create by: 86136
create time: 2023/3/23 15:18
Function description:
普通成员
 */

class FuBenOrdinaryController(p: AccessibilityHelper, c: () -> Boolean) : BaseController(p, c) {

    val isHasPropeller = spReo.isHasPropellerF

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
    private val timeOnOpenList1 by lazy {
        JsonUtil.anyToJsonObject(spReo.timeOnList1F) ?: listOf<Int>()
    }
    private val timeOnOpenList2 by lazy {
        JsonUtil.anyToJsonObject(spReo.timeOnList2F) ?: listOf<Int>()
    }
    private val timeOnOpenList3 by lazy {
        JsonUtil.anyToJsonObject(spReo.timeOnList3F) ?: listOf<Int>()
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
                runSwitch = false
                return
            }
            if (visual.isDungeonWaiting()) {
                false
            }
            if (visual.isInviteToDungeon()) {
                click(constant.acceptDungeonArea)
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
        //打开选中第一个条目进行接近
        ensureOpenEyeMenu()
        click(constant.clickEyesMenuItemArea(0), doubleClickInterval)
        click(constant.getTransitionArea(0), doubleClickInterval)
        clickEquipArray(wholeBattleOpenList)

        var flag = true
        var count = 1200
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
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
            val nowTarget = visual.getTagNumber()
            if (nowTarget <= 0) {
                targetCount = nowTarget
                continue
            }

            val needCheckOpenList = mutableListOf<Int>()
            needCheckOpenList.addAll(wholeBattleOpenList)
            needCheckOpenList.addAll(roundBattleOpenList)
            val needCheckCloseList = mutableListOf<Int>()
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
}