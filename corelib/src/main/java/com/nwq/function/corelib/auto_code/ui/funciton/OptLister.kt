package com.nwq.function.corelib.auto_code.ui.funciton

import android.content.ClipboardManager
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.auto_code.ui.data.FeatureCoordinatePoint

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
