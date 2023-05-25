package com.nwq.function.corelib.img.pcheck

import android.graphics.Bitmap
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

//单点对应多规则
class PointRules(val point: CoordinatePoint, val rule: List <ColorIdentificationRule>) :IPR{

    override fun getCoordinatePoint(): CoordinatePoint {
        return point
    }

    override fun checkIpr(bitmap: Bitmap, offsetX: Int, offsetY: Int): Boolean {
        val intColor = bitmap.getPixel(point.xI + offsetX, point.yI + offsetY)
        return rule.find { it.optInt(intColor) } != null
    }


}