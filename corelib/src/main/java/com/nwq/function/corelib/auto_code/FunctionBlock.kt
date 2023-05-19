package com.nwq.function.corelib.auto_code

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.nwq.function.corelib.auto_code.ui.data.FeaturePointKey

interface FunctionBlock {

    //单点选取平均色
    fun addFeatureKey(colorInt: Int)

    //多点选择平均色
    fun addFeatureKey(colorInt: IntArray)



}