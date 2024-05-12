package com.example.taskflow

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity


class WelcomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome_page)

        var button1 = findViewById<ImageView>(R.id.startbtn)

        button1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            }

    }
}