package com.nwq.function.scheduling.core_code.contract

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityService.*
import android.graphics.Bitmap
import android.os.Build
import android.view.Display
import androidx.annotation.RequiresApi
import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.click.ClickTask
import com.nwq.function.scheduling.core_code.click.ClickUtils
import com.nwq.function.scheduling.core_code.click.DirectionType
import com.nwq.function.scheduling.core_code.click.SlideScreenTask
import timber.log.Timber
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class AccessibilityHelper(val acService: AccessibilityService) {

    var screenBitmap: Bitmap? = null
    val defultClickDuration
        get() = ((Math.random() * 0.5 + 0.5) * 300).toLong()
    val defultClickDurationMeath
        get() = { ((Math.random() * 0.5 + 0.5) * 300).toLong() }

    //这里跟新截图信息
    @RequiresApi(Build.VERSION_CODES.R)
    suspend fun takeScreen(): Bitmap? = suspendCoroutine {
        screenBitmap?.recycle()
        screenBitmap = null
        Timber.d("recycle takeScreen AccessibilityHelper NWQ_ 2023/3/12");
        acService.takeScreenshot(Display.DEFAULT_DISPLAY,
            acService.mainExecutor,
            object : AccessibilityService.TakeScreenshotCallback {
                override fun onSuccess(screenshotResult: AccessibilityService.ScreenshotResult) {
                    val bitmap = Bitmap.wrapHardwareBuffer(
                        screenshotResult.hardwareBuffer, screenshotResult.colorSpace
                    )
                    screenBitmap = bitmap?.copy(Bitmap.Config.RGBA_F16, true)
                    bitmap?.recycle()
                    //screenBitmap?.let { it1 -> FileUtils.saveImage29(it1,acService) }
                    Timber.d("setScreenBitmap onSuccess AccessibilityHelper NWQ_ 2023/3/12");
                    it.resume(screenBitmap)
                }

                override fun onFailure(i: Int) {
                    Timber.d("  onFailure AccessibilityHelper NWQ_ 2023/3/12");
                    it.resume(null)
                }
            })
    }


    fun pressBackBtn() {
        acService.performGlobalAction(GLOBAL_ACTION_BACK)
    }

    fun pressHomeBtn() {
        acService.performGlobalAction(GLOBAL_ACTION_HOME)
    }

    fun saveScreen() {
        acService.performGlobalAction(GLOBAL_ACTION_TAKE_SCREENSHOT)
    }

    suspend fun click(
        coordinate: Coordinate, duration: Long = defultClickDuration
    ) {
        ClickUtils.optClickTasks(acService, ClickTask(listOf(coordinate), 0, duration))
    }


    suspend fun click(x: Float, y: Float, duration: Long = ((Math.random() + 0.5) * 300).toLong()) {
        click(x, y, duration, 0)
    }

    suspend fun click(x: Float, y: Float, with: Int, height: Int) {
        click(x, y, with, height, defultClickDuration)
    }


    suspend fun click(x: Float, y: Float, with: Int, height: Int, duration: Long) {
        val newX = (x + (Math.random() * 0.6 + 0.2) * with).toFloat()
        val newY = (y + (Math.random() * 0.6 + 0.2) * height).toFloat()
        click(newX, newY, duration, 0)
    }

    suspend fun click(x: Float, y: Float, duration: Long = defultClickDuration, delayTime: Long) {
        val coordinate = Coordinate(x, y)
        val task = ClickTask(listOf(coordinate), delayTime, duration)
        ClickUtils.optClickTasks(acService, task)
    }

    suspend fun click(area: List<Area>, delayTime: () -> Long = defultClickDurationMeath) {
        val list = area.map {
            ClickTask(listOf(it.coordinate), delayTime.invoke(), defultClickDuration)
        }
        ClickUtils.optClickTasks(acService, *list.toTypedArray())
    }


    suspend fun slide(
        x: Float,
        y: Float,
        endX: Float,
        endY: Float,
        duration: Long,
    ) {
        slide(x, y, endX, endY, duration, 0)
    }

    suspend fun slide(
        x: Float, y: Float, endX: Float, endY: Float, duration: Long, delayTime: Long = 0
    ) {
        val coordinate = Coordinate(x, y)
        val coordinate1 = Coordinate(endX, endY)
        val task = ClickTask(listOf(coordinate, coordinate1), delayTime, duration)
        ClickUtils.optClickTasks(acService, task)
    }


    suspend fun slide(
        x: Float,
        y: Float,
        with: Int,
        height: Int,
        @DirectionType direction: Int,
        delayTime: Long = 0
    ) {
        val task = SlideScreenTask(x, y, with, height, direction, delayTime)
        ClickUtils.optSlideTask(acService, task)
    }

    suspend fun slideByLocation(
        startX: Double,
        startY: Double,
        endX: Double,
        endY: Double,
        duration: Long,
        delayTime: Long = 0
    ) {
        val startCoordinate = Coordinate(startX.toFloat(), startY.toFloat())
        val endCoordinate = Coordinate(endX.toFloat(), endY.toFloat())
        val task = ClickTask(listOf(startCoordinate, endCoordinate), delayTime, duration)
        ClickUtils.optClickTasks(acService, task)
    }

    suspend fun slideByLocationMidpoint(
        startX: Double,
        startY: Double,
        endX: Double,
        endY: Double,
        duration: Long,
        delayTime: Long = 0,
        midpointCount: Int = (Math.random() * 4).toInt()
    ) {
        val list = mutableListOf<Coordinate>()
        val startCoordinate = Coordinate(startX.toFloat(), startY.toFloat())
        list.add(startCoordinate)
        if (midpointCount > 0) {
            val xLength = endX - startX
            val yLength = startY - endY
            val xPercent = xLength / (midpointCount + 2)
            val yPercent = yLength / (midpointCount + 2)
            for (i in 0..midpointCount) {
                val midX = xPercent * (i + 1) * (1 + Math.random() * 0.1)
                val midY = yPercent * (i + 1) * (1 + Math.random() * 0.1)
                list.add(Coordinate(midX.toFloat(), midY.toFloat()))
            }
        }
        val endCoordinate = Coordinate(endX.toFloat(), endY.toFloat())
        list.add(endCoordinate)
        val task = ClickTask(listOf(startCoordinate, endCoordinate), delayTime, duration)
        ClickUtils.optClickTasks(acService, task)
    }


}