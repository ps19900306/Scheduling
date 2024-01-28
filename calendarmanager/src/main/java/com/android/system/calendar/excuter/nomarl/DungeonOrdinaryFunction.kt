package com.android.system.calendar.excuter.nomarl

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.controller.ClickSpeedControl
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.process_control.StuckJudePoint
import com.android.schedule.corelibrary.process_control.StuckPointMonitoring
import com.android.schedule.corelibrary.utils.L
import com.android.system.calendar.constant.DungeonOrdinaryType
import com.android.system.calendar.constant.GameStuckPoint
import kotlinx.coroutines.delay

class DungeonOrdinaryFunction(
    acService: AccessibilityService, en: ImageEnvironment,
    val typeList: MutableList<Int>,
) : BasicFunction(acService, en) {

    override suspend fun startFunction() {
        while (runSwitch && typeList.isNotEmpty()) {
            startDungeon(typeList.getOrNull(0) ?: 0)
        }
    }

    private suspend fun startDungeon(dungeonType: Int) {
        var flag = true
        var count = 40
        var hasSelect = false

        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }

            if (en.isDungeonExitBtnTask.check()) {
                flag = false
            }
            if (hasSelect) {
                if (en.isHuodongDiloagTask.check()) {
                    en.huodongDiloag1Area.c()
                } else if (en.isTotalCombatPowerTask.check()) {
                    mAutoFightingRecorder.updateInfo()
                    mAutoPathfindingRecorder.updateInfo()
                    if (mAutoFightingRecorder.isCloseErrorThresholds() && mAutoPathfindingRecorder.isCloseErrorThresholds()) {
                        hasSelect = false
                    }
                } else if (en.isTeamStatusTask.check()) {
                    en.closeTeamStatusArea.c(repeatedClickInterval)
                    delay(jumpClickInterval * 4)
                    hasSelect = false
                }else if (en.isOpenActivityMenuTask.check()){
                    en.closeBtnArea.c(repeatedClickInterval)
                }
            } else {
                if (en.isTotalCombatPowerTask.check()) {
                    openActivityNeed()
                } else if (en.isOpenActivityMenuTask.check()) {
                    if (en.isActivityNeedTask.check()) {
                        en.activityNeedArea.c()
                    } else if (en.findMultiplayerDungeonTaskTask.check()) {
                        en.startMultiplayerDungeonTaskArea.c(
                            en.findMultiplayerDungeonTaskTask,
                            repeatedClickInterval
                        )
                    }
                }else if (en.isMultiplayerDungeonMenuTask.check()) {
                    when (dungeonType) {
                        DungeonOrdinaryType.TIAN_NING_SHI -> {
                            if (en.findDungeonTianNingShiTask.check()) {
                                en.dungeonTianNingShiArea.c(
                                    en.findDungeonTianNingShiTask,
                                    repeatedClickInterval
                                )
                                hasSelect = true
                            }
                        }

                        DungeonOrdinaryType.QIN_HUAI -> {
                            if (en.findQinHuaiTask.check()) {
                                en.qinHuaiArea.c(
                                    en.findQinHuaiTask,
                                    repeatedClickInterval
                                )
                                hasSelect = true
                            }
                        }

                        DungeonOrdinaryType.MAN_TUO_SHAN -> {
                            if (en.findDungeonManTuoShanTask.check()) {
                                en.dungeonManTuoShanArea.c(
                                    en.findDungeonManTuoShanTask,
                                    repeatedClickInterval
                                )
                                hasSelect = true
                            }
                        }

                        else -> {
                            runSwitch = false
                        }
                    }
                }
            }
            count--
        }
        if (!flag) {
            typeList.remove(dungeonType)
            dungeonMoniter(dungeonType)
        }
    }


    private suspend fun dungeonMoniter(dungeonType: Int) {
        var flag = true
        val exitRecord = en.isDungeonExitBtnTask.toStatusRecorder(5, 5)
        while (flag && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)

            }
            if (en.isTotalCombatPowerTask.check()) {
                exitRecord.updateInfo()
                if (exitRecord.isCloseTrustThresholds()) {
                    flag = false
                }
            } else {
                exitRecord.clearUp()
            }
        }
    }

}