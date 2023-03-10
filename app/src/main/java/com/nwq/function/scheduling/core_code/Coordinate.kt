package com.nwq.function.scheduling.core_code

data class Coordinate(val x: Float, val y: Float) {
    constructor(x: Int, y: Int) : this(x.toFloat(), y.toFloat())
    {

    }
}
