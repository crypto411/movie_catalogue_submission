package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.Movie

class MovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    private var movieLists: LiveData<ArrayList<Movie>>? = null

    fun getMovies(): LiveData<ArrayList<Movie>>? {
        if(movieLists == null)
            movieLists = movieCatalogueRepository.getMovies()
        return movieLists
    }
}