package com.nwq.function.scheduling.executer.img.pcheck


import android.graphics.Bitmap

import com.nwq.function.scheduling.executer.img.rule.ColorCompareRule
import com.nwq.function.scheduling.executer.area.CoordinatePoint


//单点对应单色
class TwoPointRule(val point1: CoordinatePoint, val point2: CoordinatePoint, val rule: ColorCompareRule) :
    IPR {

    override fun getCoordinatePoint(): CoordinatePoint {
         return point1
    }

    override fun checkIpr(bitmap: Bitmap,offsetX: Int, offsetY: Int): Boolean {
        val intColor1 = bitmap.getPixel(point1.xI + offsetX, point1.yI + offsetY)
        val intColor2 = bitmap.getPixel(point2.xI + offsetX, point2.yI + offsetY)
        return rule.optInt(intColor1, intColor2)
    }


}