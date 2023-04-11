package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.star_wars.data.OptSlotInfo
import com.nwq.function.scheduling.utils.JsonUtil
import kotlinx.coroutines.delay
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
    private var needTargetOpt = true //是否许需要操作目标
    private var needStopShip = false
    private val START_GAME = 0//开始游戏
    private val IN_SPACE_STATION = 1  //在空间站
    private val IN_PREPARATION_INTERFACE = 2 //在准备界面
    private val BATTLE_NAVIGATION_MONITORING = 3//战斗监控阶段

    var nowStep = START_GAME
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
            OptSlotInfo(d, constant.listInterval3, 0, p, constant.offsetInterval * 12)
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

    private suspend fun startGame() {
        takeScreen(normalClickInterval)
        delay(2000)
        click(constant.getAppArea())
        delay(doubleClickInterval * 2)
        nowStep = IN_SPACE_STATION
    }

    suspend fun stationMonitoring() {
        nowStep++
        var flag = true
        var count = 40
        completedCount = 0
        needTargetOpt = true
        while (flag && count > 0 && runSwitch) {
            Timber.d("stationMonitoring DungeonOrdinaryController NWQ_ 2023/4/8");
            if (!takeScreen(doubleClickInterval)) {
                if (count < 30) {
                    runSwitch = false
                    return
                } else {
                    continue
                }
            }
            if (visual.isDungeonWaiting()) {
                flag = false
            } else if (visual.isDungeonFight()) {
                nowStep++
                flag = false
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
            Timber.d("stationMonitoring DungeonOrdinaryController NWQ_ 2023/4/8");
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.isDungeonFight()) {
                flag = false
            }
            count--
        }
        if (count == 0 && flag) {
            runSwitch = false
            return
        }
    }


    suspend fun combatMonitoring() {
        if (completedCount == 0 && needTargetOpt) {
            needTargetOpt = false
            selectRightEvacuationTarget()
            click(constant.clickEyesMenuItemArea(0), doubleClickInterval)
            click(constant.getTransitionArea(0), doubleClickInterval)
            delay(doubleClickInterval)
            selectRightImportTarget()
            clickEquipArray(listOf(propellerPosition))
        } else if (completedCount == 1 && needTargetOpt) {
            needTargetOpt = false
            click(constant.clickEyesMenuItemArea(0), doubleClickInterval)
            click(constant.getLockingArea(0), doubleClickInterval)
            clickEquipArray(listOf(propellerPosition))
        } else if (completedCount == 2 && needTargetOpt) {
            needTargetOpt = false
            needStopShip = true
            click(constant.clickEyesMenuItemArea(spReo.lastAttackPosition), doubleClickInterval)
            click(constant.getLockingArea(spReo.lastAttackPosition), doubleClickInterval)
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
//            if (visual.isDungeonComplete()) {
//                click(constant.completeDungeonArea)
//                continue
//            }

            if (completedCount == 2 && visual.isNearestNumberOne()) {
                stopShip()
                needStopShip = false
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
            Timber.d("目标数量:$nowTarget  combatMonitoring DungeonOrdinaryController NWQ_ 2023/4/9");
            if (nowTarget <= 0) {
                if (hasIntoAction) {
                    if (completedCount == 0) {
                        if (visual.isCompleteGoalOne()) {
                            needTargetOpt = true
                            completedCount = 1
                        }
                    } else if (completedCount == 1) {
                        if (visual.isCompleteGoalTwo()) {
                            needTargetOpt = true
                            completedCount = 2
                        }
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