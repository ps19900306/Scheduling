package com.nwq.function.corelib.area

import com.nwq.function.corelib.click.task.ClickTask

/**
create by: 86136
create time: 2023/5/5 10:47
Function description:
 */

class CoordinateArea(
    var x: Int,
    var y: Int,
    var width: Int,
    var height: Int,
    var offsetX: Int = 0,
    var offsetY: Int = 0
) {


    fun setOffset(ofstX: Int, ofstY: Int) {
        offsetX = ofstX
        offsetY = ofstY
    }


    fun toClickTask(): ClickTask {
        return ClickTask(listOf(coordinate), 0, 0)
    }


    val coordinate
        get() = CoordinatePoint(
            (x + (Math.random() * 0.6 + 0.2) * width).toFloat()+offsetX ,
            (y + (Math.random() * 0.6 + 0.2) * height).toFloat()+offsetY
        )


    val fullCoordinate
        get() = CoordinatePoint(
            (x + Math.random() * width).toFloat()+offsetX ,
            (y + Math.random() * height).toFloat()+offsetY
        )

}