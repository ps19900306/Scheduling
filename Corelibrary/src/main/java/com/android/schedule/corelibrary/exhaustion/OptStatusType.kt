package com.android.schedule.corelibrary.exhaustion

import androidx.annotation.IntDef
import java.lang.annotation.RetentionPolicy

@IntDef(
    OptStatusType.PRECISION,//精准操作

    OptStatusType.CARELESS,//粗心

    OptStatusType.REDUNDANCY,//多余的操作

    OptStatusType.BLUNDER,//失误 有机会失败

    OptStatusType.FAILURE,//


)
annotation class OptStatusType() {
    companion object {
        const val PRECISION = 1
        const val CARELESS = 2
        const val REDUNDANCY = 4
        const val BLUNDER = 8
        const val FAILURE = 16
    }
}


