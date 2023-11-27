package com.android.system.talker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.system.talker.enums.MenuType
import com.android.system.talker.enums.ShipType


@Entity(tableName = "users")
data class UserDb(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long,

    @ColumnInfo(name = "account")
    var sccoutStr: String,

    //这个用于记录之前的船的状态
    var shipType: Int = ShipType.UNKNOWN,


    var isChecked: Boolean = false,

    var appLocationX: Int = 1,
    var appLocationY: Int = 1,


    var shortcutMenu1: Int = MenuType.WAREHOUSE,
    var shortcutMenu2: Int = MenuType.TASK,
    var shortcutMenu3: Int = MenuType.PLANETARY_MINE,
    var shortcutMenu4: Int = MenuType.UNSET,

    )




