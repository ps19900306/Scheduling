package com.android.system.calendar.constant

import androidx.annotation.IntDef
import java.lang.annotation.RetentionPolicy

@IntDef(
    TaskType.MAIN_QUEST,//主线任务
    TaskType.SIDE_QUEST,//支线任务
    TaskType.SHEN_LONG,//这里是什么龙吟的
    TaskType.DANG_ZE_KOU,//荡贼寇
    TaskType.HAO_YOU_XIA,//豪友侠客
)
annotation class TaskType() {
    companion object {
        const val MAIN_QUEST = 1
        const val SIDE_QUEST=2
        const val SHEN_LONG= 3
        const val DANG_ZE_KOU= 4
        const val HAO_YOU_XIA= 5
    }
}


