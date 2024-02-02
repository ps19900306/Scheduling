package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import android.graphics.Bitmap
import com.android.schedule.corelibrary.SetConstant
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.controller.ClickSpeedControl
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.expand.isLandscape
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.NwqCallBack
import com.android.schedule.corelibrary.utils.TimeUtils
import com.android.schedule.corelibrary.xiaomi.XiaoMiEnvironment
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
import com.android.system.talker.enums.ActivityType
import com.android.system.talker.enums.MenuType
import com.android.system.talker.enums.ShipType
import com.android.system.talker.enums.WarehouseType
import kotlinx.coroutines.delay

abstract class BaseFunctionControl(
    val userDb: UserDb,
    val dataBase: AppDataBase,
    acService: AccessibilityService,
) : TurnBaseController(acService) {

    private var onEnd: NwqCallBack<Boolean>? = null
    protected val ABNORMAL_SCREENO_ORIENTATION = "屏幕方向异常"
    protected val ABNORMAL_CAN_CLONE = "不能进行克隆"
    fun setOnEnd(end: NwqCallBack<Boolean>) {
        onEnd = end
    }


    abstract suspend fun endGame(eroMsg: String? = "")

    abstract suspend fun getTag(): String

    abstract suspend fun startFunction()

    abstract suspend fun getBaseCloneLocation(): Int

    private var hasResult = true

    var optReuslt = true
    suspend fun reportingError(string: String) {
        runSwitch = false
        if (hasResult) {
            L.d(string)
            optReuslt = false
            endGame(string)
            hasResult = false
            onEnd?.onCallBack(false)
        }
    }

    override suspend fun end() {
        theOutCheck()
        super.end()
        runSwitch = false
        if (hasResult) {
            endGame("")
            hasResult = false
            onEnd?.onCallBack(true)
        }
    }


    val en = StarWarEnvironment()


    protected suspend fun intoGame(): Boolean {
        var flag = true
        var count = 200


        val clickSpeedControl = ClickSpeedControl()
        clickSpeedControl.addUnit(en.hasXiaoTipsTask, en.hasXiaoTipsTask.clickArea!!)
        clickSpeedControl.addUnit(en.isAnnouncementT, en.closeAnnouncementArea)
        clickSpeedControl.addUnit(en.isUpdateGameT, en.updateGameArea)
        clickSpeedControl.addUnit(en.isStartGameT, en.isStartGameArea)
        clickSpeedControl.addUnit(en.isSelectRoleT, en.selectRoleArea)
        clickSpeedControl.addUnit(en.isOpenBigMenuT, en.closeBigMenuArea)
        clickSpeedControl.addUnit(en.isXiaoVipTipsTask, en.isXiaoVipTipsArea)

        clickSpeedControl.maxCount = 10

        while (flag && count > 0 && runSwitch) {
            val bitmap = takeScreen(screenshotIntervalF)
            if (bitmap.isLandscape()) {
                delay(TimeUtils.getDelayStart())
                if (hasIntoGame()) {
                    flag = false
                } else if (en.isLoadingGameT.check()) {

                } else {
                    clickSpeedControl.cc()
                }
            } else {//这里没有横屏所以
                if (XiaoMiEnvironment.isHomeGameCenterTask.check() || XiaoMiEnvironment.isHomeGameCenter2Task.check()) {
                    click(getAppArea())
                    delay(tripleClickInterval)
                } else {
                    pressHomeBtn()
                    delay(tripleClickInterval)
                }
            }
            count--
        }
        if (flag) {
            reportingError("${getTag()} intoGame")
        }
        return !flag
    }


    protected suspend fun hasIntoGame(): Boolean {
        return (en.isClosePositionMenuT.check() || en.isOpenPositionMenuT.check()) && (en.isInSpaceStationT.check() || en.isOpenEyeMenuT.check() || en.isCloseEyeMenuT.check())
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
        val isInSpace = en.isInSpaceStationT.toStatusRecorder(3)
        val isOpenBigMenu = en.isOpenBigMenuT.toStatusRecorder(5)
        val isClosePosition = en.isClosePositionMenuT.toStatusRecorder(5, 20)
        val isOpenPosition = en.isOpenPositionMenuT.toStatusRecorder(30, 80)
        val isHasEyeMenu = en.isHasEyeMenuMT.toStatusRecorder(3, 60)
        val isConfirmDialog = en.isConfirmDialogTask.toStatusRecorder(3)
        val isOneClickClaim = en.isOneClickClaimTask.toStatusRecorder(3)//这个是收菜的
        val isOnlyOpenPosition = en.isOnlyOpenPositionMenuTask.toStatusRecorder(5)//这里表表示并没有开始导航


        var flag = true
        var count = 20 * 10
        var clickArea: ClickArea? = null
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            updateStatusRecorder(
                isInSpace,
                isOpenBigMenu,
                isClosePosition,
                isHasEyeMenu,
                isConfirmDialog,
                isOneClickClaim,
                isOpenPosition,
                isOnlyOpenPosition
            )
            if (isInSpace.isOpenTrustThresholds()) {
                return true
            }


            if (isConfirmDialog.isOpenTrustThresholds()) {
                en.confirmDialogEnsureArea.c(en.isConfirmDialogTask, repeatedClickInterval)
            } else if (isOneClickClaim.isOpenTrustThresholds()) {
                en.closeOneClickArea.c(en.isOneClickClaimTask, repeatedClickInterval)
            } else if (isOpenBigMenu.isOpenTrustThresholds()) {
                en.closeBigMenuArea.c(repeatedClickInterval)
            } else if (isClosePosition.isOpenTrustThresholds() && isHasEyeMenu.isOpenTrustThresholds()) {
                clickPositionMenu(position)
            } else if (isOnlyOpenPosition.isOpenTrustThresholds() && isHasEyeMenu.isOpenTrustThresholds()) {
                if (clickArea == null) {
                    clickArea = en.getPositionArea(position)
                }
                clickArea.c(SetConstant.MINUTE)
            } else if (isOpenPosition.isOpenErrorThresholds() && isHasEyeMenu.isOpenErrorThresholds()) {
                if (clickArea == null) {
                    clickArea = en.getPositionArea(position)
                }
                isOpenPosition.clearUp()
                clickArea.c(SetConstant.MINUTE)
            }
            count--
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
        if (en.isOpenPositionMenuT.check()) return true
        theOutCheck()
        val result= optTaskOperation(
            pTask = en.isClosePositionMenuT,
            clickArea = en.openPositionArea,
            eTask = en.isOpenPositionMenuT
        )
        if(result){
            delay(jumpClickInterval)
        }
        return result
    }

    protected suspend fun theOutCheck(): Boolean {
        var flag = true
        var count = 20

        val clickSpeedControl = ClickSpeedControl()
        clickSpeedControl.addUnit(en.isOpenBigMenuT, en.closeBigMenuArea)
        clickSpeedControl.addUnit(en.isConfirmDialogTask, en.confirmDialogCancelArea)
        clickSpeedControl.addUnit(en.isCanCollectGiftT, en.closeCollectGiftArea)
        clickSpeedControl.addUnit(en.isOneClickClaimTask, en.closeOneClickArea)
        clickSpeedControl.addUnit(en.isOpenHuodongBigMenuTask, en.closeBigMenuArea)
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (hasIntoGame()) {
                flag = false
            } else {
                clickSpeedControl.cc()
            }
            count--
        }
        return !flag
    }

    protected suspend fun checkShip(shipType: Int): Boolean {
        if (userDb.shipType == shipType) {
            return true
        }

        L.d("changeShip")
        //先打开船仓库
        var result = ensureOpenWarehouseType(WarehouseType.STATION_SHIPS)
        if (!result) {
            L.d("打开船库失败")
            return false
        }

        //找到需要换船的位置
        val shipLocation = queryShipLocation(shipType)
        if (shipLocation < 0) {//这里表示没有找到船
            L.d("沒有找到船")
            return false
        } else if (shipLocation == 0) {//表示一开始位置就正确的
            L.d("正在在一號位置")
            userDb.shipType = shipType
            dataBase.getUserDao().update(userDb)
            return true
        }


        L.d("准备更换飞船")
        var flag = true
        var count = 5
        var hasClick = false
        val clickSpeedControl = ClickSpeedControl()
        clickSpeedControl.addUnit(en.isActivationShipTask, en.activationShipArea)
        clickSpeedControl.addUnit(en.isOpenWarehouseBigMenuTask, en.getShipArea(shipLocation))
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (hasClick && en.isOpenWarehouseBigMenuTask.check() && (queryShipLocation(shipType) == 0 || en.isActivationLocationList[shipLocation].check() || en.isActivationLocationList[shipLocation - 1].check())) {
                userDb.shipType = shipType
                dataBase.getUserDao().update(userDb)
                L.d("飞船成功")
                flag = false
            } else if (en.isActivationShipTask.check()) {
                hasClick = true
                //点击船的位置
                L.d("点击船的位置")
                en.activationShipArea.c(en.isActivationShipTask)
            } else {
                clickSpeedControl.cc()
            }
            count--
        }
        return !flag
    }

    private suspend fun queryShipLocation(shipType: Int): Int {
        var flag = true
        var count = 3
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                runSwitch = false
                return -1
            }
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
                    en.isVegetableShipList2.forEachIndexed { index, imgTaskImpl1 ->
                        if (imgTaskImpl1.check()) {
                            return index
                        }
                    }
                }

                ShipType.MINING_SHIP -> {

                }
            }
            count--
        }
        return -1
    }


    protected suspend fun ensureOpenBigMenuArea(@MenuType index: Int): Boolean {
        var flag = true
        var count = 6
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
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
                if (userDb.shortcutMenu1 == index && hasPositionMenu()) {
                    en.getQuickMenuArea(0).c()
                } else if (userDb.shortcutMenu2 == index && hasPositionMenu()) {
                    en.getQuickMenuArea(1).c()
                } else if (userDb.shortcutMenu3 == index && hasPositionMenu()) {
                    en.getQuickMenuArea(2).c()
                } else if (userDb.shortcutMenu4 == index && hasPositionMenu()) {
                    en.getQuickMenuArea(3).c()
                } else {
                    en.openMenuMenuArea.c()
                }
            }
            count--
        }
        return !flag
    }

    protected suspend fun hasPositionMenu(): Boolean {
        return en.isOpenPositionMenuT.check() || en.isClosePositionMenuT.check()
    }


    suspend fun ensureOpenWarehouseType(@WarehouseType type: Int): Boolean {
        //先打开仓库
        var result = ensureOpenBigMenuArea(MenuType.WAREHOUSE)
        if (!result) {
            L.d("打开仓库失败")
            return false
        }

        var flag = true
        var findTraget = false
        var count = 7
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            when (type) {
                WarehouseType.STATION_GOODS -> {
                    if (en.isStationGoodsCheckTask.check()) {
                        return true
                    } else if (en.isStationGoodsTask.check()) {
                        en.stationGoodsArea.c(en.isStationGoodsTask)
                        return true
                    }
                }

                WarehouseType.STATION_SHIPS -> {
                    if (en.isStationShipCheckTask.check()) {
                        return true
                    } else if (en.isStationShipTask.check()) {
                        en.stationShipArea.c(en.isStationShipTask)
                        return true
                    }
                }

                WarehouseType.SHIP_CABIN -> {
                    if (en.isShipWarehouseSelectTask.check()) {
                        return true
                    } else if (en.isShipWarehouseTask.check()) {
                        en.shipWarehouseArea.c(en.isShipWarehouseTask)
                        return true
                    }
                }

                WarehouseType.SHIP_SPECIAL -> {
                    if (en.isShipWarehouseTask.check()) {
                        if (!en.isShipWarehouseCloseTask.copyOffset(en.isShipWarehouseTask)
                                .check()
                        ) {
                            en.switchSpecialArea.c(en.isShipWarehouseTask)
                            return true
                        } else {
                            findTraget = true
                            en.specialArea.c(en.isShipWarehouseTask)
                        }

                    }
                }
            }

            if (!findTraget) {
                if (count >= 4) {
                    //这里前二次先不滑动
                } else if (count >= 2) {
                    if (type <= WarehouseType.STATION_SHIPS) {
                        en.swipeWarehouseDown.c()
                        delay(jumpClickInterval)
                    } else {
                        en.swipeWarehouseTop.c()
                        delay(jumpClickInterval)
                    }
                } else {
                    if (type <= WarehouseType.STATION_SHIPS) {
                        en.swipeWarehouseTop.c()
                        delay(jumpClickInterval)
                    } else {
                        en.swipeWarehouseDown.c()
                        delay(jumpClickInterval)
                    }
                }
            }
            count--
        }
        return !flag
    }

    suspend fun ensureOpenActivityType(@ActivityType type: Int): Boolean {
        //先打开仓库
        var result = ensureOpenBigMenuArea(MenuType.GAME_ACTIVITY)
        if (!result) {
            L.d("打开活动界面失败")
            return false
        }
        var hasFind = false
        var flag = true
        var count = 6
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }

            //这里是结束循环的判断
            when (type) {
                ActivityType.LOGIN_GIFT -> {
                    if (en.isQuickClaimTask.check()) {
                        L.d("找到每日礼物")
                        return true
                    }
                }

                ActivityType.CHENG_NIAN_LI -> {
                    if (en.isOpenChenNianLiMenuTask.check()) {
                        L.d("成年里")
                        return true
                    }
                }
            }

            //找到菜单的点击位置
            when (type) {
                ActivityType.LOGIN_GIFT -> {
                    if (en.isSupplyMaterialsTask.check()) {
                        L.d("找到活动物资位置")
                        hasFind = true
                        count = 4
                        en.supplyMaterialsArea.c(en.isSupplyMaterialsTask)
                        delay(jumpClickInterval)
                    }
                }

                ActivityType.CHENG_NIAN_LI -> {
                    if (en.isChenNianLiTask.check()) {
                        L.d("成年里位置")
                        hasFind = true
                        count = 4
                        en.ChenNianLiBtnArea.c(en.isChenNianLiTask)
                        delay(jumpClickInterval)
                    }
                }
            }

            if (hasFind) {

            } else if (count <= 2) {
                L.d("向下滑动")
                en.activityMenuSlideBottom.c()
                delay(jumpClickInterval)
            } else if (count <= 4) {
                L.d("向上滑动")
                en.activityMenuSlideTop.c()
                delay(jumpClickInterval)
            }
            count--
        }
        return !flag
    }

    suspend fun ensureCloseDetermine(): Boolean {
        if (en.isConfirmDialogTask.check()) {
            en.confirmDialogEnsureArea.c(en.isConfirmDialogTask)
            return true
        }
        return false
    }


    suspend fun unloadingCargo(@WarehouseType flag: Int) {
        if (flag and WarehouseType.SHIP_CABIN == WarehouseType.SHIP_CABIN) {
            ensureOpenWarehouseType(WarehouseType.SHIP_CABIN)
            delay(clickInterval)
            unloadingGoods()
        }

        if (flag and WarehouseType.SHIP_SPECIAL == WarehouseType.SHIP_SPECIAL) {
            ensureOpenWarehouseType(WarehouseType.SHIP_SPECIAL)
            delay(clickInterval)
            unloadingGoods()
        }
    }

    private suspend fun unloadingGoods(): Boolean {
        var flag = true
        var count = 5
        var complete = false
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isEmptyWarehouseTask.check()) {
                flag = false
            } else if (en.isOpenWarehouseBigMenuTask.check()) {
                if (complete) {
                    flag = false
                } else {
                    en.warehouseSelectAllArea.c()
                }
            } else if (en.isShowMoveToTask.check()) {
                en.moveToArea.c(en.isShowMoveToTask)
                delay(jumpClickInterval)
                en.moveToStationGoodsArea.c()
                delay(jumpClickInterval * 2)
                complete = true
            } else if (complete && !en.isShowMoveToTask.check()) {
                en.moveToStationGoodsArea.c()
                delay(jumpClickInterval)
            }
            count--
        }
        return !flag
    }


    suspend fun exitGame(): Boolean {
        theOutCheck()
        //先进行游戏退出
        var flag = true
        var count = 5
        while (flag && count > 0) {
            val bitmap = takeScreen(screenshotInterval)
            if (bitmap.isLandscape()) {
                if (en.exitGameTask.check()) {
                    L.d("退出操作")
                    en.exitGameTask.lastResult?.let {
                        it.clickArea?.c(it)
                        delay(jumpClickInterval)
                    }
                } else if (hasIntoGame()) {
                    L.d("退出点击回退")
                    pressBackBtn()
                    delay(jumpClickInterval)
                }
            } else {
                return true
            }
            count--
        }

        //这里进行游戏的切换
        flag = true
        count = 5
        while (flag && count > 0) {
            val bitmap = takeScreen(screenshotInterval)
            if (bitmap.isLandscape()) {
                pressHomeBtn()
            } else {
                return false
            }
        }

        return false
    }


    //改变克隆点位置
    protected suspend fun checkCloneLocation(menuPosition: Int, clonePosition: Int): Boolean {
        L.d("检查克隆位置")
        if (userDb.baseCloneLocation == clonePosition) {
            L.d("克隆位置一致")
            return true
        }
        //先回空间站
        if (!returnSpaceStation(userDb.baseMenuLocation)) return false


        //这里是离开船
        if (!leaveShip()) return false

        //如果是基地就出去自毁，不然就进行远克隆
        if (clonePosition == SetConstant.BASE_CLONE_LOCATION) {
            outSelfExplosion()
        } else {
            remoteClone(clonePosition)
            userDb.lastChangeLocationTime = System.currentTimeMillis()
        }


        //这里保存结果
        userDb.baseCloneLocation = clonePosition
        userDb.baseMenuLocation = menuPosition
        userDb.shipType = ShipType.UNKNOWN
        dataBase.getUserDao().update(userDb)
        return true
    }


    protected suspend fun leaveShip(): Boolean {
        var hasClickLive = false
        var flag = true
        var count = 10
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            //已经打开船菜单
            if (en.isOpenShipMenuTask.check()) {
                val isShowLeaveTask = en.isShowLeaveTask.copyOffset(
                    en.isShowLeaveTask.tag,
                    en.isOpenShipMenuTask.getOffsetX(),
                    en.isOpenShipMenuTask.getOffsetY()
                )
                if (isShowLeaveTask.check()) {
                    optClickTask(
                        en.clickLeveShipArea.toClickTask(
                            0,
                            en.isOpenShipMenuTask.getOffsetX(),
                            en.isOpenShipMenuTask.getOffsetY()
                        )
                    )
                    count = 5
                    hasClickLive = true
                    delay(jumpClickInterval)
                } else {
                    flag = false
                }
            } else if (en.isInSpaceStationT.check()) {
                if (hasClickLive) {
                    flag = false
                } else if (count % 2 == 0) {
                    en.clickShip2Area.c()
                } else {
                    en.openShipVolume.c()
                }
            }
            count--
        }
        return !flag
    }


    //这个表示是蛋的情况下出船自毁
    protected suspend fun outSelfExplosion(): Boolean {
        var flag = true
        var count = 10
        var hasClickExplosion = false
        var hasOpenShipVolume = false
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            if (en.isInSpaceStationT.check()) {
                if (hasClickExplosion) {
                    flag = false
                } else {
                    en.outSpaceArea.c()
                    delay(tripleClickInterval)
                }
            } else if (isInSpace()) {//这里判断是在太空中
                if (!hasOpenShipVolume) {
                    hasOpenShipVolume = true
                    val max = (Math.random() * 2 + 2).toInt()
                    for (i in 0..max) {
                        en.openShipVolume.c()
                        delay(clickInterval)
                    }
                }


                if (en.isOpenShipMenu2Task.check()) { //这里判断是否打开飞船菜单
                    val task = en.isShowExplosionTask.copyOffset(
                        en.isShowExplosionTask.tag,
                        en.isOpenShipMenu2Task.getOffsetX(),
                        en.isOpenShipMenu2Task.getOffsetY()
                    )
                    if (task.check()) {
                        en.clickSelfExplosionArea.c(en.isOpenShipMenu2Task)

                        taskScreenL(jumpClickInterval)
                        if (en.isConfirmDialogTask.check()) {
                            en.confirmDialogEnsureArea.c(en.isConfirmDialogTask)
                        }

                        taskScreenL(jumpClickInterval)
                        if (en.isConfirmDialogTask.check()) {
                            en.confirmDialogEnsureArea.c(en.isConfirmDialogTask)
                        }

                        hasClickExplosion = true
                        delay(((2.5 + Math.random()) * SetConstant.MINUTE).toLong())
                    }
                } else if (count % 2 == 0) {
                    en.clickShip2Area.c()
                } else {
                    en.openShipVolume.c()
                }
            }
            count--
        }
        return !flag
    }

    protected suspend fun remoteClone(position: Int): Boolean {
        var flag = true
        var count = 19
        var hasClickClone = false
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            if (en.isInSpaceStationT.check()) {
                if (hasClickClone) {
                    flag = false
                } else if (en.isCloneCenterTask.check()) {
                    en.cloneCenterArea.c(en.isCloneCenterTask)
                    delay(clickInterval)
                } else if (count % 5 == 0) {//这里多次每找到需要进行滑动
                    en.cloneCenterSlide.c()
                    delay(jumpClickInterval)
                }
            } else if (en.isOpenCloneMenuTask.check()) {
                if (position <= 2) {
                    en.getCloneClickArea(position).c()
                    delay(clickInterval)
                } else if (en.isCloneListTask.check()) {
                    if (en.isCloneListTask.getOffsetY() < 10) {
                        en.getCloneClickArea(position).c(en.isCloneListTask)
                    } else {
                        en.swipeCloneListTArea.c()
                    }
                    delay(clickInterval)
                }
            } else if (en.isConfirmDialogTask.check()) {
                en.confirmDialogEnsureArea.c(en.isConfirmDialogTask)
                hasClickClone = true
                delay(tripleClickInterval)
            }
            count--
        }
        return !flag
    }


    protected suspend fun outSpaceStation(): Boolean {
        var flag = true
        var count = 5
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                runSwitch = false
                return false
            }
            if (isInSpace()) {
                flag = false
            } else if (en.isInSpaceStationT.check()) {
                en.outSpaceArea.c()
                delay(tripleClickInterval)
            } else if (en.isConfirmDialogTask.check()) {
                en.confirmDialogEnsureArea.c()
            }
            count--
        }
        return !flag


    }

    protected suspend fun isInSpace(): Boolean {
        return ((en.isClosePositionMenuT.check() || en.isOpenPositionMenuT.check()) && (en.isOpenEyeMenuT.check() || en.isCloseEyeMenuT.check()))
    }


    protected suspend fun hasTopLockTart(): Boolean {
        return null != en.topLockTargetList1.find { it.check() }
    }

    protected suspend fun hasBottomDeviceOpen(): Boolean {
        return null != en.bottomDeviceList.find { it.check() }
    }


    var lastLianLuoTime = 0L;

    //水龙年的l
    suspend fun linQuLianLuo() {
        if (System.currentTimeMillis() - lastLianLuoTime < SetConstant.Hour) {
            return
        }
        lastLianLuoTime = System.currentTimeMillis()
        var flag = true
        var count = 20
        val clickSpeedControl = ClickSpeedControl()
        clickSpeedControl.maxCount = 1
        clickSpeedControl.addUnit(en.isJieShouTask, en.jieShouArea)
        clickSpeedControl.addUnit(en.isShowLeftDialogBox, en.leftDialogArea)
        clickSpeedControl.addUnit(en.isShowRightDialogBox, en.rightDialogArea)
        clickSpeedControl.addUnit(en.isConfirmDialogTask, en.confirmDialogCancelArea)
        clickSpeedControl.addUnit(en.findLianLuoAnBtnTask, en.lianLuoAnBtnArea)
        clickSpeedControl.addUnit(en.isOpenJiyuBigMenuTask, en.closeBigMenuArea)
        clickSpeedControl.addUnit(en.isJieShouHuoDongTask, en.jieShouHuoDongArea)

        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (hasIntoGame()) {
                if (en.isHasGiftBtnTask.check()) {
                    if (ensureOpenActivityType(ActivityType.CHENG_NIAN_LI)) {
                        if (en.findLianLuoAnBtnTask.check()) {
                            en.lianLuoAnBtnArea.c(en.findLianLuoAnBtnTask)
                            delay(clickInterval)
                            count = 40
                        } else {
                            flag = false
                        }
                    }
                } else {
                    en.leftDialogArea.c()
                }
            } else if (en.isHuoBigDialogTask.check() && !en.isOpenJiyuBigMenuTask.check() ) {
                L.t("活动对话中")
                count = 40
                if (en.isJieShouHuoDongTask.check()) {
                    en.jieShouHuoDongArea.c()
                } else {
                    if (Math.random() > 0.6) {
                        en.huoDongSelect2Area.c()
                    } else {
                        en.huoDongSelect1Area.c()
                    }
                }
            } else {
                clickSpeedControl.cc()
            }
            count--
        }

        theOutCheck()
        return
    }

}