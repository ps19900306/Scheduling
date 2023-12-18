package com.android.system.talker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "miner")
class MinerDb (){

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long=0L

    var userid: Long = -1L//这个是UserDb的数据

    //上次完成时间
    var lastCompletionTime: Long = 0L

    //基地位置
    var baseMenuLocation: Int = 0

    //克隆的位置
    var baseCloneLocation: Int = -1


    var switch: Boolean = false

    var needDelay: Boolean = false //是否有些步骤需要延迟处理
}