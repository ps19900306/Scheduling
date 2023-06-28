package com.nwq.function.corelib.click.task

import com.nwq.function.corelib.baseIf.BasicTask
import com.nwq.function.corelib.area.CoordinatePoint

class ClickTask(
    val coordinates:List<CoordinatePoint>,
    var delayTime: Long,
    val duration: Long
): BasicTask

