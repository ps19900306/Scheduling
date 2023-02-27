package com.nwq.function.scheduling.core_code.contract

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.view.Display
import androidx.annotation.RequiresApi
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@RequiresApi(Build.VERSION_CODES.R)
class AccessibilityHelper(val acService: AccessibilityService, val context: Context) {

    var screenBitmap: Bitmap? = null

    //这里跟新截图信息
    suspend fun takeScreen(): Bitmap? = suspendCoroutine {
        screenBitmap?.recycle()
        screenBitmap = null
        acService.takeScreenshot(Display.DEFAULT_DISPLAY,
            context.mainExecutor,
            object : AccessibilityService.TakeScreenshotCallback {
                override fun onSuccess(screenshotResult: AccessibilityService.ScreenshotResult) {
                    val bitmap = Bitmap.wrapHardwareBuffer(
                        screenshotResult.hardwareBuffer, screenshotResult.colorSpace
                    )
                    screenBitmap = bitmap
                    it.resume(screenBitmap)
                }

                override fun onFailure(i: Int) {
                    it.resume(null)
                }
            })
    }




}