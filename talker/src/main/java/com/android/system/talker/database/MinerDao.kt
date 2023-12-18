package com.android.system.talker.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface MinerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: MinerDb)

    @Delete
    fun delete(data: MinerDb)

    @Update
    fun update(data: MinerDb)

    @Query("SELECT * FROM miner where userid =:userId")
    fun queryByUserId(userId: Long): MinerDb?



}