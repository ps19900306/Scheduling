package com.android.system.talker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_gift")
class DailyGiftDb() {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
    var userid: Long = -1L//这个是UserDb的数据


    var lastCompletionTime: Long = -1L
}


