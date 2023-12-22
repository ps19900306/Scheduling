package com.android.system.talker

import androidx.annotation.IntDef

@IntDef(
    CmdType.START,
    CmdType.CLOSE,
    CmdType.TAKE_IMG,
)
annotation class CmdType() {
    companion object {
        public const val START = 1
        public const val CLOSE = 2
        public const val TAKE_IMG = 3
    }
}