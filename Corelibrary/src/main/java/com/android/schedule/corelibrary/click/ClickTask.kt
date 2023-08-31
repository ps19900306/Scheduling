package com.android.schedule.corelibrary.click

import com.android.schedule.corelibrary.area.CoordinatePoint


class ClickTask(
    val coordinates:List<CoordinatePoint>,
    var delayTime: Long,
    val duration: Long
)

