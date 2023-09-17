package com.android.schedule.corelibrary

/**
create by: 86136
create time: 2023/8/23 15:58
Function description:这里是一些默认设置
 */
object SetConstant {

    var uiAdaptation: UiAdaptation? = null

    const val SECOND = 1000L
    const val Hour = 1000L * 60 * 60
    const val MINUTE = 1000L * 60

    //这里是点击的间隔
    val clickDuration get() = ((Math.random() * 2 + 1) * 40).toLong()

//    val fastClickInterval
//        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.4 + 0.4)).toLong()

}