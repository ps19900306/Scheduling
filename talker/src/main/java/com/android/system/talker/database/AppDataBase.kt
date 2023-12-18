package com.android.system.talker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserDb::class,
    MinerDb::class,
    TaskDb::class,
    VegetableDb::class], version = 1, exportSchema = false)
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

    abstract fun getTaskDao():TaskDao

    abstract fun getMinerDao():MinerDao

    abstract fun getVegetableDao():VegetableDao

}