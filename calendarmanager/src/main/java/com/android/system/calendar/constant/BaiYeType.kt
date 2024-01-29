package com.android.system.calendar.constant

import androidx.annotation.IntDef
import java.lang.annotation.RetentionPolicy

@IntDef(
    BaiYeType.YAO_LONG,
    BaiYeType.MU_KE,
    BaiYeType.DIAO_KE,
    BaiYeType.CAI_JIN,
)
annotation class BaiYeType() {
    companion object {
        const val YAO_LONG = 1
        const val MU_KE=2
        const val DIAO_KE= 3
        const val CAI_JIN= 4
    }
}


