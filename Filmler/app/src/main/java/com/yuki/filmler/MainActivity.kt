package com.yuki.filmler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuki.filmler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var filmList: ArrayList<Film>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        filmList = ArrayList()
        filmList.add(Film("Avengers: Endgame", "Aksiyon", R.drawable.endgame))
        filmList.add(Film("Frozen", "Animasyon", R.drawable.frozen))
        filmList.add(Film("Titanic", "Drama", R.drawable.titanic))

        binding.filmRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.filmRecyclerView.adapter = FilmAdapter(filmList)
    }
}
