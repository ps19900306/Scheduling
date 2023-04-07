package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.Constant
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.utils.sp.SpConstant
import kotlinx.coroutines.delay
import timber.log.Timber

/**
create by: 86136
create time: 2023/3/14 17:54
Function description:
 */

class HarvestVegetableController(p: AccessibilityHelper, c: () -> Boolean) : BaseController(p, c) {

    private val START_GAME = 0//等待资源发射
    private val LAUNCH_RESOURCE_LAUNCH = 1//等待资源发射
    private val GO_TO_COLLECT_NAVIGATION_MONITORING = 2//收菜导航
    private val MONITORING_RETURN_STATUS = 4//返回空间站监听

    private var nowCelestialCount = 0
    private var nowStep = START_GAME
    private var hasLaunch = false


    suspend fun addPlanetaryTime() {
        ensureOpenMenuArea(CaiPosition)
        delay(normalClickInterval)
        selectEntryItem(0)
        click(constant.addTimeArea, doubleClickInterval)
        takeScreen(doubleClickInterval)
        ensureCloseDetermine()
        spReo.resourcesAddTime = System.currentTimeMillis()
        theOutCheck()
    }

    suspend fun startCollectVegetables() {
        theOutCheck()
        takeScreen(normalClickInterval)
        if (visual.isInSpaceStation()) {
            nowStep = LAUNCH_RESOURCE_LAUNCH
        } else {
            clickJumpCollectionAddress(spReo.resourcesBaseLocation, false)
            nowStep = MONITORING_RETURN_STATUS
        }
        generalControlMethod()
    }


    override suspend fun generalControlMethod() {
        while (runSwitch) {
            when (nowStep) {
                START_GAME -> {
                    startGame()
                }
                LAUNCH_RESOURCE_LAUNCH -> {
                    launchAllVegetables()
                }
                GO_TO_COLLECT_NAVIGATION_MONITORING -> {
                    goCollectNavigationMonitoring()
                }
                MONITORING_RETURN_STATUS -> {
                    monitoringReturnStatus()
                }
            }
        }
    }


    private suspend fun startGame() {
        takeScreen(normalClickInterval)
        delay(2000)
        click(constant.getAppArea())
        delay(doubleClickInterval * 2)
        if (intoGame()) {
            nowStep = LAUNCH_RESOURCE_LAUNCH
        } else {
            onComplete.invoke()
        }
    }


    private suspend fun launchAllVegetables() {
        spReo.lastStatus = SpConstant.VEGETABLE
        if (celestialList.isEmpty()) {
            onComplete.invoke()
            return
        }
        changeTrainShip()
        unloadingCargo()

        ensureOpenMenuArea(CaiPosition)
        selectEntryItem(nowCelestialCount, doubleClickInterval)
        delay(normalClickInterval)


        click(constant.addTimeArea, normalClickInterval)
        takeScreen(normalClickInterval)
        ensureCloseDetermine()
        spReo.resourcesAddTime = System.currentTimeMillis()
        delay(normalClickInterval)


        launchResources(celestialList[nowCelestialCount], normalClickInterval)
        takeScreen(normalClickInterval)
        ensureCloseDetermine()

        click(constant.setTargetArea, doubleClickInterval)
        var flag = true
        var count = 20 * 20
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.judeIsLaunchComplete(celestialList[nowCelestialCount])) {
                Timber.d("发射完成 startCollectVegetables HarvestVegetableController NWQ_ 2023/3/14");
                flag = false
            }
            count--
        }

        theOutCheck()
        click(constant.eraseWarningArea, normalClickInterval)
        hasLaunch = true
        nowStep = GO_TO_COLLECT_NAVIGATION_MONITORING
    }


    private suspend fun chooseADestination() {
        ensureOpenMenuArea(CaiPosition)
        selectEntryItem(nowCelestialCount, doubleClickInterval)
        delay(normalClickInterval)
        click(constant.setTargetArea, normalClickInterval)
        theOutCheck()
        click(constant.eraseWarningArea, normalClickInterval)
    }


    private suspend fun goCollectNavigationMonitoring() {
        var flag = true
        var count = 10
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.arriveReceivingPoint()) {
                click(constant.collectButtonArea1, normalClickInterval)
                nowCelestialCount++
                if (nowCelestialCount >= celestialList.size) {
                    spReo.resourcesCollectTime = System.currentTimeMillis()
                    clickJumpCollectionAddress(spReo.resourcesBaseLocation, false)
                    nowStep = MONITORING_RETURN_STATUS
                } else {
                    chooseADestination()
                }
                return  //这里要进入第下一轮
            } else if (visual.isShowDetermine()) {
                click(constant.dialogDetermineArea)
            } else if (visual.isOpenWallet()) {
                click(constant.closeWalletArea)
            } else if (visual.isOpenPositionMenu()) {
                if (visual.hasEyesMenu() || visual.isInSpaceStation()) {
                    if (visual.isSailing()) {
                        count = 30
                    } else {
                        count--
                        if (count == 20 || count == 10) {
                            click(constant.eraseWarningArea, normalClickInterval)
                        }
                    }
                }
            } else if (visual.isCloseEyesMenu()) {
                count--
            }
        }
        if (count == 0 && flag) {//这里大概率菜被偷了
            nowCelestialCount++
            chooseADestination()
            return
        }
    }


    private suspend fun monitoringReturnStatus() {
        var flag = true
        var count = 300
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.isInSpaceStation()) {
                if (hasLaunch) {
                    unloadingCargo()
                    delay(normalClickInterval)
                    changeTrainShip()
                    delay(doubleClickInterval)
                    spReo.lastStatus = SpConstant.VEGETABLES
                    runSwitch = false //结束掉收菜
                } else {
                    nowStep = LAUNCH_RESOURCE_LAUNCH
                    return
                }
            } else if (visual.isShowDetermine()) {
                click(constant.dialogDetermineArea)
            } else if (visual.isOpenBigMenu()) {
                click(constant.closeBigMenuArea)
            } else if (visual.isOpenWallet()) {
                click(constant.closeWalletArea)
            } else if (count == 100) {
                if (!visual.isSailing()) {
                    clickJumpCollectionAddress(spReo.resourcesBaseLocation, false)
                }
            }
            count--
        }

        if (count == 0 && flag) {
            runSwitch = false
            spReo.lastStatus = SpConstant.UNUSUAL
            return
        }
    }


    private suspend fun selectEntryItem(position: Int, delayTime: Long = 0) {
        Timber.d("$position selectEntryItem HarvestVegetableController NWQ_ 2023/3/14");
        if (position < 5) {
            click(constant.celestialBodyItem(position), delayTime)
        } else {
            swipe(constant.celestialSwipeArea(delayTime))
            click(constant.celestialBodyItem(position), doubleClickInterval)
        }
    }

    private suspend fun launchResources(position: Int, delayTime: Long = 0) {
        Timber.d("$position launchResources HarvestVegetableController NWQ_ 2023/3/14");
        if (position <= 2) {
            click(constant.resourceLocation(position))
        } else {
            swipe(constant.resourceSwipeArea(delayTime), 0)
            click(constant.resourceLocation(position), quadrupleClickInterval)
        }
    }


}