package com.nwq.function.corelib.click

import com.nwq.function.corelib.area.CoordinatePoint

class ClickTask(
    val coordinates:List<CoordinatePoint>,
    var delayTime: Long,
    val duration: Long
)

