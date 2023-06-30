package com.nwq.function.corelib.excuter.star_wars

import android.accessibilityservice.AccessibilityService
import com.nwq.function.corelib.excuter.EndLister

/**
create by: 86136
create time: 2023/6/28 15:04
Function description:
挖矿的
 */
class InterstellarMiners(acService: AccessibilityService,endLister: EndLister?=null) : StarWarController(acService,endLister) {

    private val START_GAME = 0  //开始游戏
    private val MONITORING_RETURN_STATUS = 1//返回空间站监听
    private val WAIT_FOR_SAFE = 2//安全等待期
    private val OUT_SPAE = 3 //出空间站
    private val LOOKING_FOR_PLANETARY_GROUPS = 4//寻找资源行星
    private val MINING_MONITORING = 5//采矿监控期间



}