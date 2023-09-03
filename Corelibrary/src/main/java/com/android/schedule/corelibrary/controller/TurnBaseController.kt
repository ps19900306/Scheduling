package com.android.schedule.corelibrary.controller

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.click.SimpleClickUtils
import com.android.schedule.corelibrary.exhaustion.ExhaustionControl

/**
create by: 86136
create time: 2023/8/28 10:06
Function description:
 */

abstract class TurnBaseController(
    acService: AccessibilityService,
    onEnd: () -> Unit,
) : BaseController(acService, onEnd) {


    override fun start() {

    }

    override fun end() {

    }

    override fun onPause() {

    }

    override fun onResume() {

    }

    protected suspend fun click(clickArea: ClickArea, offsetX: Int = 0, offsetY: Int = 0) {
        SimpleClickUtils.optClickTasks(acService, 0, 0,clickArea.toClickTask())
    }

    protected suspend fun click(
        listArea: List<ClickArea>?,
        offsetX: Int = 0,
        offsetY: Int = 0,
        canMiss: Boolean = false,
    ) {
        if (listArea.isNullOrEmpty()) return
        val list =
            ExhaustionControl.areaToClickTask(listArea, offsetX, offsetY, canMiss).toTypedArray()
        SimpleClickUtils.optClickTasks(acService, 0, 0, *list)
    }


}
