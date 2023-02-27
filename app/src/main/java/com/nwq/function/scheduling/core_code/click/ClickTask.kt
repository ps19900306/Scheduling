package com.nwq.function.scheduling.core_code.click

import com.nwq.function.scheduling.core_code.Coordinate

class ClickTask(
    val coordinates:List<Coordinate>,
    val delayTime: Long,
    val duration: Long
)

