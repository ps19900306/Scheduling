package com.nwq.function.corelib.area

/**
create by: 86136
create time: 2023/5/5 10:43
Function description:
这里不用INT,这样生成的坐标带小数，触发点击更好用
 */
class CoordinatePoint(val x: Float, val y: Float) {

    constructor(x: Int, y: Int) : this(x.toFloat(), y.toFloat()) {

    }

    constructor(x: Double, y: Double) : this(x.toFloat(), y.toFloat()) {

    }

    private val xI
        get() = x.toInt()

    private val yI
        get() = y.toInt()


    private val xD
        get() = x.toDouble()

    private val yD
        get() = y.toDouble()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CoordinatePoint) return false

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