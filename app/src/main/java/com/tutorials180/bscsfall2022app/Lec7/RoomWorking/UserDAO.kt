package com.tutorials180.bscsfall2022app.Lec7.RoomWorking

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO
{
    @Query("select * from UserTable")
    fun getAllUser():List<User>

    @Insert
    fun insertOneUser(mUser:User):Long
}