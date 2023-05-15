package com.nwq.function.corelib.click.task

import com.nwq.function.corelib.area.CoordinateArea

class ContinuousClickTask(
    val area: CoordinateArea,
    val intervalTime: Long,
    var lastClickTime: Long = 0L,
)

