package com.android.system.calendar.excuter

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.controller.ClickSpeedControl
import com.android.schedule.corelibrary.controller.SequentialProcessBaseController
import com.android.schedule.corelibrary.controller.StatusRecorder
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.process_control.KeyframeStep
import com.android.schedule.corelibrary.process_control.StuckJudePoint
import com.android.schedule.corelibrary.process_control.StuckPointMonitoring
import com.android.schedule.corelibrary.utils.L
import com.android.system.calendar.constant.GameStuckPoint
import com.android.system.calendar.constant.TaskType
import kotlinx.coroutines.delay

class OriginFunction(acService: AccessibilityService) : SequentialProcessBaseController(acService) {

    val en = LeiDianImageEnvironment()


    var nowStepType = TaskType.MAIN_QUEST

    private val ABNORMAL_SCREENO_ORIENTATION = ""
    private suspend fun reportingError(s: String) {

    }

    //固定流程部分
    //监听卡点部分
    //一步一步的流程
    override suspend fun getKeyframeStepList(): List<KeyframeStep> {
        var count = 1
        val list = mutableListOf<KeyframeStep>()
        list.add(KeyframeStep(++count, { en.isChooseFashionTask.check() }, {
            L.d(en.isChooseFashionTask.tag)
            when ((Math.random() * 3).toInt()) {
                0 -> {
                    en.isChooseFashion1Area.c()
                }

                1 -> {
                    en.isChooseFashion2Area.c()
                }

                2 -> {
                    en.isChooseFashion3Area.c()
                }
            }
            delay(clickInterval)
            en.isChooseFashionCfArea.c()
            delay(jumpClickInterval)
            en.mainTaskArea.c()
        }))


        list.add(
            KeyframeStep(++count, { en.isWeaponGuideMenuTask.check() }, {
                L.d(en.isWeaponGuideMenuTask.tag)
                var flag = true
                var hasInto = false
                while (flag && runSwitch) {
                    if (!taskScreenL(screenshotIntervalF)) {
                        reportingError(ABNORMAL_SCREENO_ORIENTATION)
                    }
                    if (hasInto && en.isTotalCombatPowerTask.check()) {
                        flag = false
                    } else if (en.isWeaponGuideMenuTask.check()) {
                        en.openWeaponGuideMenuArea.c()
                        delay(jumpClickInterval)
                    } else if (en.isOpenWeaponGuideTask.check()) {
                        hasInto = true
                        en.receiveDivineWeapon1Area.c()
                        delay(jumpClickInterval)
                        en.receiveDivineWeapon5Area.c()
                        delay(clickInterval)
                        en.closeWeaponGuideTask.c()
                    }
                }
            })
        )


        //这个是轻功的
        list.add(
            KeyframeStep(++count, { en.isClickLightnessSkillTask.check() }, {
                L.d(en.isClickLightnessSkillTask.tag)
                en.clickLightnessSkillArea.c()
                delay(tripleClickInterval)
                en.mainTaskArea.c()
            })
        )


        //画作找不同
        list.add(
            KeyframeStep(++count, { en.isPainting1Task.check() }, {
                L.d(en.isPainting1Task.tag)
                en.painting1Area.c()
                delay(jumpClickInterval)
                en.painting2Area.c()
                delay(jumpClickInterval)
                en.skipPlotFlowArea.c()
                delay(jumpClickInterval)
                en.mainTaskArea.c()
            })
        )


        //一键升级所有武学技能
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.isOpenMartialArtsInterfaceTask.check() },
                {
                    L.d(en.isOpenFeatureListTask.tag + en.isOpenMartialArtsInterfaceTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && en.isTotalCombatPowerTask.check()) {
                            flag = false
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenMartialArtsInterfaceTask.check()) {
                            en.isOpenMartialArtsInterfaceArea.c(en.isOpenMartialArtsInterfaceTask)
                            delay(jumpClickInterval)
                        } else if (en.isOneUpgradeAllSkillTask.check()) {
                            en.oneUpgradeAllSkillArea.c()
                            delay(jumpClickInterval)
                            en.oneUpgradeAllSkill2Area.c()
                            delay(clickInterval)
                            en.oneUpgradeAllSkill3Area.c()
                            delay(jumpClickInterval)
                            en.closeUpgradeAllSkillArea.c()
                            delay(jumpClickInterval)
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                            en.switchAutoFightArea.c()
                            hasInto = true
                        }
                    }
                })
        )


        //这里有点问题
        //补充药品列表
        list.add(
            KeyframeStep(++count, { en.isOpenMedicationListTask.check() }, {
                L.d(en.isOpenMedicationListTask.tag)
                en.OpenMedicationList1Area.c()
                delay(jumpClickInterval)
                en.OpenMedicationList2Area.c()
                delay(jumpClickInterval)
                en.OpenMedicationList3Area.c()
                delay(jumpClickInterval)
                en.OpenMedicationList2Area.c()
                delay(jumpClickInterval)
                en.OpenMedicationList2Area.c()
                delay(jumpClickInterval)
                en.mainTaskArea.c()
                delay(jumpClickInterval)
                en.mainTaskArea.c()
            })
        )


        //这里有个设置珍兽
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.isOpenListOfRareBeastsTask.check() },
                {
                    L.d(en.isOpenMartialArtsInterfaceTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && en.isTotalCombatPowerTask.check()) {
                            flag = false
                            en.mainTaskArea.c()
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenListOfRareBeastsTask.check()) {
                            en.openListOfRareBeastsArea.c(en.isOpenListOfRareBeastsTask)
                            delay(jumpClickInterval)
                        } else if (en.isOpenRareBeastsMenuTask.check()) {
                            en.rareBeastsGoWarArea.c()
                            delay(jumpClickInterval)
                            en.closeBigMenuArea.c()
                            hasInto = true
                        }
                    }
                })
        )


        //这个白沙门信封
        list.add(
            KeyframeStep(++count, { en.isBaishamenTask.check() }, {
                L.d(en.isBaishamenTask.tag)
                en.baishamenArea.c()
            })
        )


        //设置辅助药品
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.isOpenTheSettingsScreenTask.check() },
                {
                    L.d(en.isOpenFeatureListTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && en.isTotalCombatPowerTask.check()) {
                            flag = false
                            en.mainTaskArea.c()
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenTheSettingsScreenTask.check()) {
                            en.openTheSettingsScreenArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenSettingMenuTask.check()) {
                            en.clickFuZhuArea.c()
                            delay(jumpClickInterval)
                            en.clickFuZhu1Area.c()
                            delay(jumpClickInterval)
                            en.clickFuZhu3Area.c()
                            delay(jumpClickInterval)
                            en.clickFuZhu2Area.c()
                            delay(jumpClickInterval)
                            en.clickFuZhu3Area.c()
                            delay(jumpClickInterval)
                            en.closeSettingArea.c()
                            hasInto = true
                        }
                    }
                })
        )


        //这里设置宝石
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.isOpenEquipSettingTask.check() },
                {
                    L.d(en.isOpenEquipSettingTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && en.isTotalCombatPowerTask.check()) {
                            en.mainTaskArea.c()
                            flag = false
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenEquipSettingTask.check()) {
                            en.openEquipSettingArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenEquipMenuTask.check()) {
                            en.clickJewel1Area.c()
                            delay(jumpClickInterval)
                            en.clickJewel2Area.c()
                            delay(jumpClickInterval)
                            en.clickJewel3Area.c()
                            delay(jumpClickInterval)
                            en.clickJewel4Area.c()
                            delay(jumpClickInterval)
                            en.closeEquipMenuArea.c()
                            hasInto = true
                        }
                    }
                })
        )


//        //这里是躲避行人 先不进行任何操作
//        list.add(
//            KeyframeStep(++count, { en.isAvoidPedestriansTask.check() }, {
//
//            })
//        )


        //一键强化装备
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.isOpenEquipSettingTask.check() },
                {
                    L.d(en.isOpenEquipSettingTask.tag + 2)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && en.isTotalCombatPowerTask.check()) {
                            en.mainTaskArea.c()
                            flag = false
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenEquipSettingTask.check()) {
                            en.openEquipSettingArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenEquipMenuTask.check()) {
                            //一键强化点击二次
                            en.oneClickReinforcementArea.c()
                            delay(jumpClickInterval)
                            en.oneClickReinforcementArea.c()
                            delay(jumpClickInterval)
                            en.closeEquipMenuArea.c()
                            hasInto = true
                        } else {
                            hasInto = true
                        }
                    }
                })
        )


        //领取章节奖励的 en.isOpenTheActivityHallTask.check()这里如果没有进入章节就直接跳过
//        list.add(
//            KeyframeStep(++count, { en.isOpenMainRewardTask.check() || en.isOpenTheActivityHallTask.check() }, {
//                L.d(en.isOpenMainRewardTask.tag)
//                var flag = true
//                var hasInto = false
//                while (flag && runSwitch) {
//                    if (!taskScreenL(screenshotIntervalF)) {
//                        reportingError(ABNORMAL_SCREENO_ORIENTATION)
//                    }
//                    if(en.isOpenTheActivityHallTask.check()){
//                        flag = false
//                    } else if (hasInto && en.isTotalCombatPowerTask.check()) {
//                        en.mainTaskArea.c()
//                        flag = false
//                    } else if (en.isOpenMainRewardTask.check()) {
//                        en.openMainRewardArea.c()
//                        delay(jumpClickInterval)
//                    } else if (en.isOpenMainRewardMenuTask.check()) {
//                        en.claimYourRewardsArea.c()
//                        delay(jumpClickInterval)
//                        en.closeBigMenuArea.c()
//                        hasInto = true
//                    }
//                }
//            })
//        )


        //这里去乾坤论武
        list.add(
            KeyframeStep(++count, { en.isOpenTheActivityHallTask.check() }, {
                L.d("去乾坤论武")
                var flag = true
                var hasInto = false
                while (flag && runSwitch) {
                    if (!taskScreenL(screenshotIntervalF)) {
                        reportingError(ABNORMAL_SCREENO_ORIENTATION)
                    }
                    if (hasInto && en.isTotalCombatPowerTask.check()) {
                        flag = false
                    } else if (en.isOpenTheActivityHallTask.check()) {
                        en.openTheActivityHallArea.c()
                        delay(jumpClickInterval)
                    } else if (en.isTheActivityHallMenuTask.check()) {
                        if (en.isQianKunWuStartTask.check()) {
                            hasInto = true
                            en.qianKunWuStartArea.c(en.isQianKunWuStartTask)
                        } else {
                            en.tiaozhanClick1Area.c()
                        }
                    } else if (en.isQianKunMartialArtsTask.check()) {
                        en.qianKunMartialArtsArea.c()
                        hasInto = true
                    }
                }
            })
        )


        //乾坤论武
        list.add(
            KeyframeStep(++count, { en.isOpenQianKunFightTask.check() }, {
                mAutoFightingRecorder.updateInfo()
                if (mAutoFightingRecorder.isCloseTrustThresholds()) {
                    en.switchAutoFightArea.c()
                }
            })
        )


        //这里继续主线任务
        list.add(
            KeyframeStep(++count, { en.isJiXuMianOpenTask.check() }, {
                en.mainTaskArea.c()
                nowStepType = TaskType.MAIN_QUEST
            })
        )


        //钓鱼任务
        list.add(
            KeyframeStep(++count, { en.isFishingOnWaterTask.check() }, {
                L.d(en.isFishingOnWaterTask.tag)
                var flag = true
                while (flag && runSwitch) {
                    if (!taskScreenL(screenshotIntervalF)) {
                        reportingError(ABNORMAL_SCREENO_ORIENTATION)
                    }
                    if (en.isSkipPlotFlowTask.check()) {
                        flag = false
                    } else if (en.isFishingOnWaterTask.check()) {
                        en.fishingOnWaterArea.c()
                        delay(jumpClickInterval)
                    } else if (en.isFastClickFishingTask.check()) {
                        val maxInt = 20 + Math.random() * 6
                        for (i in 1..maxInt.toInt()) {
                            en.fishingOnWaterArea.c()
                            delay(fastClickInterval2)
                        }
                    }
                }
            })
        )


        //连续点击经脉任务
        list.add(
            KeyframeStep(++count, { en.isClickLocationAccordinglyTask.check() }, {
                L.d(en.isClickLocationAccordinglyTask.tag)
                swipClick(en.locationAccordinglyAreaList)
                delay(jumpClickInterval)
            })
        )


        //接佛珠的任务
        list.add(
            KeyframeStep(++count, { en.isCatchFlyingBeadsTask.check() }, {
                L.d(en.isFishingOnWaterTask.tag)
                var flag = true
                while (flag && runSwitch) {
                    if (!taskScreenL(screenshotIntervalF)) {
                        reportingError(ABNORMAL_SCREENO_ORIENTATION)
                    }
                    if (!en.isCatchFlyingBeadsTask.check()) {
                        flag = false
                    } else if (en.isCatchFlyingBeads1Task.check()) {
                        en.catchFlyingBeads11Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads12Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads13Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads14Area.c()
                        delay(fastClickInterval2)
                    } else if (en.isCatchFlyingBeads2Task.check()) {
                        en.catchFlyingBeads21Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads22Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads23Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads24Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads25Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads26Area.c()
                        delay(fastClickInterval2)
                    } else if (en.isCatchFlyingBeads3Task.check()) {
                        en.catchFlyingBeads31Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads32Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads33Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads34Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads35Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads36Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads37Area.c()
                        delay(fastClickInterval2)
                        en.catchFlyingBeads38Area.c()
                        delay(fastClickInterval2)
                    }
                }
            })
        )


        //一键升级所有武学技能
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.isOpenMartialArtsInterfaceTask.check() },
                {
                    L.d(en.isOpenMartialArtsInterfaceTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && en.isTotalCombatPowerTask.check()) {
                            nowStepType = TaskType.SIDE_QUEST
                            flag = false
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenMartialArtsInterfaceTask.check()) {
                            en.isOpenMartialArtsInterfaceArea.c(en.isOpenMartialArtsInterfaceTask)
                            delay(jumpClickInterval)
                            en.oneUpgradeAllSkillArea.c()
                            delay(jumpClickInterval)
                            en.oneUpgradeAllSkill2Area.c()
                            delay(clickInterval)
                            en.oneUpgradeAllSkill3Area.c()
                            delay(jumpClickInterval)
                            en.closeUpgradeAllSkillArea.c()
                            delay(jumpClickInterval)
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                            hasInto = true
                        }
                    }
                })
        )


        //这个门派接引使
        list.add(KeyframeStep(++count, { en.isTongSuyueTask.check() }, {
            L.d(en.isTongSuyueTask.tag)
            en.baishamenArea.c()
        }))


        //这个要开始师门任务了
        list.add(KeyframeStep(++count, { en.isOpenTheActivityHallTask.check() }, {
            L.d("师门任务")
            var flag = true
            var hasInto = false
            while (flag && runSwitch) {
                if (!taskScreenL(screenshotIntervalF)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }
                if (hasInto && en.isTotalCombatPowerTask.check()) {

                    flag = false
                } else if (en.isOpenTheActivityHallTask.check()) {
                    en.openTheActivityHallArea.c()
                    delay(jumpClickInterval)
                } else if (en.isTheActivityHallMenuTask.check()) {
                    if (en.isDivisionalMissionsTask.check()) {
                        en.divisionalMissionsStartArea.c(en.isDivisionalMissionsTask)
                    } else {
                        en.divisionalMissionsStartArea.c()
                    }
                    hasInto = true
                }
            }
        }))

        //这里加入帮会
        list.add(
            KeyframeStep(++count,
                {
                    en.isOpenFeatureListTask.check() || en.banghuiGuideTask.check()
                },
                {
                    L.d(en.banghuiGuideTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && en.isTotalCombatPowerTask.check()) {
                            en.sideQuestArea.c()
                            flag = false
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.banghuiGuideTask.check()) {
                            en.banghuiGuideArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenBanghuiMenuTask.check()) {
                            hasInto = true
                            if (en.oneClickGangUpTask.check()) {
                                en.oneClickGangUpArea.c()
                                delay(jumpClickInterval)
                            } else if (en.isReturnGangTask.check()) {
                                en.returnGangArea.c()
                                delay(jumpClickInterval * 4)
                            }
                        }

                    }
                })
        )


        //这个是发送聊天信息
        list.add(KeyframeStep(++count, { en.isSendChatsTask.check() }, {
            L.d(en.isSendChatsTask.tag)
            en.sendChatsArea.c()
            delay(jumpClickInterval)
        }))


        //这个是关闭聊天内容
        list.add(KeyframeStep(++count, { en.isCloseChatTask.check() }, {
            L.d(en.isCloseChatTask.tag)
            en.closeChatArea.c()
            delay(jumpClickInterval)
            en.sideQuestArea.c()
        }))


        //这里在帮会里面购物
        list.add(
            KeyframeStep(++count,
                {
                    en.isOpenFeatureListTask.check() || en.banghuiGuideTask.check()
                },
                {
                    L.d(en.banghuiGuideTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && en.isTotalCombatPowerTask.check()) {
                            en.sideQuestArea.c()
                            flag = false
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.banghuiGuideTask.check()) {
                            en.banghuiGuideArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenBanghuiMenuTask.check()) {
                            if (hasInto) {
                                en.closeBigMenuArea.c()
                            } else if (en.oneClickGangUpTask.check()) {
                                en.oneClickGangUpArea.c()
                                delay(jumpClickInterval)
                            } else if (en.isFuLiTask.check()) {
                                en.fuliArea.c()
                                delay(jumpClickInterval)
                            } else if (en.isZhenBaoGeTask.check()) {
                                en.zhenBaoGeArea.c()
                                delay(jumpClickInterval)
                            }
                        } else if (en.isGangMallTask.check()) {
                            if (hasInto) {
                                en.closeBigMenuArea.c()
                            } else {
                                en.purchaseBangHuiArea.c()
                            }
                        } else if (en.isPurchaseItemTask.check()) {
                            hasInto = true
                            en.isPurchaseItemArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isSecurityLocksTask.check()) {
                            hasInto = false
                            en.cancelSecurityLockArea.c()
                            delay(clickInterval)
                            en.purchaseBangHuiArea.c()
                        }
                    }
                }
            )
        )


        //武学经脉
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.isOpenMartialArtsInterfaceTask.check() },
                {
                    L.d(en.isOpenMartialArtsInterfaceTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && en.isTotalCombatPowerTask.check()) {
                            flag = false
                            en.sideQuestArea.c()
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenMartialArtsInterfaceTask.check()) {
                            en.isOpenMartialArtsInterfaceArea.c(en.isOpenMartialArtsInterfaceTask)
                            delay(jumpClickInterval)
                        } else if (en.isWuXueMenuTask.check()) {
                            hasInto = true
                            if (en.isJingMaiTask.check()) {
                                en.oneUpgradeAllSkillArea.c()
                                delay(jumpClickInterval)
                                en.oneUpgradeAllSkill2Area.c()
                                delay(clickInterval)
                                en.oneUpgradeAllSkill3Area.c()
                                delay(jumpClickInterval)
                                en.jingMaiArea.c()
                                delay(jumpClickInterval)
                            } else {
                                en.chongMaiArea.c()
                                delay(jumpClickInterval)
                                en.closeUpgradeAllSkillArea.c()
                                delay(jumpClickInterval)
                                en.sideQuestArea.c()
                            }
                        }
                    }
                })
        )


        //完成十轮帮会任务
        list.add(KeyframeStep(++count, { en.isOpenTheActivityHallTask.check() }, {
            L.d("帮会任务")
            var flag = true
            var hasInto = false
            while (flag && runSwitch) {
                if (!taskScreenL(screenshotIntervalF)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }
                if (hasInto && en.isTotalCombatPowerTask.check()) {
                    flag = false
                } else if (en.isOpenTheActivityHallTask.check()) {
                    en.openTheActivityHallArea.c()
                    delay(jumpClickInterval)
                } else if (en.isTheActivityHallMenuTask.check()) {
                    if (en.isBangTaskTask.check()) {
                        en.bangTaskArea.c(en.isBangTaskTask)
                    } else {
                        en.bangTaskArea.c()
                    }
                } else if (en.isGoGangQuestTask.check()) {
                    hasInto = true
                    en.goGangQuestArea.c()
                } else if (en.gangQuestTipsTask.check()) {
                    hasInto = true
                    en.gangQuestTips1Task.c()
                    delay(jumpClickInterval)
                    en.gangQuestTips2Task.c()
                    delay(jumpClickInterval)
                    en.pickUpBangTask1Area.c()
                } else if (en.isBangTaskMenuTask.check()) {
                    hasInto = true
                    en.pickUpBangTask1Area.c()
                }
            }
        }))


        //这里领取帮会功勋
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.banghuiGuideTask.check() },
                {
                    L.d(en.banghuiGuideTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && en.isTotalCombatPowerTask.check()) {
                            en.sideQuestArea.c()
                            flag = false
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.banghuiGuideTask.check()) {
                            en.banghuiGuideArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenBanghuiMenuTask.check()) {
                            if (hasInto) {
                                en.closeBigMenuArea.c()
                            } else if (en.oneClickGangUpTask.check()) {
                                en.oneClickGangUpArea.c()
                                delay(jumpClickInterval)
                            } else if (en.isFuLiTask.check()) {
                                en.fuliArea.c()
                                delay(jumpClickInterval)
                            } else {
                                en.openClickGongXunArea.c()
                                delay(jumpClickInterval)
                            }
                        } else if (en.isGongXunLinQuTask.check()) {
                            hasInto = true
                            en.gongXunLinQuArea.c()
                            delay(jumpClickInterval)
                            en.closeBigMenuArea.c()
                        } else if (en.isSettleWagesTask.check()) {
                            en.settleWagesArea.c()
                            delay(jumpClickInterval)
                        }

                    }
                }
            )
        )


        //这里捕捉珍兽
        list.add(
            KeyframeStep(++count, { en.isOpenTheMapTask.check() }, {
                L.d(en.banghuiGuideTask.tag)
                var flag = true
                var hasInto = false
                while (flag && runSwitch) {
                    if (!taskScreenL(screenshotIntervalF)) {
                        reportingError(ABNORMAL_SCREENO_ORIENTATION)
                    }
                    if (hasInto && en.isTotalCombatPowerTask.check()) {
                        en.sideQuestArea.c()
                        flag = false
                    } else if (en.isOpenTheMapTask.check()) {
                        en.openTheMapArea.c()
                        delay(jumpClickInterval)
                    } else if (en.isWorldMapTask.check()) {
                        en.worldMapArea.c()
                        delay(jumpClickInterval)
                    } else if (en.isXuanWuLandTask.check()) {
                        en.xuanWuLandArea.c()
                        delay(jumpClickInterval)
                        en.openTuZiArea.c()
                        delay(jumpClickInterval)
                    } else if (en.isAutoZhenShouTask.check()) {
                        en.switchAutoFightArea.c()
                        delay(jumpClickInterval)
                    } else if (en.isBuZhuoZhenShouTask.check()) {
                        en.buZhuoZhenShouArea.c()
                        delay(jumpClickInterval * 3)
                        en.sideQuestArea.c()
                        flag = false
                    } else if (en.isSkipPlotFlowTask.check()) {
                        en.skipPlotFlowArea.c()
                        delay(jumpClickInterval)
                    }
                }
            })
        )


        //珍兽洗练
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.isOpenListOfRareBeastsTask.check() },
                {
                    L.d(en.isOpenMartialArtsInterfaceTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && (en.isTotalCombatPowerTask.check() || en.isSkipPlotFlowTask.check())) {
                            flag = false
                            en.sideQuestArea.c()
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenListOfRareBeastsTask.check()) {
                            en.openListOfRareBeastsArea.c(en.isOpenListOfRareBeastsTask)
                            delay(jumpClickInterval)
                        } else if (en.isOpenRareBeastsMenuTask.check()) {
                            en.peiYangArea.c()
                            delay(jumpClickInterval)
                            en.peiYang1Area.c()
                            delay(jumpClickInterval)
                            en.peiYang2Area.c()
                            delay(jumpClickInterval)
                            en.peiYang3Area.c()
                            delay(jumpClickInterval)
                            en.peiYang4Area.c()
                            delay(jumpClickInterval)
                            en.peiYang3Area.c()
                            delay(jumpClickInterval)
                            en.closeBigMenuArea.c()
                            delay(jumpClickInterval)
                            en.sideQuestArea.c()
                            hasInto = true
                        }
                    }
                })
        )


        //珍兽繁殖
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.isOpenListOfRareBeastsTask.check() },
                {
                    L.d(en.isOpenMartialArtsInterfaceTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && (en.isTotalCombatPowerTask.check() || en.isSkipPlotFlowTask.check())) {
                            flag = false
                            en.sideQuestArea.c()
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenListOfRareBeastsTask.check()) {
                            en.openListOfRareBeastsArea.c(en.isOpenListOfRareBeastsTask)
                            delay(jumpClickInterval)
                        } else if (en.isOpenRareBeastsMenuTask.check()) {
                            en.breedRareBeastsArea.c()
                            delay(jumpClickInterval * 3)
                        } else if (en.isSoloBreedingTask.check()) {
                            en.soloBreedingArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isBreedingOptMenuTask.check()) {
                            hasInto = true
                            en.breedingOpt1Area.c()
                            delay(jumpClickInterval)
                            en.breedingOpt2Area.c()
                            delay(jumpClickInterval)
                            en.breedingOpt3Area.c()
                            delay(jumpClickInterval)
                            en.breedingOpt4Area.c()
                            delay(jumpClickInterval)
                            en.breedingOpt5Area.c() //這裏進行了繁殖
                            delay(jumpClickInterval * 4)

                            en.breedingOpt6Area.c()
                            delay(jumpClickInterval)
                            en.closeBigMenuArea.c()
                            delay(jumpClickInterval)

                            en.breedingOpt6Area.c()
                            delay(jumpClickInterval)
                            en.closeBigMenuArea.c()
                            delay(jumpClickInterval)

                            en.sideQuestArea.c()
                        }
                    }
                })
        )


        //珍兽技能學習
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.isOpenListOfRareBeastsTask.check() || en.isOpenListOfRareBeasts2Task.check() },
                {
                    L.d(en.isOpenMartialArtsInterfaceTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && (en.isTotalCombatPowerTask.check() || en.isSkipPlotFlowTask.check())) {
                            flag = false
                            en.sideQuestArea.c()
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenListOfRareBeastsTask.check()) {
                            en.openListOfRareBeastsArea.c(en.isOpenListOfRareBeastsTask)
                            delay(jumpClickInterval)
                        } else if (en.isOpenListOfRareBeasts2Task.check()) {
                            en.openListOfRareBeasts2Area.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenRareBeastsMenuTask.check()) {
                            hasInto = true
                            en.practiceSkills1Area.c()
                            delay(jumpClickInterval)
                            en.practiceSkills2Area.c()
                            delay(jumpClickInterval)
                            en.practiceSkills3Area.c()
                            delay(jumpClickInterval)
                            en.practiceSkills3Area.c()
                            delay(jumpClickInterval)
                            en.practiceSkills4Area.c()
                            delay(jumpClickInterval)
                            en.practiceSkills5Area.c()
                            delay(jumpClickInterval)
                            en.closeBigMenuArea.c()
                        }
                    }
                })
        )


        //惩凶打图
        list.add(KeyframeStep(++count, { en.isOpenTheActivityHallTask.check() }, {
            L.d("惩凶打图")
            var flag = true
            var hasInto = false
            while (flag && runSwitch) {
                if (!taskScreenL(screenshotIntervalF)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }
                if (hasInto && en.isTotalCombatPowerTask.check()) {
                    flag = false
                } else if (en.isOpenTheActivityHallTask.check()) {
                    en.openTheActivityHallArea.c()
                    delay(jumpClickInterval)
                } else if (en.isTheActivityHallMenuTask.check()) {
                    if (en.isMurderousFiguresTask.check()) {
                        en.murderousFiguresArea.c(en.isMurderousFiguresTask)
                    } else {
                        en.murderousFiguresArea.c()
                    }
                } else if (en.isHuodongDiloagTask.check()) {
                    en.huodongDiloag1Area.c()
                    hasInto = true
                }
            }
        }))


        //这里进行藏宝图
        list.add(KeyframeStep(++count, { en.isOpenTheBackpackTask.check() }, {
            L.d("进行藏宝图")
            var flag = true
            var hasInto = false
            while (flag && runSwitch) {
                if (!taskScreenL(screenshotIntervalF)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }
                if (hasInto && en.isTotalCombatPowerTask.check()) {
                    nowStepType = TaskType.MAIN_QUEST
                    flag = false
                } else if (en.isOpenTheBackpackTask.check()) {
                    en.openTheBackpacArea.c()
                    delay(jumpClickInterval)
                } else if (en.isSelectTreasureMapTask.check()) {
                    en.selectTreasureMapArea.c(en.isSelectTreasureMapTask)
                } else if (en.isUseItemsTask.check()) {
                    en.useItemsArea.c(en.isUseItemsTask)
                    hasInto = true
                }
            }
        }))

        //这个是敲门任务
        list.add(KeyframeStep(++count, { en.isKnockTheDoorStartTask.check() }, {
            L.d(en.isKnockTheDoorStartTask.tag)
            var flag = true
            while (flag && runSwitch) {
                if (!taskScreenL(fastClickInterval)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }
                if (!en.isKnockTheDoorStartTask.check()) {
                    flag = false
                } else if (en.isKnockTheDoorTask.check()) {
                    var allDelayTime = 0L
                    var delayTime = 0L
                    en.knockTheDoorArea.c()
                    delayTime = (1900 + Math.random() * 100).toLong()
                    allDelayTime = delayTime
                    delay(delayTime)
                    en.knockTheDoorArea.c()

                    delayTime = (3400 + Math.random() * 100).toLong()
                    delay(delayTime - allDelayTime)
                    allDelayTime = delayTime
                    en.knockTheDoorArea.c()

                    delayTime = (3900 + Math.random() * 100).toLong()
                    delay(delayTime - allDelayTime)
                    allDelayTime = delayTime
                    en.knockTheDoorArea.c()

                    delayTime = (6000 + Math.random() * 100).toLong()
                    delay(delayTime - allDelayTime)
                    en.knockTheDoorArea.c()

                }
            }
        }))

        //这个是移动书简的
        list.add(KeyframeStep(++count, { en.isSupplementaryVersesTask.check() }, {
            L.d(en.isSupplementaryVersesTask.tag)
            swipClick(en.supplementaryVersesList)
            delay(jumpClickInterval)
        }))

        //这个是打开窗户
        list.add(KeyframeStep(++count, { en.isPokeOpenWindowTask.check() }, {
            L.d(en.isPokeOpenWindowTask.tag)
            en.pokeOpenWindowArea.c()
            delay(jumpClickInterval)
        }))


        //这个是师徒的
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.mentorApprenticeInterfaceTask.check() },
                {
                    L.d(en.isOpenMartialArtsInterfaceTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && (en.isTotalCombatPowerTask.check() || en.isSkipPlotFlowTask.check())) {
                            flag = false
                            nowStepType = TaskType.SHEN_LONG
                            en.sideQuestArea.c()
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.mentorApprenticeInterfaceTask.check()) {
                            en.mentorApprenticeInterfaceArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isLookForMasterTask.check()) {
                            hasInto = true
                            en.lookForMaster1Area.c()
                            delay(jumpClickInterval)
                            en.lookForMaster2Area.c()
                            delay(jumpClickInterval)
                            en.closeBigMenuArea.c()
                        }
                    }
                })
        )

        //神龙吟Tips
        list.add(
            KeyframeStep(++count, { en.isShenLongYinTask.check() }, {
                L.d(en.isShenLongYinTask.tag)
                var flag = true
                var hasInto = false
                while (flag && runSwitch) {
                    if (!taskScreenL(screenshotIntervalF)) {
                        reportingError(ABNORMAL_SCREENO_ORIENTATION)
                    }
                    if (hasInto && (en.isTotalCombatPowerTask.check() || en.isSkipPlotFlowTask.check()) || en.isOpenQianKunFightTask.check()) {
                        flag = false
                        nowStepType = TaskType.SHEN_LONG
                        en.sideQuestArea.c()
                    } else if (en.isShenLongYinTask.check()) {
                        en.shenLongYinArea.c()
                        delay(jumpClickInterval)
                    } else if (en.isShenLongYinTips1Task.check() || en.isShenLongYinTips2Task.check()) {
                        en.shenLongYinTips1Area.c()
                        delay(jumpClickInterval)
                    } else if (en.isShenLongYinMenuTask.check()) {
                        if (en.isShenLongYinTargetTask.check()) {
                            en.shenLongYinTargetArea.c()
                        } else {
                            en.closeShenLongYinMenuArea.c()
                            hasInto = true
                        }
                    } else if (en.isQianKunWuStartTask.check()) {
                        en.qianKunWuStartArea.c(en.isQianKunWuStartTask)
                    } else if (en.isQianKunMartialArtsTask.check()) {
                        en.qianKunMartialArtsArea.c()
                        hasInto = true
                    }
                }
            })
        )

        //乾坤论武开启自动战斗
        list.add(
            KeyframeStep(++count, { en.isOpenQianKunFightTask.check() }, {
                mAutoFightingRecorder.updateInfo()
                if (mAutoFightingRecorder.isCloseTrustThresholds()) {
                    en.switchAutoFightArea.c()
                }
            })
        )

        //这里是查看通关奖励
        list.add(
            KeyframeStep(++count, { en.isOpenTheActivityHall3Task.check() }, {
                L.d("通关奖励")
                var flag = true
                var hasInto = false
                while (flag && runSwitch) {
                    if (!taskScreenL(screenshotIntervalF)) {
                        reportingError(ABNORMAL_SCREENO_ORIENTATION)
                    }
                    if (hasInto && en.isTotalCombatPowerTask.check()) {
                        flag = false
                    } else if (en.isOpenTheActivityHall3Task.check()) {
                        en.openTheActivityHall3Area.c()
                        delay(jumpClickInterval)
                    } else if (en.isTheActivityHallMenuTask.check()) {
                        if (hasInto) {
                            en.closeBigMenuArea.c()
                        } else if (en.isQianKunWuStartTask.check()) {
                            en.qianKunWuStartArea.c(en.isQianKunWuStartTask)
                        } else {
                            en.tiaozhanClick1Area.c()
                        }
                    } else if (en.isQianKunMiBaoTask.check()) {
                        en.qianKunMiBaoArea.c()
                        hasInto = true
                    } else if (en.isQianKunJiangLiTipsTask.check()) {
                        en.qianKunJiangLiTipsArea.c()
                    } else if (en.isQianKunJiangLiMenuTask.check()) {
                        en.closeQianKunJiangLiMenuArea.c()
                    } else if (en.isQianKunMartialArtsTask.check()) {
                        if (hasInto) {
                            en.closeBigMenuArea.c()
                        }
                    }
                }
            }, true)
        )

        //这个是武道突破
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.isOpenRoleScreenTask.check() },
                {
                    L.d(en.isOpenMartialArtsInterfaceTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && (en.isTotalCombatPowerTask.check() || en.isSkipPlotFlowTask.check())) {
                            flag = false
                            nowStepType = TaskType.DANG_ZE_KOU
                            en.sideQuestArea.c()
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isOpenRoleScreenTask.check()) {
                            en.openRoleScreenArea.c()
                            delay(jumpClickInterval)
                        } else if (en.isRoleMenuTask.check()) {
                            if (hasInto) {
                                en.closeBigMenuArea.c()
                            } else if (en.isRoleWuDaoTask.check()) {
                                en.roleWuDaoArea.c()
                            } else if (en.isWuDaoTuPoTask.check()) {
                                hasInto = true
                                en.wuDaoTuPoArea.c()
                            }
                        } else if (en.isWuDaoSucessTask.check()) {
                            en.wuDaoSucessArea.c()
                        }
                    }
                })
        )

        //购买荡魔腰牌
        list.add(
            KeyframeStep(++count,
                { en.isOpenMarketTask.check() },
                {
                    L.d(en.isOpenMarketTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && (en.isTotalCombatPowerTask.check() || en.isSkipPlotFlowTask.check())) {
                            flag = false
                            en.sideQuestArea.c()
                            delay(clickInterval)
                            en.sideQuestArea.c()
                            delay(clickInterval)
                            en.clickUseArea.c()
                            delay(clickInterval)
                            en.sideQuestArea.c()

                            nowStepType = TaskType.HAO_YOU_XIA
                        } else if (en.isOpenMarketTask.check()) {
                            en.openMarketArea.c()
                            delay(clickInterval)
                        } else if (en.isShopMenuTask.check()) {
                            if (hasInto) {
                                en.closeBigMenuArea.c()
                            } else if (en.isShopTokensTask.check()) {
                                en.shopTokensArea.c()
                            } else if (en.isDangkouTask.check()) {
                                en.dangkouArea.c()
                            } else if (en.isDangKouMaiTask.check()) {
                                en.dangKouMai1Area.c()
                                delay(clickInterval)
                            }
                        } else if (en.isSecurityLocksTask.check()) {
                            hasInto = false
                            en.cancelSecurityLockArea.c()
                            delay(jumpClickInterval)
                            en.dangKouMai1Area.c()
                        } else if (en.isPurchaseItemTask.check()) {
                            en.isPurchaseItemArea.c()
                            hasInto = true
                        }
                    }
                })
        )

        //豪友侠提升装备
        list.add(
            KeyframeStep(++count,
                { en.isOpenFeatureListTask.check() || en.isOpenHaoJieTask.check() },
                {
                    L.d(en.isOpenHaoJieTask.tag)
                    var flag = true
                    var hasInto = false
                    while (flag && runSwitch) {
                        if (!taskScreenL(screenshotIntervalF)) {
                            reportingError(ABNORMAL_SCREENO_ORIENTATION)
                        }
                        if (hasInto && (en.isTotalCombatPowerTask.check() || en.isSkipPlotFlowTask.check())) {
                            flag = false
                            en.sideQuestArea.c()
                            end()
                        } else if (en.isOpenFeatureListTask.check()) {
                            en.openFeatureListArea.c()
                            delay(clickInterval)
                        } else if (en.isOpenHaoJieTask.check()) {
                            en.openHaoJieArea.c()
                            delay(clickInterval)
                        } else if (en.isOpenHaoJieMenuTask.check()) {
                            if (hasInto) {
                                en.closeBigMenuArea.c()
                            } else if (en.isEquipmentUpgradesTask.check()) {
                                en.equipmentUpgradesArea.c()
                            } else {
                                en.openHaoJie1Area.c()
                                delay(clickInterval)
                                en.equipmentUpgradesArea.c()
                            }
                        } else if (en.isEquipmentUpgrades2Task.check()) {
                            hasInto = true
                            en.equipmentUpgrades2Area.c()
                            delay(jumpClickInterval)
                            en.closeEquipmentUpgradesArea.c()
                        }
                    }
                })
        )

        return list
    }


    override suspend fun getStuckPointMonitoring(): List<StuckPointMonitoring> {
        val list = mutableListOf<StuckPointMonitoring>()
        list.add(
            StuckPointMonitoring(
                GameStuckPoint.HOME_SCREEN_REMAIN, {
                    val s = en.isTotalCombatPowerTask.check()
                    L.d("isMain $s")
                    s
                }, listOf(
                    StuckJudePoint(1152, 34),
                    StuckJudePoint(1256, 28),
                    StuckJudePoint(1150, 83),
                ), 5
            )
        )
        return list
    }


    private val clickSpeedControl = ClickSpeedControl()
    override suspend fun getClickSpeedControl(): ClickSpeedControl? {
        //这二个是帮会选择的
        clickSpeedControl.addUnit(en.isAllAboveTask, en.isAllAboveArea)
        clickSpeedControl.addUnit(en.IsGangActivitiesTask, en.gangActivitiesArea)
        clickSpeedControl.addUnit(en.isSkipPlotFlowTask, en.skipPlotFlowArea)
        clickSpeedControl.addUnit(en.isClickUseTask, en.clickUseArea)
        clickSpeedControl.addUnit(en.isClickEquipTask, en.clickUseArea)
        clickSpeedControl.addUnit(en.isTipsDetermineTask, en.tipsDetermineArea)
        clickSpeedControl.addUnit(en.isANewFriendshipTask, en.closeFriendshipArea)
        clickSpeedControl.addUnit(en.isItemsInDemandTask, en.itemsInDemandArea)
        clickSpeedControl.addUnit(en.isPurchaseItemTask, en.isPurchaseItemArea)


        //挑战失败的 这个三个顺序不能调整
        clickSpeedControl.addUnit(en.isChallengeFailedTask, en.clickOutFuBenArea)
        //这个是挑战到出现任务结束
        clickSpeedControl.addUnit(en.isClickOutFuBenTask, en.clickOutFuBenArea)
        //这个是继续挑战副本
        clickSpeedControl.addUnit(en.isOpenQianKunFightNextTask, en.qianKunFightNextArea)

        clickSpeedControl.addUnit(en.isDivisionalMissionsDTask, en.divisionalMissionsDStartArea)
        clickSpeedControl.addUnit(en.isHuodongDiloagTask, en.huodongDiloag2Area)


        clickSpeedControl.addUnit(
            en.hasDialogueSelectionBoxTask,
            listOf(en.dialogueSelectionBox1Area, en.dialogueSelectionBox2Area)
        )
        clickSpeedControl.addUnit(
            en.isBangTaskMenuTask,
            listOf(en.pickUpBangTask1Area, en.pickUpBangTask2Area, en.pickUpBangTask2Area)
        )

        clickSpeedControl.addUnit(en.isEnableNewFeaturesTask, en.isEnableNewFeaturesArea)
        //这里是章节 分享的
        clickSpeedControl.addUnit(en.isUnitShareTask, en.closeUnitShareArea)


        clickSpeedControl.addUnit(en.isSubmitItemsTask, en.submitItemArea)

        return clickSpeedControl
    }


    private val mAutoFightingRecorder = en.isAutoFightingTask.toStatusRecorder(5, 10)
    private val mAutoPathfindingRecorder = en.isAutomaticPathfindingTask.toStatusRecorder(5, 10)

    //这个是判断是否正在自动执行
    override suspend fun isAutoOpt(): Boolean {
        mAutoFightingRecorder.updateInfo()
        mAutoPathfindingRecorder.updateInfo()
        return mAutoFightingRecorder.isOpenTrustThresholds() || mAutoPathfindingRecorder.isOpenTrustThresholds()
    }

    //当对应的卡点出现的时候
    override suspend fun onGameStuck(type: Int) {
        when (type) {
            GameStuckPoint.HOME_SCREEN_REMAIN -> {
                if (nowStepType == TaskType.MAIN_QUEST) {
                    if (en.isStartSideTask.check() || en.isStartDivisionalTask.check()) {
                        nowStepType = TaskType.SIDE_QUEST
                    } else if (en.isMainTaskTask.check()) {
                        en.mainTaskArea.c(en.isMainTaskTask, repeatedClickInterval)
                    } else {
                        en.mainTaskArea.c(repeatedClickInterval)
                    }
                } else if (nowStepType == TaskType.SIDE_QUEST) {
                    if (en.isSideQuestTask.check() || en.isActivityTaskTask.check()) {
                        en.sideQuestArea.c()
                    } else {
                        nowStepType = TaskType.MAIN_QUEST
                    }
                } else if (nowStepType == TaskType.SHEN_LONG) {
                    if (en.isShenLongYinTypeTask.check()) {
                        en.shenLongYinTypeArea.c(en.isShenLongYinTypeTask)
                    } else {
                        nowStepType = TaskType.SIDE_QUEST
                    }
                } else if (nowStepType == TaskType.DANG_ZE_KOU) {
                    if (en.isDangZeKouTypeTask.check()) {
                        en.dangZeKouTypeArea.c(en.isDangZeKouTypeTask)
                    } else {
                        nowStepType = TaskType.SIDE_QUEST
                    }
                } else if (nowStepType == TaskType.HAO_YOU_XIA) {
                    if (en.isHaoYouXiaTypeTask.check()) {
                        en.haoYouXiaTypeArea.c(en.isHaoYouXiaTypeTask)
                    } else {
                        nowStepType = TaskType.SIDE_QUEST
                    }
                }
            }
        }
    }


}