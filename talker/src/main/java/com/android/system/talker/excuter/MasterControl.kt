package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.TimeUtils
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

//这里是一个主要控制的
class MasterControl(
    val dataBase: AppDataBase,
    acService: AccessibilityService,
) : TurnBaseController(acService) {

    private var job: Job? = null

    override fun start() {
        job = GlobalScope.launch(Dispatchers.IO) {
            //var userDb = selectExecutiveRole()
            pressHomeBtn()
            dataBase.getUserDao().list().forEach{
                if(it.isChecked)
                performTask(it)
            }
        }
    }

    override suspend fun end() {
        job?.cancel()
    }

    private suspend fun performTask(userDb: UserDb) {

        val vegetableDb = dataBase.getVegetableDao().queryByUserId(userDb.id)
        val taskDb = dataBase.getTaskDao().queryByUserId(userDb.id)
        val minerDb = dataBase.getMinerDao().queryByUserId(userDb.id)

        val list = mutableListOf<BaseFunctionControl>()


        list.add(UserFunction(userDb, dataBase, acService))

        if (vegetableDb != null && vegetableDb.isSwitch) {
            list.add(HarvestFunction(vegetableDb, userDb, dataBase, acService))
        }

        if (taskDb != null && taskDb.isSwitch==1) {
            list.add(TaskFunction(taskDb, userDb, dataBase, acService))
        }

        if (minerDb != null && minerDb.switch) {
            list.add(MinerFunction(minerDb, userDb, dataBase, acService))
        }

        val mapList = list.groupBy { it.getBaseCloneLocation() }

        //这里先集中执行克隆位置一样的
        mapList[userDb.baseCloneLocation]?.let {
            it.forEach {
                it.startFunction()
            }
        }

        val oldCloneLocation = userDb.baseCloneLocation
        mapList.forEach { (t, u) ->
            if (t != oldCloneLocation) {
                u.forEach {
                    it.startFunction()
                }
            }
        }

        //最后再增加一下收菜时间
        if (vegetableDb != null && vegetableDb.isSwitch) {
            HarvestFunction(vegetableDb, userDb, dataBase, acService).let {
                it.checkAndTime()
                it.exitGame()
            }
        }else{
            list.getOrNull(0)?.exitGame()
        }
    }


    private fun selectExecutiveRole(): UserDb? {
        val list = dataBase.getUserDao().list()
        return list.find { !it.needDelay && TimeUtils.isNewDay(it.lastCompletionTime) }
            ?: list.find { TimeUtils.isNewDay(it.lastCompletionTime) }
    }


}