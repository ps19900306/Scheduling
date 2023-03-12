package com.nwq.function.scheduling.executer.test

import com.nwq.function.scheduling.core_code.click.DirectionType
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController
import kotlinx.coroutines.delay
import timber.log.Timber

/**
create by: 86136
create time: 2023/3/1 10:59
Function description:
 */

class ClickTestController(helper: AccessibilityHelper) : TravelController(helper) {


    override suspend fun generalControlMethod() {
        testGetColor()
    }

    suspend fun moveLeft(){

    }


    suspend fun testGetColor(){
        delay(3000)
        for (i in 0 until 100){
            helper.takeScreen()
            val x= (Math.random()*getBitmapWith()).toFloat()
            val y= (Math.random()*getBitmapHeight()).toFloat()
            val color = getColor(x.toInt(), y.toInt())
            Timber.d("x:$x y:$y color:${color?.toArgb().toString()}  testGetColor ClickTestController NWQ_ 2023/3/12");
            delay(500)
        }
    }

    suspend fun testClick(){
        for (i in 0 until 10){
            val x= (Math.random()*getBitmapWith()).toFloat()
            val y= (Math.random()*getBitmapHeight()).toFloat()
            click(x, y)
            Timber.d("x:$x y:$y  testClick ClickTestController NWQ_ 2023/3/12");
            delay(500)
        }
    }

    suspend fun testSlide(){
        delay(3000)
        Timber.d("With:${getBitmapWith()} Height:${getBitmapHeight()}  testSlide ClickTestController NWQ_ 2023/3/12");
        for (i in 0 until 10){
            val x= ((Math.random()*0.4+0.3)*getBitmapWith()).toFloat()
            val y= ((Math.random()*0.4+0.2)*getBitmapHeight()).toFloat()
            Timber.d("x:$x y:$y  testSlide ClickTestController NWQ_ 2023/3/12");
            slide(x, y, ((Math.random()*0.2+0.1)*getBitmapWith()).toInt(),
                ((Math.random()*0.2+0.1)*getBitmapHeight()).toInt(),
                DirectionType.LEFT,
            )
            delay(500)
        }
    }
}