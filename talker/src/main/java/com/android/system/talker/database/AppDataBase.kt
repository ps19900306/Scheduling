package com.android.system.talker.database

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [UserDb::class, VegetableDb::class], version = 1)
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

    abstract fun getUserDao():UserDao

    abstract fun getDailyGiftDao():DailyGiftDao

    abstract fun getTaskDao():TaskDao


    abstract fun getVegetableDao():VegetableDao

}