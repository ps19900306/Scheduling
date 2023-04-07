package com.nwq.function.scheduling.core_code.img

import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.PixelsInfo
import com.nwq.function.scheduling.core_code.SwipeArea

/**
create by: 86136
create time: 2023/4/7 15:46
Function description:
 */

data class FindImgTask(
    val pixelsInfo: PixelsInfo,
    val baseCoordinate: Coordinate,
    val colorList: List<Int>,
    val tolerance: Int = 3,
    val verifyList: List<PointColorVerification>,
    val clickArea: Area
)