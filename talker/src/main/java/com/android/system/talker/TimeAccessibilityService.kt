package com.android.system.talker

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class TimeAccessibilityService: AccessibilityService() {

    private val TAG = this::class.java.simpleName


    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

    }

    override fun onInterrupt() {

    }

}