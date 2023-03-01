package com.nwq.function.scheduling.executer.base

import android.graphics.Color
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.click.ClickTask
import com.nwq.function.scheduling.core_code.click.ClickUtils
import com.nwq.function.scheduling.core_code.click.DirectionType
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.utils.log.L
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
create by: 86136
create time: 2023/2/28 10:34
Function description:
这个是进行流程控制的，为了保证复用性，这里不放入任何图片和配置参数
 */

abstract class TravelController(val helper: AccessibilityHelper) {

    private val STANDARD_CLICK_INTERVAL = 2000

    protected val fastClickInterval
        get() = STANDARD_CLICK_INTERVAL * (Math.random() * 0.2 + 0.5)

    protected val normalClickInterval
        get() = STANDARD_CLICK_INTERVAL * (Math.random() * 0.4 + 0.8)

    protected val doubleClickInterval
        get() = STANDARD_CLICK_INTERVAL * (Math.random() * 0.6 + 2)

    fun startOperation() {
        GlobalScope.launch {
            L.d("", "startOperation", "TravelController", "nwq", "2023/3/1");
            helper.takeScreen()
            generalControlMethod()
        }
    }

    abstract suspend fun generalControlMethod()

    suspend fun pressBackBtn() {
        helper.pressBackBtn()
    }

    suspend fun pressHomeBtn() {
        helper.pressHomeBtn()
    }

    suspend fun saveScreen() {
        helper.saveScreen()
    }


    suspend fun getColor(x: Int, y: Int): Color? {
        return helper.screenBitmap?.getColor(x, y)
    }

    fun getBitmapWith(): Int {
        return helper.screenBitmap?.width ?: 0
    }

    fun getBitmapHeight(): Int {
        return helper.screenBitmap?.height ?: 0
    }

    suspend fun click(x: Float, y: Float, delayTime: Long = 0) {
        helper.click(x, y, delayTime)
    }

    suspend fun slide(x: Float, y: Float,  with: Int, height: Int, @DirectionType  direction: Int, delayTime: Long = 0) {
        helper.slide(x, y, with,height,direction,delayTime)
    }
}