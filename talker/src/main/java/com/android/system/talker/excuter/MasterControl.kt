package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.system.talker.database.AppDataBase

//这里是一个主要控制的
class MasterControl(
    val dataBase: AppDataBase,
    acService: AccessibilityService,
) : TurnBaseController(acService) {



}