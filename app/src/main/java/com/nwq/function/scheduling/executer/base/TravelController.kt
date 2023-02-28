package com.nwq.function.scheduling.executer.base

import android.accessibilityservice.AccessibilityService
import androidx.annotation.RestrictTo
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
create by: 86136
create time: 2023/2/28 10:34
Function description:
这个是进行流程控制的，为了保证复用性，这里不放入任何图片和配置参数
 */

abstract class TravelController(val helper: AccessibilityHelper)
{

    private val STANDARD_CLICK_INTERVAL = 2000

    protected val fastClickInterval
        get() = STANDARD_CLICK_INTERVAL * (Math.random() * 0.2 + 0.5)

    protected val normalClickInterval
        get() = STANDARD_CLICK_INTERVAL * (Math.random() * 0.4 + 0.8)

    protected val doubleClickInterval
        get() = STANDARD_CLICK_INTERVAL * (Math.random() * 0.6 + 2)



    abstract fun generalControlMethod()

    suspend fun pressBackBtn(){
        helper.pressBackBtn()
    }

    suspend fun pressHomeBtn(){
        helper.pressHomeBtn()
    }

    suspend fun delay234(){
        delay(2000)
    }

}