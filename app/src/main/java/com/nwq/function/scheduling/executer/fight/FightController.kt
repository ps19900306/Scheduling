package com.nwq.function.scheduling.executer.fight

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController
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
    private val INTO_GAME = 0 //进入游戏
    private val PICK_UP_TASK = 1 //接取任务
    private val BATTLE_NAVIGATION_MONITORING = 2 //战斗飞行导航监控
    private val COMBAT_MONITORING = 3 //战斗监控阶段
    private val MONITORING_RETURN_STATUS = 4 //返回空间站监听
    private val ABNORMAL_STATE = 1000 //异常状态


    private val visualEnvironment by lazy {
        FightVisualEnvironment(helper)
    }

    /**
     * 这个是控制变量
     */
    override suspend fun generalControlMethod() {


    }

    suspend fun intoGame() {
        pressHomeBtn()
        delay(2000)
        helper.click((82 + (VisualConstant.APP_LOCATION_X - 1) * 254).toFloat(),
            (185 + (VisualConstant.APP_LOCATION_Y - 1) * 291).toFloat(), 154, 153)
        delay(doubleClickInterval*2)
        takeScreen()

    }
}