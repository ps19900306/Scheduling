package com.android.system.talker.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: TaskDb)

    @Delete
    fun delete(data: TaskDb)

    @Update
    fun update(data: TaskDb)

    @Query("SELECT * FROM tasks where userid =:userId")
    fun queryByUserId(userId: Long): TaskDb?



}