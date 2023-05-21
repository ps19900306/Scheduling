package com.nwq.function.corelib.img.pcheck


import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

//单点对应单色
class PointRule(val point: CoordinatePoint, val rule: ColorIdentificationRule) : IPR {

    override fun getCoordinatePoint(): CoordinatePoint {
        return point
    }

}