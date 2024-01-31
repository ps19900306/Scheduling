package com.android.system.calendar.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "role")
class RoleDb {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0

    var zoneId:Long?=0L //游戏区域编号

    var roleLoginPostion:Int=1
    var roleName:String?=""

    var isChecked: Boolean = false

    //帮派跑商
    var bangMerchantSwitch: Boolean = true
    var bangMerchantTime: Long = 0L

    //帮派环任务
    var bangTaskSwitch: Boolean = true
    var bangTaskTime: Long = 0L

    // 山河映画
    var mountainsRiversPaintingSwitch: Boolean = true
    var mountainsRiversPaintingTime: Long = 0L

    // 师门任务
    var shiMenSwitch: Boolean = true
    var shiMenTime: Long = 0L

    //打图任务
    var treasureMapSwitch: Boolean = true
    var treasureMapeTime: Long = 0L

    //这个是挖图的
    var xunLongFenJinSwitch: Boolean = true
    var xunLongFenJinTime: Long = 0L

    //_____ 限时任务
    // 跑標
    var transportTreasureSwitch: Boolean = true
    var transportTreasureTime: Long = 0L

    //_____
    //每日礼物
    var dailyGiftSwitch: Boolean = true
    var dailyGiftTime: Long = 0L

    //_____
    //普通副本
    var dungeonOrdinarySwitch: Boolean = true
    var dungeonOrdinaryTime: Long = 0L


    //_____
    //马匪
    var hitHorseBanditsSwitch: Boolean = true
    var hitHorseBanditsTime: Long = 0L


}