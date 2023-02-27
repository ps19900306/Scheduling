package com.nwq.function.scheduling.core_code.click

import androidx.annotation.IntDef

@IntDef(
    DirectionVaryType.INCREASE_X,
    DirectionVaryType.REDUCE_X,
    DirectionVaryType.INCREASE_Y,
    DirectionVaryType.REDUCE_Y,
)
annotation class DirectionVaryType(){
    companion object {
        public const val INCREASE_X = 1
        public const val REDUCE_X = 2
        public const val INCREASE_Y = 3
        public const val REDUCE_Y = 4
    }
}
