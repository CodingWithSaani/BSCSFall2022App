package com.tutorials180.bscsfall2022app.Lec7.RoomWorking

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class,Admin::class], version = 1)
abstract class UserDatabase:RoomDatabase() {

    abstract fun getUserDAOObject():UserDAO
}