package com.android.system.talker.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface VegetableDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: VegetableDb)

    @Delete
    fun delete(data: VegetableDb)

    @Update
    fun update(data: VegetableDb)

    @Query("SELECT * FROM vegetables where userid =:userId")
    fun queryByUserId(userId: Long): VegetableDb?

    @Query("SELECT * FROM vegetables")
    fun list(): List<VegetableDb>
}