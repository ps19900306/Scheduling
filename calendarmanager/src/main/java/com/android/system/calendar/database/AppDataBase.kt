package com.android.system.calendar.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


abstract class AppDataBase : RoomDatabase() {

    companion object {

        private var instance: AppDataBase? = null
        private const val DB_NAME = "sc_db"

        fun getInstance(context: Context):AppDataBase{
            return instance?:Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                DB_NAME
            ).build().apply {
                instance = this
            }
        }
    }


}