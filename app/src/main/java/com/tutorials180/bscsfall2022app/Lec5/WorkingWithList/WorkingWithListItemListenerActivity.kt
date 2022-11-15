package com.tutorials180.bscsfall2022app.Lec5.WorkingWithList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.tutorials180.bscsfall2022app.R

class WorkingWithListItemListenerActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val dataList = listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday",
                                    "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday",
                                        "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_working_with_list_item_listener)

        connectWithXML()
    }

    private fun connectWithXML()
    {
        try
        {
            listView = findViewById(R.id.working_list_item_listener_list)
            adapterWorking()
        }
        catch(ex:Exception)
        {
            Toast.makeText(WorkingWithListItemListenerActivity@this, "connect With XML: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun adapterWorking()
    {
        try
        {
            listView.adapter = ArrayAdapter(WorkingWithListItemListenerActivity@this,android.R.layout.simple_list_item_1,dataList)
            listView.setOnItemClickListener { parent, view, position, id ->
                val valueFromList = parent.getItemAtPosition(position) as String

                startActivity(Intent(WorkingWithListItemListenerActivity@this,
                    WorkingWithListItemListenerReceiverActivity::class.java)
                    .putExtra("value",valueFromList))
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(WorkingWithListItemListenerActivity@this, "adapter working: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }
}