package com.example.web

import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        btn.setOnClickListener()
        {
            check_fun()
        }
        btn1.setOnClickListener()
        {
            check_fun1()
        }
    }

    fun check_fun()
    {
        if (address_!== null)
        {
            //Toast.makeText(this, address_.text.toString(), Toast.LENGTH_LONG).show()
            startActivity(Intent(this, web::class.java).putExtra("name", address_.text.toString()))
        }
    }

    fun check_fun1()
    {
        val intent: Intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(intent, 10)
        }
        else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            10 -> if (resultCode == Activity.RESULT_OK && data != null) {
                val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                dataExtend(result[0])
            }
        }
    }

    fun dataExtend(names:String)
    {
        //Toast.makeText(this, names, Toast.LENGTH_SHORT).show()

        if (names.isNotEmpty())
        {
            startActivity(Intent(this, web::class.java).putExtra("name", names))
        }
        else
        {
            Toast.makeText(this,"try again", Toast.LENGTH_SHORT).show()
        }
    }
}
