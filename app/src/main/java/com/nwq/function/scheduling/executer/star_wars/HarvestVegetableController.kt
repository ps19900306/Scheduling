package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.utils.JsonUtil
import com.nwq.function.scheduling.utils.sp.SP
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SpConstant
import kotlinx.coroutines.delay
import timber.log.Timber

/**
create by: 86136
create time: 2023/3/14 17:54
Function description:
 */

class HarvestVegetableController(p: AccessibilityHelper, c: () -> Boolean) : BaseController(p, c) {

    private val WAIT_FOR_RESOURCE_LAUNCH = 0//等待资源发射
    private val GO_TO_COLLECT_NAVIGATION_MONITORING = 2//收菜导航
    private val MONITORING_RETURN_STATUS = 4//返回空间站监听

    private var nowCelestialCount = 0
    private var nowStep = GO_TO_COLLECT_NAVIGATION_MONITORING
    private var isDamage = false
    val warehouseIndex by lazy {
        SP.getValue(prefixRole + SpConstant.BASE_LOCATION, 0)
    }

    val list by lazy {
        val str = SP.getValue(prefixRole + SpConstant.CELESTIAL_RESOURCES_LIST, "")
        JsonUtil.anyToJsonObject(str) ?: mutableListOf<Int>()
    }
    var resourcesAddTimeSp by SP(prefixRole + SpConstant.RESOURCES_ADD_TIME, 0L)
    var resourcesCollectTimeSp by SP(prefixRole + SpConstant.RESOURCES_ADD_COLLECT, 0L)


    suspend fun addPlanetaryTime() {
        click(constant.getTopMenuArea(3))
        delay(doubleClickInterval)
        selectEntryItem(0)
        click(constant.addTimeArea, doubleClickInterval)
        takeScreen(doubleClickInterval)
        ensureCloseDetermine()
        resourcesAddTimeSp = System.currentTimeMillis()
        theOutCheck()
    }

    suspend fun startCollectVegetables() {
        if (list.isEmpty()) {
            onComplete.invoke()
            return
        }
        changeTrainShip()

        unloadingCargo()
        theOutCheck()
        click(constant.getTopMenuArea(3))
        selectEntryItem(nowCelestialCount, doubleClickInterval)
        delay(normalClickInterval)

        click(constant.addTimeArea, doubleClickInterval)
        takeScreen(doubleClickInterval)
        ensureCloseDetermine()
        resourcesAddTimeSp = System.currentTimeMillis()
        delay(normalClickInterval)

        launchResources(list[nowCelestialCount], normalClickInterval)
        takeScreen(normalClickInterval)
        ensureCloseDetermine()
        val startTime = System.currentTimeMillis()
        var flag = true
        while (flag && System.currentTimeMillis() - startTime < 20 * 60 * 1000) {
            takeScreen(quadrupleClickInterval)
            if (visual.judeIsLaunchComplete(list[nowCelestialCount])) {
                Timber.d("发射完成 startCollectVegetables HarvestVegetableController NWQ_ 2023/3/14");
                flag = false
            } else {
                Timber.d("等待发射 startCollectVegetables HarvestVegetableController NWQ_ 2023/3/14");
            }
        }
        click(constant.setTargetArea)
        theOutCheck()
        delay(doubleClickInterval)
        click(constant.eraseWarningArea)
        takeScreen(doubleClickInterval)
        ensureCloseDetermine()
        takeScreen(doubleClickInterval)
        ensureCloseDetermine()
        generalControlMethod()
    }

    override suspend fun generalControlMethod() {
        while (runSwitch) {
            when (nowStep) {
                GO_TO_COLLECT_NAVIGATION_MONITORING -> {
                    goCollectNavigationMonitoring()
                }
                MONITORING_RETURN_STATUS -> {

                }
            }
        }
    }


    suspend fun goCollectNavigationMonitoring() {
        takeScreen(quadrupleClickInterval)
        if (visual.isClosePositionMenu() && visual.hasEyesMenu()) {
            Timber.d(" 到底目的 goCollectNavigationMonitoring HarvestVegetableController NWQ_ 2023/3/14");
            if (visual.isShowCollectBtn()) {
                click(constant.collectButtonArea1, doubleClickInterval)
            } else {
                click(constant.collectButtonArea2, quadrupleClickInterval)
            }
            var flag = true
            while (flag) {
                takeScreen(normalClickInterval)
                if (visual.isClosePositionMenu()) {
                    flag = false
                }
            }
            nowCelestialCount++
            if (nowCelestialCount >= list.size) {//结束了
                resourcesCollectTimeSp = System.currentTimeMillis()
                Timber.d("完成 goCollectNavigationMonitoring HarvestVegetableController NWQ_ 2023/3/14");
                SPRepo.lastBackSpaceStation = System.currentTimeMillis()
                clickJumpCollectionAddress(warehouseIndex, false)
                nowStep = MONITORING_RETURN_STATUS
            } else {
                Timber.d("继续 goCollectNavigationMonitoring HarvestVegetableController NWQ_ 2023/3/14");
                click(constant.getTopMenuArea(3))
                selectEntryItem(nowCelestialCount, doubleClickInterval)
                delay(normalClickInterval)
                click(constant.setTargetArea, normalClickInterval)
                theOutCheck()
                delay(doubleClickInterval)
                click(constant.eraseWarningArea, normalClickInterval)

            }
        } else if (visual.isOpenEyesMenu() && visual.isOpenPositionMenu() && !visual.isSailing()) {//导航停止了
            Timber.d("导航停止了 goCollectNavigationMonitoring HarvestVegetableController NWQ_ 2023/3/14");
            click(constant.eraseWarningArea)
        } else if (visual.isInSpaceStation() && visual.isOpenPositionMenu() && !visual.isSailing()) {//炸了
            Timber.d("//炸了 goCollectNavigationMonitoring HarvestVegetableController NWQ_ 2023/3/14");
            clickJumpCollectionAddress(warehouseIndex, false)
            nowStep = MONITORING_RETURN_STATUS
            isDamage = true
        }
    }


    suspend fun monitoringReturnStatus() {
        takeScreen(quadrupleClickInterval * 2)
        if (System.currentTimeMillis() - SPRepo.lastBackSpaceStation > constant.MAX_BATTLE_TIME * 2) {
            SPRepo.lastBackSpaceStation = System.currentTimeMillis() - constant.MAX_BATTLE_TIME
            if (!visual.isSailing()) {
                clickJumpCollectionAddress(warehouseIndex, false)
            }
            return
        } else if (visual.isInSpaceStation()) {
            changeTrainShip()
            delay(doubleClickInterval)
            runSwitch = false //结束掉收菜
        } else if (visual.isOpenBigMenu()) {
            click(constant.closeBigMenuArea)
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


    //开始驾驶二号船 默认就只有二个船
    suspend fun changeTrainShip() {
        click(constant.getTopMenuArea(1))
        delay(doubleClickInterval)

        //点击机库
        click(constant.jikuArea)
        delay(doubleClickInterval)

        //第二个船
        click(constant.theTwoArea)
        delay(doubleClickInterval)

        //点击激活
        click(constant.jiHuoArea)
        delay(quadrupleClickInterval)
        theOutCheck()
    }
}