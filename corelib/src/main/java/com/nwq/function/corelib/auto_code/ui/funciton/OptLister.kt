package com.nwq.function.corelib.auto_code.ui.funciton

import com.nwq.function.corelib.auto_code.ui.data.FeatureCoordinatePoint

interface OptLister {

    fun optPoint(@OptCmd cmd:Int)

    fun requestArea(@OptCmd cmd:Int)

    fun requestFeatureKey()

    fun showPoint(list:List<FeatureCoordinatePoint>)

}
