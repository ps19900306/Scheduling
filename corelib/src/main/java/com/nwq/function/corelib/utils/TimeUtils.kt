package com.nwq.function.corelib.utils


import com.nwq.function.corelib.Constant
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

    fun getDelayStart(): Long {
        val calendar = Calendar.getInstance();
        val day = calendar.get(Calendar.DAY_OF_WEEK)
        if (day == Calendar.THURSDAY) {
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            return when (hour) {
                8 -> {
                    1 * Constant.Hour + (60 - minute) * Constant.MINUTE
                }
                9 -> {
                    (60 - minute) * Constant.MINUTE
                }
                else -> {
                    0
                }
            }
        }
        return 0
    }

}