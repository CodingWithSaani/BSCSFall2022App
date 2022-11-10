package com.tutorials180.bscsfall2022app.Lec4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.tutorials180.bscsfall2022app.R

class EndPointActivity : AppCompatActivity() {

    private lateinit var dataTV:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_point)

        connector()
    }

    private fun connector()
    {
        try
        {
            dataTV = findViewById(R.id.endpoint_data_tv)
            fetchData()
        }
        catch (ex:Exception)
        {
            Toast.makeText(EndPointActivity@this, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun fetchData() {
        try
        {
            val dataFromStater = intent.getStringExtra("key")
            dataTV.text = dataFromStater
        }
        catch (ex:Exception)
        {
            Toast.makeText(EndPointActivity@this, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }
}