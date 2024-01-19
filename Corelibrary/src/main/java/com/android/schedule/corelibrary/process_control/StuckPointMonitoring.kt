package com.android.schedule.corelibrary.process_control

import android.graphics.Bitmap
import com.android.schedule.corelibrary.area.CoordinatePoint

class StuckPointMonitoring(
    val keyNumber: Int,
    val preconditions: suspend () -> Boolean,
    val pointList: List<StuckJudePoint>,
    var trustThreshold: Int = 5
) {


    var recordNoChange = 0
    suspend fun gameIsStuck(bitmap: Bitmap): Boolean {
        if (preconditions.invoke()) {
            var count = 0
            pointList.forEach {
                val colorInt = bitmap.getPixel(it.x, it.y)
                if (colorInt == it.lastColor) {
                    count++
                } else {
                    it.lastColor = colorInt
                }
                if (pointList.size != count) {
                    recordNoChange++
                } else {
                    recordNoChange = 0
                }
                return recordNoChange > trustThreshold
            }
        }
        return false
    }


}


class StuckJudePoint(val x: Int, val y: Int, var lastColor: Int=-1)