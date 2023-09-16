package com.nwq.function.autocodeapp.function

import androidx.annotation.IntDef


@IntDef(
    OptCmd.ADD_POINT,//原点必须为右上角
    OptCmd.DELETE_POINT,//原点必须为左上角
    OptCmd.ADD_FEATURE_KEY,//原点必须为左上角
    OptCmd.ADD_AREA,//原点必须为左上角
    OptCmd.FIND_IMAGE_AREA,//原点必须为左上角
    OptCmd.FILTER_OUT_AREAS,//原点必须为左上角
)
annotation class OptCmd() {
    companion object {
        const val ADD_POINT = 1
        const val DELETE_POINT = 2
        const val ADD_FEATURE_KEY = 3

        const val ADD_AREA = 4
        const val FIND_IMAGE_AREA = 5
        const val FILTER_OUT_AREAS = 6

    }
}