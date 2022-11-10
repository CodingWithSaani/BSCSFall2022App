package com.tutorials180.bscsfall2022app.Lec4.AdapterWorking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.tutorials180.bscsfall2022app.R

class BuiltInAdapterActivity : AppCompatActivity() {

    private var weekDays = arrayOf("Monday","Tuesday","Wednesday","Thursday"
                                   ,"Friday","Saturday","Sunday",
                                    "Monday","Tuesday","Wednesday","Thursday"
                                    ,"Friday","Saturday","Sunday",
                                    "Monday","Tuesday","Wednesday","Thursday"
                                    ,"Friday","Saturday","Sunday")

    private lateinit var listView:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_built_in_adapter)

        connector()
    }

    private fun connector() {
        try
        {
            listView = findViewById(R.id.build_in_adapter_list_view)
            publishData()
        }
        catch (ex:Exception)
        {
            Toast.makeText(BuiltInAdapterActivity@this, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun publishData() {
        try
        {
            listView.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,weekDays)
        }
        catch (ex:Exception)
        {
            Toast.makeText(BuiltInAdapterActivity@this, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }
}