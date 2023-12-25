package com.android.schedule.corelibrary.controller.functions

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.click.SimpleClickUtils
import com.android.schedule.corelibrary.controller.ClickSpeedControl
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.xiaomi.XiaoMiEnvironment
import kotlinx.coroutines.delay


class CollectVoucherExecuter(acService: AccessibilityService) : TurnBaseController(acService) {

    private var result = false

    val en = XiaoMiEnvironment
    suspend fun optCollectVoucher() {
        var flag = true
        var count = 12

        L.d("进入优惠卷领取")
        val clickSpeedControl = ClickSpeedControl()
        clickSpeedControl.addUnit(en.isHomeGameCenterTask, en.homeGameCenterArea)
        clickSpeedControl.addUnit(en.isHomeGameCenter2Task, en.homeGameCenter2Area)
        clickSpeedControl.addUnit(en.isShowCloseTask, en.showCloseArea)
        clickSpeedControl.addUnit(en.isFuLiUnSelectTask, en.fuLiUnSelectArea)



        while (flag && count > 0 && runSwitch) {
            if (!taskScreenV(screenshotIntervalF)) {
                return
            }
            if (en.isFuLiSelectTask.check()) {
                L.d("福利已经选中")
                flag = false
            } else {
                clickSpeedControl.cc()
            }
            count--
        }

        //执行到这里没有成功选中福利
        if (flag) {
            L.d("执行到这里没有成功选中福利")
            return
        }
        L.d("进入到福利中")
        flag = true
        count = 3
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenV(screenshotIntervalF)) {
                return
            }
            if (en.is3DiscountFastTask.check() && en.is3DiscountFastVTask.copyOffset(en.is3DiscountFastTask)
                    .check()
            ) {
                L.d("快速领取成功")
                en.is3DiscountFastArea.c(en.is3DiscountFastTask)
                delay(jumpClickInterval)
                result = true
                return
            }
            count--
        }



        L.d("寻找畅玩")
        flag = true
        count = 15
        val clickSpeedControl1 = ClickSpeedControl()
        clickSpeedControl1.addUnit(en.isChangWankaTask, en.changWankaArea)
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenV(screenshotIntervalF)) {
                return
            }
            if (en.isIsIntoVipTask.check()) {
                flag = false
            } else {
                clickSpeedControl1.cc()
            }
            count--
        }

        //执行到这里没有成功选中福利
        if (flag) {
            L.d("没有进入会员中心")
            return
        }
        L.d("进入会员中心")

        flag = true
        count = 20
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenV(screenshotIntervalF)) {
                return
            }
            if (en.isOnceDailyTask.check()
             //   && en.is3DiscountTask.copyOffset(en.isOnceDailyTask).check()
            ) {
                L.d("领取成功")
                en.is3DiscountArea.c(en.isOnceDailyTask)
                result = true
                delay(jumpClickInterval)
            } else {
                SimpleClickUtils.optClickTasks(acService, 0, 0, en.bottomToTopCenter)
            }
            count--
        }


    }
}