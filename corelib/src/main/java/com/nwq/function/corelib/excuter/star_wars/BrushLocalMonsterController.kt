package com.nwq.function.corelib.excuter.star_wars

import android.accessibilityservice.AccessibilityService
import com.nwq.function.corelib.excuter.EndLister

/**
create by: 86136
create time: 2023/7/25 15:36
Function description:
这个是刷
 */
class BrushLocalMonsterController (acService: AccessibilityService, endLister: EndLister? = null) :
    StarWarController(acService, endLister){
    private val DAMAGE = -100 //飞船已经损毁
    private val START_GAME = 0  //开始游戏
    private val XU = 1 //接取任务
    private val BATTLE_NAVIGATION_MONITORING = 2//战斗飞行导航监控
    private val COMBAT_MONITORING = 3 //战斗监控阶段
    private val MONITORING_RETURN_STATUS = 4//返回空间站监听
    private val ALL_COMPLETE = 9//全部完成
    private val CHECK_SHIP = 10//检查船只
    private var nowTask = START_GAME

    override suspend fun generalControlMethod() {
        while (runSwitch) {
            when (nowTask) {
//                START_GAME -> {
//                    startGame()
//                }
//                PICK_UP_TASK -> {
//                    pickTask()
//                }
//                BATTLE_NAVIGATION_MONITORING -> {
//                    startNavigationMonitoring()
//                }
//                COMBAT_MONITORING -> {
//                    combatMonitoring()
//                }
//                MONITORING_RETURN_STATUS -> {
//                    monitoringReturnStatus()
//                }
//                ALL_COMPLETE -> {
//                    outGame()
//                    runSwitch = false
//                    endLister?.onEndLister()
//                }
//                CHECK_SHIP -> {
//
//                }
//                RESTART_GAME -> {//这里先退出游戏再出去
//                    restartGame()
//                }
//                ABNORMAL_STATE -> {
//                    theOutCheck()
//                    clickPositionMenu(warehouseIndex)
//                    nowTask = MONITORING_RETURN_STATUS
//                }
            }
        }
    }

    private suspend fun startGame() {
//        topTargetMonitor.updateInfo(screenBitmap!!)
//        if (topTargetMonitor.lastTargetNumber > 0 || en.isCanLockTask.check()) {
//            nowTask = COMBAT_MONITORING
//        } else {
//            nowTask = PICK_UP_TASK
//        }
    }
}