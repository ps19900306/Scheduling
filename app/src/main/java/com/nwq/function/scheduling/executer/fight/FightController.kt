package com.nwq.function.scheduling.executer.fight

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController
import com.nwq.function.scheduling.utils.log.L
import kotlinx.coroutines.delay

/**
create by: 86136
create time: 2023/2/28 10:43
Function description:
这个是逻辑控制流程,保证能复用
 */

class FightController(p: AccessibilityHelper) : TravelController(p) {

    /**
     * 这个是状态常规量
     */
    private val DAMAGE = -100 //飞船已经损毁
    private val START_GAME = 0  //开始游戏
    private val INTO_GAME = 1 //进入游戏
    private val PICK_UP_TASK = 2 //接取任务
    private val BATTLE_NAVIGATION_MONITORING = 3//战斗飞行导航监控
    private val COMBAT_MONITORING = 4 //战斗监控阶段
    private val MONITORING_RETURN_STATUS = 5//返回空间站监听
    private val ABNORMAL_STATE = 1000 //异常状态

    //下面是进入游戏的的一些判断条件
    private val LOADING = 11;
    private val ANNOUNCEMENT = 12;
    private val START_GAME_MENU = 13
    private val SELECT_ROLE = 14
    private val BIG_MENU = 15

    private val STATUS_DETERMINATION = 1000000//这个是进行状态判定


    /**
     * 这个是控制变量
     */
    private var nowStep = START_GAME
    var runSwitch = true
    var intoGameStep = LOADING
    var cancelTask = false
    var needBackStation = false
    var mNumberOfTasksReceived = 51
    private val visual by lazy {
        FightVisualEnvironment(helper)
    }


    /*******************************************************************
     *                        下面都是方法
     * *****************************************************************
     */
    override suspend fun generalControlMethod() {
        while (runSwitch) {
            when (nowStep) {
                START_GAME -> {
                    startGame()
                }
                INTO_GAME -> {
                    intoGame()
                }
            }
        }
    }

    suspend fun startGame() {
        pressHomeBtn()
        delay(2000)
        helper.click(
            (82 + (VisualConstant.APP_LOCATION_X - 1) * 254).toFloat(),
            (185 + (VisualConstant.APP_LOCATION_Y - 1) * 291).toFloat(), 154, 153
        )
        delay(doubleClickInterval * 2)
        takeScreen()
        if (visual.hasIntoGame()) {
            nowStep = STATUS_DETERMINATION
        }
    }

    suspend fun intoGame() {
        when (intoGameStep) {
            LOADING -> {

            }
            ANNOUNCEMENT -> {

            }
            START_GAME_MENU -> {

            }
            SELECT_ROLE -> {

            }
            BIG_MENU -> {

            }
        }
    }

    suspend fun pickUpTask() {
        if (mNumberOfTasksReceived <= 0) {
            exitController()
            return
        }
        mNumberOfTasksReceived--
        var inSpaceStation = visual.isInSpaceStation()
        L.i("准备接取任务  inSpaceStation: $inSpaceStation ", "pickUpTask", "FightController", "nwq", "2023/3/2");
    }


    suspend fun exitController() {

    }

}