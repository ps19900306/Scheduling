package com.android.system.talker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.system.talker.enums.ShipType


@Entity(tableName = "tasks")
data class TaskDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0L,

    var userid: Long = -1L,//这个是UserDb的数据

    //上次完成时间
    var lastCompletionTime: Long = 0L,

    //基地位置
    var baseMenuLocation: Int = 0,

    //克隆的位置
    var baseCloneLocation: Int = 0,

    var errorStr: String = "",

    //功能的序列号
    var sort: Int = -1,

    var isSwitch: Int = 0,

    var needDelay: Boolean = false, //是否有些步骤需要延迟处理

    var shipType: Int = ShipType.TASK_SHIP
)




