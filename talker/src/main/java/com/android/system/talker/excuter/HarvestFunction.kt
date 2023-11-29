package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.utils.L
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
import com.android.system.talker.database.VegetableDb

class HarvestFunction(
    val vegetableDb: VegetableDb,
    userDb: UserDb,
    dataBase: AppDataBase,
    acService: AccessibilityService,
    onEnd: (b: Boolean) -> Unit,
) : BaseFunctionControl(userDb, dataBase, acService, onEnd) {


    val TAG = "收菜"

    private val START_GAME = 0//开始游戏
    private val LAUNCH_RESOURCE_LAUNCH = 1//等待资源发射
    private val GO_TO_COLLECT_NAVIGATION_MONITORING = 2//收菜导航
    private val MONITORING_RETURN_STATUS = 4//返回空间站监听
    private var nowStep = START_GAME
    override suspend fun getTag(): String {
        return TAG
    }


    override suspend fun startFunction() {
        if (needHarvestVegetables()) {
            harvestVegetables()
        } else if (needAddTime()) {

        } else {
            end()
        }


    }


    private suspend fun harvestVegetables() {
        var result = intoGame()
        if (!result) return

        result = returnSpaceStation(vegetableDb.baseLocation)
        if (!result) return

        checkShip(vegetableDb.shipType)


    }

    suspend fun generalControlMethod() {
        while (runSwitch) {
            when (nowStep) {
                LAUNCH_RESOURCE_LAUNCH -> {
                    launchAllVegetables()
                }
                GO_TO_COLLECT_NAVIGATION_MONITORING -> {
                   // goCollectNavigationMonitoring()
                }
                MONITORING_RETURN_STATUS -> {
                  //  monitoringReturnStatus()
                }
            }
        }
    }



    private suspend fun launchAllVegetables() {
          ensureOpenBigMenuArea(vegetableDb.menuType)


//        spReo.lastStatus = SpConstant.VEGETABLE
//        if (celestialList.isEmpty()) {
//            onComplete.invoke()
//            return
//        }
//        changeTrainShip()
//        unloadingCargo()
//
//        ensureOpenMenuArea(CaiPosition)
//        selectEntryItem(nowCelestialCount, doubleClickInterval)
//        delay(normalClickInterval)
//
//
//        click(constant.addTimeArea, normalClickInterval)
//        takeScreen(normalClickInterval)
//        ensureCloseDetermine()
//        spReo.resourcesAddTime = System.currentTimeMillis()
//        delay(normalClickInterval)
//
//
//        launchResources(celestialList[nowCelestialCount], normalClickInterval)
//        spReo.resourcesCollectTime = System.currentTimeMillis()
//        takeScreen(normalClickInterval)
//        ensureCloseDetermine()
//
//        click(constant.setTargetArea, doubleClickInterval)
//        var flag = true
//        var count = 20 * 20
//        while (flag && count > 0 && runSwitch) {
//            if (!takeScreen(doubleClickInterval)) {
//                runSwitch = false
//                return
//            }
//            if (visual.judeIsLaunchComplete(celestialList[nowCelestialCount])) {
//                Timber.d("发射完成 startCollectVegetables HarvestVegetableController NWQ_ 2023/3/14");
//                flag = false
//            }
//            count--
//        }
//        theOutCheck()
//        click(constant.eraseWarningArea, normalClickInterval)
//        hasLaunch = true
//        nowStep = GO_TO_COLLECT_NAVIGATION_MONITORING
    }




    fun needHarvestVegetables(): Boolean {
        return false
    }


    fun needAddTime(): Boolean {
        return false
    }

    private suspend fun selectEntryItem(position: Int, delayTime: Long = 0) {
        L.i("$position selectEntryItem HarvestVegetableController NWQ_ 2023/3/14");
        if (position < 5) {
           // click(constant.celestialBodyItem(position), delayTime)
        } else {
          //  swipe(constant.celestialSwipeArea(delayTime))
          //  click(constant.celestialBodyItem(position), doubleClickInterval)
        }
    }



}