package com.android.schedule.corelibrary.utils

import com.android.schedule.corelibrary.SetConstant
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Calendar.THURSDAY
import java.util.Date

object TimeUtils {

    //这里判断超过估计间隔
    fun isAboveInterval(lastCompletionTime: Long, intervalHour: Int = 8): Boolean {
        return System.currentTimeMillis() - lastCompletionTime >= intervalHour * SetConstant.Hour
    }


    //这里用来对比是否需是新的一天
    fun isNewDay(lastCompletionTime: Long, refreshHour: Int = 8): Boolean {
        val lastCalendar = Calendar.getInstance();
        lastCalendar.timeInMillis = lastCompletionTime
        val lastHour = lastCalendar.get(Calendar.HOUR_OF_DAY)
        val lastDay = lastCalendar.get(Calendar.DAY_OF_YEAR)

        val lastFlag = if (lastHour >= refreshHour) {
            lastDay
        } else {
            lastDay - 1
        }

        val nowCalendar = Calendar.getInstance();
        val nowHour = nowCalendar.get(Calendar.HOUR_OF_DAY)
        val nowDay = nowCalendar.get(Calendar.DAY_OF_YEAR)

        val nowFlag = if (nowHour >= refreshHour) {
            nowDay
        } else {
            nowDay - 1
        }
        return nowFlag != lastFlag
    }

    //这里是用来判断是新的一周
    fun isNewWeek(lastCompletionTime: Long, refreshDay: Int = THURSDAY): Boolean {
        val lastCalendar = Calendar.getInstance();
        lastCalendar.timeInMillis = lastCompletionTime
        val lastWeek = lastCalendar.get(Calendar.WEEK_OF_YEAR)
        val lastDay = lastCalendar.get(Calendar.DAY_OF_WEEK)

        val lastFlag = if (lastDay > refreshDay) {
            lastWeek
        } else {
            lastWeek - 1
        }

        val nowCalendar = Calendar.getInstance();
        val nowWeek = nowCalendar.get(Calendar.WEEK_OF_YEAR)
        val nowDay = nowCalendar.get(Calendar.DAY_OF_YEAR)

        val nowFlag = if (nowDay > refreshDay) {
            nowWeek
        } else {
            nowWeek - 1
        }
        return nowFlag != lastFlag
    }

    //这里是用来判断是新的一周
    fun isNewMouth(lastCompletionTime: Long, pickDay: Int = 30): Boolean {
        val lastCalendar = Calendar.getInstance();
        lastCalendar.timeInMillis = lastCompletionTime
        val lastMouth = lastCalendar.get(Calendar.MONTH)

        val nowCalendar = Calendar.getInstance();
        val month = nowCalendar.get(Calendar.MONTH)
        if (lastMouth == month)
            return false

        val year = nowCalendar.get(Calendar.YEAR)
        val day = nowCalendar.get(Calendar.DAY_OF_MONTH)

        val maxDayOfMouth = getDays(year, month)
        if (maxDayOfMouth < pickDay) {
            return day == maxDayOfMouth
        } else {
            return day >= pickDay
        }
    }


    fun getDelayStart(): Long {
        val calendar = Calendar.getInstance();
        val day = calendar.get(Calendar.DAY_OF_WEEK)
        if (day == Calendar.THURSDAY) {
            if (calendar.get(Calendar.HOUR_OF_DAY) == 8) {
                return ((2 + Math.random() * 0.1) * SetConstant.Hour).toLong()
            }
        }
        return 0
    }

    private fun isLeap(year: Int): Boolean {
        return year % 100 == 0 && year % 400 == 0 || year % 100 != 0 && year % 4 == 0
    }


    fun getNowTime(): String {
        val dateFormat = SimpleDateFormat("mm月dd日hh时")
        return dateFormat.format(Date())
    }

    //返回当月天数
    private fun getDays(year: Int, month: Int): Int {
        return when (month) {
            1, 3, 5, 7, 8, 10, 12 -> {
                31
            }

            4, 6, 9, 11 -> {
                30
            }

            2 -> {
                if (isLeap(year))
                    29
                else
                    28
            }

            else -> {
                30
            }
        }
    }
}
