package com.android.schedule.corelibrary.click

import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint

/**
create by: 86136
create time: 2023/8/31 14:55
Function description:
 */

class ClickArea(
    var x: Int,
    var y: Int,
    var width: Int,
    var height: Int,
    var isRotundity: Boolean = false
) {

    var offsetX: Int = 0
    var offsetY: Int = 0

    fun setOffset(ofstX: Int, ofstY: Int) {
        offsetX = ofstX
        offsetY = ofstY
    }

    private val centerPoint = CoordinatePoint(x + width / 2, y + height / 2) //中心点
    private val minimumDiameter = (if (width>height)  height else width)  //最小半径



}