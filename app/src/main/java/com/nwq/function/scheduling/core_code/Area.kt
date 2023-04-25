package com.nwq.function.scheduling.core_code

data class Area(var x: Int, var y: Int, val with: Int, val height: Int) {

    val coordinate
        get() = Coordinate(
            (x + (Math.random() * 0.6 + 0.2) * with).toFloat(),
            (y + (Math.random() * 0.6 + 0.2) * height).toFloat()
        )


    val fullCoordinate
        get() = Coordinate(
            (x + Math.random() * with).toFloat(),
            (y + Math.random() * height).toFloat()
        )


    constructor(x: Float, y: Float, x1: Float, y1: Float) : this(
        x.toInt(),
        y.toInt(),
        (x1 - x).toInt(),
        (y1 - y).toInt()
    )

}
