package com.example.unitedroad.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unitedroad.R
import com.example.unitedroad.adapter.PlayerAdapter
import com.example.unitedroad.data.PlayerData
import com.example.unitedroad.databinding.ActivityMainBinding
import com.example.unitedroad.model.Player

class MainActivity : AppCompatActivity() {
    private var list: ArrayList<Player> = arrayListOf()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.apply {
            rvPlayer.layoutManager = layoutManager
            rvPlayer.setHasFixedSize(true)
            rvPlayer.adapter = PlayerAdapter(list)
        }
        list.addAll(PlayerData.listData)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.about -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
    }
}