package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.TaskDb
import com.android.system.talker.database.UserDb


class TaskFunction(
    val taskDb: TaskDb,
    userDb: UserDb,
    dataBase: AppDataBase,
    acService: AccessibilityService
) : BaseFunctionControl(userDb, dataBase, acService){

    val TAG = "际遇任务"
    override fun endGame(eroMsg: String?) {
        TODO("Not yet implemented")
    }

    override suspend fun getTag(): String {
        return TAG
    }


    override suspend fun startFunction() {
        TODO("Not yet implemented")
    }

    override suspend fun getBaseCloneLocation(): Int {
        TODO("Not yet implemented")
    }

}