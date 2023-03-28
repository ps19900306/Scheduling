package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.utils.JsonUtil
import timber.log.Timber

/**
create by: 86136
create time: 2023/3/23 15:18
Function description:
 */

class FuBenController(p: AccessibilityHelper, c: () -> Boolean) : BaseController(p, c) {

    val isHasPropeller = spReo.isHasPropellerF

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

    }


    suspend fun combatMonitoring() {
        var flag = true
        var count = 10
        clickEquipArray(openCheckEquipTimes(2, wholeBattleOpenList))
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                count--
                continue
            }
            count = 10
            if (visual.hasGroupLock()) {
                click(constant.lockTargetGroupArea)
                continue
            }

            val nowTargetCount = visual.getTagNumber()
            if (nowTargetCount <= 0) {
                if (isHasPropeller) {
                    val list = checkEquipTimes(2, listOf(weaponPosition), listOf(propellerPosition))
                    if (list.contains(weaponPosition) && list.contains(propellerPosition)) {
                        clickEquipArray(listOf(propellerPosition))
                    }
                }
                hasNewLock = true
                hasOpenCatch = false
                continue
            }

            val needCheckOpenList = mutableListOf<Int>()
            val needCheckCloseList = mutableListOf<Int>(propellerPosition)
            if (nowTargetCount > 0) {
                if (catchFoodList.isNullOrEmpty()) {//这里就需要判断是否需要开启网子
                } else if (nowTargetCount > targetCount && hasNewLock) {
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
                clickEquipArray(checkEquipTimes(2, needCheckOpenList, needCheckCloseList))

                if (!hasOpenCatch && needCheckOpenList.contains(0) && checkEquipTimes(
                        2, listOf(), catchFoodList
                    ).isNotEmpty()
                ) {
                    Timber.d("hasOpenCatch:$hasOpenCatch combatMonitoring FightController NWQ_ 2023/3/13");
                    hasOpenCatch = true
                }




            }
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

}