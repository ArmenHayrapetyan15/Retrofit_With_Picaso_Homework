package com.example.retrofit_with_picasso_homework.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit_with_picasso_homework.Model.MovieModel
import com.example.retrofit_with_picasso_homework.Repositories.MainRepo

class MainActivityViewModel : ViewModel() {
    private val mainRepo: MainRepo
    val getMovieList: LiveData<MutableList<MovieModel>>
        get() = mainRepo.getMovieModelLiveData

    init {
        mainRepo = MainRepo()
    }
}