package com.nwq.function.scheduling.core_code.click

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import com.nwq.function.scheduling.utils.log.L
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


/**
create by: 86136
create time: 2023/2/24 15:58
Function description:
 */

object ClickUtils {


    suspend fun optSlideTask(aService: AccessibilityService, slideScreenTask: SlideScreenTask) {
        optClickTasks(aService, slideScreenTask.convertToClick())
    }

    suspend fun optClickTasks(
        aService: AccessibilityService, vararg clickTask: ClickTask
    ): Boolean = suspendCoroutine {
        val builder = GestureDescription.Builder()
        var timeStemp = 0L
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
                    path, task.delayTime + timeStemp, task.duration
                )
            )
            timeStemp += task.delayTime + task.duration
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