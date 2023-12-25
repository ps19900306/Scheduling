package com.nwq.function.autocodeapp

import android.accessibilityservice.AccessibilityService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.Bitmap
import android.os.Build
import android.view.Display
import android.view.accessibility.AccessibilityEvent
import androidx.annotation.RequiresApi
import com.android.schedule.corelibrary.utils.ContextUtil
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.NwqCallBack
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class TakeImgAccessibilityService : AccessibilityService() {


    private val TAG = "TakeImgAccessibilityService"

    var screenBitmap: Bitmap? = null



    private val _bind = object : GetMyImg.Stub() {
        override fun optIntentBitmap() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                takeImgSend()
            }
        }

        override fun getIntentBitmap(): Bitmap {
            return screenBitmap!!
        }
    }


    private val communicationBroadcast by lazy {
        object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                intent?.let { dealEvent(it) }
            }
        }
    }


    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

    }

   @RequiresApi(Build.VERSION_CODES.R)
   val takeIMG = NwqCallBack<Boolean> { //收到截图操作
       takeImgSend()
   }

    override fun onServiceConnected() {
        super.onServiceConnected()
        ContextUtil.context = this
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            L.d("设置截图")
            ImgOpt.takeBitmap = takeIMG
        }
    }

    override fun onInterrupt() {
        unregisterReceiver(communicationBroadcast)

    }

    fun dealEvent(intent: Intent) {

    }

    @RequiresApi(Build.VERSION_CODES.R)
    fun takeImgSend() {
        GlobalScope.launch {
            delay(10000)

         //   CollectVoucherExecuter(this@TakeImgAccessibilityService).optCollectVoucher()


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
        }


    }

    override fun bindService(service: Intent?, conn: ServiceConnection, flags: Int): Boolean {
        return super.bindService(service, conn, flags)

    }

    override fun unbindService(conn: ServiceConnection) {
        super.unbindService(conn)
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
    }

    fun pressBackBtn() {
        performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK)
    }



    fun pressHomeBtn() {
        performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME)
    }
}