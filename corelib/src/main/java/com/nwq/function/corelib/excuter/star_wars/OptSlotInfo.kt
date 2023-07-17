package com.nwq.function.corelib.excuter.star_wars

import com.nwq.function.corelib.area.CoordinateArea

/**
create by: 86136
create time: 2023/7/17 15:30
Function description:
 */

data class OptSlotInfo(
    val clickArea: CoordinateArea,
    val interval: Long,
    var lastOpenedTime: Long = 0L,
    val offset: Int,
    val offsetInterval: Long,
)