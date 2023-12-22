package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import android.graphics.Bitmap
import com.android.schedule.corelibrary.SetConstant
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.click.SimpleClickUtils
import com.android.schedule.corelibrary.click.SlidingArea
import com.android.schedule.corelibrary.click.TwoFingerArea
import com.android.schedule.corelibrary.controller.ClickSpeedControl
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.expand.isLandscape
import com.android.schedule.corelibrary.img.img_rule.ImgTask
import com.android.schedule.corelibrary.utils.ContextUtil
import com.android.schedule.corelibrary.utils.FileUtils
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.NwqCallBack
import com.android.schedule.corelibrary.utils.TimeUtils
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
import com.android.system.talker.enums.ActivityType
import com.android.system.talker.enums.MenuType
import com.android.system.talker.enums.ShipType
import com.android.system.talker.enums.WarehouseType
import kotlinx.coroutines.delay
import kotlin.math.abs

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


    abstract fun endGame(eroMsg: String? = "")

    abstract suspend fun getTag(): String

    abstract suspend fun startFunction()

    abstract suspend fun getBaseCloneLocation(): Int


    private var hasResult = true
    fun reportingError(string: String) {
        if (hasResult) {
            L.d(string)
            endGame(string)
            hasResult = false
            runSwitch = false
            onEnd?.onCallBack(false)
        }
    }

    override fun end() {
        super.end()
        if (hasResult) {
            endGame("")
            hasResult = false
            runSwitch = false
            onEnd?.onCallBack(true)
        }
    }


    val en = StarWarEnvironment()


    protected suspend fun intoGame(): Boolean {
        var flag = true
        var count = 40


        val clickSpeedControl = ClickSpeedControl()
        clickSpeedControl.addUnit(en.hasXiaoTipsTask, en.hasXiaoTipsTask.clickArea!!)
        clickSpeedControl.addUnit(en.isAnnouncementT, en.closeAnnouncementArea)
        clickSpeedControl.addUnit(en.isUpdateGameT, en.updateGameArea)
        clickSpeedControl.addUnit(en.isStartGameT, en.isStartGameArea)
        clickSpeedControl.addUnit(en.isSelectRoleT, en.selectRoleArea)
        clickSpeedControl.addUnit(en.isOpenBigMenuT, en.closeBigMenuArea)

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


    private suspend fun hasIntoGame(): Boolean {
        return (en.isClosePositionMenuT.check() || en.isOpenPositionMenuT.check()) &&
                (en.isInSpaceStationT.check() || en.isOpenEyeMenuT.check() || en.isCloseEyeMenuT.check())
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
        L.d("returnSpaceStation")
        var flag = true
        val maxCount = 10
        var count = maxCount
        var hasStart = false
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isInSpaceStationT.check()) {
                return true
            }

            if (en.isConfirmDialogTask.check()) {
                en.confirmDialogEnsureArea.c(en.isConfirmDialogTask)
                count = maxCount
            } else if (en.isSailingT.check()) {
                count = maxCount
            } else if (en.isOpenBigMenuT.check()) {
                en.closeBigMenuArea.c()
                count = maxCount
            } else if (en.isClosePositionMenuT.check() && (en.isCloseEyeMenuT.check() || en.isOpenEyeMenuT.check())) {
                //这个是防止一键收菜卡住
                if (en.isOneClickClaimTask.check()) {
                    en.closeOneClickArea.c(en.isOneClickClaimTask)
                }
                if (!hasStart || count == 2) {
                    if (!clickPositionMenu(position)) {
                        reportingError("${getTag()} returnSpaceStation clickPositionMenu")
                        return false
                    } else {
                        count = maxCount
                        hasStart = true
                    }
                } else {
                    count--
                }
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
        if (en.isOpenPositionMenuT.check()) return true
        theOutCheck()
        return optTaskOperation(
            pTask = en.isClosePositionMenuT,
            clickArea = en.openPositionArea,
            eTask = en.isOpenPositionMenuT
        )

    }

    protected suspend fun theOutCheck(): Boolean {
        var flag = true
        var count = 20

        val clickSpeedControl = ClickSpeedControl()
        clickSpeedControl.addUnit(en.isOpenBigMenuT, en.closeBigMenuArea)
        clickSpeedControl.addUnit(en.isConfirmDialogTask, en.confirmDialogCancelArea)
        clickSpeedControl.addUnit(en.isCanCollectGiftT, en.closeCollectGiftArea)

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
        val clickSpeedControl = ClickSpeedControl()
        clickSpeedControl.addUnit(en.isActivationShipTask, en.activationShipArea)
        clickSpeedControl.addUnit(en.isOpenWarehouseBigMenuTask, en.getShipArea(shipLocation))
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isOpenWarehouseBigMenuTask.check() && en.isActivationLocationList[shipLocation].check()) {
                userDb.shipType = shipType
                dataBase.getUserDao().update(userDb)
                L.d("飞船成功")
                flag = false
            } else if (en.isActivationShipTask.check()) {
                //点击船的位置
                L.d("点击船的位置")
                en.activationShipArea.c(en.isActivationShipTask)
            } else {
                clickSpeedControl.cc()
            }
            if (count < 2) {
                FileUtils.saveBitmapAndroid(context = ContextUtil.context, "新图", screenBitmap!!)
                screenBitmap?.let { en.isActivationShipTask.logColor(it) }
            }
            L.d("换船 $count")
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
                }

                ShipType.MINING_SHIP -> {

                }
            }
            count--
        }
        return -1
    }


    protected suspend fun ensureOpenBigMenuArea(@MenuType index: Int): Boolean {
        L.d("ensureOpenBigMenuArea $index")
        var flag = true
        var count = 10
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isOpenBigMenuT.check()) {
                L.d("isOpenBigMenuT.c()")
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
                    if (en.isShipWarehouseTask.check()) {
                        en.shipWarehouseArea.c(en.isShipWarehouseTask)
                        return true
                    }
                }

                WarehouseType.SHIP_SPECIAL -> {
                    if (en.isShipWarehouseTask.check()) {
                        if (abs(en.isShipWarehouseTask.getOffsetX()) < 3 && abs(en.isShipWarehouseTask.getOffsetY()) < 3) {
                            if (en.isShipWarehouseOpenTask.check()) {
                                en.specialArea.c(en.isShipWarehouseTask)
                                return true
                            } else {
                                findTraget = true
                                en.switchSpecialArea.c(en.isShipWarehouseTask)
                            }
                        } else {
                            if (en.isShipWarehouseOpenTask.copyOffset(
                                    "shipWarehouseOpenTaskCopy",
                                    en.isShipWarehouseTask.getOffsetX(),
                                    en.isShipWarehouseTask.getOffsetY()
                                ).check()
                            ) {
                                en.specialArea.c(en.isShipWarehouseTask)
                                return true
                            } else {
                                findTraget = true
                                en.switchSpecialArea.c(en.isShipWarehouseTask)
                            }
                        }
                    }
                }
            }

            if (!findTraget) {
                if (count >= 5) {
                    //这里前二次先不滑动
                } else if (count >= 3) {
                    if (type <= WarehouseType.STATION_SHIPS) {
                        en.swipeWarehouseDown.c()
                    } else {
                        en.swipeWarehouseTop.c()
                    }
                } else {
                    if (type <= WarehouseType.STATION_SHIPS) {
                        en.swipeWarehouseTop.c()
                    } else {
                        en.swipeWarehouseDown.c()
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
        var flag = true
        var count = 7
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }

            //这里是结束循环的判断
            when (type) {
                ActivityType.LOGIN_GIFT -> {
                    if (en.isQuickClaimTask.check()) {
                        return true
                    }
                }
            }

            //找到菜单的点击位置
            when (type) {
                ActivityType.LOGIN_GIFT -> {
                    if (en.isSupplyMaterialsTask.check()) {
                        en.supplyMaterialsArea.c(en.isSupplyMaterialsTask)
                        delay(jumpClickInterval)
                    }
                }
            }

            if (count >= 5) {
                //这里前二次先不滑动
            } else if (count >= 3) {
                en.activityMenuSlideTop.c()
            } else {
                en.activityMenuSlideBottom.c()
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


    suspend fun ClickArea.c() {
        click(this)
    }

    suspend fun ClickSpeedControl.cc() {
        screenBitmap?.let {
            this.checkImg(it)?.let {
                optClickTask(it)
            }
        }
    }

    suspend fun TwoFingerArea.c() {
        SimpleClickUtils.optClickTasks(acService, 0, 0, *this.toClickTask().toTypedArray())
    }

    suspend fun ClickArea.c(task: ImgTask) {
        click(task, this)
    }

    suspend fun SlidingArea.c() {
        optClickTask(this.toClickTask())
    }


    suspend fun unloadingCargo(@WarehouseType flag: Int) {
        if (flag and WarehouseType.SHIP_CABIN == WarehouseType.SHIP_CABIN) {
            ensureOpenWarehouseType(WarehouseType.SHIP_CABIN)
            delay(clickInterval)
            unloadingGoods()
        }

        if (flag and WarehouseType.SHIP_CABIN == WarehouseType.SHIP_CABIN) {
            ensureOpenWarehouseType(WarehouseType.SHIP_CABIN)
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
                delay(clickInterval)
            } else if (en.moveToStationGoodsTask.check()) {
                en.moveToStationGoodsArea.c(en.moveToStationGoodsTask)
                delay(jumpClickInterval)
                complete = true
            }
            count--
        }
        return !flag
    }


    suspend fun exitGame(): Boolean {
        //先进行游戏退出
        var flag = true
        var count = 5
        while (flag && count > 0) {
            val bitmap = takeScreen(screenshotInterval)
            if (bitmap.isLandscape()) {
                en.exitGameTask.list.forEach {
                    if (it.check()) {
                        it.clickArea?.c(it)
                        delay(jumpClickInterval)
                    } else {
                        pressBackBtn()
                        delay(jumpClickInterval)
                    }
                }
            } else {
                return true
            }
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
        }


        //这里保存结果
        userDb.baseCloneLocation = clonePosition
        userDb.baseMenuLocation = menuPosition
        userDb.shipType = ShipType.UNKNOWN
        dataBase.getUserDao().update(userDb)
        return false
    }


    protected suspend fun leaveShip(): Boolean {
        var hasClickLive = false
        var flag = true
        var count = 5
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
                    hasClickLive = true
                    delay(jumpClickInterval)
                } else {
                    flag = false
                }
            } else if (en.isInSpaceStationT.check()) {
                if (hasClickLive) {
                    flag = false
                } else if (count % 2 == 0) {
                    en.clickShipArea.c()
                } else {
                    en.openShipVolume.c()
                }
            }
            count--
        }
        return !flag
    }


    //这个表示是蛋的情况下出船自毁
    private suspend fun outSelfExplosion(): Boolean {
        var flag = true
        var count = 10
        var hasClickExplosion = false
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
                if (en.isOpenShipMenu2Task.check()) { //这里判断是否打开飞船菜单
                    val task = en.isShowExplosionTask.copyOffset(
                        en.isShowExplosionTask.tag,
                        en.isOpenShipMenu2Task.getOffsetX(),
                        en.isOpenShipMenu2Task.getOffsetY()
                    )
                    if (task.check()) {
                        en.clickSelfExplosionArea.c(en.isOpenShipMenu2Task)
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
        var count = 5
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
                en.confirmDialogCancelArea.c(en.isConfirmDialogTask)
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


}