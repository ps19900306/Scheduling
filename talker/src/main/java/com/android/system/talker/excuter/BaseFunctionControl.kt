package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import android.graphics.Bitmap
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.click.SlidingArea
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.expand.isLandscape
import com.android.schedule.corelibrary.img.img_rule.ImgTask
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
import com.android.system.talker.enums.MenuType
import com.android.system.talker.enums.ShipType
import com.android.system.talker.enums.WarehouseType
import kotlinx.coroutines.delay

abstract class BaseFunctionControl(
    val userDb: UserDb,
    val dataBase: AppDataBase,
    acService: AccessibilityService,
    private val onEnd: (succes: Boolean) -> Unit,
) : TurnBaseController(acService) {


    abstract suspend fun getTag(): String

    abstract suspend fun startFunction()

    fun reportingError(string: String) {
        runSwitch = false
        onEnd.invoke(false)
    }

    override fun end() {
        super.end()
        onEnd.invoke(true)
    }


    val en = StarWarEnvironment()


    protected suspend fun intoGame(): Boolean {
        var flag = true
        var count = 20
        while (flag && count > 0 && runSwitch) {
            val bitmap = takeScreen(screenshotInterval)
            if (bitmap.isLandscape()) {
                delay(tripleClickInterval)
                if (en.isLoadingGameT.check()) {
                } else if (en.isAnnouncementT.check()) {
                    click(en.isAnnouncementT, en.closeAnnouncementArea)
                } else if (en.isUpdateGameT.check()) {
                    click(en.isUpdateGameT, en.updateGameArea)
                    delay(tripleClickInterval)
                } else if (en.isStartGameT.check()) {
                    click(en.isStartGameT, en.isStartGameArea)
                } else if (en.isSelectRoleT.check()) {
                    click(en.isSelectRoleT, en.selectRoleArea)
                } else if (en.isOpenBigMenuT.check()) {
                    click(en.isOpenBigMenuT, en.closeBigMenuArea)
                } else if (hasIntoGame(bitmap)) {
                    flag = false
                }
            } else {//这里没有横屏所以
                click(getAppArea())
                delay(tripleClickInterval)
                count--
            }
        }
        if (flag) {
            reportingError("${getTag()} intoGame")
        }
        return !flag
    }


    private suspend fun hasIntoGame(bitmap: Bitmap? = screenBitmap): Boolean {
        if (bitmap == null) return false
        return (en.isClosePositionMenuT.check() || en.isOpenPositionMenuT.check() && (en.isInSpaceStationT.check() || en.isOpenEyeMenuT.check() || en.isCloseEyeMenuT.check()))
    }

    protected suspend fun hasTaskDialogBox(): Boolean {
        return (en.isShowLeftDialogBox.check() || en.isShowLeftDialogBox.check())
    }

    protected suspend fun isInSailing(bitmap: Bitmap?): Boolean {
        if (bitmap == null) return false
        return (en.isOpenPositionMenuT.check() || en.isSailingT.check())
    }


    fun getAppArea(): ClickArea {
        return ClickArea(
            82 + (userDb.appLocationX - 1) * 254, 185 + (userDb.appLocationY - 1) * 291, 154, 153
        )
    }

    suspend fun returnSpaceStation(position: Int): Boolean {
        var flag = true
        val maxCount = 3
        var count = maxCount
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            if (en.isInSpaceStationT.check()) {
                return true
            }
            if (en.isConfirmDialogTask.check()) {
                click(en.confirmDialogEnsureArea)
            } else if (en.isClosePositionMenuT.check()) {
                if (en.isOneClickClaimTask.check()) {
                    en.closeOneClickArea.c(en.isOneClickClaimTask)
                }
                if (!clickPositionMenu(position)) {
                    reportingError("${getTag()} returnSpaceStation clickPositionMenu")
                    return false
                }
                count--
            }
        }
        if (flag) {
            reportingError("${getTag()} returnSpaceStation")
        }
        return !flag
    }


    protected suspend fun clickPositionMenu(index: Int): Boolean {
        if (!openPositionMenu()) {
            return false
        }
        click(en.getPositionArea(index))
        return true
    }


    //确保打开左边的位置菜单
    protected suspend fun openPositionMenu(): Boolean {
        if (en.isOpenPositionMenuT.check())
            return true
        return theOutCheck() && optTaskOperation(
            pTask = en.isClosePositionMenuT,
            clickArea = en.openPositionArea,
            eTask = en.isOpenPositionMenuT
        )
    }

    protected suspend fun theOutCheck(): Boolean {
        var flag = true
        var count = 20
        while (flag && count > 0 && runSwitch) {
            if (taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            if (hasIntoGame()) {
                flag = false
            } else if (en.isOpenBigMenuT.check()) {
                click(en.closeBigMenuArea)
            } else if (en.isConfirmDialogTask.check()) {
                click(en.confirmDialogCancelArea)
            } else if (en.isCanCollectGiftT.check()) {
                click(en.closeCollectGiftArea)
            } else if (count == 5) {
                pressBackBtn()
            }
            count--
        }
        return !flag
    }

    protected suspend fun checkShip(shipType: Int): Boolean {
        if (userDb.shipType == shipType) {
            return true
        }


        //先打开船仓库
        var result = ensureOpenShipWarehouse()
        if (!result) {
            return false
        }

        //找到需要换船的位置
        val shipLocation = queryShipLocation(shipType)
        if (shipLocation < 0) {//这里表示没有找到船
            return false
        } else if (shipLocation == 0) {//表示一开始位置就正确的
            userDb.shipType = shipType
            dataBase.getUserDao().update(userDb)
            return true
        }

        //这里点击飞船的位置
        en.getShipArea(shipLocation).c()

        //这里点击激活
        if (en.isActivationShipTask.check()) {
            click(
                en.activationShipArea,
                en.isActivationShipTask.getOffsetX(),
                en.isActivationShipTask.getOffsetY()
            )
        }

        //这里可以进行校验
        delay(tripleClickInterval)
        return if (en.isActivationLocationList[shipLocation].check()) {
            userDb.shipType = shipType
            dataBase.getUserDao().update(userDb)
            true
        } else {
            false
        }
    }

    private suspend fun queryShipLocation(shipType: Int): Int {
        when (shipType) {
            ShipType.TASK_SHIP, ShipType.ABNORMAL_SHIP -> {
                en.isJiYuShipList.forEachIndexed { index, imgTaskImpl1 ->
                    if (imgTaskImpl1.check()) {
                        return index
                    }
                }
            }

            ShipType.VEGETABLE_SHIP -> {
                en.isVegetableShipList.forEachIndexed { index, imgTaskImpl1 ->
                    if (imgTaskImpl1.check()) {
                        return index
                    }
                }
            }

            ShipType.MINING_SHIP -> {

            }
        }
        return -1
    }


    protected suspend fun ensureOpenBigMenuArea(@MenuType index: Int): Boolean {
        var flag = true
        var count = 10
        while (flag && count > 0 && runSwitch) {
            if (taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            if (en.isOpenBigMenuT.check()) {
                when (index) {
                    MenuType.WAREHOUSE -> {
                        if (en.isOpenWarehouseBigMenuTask.check()) {
                            flag = false
                        } else {
                            en.closeBigMenuArea.c()
                        }
                    }

                    MenuType.TASK -> {
                        if (en.isOpenJiyuBigMenuTask.check()) {
                            flag = false
                        } else {
                            en.closeBigMenuArea.c()
                        }
                    }

                    MenuType.PLANETARY_MINE -> {
                        if (en.isOpenCaiBigMenuTask.check()) {
                            flag = false
                        } else {
                            en.closeBigMenuArea.c()
                        }
                    }

                    MenuType.AGREEMENT -> {
                        if (en.isOpenAgreementTask.check()) {
                            flag = false
                        } else {
                            en.closeBigMenuArea.c()
                        }
                    }

                    MenuType.GAME_ACTIVITY -> {
                        if (en.isOpenGameActivityTask.check()) {
                            flag = false
                        } else {
                            en.closeBigMenuArea.c()
                        }
                    }

                }
            } else if (en.isOpenMenuMenu.check()) {//这里点开了打菜单
                when (index) {
                    MenuType.WAREHOUSE -> {
                        en.openWarehouseMenuArea.c()
                    }

                    MenuType.TASK -> {
                        en.openTaskMenuArea.c()
                    }

                    MenuType.PLANETARY_MINE -> {
                        en.openPlanetaryMenuArea.c()
                    }

                    MenuType.AGREEMENT -> {
                        en.openAgreementMenuArea.c()
                    }

                    MenuType.GAME_ACTIVITY -> {
                        en.openActivityMenuArea.c()
                    }
                }
            } else {
                if (userDb.shortcutMenu1 == index && en.isOpenPositionMenuT.check() || en.isClosePositionMenuT.check()) {
                    en.getQuickMenuArea(0).c()
                } else if (userDb.shortcutMenu2 == index && en.isOpenPositionMenuT.check() || en.isClosePositionMenuT.check()) {
                    en.getQuickMenuArea(1).c()
                } else if (userDb.shortcutMenu3 == index && en.isOpenPositionMenuT.check() || en.isClosePositionMenuT.check()) {
                    en.getQuickMenuArea(2).c()
                } else if (userDb.shortcutMenu4 == index && en.isOpenPositionMenuT.check() || en.isClosePositionMenuT.check()) {
                    en.getQuickMenuArea(3).c()
                } else {
                    //这里点击
                    en.openMenuMenuArea.c()
                }
            }
            count--
        }
        return !flag
    }


    //这个事打开仓库的一个子类型
    suspend fun ensureOpenShipWarehouse(): Boolean {
        //先打开仓库
        var result = ensureOpenBigMenuArea(MenuType.WAREHOUSE)
        if (!result) {
            return false
        }

        var flag = true
        var count = 10
        while (flag && count > 0 && runSwitch) {
            if (taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            if (en.isShipWarehouseTask.check()) {
                en.shipWarehouseArea.c()
                flag = false
            } else if (en.isSpaceStationWarehouseTask.check()) {
                if (en.isCloseSpaceStationWarehouseTask.check()) {
                    en.switchSpaceStationWarehouseArea.c()
                }
            } else if (en.isInSpaceStationT.check()) {
                result = ensureOpenBigMenuArea(MenuType.WAREHOUSE)
                if (!result) {
                    return false
                }
            } else {//这里需要往下滑动
                en.swipeWarehouseDown.c()
            }
            count--
        }

        return !flag
    }


    suspend fun ensureOpenWarehouseType(@WarehouseType type: Int): Boolean {
        //先打开仓库
        var result = ensureOpenBigMenuArea(MenuType.WAREHOUSE)
        if (!result) {
            return false
        }

        var flag = true
        var count = 10
        while (flag && count > 0 && runSwitch) {
            if (taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            when (type) {
                WarehouseType.STATION_GOODS -> {
                    if(en.isStationGoodsCheckTask.check()){
                        flag = false
                    }else if (en.isStationGoodsTask.check()){
                        en.stationGoodsArea.c(en.isStationGoodsTask)
                        flag = false
                    }
                }

                WarehouseType.STATION_SHIPS -> {
                    if(en.isStationShipCheckTask.check()){
                        flag = false
                    }else if (en.isStationShipTask.check()){
                        en.stationShipArea.c(en.isStationGoodsTask)
                        flag = false
                    }
                }

                WarehouseType.SHIP_CABIN,WarehouseType.SHIP_SPECIAL -> {
                    if(en.isStationShipCheckTask.check()){

                    }
                }
            }

            if (en.isShipWarehouseTask.check()) {
                en.shipWarehouseArea.c()
                flag = false
            } else if (en.isSpaceStationWarehouseTask.check()) {
                if (en.isCloseSpaceStationWarehouseTask.check()) {
                    en.switchSpaceStationWarehouseArea.c()
                }
            } else if (en.isInSpaceStationT.check()) {
                result = ensureOpenBigMenuArea(MenuType.WAREHOUSE)
                if (!result) {
                    return false
                }
            } else {//这里需要往下滑动
                en.swipeWarehouseDown.c()
            }
            count--
        }

        return !flag
    }


    suspend fun ensureCloseDetermine(): Boolean {
        if (en.isConfirmDialogTask.check()) {
            en.confirmDialogEnsureArea.c()
            return true
        }
        return false
    }


    suspend fun ClickArea.c() {
        click(this)
    }

    suspend fun ClickArea.c(task: ImgTask) {
        click(task, this)
    }

    suspend fun SlidingArea.c() {
        optClickTask(this.toClickTask())
    }


    suspend fun unloadingCargo(normal: Boolean = true) {

        // CoordinateArea
//        delay(normalClickInterval)
//        if (normal) click(constant.generalWarehouseArea)
//        else click(constant.mineralWarehouseArea)
//
//        delay(doubleClickInterval)
//        takeScreen()
//        if (visual.isEmptyWarehouse()) {
//            theOutCheck()
//        } else {
//            click(constant.warehouseSelectAllArea)
//            delay(normalClickInterval)
//            click(constant.warehouseMoveArea)
//            delay(normalClickInterval)
//            click(constant.warehouseAllArea)
//            delay(doubleClickInterval)
//            theOutCheck()
//        }
    }
}