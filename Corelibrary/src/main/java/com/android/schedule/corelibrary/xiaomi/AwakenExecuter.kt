package com.android.schedule.corelibrary.xiaomi

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.click.SimpleClickUtils
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.utils.L

class AwakenExecuter(acService: AccessibilityService) : TurnBaseController(acService) {

    var result = false

    val en = XiaoMiEnvironment
    suspend fun optAwaken() {
        L.d("执行唤醒操作")
        var flag = true
        var count = 12
        taskScreenV(screenshotInterval)
        if (en.isHomeGameCenterTask.check() || en.isHomeGameCenter2Task.check()) {
            result = true
            return
        }

        var number = 0
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenV(screenshotInterval)) {
                flag = false
            }
            if (en.isHomeGameCenterTask.check() || en.isHomeGameCenter2Task.check()) {
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