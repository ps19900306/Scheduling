package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.area.CoordinateArea
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


    private val GO_TO_COLLECT_NAVIGATION_MONITORING = 1//收菜导航
    private val ONE_CLICK_CLAIM = 2// 进行收取
    private val MONITORING_RETURN_STATUS = 4//返回空间站监听
    private var nowStep = GO_TO_COLLECT_NAVIGATION_MONITORING
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

        delay(doubleClickInterval)
        launchResources()

        delay(doubleClickInterval)
        en.setTargetArea.c()

        waitLaunchEnd()

        theOutCheck()
        delay(normalClickInterval)
        en.eraseWarningArea.c()

        nowStep = GO_TO_COLLECT_NAVIGATION_MONITORING
        generalControlMethod()

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
                GO_TO_COLLECT_NAVIGATION_MONITORING -> {
                    goCollectNavigationMonitoring()
                }

                ONE_CLICK_CLAIM -> {
                    oneClickClaim()
                }

                MONITORING_RETURN_STATUS -> {
                    var result = returnSpaceStation(vegetableDb.baseLocation)
                    if (!result) return
                }
            }
        }
    }

    private suspend fun oneClickClaim(): Boolean {
        var flag = true
        var count = 5
        var hasLin = false
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            if (!hasLin && en.isOneClickClaimTask.check()) {
                en.oneClickClaimArea.c(en.isOneClickClaimTask)
                hasLin = true
                delay(screenshotInterval)
            } else if (en.isShowMaxTask.check()) {
                en.clickMaxArea.c(en.isShowMaxTask)
                delay(clickInterval)
                en.clickMaxConfArea.c(en.isShowMaxTask)
                delay(clickInterval)
                en.closeMaxArea.c(en.isShowMaxTask)
                delay(jumpClickInterval)
                en.closeOneClickArea.c(en.isOneClickClaimTask)
                nowStep = MONITORING_RETURN_STATUS
                return  true
            } else if (hasLin) {
                ensureOpenBigMenuArea(vegetableDb.menuType)
            }
            count--
        }
        return !flag
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
                runSwitch = false
            }
            if (en.isConfirmDialogTask.check()) {
                en.confirmDialogEnsureArea.c()
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
                runSwitch = false
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
        var flag = true
        var count = 20
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                runSwitch = false
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
                en.confirmDialogEnsureArea.c()
            } else if (en.isOpenBigMenuT.check()) {
                en.closeBigMenuArea.c()
            } else if (en.isClosePositionMenuT.check()) {
                nowStep = ONE_CLICK_CLAIM
                return true
            } else if (en.isSailingT.check()) {
                count = 20
            }
            count--
        }
        return !flag

    }

}