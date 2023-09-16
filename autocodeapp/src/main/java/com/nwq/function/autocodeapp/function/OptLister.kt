package com.nwq.function.autocodeapp.function

import android.content.ClipboardManager
import com.android.schedule.corelibrary.area.CoordinatePoint


interface OptLister {

    fun optPoint(@OptCmd cmd: Int)

    fun requestArea(@OptCmd cmd: Int)

    fun showPoint(list: List<CoordinatePoint>)

    fun getPointColor(x: Int, y: Int): Int

    fun getPointColor(
        x: Int,
        y: Int,
        width: Int,
        height: Int,
    ): IntArray

    fun getClipboardManager(): ClipboardManager

    fun fullScreen()

}
