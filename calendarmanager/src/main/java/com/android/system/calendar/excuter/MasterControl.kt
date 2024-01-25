package com.android.system.calendar.excuter

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.utils.TimeUtils
import com.android.system.calendar.excuter.nomarl.BangTaskFunction
import com.android.system.calendar.excuter.nomarl.ImageEnvironment
import com.android.system.calendar.excuter.nomarl.ShiMenFunction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MasterControl(acService: AccessibilityService) : TurnBaseController(acService) {


    private var job: Job? = null
    val en = ImageEnvironment()
    override fun start() {
        job?.cancel()
        job = GlobalScope.launch(Dispatchers.IO) {
            //OriginFunction(acService).startTheProcess()
            BangTaskFunction(acService,en).startFunction()
        }
    }

    fun stop() {
        job?.cancel()
    }
}