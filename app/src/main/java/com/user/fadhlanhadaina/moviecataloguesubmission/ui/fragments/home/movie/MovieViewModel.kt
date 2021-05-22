package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase

class MovieViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {
    private var movieLists: LiveData<ArrayList<Movie>>? = null

    fun getMovies(): LiveData<ArrayList<Movie>>? {
        if(movieLists == null)
            movieLists = movieCatalogueUseCase.getMovies()
        return movieLists
    }
}