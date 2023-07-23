package com.nwq.function.corelib

import android.accessibilityservice.AccessibilityService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.view.accessibility.AccessibilityEvent
import com.nwq.function.corelib.excuter.BaseController
import com.nwq.function.corelib.excuter.star_wars.AdventureTaskController
import com.nwq.function.corelib.excuter.star_wars.GetColorController
import com.nwq.function.corelib.excuter.star_wars.InterstellarMiners
import com.nwq.function.corelib.utils.ContextUtil
import timber.log.Timber


/**
create by: 86136
create time: 2023/2/24 13:33
Function description:
 */

class NwqAccessibilityService : AccessibilityService() {

    private val TAG = "NwqAccessibilityService"
    private val cList = mutableListOf<BaseController>()

    companion object {
        const val Intent_Filter_TAG = "schedule.cmd.v2"
    }


    private val communicationBroadcast by lazy {
        object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                intent?.let { dealEvent(it) }
            }
        }
    }



    private val onCompleteLister = {

    }


    private fun startOpt(outGame: Boolean = false) {
        Timber.d("启动脚本 GetColorController NWQ_ 2023/3/12");
        val interstellarMiners=  AdventureTaskController(this)

        interstellarMiners.startWork()
        cList.add(interstellarMiners)
    }


    fun dealEvent(intent: Intent) {
        startOpt()
    }


    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        // 获取包名

    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        Timber.d("onServiceConnected NwqAccessibilityService NWQ_ 2023/3/12");
        registerReceiver()
        ContextUtil.context = this
    }

    private fun registerReceiver() {
        Timber.d("registerReceiver NwqAccessibilityService NWQ_ 2023/3/12");
        registerReceiver(communicationBroadcast, IntentFilter.create(Intent_Filter_TAG, "cmd/int"))
    }


    override fun onInterrupt() {
        unregisterReceiver(communicationBroadcast)
        Timber.d("onInterrupt NwqAccessibilityService NWQ_ 2023/3/12");
    }


}