package com.android.schedule.corelibrary.utils

import com.android.schedule.corelibrary.SetConstant
import kotlinx.coroutines.delay
import java.util.Calendar
import java.util.Calendar.SUNDAY
import kotlin.math.abs

object TimeUtils {


    fun judgingTheInterval(time1: Long, time2: Long, intervalTime: Long): Boolean {
        return abs(time2 - time1) > intervalTime
    }


    //这里判断超过估计间隔
    fun isAboveInterval(lastCompletionTime: Long, intervalHour: Int = 8): Boolean {
        return System.currentTimeMillis() - lastCompletionTime >= intervalHour * SetConstant.Hour
    }


    //这里用来对比是否需是新的一天
    fun isNewDay(lastCompletionTime: Long, refreshHour: Int = 8): Boolean {
        if (lastCompletionTime == 0L)
            return true
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

    fun getDelayTime(lastCompletionTime: Long, refreshHour: Int = 8): Long {
        if (lastCompletionTime == 0L)
            return 0L
        val lastCalendar = Calendar.getInstance();
        lastCalendar.timeInMillis = lastCompletionTime
        val lastHour = lastCalendar.get(Calendar.HOUR_OF_DAY)
        val lastDay = lastCalendar.get(Calendar.DAY_OF_MONTH)
        val lastMouth= lastCalendar.get(Calendar.MONTH)
        val dayFlag = if (lastHour >= refreshHour) {
            lastDay
        } else {
            lastDay - 1
        }

        val maxDayOfMouth = getDays(lastCalendar.get(Calendar.YEAR), lastMouth)

        val nowCalendar = Calendar.getInstance();
        if(dayFlag==maxDayOfMouth){
            if(lastMouth==Calendar.DECEMBER){//这里是十二月
                nowCalendar.set(nowCalendar.get(Calendar.YEAR)+1,Calendar.JANUARY,1,refreshHour,0,10)
            }else{
                nowCalendar.set(nowCalendar.get(Calendar.YEAR),lastMouth+1,1,refreshHour,0,10)
            }
        }else{
            nowCalendar.set(nowCalendar.get(Calendar.YEAR),lastMouth,dayFlag+1,refreshHour,0,10)
        }

        L.d("time${nowCalendar.get(Calendar.YEAR)} getDelayTime ${nowCalendar.get(Calendar.MONTH)}${nowCalendar.get(Calendar.MONTH)}")
        val time = nowCalendar.timeInMillis - System.currentTimeMillis()
        L.d("time${time} getDelayTime ${convertMillis(time)}")
        return time
    }


    private fun convertMillis(n: Long): String? {
        val a = n / (1000 * 60 * 60)
        val b = (n / 60000)%60
        val c = (n / 1000)%60
        return "$a:$b:$c"
    }



    //这里是用来判断是新的一周
    fun isNewWeek(lastCompletionTime: Long, refreshDay: Int = SUNDAY): Boolean {
       if (lastCompletionTime == 0L)
            return true

        val lastCalendar = Calendar.getInstance();
        lastCalendar.timeInMillis = lastCompletionTime
        val lastWeek = lastCalendar.get(Calendar.WEEK_OF_YEAR)
        val lastDay = lastCalendar.get(Calendar.DAY_OF_WEEK)

        val lastFlag = if (lastDay >= refreshDay) {
            lastWeek
        } else {
            lastWeek - 1
        }

        val nowCalendar = Calendar.getInstance();
        val nowWeek = nowCalendar.get(Calendar.WEEK_OF_YEAR)
        val nowDay = nowCalendar.get(Calendar.DAY_OF_WEEK)

        val nowFlag = if (nowDay > refreshDay) {
            nowWeek
        } else {
            nowWeek - 1
        }
        return nowFlag != lastFlag
    }

    //这里是用来判断是新的一月
    fun isNewMouth(lastCompletionTime: Long, pickDay: Int = 30): Boolean {
        if (lastCompletionTime == 0L)
            return true
        val lastCalendar = Calendar.getInstance();
        lastCalendar.timeInMillis = lastCompletionTime
        val lastMouth = lastCalendar.get(Calendar.MONTH)
        val lastDay = lastCalendar.get(Calendar.DAY_OF_MONTH)

        val lastMaxDay = getDays(lastCalendar.get(Calendar.YEAR), lastMouth)
        val lastFlag = if (lastDay >= pickDay || lastDay>=lastMaxDay) {
            lastMouth
        } else {
            lastMouth - 1
        }

        val nowCalendar = Calendar.getInstance();
        val month = nowCalendar.get(Calendar.MONTH)
        if (lastFlag == month)
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


    fun getNowTime(time:Long= System.currentTimeMillis()): String {
        val calendar = Calendar.getInstance();
        calendar.timeInMillis = time
        return  "${calendar.get(Calendar.DAY_OF_MONTH)}日${calendar.get(Calendar.HOUR_OF_DAY)}时"
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
