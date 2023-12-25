package com.android.schedule.corelibrary.controller.functions

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.click.SimpleClickUtils
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.xiaomi.XiaoMiEnvironment

class awakenExecuter(acService: AccessibilityService) : TurnBaseController(acService) {

    private var result = false

    val en = XiaoMiEnvironment
    suspend fun optAwaken() {
        var flag = true
        var count = 12
        taskScreenV(screenshotInterval)
        if (en.isHomeGameCenterTask.check()) {
            result = true
            return
        }

        var number = 0
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenV(screenshotInterval)) {
                flag = false
            }
            if (en.isHomeGameCenterTask.check()) {
                flag = false
                result = true
            } else if (number <= 0) {
                SimpleClickUtils.optClickTasks(acService, 0, 0, en.bottomToTop)
                number = 4
            } else {
                number--
            }
            count--
        }
    }


}