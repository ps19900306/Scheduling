package com.android.system.calendar

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.view.accessibility.AccessibilityEvent
import com.android.schedule.corelibrary.utils.ContextUtil
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.TimeUtils
import com.android.system.calendar.constant.OperationalInterface
import com.android.system.calendar.excuter.MasterControl


class CalendarAccessibilityService : AccessibilityService(), OperationalInterface {

    var masterControl: MasterControl? = null
    companion object {
        var instance: OperationalInterface? = null
    }

    private val TAG = this::class.java.simpleName

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        L.i("onServiceConnected $TAG NWQ_ ${TimeUtils.getNowTime()}");
        ContextUtil.context = this
        instance = this
    }


    override fun onInterrupt() {
        L.i("onInterrupt $TAG NWQ_ ${TimeUtils.getNowTime()}");
    }

    override fun startAuto() {
        masterControl?.stop()
        masterControl = MasterControl(this)
        masterControl?.start()
    }

    override fun stopAuto() {
        masterControl?.stop()
    }


}