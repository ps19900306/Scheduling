package com.android.system.talker

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.excuter.MasterControl

class TimeAccessibilityService : AccessibilityService() {

    private val TAG = this::class.java.simpleName


    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        val excuter = MasterControl(
            AppDataBase.getInstance(this@TimeAccessibilityService),
            this@TimeAccessibilityService
        )

    }

    override fun onInterrupt() {

    }

}