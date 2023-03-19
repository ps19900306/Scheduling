package com.nwq.function.scheduling.executer.star_wars

import android.text.TextUtils
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.core_code.img.FindPointByColorTask
import com.nwq.function.scheduling.executer.base.TravelController
import com.nwq.function.scheduling.utils.JsonUtil
import com.nwq.function.scheduling.utils.sp.SP
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SpConstant
import kotlinx.coroutines.delay
import timber.log.Timber

abstract class BaseController(p: AccessibilityHelper, c: () -> Boolean) : TravelController(p, c) {


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

    //这些是收菜的
    val openHarvestVegetablesSP: Boolean by lazy {//是否开启收菜
        val isOpen = SP.getValue(prefixRole + SpConstant.OPEN_HARVEST_VEGETABLES, false)
        val str = SP.getValue(prefixRole + SpConstant.CELESTIAL_RESOURCES_LIST, "")
        isOpen && !TextUtils.isEmpty(str)
    }
    var resourcesAddTimeSp by SP(prefixRole + SpConstant.RESOURCES_ADD_TIME, 0L)
    var resourcesCollectTimeSp by SP(prefixRole + SpConstant.RESOURCES_ADD_COLLECT, 0L)
    val harvestVegetableController by lazy {
        HarvestVegetableController(helper, {
            true
        })
    }


    //这个是
    suspend fun intoGame() {
        var flag = true
        do {
            takeScreen(doubleClickInterval)
            if (visual.showAnnouncement()) {
                click(constant.closeAnnouncementArea)
            } else if (visual.readStartGame()) {
                click(constant.startGameArea)
            } else if (visual.selectRole()) {
                click(constant.selectRoleArea)
            } else if (visual.isOpenBigMenu()) {
                click(constant.closeBigMenuArea)
            } else if (visual.hasIntoGame()) {
                if (openHarvestVegetablesSP && System.currentTimeMillis() - resourcesAddTimeSp > constant.ADD_INTERVAL) {
                    harvestVegetableController.addPlanetaryTime()
                }
                flag = false
            }
        } while (flag && runSwitch)
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
    suspend fun unloadingCargo(normal: Boolean = true) {
        click(constant.getTopMenuArea(1))
        delay(tripleClickInterval)

        if (normal)
            click(constant.generalWarehouseArea)
        else
            click(constant.mineralWarehouseArea)

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
        while (!visual.hasPositionMenu() && flag > 0 && runSwitch) {
            click(constant.eraseWarningArea)
            takeScreen(doubleClickInterval)
        }
        if (visual.isClosePositionMenu()) {
            click(constant.eraseWarningArea)
        } else if (!visual.isDefaultCoordinateMenu()) {
            click(constant.defaultCoordinateMenuArea)
        }
    }

    suspend fun ensureOpenEyeMenu() {
        if (!visual.hasEyesMenu()) {
            theOutCheck()
        }
        if (visual.isCloseEyesMenu()) {
            click(constant.openEyeMenuArea, normalClickInterval)
        }
    }


    suspend fun theOutCheck() {
        Timber.d("  theOutCheck FightController NWQ_ 2023/3/12");
        var flag = true
        var count = 20
        while (flag && runSwitch) {
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
        while (flag && count > 0 && runSwitch) {
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
        while (flag && count > 0 && runSwitch) {
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
    suspend fun correctedCoordinate(): Boolean {
        var hasModifyX = false
        visual.findPointByColor(
            FindPointByColorTask(constant.localBaseX, 3, 0),
            listOf(255, 255, 255)
        )?.let {
            hasModifyX = true
            localOffsetX = (it.x - constant.localBaseX.x).toInt()
        }
        var hasModifyY = false
        visual.findPointByColor(
            FindPointByColorTask(constant.localBaseY, 0, 3),
            listOf(255, 255, 255)
        )?.let {
            hasModifyY = true
            localOffsetY = (it.y - constant.localBaseX.y).toInt()
        }
        Timber.d("hasModifyX:$hasModifyX hasModifyY:$hasModifyY  correctedCoordinate BaseController NWQ_ 2023/3/19");
        return hasModifyX && hasModifyY
    }

}
