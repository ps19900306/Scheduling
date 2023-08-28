package com.android.schedule.corelibrary.controller

import android.accessibilityservice.AccessibilityService

/**
create by: 86136
create time: 2023/8/28 10:06
Function description:
 */

abstract class BaseController(
    val acService: AccessibilityService,
    val onEnd: () -> Unit,
) {

    fun startGame() {

    }


    fun endGame() {

    }


    fun onPause() {

    }

    fun onResume() {

    }
}