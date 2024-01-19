package com.android.system.calendar.constant

import androidx.annotation.IntDef
import java.lang.annotation.RetentionPolicy

@IntDef(
    TaskType.MAIN_QUEST,//主线任务
    TaskType.SIDE_QUEST,//支线任务

)
annotation class TaskType() {
    companion object {
        const val MAIN_QUEST = 1
        const val SIDE_QUEST=2

    }
}


