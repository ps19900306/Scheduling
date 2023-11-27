package com.android.system.talker.database

interface BasicFunctionItem {

    fun setSwitchStatus(b:Boolean)

    fun getSwitchStatus(b:Boolean):Boolean

    fun getSortNumber():Int

    fun setSortNumber(i:Int)

    fun getIdName():Int

    fun getLocalType():Int
}