package com.example.unitedroad.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.unitedroad.R

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_POSITION = "extra_position"
        const val EXTRA_NATIONALITY = "extra_nationality"
        const val EXTRA_BIRTHDATE = "extra_birthdate"
        const val EXTRA_BIOGRAPHY = "extra_biography"
        const val EXTRA_IMAGE = "extra_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        title = "Player Detail"

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvPosition: TextView = findViewById(R.id.tv_position)
        val tvNationality: TextView = findViewById(R.id.tv_nationality)
        val tvBirthdate: TextView = findViewById(R.id.tv_birth_date)
        val tvBiography: TextView = findViewById(R.id.tv_biography)
        val ivPlayer: ImageView = findViewById(R.id.iv_player)

        val name = intent.getStringExtra(EXTRA_NAME)
        val position = intent.getStringExtra(EXTRA_POSITION)
        val nationality = intent.getStringExtra(EXTRA_NATIONALITY)
        val birthdate = intent.getStringExtra(EXTRA_BIRTHDATE)
        val biography = intent.getStringExtra(EXTRA_BIOGRAPHY)
        val image = intent.getIntExtra(EXTRA_IMAGE, 0)

        tvName.text = name
        tvPosition.text = position
        tvNationality.text = nationality
        tvBirthdate.text = birthdate
        tvBiography.text = biography
        Glide.with(this)
            .load(image)
            .apply(RequestOptions())
            .into(ivPlayer)
    }
}