package com.android.system.calendar.excuter

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.area.CoordinatePoint
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
        KeyframeStep(count, { en.isChooseFashionTask.check() }, {
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
        })
        count++

        KeyframeStep(count, { en.isWeaponGuideMenuTask.check() }, {
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
        count++

        //这个是轻功的
        KeyframeStep(count, { en.isClickLightnessSkillTask.check() }, {
            L.d(en.isClickLightnessSkillTask.tag)
            en.clickLightnessSkillArea.c()
            delay(tripleClickInterval)
            en.mainTaskArea.c()
        })
        count++


        //画作找不同
        KeyframeStep(count, { en.isPainting1Task.check() }, {
            L.d(en.isPainting1Task.tag)
            en.painting1Area.c()
            delay(jumpClickInterval)
            en.painting2Area.c()
            delay(jumpClickInterval)
            en.skipPlotFlowArea.c()
            delay(jumpClickInterval)
            en.mainTaskArea.c()
        })
        count++

        //一键升级所有武学技能
        KeyframeStep(
            count,
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
                        en.isOpenMartialArtsInterfaceArea.c()
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
        count++

        //补充药品列表
        KeyframeStep(count, { en.isOpenMedicationListTask.check() }, {
            L.d(en.isOpenMedicationListTask.tag)
            en.OpenMedicationList1Area.c()
            delay(jumpClickInterval)
            en.OpenMedicationList2Area.c()
            delay(jumpClickInterval)
            en.OpenMedicationList3Area.c()
            delay(jumpClickInterval)
            en.OpenMedicationList2Area.c()
            delay(jumpClickInterval)
            en.mainTaskArea.c()
        })
        count++

        //一键升级所有武学技能
        KeyframeStep(
            count,
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
                    } else if (en.isOpenFeatureListTask.check()) {
                        en.openFeatureListArea.c()
                        delay(jumpClickInterval)
                    } else if (en.isOpenMartialArtsInterfaceTask.check()) {
                        en.isOpenMartialArtsInterfaceArea.c()
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
        count++


        //这个白沙门信封
        KeyframeStep(count, { en.isBaishamenTask.check() }, {
            L.d(en.isBaishamenTask.tag)
            en.baishamenArea.c()
        })
        count++


        //设置辅助药品
        KeyframeStep(
            count,
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
        count++

        //这里设置宝石
        KeyframeStep(
            count,
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
        count++

        //这里是躲避行人 先不进行任何操作
        KeyframeStep(count, { en.isAvoidPedestriansTask.check() }, {

        })
        count++

        //一键强化装备
        KeyframeStep(
            count,
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
                        en.oneClickReinforcementArea.c()
                        delay(jumpClickInterval)
                        en.closeEquipMenuArea.c()
                        hasInto = true
                    }
                }
            })
        count++

        //这里是解除控制的
        KeyframeStep(count, { en.isUncontrolTask.check() }, {
            L.d(en.isUncontrolTask.tag)
            en.uncontrolArea.c(repeatedClickInterval)
        })
        count++

        //这里是分享的
        KeyframeStep(count, { en.isShareActionTask.check() }, {
            L.d(en.isShareActionTask.tag)
            en.closeShareActionArea.c(repeatedClickInterval)
        })
        count++

        //领取章节奖励的
        KeyframeStep(count, { en.isOpenMainRewardTask.check() }, {
            L.d(en.isOpenMainRewardTask.tag)
            var flag = true
            var hasInto = false
            while (flag && runSwitch) {
                if (!taskScreenL(screenshotIntervalF)) {
                    reportingError(ABNORMAL_SCREENO_ORIENTATION)
                }
                if (hasInto && en.isTotalCombatPowerTask.check()) {
                    en.mainTaskArea.c()
                    flag = false
                } else if (en.isOpenMainRewardTask.check()) {
                    en.openMainRewardArea.c()
                    delay(jumpClickInterval)
                } else if (en.isOpenMainRewardMenuTask.check()) {
                    en.claimYourRewardsArea.c()
                    delay(jumpClickInterval)
                    en.closeBigMenuArea.c()
                    hasInto = true
                }
            }
        })
        count++

        //下面要开始支线任务了
        KeyframeStep(count, { nowStepType == TaskType.MAIN_QUEST && en.isSideQuestTask.check() }, {
            nowStepType = TaskType.SIDE_QUEST
            en.sideQuestArea.c()
        })
        count++

        //这里去乾坤论武
        KeyframeStep(count, { en.isOpenTheActivityHallTask.check() }, {
            L.d(en.isOpenEquipSettingTask.tag + 2)
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
                    en.tiaozhanClick1Area.c()
                    delay(jumpClickInterval)
                    en.tiaozhanClick2Area.c()
                    delay(jumpClickInterval)
                } else if (en.isQianKunMartialArtsTask.check()) {
                    en.qianKunMartialArtsArea.c()
                    hasInto = true
                }
            }
        })
        count++

        KeyframeStep(count, { en.isOpenQianKunFightTask.check() }, {
            mAutoFightingRecorder.updateInfo()
            if (mAutoFightingRecorder.isCloseTrustThresholds()) {
                en.switchAutoFightArea.c()
            }
        })
        count++
        //1
        KeyframeStep(count, { en.isOpenQianKunFightNextTask.check() }, {
            en.qianKunFightNextArea.c()
        })
        count++
        //2
        KeyframeStep(count, { en.isOpenQianKunFightNextTask.check() }, {
            en.qianKunFightNextArea.c()
        })
        count++
        //3
        KeyframeStep(count, { en.isOpenQianKunFightNextTask.check() }, {
            en.qianKunFightNextArea.c()
        })
        count++
        //4
        KeyframeStep(count, { en.isOpenQianKunFightNextTask.check() }, {
            en.qianKunFightNextArea.c()
        })
        count++
        //5
        KeyframeStep(count, { en.isOpenQianKunFightNextTask.check() }, {
            en.qianKunFightLeveArea.c()
        })
        count++

        //这里继续主线任务
        KeyframeStep(count, { en.isJiXuMianOpenTask.check() }, {
            en.mainTaskArea.c()
            nowStepType = TaskType.MAIN_QUEST
        })
        count++

        //钓鱼任务
        KeyframeStep(count, { en.isFishingOnWaterTask.check() }, {
            en.fishingOnWaterArea.c()
        })
        count++

        //钓鱼任务
        KeyframeStep(count, { en.isFishingOnWaterTask.check() }, {
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
                    en.fishingOnWaterArea.c()
                    delay(fastClickInterval)
                    en.fishingOnWaterArea.c()
                    delay(fastClickInterval)
                    en.fishingOnWaterArea.c()
                    delay(fastClickInterval)
                    en.fishingOnWaterArea.c()
                    delay(fastClickInterval)
                    en.fishingOnWaterArea.c()
                    delay(fastClickInterval)
                    en.fishingOnWaterArea.c()
                    delay(fastClickInterval)
                }
            }
        })
        count++

        //连续点击经脉任务
        KeyframeStep(count, { en.isClickLocationAccordinglyTask.check() }, {
            L.d(en.isClickLocationAccordinglyTask.tag)
            swipClick(en.locationAccordinglyAreaList)
            delay(jumpClickInterval)
        })
        count++


        //接佛珠的任务
        KeyframeStep(count, { en.isCatchFlyingBeads1Task.check() }, {
            L.d(en.isClickLocationAccordinglyTask.tag)
            en.catchFlyingBeads11Area.c()
            delay(fastClickInterval)
            en.catchFlyingBeads12Area.c()
        })
        count++

        //接佛珠的任务1
        KeyframeStep(count, { en.isCatchFlyingBeads1Task.check() }, {
            L.d(en.isClickLocationAccordinglyTask.tag)
            en.catchFlyingBeads11Area.c()
            delay(fastClickInterval)
            en.catchFlyingBeads12Area.c()
        })
        count++

        //接佛珠的任务2
        KeyframeStep(count, { en.isCatchFlyingBeads2Task.check() }, {
            L.d(en.isClickLocationAccordinglyTask.tag)
            en.catchFlyingBeads21Area.c()
            delay(fastClickInterval)
            en.catchFlyingBeads22Area.c()
            delay(fastClickInterval)
            en.catchFlyingBeads23Area.c()
        })
        count++

        //接佛珠的任务3
        KeyframeStep(count, { en.isCatchFlyingBeads3Task.check() }, {
            L.d(en.isClickLocationAccordinglyTask.tag)
            en.catchFlyingBeads31Area.c()
            delay(fastClickInterval)
            en.catchFlyingBeads32Area.c()
            delay(fastClickInterval)
            en.catchFlyingBeads33Area.c()
            delay(fastClickInterval)
            en.catchFlyingBeads34Area.c()
        })
        count++


        //一键升级所有武学技能
        KeyframeStep(
            count,
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
0
                    } else if (en.isOpenFeatureListTask.check()) {
                        en.openFeatureListArea.c()
                        delay(jumpClickInterval)
                    } else if (en.isOpenMartialArtsInterfaceTask.check()) {
                        en.isOpenMartialArtsInterfaceArea.c()
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
        count++



        return list
    }


    override suspend fun getStuckPointMonitoring(): List<StuckPointMonitoring> {
        val list = mutableListOf<StuckPointMonitoring>()
        StuckPointMonitoring(
            GameStuckPoint.HOME_SCREEN_REMAIN,
            {
                val s = en.isTotalCombatPowerTask.check()
                s
            },
            listOf(
                StuckJudePoint(1141, 39),
                StuckJudePoint(1141, 133),
                StuckJudePoint(1264, 33),
                StuckJudePoint(1230, 146),
                StuckJudePoint(1269, 113)
            ),
            10
        )
        return list
    }

    override suspend fun getClickSpeedControl(): ClickSpeedControl? {
        val clickSpeedControl = ClickSpeedControl()
        clickSpeedControl.maxCount = 5
        clickSpeedControl.addUnit(en.isSkipPlotFlowTask, en.skipPlotFlowArea)
        clickSpeedControl.addUnit(en.isClickUseTask, en.clickUseArea)
        clickSpeedControl.addUnit(en.isClickEquipTask, en.clickUseArea)
        clickSpeedControl.addUnit(en.isTipsDetermineTask, en.tipsDetermineArea)
        clickSpeedControl.addUnit(en.isANewFriendshipTask, en.closeFriendshipArea)
        clickSpeedControl.addUnit(en.isItemsInDemandTask, en.itemsInDemandArea)
        clickSpeedControl.addUnit(en.isPurchaseItemTask, en.isPurchaseItemArea)
        clickSpeedControl.addUnit(
            en.hasDialogueSelectionBoxTask,
            listOf(en.dialogueSelectionBox1Area, en.dialogueSelectionBox2Area)
        )
        clickSpeedControl.addUnit(en.isEnableNewFeaturesTask, en.isEnableNewFeaturesArea)
        return clickSpeedControl
    }


    private val mAutoFightingRecorder = en.isAutoFightingTask.toStatusRecorder(5, 10)
    private val mAutoPathfindingRecorder = en.isAutomaticPathfindingTask.toStatusRecorder(5, 10)

    //这个是判断是否正在自动执行
    override suspend fun isAutoOpt(): Boolean {
        mAutoFightingRecorder.updateInfo()
        mAutoPathfindingRecorder.updateInfo()
        return mAutoFightingRecorder.isCloseTrustThresholds() && mAutoPathfindingRecorder.isCloseTrustThresholds()
    }

    //当对应的卡点出现的时候
    override suspend fun onGameStuck(type: Int) {
        when (type) {
            GameStuckPoint.HOME_SCREEN_REMAIN -> {
                if (nowStepType == TaskType.MAIN_QUEST) {
                    if (en.isMainTaskTask.check()) {
                        en.mainTaskArea.c(en.isMainTaskTask, repeatedClickInterval)
                    } else {
                        en.mainTaskArea.c(repeatedClickInterval)
                    }
                } else if (nowStepType == TaskType.SIDE_QUEST) {
                    en.sideQuestArea.c()
                }
            }
        }
    }


}