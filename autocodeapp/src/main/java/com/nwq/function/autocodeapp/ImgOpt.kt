package com.nwq.function.autocodeapp

import android.graphics.Bitmap
import com.android.schedule.corelibrary.utils.NwqCallBack

object ImgOpt {
    var getbitmap:NwqCallBack<Bitmap?>? = null
    var takeBitmap:NwqCallBack<Boolean>? = null
    var optFunction:NwqCallBack<Boolean>? = null

}