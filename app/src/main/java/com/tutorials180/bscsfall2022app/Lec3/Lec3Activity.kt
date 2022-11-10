package com.tutorials180.bscsfall2022app.Lec3


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.tutorials180.bscsfall2022app.Lec2.Lec2Activity
import com.tutorials180.bscsfall2022app.R

class Lec3Activity : AppCompatActivity() {

    lateinit var firstValueET: EditText
    lateinit var secondValueET:EditText

    lateinit var calculateBtn: Button
    lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec3)

        connector()
    }

    private fun connector()
    {
        try{
            firstValueET = findViewById(R.id.first_value_et)
            secondValueET = findViewById(R.id.second_value_et)

            calculateBtn = findViewById(R.id.calculate_btn)
            resultTV = findViewById(R.id.result_tv)

            calculateBtn.setOnClickListener {
                calculateResult()
            }
        }
        catch (ex:Exception){
            Toast.makeText(Lec3Activity@this,"Exception is ${ex.message}",Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun calculateResult() {
        try
        {
            if(firstValueET.text.toString().isBlank())
            {
                Toast.makeText(Lec3Activity@this, "Please enter the first value", Toast.LENGTH_SHORT).show();
                firstValueET.requestFocus()
            }
            else if(secondValueET.text.toString().isBlank())
            {
                Toast.makeText(Lec3Activity@this, "Please enter the second value", Toast.LENGTH_SHORT).show();
                secondValueET.requestFocus()
            }
            else {
                var value1 = firstValueET.text.toString().toInt()
                var value2 = secondValueET.text.toString().toInt()

                var result = value1 + value2
                resultTV.text = "Result : $result"
            }


        }
        catch (ex:Exception)
        {
            Toast.makeText(Lec3Activity@this, "Exception in calRes: ${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }
}







