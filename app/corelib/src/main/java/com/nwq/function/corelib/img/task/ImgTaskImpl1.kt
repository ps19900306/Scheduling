package com.nwq.function.corelib.img.task

import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

/**
create by: 86136
create time: 2023/5/13 14:22
Function description:
 */
class ImgTaskImpl1(
    pointList: List<CoordinatePoint>,
    ruleList: List<ColorIdentificationRule>,
    range: Int = 0 //初始图片的寻找范围
) : ImgTask(pointList, ruleList) {

    private var hasCorrect = range <= 0

    fun isCorrect(): Boolean {
        return hasCorrect
    }

    fun correctCoordinate(offsetX: Int, offsetY: Int) {
        if (!hasCorrect) {
            hasCorrect = true
            for (coordinatePoint in pointList) {
                coordinatePoint.x += offsetX
                coordinatePoint.y += offsetY
            }
        }
    }
}