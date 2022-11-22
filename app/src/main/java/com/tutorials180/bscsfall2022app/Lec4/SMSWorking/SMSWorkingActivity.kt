package com.tutorials180.bscsfall2022app.Lec4.SMSWorking

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.tutorials180.bscsfall2022app.R

class SMSWorkingActivity : AppCompatActivity() {

    private lateinit var smsContentET:EditText
    private lateinit var sendSMSBtn:Button

    private lateinit var mSmsManager: SmsManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smsworking)

        xmlConnector()
    }

    private fun xmlConnector()
    {
        try
        {
           smsContentET = findViewById(R.id.sms_working_sms_content_et)
           sendSMSBtn = findViewById(R.id.sms_working_send_sms_btn)

           mSmsManager = SmsManager.getDefault()
           sendSMSBtn.setOnClickListener {
               sendIt()
           }
        }
        catch (ex:Exception)
        {
            Toast.makeText(SMSWorkingActivity@this, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun sendIt() {
        try
        {
           if(smsContentET.text.toString().isNotBlank())
           {
               //Check the permission
               if(ActivityCompat.checkSelfPermission(applicationContext,
               android.Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_GRANTED)
               {
                   sendSMSNow()
               }
               else
               {
                    ActivityCompat.requestPermissions(SMSWorkingActivity@this,
                    arrayOf(android.Manifest.permission.SEND_SMS),
                    102
                        )
               }


           }
            else
           {
               Toast.makeText(SMSWorkingActivity@this, "Please enter some text", Toast.LENGTH_SHORT).show();
               smsContentET.requestFocus()
           }
        }
        catch (ex:Exception)
        {
            Toast.makeText(SMSWorkingActivity@this, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun sendSMSNow() {
        try
        {
            mSmsManager.sendTextMessage("009021111111",null,
                smsContentET.text.toString(),null,null)
        }
        catch (ex:Exception)
        {
            Toast.makeText(SMSWorkingActivity@this, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==102 && grantResults.isNotEmpty())
        {
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(applicationContext, "Permission granted", Toast.LENGTH_SHORT).show();
                sendSMSNow()
            }
        }
        else
        {

        }
    }
}