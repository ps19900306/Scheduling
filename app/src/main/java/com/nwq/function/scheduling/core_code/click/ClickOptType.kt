package com.nwq.function.scheduling.core_code.click

import androidx.annotation.IntDef
import java.lang.annotation.RetentionPolicy

@IntDef(
    ClickOptType.SINGLE_CLICK,
    ClickOptType.SINGLE_slide,
    ClickOptType.ADDITIONAL_CLICKS,
    ClickOptType.ADDITIONAL_SLIDE,
)
annotation class ClickOptType() {
    companion object {
        public const val SINGLE_CLICK = 1
        public const val SINGLE_slide = 2

        public const val ADDITIONAL_CLICKS = 3
        public const val ADDITIONAL_SLIDE = 4
    }
}