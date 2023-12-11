package com.android.system.talker.database

import android.widget.Switch
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.system.talker.enums.MenuType
import com.android.system.talker.enums.ShipType


@Entity(tableName = "users")
class UserDb() {
    @ColumnInfo(name = "account")
    var sccoutStr: String = ""

    //这个用于记录之前的船的状态
    var shipType: Int = ShipType.UNKNOWN


    var isChecked: Boolean = false
    //克隆的位置
    var baseCloneLocation: Int = -1

    var appLocationX: Int = 1
    var appLocationY: Int = 1



    var shortcutMenu1: Int = MenuType.WAREHOUSE
    var shortcutMenu2: Int = MenuType.TASK
    var shortcutMenu3: Int = MenuType.PLANETARY_MINE
    var shortcutMenu4: Int = MenuType.UNSET


    var dailyGiftSwitch: Boolean = true
    var dailyGiftTime: Long = 0L

    var activeGiftSwitch: Boolean = true
    var activeGiftTime: Long = 0L


    var agreementGiftSwitch: Boolean = true
    var agreementGiftTime: Long = 0L


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
}




