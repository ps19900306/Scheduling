package com.nwq.function.scheduling.executer.img.pcheck

import android.graphics.Bitmap
import com.nwq.function.scheduling.executer.area.CoordinatePoint
import com.nwq.function.scheduling.executer.img.rule.ColorIdentificationRule


interface IPR {

    fun getCoordinatePoint(): CoordinatePoint

    fun getColorRule(): ColorIdentificationRule?{
        return  null
    }

    fun checkIpr(bitmap: Bitmap,offsetX: Int = 0, offsetY: Int = 0):Boolean
}

