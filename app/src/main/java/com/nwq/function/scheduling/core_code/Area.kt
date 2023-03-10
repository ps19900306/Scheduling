package com.nwq.function.scheduling.core_code

data class Area(val x: Int, val y: Int,val with: Int,val height: Int){

    val coordinate get() = Coordinate( (x + (Math.random() * 0.6 + 0.2) * with).toFloat(), (y + (Math.random() * 0.6 + 0.2) * height).toFloat())
}
