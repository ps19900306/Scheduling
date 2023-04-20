package com.nwq.function.scheduling.core_code

data class Coordinate(val x: Float, val y: Float) {
    constructor(x: Int, y: Int) : this(x.toFloat(), y.toFloat()) {

    }

    constructor(x: Double, y: Double) : this(x.toFloat(), y.toFloat()) {

    }

    private val xI
        get() = x.toInt()

    private val yI
        get() = y.toInt()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Coordinate) return false

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }



}
