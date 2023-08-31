package com.android.schedule.corelibrary.click

import com.android.schedule.corelibrary.area.CoordinateArea


class ContinuousClickTask(
    val area: CoordinateArea,
    val intervalTime: Long,
    var lastClickTime: Long = 0L,
)

