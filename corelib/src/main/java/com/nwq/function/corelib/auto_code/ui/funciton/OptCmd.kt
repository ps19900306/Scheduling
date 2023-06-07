package com.nwq.function.corelib.auto_code.ui.funciton

import androidx.annotation.IntDef


@IntDef(
    OptCmd.ADD_POINT,//原点必须为右上角
    OptCmd.DELETE_POINT,//原点必须为左上角
    OptCmd.ADD_FEATURE_KEY,//原点必须为左上角
)
annotation class OptCmd() {
    companion object {
        const val ADD_POINT = 1
        const val DELETE_POINT = 2
        const val ADD_FEATURE_KEY = 3
    }
}