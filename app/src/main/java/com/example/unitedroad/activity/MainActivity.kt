package com.example.unitedroad.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unitedroad.model.Player
import com.example.unitedroad.adapter.PlayerAdapter
import com.example.unitedroad.data.PlayerData
import com.example.unitedroad.R

class MainActivity : AppCompatActivity() {
    private var list: ArrayList<Player> = arrayListOf()
    private lateinit var rvPlayer: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPlayer = findViewById(R.id.rv_player)
        rvPlayer.setHasFixedSize(true)

        list.addAll(PlayerData.listData)
        rvPlayer.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = PlayerAdapter(list)
        rvPlayer.adapter = listPlayerAdapter

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