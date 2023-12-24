package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import android.text.TextUtils
import com.android.schedule.corelibrary.SetConstant
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.controller.ClickSpeedControl
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.TimeUtils
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
import com.android.system.talker.database.VegetableDb
import com.android.system.talker.enums.MenuType
import com.android.system.talker.enums.WarehouseType
import kotlinx.coroutines.delay


//这人个是收菜的逻辑
class HarvestFunction(
    val vegetableDb: VegetableDb,
    userDb: UserDb,
    dataBase: AppDataBase,
    acService: AccessibilityService
) : BaseFunctionControl(userDb, dataBase, acService) {


    val TAG = "收菜"
    override fun endGame(eroMsg: String?) {
        if (TextUtils.isEmpty(eroMsg)) {
            vegetableDb.lastCompletionTime = System.currentTimeMillis()
        } else {
            vegetableDb.errorStr = TimeUtils.getNowTime() + eroMsg
        }
        dataBase.getVegetableDao().update(vegetableDb)
    }

    override suspend fun getBaseCloneLocation(): Int {
        return vegetableDb.baseCloneLocation
    }


    override suspend fun getTag(): String {
        return TAG
    }

    private var nowCelestialCount = 0
    private val GO_TO_COLLECT_NAVIGATION_MONITORING = 1//收菜导航
    private val ONE_CLICK_CLAIM = 2// 进行收取
    private val MONITORING_RETURN_STATUS = 4//返回空间站监听
    private var nowStep = GO_TO_COLLECT_NAVIGATION_MONITORING


    override suspend fun startFunction() {
        L.i("$TAG startFunction")
        var result = intoGame()
        if (!result) return

        if (needHarvestVegetables()) {
            if (checkCloneLocation(vegetableDb.baseMenuLocation, vegetableDb.baseCloneLocation)) {
                harvestVegetables()
            } else {
                addVegetablesTime()
            }
        } else if (needAddTime()) {
            addVegetablesTime()
        }
    }

    suspend fun checkAndTime() {
        if (needAddTime()) {
            addVegetablesTime()
        }
    }


    private suspend fun harvestVegetables() {
        L.d("harvestVegetables")
        var result = returnSpaceStation(vegetableDb.baseMenuLocation)
        if (!result) return

        L.d("harvestVegetables")
        result = checkShip(vegetableDb.shipType)
        if (!result) return
        delay(jumpClickInterval)

        result = theOutCheck()
        if (!result) return

        result = addVegetablesTime()
        if (!result) return

        delay(jumpClickInterval)
        launchResources()

        delay(jumpClickInterval)
        en.setTargetArea.c()

        waitLaunchEnd()

        theOutCheck()
        delay(clickInterval)
        en.eraseWarningArea.c()

        nowStep = GO_TO_COLLECT_NAVIGATION_MONITORING
        generalControlMethod()

    }

    private suspend fun addVegetablesTime(): Boolean {
        L.d("addVegetablesTime")

        ensureOpenBigMenuArea(MenuType.PLANETARY_MINE)

        var flag = true
        var count = 5
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isConfirmDialogTask.check()) {
                en.confirmDialogEnsureArea.c(en.isConfirmDialogTask)
                vegetableDb.lastAddTime = System.currentTimeMillis()
                dataBase.getVegetableDao().update(vegetableDb)
                flag = false
            } else if (en.isShowAddCelestialTask.check()) {
                en.addCelestialArea.c()
            } else if (en.isOpenCaiBigMenuTask.check()) {
                selectEntryItem(0, clickInterval)
            }
            count--
        }
        return !flag
    }


    suspend fun generalControlMethod() {
        while (runSwitch) {
            when (nowStep) {
                GO_TO_COLLECT_NAVIGATION_MONITORING -> {
                    goCollectNavigationMonitoring()
                }

                ONE_CLICK_CLAIM -> {
                    oneClickClaim()
                }

                MONITORING_RETURN_STATUS -> {
                    monitoringReturnStatus()

                }
            }
        }
    }

    private suspend fun monitoringReturnStatus() {
        var result = returnSpaceStation(vegetableDb.baseMenuLocation)
        if (!result) return

        //卸载货物
        unloadingCargo(WarehouseType.SHIP_CABIN)

        if (nowCelestialCount < vegetableDb.numberCount) {
            ensureOpenBigMenuArea(vegetableDb.menuType)
            selectEntryItem(nowCelestialCount, jumpClickInterval)
            delay(jumpClickInterval)
            en.setTargetArea.c()
            theOutCheck()
            delay(jumpClickInterval)
            en.eraseWarningArea.c()
            nowStep = GO_TO_COLLECT_NAVIGATION_MONITORING
        } else {
            vegetableDb.lastAddTime = System.currentTimeMillis()
            vegetableDb.lastCompletionTime = System.currentTimeMillis()
            dataBase.getVegetableDao().update(vegetableDb)
            end()
        }
    }

    private suspend fun oneClickClaim(): Boolean {
        L.d("oneClickClaim")
        var flag = true
        var count = 30
        var hasLin = false
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (!hasLin && en.isOneClickClaimTask.check()) {
                en.oneClickClaimArea.c(en.isOneClickClaimTask)
                hasLin = true
                delay(jumpClickInterval)
            } else if (en.isShowMaxTask.check()) {
                oneClickClaimExtra()
                nowStep = MONITORING_RETURN_STATUS
                return true
            } else if (hasLin) {
                L.d("进行一次收菜操作")
                nowCelestialCount++
                if (nowCelestialCount < vegetableDb.numberCount) {
                    ensureOpenBigMenuArea(vegetableDb.menuType)
                    selectEntryItem(nowCelestialCount, jumpClickInterval)
                    delay(jumpClickInterval)
                    en.setTargetArea.c()
                    theOutCheck()
                    delay(jumpClickInterval)
                    en.eraseWarningArea.c()
                    nowStep = GO_TO_COLLECT_NAVIGATION_MONITORING
                } else {
                    nowStep = MONITORING_RETURN_STATUS
                }
                return true
            }
            count--
        }
        return !flag
    }

    private suspend fun oneClickClaimExtra():Boolean {
        var flag = true
        var count = 3
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isClosePositionMenuT.check() && !en.isOneClickClaimTask.check()) {
                flag = false
            } else {
                en.clickMaxArea.c(en.isShowMaxTask)
                delay(jumpClickInterval)
                en.clickMaxConfArea.c(en.isShowMaxTask)
                delay(jumpClickInterval)
                en.closeMaxArea.c(en.isShowMaxTask)
                delay(jumpClickInterval)
                en.closeOneClickArea.c(en.isOneClickClaimTask)
            }
            count--
        }
        return !flag
    }


    private fun needHarvestVegetables(): Boolean {
        return  TimeUtils.isAboveInterval(vegetableDb.lastCompletionTime,vegetableDb.completeInterval)
    }


    private fun needAddTime(): Boolean {
        return  TimeUtils.isAboveInterval(vegetableDb.lastAddTime,vegetableDb.addInterval)
    }

    // 这个是
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

    //发射行星菜不再需要知道
    private suspend fun launchResources(): Boolean {
        var flag = true
        var count = 5
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isConfirmDialogTask.check()) {
                en.confirmDialogEnsureArea.c(en.isConfirmDialogTask)
                flag = false
            } else if (en.findLunchAreaTask.check()) {
                ClickArea(
                    en.lunchAreaArea.x + en.findLunchAreaTask.getOffsetX(),
                    en.lunchAreaArea.y + en.findLunchAreaTask.getOffsetY(),
                    en.lunchAreaArea.width,
                    en.lunchAreaArea.height
                ).c()
            } else if (en.isShowAddCelestialTask.check()) {
                en.swipeResourceArea.c()
            }
            count--
        }
        return !flag
    }

    private suspend fun waitLaunchEnd(): Boolean {
        var flag = true
        var count = 20 * 3
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(20 * 1000)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.findLunchAreaTask.check()) {
                flag = false
            }
            count--
        }
        return true
    }


    private suspend fun goCollectNavigationMonitoring(): Boolean {
        L.d("进入收菜导航")
        var flag = true
        var count = 40
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isInSpaceStationT.check()) {
                if (en.isSailingT.check()) {
                    if (count == 15) {
                        en.outSpaceArea.c()
                    }
                } else {
                    if (count == 15) {
                        en.openPositionArea.c()
                    }
                }
            } else if (en.isConfirmDialogTask.check()) {
                en.confirmDialogEnsureArea.c(en.isConfirmDialogTask)
            } else if (en.isOpenBigMenuT.check()) {
                en.closeBigMenuArea.c()
            } else if (en.isClosePositionMenuT.check()) {
                nowStep = ONE_CLICK_CLAIM
                return true
            } else if (en.isSailingT.check()) {
                count = 40
            }
            count--
        }
        return !flag

    }

}