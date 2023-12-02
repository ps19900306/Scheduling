package com.android.system.talker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.system.talker.R
import com.android.system.talker.enums.MenuType
import com.android.system.talker.enums.ShipType


@Entity(tableName = "vegetables")
data class VegetableDb(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long,

    var userid: Long,//这个是UserDb的数据

    val nameResInt: Int = R.string.harvest_setting,//这个是用于显示的

    //基地位置
    var baseLocation: Int = 0,

    //菜种植数量
    var numberCount: Int = 0,

    //上次收菜完成时间
    var lastCompletionTime: Long = 0L,

    //收菜的间隔时间
    var completeInterval: Int = 24 * 4,

    //上次增加时间  这里默认八小时
    var lastAddTime: Long = 0L,

    //收菜的间隔时间
    var addInterval: Int = 6,


    //功能的序列号
    var sort: Int = -1,

    var switch: Boolean = false,

    //这个用于记录之前的船的状态
    val shipType: Int = ShipType.VEGETABLE_SHIP,

    val menuType: Int = MenuType.PLANETARY_MINE

    ) : BasicFunctionItem {
    override fun setSwitchStatus(b: Boolean) {
        switch = b
    }

    override fun getSwitchStatus(b: Boolean): Boolean {
        return switch
    }

    override fun getSortNumber(): Int {
        return sort
    }

    override fun setSortNumber(i: Int) {
        sort = i
    }

    override fun getIdName(): Int {
        return nameResInt
    }

    override fun getLocalType(): Int {
        return baseLocation
    }


}




