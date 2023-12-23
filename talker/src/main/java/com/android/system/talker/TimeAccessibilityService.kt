package com.android.system.talker

import android.accessibilityservice.AccessibilityService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.view.accessibility.AccessibilityEvent
import com.android.schedule.corelibrary.utils.ContextUtil
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.TimeUtils
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.excuter.MasterControl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TimeAccessibilityService : AccessibilityService() {

    private val TAG = this::class.java.simpleName

    var masterControl: MasterControl? = null

    companion object {
        const val Intent_Filter_TAG = "schedule.cmd.v3"
        const val CMD = "cmd"
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

    override fun onServiceConnected() {
        super.onServiceConnected()
        L.i("onServiceConnected $TAG NWQ_ ${TimeUtils.getNowTime()}");
        registerReceiver(communicationBroadcast, IntentFilter.create(Intent_Filter_TAG, "cmd/int"))
        ContextUtil.context = this
    }

    override fun onInterrupt() {
        unregisterReceiver(communicationBroadcast)
        L.i("onInterrupt $TAG NWQ_ ${TimeUtils.getNowTime()}");
    }

    fun dealEvent(intent: Intent) {
        val cmd = intent.getIntExtra(CMD, CmdType.START)
        when (cmd) {
            CmdType.START -> {
                GlobalScope.launch {
                    masterControl?.end()
                    masterControl = MasterControl(
                        AppDataBase.getInstance(this@TimeAccessibilityService.applicationContext),
                        this@TimeAccessibilityService
                    )
                    masterControl?.start()
                }
            }

            CmdType.CLOSE -> {
                GlobalScope.launch {
                    masterControl?.end()
                    masterControl = null
                }
            }
        }
    }


}