package com.android.system.talker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.system.talker.R


@Entity(tableName = "vegetables")
data class VegetableDb(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long,

    var userid: Long,//这个是UserDb的数据

    val nameResInt: Int = R.string.harvest_setting,//这个是用于显示的

    //收菜第一个行星的位置
    var firstPosition: Int = 0,

    //菜种植数量
    var numberCount: Int = 0,

    //上次收菜完成时间
    var lastCompletionTime: Long = 0L,

    //上次增加时间  这里默认八小时
    var lastAddTime: Long = 0L,

    //基地位置
    var baseLocation: Int = 0,


    //收菜的间隔时间
    var interval: Int = 0,

    //功能的序列号
    var sort: Int = -1,

    var switch: Boolean = false

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


}




