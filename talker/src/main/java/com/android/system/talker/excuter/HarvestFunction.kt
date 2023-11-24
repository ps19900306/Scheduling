package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
import com.android.system.talker.database.VegetableDb

class HarvestFunction(
    userId: Long,
    userDb: UserDb,
    dataBase: AppDataBase,
    acService: AccessibilityService,
    onEnd: () -> Unit,
) : BaseFunctionControl(userId, userDb, dataBase, acService, onEnd) {

    lateinit var mVegetableDb: VegetableDb

    override suspend fun startFunction() {
        mVegetableDb = dataBase.getVegetableDao().queryByUserId(userId)
    }


}