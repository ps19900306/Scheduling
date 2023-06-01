package com.nwq.function.corelib.auto_code

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.nwq.function.corelib.auto_code.ui.data.FeaturePointKey
import com.nwq.function.corelib.auto_code.ui.funciton.OptCmd

interface FunctionBlock {

    //单点选取平均色
    suspend fun addFeatureKey(vararg colorInt: Int)

    fun optPoint(@OptCmd cmd: Int, x: Int, y: Int, colorInt: Int)

    fun generateCode()
}