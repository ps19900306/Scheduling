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


    //上次收菜完成时间
    var lastCompletionTime: Long = 0L

    var isChecked: Boolean = false

    //基地位置
    var baseMenuLocation: Int = 0

    //克隆的位置
    var baseCloneLocation: Int = 0

    // 上次修改克隆时间的时间
    var lastChangeLocationTime: Long = 0L

    // 修改克隆地址的间隔时间
    var ChangeLocationInterval: Long = 25

    var needDelay: Boolean = false //是否有些步骤需要延迟处理

    var appLocationX: Int = 1
    var appLocationY: Int = 1


    var shortcutMenu1: Int = MenuType.WAREHOUSE
    var shortcutMenu2: Int = MenuType.TASK
    var shortcutMenu3: Int = MenuType.PLANETARY_MINE
    var shortcutMenu4: Int = MenuType.UNSET


    //这个是每日礼物
    var dailyGiftSwitch: Boolean = true
    var dailyGiftTime: Long = 0L

    //这个是三十天的礼物
    var activeGiftSwitch: Boolean = true
    var activeGiftTime: Long = 0L

    //这个是协议礼物
    var agreementGiftSwitch: Boolean = true
    var agreementGiftTime: Long = 0L


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}




