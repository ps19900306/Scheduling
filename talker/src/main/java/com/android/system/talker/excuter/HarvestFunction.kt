package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.utils.L
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
import com.android.system.talker.database.VegetableDb
import kotlinx.coroutines.delay

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
        var result = intoGame()
        if (!result) return

        if (needHarvestVegetables()) {
            harvestVegetables()
        } else if (needAddTime()) {
            addVegetablesTime()
        } else {
            end()
        }


    }


    private suspend fun harvestVegetables() {
        var result = returnSpaceStation(vegetableDb.baseLocation)
        if (!result) return

        result = checkShip(vegetableDb.shipType)
        if (!result) return
        delay(doubleClickInterval)

        result = theOutCheck()
        if (!result) return

        result = addVegetablesTime()
        if (!result) return


    }

    private suspend fun addVegetablesTime(): Boolean {
        var flag = true
        var count = 20
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            if (en.isConfirmDialogTask.check()) {
                en.confirmDialogEnsureArea.c()
                flag = false
            } else if (en.isInSpaceStationT.check()) {
                ensureOpenBigMenuArea(vegetableDb.menuType)
            } else if (en.isOpenCaiBigMenuTask.check()) {
                if (en.isShowAddCelestialTask.check()) {
                    en.addCelestialArea.c()
                } else {
                    selectEntryItem(0, normalClickInterval)
                }
            }
            count--
        }
        return !flag
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
            en.getCelestialClickArea(position).c()
        } else {
            optClickTask(en.celestialSwipeArea(delayTime).toClickTask())
            delay(delayTime)
            en.celestialClick6Area.c()
        }
    }

    fun getCelestialClickArea(offset: Int): ClickArea {
        return if (offset <= 3) {
            ClickArea(102, 193 + offset * 198, 456, 183, false)
        } else if (offset == 4) {
            ClickArea(129, 1001, 387, 77, false)
        } else { //这里其实是等于5
            ClickArea(129, 1001, 387, 77, false)
        }
    }


}