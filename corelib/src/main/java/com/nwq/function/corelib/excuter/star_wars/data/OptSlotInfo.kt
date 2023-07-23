package com.nwq.function.corelib.excuter.star_wars.data

import com.nwq.function.corelib.area.CoordinateArea

/**
create by: 86136
create time: 2023/7/17 15:30
Function description:
 */

data class OptSlotInfo(
    val clickArea: CoordinateArea,
    var lastOpenedTime: Long = 0L,
    var selfInterval:Long = 30*1000L,
    var offsetInterval:Long = 30*1000L
)