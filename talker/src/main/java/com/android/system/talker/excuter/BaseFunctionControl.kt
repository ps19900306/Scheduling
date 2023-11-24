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
    val userId:Long,
    val userDb: UserDb,
    val dataBase: AppDataBase,
    acService: AccessibilityService,
    onEnd: () -> Unit,): TurnBaseController(acService,onEnd) {



    abstract suspend fun startFunction()

    fun reportingError(string: String){

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
}