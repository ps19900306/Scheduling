package com.android.schedule.corelibrary.exhaustion

import androidx.annotation.IntDef

@IntDef(
    OptRange.SMALL_PRECISION,//精准操作

    OptRange.WIDE_RANGE,//大范围的

    OptRange.FULL_RANGE,//全范围日

    OptRange.BEYOND_RANGE,//超越范围，范围外点击

    OptRange.ALL_OPT_RANGE,//全范围，范围外点击
)
annotation class OptRange {

    companion object {
        const val SMALL_PRECISION = 1
        const val WIDE_RANGE = 2
        const val FULL_RANGE = 4
        const val ALL_OPT_RANGE = 8
        const val BEYOND_RANGE = 16
    }

}