package com.nwq.function.corelib.excuter.star_wars

import android.accessibilityservice.AccessibilityService
import android.graphics.Bitmap
import com.nwq.function.corelib.Constant.doubleClickInterval
import com.nwq.function.corelib.Constant.fastClickInterval
import com.nwq.function.corelib.Constant.normalClickInterval
import com.nwq.function.corelib.Constant.tripleClickInterval
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.excuter.BaseController
import com.nwq.function.corelib.excuter.EndLister
import com.nwq.function.corelib.excuter.star_wars.data.QuickBigMenu
import com.nwq.function.corelib.img.task.BasicImgTask
import com.nwq.function.corelib.img.task.ImgTaskImpl1
import com.nwq.function.corelib.utils.sp.SPRepo
import com.nwq.function.corelib.utils.sp.SPRepoPrefix
import com.nwq.function.corelib.utils.sp.SpConstant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
create by: 86136
create time: 2023/6/28 14:52
Function description:
 */

abstract class StarWarController(acService: AccessibilityService, endLister: EndLister? = null) :
    BaseController(acService, endLister) {

    protected val spReo by lazy {
        SPRepoPrefix.getNowSPRepo()
    }
    val warehouseIndex = spReo.fightBaseLocation
    val en = StarWarEnvironment
    var APP_LOCATION_Y = 1 //APP位于当前页的第一行
    val APP_LOCATION_X
        get() = if (SPRepo.role == SpConstant.PREFIX_ROLE1) {
            1
        } else {
            2
        }

    fun getAppArea(): CoordinateArea {
        return CoordinateArea(
            82 + (APP_LOCATION_X - 1) * 254, 185 + (APP_LOCATION_Y - 1) * 291, 154, 153
        )
    }

    override fun startWork() {
        GlobalScope.launch(Dispatchers.Default) {
            val bitmap = takeScreenBitmap(doubleClickInterval)
            if (bitmap.isOrientation()) {
                pressHomeBtn()
                delay(doubleClickInterval)
            }
            intoGame()
        }
    }

    private suspend fun hasIntoGame(bitmap: Bitmap?): Boolean {
        if (bitmap == null)
            return false
        return (en.isClosePositionMenuT.check() || en.isOpenPositionMenuT.check()
                && (en.isInSpaceStationT.check() || en.isOpenEyeMenuT.check() || en.isCloseEyeMenuT.check()))
    }

    protected suspend fun hasTaskDialogBox(bitmap: Bitmap?): Boolean {
        if (bitmap == null)
            return false
        return (en.isShowLeftDialogBox.check() || en.isShowLeftDialogBox.check())
    }

    protected suspend fun isInSailing(bitmap: Bitmap?): Boolean {
        if (bitmap == null)
            return false
        return (en.isOpenPositionMenuT.check() || en.isSailingT.check())
    }


    //进入游戏的进入逻辑
    protected suspend fun intoGame() {
        var flag = true
        var count = 10
        while (flag && count > 0 && runSwitch) {
            val bitmap = takeScreenBitmap(doubleClickInterval)
            if (bitmap.isOrientation()) {
                if (en.isLoadingGameT.check()) {
                } else if (en.isAnnouncementT.check()) {
                    click(en.isAnnouncementT, en.closeAnnouncementArea.toClickTask())
                } else if (en.isUpdateGameT.check()) {
                    click(en.isUpdateGameT, en.updateGameArea.toClickTask())
                    delay(tripleClickInterval)
                } else if (en.isStartGameT.check()) {
                    click(en.isStartGameT, en.isStartGameArea.toClickTask())
                } else if (en.isSelectRoleT.check()) {
                    click(en.isSelectRoleT, en.selectRoleArea.toClickTask())
                } else if (en.isOpenBigMenuT.check()) {
                    click(en.isOpenBigMenuT, en.closeBigMenuArea.toClickTask())
                } else if (hasIntoGame(bitmap)) {
                    receiveDailyGift()
                    flag = false
                }
            } else {//这里没有横屏所以
                click(getAppArea().toClickTask())
                delay(tripleClickInterval)
                count--
            }
        }
    }

    private suspend fun receiveDailyGift() {
        if (takeScreen(fastClickInterval) || !runSwitch) {
            runSwitch = false
            return
        }
        val hasTips = en.isGiftMenuTipsT.check()
        if (hasTips) {
            val isInSpace = en.isInSpaceStationT.check()
            waitImgNotTask(en.isGiftMenuTipsT)
            if (waitImgTask(en.isCanCollectGiftT)) {
                click(en.openCollectGiftArea.toClickTask())
                if (isInSpace && en.isCollectChipT.check()) {
                    delay(normalClickInterval)
                    click(en.collectChipMenuArea.toClickTask())
                    waitImgTask(en.isCollectChipMenuT)
                    delay(normalClickInterval)
                    click(en.CloseCollectChipMenuArea.toClickTask())
                } else {
                    delay(normalClickInterval)
                    click(en.closeCollectGiftArea.toClickTask())
                }
            }

            var flag = true
            var count = 5
            while (flag && count > 0 && runSwitch) {
                if (!takeScreen(doubleClickInterval) || !runSwitch) {
                    runSwitch = false
                    return
                }
                if (hasIntoGame(screenBitmap)) {
                    flag = false
                } else {
                    pressBackBtn()
                }
                count--
            }
        }

    }


    private suspend fun executionResults(
        endTask: List<BasicImgTask>, midList: List<ImgTaskImpl1>
    ): Boolean {
        var flag = true
        var count = 300
        while (flag && count > 0 && runSwitch) {
            val bitmap = takeScreenBitmap(normalClickInterval)
            if (!bitmap.isOrientation()) {
                click(getAppArea().toClickTask())
                count--
            } else if (endTask.find { !it.check() } == null) {
                flag = false
            } else {
                val nowTask = midList.find { it.check() }
                if (nowTask == null) {
                    count--
                } else {
                    nowTask.clickArea?.toClickTask()?.let {
                        click(nowTask, it)
                    }
                }
            }
        }
        return !flag
    }


    //这个是在战斗中飞回
    protected suspend fun emergencyEvacuation(flag: Boolean = true) {
        if (en.isInSpaceStationT.check()) {
            //这里是已经成功回到空间站了

        } else if (en.isOpenPositionMenuT.check()) {
            //坐标菜单打开的
            clickPositionMenu(warehouseIndex)
        } else if (en.isClosePositionMenuT.check()) {
            //坐标菜关闭的
            waitImgTask2(en.isOpenPositionMenuT, en.openPositionArea)
            clickPositionMenu(warehouseIndex)
        } else if (en.isOpenEyeMenuT.check() || en.isCloseEyeMenuT.check()
        ) { //这里是坐标菜单被遮挡了
            waitImgTask2(en.isOpenPositionMenuT, en.openPositionArea)
            clickPositionMenu(warehouseIndex)
        } else { //这里是没有在前台界面
            if (flag) {
                theOutCheck()
                waitImgTask2(en.isOpenPositionMenuT, en.openPositionArea)
                emergencyEvacuation(false)
            }
        }
    }

    protected suspend fun ensureOpenBigMenuArea(@QuickBigMenu index: Int): Boolean {
        var flag = true
        var count = 10
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(doubleClickInterval)) {
                runSwitch = false
                return false
            }
            if (en.isOpenBigMenuT.check()) {
                when (index) {
                    QuickBigMenu.WAREHOUSE_BIG_MUNU_P -> {

                    }
                    QuickBigMenu.TASK_BIG_MUNU_P -> {
                        if (en.isOpenJiyuBigMenuTask.check()) {
                            flag = false
                        } else {
                            en.closeBigMenuArea.clickA()
                        }
                    }
                    QuickBigMenu.PLANETARY_ORE_MUNU_P -> {

                    }
                }
            } else {
                //这里判断有图行再进行点击防止被阻挡导致错点
                when (index) {
                    QuickBigMenu.WAREHOUSE_BIG_MUNU_P -> {

                    }
                    QuickBigMenu.TASK_BIG_MUNU_P -> {
                        if (en.isOpenJiyuBigMenuTask.check()) {
                            flag = false
                        } else {
                            en.closeBigMenuArea.clickA()
                        }
                    }
                    QuickBigMenu.PLANETARY_ORE_MUNU_P -> {

                    }
                }
            }
        }
        return !flag
    }

    protected suspend fun clickQuickBigMenu(index: Int) {
        TODO("Not yet implemented")
    }


    protected suspend fun clickPositionMenu(index: Int) {
        TODO("Not yet implemented")
    }

    //这个方法要将出现眼睛或者在空间站
    protected suspend fun theOutCheck() {
        TODO("Not yet implemented")
    }


    protected fun unloadingCargo() {
        TODO("Not yet implemented")
    }


    protected fun outGame() {
        TODO("Not yet implemented")
    }
}