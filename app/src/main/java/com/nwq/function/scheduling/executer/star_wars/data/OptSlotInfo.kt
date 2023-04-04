package com.nwq.function.scheduling.executer.star_wars.data

/**
create by: 86136
create time: 2023/4/4 16:40
Function description:
 */

data class OptSlotInfo(
    val slotPosition: Int,
    val interval: Long,
    var lastOpenedTime: Long = 0L,
    val offset: Int,
    val offsetInterval: Long,
)