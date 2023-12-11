package com.android.system.talker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.system.talker.R


@Entity(tableName = "task")
class TaskDb()  {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

    var userid: Long = -1L//这个是UserDb的数据

    var nameResInt: Int = R.string.harvest_setting//这个是用于显示的

    //上次收菜完成时间
    var lastCompletionTime: Long = 0L

    //基地位置
    var baseMenuLocation: Int = 0

    //克隆的位置
    var baseCloneLocation: Int = -1

    //功能的序列号
    var sort: Int = -1

    var switch: Boolean = false

}




