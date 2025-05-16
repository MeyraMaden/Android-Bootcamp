package com.yuki.filmler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuki.filmler.databinding.ItemFilmBinding

class FilmAdapter(private val filmList: List<Film>) :
    RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    class FilmViewHolder(val binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = filmList[position]
        holder.binding.filmAdi.text = film.ad
        holder.binding.filmTuru.text = film.tur
        holder.binding.filmResmi.setImageResource(film.resimId)
    }

    override fun getItemCount(): Int = filmList.size
}
