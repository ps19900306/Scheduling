package com.nwq.function.scheduling.core_code

import android.icu.text.Transliterator

/**
create by: 86136
create time: 2023/4/20 11:02
Function description:
 */

data class PositionLength(var position: Int, val length: Int) {

    val getPercentage
        get() = (position.toFloat() * 100 / length.toFloat()).toInt()

}