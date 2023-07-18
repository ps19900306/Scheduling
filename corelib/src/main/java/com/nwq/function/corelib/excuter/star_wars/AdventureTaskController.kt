package com.nwq.function.corelib.excuter.star_wars

import android.accessibilityservice.AccessibilityService
import com.nwq.function.corelib.Constant.doubleClickInterval
import com.nwq.function.corelib.excuter.EndLister
import timber.log.Timber

/**
create by: 86136
create time: 2023/7/17 19:45
Function description:
 */

class AdventureTaskController(acService: AccessibilityService, endLister: EndLister? = null) :
    StarWarController(acService, endLister) {


    private val DAMAGE = -100 //飞船已经损毁
    private val START_GAME = 0  //开始游戏
    private val PICK_UP_TASK = 1 //接取任务
    private val BATTLE_NAVIGATION_MONITORING = 2//战斗飞行导航监控
    private val COMBAT_MONITORING = 3 //战斗监控阶段
    private val MONITORING_RETURN_STATUS = 4//返回空间站监听
    private val ALL_COMPLETE = 9//返回空间站监听
    private val CHECK_SHIP = 10//检查船只

    private val EXIT_GAME = 400//正常退出
    private val RESTART_GAME = 401//退出重新进入
    private val EXIT_GAME_ERROR = 1000//异常退出


    private var nowTask = START_GAME

    override suspend fun generalControlMethod() {
        while (runSwitch) {

        }
    }


    private fun pickTask() {

    }

    private lateinit var topTargetMonitor: TopTargetMonitor
    private lateinit var bottomDeviceMonitor: BottomDeviceMonitor

    //    var mEnterCombatStatus = false //这个是进入战斗的时间
    private var needBack = false
    private var needCancel = false
    private suspend fun combatMonitoring() {
        var flag = true
        var count = 200
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (en.isCanLockTask.verificationRule(screenBitmap)) {
                click(en.isCanLockTask)
                if (topTargetMonitor.onNewLock()) {
                    bottomDeviceMonitor.openReducer()
                }
            } else if (hasTaskDialogBox(screenBitmap)) { //这里表示任务已经结束了
                nowTask = PICK_UP_TASK
                return
            } else if (needBack && (isInSailing(screenBitmap) || en.isInSpaceStationT.verificationRule(
                    screenBitmap
                ))
            ) {//这里一般是血量异常或者卡住了
                nowTask = MONITORING_RETURN_STATUS
                return
            } else {
                topTargetMonitor.updateInfo(screenBitmap!!)
                if (topTargetMonitor.needOpenReducer) {
                    bottomDeviceMonitor.openReducer()
                }
                if (!needBack && topTargetMonitor.isNeedAbnormal()) {
                    emergencyEvacuation()
                    needCancel = true
                    needBack = true
                }
                if (topTargetMonitor.lastTargetNumber > 0) {
                    val listArea = bottomDeviceMonitor.updateInfo(screenBitmap!!)
                    click(listArea)
                    if (bottomDeviceMonitor.isNeedAbnormal()) {
                        emergencyEvacuation()
                        nowTask = RESTART_GAME
                        needCancel = true
                        needBack = true
                    }
                } else if (needBack) { //如果没有目标 需要撤离则进行紧急撤了
                    emergencyEvacuation()
                }
            }
        }

        if (count < 0) {
            emergencyEvacuation()
            nowTask = MONITORING_RETURN_STATUS
            needCancel = true
            needBack = true
        }
    }


}