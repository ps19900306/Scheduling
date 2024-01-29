package com.android.system.calendar.excuter.nomarl

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.utils.L
import com.android.system.calendar.constant.BaiYeType
import kotlinx.coroutines.delay


//di yi  x=0 y=0
class BaiYeFunction(
    val bayYeType: Int,
    val x: Int,
    val y: Int,
    acService: AccessibilityService,
    en: ImageEnvironment
) : BasicFunction(acService, en) {


    override suspend fun startFunction() {
        var flag = true
        var count = 40
        var hasClick = false
        val resLocationArea = en.selectCaiJiLocationArea(x, y)
        while (flag && count > 0 && runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)

            }
            if (en.isTotalCombatPowerTask.check()) {
                if (hasClick) {
                    flag = false
                } else if (en.isMainBaiYeBtnTask.check()) {
                    en.mainBaiYeBtnArea.c(repeatedClickInterval)
                } else {
                    en.switchMainMenuBtnArea.c(repeatedClickInterval)
                }
            } else if (en.isOpenBaiYeMenuTask.check()) {
                when (bayYeType) {
                    BaiYeType.YAO_LONG -> {
                        en.baiYeYaoArea.c(repeatedClickInterval)
                    }

                    BaiYeType.MU_KE -> {
                        en.baiYeMuArea.c(repeatedClickInterval)
                    }

                    BaiYeType.DIAO_KE -> {
                        en.baiYeDiaoArea.c(repeatedClickInterval)
                    }

                    BaiYeType.CAI_JIN -> {
                        en.baiYeJinArea.c(repeatedClickInterval)
                    }
                }
            } else if ((bayYeType == BaiYeType.YAO_LONG && en.isOpenBaiYeYaoMenuTask.check()) ||
                (bayYeType == BaiYeType.MU_KE && en.isOpenBaiYeMuMenuTask.check()) ||
                (bayYeType == BaiYeType.DIAO_KE && en.isOpenBaiYeDiaoMenuTask.check()) ||
                (bayYeType == BaiYeType.CAI_JIN && en.isOpenBaiYeJinMenuTask.check())
            ) {
                resLocationArea.c(repeatedClickInterval)
                delay(clickInterval)
                en.clickBaiYeQianWangArea.c(repeatedClickInterval)
            } else if (en.isShiJiMapTask.check()) {
                L.d("isShiJiMapTask")
                when (bayYeType) {
                    BaiYeType.YAO_LONG -> {
                        if (en.finBaiYeLongResourceTask.check()) {
                            L.d("finBaiYeLongResourceTask")
                            en.baiYeLongResourceArea.c(
                                en.finBaiYeDiaoResourceTask,
                                repeatedClickInterval
                            )
                            hasClick = true
                        }
                    }

                    BaiYeType.MU_KE -> {
                        if (en.finBaiYeMuResourceTask.check()) {
                            L.d("finBaiYeMuResourceTask")
                            en.baiYeMuResourceArea.c(
                                en.finBaiYeDiaoResourceTask,
                                repeatedClickInterval
                            )
                            hasClick = true
                        }
                    }

                    BaiYeType.DIAO_KE -> {
                        if (en.finBaiYeDiaoResourceTask.check()) {
                            L.d("finBaiYeDiaoResourceTask")
                            en.baiYeDiaoResourceArea.c(
                                en.finBaiYeDiaoResourceTask,
                                repeatedClickInterval
                            )
                            hasClick = true
                        }
                    }

                    BaiYeType.CAI_JIN -> {
                        if (en.finBaiYeJinResourceTask.check()) {
                            L.d("finBaiYeJinResourceTask")
                            en.baiYeJinResourceArea.c(
                                en.finBaiYeDiaoResourceTask,
                                repeatedClickInterval
                            )
                            hasClick = true
                        }
                    }
                }
            }
            count--
        }
        if (!flag) {
            processListening()
        }
    }

    private suspend fun processListening() {
        L.d("执行监听")
        val mainStuckPoint = getMainStuckPointMonitoring()
        val clickSpeedControl = getNormalClickSpeedControl()


        val caijiRecorder = en.isCaiJiZhongTask.toStatusRecorder(5, 10)
        while (runSwitch) {
            if (!taskScreenL(screenshotIntervalF)) {
                reportingError(ABNORMAL_SCREENO_ORIENTATION)
            }
            if (en.isTotalCombatPowerTask.check()) {//正在主界面
                L.d("正在主界面")
                clickSpeedControl.clearTag()
                caijiRecorder.updateInfo()
                mAutoPathfindingRecorder.updateInfo()
                if (mAutoPathfindingRecorder.isCloseErrorThresholds() && caijiRecorder.isCloseErrorThresholds()) {
                    mainStuckPoint.trustThreshold = 3
                } else if (mAutoPathfindingRecorder.isCloseTrustThresholds() && caijiRecorder.isCloseTrustThresholds()) {
                    mainStuckPoint.trustThreshold = 5
                } else {
                    mainStuckPoint.recordNoChange = 0
                }
                if (mainStuckPoint.gameIsStuck(screenBitmap!!)) { //如果卡点
                    //結束幫派任務
                    runSwitch = false
                }
            }
            clickSpeedControl.cc()
        }
    }


}