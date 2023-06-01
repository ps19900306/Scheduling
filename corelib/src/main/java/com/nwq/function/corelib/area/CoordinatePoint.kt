package com.nwq.function.corelib.area

import com.nwq.function.corelib.click.task.ClickTask

/**
create by: 86136
create time: 2023/5/5 10:43
Function description:
这里不用INT,这样生成的坐标带小数，触发点击更好用
 */
class CoordinatePoint(var x: Float, var y: Float) {

    constructor(x: Int, y: Int) : this(x.toFloat(), y.toFloat()) {

    }

    constructor(x: Double, y: Double) : this(x.toFloat(), y.toFloat()) {

    }


    fun toClickTask(): ClickTask {
        return ClickTask(listOf(this), 0, 0)
    }

    val xI
        get() = x.toInt()

    val yI
        get() = y.toInt()


    val xD
        get() = x.toDouble()

    val yD
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


    fun divergentPoint(range: Int): List<CoordinatePoint> {
        return if (range <= 0) {
            listOf(this)
        } else {
            val list = mutableListOf<CoordinatePoint>()
            for (x in xI-range  .. xI+range){
                for(y in yI-range  .. yI+range){
                    list.add(CoordinatePoint(x,y))
                }
            }

            list.sortedBy {
                Math.abs(it.xI - this.xI)+ Math.abs(it.yI - this.yI)
            }
            list
        }
    }

}