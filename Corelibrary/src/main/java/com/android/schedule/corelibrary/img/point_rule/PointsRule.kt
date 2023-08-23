package com.android.schedule.corelibrary.img.point_rule

import android.graphics.Bitmap
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.img.color_rule.ColorIdentificationRule

//多点验证单规则
class PointsRule(val points: List<CoordinatePoint>, val rule: ColorIdentificationRule) : IPR {

    override fun getCoordinatePoint(): CoordinatePoint {
        return points[0]
    }

    override fun checkIpr(bitmap: Bitmap, offsetX: Int, offsetY: Int): Boolean {
        return points.find { point ->
            val intColor = bitmap.getPixel(point.xI + offsetX, point.yI + offsetY)
            rule.optInt(intColor)
        } != null
    }

    override fun getColorRule(): ColorIdentificationRule {
        return rule
    }
}