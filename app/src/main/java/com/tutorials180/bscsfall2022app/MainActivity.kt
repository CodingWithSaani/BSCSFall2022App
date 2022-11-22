package com.tutorials180.bscsfall2022app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.tutorials180.bscsfall2022app.Lec2.Lec2Activity
import com.tutorials180.bscsfall2022app.Lec3.Lec3Activity
import com.tutorials180.bscsfall2022app.Lec4.AdapterWorking.BuiltInAdapterActivity
import com.tutorials180.bscsfall2022app.Lec4.StarterActivity
import com.tutorials180.bscsfall2022app.Lec5.Serialization.DataSenderActivity
import com.tutorials180.bscsfall2022app.Lec5.WorkingWithList.WorkingWithListItemListenerActivity
import com.tutorials180.bscsfall2022app.Lec6.GeoLocationActivity

class MainActivity : AppCompatActivity() {
    private lateinit var lec2Btn:Button
    private lateinit var lec3Btn:Button

    private lateinit var lec4Btn:Button
    private lateinit var lec4bBtn:Button

    private lateinit var lec5aBtn:Button
    private lateinit var lec5bBtn:Button

    private lateinit var lec6aBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connector()
    }

    private fun connector()
    {
        try
        {
            lec2Btn = findViewById(R.id.lec_2_btn)
            lec3Btn = findViewById(R.id.lec_3_btn)

            lec4Btn = findViewById(R.id.lec_4_btn)
            lec4bBtn = findViewById(R.id.lec_4_b_btn)

            lec5aBtn = findViewById(R.id.lec_5_a_btn)
            lec5bBtn = findViewById(R.id.lec_5_b_btn)

            lec6aBtn = findViewById(R.id.lec_6_a_btn)

            lec2Btn.setOnClickListener {
                moveToLecture2()
            }
            lec3Btn.setOnClickListener {
                moveToLecture3()
            }

            lec4Btn.setOnClickListener {
                moveToLecture4()
            }

            lec4bBtn.setOnClickListener {
                moveToLecture4b()
            }


            lec5aBtn.setOnClickListener {
                moveToLecture5a()
            }

            lec5bBtn.setOnClickListener {
                moveToLecture5b()
            }

            lec6aBtn.setOnClickListener {
                moveToLecture6a()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(MainActivity@this, "MainScreen: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun moveToLecture6a() {
        try {
            var objIntent = Intent(MainActivity@this, GeoLocationActivity::class.java)
            startActivity(objIntent)
        }
        catch (ex:Exception)
        {
            Toast.makeText(MainActivity@this, "moveToLecture6a: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun moveToLecture5b() {
        try {
            var objIntent = Intent(MainActivity@this, DataSenderActivity::class.java)
            startActivity(objIntent)
        }
        catch (ex:Exception)
        {
            Toast.makeText(MainActivity@this, "moveToLecture5a: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun moveToLecture5a() {
        try {
            var objIntent = Intent(MainActivity@this, WorkingWithListItemListenerActivity::class.java)
            startActivity(objIntent)
        }
        catch (ex:Exception)
        {
            Toast.makeText(MainActivity@this, "moveToLecture5a: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun moveToLecture4b() {
        try
        {
            var objIntent = Intent(MainActivity@this,BuiltInAdapterActivity::class.java)
            startActivity(objIntent)
        }catch (ex:Exception)
        {
            Toast.makeText(MainActivity@this, "moveToLecture4b: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun moveToLecture4() {
        try
        {
            var objIntent = Intent(MainActivity@this,StarterActivity::class.java)
            startActivity(objIntent)
        }catch (ex:Exception)
        {
            Toast.makeText(MainActivity@this, "moveToLecture4: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun moveToLecture3() {
        try
        {
            var objIntent = Intent(MainActivity@this,Lec3Activity::class.java)
            startActivity(objIntent)
        }catch (ex:Exception)
        {
            Toast.makeText(MainActivity@this, "moveToLecture3: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun moveToLecture2() {
        try
        {
            startActivity(Intent(MainActivity@this,Lec2Activity::class.java))
        }catch (ex:Exception)
        {
            Toast.makeText(MainActivity@this, "moveToLecture2: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }
}