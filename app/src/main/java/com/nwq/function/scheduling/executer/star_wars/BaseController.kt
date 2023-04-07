package com.nwq.function.scheduling.executer.star_wars

import android.icu.text.Transliterator
import android.text.TextUtils
import com.nwq.function.scheduling.core_code.Constant
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.core_code.img.FindPointByColorTask
import com.nwq.function.scheduling.executer.base.TravelController
import com.nwq.function.scheduling.executer.star_wars.data.OptSlotInfo
import com.nwq.function.scheduling.utils.JsonUtil
import com.nwq.function.scheduling.utils.TimeUtils
import com.nwq.function.scheduling.utils.sp.SPRepoPrefix
import com.nwq.function.scheduling.utils.sp.SpConstant
import kotlinx.coroutines.delay
import timber.log.Timber

abstract class BaseController(p: AccessibilityHelper, c: () -> Boolean) : TravelController(p, c) {


    protected val spReo by lazy {
        SPRepoPrefix.getNowSPRepo()
    }
    protected val TopOfst = 6//顶部的偏移量
    protected val BotOfst = -1//底部的便宜量
    var DEFAULT_DESTROY_INTERVAL = 80 * 1000 //能够容忍的最大击毁间隔
    var DESTROY_INTERVAL = DEFAULT_DESTROY_INTERVAL //能够容忍的最大击毁间隔
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
    protected val propellerPosition = BotOfst + 1
    val isShieldResistance = if (spReo.nowSelectMode == SpConstant.FIGHT_MODEL) spReo.resistanceMode
    else spReo.resistanceModeF
    protected var needCancel = false
    protected var neeForceRefresh = false
    protected var needBackStation = false
    protected var needChangeShip = false
    protected val celestialList by lazy {
        JsonUtil.anyToJsonObject(spReo.celestialResources) ?: mutableListOf<Int>()
    }

    //这些是收菜的
    val openHarvestVegetablesSP: Boolean by lazy {//是否开启收菜
        val isOpen = spReo.openHarvestVegetables
        val str = spReo.celestialResources
        isOpen && !TextUtils.isEmpty(str)
    }

    val harvestVegetableController by lazy {
        HarvestVegetableController(helper, {
            true
        })
    }


    //这个是
    suspend fun intoGame(): Boolean {
        val t = TimeUtils.getDelayStart()
        if (t > 0) {
            delay(t)
        }
        var flag = true
        var count = 40
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return false
            }
            if (visual.showAnnouncement()) {
                click(constant.closeAnnouncementArea)
            } else if (visual.readStartGame()) {
                click(constant.startGameArea)
            } else if (visual.selectRole()) {
                click(constant.selectRoleArea)
            } else if (visual.isOpenBigMenu()) {
                click(constant.closeBigMenuArea)
            } else if (visual.hasIntoGame()) {

                return true
            }
        }
        return false
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
        Timber.d("${JsonUtil.objectToString(list)} 点击数组有 BaseController NWQ_ 2023/3/10");
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
        return if (list.size > 0) list.toSet().toMutableList() else list//这里进行一次去重
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
        ensureOpenMenuArea(cangkuPosition)
        delay(normalClickInterval)
        if (normal) click(constant.generalWarehouseArea)
        else click(constant.mineralWarehouseArea)

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
            delay(doubleClickInterval)
            theOutCheck()
        }
    }

    suspend fun clickJumpCollectionAddress(index: Int, determine: Boolean = false) {
        ensureOpenPositionMenu()
        var flag = true
        var count = 4
        click(constant.getAddressArea(index), normalClickInterval)
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (!visual.hasPositionMenu() || visual.isSailing()) {
                flag = false
            } else {
                click(constant.getAddressArea(index))
            }
            count--
        }
    }

    suspend fun ensureOpenPositionMenu() {
        var flag = true
        var count = 10
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.isOpenBigMenu()) {
                click(constant.closeBigMenuArea)
            } else if (visual.isOpenWallet()) {
                click(constant.closeWalletArea)
            } else if (visual.isShowDetermine()) {
                click(constant.dialogCancleArea)
            } else if (visual.hasPositionMenu()) {
                if (visual.isClosePositionMenu()) {
                    click(constant.eraseWarningArea)
                } else if (visual.isOpenPositionMenu()) {
                    flag = false
                    if (!visual.isDefaultCoordinateMenu()) click(constant.defaultCoordinateMenuArea)
                }
            } else {
                click(constant.eraseWarningArea)
            }
            if (count == 1) {
                Timber.d("打开失败 ensureOpenPositionMenu BaseController NWQ_ 2023/3/28");
                runSwitch = false
                return
            }
            count--
        }

    }

    suspend fun ensureOpenEyeMenu() {
        var flag = true
        var count = 4
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.isCloseEyesMenu()) {
                click(constant.openEyeMenuArea, normalClickInterval)
            } else {
                flag = false
            }
            count--
        }
    }

    suspend fun ensureCloseEyeMenu() {
        if (visual.isOpenEyesMenu()) {
            click(constant.closeEyeMenuArea, normalClickInterval)
        }
    }


    suspend fun theOutCheck() {
        Timber.d("  theOutCheck BaseController NWQ_ 2023/3/12");
        var flag = true
        var count = 10
        while (flag && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.hasIntoGame()) {
                flag = false
            } else if (visual.hasPositionMenu() && visual.hasRightDialogue()) {
                flag = false
            } else if (visual.isOpenBigMenu()) {
                click(constant.closeBigMenuArea)
            } else if (visual.isOpenWallet()) {
                click(constant.closeWalletArea)
            } else if (visual.isShowDetermine()) {
                click(constant.dialogDetermineArea)
            } else if (visual.isOpenLiaoTian()) {
                click(constant.closeLiaoTianArea)
            } else if (count == 5) {
                pressBackBtn()
            } else if (count <= 0) {
                click(constant.closeBigMenuArea)
                flag = false
                runSwitch = false
            }
            count--
        }
    }

    suspend fun ensureCloseDetermine(): Boolean {
        if (visual.isShowDetermine()) {
            click(constant.dialogDetermineArea)
            return true
        }
        return false
    }

    var maintenanceOpenCount = 3
    var maintenanceTimeStartStamp = 0L
    var MAINTENANCE_INTERVAL = Constant.MINUTE //维修间隔
    suspend fun bloodVolumeMonitoring(
        needCheckOpenList: MutableList<Int>, needCheckCloseList: MutableList<Int>
    ) {
        if (isShieldResistance) {
            if (visual.shieldTooLow()) {
                needCheckOpenList.add(maintenanceDevicePosition)
            }
        } else {
            if (visual.armorTooLow()) {
                needCheckOpenList.add(maintenanceDevicePosition)
            }
        }
    }

    suspend fun needBack(): Boolean {
        return if (isShieldResistance) {
            visual.armorTooLow()
        } else {
            visual.structuralDamage()
        }
    }


    suspend fun ensureOpenLocalList() {
        var flag = true
        var count = 3
        while (flag && count > 0 && runSwitch) {
            takeScreen(doubleClickInterval)
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
                click(constant.isOpenPositionArea)
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
            FindPointByColorTask(constant.localBaseX, 3, 0), listOf(200, 200, 200)
        )?.let {
            hasModifyX = true
            localOffsetX = (it.x - constant.localBaseX.x).toInt()
        }
        var hasModifyY = false
        visual.findPointByColor(
            FindPointByColorTask(constant.localBaseY, 0, 3), listOf(200, 200, 200)
        )?.let {
            hasModifyY = true
            localOffsetY = (it.y - constant.localBaseY.y).toInt()
        }
        Timber.d("hasModifyX:$hasModifyX $localOffsetX  hasModifyY:$hasModifyY $localOffsetY  correctedCoordinate BaseController NWQ_ 2023/3/19");
        return hasModifyX && hasModifyY
    }

    //领取每日礼物
    suspend fun dailyGiftPack() {
        if (TimeUtils.isNewTaskDay(spReo.dailytaskstime)) {
            Timber.d("领取每日礼包 dailyGiftPack BaseController NWQ_ 2023/3/21");
            click(constant.libaoArea1, normalClickInterval)
            click(constant.libaoArea2, tripleClickInterval)
            click(constant.libaoArea3, normalClickInterval)
            takeScreen(doubleClickInterval)
            if (!visual.hasIntoGame()) {
                click(constant.libaoArea3, normalClickInterval)
            }
            spReo.dailytaskstime = System.currentTimeMillis()
        }
    }


    val cangkuPosition = 1
    val JiyuPosition = 2
    val CaiPosition = 3
    suspend fun ensureOpenMenuArea(index: Int) {
        var flag = true
        var count = 10
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.isOpenBigMenu()) {
                when (index) {
                    cangkuPosition -> {
                        if (visual.isOpenStorehouseMenu()) {
                            flag = false
                        }
                    }
                    JiyuPosition -> {
                        if (visual.isOpenJiYuBigMenu()) {
                            flag = false
                        }
                    }
                    CaiPosition -> {
                        if (visual.isOpenVegetableMenu()) {
                            flag = false
                        }
                    }
                }
                if (flag) {
                    click(constant.closeBigMenuArea)
                }
            } else if (visual.isOpenWallet()) {
                click(constant.closeWalletArea)
            } else if (visual.isOpenLeftMenu()) {
                when (index) {
                    cangkuPosition -> {
                        click(constant.leftCangKuMenu)
                    }
                    JiyuPosition -> {
                        click(constant.leftJiYuMenu)
                    }
                    CaiPosition -> {
                        click(constant.leftCaiMenu)
                    }
                }
            } else {
                click(constant.getTopMenuArea(index))
            }
            count--
        }
    }

    //这里处理出战，包括飞点等，这里先只做简单流程
    protected suspend fun outSpaceStation(): Boolean {
        var flag = true
        var count = 10
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return false
            }
            if (visual.hasPositionMenu() && visual.hasEyesMenu()) {
                return true
            } else if (visual.isInSpaceStation()) {
                click(constant.outSpaceArea)
            }
            count--
        }
        return false
    }

    //开始驾驶二号船 默认就只有二个船
    suspend fun changeTrainShip() {
        if (!spReo.transferShip) return
        ensureOpenMenuArea(cangkuPosition)
        //点击机库
        click(constant.jikuArea, tripleClickInterval)
        //第二个船
        click(constant.theTwoArea, doubleClickInterval)
        //点击激活
        click(constant.jiHuoArea, doubleClickInterval)
        delay(quadrupleClickInterval)
        theOutCheck()
    }


    protected fun checkTimeOn(
        nowtime: Long,
        positionList: List<OptSlotInfo>,
        needCheckOpenList: MutableList<Int>,
    ) {
        var lastOpenedTime = 0L
        positionList.forEach { d ->
            if (d.offset == 0) {
                if (nowtime - d.lastOpenedTime > d.interval) {
                    needCheckOpenList.add(d.slotPosition)
                    d.lastOpenedTime = nowtime
                    return
                } else {
                    lastOpenedTime = d.lastOpenedTime
                }
            } else {
                val intervalTime = nowtime - lastOpenedTime
                if (d.offset * d.offsetInterval < intervalTime && intervalTime < (d.offset + 1) * d.offsetInterval && nowtime - d.lastOpenedTime > d.interval) {
                    needCheckOpenList.add(d.slotPosition)
                    d.lastOpenedTime = nowtime
                    return
                }
            }
        }
    }


    //停止船
    protected suspend fun stopShip() {
        click(constant.stopShipArea)
        click(constant.stopShipArea, doubleClickInterval)
    }


    protected suspend fun switchEyesMenu(index: Int) {
        ensureOpenEyeMenu()
        var flag = true
        var count = 4
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return
            }
            if (visual.isOpenCheckRightMenu()) {
                flag = false
            }
            count--
        }
        flag = true
        count = 4
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return
            }
            if (!visual.isOpenCheckRightMenu()) {
                flag = false
            } else {
                click(constant.switchEyesMenuItemArea(index))
            }
            count--
        }

    }

    //副本选择重要目标
    protected suspend fun selectRightImportTarget() {
        switchEyesMenu(4)
    }

    //副本选择撤离目标
    protected suspend fun selectRightEvacuationTarget() {
        switchEyesMenu(5)
    }


}
