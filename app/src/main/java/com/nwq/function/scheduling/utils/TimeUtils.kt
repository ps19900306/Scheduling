package com.nwq.function.scheduling.utils

import java.util.*

object TimeUtils {

    fun isNewTaskDay(time: Long): Boolean {
        if (time == 0L) return true
        val date = Date(time)
        val toyday = Date(System.currentTimeMillis())
        if (toyday.hours >= 8) {
            if (date.day < toyday.day || date.hours < 8) {
                return true
            }
        } else if (date.day + 1 < toyday.day || (date.day < toyday.day && date.hours < 8)) {
            return true
        }
        return false
    }

    fun isLateAtNight(time: Long): Boolean {
        if (time == 0L) return true
        val date = Date(time)
        val toyday = Date(System.currentTimeMillis())
        if (toyday.hours >= 8) {
            if (date.day < toyday.day || date.hours < 8) {
                return true
            }
        } else if (date.day + 1 < toyday.day || (date.day < toyday.day && date.hours < 8)) {
            return true
        }
        return false
    }
}