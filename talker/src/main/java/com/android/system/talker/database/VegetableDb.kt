package com.android.system.talker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.system.talker.enums.MenuType
import com.android.system.talker.enums.ShipType


@Entity(tableName = "vegetables")
data class VegetableDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0L,

    var userid: Long = -1L,//这个是UserDb的数据


    //基地位置
    var baseMenuLocation: Int = 0,

    //克隆的位置
    var baseCloneLocation: Int = 1,

    //菜种植数量
    var numberCount: Int = 6,

    //上次收菜完成时间
    var lastCompletionTime: Long = 0L,

    var errorStr: String = "",

    //收菜的间隔时间
    var completeInterval: Int = 24 * 4,

    //上次增加时间  这里默认八小时
    var lastAddTime: Long = 0L,

    //收菜的间隔时间
    var addInterval: Int = 6,
    var needDelay: Boolean = false, //是否有些步骤需要延迟处理

    //功能的序列号
    var sort: Int = -1,

    var isSwitch: Boolean = false,

    // 需要的飞船类型
    var shipType: Int = ShipType.VEGETABLE_SHIP,

    var menuType: Int = MenuType.PLANETARY_MINE,
)




