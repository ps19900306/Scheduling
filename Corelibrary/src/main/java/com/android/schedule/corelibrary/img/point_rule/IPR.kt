package com.android.schedule.corelibrary.img.point_rule

import android.graphics.Bitmap
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.img.color_rule.ColorIdentificationRule


interface IPR {

    fun getCoordinatePoint(): CoordinatePoint

    fun getColorRule(): ColorIdentificationRule?{
        return  null
    }

    fun checkIpr(bitmap: Bitmap,offsetX: Int = 0, offsetY: Int = 0):Boolean
}

