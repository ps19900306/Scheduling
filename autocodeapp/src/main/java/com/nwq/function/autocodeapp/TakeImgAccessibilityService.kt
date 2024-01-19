package com.nwq.function.autocodeapp

import android.accessibilityservice.AccessibilityService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import android.view.Display
import android.view.accessibility.AccessibilityEvent
import androidx.annotation.RequiresApi
import com.android.schedule.corelibrary.controller.ImageTakeUtils
import com.android.schedule.corelibrary.xiaomi.CollectVoucherExecuter
import com.android.schedule.corelibrary.utils.ContextUtil
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.NwqCallBack
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.nio.ByteBuffer


class TakeImgAccessibilityService : AccessibilityService() {


    private val TAG = "TakeImgAccessibilityService"

    var screenBitmap: Bitmap? = null



    private val communicationBroadcast by lazy {
        object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                intent?.let { dealEvent(it) }
            }
        }
    }


    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

    }


    val takeIMG = NwqCallBack<Boolean> { //收到截图操作
        takeImgSend()
    }


    val optFunctions = NwqCallBack<Boolean> { //收到截图操作
        testFunction()
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        ContextUtil.context = this
        L.t("设置截图")
        ImgOpt.takeBitmap = takeIMG
        ImgOpt.optFunction = optFunctions

    }

    override fun onInterrupt() {
        unregisterReceiver(communicationBroadcast)

    }

    fun dealEvent(intent: Intent) {

    }

    fun testFunction(){
        GlobalScope.launch {
            delay(6000)
            CollectVoucherExecuter(this@TakeImgAccessibilityService).optCollectVoucher()
        }
    }


    fun takeImgSend() {
        GlobalScope.launch {
            delay(5000)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

                takeScreenshot(
                    Display.DEFAULT_DISPLAY,
                    mainExecutor,
                    object : AccessibilityService.TakeScreenshotCallback {
                        override fun onSuccess(screenshotResult: AccessibilityService.ScreenshotResult) {
                            val bitmap = Bitmap.wrapHardwareBuffer(
                                screenshotResult.hardwareBuffer, screenshotResult.colorSpace
                            )
                            screenBitmap = bitmap?.copy(Bitmap.Config.ARGB_8888, true)
                            bitmap?.recycle()
                            screenshotResult.hardwareBuffer.close()

                            ImgOpt.getbitmap?.onCallBack(screenBitmap)
                        }

                        override fun onFailure(i: Int) {
                        }
                    })
            }else{
                screenBitmap=takeScreenShotOld()
                ImgOpt.getbitmap?.onCallBack(screenBitmap)
            }
        }
    }

    override fun bindService(service: Intent?, conn: ServiceConnection, flags: Int): Boolean {
        return super.bindService(service, conn, flags)
    }

    private suspend fun takeScreenShotOld(): Bitmap? {
        var bitmap: Bitmap? = null
        delay(100)
        ImageTakeUtils.acquireNextImage()?.let { image ->
            if(image==null){
                L.t("img为空")
            }else{
                L.t("获取到最新图片")
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
                    screenBitmap = bitmap?.copy(Bitmap.Config.ARGB_8888, true)
                    bitmap.recycle()
                    return screenBitmap
                }else{
                    L.t( "屏幕截图失败!")
                }
            }
            image.close()
        }
        return bitmap
    }



    fun pressBackBtn() {
        performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK)
    }


    fun pressHomeBtn() {
        performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME)
    }
}