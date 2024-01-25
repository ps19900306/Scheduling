package com.android.schedule.corelibrary.process_control

import android.graphics.Bitmap
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.utils.L

class StuckPointMonitoring(
    val keyNumber: Int,
    val preconditions: suspend () -> Boolean,
    val pointList: List<StuckJudePoint>,
    var trustThreshold: Int = 3
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
            }
            if (pointList.size == count) {
                L.d("检测点无变化")
                recordNoChange++
            } else {
                L.d("检测点有变化")
                recordNoChange = 0
            }
            if(recordNoChange > trustThreshold){
                recordNoChange = 0
                return true
            }
        }
        return false
    }


}


class StuckJudePoint(val x: Int, val y: Int, var lastColor: Int=-1)