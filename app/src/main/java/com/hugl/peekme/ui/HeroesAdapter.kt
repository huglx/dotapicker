package com.hugl.peekme.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hugl.peekme.databinding.ActivityMainBinding
import com.hugl.peekme.databinding.HeroesItemBinding
import com.hugl.peekme.domain.Models

class HeroesAdapter(private val heroes: List<Models.Hero>) : RecyclerView.Adapter<HeroesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val itemBinding = HeroesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    override fun getItemCount(): Int {
        return heroes.size
    }
}

class HeroesViewHolder(private val itemBinding: HeroesItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(heroes: Models.Hero) {
        itemBinding.name.text = heroes.name
    }
}

