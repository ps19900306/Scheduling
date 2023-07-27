package com.nwq.function.corelib.excuter.star_wars

import android.accessibilityservice.AccessibilityService
import com.nwq.function.corelib.Constant
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.excuter.EndLister
import com.nwq.function.corelib.excuter.star_wars.function.BottomDeviceMonitor
import com.nwq.function.corelib.excuter.star_wars.function.EnemyMonitor
import com.nwq.function.corelib.excuter.star_wars.function.TopTargetMonitor
import kotlinx.coroutines.delay
import timber.log.Timber

/**
create by: 86136
create time: 2023/6/28 15:04
Function description:
挖矿的先不做
 */
class InterstellarMiners(acService: AccessibilityService, endLister: EndLister? = null) :
    StarWarController(acService, endLister) {


    private val DAMAGE = -100 //飞船已经损毁

    private val LOOK_FOR_TARGET = 1 //寻找矿物星球目标
    private val BATTLE_NAVIGATION_MONITORING = 2//战斗飞行导航监控
    private val COMBAT_MONITORING = 3 //战斗监控阶段
    private val OUT_STATUS = 5// 出战监听
    private val RESTART_GAME = 401//退出重新进入
    private val ALL_COMPLETE = 9//全部完成
    private val CHECK_SHIP = 10//检查船只

    private val topTargetMonitor by lazy {
        TopTargetMonitor(
            en.topLockTargetList1, en.topTargetHpList1, en.topLockTargetList2, en.topTargetHpList2
        ).apply {
            secondReducer = false
            waitEndMax = 5
            openEndMenu(true)
        }
    }
    private val bottomDeviceMonitor by lazy {
        BottomDeviceMonitor(en.topDeviceList, en.bottomDeviceList)
    }
    private lateinit var enemyMonitor: EnemyMonitor
    private lateinit var outSpaceArea: CoordinateArea
    private var needBack = false
    private var needRestart = false

    override suspend fun generalControlMethod() {
        while (runSwitch) {
            when (nowTask) {
                START_GAME -> {
                    startGame()
                }
                MONITORING_RETURN_STATUS -> {
                    monitoringReturnStatus()
                }
                OUT_STATUS -> {
                    outSpace()
                }
                LOOK_FOR_TARGET -> {
                    lookForTarget()
                }
                BATTLE_NAVIGATION_MONITORING -> {
                    startNavigationMonitoring()
                }
                COMBAT_MONITORING -> {
                    combatMonitoring()
                }
                ALL_COMPLETE -> {
                    onComplete()
                }
                CHECK_SHIP -> {

                }
                RESTART_GAME -> {//这里先退出游戏再出去
                    restartGame()
                }
                ABNORMAL_STATE -> {
                    abnormalState()
                }
            }
        }
    }

    private suspend fun startGame() {
        if (en.isOpenEyeMenuT.check() || en.isCloseEyeMenuT.check()) {
            waitImgTask2(en.isOpenEyeMenuT, en.openEyeMenuArea)
            //这里还需要打开本地的人员监控
        }
        topTargetMonitor.updateInfo(screenBitmap!!)
        nowTask = if (topTargetMonitor.lastTargetNumber > 0 || en.isCanLockTask.check()) {
            COMBAT_MONITORING
        } else if (en.isOpenEyeMenuT.check() || en.isCloseEyeMenuT.check()) {
            LOOK_FOR_TARGET
        } else {
            MONITORING_RETURN_STATUS
        }
    }

    private suspend fun monitoringReturnStatus() {
        Timber.d("monitoringReturnStatus BrushLocalMonsterController NWQ_ 2023/4/11");
        var flag = true
        val maxCount = 15 * 60
        var count = maxCount
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (enemyMonitor.getEnemyNumber() > 0) {
                topTargetMonitor.updateInfo(screenBitmap!!)
                if (topTargetMonitor.lastTargetNumber > 0) { //这里表示被敌人拦下了 需要进行战斗
                    nowTask = COMBAT_MONITORING
                    flag = false
                }
            }

            if (en.isInSpaceStationT.check()) {
                if (spReo.isPickupBox) {
                    unloadingCargo()
                }
                nowTask = OUT_STATUS
                flag = false
            } else if (en.isOpenBigMenuT.check()) {
                click(en.closeBigMenuArea)
            } else if (en.isConfirmDialogTask.check()) {
                click(en.confirmDialogEnsureArea)
            } else if (en.isCanLockTask.check()) {
                nowTask = COMBAT_MONITORING
                flag = false
            } else if (count < maxCount - 10 && !en.isSailingT.check() && en.isCloseEyeMenuT.check() && en.isOpenEyeMenuT.check()
            ) {
                emergencyEvacuation()
            }
            count--
        }
        if (count == 0 && flag) {
            runSwitch = false
            return
        }
    }

    private suspend fun outSpace() {
        var flag = true
        var count = 10
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.doubleClickInterval)) {
                runSwitch = false
                return
            }
            enemyMonitor.updateInfo(screenBitmap!!)
            //这里需要保证先打开本地菜单
            if (enemyMonitor.isSafe()) {
                flag = false
            }
        }

        outSpaceArea.clickA()
        flag = true
        count = 10
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.tripleClickInterval)) {
                runSwitch = false
                return
            }
            if (en.isOpenEyeMenuT.check() || en.isCloseEyeMenuT.check()) {
                nowTask = LOOK_FOR_TARGET
                openPositionMenu()
                flag = false
            } else if (en.isInSpaceStationT.check()) {
                outSpaceArea.clickA()
            }
            count--
        }

        if (flag) {
            nowTask = ABNORMAL_STATE
        }
    }

    private suspend fun lookForTarget() {

    }


    private suspend fun startNavigationMonitoring() {
        Timber.d("monitoringReturnStatus FightController NWQ_ 2023/4/11");
        var flag = true
        val maxCount = 20
        var count = maxCount
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.doubleClickInterval)) {
                runSwitch = false
                return
            }
            enemyMonitor.updateInfo(screenBitmap!!)
            if (!enemyMonitor.isSafe()) { //如果有敌军进行战斗返回监控
                nowTask = MONITORING_RETURN_STATUS
                emergencyEvacuation()
                flag = false
            } else if (en.isCanLockTask.check()) {
                topTargetMonitor.clearData()
                bottomDeviceMonitor.clearData()
                nowTask = COMBAT_MONITORING
                flag = false
            } else if (en.isConfirmDialogTask.check()) {
                click(en.confirmDialogEnsureArea)
            } else if (en.isClosePositionMenuT.check()) {
                count--
            }
        }
        if (flag && runSwitch) {
            nowTask = LOOK_FOR_TARGET
            return
        }
    }


    private suspend fun combatMonitoring() {
        var flag = true
        while (flag && runSwitch) {
            if (!takeScreen(Constant.doubleClickInterval)) {
                runSwitch = false
                return
            }
            //每一轮发现敌人都有优先撤离
            enemyMonitor.updateInfo(screenBitmap!!)
            if (!enemyMonitor.isSafe()) {
                emergencyEvacuation()
                needBack = true
            }

            if (en.isCanLockTask.check()) {
                en.lockTargetArea.clickA()
                delay(Constant.doubleClickInterval)
                if (topTargetMonitor.onNewAgainLock()) {
                    bottomDeviceMonitor.openReducer()
                } else {
                    bottomDeviceMonitor.closeReducer()
                }
            } else if (needBack && (isInSailing(screenBitmap) || en.isInSpaceStationT.check())) {//这里一般是血量异常或者卡住了
                nowTask = MONITORING_RETURN_STATUS
                return
            } else {
                topTargetMonitor.updateInfo(screenBitmap!!)
                if (needBack && topTargetMonitor.fewerTargets) {//这里没减少一次目标点击一次撤离
                    emergencyEvacuation()
                }
                if (topTargetMonitor.needOpenReducer) {
                    bottomDeviceMonitor.openReducer()
                } else {
                    bottomDeviceMonitor.closeReducer()
                }
                if (topTargetMonitor.isWaitEnd()) {
                    if (!needBack) {
                        Timber.d("topTargetMonitor isWaitEnd NWQ_ 2023/7/22");
                        topTargetMonitor.clearData()
                        bottomDeviceMonitor.clearData()
                        nowTask = LOOK_FOR_TARGET
                        return
                    } else {
                        emergencyEvacuation()
                        nowTask = MONITORING_RETURN_STATUS
                        return
                    }
                }

                if (!needBack && topTargetMonitor.isNeedAbnormal()) {
                    if (topTargetMonitor.isNeedAbnormal()) {
                        Timber.d("topTargetMonitor emergencyEvacuation NWQ_ 2023/7/22");
                        emergencyEvacuation()
                        nowTask = MONITORING_RETURN_STATUS
                        needBack = true
                    }
                }
                if (topTargetMonitor.lastTargetNumber > 0) {
                    val listArea = bottomDeviceMonitor.updateInfo(screenBitmap!!)
                    click(listArea)
                    if (bottomDeviceMonitor.isNeedAbnormal()) {
                        Timber.d("bottomDeviceMonitor emergencyEvacuation NWQ_ 2023/7/22");
                        emergencyEvacuation()
                        nowTask = RESTART_GAME
                        needBack = true
                        needRestart = true
                    }
                } else if (needBack) { //如果没有目标 需要撤离则进行紧急撤了
                    emergencyEvacuation()
                }
            }
        }
    }


}