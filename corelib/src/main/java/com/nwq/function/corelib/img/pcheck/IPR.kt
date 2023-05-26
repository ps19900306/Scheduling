package com.nwq.function.corelib.img.pcheck

import android.graphics.Bitmap
import com.nwq.function.corelib.area.CoordinatePoint


interface IPR {

    fun getCoordinatePoint(): CoordinatePoint


    fun checkIpr(bitmap: Bitmap,offsetX: Int = 0, offsetY: Int = 0):Boolean
}

