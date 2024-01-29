package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.TimeUtils
import com.android.schedule.corelibrary.xiaomi.AwakenExecuter
import com.android.schedule.corelibrary.xiaomi.CollectVoucherExecuter
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//这里是一个主要控制的
class MasterControl(
    val dataBase: AppDataBase,
    acService: AccessibilityService,
) : TurnBaseController(acService) {

    private var job: Job? = null

    override fun start() {
        job = GlobalScope.launch(Dispatchers.IO) {
            pressHomeBtn()
            dataBase.getUserDao().list().forEach {
                if (it.isChecked && TimeUtils.isNewDay(it.lastCompletionTime, it.startGameTime)) {
                    performTask(it)
                }
            }
        }
    }

    fun startCirculate() {
        job = GlobalScope.launch(Dispatchers.IO) {
            pressHomeBtn()
            var flag = true
            L.d("启动循环")
            while (flag) {
                dataBase.getUserDao().list().sortedBy { it.lastCompletionTime }.forEach {
                    if (it.isChecked) {
                        //如果时间不够就释放掉
                        if (!TimeUtils.isNewDay(it.lastCompletionTime, it.startGameTime)) {
                            L.d(" 进行启动等待")
                            delay(TimeUtils.getDelayTime(it.lastCompletionTime, it.startGameTime))
                            val awakenExecuter = AwakenExecuter(acService)
                            awakenExecuter.optAwaken()
                            if (!awakenExecuter.result) {
                                flag = false
                                return@launch
                            }
                        }
                        if(!performTask(it)){//只要有一个失败就结束执行
                            flag = false
                            return@launch
                        }
                    }
                }
            }
        }
    }





    override suspend fun end() {
        job?.cancel()
    }

    private suspend fun performTask(userDb: UserDb):Boolean {
        if (userDb.xiaomiDiscountSwitch && TimeUtils.isNewDay(userDb.xiaomiDiscountTime, 1)) {
            CollectVoucherExecuter(acService).let {
                it.optCollectVoucher()
                if (it.result) {
                    userDb.xiaomiDiscountTime = System.currentTimeMillis()
                    dataBase.getUserDao().update(userDb)
                }
            }
        }


        val vegetableDb = dataBase.getVegetableDao().queryByUserId(userDb.id)
        val taskDb = dataBase.getTaskDao().queryByUserId(userDb.id)
        val minerDb = dataBase.getMinerDao().queryByUserId(userDb.id)

        val list = mutableListOf<BaseFunctionControl>()


        list.add(UserFunction(userDb, dataBase, acService))


        if (vegetableDb != null && vegetableDb.isSwitch) {
            list.add(HarvestFunction(vegetableDb, userDb, dataBase, acService))
        }



        if (taskDb != null && taskDb.isSwitch == 1) {
            list.add(TaskFunction(taskDb, userDb, dataBase, acService))
        }

        if (minerDb != null && minerDb.switch) {
            list.add(MinerFunction(minerDb, userDb, dataBase, acService))
        }

        val mapList = list.groupBy { it.getBaseCloneLocation() }


        val oldCloneLocation = userDb.baseCloneLocation
        //这里先集中执行克隆位置一样的
        mapList[userDb.baseCloneLocation]?.let {
            it.forEachIndexed { index, baseFunctionControl ->
                baseFunctionControl.startFunction()
                if (!baseFunctionControl.optReuslt) {
                    baseFunctionControl.exitGame()
                    return false
                }
                //这里是保证进入后增加一次菜时间
                if (index == 0 && vegetableDb != null && vegetableDb.baseCloneLocation != oldCloneLocation) {
                    HarvestFunction(vegetableDb, userDb, dataBase, acService).checkAndTime()
                }
            }
        }



        mapList.forEach { (t, u) ->
            if (t != oldCloneLocation) {
                //改变克隆时间需要有间隔 但是基地坐标不需要时间
                if (t == 0 || TimeUtils.isAboveInterval(
                        userDb.lastChangeLocationTime,
                        userDb.ChangeLocationInterval.toInt()
                    )
                ) {
                    u.forEach {
                        it.startFunction()
                        if (!it.optReuslt) {
                            it.exitGame()
                            return false
                        }
                    }
                }

            }

        }

        //最后再增加一下收菜时间
        if (vegetableDb != null && vegetableDb.baseCloneLocation == oldCloneLocation) {
            HarvestFunction(vegetableDb, userDb, dataBase, acService).let {
                it.checkAndTime()
                it.exitGame()
            }
        } else {
            list.getOrNull(0)?.exitGame()
        }

        userDb.lastCompletionTime = System.currentTimeMillis()
        dataBase.getUserDao().update(userDb)

        if (userDb.xiaomiDiscountSwitch && TimeUtils.isNewDay(userDb.xiaomiDiscountTime, 1)) {
            CollectVoucherExecuter(acService).let {
                it.optCollectVoucher()
                if (it.result) {
                    userDb.xiaomiDiscountTime = System.currentTimeMillis()
                    dataBase.getUserDao().update(userDb)
                }
            }
        }
        return true
    }


    private fun selectExecutiveRole(): UserDb? {
        val list = dataBase.getUserDao().list()
        return list.find { !it.needDelay && TimeUtils.isNewDay(it.lastCompletionTime) }
            ?: list.find { TimeUtils.isNewDay(it.lastCompletionTime) }
    }


}