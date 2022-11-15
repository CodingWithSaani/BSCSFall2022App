package com.tutorials180.bscsfall2022app.Lec5.Serialization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.tutorials180.bscsfall2022app.R

class DataReceiverActivity : AppCompatActivity()
{
    private lateinit var carNameTV:TextView
    private lateinit var carModelTV:TextView

    private lateinit var goBackBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_receiver)

        connectWithXML()
    }

    private fun connectWithXML() {
        try
        {
            carNameTV = findViewById(R.id.data_receiver_car_name_tv)
            carModelTV = findViewById(R.id.data_receiver_car_model_tv)

            goBackBtn = findViewById(R.id.data_receiver_go_back_btn)
            goBackBtn.setOnClickListener {
                startActivity(Intent(DataReceiverActivity@this,DataSenderActivity::class.java))
                this.finish()
            }

            receiveInformation()
        }
        catch (ex:Exception)
        {
            Toast.makeText(DataSenderActivity@this, "Connect With XML:${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun receiveInformation() {
        try
        {
            if(intent != null)
            {
                val mCar = intent.getSerializableExtra("mCar") as Car
                carNameTV.text = mCar.name

                carModelTV.text = mCar.model.toString()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(DataSenderActivity@this, "Receive Information:${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }
}