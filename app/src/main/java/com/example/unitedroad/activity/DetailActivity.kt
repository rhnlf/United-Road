package com.example.unitedroad.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.unitedroad.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

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
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Player Detail"

        val name = intent.getStringExtra(EXTRA_NAME)
        val position = intent.getStringExtra(EXTRA_POSITION)
        val nationality = intent.getStringExtra(EXTRA_NATIONALITY)
        val birthdate = intent.getStringExtra(EXTRA_BIRTHDATE)
        val biography = intent.getStringExtra(EXTRA_BIOGRAPHY)
        val image = intent.getStringExtra(EXTRA_IMAGE)

        binding.apply {
            tvName.text = name
            tvPosition.text = position
            tvNationality.text = nationality
            tvBirthDate.text = birthdate
            tvBiography.text = biography
            Glide.with(this@DetailActivity)
                .load(image)
                .apply(RequestOptions())
                .into(ivPlayer)
        }
    }
}