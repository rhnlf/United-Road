package com.example.unitedroad.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.unitedroad.activity.DetailActivity
import com.example.unitedroad.databinding.ItemRowPlayerBinding
import com.example.unitedroad.model.Player

class PlayerAdapter(private val listPlayer: ArrayList<Player>) :
    RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRowPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
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

    class ViewHolder(binding: ItemRowPlayerBinding) : RecyclerView.ViewHolder(binding.root) {
        var image: ImageView = binding.ivPlayer
        var name: TextView = binding.tvName
        var position: TextView = binding.tvPosition
        var nationality: TextView = binding.tvNationality
    }
}