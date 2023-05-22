package com.nwq.function.corelib.img.pcheck

import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

//单点对应多规则
class PointRules(val point: CoordinatePoint, val rule: List <ColorIdentificationRule>) :IPR{

    override fun getCoordinatePoint(): CoordinatePoint {
        return point
    }


}