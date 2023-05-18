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
            if (calendar.get(Calendar.HOUR_OF_DAY) == 8) {
                return ((2 + Math.random() * 0.1) * Constant.Hour).toLong()
            }
        }
        return 0
    }

}