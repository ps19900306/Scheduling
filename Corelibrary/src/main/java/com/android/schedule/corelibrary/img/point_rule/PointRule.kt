package com.android.schedule.corelibrary.img.point_rule


import android.graphics.Bitmap
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.img.color_rule.ColorIdentificationRule
import com.android.schedule.corelibrary.utils.L


//单点对应单色
class PointRule(val point: CoordinatePoint, val rule: ColorIdentificationRule) : IPR {

    override fun getCoordinatePoint(): CoordinatePoint {
        return point
    }

    override fun getColorRule(): ColorIdentificationRule {
        return rule
    }


    override fun checkIpr(bitmap: Bitmap, offsetX: Int, offsetY: Int): Boolean {
//        if (point.xI + offsetX < bitmap.width || point.yI + offsetY < bitmap.height) {
//            L.d("圖片不合規")
//            return false
//        }
        val intColor = bitmap.getPixel(point.xI + offsetX, point.yI + offsetY)
        //    Timber.d("x:${point.xI} y:${point.yI}  offsetX:$offsetX  offsetY:$offsetY red:${intColor.red} green:${intColor.green}  blue:${intColor.blue}");
        return rule.optInt(intColor)
    }

}