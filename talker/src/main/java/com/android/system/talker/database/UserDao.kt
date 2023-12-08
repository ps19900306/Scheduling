package com.android.system.talker.database

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE


import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import com.android.system.talker.enums.ShipType


@Dao
public interface UserDao {

    @Insert(onConflict = REPLACE)
    fun insert(userDb: UserDb)

    @Delete
    fun delete(userDb: UserDb)

    @Update
    fun update(userDb: UserDb)


    @Query("SELECT * FROM USERS")
    fun list(): List<UserDb>

    @Query("SELECT * FROM USERS where id=:id ")
    fun queryById(id: Long): UserDb?


}






