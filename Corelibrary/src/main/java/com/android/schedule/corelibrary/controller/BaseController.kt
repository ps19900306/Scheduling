package com.android.schedule.corelibrary.controller

import android.accessibilityservice.AccessibilityService
import android.graphics.Bitmap
import android.os.Build
import android.view.Display
import androidx.annotation.RequiresApi
import com.android.schedule.corelibrary.expand.isLandscape
import com.android.schedule.corelibrary.expand.isVertical
import kotlinx.coroutines.delay
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
create by: 86136
create time: 2023/8/28 10:06
Function description:
 */

abstract class BaseController(
    val acService: AccessibilityService,
    val onEnd: () -> Unit,
) {

    var screenBitmap: Bitmap? = null
    var runSwitch = true
    private val waitTaskTime = 5

    abstract fun start()


    abstract fun end()


    abstract fun onPause()


    abstract fun onResume()



    


    /***
     * 这一块是截图的核心逻辑
     */
    protected suspend fun takeScreen(delayTime: Long = 0): Bitmap {
        if (delayTime > 0) {
            delay(delayTime)
        }
        var bitmap: Bitmap? = null
        do {
            bitmap = takeScreenShot()
            if (bitmap == null) {
                delay(2000)
            }
        } while (bitmap == null)
        return bitmap
    }

    //获取横屏截图
    protected suspend fun taskScreenL(delayTime: Long = 0): Boolean {
        if (delayTime > 0) {
            delay(delayTime)
        }
        var bitmap: Bitmap? = null
        do {
            bitmap = takeScreenShot()
            if (bitmap == null) {
                delay(2000)
            }
        } while (bitmap == null)
        return bitmap.isLandscape()
    }

    //获取竖屏截图
    protected suspend fun taskScreenV(delayTime: Long = 0): Boolean {
        if (delayTime > 0) {
            delay(delayTime)
        }
        var bitmap: Bitmap? = null
        do {
            bitmap = takeScreenShot()
            if (bitmap == null) {
                delay(2000)
            }
        } while (bitmap == null)
        return bitmap.isVertical()
    }


    @RequiresApi(Build.VERSION_CODES.R)
    private suspend fun takeScreenShot(): Bitmap? = suspendCoroutine {
        screenBitmap?.recycle()
        screenBitmap = null
        //Timber.d("recycle takeScreen BaseController NWQ_ 2023/3/12");
        acService.takeScreenshot(Display.DEFAULT_DISPLAY,
            acService.mainExecutor,
            object : AccessibilityService.TakeScreenshotCallback {
                override fun onSuccess(screenshotResult: AccessibilityService.ScreenshotResult) {
                    val bitmap = Bitmap.wrapHardwareBuffer(
                        screenshotResult.hardwareBuffer, screenshotResult.colorSpace
                    )
                    screenBitmap = bitmap?.copy(Bitmap.Config.ARGB_8888, true)
                    bitmap?.recycle()
                    screenshotResult.hardwareBuffer.close()
                    it.resume(screenBitmap)

                }

                override fun onFailure(i: Int) {
                    it.resume(null)
                }
            })
    }
}