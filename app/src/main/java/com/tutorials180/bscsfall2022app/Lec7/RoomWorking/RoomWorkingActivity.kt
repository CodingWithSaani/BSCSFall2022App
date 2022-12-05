package com.tutorials180.bscsfall2022app.Lec7.RoomWorking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.tutorials180.bscsfall2022app.R
import com.tutorials180.bscsfall2022app.databinding.ActivityRoomWorkingBinding

class RoomWorkingActivity : AppCompatActivity() {

    private lateinit var mRoomWorkingBinding: ActivityRoomWorkingBinding
    private lateinit var mUserDatabase: UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRoomWorkingBinding = ActivityRoomWorkingBinding.inflate(layoutInflater)

        setContentView(mRoomWorkingBinding.root)
        listeners()
    }

    private fun listeners()
    {
        try
        {
            mUserDatabase = Room.databaseBuilder(
                applicationContext,
                UserDatabase::class.java,
                "UserRecords"
            ).allowMainThreadQueries().build()

            mRoomWorkingBinding.roomWorkingAddRecordBtn.setOnClickListener {
                addRecordToDb()
            }

            mRoomWorkingBinding.roomWorkingGetRecordBtn.setOnClickListener {
                getRecordsFromDb()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun addRecordToDb() {
        try
        {
//            val mDAO = mUserDatabase.getUserDAOObject()
//            val mAli = User(0,"Ali","ali@gmail.com")
//
//            val check = mDAO.insertOneUser(mAli)

            val check = mUserDatabase.getUserDAOObject().insertOneUser(
                User("Ali","ali@gmail.com")
            )

            if(check!=0L)
            {
                mRoomWorkingBinding.roomWorkingGetRecordBtn.isEnabled = true
                Toast.makeText(applicationContext, "Record Inserted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(applicationContext, "Record not inserted", Toast.LENGTH_SHORT).show();
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun getRecordsFromDb() {
        try
        {
            val userRecords = mUserDatabase.getUserDAOObject().getAllUser()
            if(userRecords.isNotEmpty())
            {
                var data= ""
                for(singleUserRecord in userRecords)
                {
                    data = " name:${singleUserRecord.name} " +
                            "email:${singleUserRecord.email} \n"
                }

                mRoomWorkingBinding.roomWorkingRecordTv.text = data
            }
            else
            {
                Toast.makeText(applicationContext, "No record found", Toast.LENGTH_SHORT).show();
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }

    }


}