package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.MinerDb
import com.android.system.talker.database.TaskDb
import com.android.system.talker.database.UserDb
import com.android.system.talker.database.VegetableDb

class MinerFunction(
    val functionDb: MinerDb,
    userDb: UserDb,
    dataBase: AppDataBase,
    acService: AccessibilityService
) : BaseFunctionControl(userDb, dataBase, acService) {
    override fun endGame(eroMsg: String?) {
        TODO("Not yet implemented")
    }

    override suspend fun getTag(): String {
        TODO("Not yet implemented")
    }

    override suspend fun startFunction() {
        TODO("Not yet implemented")
    }

    override suspend fun getBaseCloneLocation(): Int {
        TODO("Not yet implemented")
    }
}