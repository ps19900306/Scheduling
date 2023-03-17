package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.core_code.img.FindPointByColorTask
import com.nwq.function.scheduling.executer.base.TravelController
import com.nwq.function.scheduling.utils.JsonUtil
import com.nwq.function.scheduling.utils.sp.SP
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SpConstant
import kotlinx.coroutines.delay
import timber.log.Timber

open class BaseController(p: AccessibilityHelper, c: () -> Boolean) : TravelController(p, c) {


    val prefixRole by lazy { SPRepo.role }
    protected val TopOfst = SpConstant.TopOfst//顶部的偏移量
    protected val BotOfst = SpConstant.BotOfst//底部的便宜量
    protected val visual by lazy {
        BaseVisualEnvironment(helper)
    }
    protected val constant by lazy {
        BaseConstant()
    }
    protected val maintenanceDevicePosition = TopOfst + 1
    protected val weaponPosition = BotOfst + 3
    protected val cellPosition = BotOfst + 5
    protected val pickUpPosition = BotOfst + 6
    val isShieldResistance by lazy {
        SP.getValue(prefixRole + SpConstant.CRESISTANCE_MODE, false)
    }//是否护盾抗

    override suspend fun generalControlMethod() {
//        while (runSwitch) {
//            when (nowStep) {
//
//            }
//        }
    }


    //获取是关闭的状态
    protected fun checkEquipStatusClose(vararg data: List<Int>): MutableList<Int> {
        val unOpenList = mutableListOf<Int>()
        data.forEach {
            it.forEach { index ->
                if (!judgeIsOpen(index)) {
                    unOpenList.add(index)
                }
            }
        }
        return unOpenList
    }


    //获取是开启的状态
    protected fun checkEquipStatusOpen(vararg data: List<Int>): MutableList<Int> {
        val unOpenList = mutableListOf<Int>()
        data.forEach {
            it.forEach { index ->
                if (judgeIsOpen(index)) {
                    unOpenList.add(index)
                }
            }
        }
        return unOpenList
    }

    suspend fun clickEquipArray(list: List<Int>) {
        Timber.d("${JsonUtil.objectToString(list)} 点击数组有 FightController NWQ_ 2023/3/10");
        if (list.isNullOrEmpty()) {
            return
        }
        click(list.map { index ->
            if (index < TopOfst) {
                constant.getBottomEquipArea(index)
            } else {
                constant.getTopEquipArea(index - TopOfst - 1)
            }
        })
    }


    fun judgeIsOpen(index: Int): Boolean {
        return if (index < TopOfst) {
            visual.judgeIsOpenBottom(index)
        } else {
            visual.judgeIsOpenTop(index - TopOfst - 1)
        }
    }

    suspend fun checkEquipTimes(
        times: Int, closeData: List<Int>?, openData: List<Int>?
    ): MutableList<Int> {
        var list = mutableListOf<Int>()
        var list2 = mutableListOf<Int>()
        for (i in 0 until times) {
            takeScreen(normalClickInterval)
            closeData?.let {
                val result = checkEquipStatusClose(closeData)
                list = if (i == 0) {
                    result
                } else {
                    list.filter { result.contains(it) }.toMutableList()
                }
            }
            openData?.let {
                val result2 = checkEquipStatusOpen(openData)
                list2 = if (i == 0) {
                    result2
                } else {
                    list2.filter { result2.contains(it) }.toMutableList()
                }
            }
        }
        list.addAll(list2)
        return list
    }


    suspend fun openCheckEquipTimes(times: Int, vararg data: List<Int>): List<Int> {
        var list = listOf<Int>()
        for (i in 0 until times) {
            takeScreen(normalClickInterval)
            val result = checkEquipStatusClose(*data)
            list = if (i == 0) {
                result
            } else {
                list.filter { result.contains(it) }
            }
        }
        return list
    }


    private suspend fun clickEquip(index: Int, delay: Long) {
        if (index < TopOfst) {
            click(constant.getBottomEquipArea(index), delay)
        } else {
            click(constant.getTopEquipArea(index - TopOfst - 1), delay)
        }
    }

    //卸载货物
    suspend fun unloadingCargo() {
        click(constant.getTopMenuArea(1))
        delay(tripleClickInterval)
        click(constant.generalWarehouseArea)
        delay(doubleClickInterval)
        takeScreen()
        if (visual.isEmptyWarehouse()) {
            theOutCheck()
        } else {
            click(constant.warehouseSelectAllArea)
            delay(normalClickInterval)
            click(constant.warehouseMoveArea)
            delay(normalClickInterval)
            click(constant.warehouseAllArea)
            theOutCheck()
        }
    }

    suspend fun clickJumpCollectionAddress(index: Int, determine: Boolean) {
        ensureOpenPositionMenu()
        click(constant.getAddressArea(index), normalClickInterval)
        if (determine) {
            click(constant.dialogDetermineArea, normalClickInterval)
        }
    }

    suspend fun ensureOpenPositionMenu() {
        var flag = 3
        while (!visual.hasPositionMenu() && flag > 0) {
            click(constant.eraseWarningArea)
            takeScreen(doubleClickInterval)
        }
        if (visual.isClosePositionMenu()) {
            click(constant.eraseWarningArea)
        } else if (!visual.isDefaultCoordinateMenu()) {
            click(constant.defaultCoordinateMenuArea)
        }
    }

    suspend fun theOutCheck() {
        Timber.d("  theOutCheck FightController NWQ_ 2023/3/12");
        var flag = true
        var count = 20
        while (flag) {
            takeScreen(doubleClickInterval)
            if (visual.isOpenBigMenu()) {
                click(constant.closeBigMenuArea)
            } else if (visual.hasIntoGame()) {
                flag = false
            } else if (visual.hasPositionMenu() && visual.hasRightDialogue()) {
                flag = false
            } else if (visual.isShowDetermine()) {
                click(constant.dialogDetermineArea)
            } else if (count <= 0) {
                click(constant.closeBigMenuArea)
                flag = false
                runSwitch = false
            } else {
                count--
            }
        }
    }

    suspend fun ensureCloseDetermine(): Boolean {
        if (visual.isShowDetermine()) {
            click(constant.dialogDetermineArea)
            return true
        }
        return false
    }

    var maintenanceTimeStartStamp = 0L
    var MAINTENANCE_INTERVAL = 30000L //维修间隔
    suspend fun bloodVolumeMonitoring(
        needCheckOpenList: MutableList<Int>, needCheckCloseList: MutableList<Int>
    ) {
        if (System.currentTimeMillis() - maintenanceTimeStartStamp < MAINTENANCE_INTERVAL) {
            return
        }
        if (isShieldResistance) {
            if (visual.shieldTooLow()) {
                needCheckOpenList.add(maintenanceDevicePosition)
            } else if (visual.shieldFull()) {
                needCheckCloseList.add(maintenanceDevicePosition)
            } else {

            }
        } else {
            if (visual.armorTooLow()) {
                needCheckOpenList.add(maintenanceDevicePosition)
            } else if (visual.armorFull()) {
                needCheckCloseList.add(maintenanceDevicePosition)
            } else {

            }
        }
    }


    suspend fun ensureOpenLocalList() {
        var flag = true
        var count = 3
        while (flag && count > 0) {
            takeScreen(normalClickInterval)
            if (visual.isOpenLocalList()) {
                flag = false
            } else if (visual.isOpenPositionMenu()) {
                click(constant.closePositionArea)
                delay(normalClickInterval)
                click(constant.localListArea)
                count--
            } else {
                click(constant.localListArea)
                count--
            }
        }
    }

    suspend fun ensureCloseLocalList() {
        var flag = true
        var count = 3
        while (flag && count > 0) {
            takeScreen(normalClickInterval)
            if (!visual.isOpenLocalList()) {
                flag = false
            } else if (visual.isOpenPositionMenu()) {
                click(constant.closePositionArea)
                delay(normalClickInterval)
                click(constant.localListArea)
                count--
            } else {
                click(constant.localListArea)
                count--
            }
        }
    }

    var localOffsetX = 0
    var localOffsetY = 0
    suspend fun correctedCoordinate() {
        visual.findPointByColor(
            FindPointByColorTask(constant.localBaseX, 3, 0),
            listOf(255, 255, 255)
        )?.let {
            localOffsetX = (it.x - constant.localBaseX.x).toInt()
        }
        visual.findPointByColor(
            FindPointByColorTask(constant.localBaseY, 0, 3),
            listOf(255, 255, 255)
        )?.let {
            localOffsetY = (it.y - constant.localBaseX.y).toInt()
        }
    }

}
