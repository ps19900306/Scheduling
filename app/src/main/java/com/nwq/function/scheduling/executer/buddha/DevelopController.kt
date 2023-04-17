package com.nwq.function.scheduling.executer.buddha

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController

class DevelopController(p: AccessibilityHelper, c: () -> Boolean) : TravelController(p, c) {


    protected val visual by lazy {
        BuddhaEnvironment(helper)
    }
    protected val constant by lazy {
        BuddhaConstant()
    }

    override suspend fun generalControlMethod() {
        var flag = true
        var count = 40
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                count--
                continue
            }
            else if (visual.needAutomaticCombatColor()) {//需要点击自动
                click(constant.needAutomaticCombatArea)
            } else if (visual.needStartMainColor()) {//开启主线追踪
                click(constant.needStartMainArea)
            } else if (visual.updateEquipmentColor()) {//更新装备
                click(constant.updateEquipmentArea)
            } else if (visual.clickInteractiveDialogueColor()) {//对话互动框
                click(constant.clickInteractiveDialogueArea)
            } else if (visual.clickInteractivePickupColor()) {//拾取互动框
                click(constant.clickInteractivePickupArea)
            } else if (visual.summoningEagleColor()) {//召唤雕
                click(constant.summoningEagleArea)
            } else if (visual.skipConversationColor()) { //跳过对话框
                click(constant.skipConversationArea)
            } else if (visual.skipAnimationColor()) { //点击继续
                click(constant.skipAnimationArea)
            } else if (visual.tapToContinueColor()) { //点击继续
                click(constant.tapToContinueArea)
            } else if (visual.breakingBoundariesColor()) { //突破境界
                click(constant.breakingBoundariesArea)
            } else if (visual.breakingCompletionColor() && visual.rightCloseColor()) { //突破完成
                click(constant.rightCloseArea)
            } else if (visual.challengeFailedColor()) { //挑战失败
                click(constant.challengeFailedArea)
            } else if (visual.challengeSuccessColor()) { //挑战失败
                click(constant.challengeSuccessArea)
            }

        }
    }
}