package com.example.retrofit_with_picasso_homework.Network

import com.example.retrofit_with_picasso_homework.Model.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<MovieModel>>
}