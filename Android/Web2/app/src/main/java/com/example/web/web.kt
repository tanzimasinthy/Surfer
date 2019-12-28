package com.example.web

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class web : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_web)
        val names = intent.getStringExtra("name")
        Toast.makeText(this, names.toString(), Toast.LENGTH_SHORT).show()

        var data = intent.getStringExtra("name")


        var mywebview = findViewById<WebView>(R.id.web_)

        //mywebview!!.loadUrl("https://www.google.co.in/")
        if (data.contains(".com"))
        {
            var dam = "https://"
            mywebview.loadUrl(dam+data.toString())
        }
        else
        {
            //mywebview.loadUrl("https://www.google.com")
            var tt = "https://www.google.com/search?source=hp&q="
            mywebview.loadUrl(tt+data.toString())
        }
    }
}
