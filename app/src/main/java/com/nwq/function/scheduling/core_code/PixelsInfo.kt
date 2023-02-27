package com.nwq.function.scheduling.core_code

/**
create by: 86136
create time: 2023/2/27 11:16
Function description:
 */

data class PixelsInfo(
    val startX: Int,
    val startY: Int,
    val width: Int,
    val height: Int,
    val stride: Int,
    val offset: Int = 0
) {
    companion object {
        fun buildPixelsInfo(coordinate: Coordinate, range: Int = 0): PixelsInfo {
            val startX = coordinate.x.toInt() - range
            val startY = coordinate.y.toInt() - range
            val width = range * 2 + 1
            val height = range * 2 + 1
            return PixelsInfo(startX, startY, width, height, width, 0)
        }
    }
}