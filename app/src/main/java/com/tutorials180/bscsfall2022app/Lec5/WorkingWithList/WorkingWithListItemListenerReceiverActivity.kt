package com.tutorials180.bscsfall2022app.Lec5.WorkingWithList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.tutorials180.bscsfall2022app.R

class WorkingWithListItemListenerReceiverActivity : AppCompatActivity() {

    private lateinit var dataTV:TextView
    private lateinit var moveBackBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_working_with_list_item_listener_receiver)

        connectXML()
    }

    private fun connectXML() {
        try
        {
            dataTV = findViewById(R.id.working_list_item_listener_receiver_data_tv)
            moveBackBtn = findViewById(R.id.working_list_item_listener_receiver_move_back_btn)

            getIntentValues()
            moveBackBtn.setOnClickListener {
                startActivity(Intent(WorkingWithListItemListenerActivity@this,
                    WorkingWithListItemListenerActivity::class.java))
                this.finish()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(WorkingWithListItemListenerReceiverActivity@this, "connect XML: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun getIntentValues() {
        try
        {
            if(intent != null)
            {
                dataTV.text = intent.getStringExtra("value")
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(WorkingWithListItemListenerReceiverActivity@this, "get intent values: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }


}