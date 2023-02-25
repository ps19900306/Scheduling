package com.nwq.function.scheduling.core_code

import android.accessibilityservice.AccessibilityService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.os.Build
import android.util.Log
import android.view.Display
import android.view.accessibility.AccessibilityEvent
import androidx.annotation.RequiresApi
import com.nwq.function.scheduling.core_code.click.ClickUtils


/**
create by: 86136
create time: 2023/2/24 13:33
Function description:
 */

class NwqAccessibilityService : AccessibilityService() {

    private val TAG = "NwqAccessibilityService"
    private val communicationBroadcast by lazy {
        object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                test()
            }
        }
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        // 获取包名
        val pkgName = event.packageName.toString();
        val eventType = event.eventType;
        Log.d(TAG, "pkgName: $pkgName   eventType: $eventType ");
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        registerReceiver()
    }


    private fun registerReceiver() {
        Log.d(TAG, "registerReceiver");
        registerReceiver(communicationBroadcast, IntentFilter.create("schedule.cmd", "cmd/int"))
    }


    private fun test() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            takeScreenshot(Display.DEFAULT_DISPLAY,
                applicationContext.mainExecutor, object : TakeScreenshotCallback {
                    @RequiresApi(api = Build.VERSION_CODES.R)
                    override fun onSuccess(screenshotResult: ScreenshotResult) {
                        val bitmap = Bitmap.wrapHardwareBuffer(
                            screenshotResult.hardwareBuffer,
                            screenshotResult.colorSpace
                        )

                        Log.d(TAG, "进行一 次截图 width: ${bitmap?.width}  height: ${bitmap?.height} ");
                        bitmap?.recycle()
                        ClickUtils.click(this@NwqAccessibilityService, 540F, 1200F)
                    }

                    override fun onFailure(i: Int) {
                        Log.i(TAG, "onFailure code is $i")
                    }
                })
        }
    }

    private fun clickss() {
        getRootInActiveWindow()
    }


    override fun onInterrupt() {
        unregisterReceiver(communicationBroadcast)
        Log.d(TAG, "onAccessibilityEvent: onInterrupt");
    }


}