package com.nwq.function.corelib.img.pcheck


import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.rule.ColorCompareRule
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

//单点对应单色
class TwoPointRule(val point1: CoordinatePoint,val point2: CoordinatePoint, val rule: ColorCompareRule) : IPR {

    override fun getCoordinatePoint(): CoordinatePoint {
         return point1
    }

}