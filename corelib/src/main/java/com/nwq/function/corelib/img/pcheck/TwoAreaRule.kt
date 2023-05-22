package com.nwq.function.corelib.img.pcheck


import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.rule.ColorCompareRule
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

//单点对应单色
class TwoAreaRule(
    val area1: CoordinateArea,
    val area2: CoordinateArea,
    val rule: ColorCompareRule
) : IPR {

    override fun getCoordinatePoint(): CoordinatePoint {
        return CoordinatePoint(area1.x, area1.y)
    }

}