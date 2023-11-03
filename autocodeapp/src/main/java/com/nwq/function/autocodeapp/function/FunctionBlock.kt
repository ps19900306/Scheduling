package com.nwq.function.autocodeapp.function

import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint


interface FunctionBlock {

    //单点选取平均色
    suspend fun addFeatureKey(vararg colorInt: Int){

    }

    fun optPoint(@OptCmd cmd: Int, vararg coordinatePoint: CoordinatePoint)


    fun optArea(@OptCmd cmd: Int, vararg area: CoordinateArea)

    fun generateCode()

    fun hideView()

    fun showView()



}