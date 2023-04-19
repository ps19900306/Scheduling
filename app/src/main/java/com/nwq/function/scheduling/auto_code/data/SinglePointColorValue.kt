package com.nwq.function.scheduling.auto_code.data

/**
create by: 86136
create time: 2023/4/10 11:30
Function description:
 */

data class SinglePointColorValue(val x:Int,val y:Int,val red:Int,val green:Int,val blue:Int) {
    override fun toString(): String {
        return "x=$x,y=$y,red=$red,green=$green,blue=$blue"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SinglePointColorValue) return false

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }


}


