package com.android.schedule.corelibrary.expand


fun Int.toRgbInt(): Int {
    return if (this > 255) {
        255
    } else if (this <= 0) {
        0
    } else {
        this
    }
}