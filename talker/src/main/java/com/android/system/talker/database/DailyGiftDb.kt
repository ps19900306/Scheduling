package com.android.system.talker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_gift")
class DailyGiftDb(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long,

                  var userid: Long,//这个是UserDb的数据

    //上次收菜完成时间
                  var lastCompletionTime: Long = 0L,
)