package com.example.unitedroad.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unitedroad.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "About Me"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}