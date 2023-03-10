package com.nwq.function.scheduling.executer.base

import android.graphics.Bitmap
import android.graphics.Color
import com.nwq.function.scheduling.core_code.Area
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
    var runSwitch = true
    protected val fastClickInterval
        get() = STANDARD_CLICK_INTERVAL * (Math.random() * 0.2 + 0.5).toLong()

    protected val normalClickInterval
        get() = STANDARD_CLICK_INTERVAL * (Math.random() * 0.4 + 0.8).toLong()

    protected val doubleClickInterval
        get() = STANDARD_CLICK_INTERVAL * (Math.random() * 0.6 + 1.8).toLong()

    protected val tripleClickInterval
        get() = STANDARD_CLICK_INTERVAL * (Math.random() * 0.8 + 2.6).toLong()

    protected val quadrupleClickInterval
        get() = STANDARD_CLICK_INTERVAL * (Math.random() * 1 + 3.4).toLong()

    protected val screenBitmap
        get() = helper.screenBitmap!!

    fun close() {
        runSwitch = false
    }

    fun startOperation() {
        GlobalScope.launch {
            L.d("", "startOperation", "TravelController", "nwq", "2023/3/1");
            helper.takeScreen()
            generalControlMethod()
        }
    }

    abstract suspend fun generalControlMethod()

    fun pressBackBtn() {
        helper.pressBackBtn()
    }

    fun pressHomeBtn() {
        helper.pressHomeBtn()
    }

    fun saveScreen() {
        helper.saveScreen()
    }

    //如果截图失败则等待二秒后继续截图
    suspend fun takeScreen(delayTime: Long) {
        if (delayTime > 0) {
            delay(delayTime)
        }
        takeScreen()
    }

    //如果截图失败则等待二秒后继续截图
    suspend fun takeScreen() {
        var bitmap: Bitmap? = null
        do {
            bitmap = helper.takeScreen()
            if (bitmap == null) {
                delay(2000)
            }
        } while (bitmap == null)
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

    suspend fun click(area: Area) {
        helper.click(area.coordinate)
    }

    suspend fun click(area: Area, delayTime: Long = 0) {
        area.coordinate.let {
            helper.click(x = it.x, y = it.y, delayTime = delayTime)
        }
    }

    suspend fun click(x: Float, y: Float, delayTime: Long = 0) {
        helper.click(x, y, delayTime)
    }

    suspend fun click(x: Float, y: Float, with: Int, height: Int) {
        helper.click(x, y, with, height)
    }

    suspend fun slide(
        x: Float,
        y: Float,
        with: Int,
        height: Int,
        @DirectionType direction: Int,
        delayTime: Long = 0
    ) {
        helper.slide(x, y, with, height, direction, delayTime)
    }
}