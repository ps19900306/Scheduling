package com.android.schedule.corelibrary.controller

import android.accessibilityservice.AccessibilityService

/**
create by: 86136
create time: 2023/8/28 17:22
Function description:
 这个是即时的
 */

class ImmediateBaseController(acService: AccessibilityService,
                              onEnd: () -> Unit,):BaseController(acService,onEnd) {



    override fun start() {

    }

    override fun end() {

    }

    override fun onPause() {

    }

    override fun onResume() {

    }
}