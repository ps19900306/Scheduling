package com.android.schedule.corelibrary.controller

import android.accessibilityservice.AccessibilityService
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.PixelFormat
import android.hardware.display.VirtualDisplay
import android.media.Image
import android.media.ImageReader
import android.media.projection.MediaProjection
import android.os.Build
import android.util.Log
import android.view.Display
import androidx.annotation.RequiresApi
import com.android.schedule.corelibrary.expand.isLandscape
import com.android.schedule.corelibrary.expand.isVertical
import com.android.schedule.corelibrary.img.img_rule.BasicImgTask
import com.android.schedule.corelibrary.img.img_rule.ImgTask
import com.android.schedule.corelibrary.img.img_rule.ImgTaskImpl1
import com.android.schedule.corelibrary.img.img_rule.MultiFindImgTask
import com.android.schedule.corelibrary.img.img_rule.MultiImgContainmentTask
import com.android.schedule.corelibrary.utils.L
import kotlinx.coroutines.delay
import java.nio.ByteBuffer
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


/**
create by: 86136
create time: 2023/8/28 10:06
Function description:
 */

abstract class BaseController(
    val acService: AccessibilityService,
) {

    var screenBitmap: Bitmap? = null
    var runSwitch = true
    private val waitTaskTime = 5
    private val takeScreenIn = 4000L

    protected val repeatedClickInterval = 8000L

    abstract fun start()


    abstract suspend fun end()


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
                delay(takeScreenIn)
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
                delay(takeScreenIn)
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
                delay(4000)
            }
        } while (bitmap == null)
        return bitmap.isVertical()
    }


    private suspend fun takeScreenShot(): Bitmap? = suspendCoroutine {
        screenBitmap?.recycle()
        screenBitmap = null
        //Timber.d("recycle takeScreen BaseController NWQ_ 2023/3/12");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
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
        } else {
            screenBitmap = takeScreenShotOld()
            it.resume(screenBitmap)
        }
    }

    suspend fun BasicImgTask.check(): Boolean {
        return this.verificationRule(screenBitmap)
    }

    suspend fun ImgTaskImpl1.check(other: BasicImgTask): Boolean {
        return this.copyOffset(other).verificationRule(screenBitmap)
    }

    fun pressBackBtn() {
        acService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK)
    }

    fun pressHomeBtn() {
        acService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME)
    }

    fun ImgTask.toStatusRecorder(
        trustThresholds: Int = 3,
        errorThreshold: Int = trustThresholds * 3
    ): StatusRecorder {
        return StatusRecorder(this.tag, trustThresholds, errorThreshold) {
            this.verificationRule(screenBitmap)
        }
    }


    fun MultiImgContainmentTask.toStatusRecorder(
        trustThresholds: Int = 3,
        errorThreshold: Int = trustThresholds * 3
    ): StatusRecorder {
        return StatusRecorder(
            this.list?.get(0)?.tag ?: "multiImgUnkown",
            trustThresholds,
            errorThreshold
        ) {
            this.verificationRule(screenBitmap)
        }
    }


    suspend fun MultiFindImgTask.toStatusRecorder(
        trustThresholds: Int = 3,
        errorThreshold: Int = trustThresholds * 3
    ): StatusRecorder {
        return StatusRecorder(this.list[0].tag, trustThresholds, errorThreshold) {
            this.verificationRule(screenBitmap)
        }
    }

    suspend fun updateStatusRecorder(vararg datas: StatusRecorder) {
        datas.forEach {
            it.updateInfo()
        }
    }


    private fun takeScreenShotOld(): Bitmap? {
        var bitmap: Bitmap? = null
        ImageTakeUtils.acquireNextImage()?.let { image ->
            if (image == null) {
                //L.t("img为空")
            } else {
                //L.t("获取到最新图片")
                val buffer: ByteBuffer = image.planes[0].getBuffer()
                val width = image.width
                val height = image.height
                L.t("whh0914 image width=$width, height=$height")
                val pixelStride: Int = image.planes[0].pixelStride
                val rowStride: Int = image.planes[0].rowStride
                val rowPadding = rowStride - pixelStride * width
                var bitmap = Bitmap.createBitmap(
                    width + rowPadding / pixelStride,
                    height,
                    Bitmap.Config.ARGB_8888
                )
                bitmap!!.copyPixelsFromBuffer(buffer)
                bitmap = Bitmap.createScaledBitmap(bitmap!!, bitmap!!.width, bitmap!!.height, false)
                if (bitmap != null) {
                    //L.t( "屏幕截图成功!")
                    return bitmap
                } else {
                    //L.t( "屏幕截图失败!")
                }
                image.close()
            }
        }
        return bitmap
    }
}