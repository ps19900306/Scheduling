package com.android.system.talker.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {

    @Insert
    fun insert(data: TaskDb)

    @Delete
    fun delete(data: TaskDb)

    @Query("SELECT * FROM task where userid =:userId")
    fun queryByUserId(userId: Long): TaskDb?
}