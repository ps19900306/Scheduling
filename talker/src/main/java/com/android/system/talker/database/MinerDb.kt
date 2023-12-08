package com.android.system.talker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "miner")
data class MinerDb (@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long?=null )