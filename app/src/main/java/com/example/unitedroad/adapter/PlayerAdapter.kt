package com.example.unitedroad.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.unitedroad.activity.DetailActivity
import com.example.unitedroad.model.Player
import com.example.unitedroad.R

class PlayerAdapter(private val listPlayer: ArrayList<Player>) :
    RecyclerView.Adapter<PlayerAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_player, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val player = listPlayer[position]
        val context = holder.itemView.context
        Glide.with(context)
            .load(player.image)
            .apply(RequestOptions())
            .into(holder.image)
        holder.name.text = player.name
        holder.position.text = player.position
        holder.nationality.text = player.nationality
        holder.itemView.setOnClickListener {
            val moveIntent = Intent(context, DetailActivity::class.java)
            moveIntent.putExtra(DetailActivity.EXTRA_NAME, player.name)
            moveIntent.putExtra(DetailActivity.EXTRA_POSITION, player.position)
            moveIntent.putExtra(DetailActivity.EXTRA_NATIONALITY, player.nationality)
            moveIntent.putExtra(DetailActivity.EXTRA_BIRTHDATE, player.birthDate)
            moveIntent.putExtra(DetailActivity.EXTRA_BIOGRAPHY, player.biography)
            moveIntent.putExtra(DetailActivity.EXTRA_IMAGE, player.image)
            context.startActivity(moveIntent)
        }
    }

    override fun getItemCount(): Int {
        return listPlayer.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.tv_name)
        var position = itemView.findViewById<TextView>(R.id.tv_position)
        var nationality = itemView.findViewById<TextView>(R.id.tv_nationality)
        var image = itemView.findViewById<ImageView>(R.id.iv_player)
    }
}