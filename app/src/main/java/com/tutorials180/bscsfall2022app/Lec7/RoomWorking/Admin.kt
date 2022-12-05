package com.tutorials180.bscsfall2022app.Lec7.RoomWorking

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Admin(@PrimaryKey val id:Int,
val adminName:String)
