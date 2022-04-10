package com.example.retrofit_with_picasso_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_with_picasso_homework.Adapter.MovieListAdapter
import com.example.retrofit_with_picasso_homework.ViewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    var mainActivityViewModel: MainActivityViewModel? = null
    var recyclerView: RecyclerView? = null
    var adapter: MovieListAdapter? = null
    var layoutManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        recyclerView = findViewById(R.id.recycleView)
        recyclerView!!.setHasFixedSize(true)
        layoutManager= LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager

        mainActivityViewModel!!.getMovieList.observe(this) { movieModels ->
            Log.e("MainActivity", "MovieList: " + movieModels.get(0).name)
            if (movieModels != null){
                adapter = MovieListAdapter(this,movieModels)
                adapter!!.notifyDataSetChanged()
                recyclerView!!.adapter = adapter

            }
        }
    }
}