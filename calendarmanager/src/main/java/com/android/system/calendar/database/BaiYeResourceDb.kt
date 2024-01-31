package com.android.system.calendar.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.system.calendar.constant.BaiYeType

@Entity(tableName = "role")
class BaiYeResourceDb {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0

    var roleId:Long?=0L //角色编号

    //資源類型
    var baiYeType:Int = BaiYeType.YAO_LONG

    var resourceX:Int =0

    var resourceY:Int =0
}