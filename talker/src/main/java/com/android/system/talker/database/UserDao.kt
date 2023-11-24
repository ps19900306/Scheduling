package com.android.system.talker.database

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import com.android.system.talker.enums.ShipType



@Dao
public interface UserDao{

    @Insert
    fun insert(userDb: UserDb)

    @Delete
    fun delete(userDb: UserDb)

    @Query("SELECT * FROM USERS")
    fun list():List<UserDb>

    @Query("UPDATE USERS SET isChecked  = 0 ")
    fun setAllUnCheck()



}






