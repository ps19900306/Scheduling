package com.nwq.function.scheduling.executer.base

import android.graphics.Bitmap
import android.graphics.Color
import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.core_code.SwipeArea
import com.nwq.function.scheduling.core_code.click.DirectionType
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.utils.JsonUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

/**
create by: 86136
create time: 2023/2/28 10:34
Function description:
这个是进行流程控制的，为了保证复用性，这里不放入任何图片和配置参数

Todo 高级任务的判定需要修改
卸载游戏需要修改
 */

abstract class TravelController(val helper: AccessibilityHelper, val onComplete: () -> Boolean) {

    private val STANDARD_CLICK_INTERVAL = 2000
    var runSwitch = true
    protected val fastClickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.2 + 0.5)).toLong()

    protected val normalClickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.4 + 0.8)).toLong()

    protected val doubleClickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.6 + 1.8)).toLong()

    protected val tripleClickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.8 + 2.6)).toLong()

    protected val quadrupleClickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 1 + 3.4)).toLong()

    protected val screenBitmap
        get() = helper.screenBitmap!!

    fun close() {
        runSwitch = false
    }

    fun startOperation() {
        GlobalScope.launch {
            Timber.d("  startOperation TravelController NWQ_ 2023/3/12");
            println("Thread : ${Thread.currentThread().name}")
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
    suspend fun takeScreen(delayTime: Long): Boolean {
        if (delayTime > 0) {
            delay(delayTime)
        }
        return takeScreen()
    }

    //如果截图失败则等待二秒后继续截图
    suspend fun takeScreen(): Boolean {
        var bitmap: Bitmap? = null
        do {
            bitmap = helper.takeScreen()
            if (bitmap == null) {
                delay(2000)
            }
        } while (bitmap == null)
        return bitmap.width > bitmap.height
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

    suspend fun click(area: List<Area>) {
        helper.click(area)
    }


    suspend fun click(x: Float, y: Float, duration: Long = ((Math.random() + 0.5) * 300).toLong()) {
        helper.click(x, y, duration)
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

    suspend fun slide(
        x: Int,
        y: Int,
        with: Int,
        height: Int,
        @DirectionType direction: Int,
        delayTime: Long = 0
    ) {
        helper.slide(x.toFloat(), y.toFloat(), with, height, direction, delayTime)
    }


    suspend fun swipe(
        swipeArea: SwipeArea,
        midPoint: Int = 0
    ) {
        val task = swipeArea.toClickTask(0)
        Timber.d("${JsonUtil.objectToString(task)} swipe TravelController NWQ_ 2023/3/14");
        helper.swipe(task)
    }


}