package com.android.schedule.corelibrary.controller.functions

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.click.SimpleClickUtils
import com.android.schedule.corelibrary.controller.ClickSpeedControl
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.xiaomi.XiaoMiEnvironment


class CollectVoucherExecuter(acService: AccessibilityService) : TurnBaseController(acService) {

    private var result = false

    val en = XiaoMiEnvironment
    suspend fun optCollectVoucher() {
        var flag = true
        var count = 20

        L.d("进入优惠卷领取")
        val clickSpeedControl = ClickSpeedControl()
        clickSpeedControl.addUnit(en.isHomeGameCenterTask, en.homeGameCenterArea)
        clickSpeedControl.addUnit(en.isShowCloseTask, en.showCloseArea)
        clickSpeedControl.addUnit(en.isFuLiUnSelectTask, en.fuLiUnSelectArea)

        while (flag && count > 0 && runSwitch) {
            if (!taskScreenV(screenshotInterval)) {
                L.d("屏幕尺寸不對")
                return
            }
            if (en.isFuLiSelectTask.check()) {
                flag = false
            } else {
                clickSpeedControl.cc()
            }
            count--
        }

        //执行到这里没有成功选中福利
        if (!flag) {
            L.d("执行到这里没有成功选中福利")
            return
        }

        flag = true
        count = 20
        val clickSpeedControl1 = ClickSpeedControl()
        clickSpeedControl.addUnit(en.isChangWankaTask, en.changWankaArea)
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
        if (!flag) {
            L.d("没有进入会员中心")
            return
        }

        flag = true
        count = 20
        clickSpeedControl.addUnit(en.isChangWankaTask, en.changWankaArea)
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenV(screenshotIntervalF)) {
                return
            }
            if (en.isOnceDailyTask.check() && en.is3DiscountTask.copyOffset(en.isOnceDailyTask)
                    .check()
            ) {
                en.is3DiscountArea.c(en.isOnceDailyTask)
                result = true
            } else {
                clickSpeedControl1.cc()
            }
            count--
        }


    }
}