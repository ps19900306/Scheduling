package com.android.system.talker.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
public interface DailyGiftDao {

    @Insert
    fun insert(data: DailyGiftDb)

    @Delete
    fun delete(data: DailyGiftDb)

    @Query("SELECT * FROM daily_gift where userid =:userId")
    fun queryByUserId(userId: Long): DailyGiftDb?

}