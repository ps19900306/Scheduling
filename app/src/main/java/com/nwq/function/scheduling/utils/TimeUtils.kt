package com.nwq.function.scheduling.utils

import android.provider.ContactsContract
import com.nwq.function.scheduling.core_code.Constant
import com.nwq.function.scheduling.utils.sp.SPRepoPrefix
import kotlinx.coroutines.delay
import java.util.*

object TimeUtils {

    fun isNewTaskDay(spReo: SPRepoPrefix): Boolean {
        val nowDate = Date(System.currentTimeMillis())
        if (spReo.dailytaskstime == 0 || spReo.dailytaskstime > 365) {
            spReo.dailytaskstime = nowDate.day
            return true
        }
        if (spReo.dailytaskstime < nowDate.day) {
            spReo.dailytaskstime = nowDate.day
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