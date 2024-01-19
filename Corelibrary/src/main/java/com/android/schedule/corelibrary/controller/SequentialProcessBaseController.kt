package com.android.schedule.corelibrary.controller

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.click.ClickTask
import com.android.schedule.corelibrary.click.SimpleClickUtils
import com.android.schedule.corelibrary.click.SlidingArea
import com.android.schedule.corelibrary.click.TwoFingerArea
import com.android.schedule.corelibrary.exhaustion.*
import com.android.schedule.corelibrary.img.img_rule.BasicImgTask
import com.android.schedule.corelibrary.img.img_rule.ImgTask
import com.android.schedule.corelibrary.img.img_rule.ImgTaskImpl1
import com.android.schedule.corelibrary.img.img_rule.MultiFindImgTask
import com.android.schedule.corelibrary.process_control.KeyframeStep
import com.android.schedule.corelibrary.process_control.StuckPointMonitoring
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.TimeUtils
import kotlinx.coroutines.delay

/**
create by: 86136
create time: 2023/8/28 10:06
Function description:这个做固定顺序流程
 */
abstract class SequentialProcessBaseController(
    acService: AccessibilityService,
) : TurnBaseController(acService) {

    //固定流程部分
    //监听卡点部分
    //一步一步的流程
    val screenshotIntervalV2
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.5 + 1)).toLong()

    protected suspend fun startTheProcess() {
        var flag = true
        val clickSpeedControl = getClickSpeedControl()
        val stuckList = getStuckPointMonitoring()
        val keyframeStepList =getKeyframeStepList()
        while (flag && runSwitch) {
            if (!taskScreenL(screenshotIntervalV2)) {
                runSwitch = false
                return
            }
            stuckList.find { it.gameIsStuck(screenBitmap!!) }?.let {
                onGameStuck(it.keyNumber)
            }
            if (isAutoOpt()) {
                L.d("正在自动操作中")
            } else if(verifyKeyframeStep(keyframeStepList)){//这里是关键帧
                L.d("一个关键帧流程 $nowStep" )
            } else {
                clickSpeedControl?.cc()
            }
        }
    }



    //这个是关键帧
    protected abstract suspend fun getKeyframeStepList(): List<KeyframeStep>

    //這個是
    protected abstract suspend fun getStuckPointMonitoring(): List<StuckPointMonitoring>
    protected abstract suspend  fun getClickSpeedControl(): ClickSpeedControl?

    //这个是正在自动寻路等操作
    protected abstract suspend fun isAutoOpt(): Boolean

    protected abstract suspend fun onGameStuck(type: Int)




    protected var nowStep = 0
    private suspend fun verifyKeyframeStep(list: List<KeyframeStep>):Boolean {
        // 这里表示流程已经跑完，或者没有
        if (list.size == 0 || nowStep >= list.size) {
            return false
        }
        if (nowStep == 0) {
            list.getOrNull(0)?.let {
                if (it.foundCheck.invoke()) {
                    it.nextOpt.invoke()
                    nowStep++
                    return true
                }
            }
        } else {
            list.getOrNull(nowStep)?.let {
                if (it.foundCheck.invoke()) {
                    it.nextOpt.invoke()
                    nowStep++
                    return true
                }
            }
            list.getOrNull(nowStep - 1)?.let {
                if (it.foundCheck.invoke()) {
                    it.nextOpt.invoke()
                    return true
                }
            }
        }
        return false
    }
}
