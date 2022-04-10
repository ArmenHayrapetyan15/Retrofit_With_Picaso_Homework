package com.example.retrofit_with_picasso_homework.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_with_picasso_homework.Model.MovieModel
import com.example.retrofit_with_picasso_homework.R
import com.squareup.picasso.Picasso

class MovieListAdapter(var context: Context, var movieModelList: MutableList<MovieModel>) :
    RecyclerView.Adapter<MovieListAdapter.myViewModel>() {
    inner class myViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgMovie: ImageView
        var txtMovieName: TextView
        var txtTeam: TextView
        var txtCreatedby: TextView

        init {
            imgMovie = itemView.findViewById(R.id.imgMovie)
            txtMovieName = itemView.findViewById(R.id.txtMovieName)
            txtTeam = itemView.findViewById(R.id.txtTeam)
            txtCreatedby = itemView.findViewById(R.id.txtCreatedby)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewModel {
        return myViewModel(
            LayoutInflater.from(context).inflate(R.layout.layout_movie_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: myViewModel, position: Int) {
        Picasso.get().load(movieModelList[position].imageurl).into(holder.imgMovie)
        holder.txtMovieName.text = movieModelList[position].name
        holder.txtTeam.text = movieModelList[position].team
        holder.txtCreatedby.text = movieModelList[position].craetedby
    }

    override fun getItemCount(): Int {
        return movieModelList.size
    }
}