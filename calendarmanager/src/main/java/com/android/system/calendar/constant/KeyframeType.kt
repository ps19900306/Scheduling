package com.android.system.calendar.constant

import androidx.annotation.IntDef
import java.lang.annotation.RetentionPolicy

@IntDef(
    GameStuckPoint.HOME_SCREEN_REMAIN,//在最前面卡住不动了


)
annotation class KeyframeType() {
    companion object {
        const val HOME_SCREEN_REMAIN = 1


    }
}


