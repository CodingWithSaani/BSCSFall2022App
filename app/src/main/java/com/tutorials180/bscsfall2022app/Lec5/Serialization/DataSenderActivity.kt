package com.tutorials180.bscsfall2022app.Lec5.Serialization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tutorials180.bscsfall2022app.R

class DataSenderActivity : AppCompatActivity() {

    private lateinit var carNameET:EditText
    private lateinit var carModelET:EditText

    private lateinit var carSendInformationBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_sender)

        connectXML()
    }

    private fun connectXML() {
        try
        {
            carNameET = findViewById(R.id.data_sender_main_car_name_et)
            carModelET = findViewById(R.id.data_sender_main_car_model_et)

            carSendInformationBtn = findViewById(R.id.data_sender_send_car_information_btn)
            carSendInformationBtn.setOnClickListener {
                sendInformation()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(DataReceiverActivity@this, "Connect XML: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun sendInformation() {
        try
        {
            if(carNameET.text.toString().isNotBlank() && carModelET.text.toString().isNotBlank())
            {
                val mCar = Car(carNameET.text.toString(),carModelET.text.toString().toInt())
                startActivity(Intent(DataSenderActivity@this,DataReceiverActivity::class.java)
                    .putExtra("mCar",mCar))
            }
            else if(carNameET.text.toString().isBlank())
            {
                Toast.makeText(DataSenderActivity@this, "Please enter car name", Toast.LENGTH_SHORT).show();
                carNameET.requestFocus()
            }
            else if(carModelET.text.toString().isBlank())
            {
                Toast.makeText(DataSenderActivity@this, "Please enter car model", Toast.LENGTH_SHORT).show();
                carModelET.requestFocus()
            }
        }catch (ex:Exception)
        {
            Toast.makeText(DataReceiverActivity@this, "Send Information: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }
}