package com.nwq.function.corelib.click

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import com.nwq.function.corelib.click.task.ClickTask
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
create by: 86136
create time: 2023/5/5 10:38
Function description:
 */
object SimpleClickUtils {


    suspend fun optClickTasks(
        aService: AccessibilityService, vararg clickTask: ClickTask
    ): Boolean = suspendCoroutine {
        val builder = GestureDescription.Builder()
        clickTask.forEach { task ->
            val path = Path()
            task.coordinates.forEachIndexed { i, d ->
                if (i == 0) {
                    path.moveTo(d.x, d.y)
                } else {
                    path.lineTo(d.x, d.y)
                }
            }
            builder.addStroke(
                GestureDescription.StrokeDescription(
                    path, task.delayTime, task.duration
                )
            )
        }
        val gesture = builder.build()
        aService.dispatchGesture(
            gesture, object : AccessibilityService.GestureResultCallback() {
                override fun onCancelled(gestureDescription: GestureDescription) {
                    super.onCancelled(gestureDescription)
                    it.resume(false)
                }

                override fun onCompleted(gestureDescription: GestureDescription) {
                    super.onCompleted(gestureDescription)
                    it.resume(true)
                }
            }, null
        )
    }



}