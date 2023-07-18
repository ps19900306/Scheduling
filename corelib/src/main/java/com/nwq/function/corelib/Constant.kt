package com.nwq.function.corelib

object Constant {
    const val SLIDE_BASE_TIME = 200
    const val DISTANCE_UNIT = 100
    const val DISTANCE_TIME_UNIT = 10
    const val DURATION_TIME_UNIT = 300

    const val CMD = "cmd"

    const val Hour = 1000L * 60 * 60
    const val MINUTE = 1000L * 60

    const val STANDARD_CLICK_INTERVAL = 2000
    val fastClickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.2 + 0.3)).toLong()

    val normalClickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.4 + 0.7)).toLong()

    val doubleClickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.6 + 1.6)).toLong()

    val tripleClickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 0.8 + 2.4)).toLong()

    val quadrupleClickInterval
        get() = (STANDARD_CLICK_INTERVAL * (Math.random() * 1 + 3.2)).toLong()


    val clickDuration
        get() = (200 * (Math.random() + 0.5)).toLong()


    val clickIntervals
        get() = ((Math.random() * 0.7 + 1) * 200).toLong()
}