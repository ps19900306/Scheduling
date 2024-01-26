package com.android.system.calendar.constant

import androidx.annotation.IntDef

@IntDef(
    DungeonOrdinaryType.TIAN_NING_SHI,
    DungeonOrdinaryType.YAN_ZI_WU,
    DungeonOrdinaryType.MAN_TUO_SHAN,
)
annotation class DungeonOrdinaryType() {
    companion object {
        const val TIAN_NING_SHI = 1
        const val YAN_ZI_WU = 2
        const val MAN_TUO_SHAN = 3
    }
}


