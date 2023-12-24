package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.SetConstant
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.TimeUtils
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
import com.android.system.talker.enums.ActivityType
import com.android.system.talker.enums.MenuType
import kotlinx.coroutines.delay

class UserFunction(
    userDb: UserDb,
    dataBase: AppDataBase,
    acService: AccessibilityService
) : BaseFunctionControl(userDb, dataBase, acService) {
    override fun endGame(eroMsg: String?) {
        L.d("保存userDb信息")
        dataBase.getUserDao().update(userDb)
    }

    val TAG = UserFunction::class.java.simpleName
    override suspend fun getTag(): String {
        return TAG
    }

    override suspend fun startFunction() {
        L.i("$TAG startFunction")
        var result = intoGame()
        if (!result) return
        L.d("$TAG 进入游戏成功")
        var isInSpaceStation = false
        //这个是每日活动的
        if (userDb.activeGiftSwitch && TimeUtils.isNewMouth(userDb.activeGiftTime)) {
            L.d("$TAG 进入活动礼物领取")
            isInSpaceStation = true
            if (!returnSpaceStation(userDb.baseMenuLocation)) {
                L.d("$TAG 返回空间站失败")
                return
            }
            L.d("$TAG 返回空间站成功")
            if (ensureOpenActivityType(ActivityType.LOGIN_GIFT)) {
                en.quickClaimArea.c()
                L.d("每日登录物资领取成功")
                delay(SetConstant.MINUTE)// 这个领取比较慢
                userDb.activeGiftTime = System.currentTimeMillis()
            }
            theOutCheck()
        }

        //这个是协议任务的
        if (userDb.agreementGiftSwitch && TimeUtils.isNewWeek(userDb.agreementGiftTime)) {
            if (!isInSpaceStation && !returnSpaceStation(userDb.baseMenuLocation)) {//这里保证返回空间站的
                return
            }
            L.d("$TAG 进入协议任务领取")
            isInSpaceStation = true
            if (ensureOpenBigMenuArea(MenuType.AGREEMENT)) {
                optAgreementGift()
                L.d("协议任务领取领取成功")
                userDb.agreementGiftTime = System.currentTimeMillis()
            }
            theOutCheck()
        }

        if (userDb.dailyGiftSwitch && TimeUtils.isNewDay(userDb.dailyGiftTime)) {
            L.d("$TAG 进入每日特惠礼物领取")
            receiveDailyGift(false)
            userDb.dailyGiftTime = System.currentTimeMillis()
            theOutCheck()
        }

        end()
    }


    private suspend fun receiveDailyGift(isInSpaceStation: Boolean) {
        en.openGiftArea.c()
        val hasOpt =
            optTaskOperation(eTask = en.isFreeDailyGiftTask, endClickArea = en.freeDailyGiftArea)
        if (isInSpaceStation && hasOpt) {
            //在次打开以及菜单
            optTaskOperation(clickArea = en.openGiftV2Area, eTask = en.isOpenGiftV2Task)
            var flag = true
            var count = 10
            while (flag && count > 0 && runSwitch) {
                if (!taskScreenL(screenshotInterval)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }

                if (en.isClosePositionMenuT.check()) {
                    flag = false
                } else if (en.isCanGiftV2Task.check()) {
                    en.canGiftV2Area.c()
                    count = 6
                } else if (count <= 6 && en.isOpenGiftV2Task.check()) {
                    en.closeGiftV2Area.c()
                } else if (count <= 6 && en.isCanGiftV3Task.check()) {
                    en.canGiftV3Area.c()
                }
                count--
            }
        } else {
            optTaskOperation(clickArea = en.closeGiftArea, eTask = en.isClosePositionMenuT)
        }

    }


    override suspend fun getBaseCloneLocation(): Int {
        return userDb.baseCloneLocation
    }


    //注意这里已经进入了
    private suspend fun optAgreementGift(): Boolean {
        // 这里先切换到任务
        var flag = true
        var count = 5
        var hasOpt = false
        // 这里切换到领取
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isAgreementMenuTask.check()) {
                flag = false
            } else {
                en.agreementMenuArea.c()
                delay(jumpClickInterval)
            }
            count--
        }


        //这里领取每周任务
        count = 5
        flag = true
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotInterval)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
                return false
            }
            if (en.isAgreementWeekTask.check()) {
                en.agreementWeekArea.c(en.isAgreementWeekTask)
                hasOpt = true
                delay(clickInterval)
                count = 2
            }
            count--
        }

        //这里领取协议挑战任务
        if (en.isProtocolChallengesTasks.check()) {
            en.protocolChallengesArea.c()
            delay(jumpClickInterval)
            //这里点击可以领取的区域
            count = 5
            while (flag && count > 0 && runSwitch) {
                if (!taskScreenL(screenshotIntervalF)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }
                if (en.isAgreementChallengesClickTask.check()) {
                    en.agreementChallengesClickArea.c(en.isAgreementChallengesClickTask)
                    delay(jumpClickInterval)
                    count = 5
                } else if (!en.isOpenAgreementTask.check()) {
                    en.canGiftV3Area.c()
                    delay(jumpClickInterval)
                }
                count--
            }
        }

        return hasOpt
    }
}