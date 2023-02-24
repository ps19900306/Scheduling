package com.nwq.function.scheduling.core_code.click

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path


/**
create by: 86136
create time: 2023/2/24 15:58
Function description:
 */

object ClickUtils {
    fun click(accessibilityService: AccessibilityService, x: Float, y: Float) {

        val builder = GestureDescription.Builder()
        val path = Path()
        path.moveTo(x, y)
        path.lineTo(x+100,y+100)
        builder.addStroke(GestureDescription.StrokeDescription(path, 2000, 500))
        builder.addStroke(GestureDescription.StrokeDescription(path, 5000, 500))
        val gesture = builder.build()
        accessibilityService.dispatchGesture(gesture, object : AccessibilityService.GestureResultCallback() {
            override fun onCancelled(gestureDescription: GestureDescription) {
                super.onCancelled(gestureDescription)
            }

            override fun onCompleted(gestureDescription: GestureDescription) {
                super.onCompleted(gestureDescription)
            }
        }, null)
    }
}