package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import android.graphics.Bitmap
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.expand.isLandscape
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
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
            val bitmap = takeScreen(doubleClickInterval)
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
            if (!taskScreenL(doubleClickInterval)) {
                runSwitch = false
                return false
            }
            if (en.isInSpaceStationT.check()) {
                return true
            }
            if (en.isConfirmDialogTask.check()) {
                click(en.confirmDialogEnsureArea)
            } else if (en.isClosePositionMenuT.check()) {
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
            if (taskScreenL(doubleClickInterval)) {
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

    protected fun checkShip(shipType: Int): Boolean {
        if (userDb.shipType == shipType) {
            return true
        }
        //TODO这里需要进行换船
        userDb.shipType=shipType
        dataBase.getUserDao().update(userDb)
        return false
    }


     fun openFunctionMenu(type:Int){ //MenuType

    }

}