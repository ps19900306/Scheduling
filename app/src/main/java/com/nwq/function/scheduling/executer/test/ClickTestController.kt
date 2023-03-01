package com.nwq.function.scheduling.executer.test

import com.nwq.function.scheduling.core_code.click.DirectionType
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController
import com.nwq.function.scheduling.utils.log.L
import kotlinx.coroutines.delay
import java.util.*

/**
create by: 86136
create time: 2023/3/1 10:59
Function description:
 */

class ClickTestController(helper: AccessibilityHelper) : TravelController(helper) {


    override suspend fun generalControlMethod() {
        testSlide()
        L.d("", "generalControlMethod", "ClickTestController", "nwq", "2023/3/1");
    }

    suspend fun moveLeft(){

    }


    suspend fun testClick(){
        for (i in 0 until 10){
            val x= (Math.random()*getBitmapWith()).toFloat()
            val y= (Math.random()*getBitmapHeight()).toFloat()
            click(x, y)
            L.d("x:$x y:$y", "testGetColor", "ClickTestController", "nwq", "2023/3/1");
            delay(500)
        }
    }

    suspend fun testSlide(){
        delay(3000)
        L.d("With:${getBitmapWith()} Height:${getBitmapHeight()}", "testGetColor", "ClickTestController", "nwq", "2023/3/1");
        for (i in 0 until 10){
            val x= ((Math.random()*0.4+0.3)*getBitmapWith()).toFloat()
            val y= ((Math.random()*0.4+0.2)*getBitmapHeight()).toFloat()
            L.d("x:$x y:$y", "testGetColor", "ClickTestController", "nwq", "2023/3/1");
            slide(x, y, ((Math.random()*0.2+0.1)*getBitmapWith()).toInt(),
                ((Math.random()*0.2+0.1)*getBitmapHeight()).toInt(),
                DirectionType.LEFT,
            )
            delay(500)
        }
    }
}