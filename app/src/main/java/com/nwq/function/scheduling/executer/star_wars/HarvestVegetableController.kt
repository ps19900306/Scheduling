package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.utils.JsonUtil
import com.nwq.function.scheduling.utils.sp.SP
import com.nwq.function.scheduling.utils.sp.SpConstant
import kotlinx.coroutines.delay

/**
create by: 86136
create time: 2023/3/14 17:54
Function description:
 */

class HarvestVegetableController(p: AccessibilityHelper, c: () -> Boolean) : BaseController(p, c) {

    private val WAIT_FOR_RESOURCE_LAUNCH = 0//等待资源发射
    private val START_GO_TO_COLLECT_NAVIGATION_MONITORING = 1//开去收菜导航
    private val GO_TO_COLLECT_NAVIGATION_MONITORING = 2//收菜导航
    private val START_MONITORING_RETURN_STATUS = 3//返回空间站监听
    private val MONITORING_RETURN_STATUS = 4//返回空间站监听

    private var nowCelestialCount = 0
    private var nowStep = 0


    val list by lazy {
        val str = SP.getValue(prefixRole + SpConstant.CELESTIAL_RESOURCES_LIST, "")
        JsonUtil.anyToJsonObject(str) ?: mutableListOf<Int>()
    }


    suspend fun addPlanetaryTime() {
        click(constant.getTopMenuArea(3))
        delay(doubleClickInterval)
        selectEntryItem(0)
        click(constant.addTimeArea, doubleClickInterval)
        takeScreen(doubleClickInterval)
        ensureCloseDetermine()
        theOutCheck()
    }

    suspend fun startCollectVegetables() {
        if (list.isEmpty()) {
            onComplete.invoke()
            return
        }
        unloadingCargo()
        theOutCheck()
        click(constant.getTopMenuArea(3))
        delay(doubleClickInterval)
        selectEntryItem(0)
        launchResources(list[0])
        ensureCloseDetermine()
    }

    override suspend fun generalControlMethod() {
        while (runSwitch) {
            when (nowStep) {
                START_GO_TO_COLLECT_NAVIGATION_MONITORING -> {

                }
                GO_TO_COLLECT_NAVIGATION_MONITORING -> {

                }
                START_MONITORING_RETURN_STATUS -> {

                }
                MONITORING_RETURN_STATUS -> {

                }
            }
        }
    }


    suspend fun goCollectNavigationMonitoring() {
        takeScreen(quadrupleClickInterval)
        if (visual.isClosePositionMenu() && visual.hasEyesMenu()) {
            //TODO 点击收菜区域
            takeScreen(doubleClickInterval)


        }
    }


    private suspend fun selectEntryItem(position: Int) {
        if (position < 5) {
            click(constant.celestialBodyItem(position))
        } else {
            var y = 1040 - (Math.random() * 270)
            var x = 150 + (Math.random() * 100)
            swipe(
                x,
                y,
                x + (Math.random() * 20),
                y - 210 - (Math.random() * 10),
                900 + (Math.random() * 50)
            )
            click(constant.celestialBodyItem(position), doubleClickInterval)
        }
    }

    private suspend fun launchResources(position: Int) {
        if (position <= 2) {

        }
    }

}