package com.tutorials180.bscsfall2022app.Lec4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tutorials180.bscsfall2022app.R

class StarterActivity : AppCompatActivity() {

    private lateinit var infoET:EditText
    private lateinit var sendInfoBtn:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)

        connector()
    }

    private fun connector()
    {
        try
        {
            infoET = findViewById(R.id.starter_info_et)
            sendInfoBtn = findViewById(R.id.starter_send_info_btn)

            sendInfoBtn.setOnClickListener {
                sendInformation()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(StarterActivity@this, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun sendInformation() {
        try
        {
            if(infoET.text.toString().isBlank())
            {
                Toast.makeText(StarterActivity@this, "Please enter some data", Toast.LENGTH_SHORT).show();
                infoET.requestFocus()
            }
            else
            {
                val data = infoET.text.toString()
                var intent = Intent(StarterActivity@this,EndPointActivity::class.java)

                intent.putExtra("key",data)
                startActivity(intent)
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(StarterActivity@this, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }
}









