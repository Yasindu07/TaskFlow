package com.example.taskflow

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@SplashScreen, WelcomePage::class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }
}