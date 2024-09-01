package com.android.system.calendar.excuter.nomarl

import android.accessibilityservice.AccessibilityService

import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.utils.L
import com.android.system.calendar.constant.BaiYeType
import kotlinx.coroutines.delay

//每日礼物
class DailyGiftFunction(
    acService: AccessibilityService, en: ImageEnvironment
) : BasicFunction(acService, en) {

    override suspend fun startFunction() {
        lingQuFuLi()
        linQuQianKunDai()
        linQuChengjiu()
      //  linQuEmail()
    }

    private suspend fun linQuEmail() {
        var flag = true
        var count = 30
        var hasClick = false

        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.isTotalCombatPowerTask.check()) {
                if (hasClick) {
                    flag = false
                } else if (en.isHasEmailTask.check()) {
                    en.hasEmailArea.c(repeatedClickInterval)
                }
            } else if (en.isOpenEmailMenuTask.check()) {
                hasClick = true
                en.detailEmailArea.c(repeatedClickInterval)
                delay(clickInterval)
                en.closeEmailMenuArea.c(repeatedClickInterval)
            }
            count--
        }
    }

    private suspend fun linQuChengjiu() {
        var flag = true
        var count = 40
        var hasClick = false

        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.isTotalCombatPowerTask.check()) {
                if (hasClick) {
                    flag = false
                } else if (en.isMainChengJiuBtnTask.check()) {
                    if (en.isMainChengJiuRedTask.check(en.isMainChengJiuBtnTask)) {
                        en.mainChengJiuBtnArea.c(en.isMainChengJiuBtnTask, repeatedClickInterval)
                    } else {
                        flag = false
                    }
                } else {
                    en.switchMainMenuBtnArea.c(repeatedClickInterval)
                }
            } else if (en.isOpenChengJiuMenuTask.check()) {
                hasClick = true
                if (en.isChengjiuLinQuTask.check()) {
                    en.chengjiuLinQuArea.c(en.isChengjiuLinQuTask)
                } else if (en.isHasChengJiuRedTipsTask.check()) {
                    en.hasChengJiuRedTipsArea.c(en.isHasChengJiuRedTipsTask,repeatedClickInterval)
                } else {
                    en.closeBtnArea.c(repeatedClickInterval)
                }
            }
            count--
        }
    }


    private suspend fun lingQuFuLi() {
        var flag = true
        var count = 20
        var number = 0
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)

            }
            if (en.isTotalCombatPowerTask.check()) {
                if (number >= 4) {
                    flag = false
                } else if (en.isMainFuLiBtnTask.check()) {
                    en.mainFuLiBtArea.c(repeatedClickInterval)
                }
            } else if (en.isOpenFuLiMenuTask.check()) {
                when (number) {
                    0 -> {
                        if (en.isMeiRiQianDaoTask.check()) {
                            en.clickQianDaoArea.c(repeatedClickInterval)
                            delay(tripleClickInterval)
                            en.clickQianDaoKongBaiArea.c(repeatedClickInterval)
                            delay(jumpClickInterval)
                            taskScreenL(screenshotIntervalF)
                            if (!en.isOpenFuLiMenuTask.check()) {
                                en.clickQianDaoKongBaiArea.c()
                                delay(jumpClickInterval)
                            }
                            number++
                        } else {
                            en.openMeiRiQianDaoArea.c(repeatedClickInterval)
                        }
                    }

                    1 -> {
                        if (en.isMeiRiLiBaoTask.check()) {
                            en.mianFeiLingQuArea.c(repeatedClickInterval)
                            number++
                        } else {
                            en.meiRiLiBaoArea.c(repeatedClickInterval)
                        }
                    }

                    2 -> {
                        if (en.isDengJiJiangLiTask.check()) {
                            en.openDengJiJiangArea.c(repeatedClickInterval)
                            delay(jumpClickInterval)
                            number++
                        } else {
                            number += 2
                        }
                    }

                    3 -> {
                        if (en.isDengJiLingQuTask.check()) {
                            en.dengJiLingQuArea.c(en.isDengJiLingQuTask)
                        } else {
                            number++
                        }
                    }

                    else -> {
                        en.closeFuLiMenuArea.c(repeatedClickInterval)
                    }
                }
            } else if (en.findCloseBtnTask.check()) {
                en.closeBtnArea.c(en.findCloseBtnTask)
            }
            count--
        }
    }

    private suspend fun linQuQianKunDai() {
        var flag = true
        var count = 20
        var number = 0
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.isTotalCombatPowerTask.check()) {
                if (number == 2) {
                    flag = false
                } else if (en.isMainQianKunDaiTask.check()) {
                    number = 1
                    en.mainQianKunDaiArea.c(repeatedClickInterval)
                }
            } else if (number == 1) {
                en.linQuQianKunDaiArea.c(repeatedClickInterval)
                delay(clickInterval)
                en.closeQianKunDaiArea.c(repeatedClickInterval)
                number = 2
            } else if (en.findCloseBtnTask.check()) {
                en.closeBtnArea.c(en.findCloseBtnTask)
            }
            count--
        }
    }
}