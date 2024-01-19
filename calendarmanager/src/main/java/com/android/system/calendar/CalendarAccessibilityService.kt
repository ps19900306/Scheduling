package com.android.system.calendar

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.view.accessibility.AccessibilityEvent
import com.android.schedule.corelibrary.utils.ContextUtil
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.TimeUtils


class CalendarAccessibilityService : AccessibilityService() {

    private val TAG = this::class.java.simpleName

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        L.i("onServiceConnected $TAG NWQ_ ${TimeUtils.getNowTime()}");
        ContextUtil.context = this
    }


    override fun onInterrupt() {
        L.i("onInterrupt $TAG NWQ_ ${TimeUtils.getNowTime()}");
    }




}