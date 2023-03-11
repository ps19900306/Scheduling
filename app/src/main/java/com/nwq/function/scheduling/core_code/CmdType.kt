package com.nwq.function.scheduling.core_code

import androidx.annotation.IntDef

@IntDef(
    CmdType.START,
    CmdType.CLOSE,
    CmdType.CHECK_COLOR,
)
annotation class CmdType() {
    companion object {
        public const val START = 1
        public const val CLOSE = 2
        public const val CHECK_COLOR = 3

    }
}