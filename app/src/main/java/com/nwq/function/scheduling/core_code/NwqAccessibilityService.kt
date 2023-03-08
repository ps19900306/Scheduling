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
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.fight.FightController
import com.nwq.function.scheduling.executer.test.ClickTestController
import com.nwq.function.scheduling.utils.ContextUtil
import com.nwq.function.scheduling.utils.log.L
import com.nwq.function.scheduling.utils.sp.SP


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
                startOpt()
                L.d("", "onReceive", "NwqAccessibilityService", "nwq", "2023/3/1");
            }
        }
    }

    fun startOpt() {
        FightController(AccessibilityHelper(this@NwqAccessibilityService)).startGame()
        //ClickTestController(AccessibilityHelper(this@NwqAccessibilityService)).startOperation()
    }


    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        // 获取包名
        val pkgName = event.packageName.toString();
        val eventType = event.eventType;
        Log.d(TAG, "pkgName: $pkgName   eventType: $eventType ");
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        L.d("", "onServiceConnected", "NwqAccessibilityService", "nwq", "2023/3/1");
        registerReceiver()
        ContextUtil.context = this
    }

    private fun registerReceiver() {
        L.i("registerReceiver", "registerReceiver", "NwqAccessibilityService", "nwq", "2023/3/1");
        registerReceiver(communicationBroadcast, IntentFilter.create("schedule.cmd", "cmd/int"))
    }


    override fun onInterrupt() {
        unregisterReceiver(communicationBroadcast)
        L.d("", "onInterrupt", "NwqAccessibilityService", "nwq", "2023/3/1");
    }


}