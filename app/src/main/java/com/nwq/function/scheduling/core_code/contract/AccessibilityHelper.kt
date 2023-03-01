package com.nwq.function.scheduling.core_code.contract

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityService.*
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Environment
import android.view.Display
import androidx.annotation.RequiresApi
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.click.ClickTask
import com.nwq.function.scheduling.core_code.click.ClickUtils
import com.nwq.function.scheduling.core_code.click.DirectionType
import com.nwq.function.scheduling.core_code.click.SlideScreenTask
import com.nwq.function.scheduling.utils.log.L
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class AccessibilityHelper(val acService: AccessibilityService) {

    var screenBitmap: Bitmap? = null

    //这里跟新截图信息
    @RequiresApi(Build.VERSION_CODES.R)
    suspend fun takeScreen(): Bitmap? = suspendCoroutine {
        screenBitmap?.recycle()
        screenBitmap = null
        L.i("recycle", "takeScreen", "AccessibilityHelper", "nwq", "2023/3/1");
        acService.takeScreenshot(Display.DEFAULT_DISPLAY,
            acService.mainExecutor,
            object : AccessibilityService.TakeScreenshotCallback {
                override fun onSuccess(screenshotResult: AccessibilityService.ScreenshotResult) {
                    val bitmap = Bitmap.wrapHardwareBuffer(
                        screenshotResult.hardwareBuffer, screenshotResult.colorSpace
                    )
                    screenBitmap= bitmap?.copy( Bitmap.Config.RGB_565,true)
                    bitmap?.recycle()
                    L.i("setScreenBitmap", "takeScreen", "AccessibilityHelper", "nwq", "2023/3/1");
                    it.resume(screenBitmap)
                }

                override fun onFailure(i: Int) {
                    L.i("", "onFailure", "AccessibilityHelper", "nwq", "2023/3/1");
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

    suspend fun click(x: Float, y: Float, delayTime: Long = 0) {
        val coordinate = Coordinate(x, y)
        val task = ClickTask(listOf(coordinate),delayTime, ((Math.random() + 0.5) * 300).toLong())
        ClickUtils.optClickTasks(acService, task)
    }

    suspend fun slide(x: Float, y: Float, with: Int, height: Int, @DirectionType direction: Int, delayTime: Long = 0) {
        val task = SlideScreenTask(x,y,with,height,direction,delayTime)
        ClickUtils.optSlideTask(acService, task)
    }
}