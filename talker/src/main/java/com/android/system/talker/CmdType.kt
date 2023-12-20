package com.android.system.talker

import androidx.annotation.IntDef

@IntDef(
    CmdType.START,
    CmdType.CLOSE,
)
annotation class CmdType() {
    companion object {
        public const val START = 1
        public const val CLOSE = 2
    }
}