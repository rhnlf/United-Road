package com.example.unitedroad.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unitedroad.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        title = "About Me"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}