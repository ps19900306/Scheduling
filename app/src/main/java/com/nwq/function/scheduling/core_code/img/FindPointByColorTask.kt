package com.nwq.function.scheduling.core_code.img

import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.PixelsInfo

/**
create by: 86136
create time: 2023/2/27 14:01
Function description:
 */

data class FindPointByColorTask(
    val coordinate: Coordinate,
    val rangeX: Int = 0, //这个是为了范围取点
    val rangeY: Int = 0, //这个是为了范围取点
) {
    fun toPixelsInfo(): PixelsInfo {
        var with = 0
        var height = 0
        var startX = 0
        var startY = 0

        if (rangeX > 0) {
            with = rangeX * 2 + 1
            startX = (coordinate.x - rangeX).toInt()
        } else {
            with = 1
            startX = coordinate.x.toInt()
        }
        if (rangeY > 0) {
            height = rangeY * 2 + 1
            startY = (coordinate.y - rangeY).toInt()
        } else {
            height = 1
            startY = coordinate.y.toInt()
        }
        return PixelsInfo(startX, startY, with, height, with, 0)
    }

}
