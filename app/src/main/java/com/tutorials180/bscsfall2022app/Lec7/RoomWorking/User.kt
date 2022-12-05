package com.tutorials180.bscsfall2022app.Lec7.RoomWorking

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserTable")
data class User (@PrimaryKey @ColumnInfo(name = "user_name") val name:String,
                 @ColumnInfo(name="user_email") val email:String)