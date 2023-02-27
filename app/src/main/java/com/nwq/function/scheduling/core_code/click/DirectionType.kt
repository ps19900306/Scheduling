package com.nwq.function.scheduling.core_code.click

import androidx.annotation.IntDef
import java.lang.annotation.RetentionPolicy

@IntDef(
    DirectionType.LEFT,//原点必须为右上角
    DirectionType.RIGHT,//原点必须为左上角
    DirectionType.TOP,//原点必须为左边下角
    DirectionType.BOTTOM,//原点必须为左边上角
)
annotation class DirectionType() {
    companion object {
        public const val LEFT = 1
        public const val RIGHT = 2
        public const val TOP = 3
        public const val BOTTOM = 4
    }
}