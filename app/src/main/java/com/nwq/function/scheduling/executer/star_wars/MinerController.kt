package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.click.DirectionType
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController
import com.nwq.function.scheduling.utils.JsonUtil
import com.nwq.function.scheduling.utils.sp.SP
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SpConstant
import kotlinx.coroutines.delay
import java.util.Date

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
    private val GO_TO_COLLECT_NAVIGATION_MONITORING = 4//战斗飞行导航监控
    private val Mining_MONITORING = 5//采矿监控期间


    private val ABNORMAL_STATE = 1000 //异常状态
    private val EXIT_OPT = 10000 //退出

    private var nowStep = START_GAME
    private var hasCorrected = false //是否修正坐标
    val warehouseIndex by lazy {
        SP.getValue(prefixRole + SpConstant.BASE_LOCATION, 0)
    }

    private val isAlarm = false


    private val wholeBattleOpenList by lazy {
        val listStr = SP.getValue(prefixRole + SpConstant.WHOLE_BATTLE_LIST, "[1,8]")
        JsonUtil.anyToJsonObject(listStr) ?: listOf<Int>()
    }//这里是采矿的
    private val roundBattleOpenList by lazy {
        val listStr = SP.getValue(prefixRole + SpConstant.ROUND_BATTLE_LIST, "[4,5]")
        JsonUtil.anyToJsonObject(listStr) ?: listOf<Int>()
    }
    private val timeOnOpenList1 by lazy {
        val listStr = SP.getValue(prefixRole + SpConstant.TIME_ON_LIST1, "[11,12]")
        JsonUtil.anyToJsonObject(listStr) ?: listOf<Int>()
    }//这个放皮球的
    private val timeOnOpenList2 by lazy {
        val listStr = SP.getValue(prefixRole + SpConstant.TIME_ON_LIST2, "")
        JsonUtil.anyToJsonObject(listStr) ?: listOf<Int>()
    }//这个放推子
    private val timeOnOpenList3 by lazy {
        val listStr = SP.getValue(prefixRole + SpConstant.TIME_ON_LIST3, "[10]")
        JsonUtil.anyToJsonObject(listStr) ?: listOf<Int>()
    }//放圣光


    // 这个放皮球的
    var CombatStamp_1 = 0L
    val BASIC_COMBAT_INTERVAL_1 = 165 * 1000L

    // 这个放推子
    var CombatStamp_2 = 0L
    val BASIC_COMBAT_INTERVAL_2 = 170 * 1000L

    // 放圣光
    var CombatStamp_3 = 0L
    val BASIC_COMBAT_INTERVAL_3 = 75 * 1000L


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

            }
        }
    }


    private suspend fun outSpace() {
        click(constant.outSpaceArea)
        var cout = 10
        var flag = true
        while (flag && runSwitch && cout > 0) {
            takeScreen(doubleClickInterval)
            if (visual.hasEyesMenu() && visual.hasPositionMenu()) {
                flag = false
            } else if (cout == 5 && visual.isInSpaceStation()) {
                click(constant.outSpaceArea)
            } else if (cout == 1) {
                nowStep = EXIT_OPT
            }
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


        takeScreen(normalClickInterval)
        val nowIsSafe = visual.isSafeInList(localOffsetX, localOffsetY)
        if (nowIsSafe == true && lastIsSafe == true) {
            if (System.currentTimeMillis() - lastSafeTime > getWaitTime()) {
                nowStep = OUT_SPAE
                waitTime = 0L
            }
        } else if (nowIsSafe == true && lastIsSafe != true) {
            lastSafeTime = System.currentTimeMillis()
        } else if (nowIsSafe != true && lastIsSafe == true) {
            LastDangerousTime = System.currentTimeMillis()
        }
        lastIsSafe = nowIsSafe
    }

    var waitTime = 0L
    fun getWaitTime(): Long {
        if (waitTime == 0L) {
            waitTime = ((Math.random() * 20 + 10) * 60 * 1000L).toLong()
        }
        return waitTime
    }

    private suspend fun startGame() {
        takeScreen(normalClickInterval)
        delay(2000)
        click(constant.getAppArea())
        delay(doubleClickInterval * 2)
        generalControlMethod()
        intoGame()
        if (visual.isInSpaceStation()) {
            nowStep = MONITORING_RETURN_STATUS
        } else if (visual.warehouseIsFull()) {
            clickJumpCollectionAddress(warehouseIndex, false)
        } else {
            nowStep = MONITORING_RETURN_STATUS
        }
    }

    //监听是否已经抵达空间战  numberCount是循环监听次数  failedCode是失败时候执行的命令码  successCode是成功过时候执行的命令码
    private suspend fun monitoringReturnStatus() {
        var flag = true
        var count = 20
        nowStep = WAIT_FOR_SAFE
        while (flag && count > 0 && runSwitch) {
            takeScreen(normalClickInterval)
            if (isAlarm) {
                if (count < 15 && visual.shieldTooLow()) {
                    val needOpenList = mutableListOf<Int>()
                    checkTimingOnList(needOpenList)
                }
                if (visual.armorTooLow()) {//被打到红甲就结束
                    nowStep = EXIT_OPT
                }
            }
            if (visual.isInSpaceStation() && visual.hasPositionMenu()) {
                delay(doubleClickInterval)
                unloadingCargo()
                delay(doubleClickInterval)
                flag = false
            } else if (count <= 10 && !visual.isSailing()) {
                clickJumpCollectionAddress(warehouseIndex, false)
            }
            count--
        }
    }

    private fun checkTimingOnList(needCheckOpenList: MutableList<Int>) {
        var nowTime = System.currentTimeMillis()
        if (checkTimeOn(
                timeOnOpenList3, nowTime, CombatStamp_3, BASIC_COMBAT_INTERVAL_3, needCheckOpenList
            )
        ) {
            CombatStamp_3 = nowTime
        }
        needCheckOpenList.addAll(timeOnOpenList2)
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
        if (intervalTime > combatInterval) {
            needCheckOpenList.addAll(list)
            flag = true
        }
        return flag
    }

}