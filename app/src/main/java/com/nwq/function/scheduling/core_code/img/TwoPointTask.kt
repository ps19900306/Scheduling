package com.nwq.function.scheduling.core_code.img

import com.nwq.function.scheduling.core_code.Coordinate

/**
create by: 86136
create time: 2023/3/2 10:49
Function description:
 */

data class TwoPointTask(
    val coordinate1: Coordinate,
    val coordinate2: Coordinate,
    val twoPointComparison: TwoPointComparison,
)

