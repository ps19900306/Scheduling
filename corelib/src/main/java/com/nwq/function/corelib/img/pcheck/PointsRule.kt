package com.nwq.function.corelib.img.pcheck

import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

//多点验证单规则
class PointsRule(val points: List<CoordinatePoint>, val rule: ColorIdentificationRule) : IPR {

    override fun getCoordinatePoint(): CoordinatePoint {
        return points[0]
    }
}