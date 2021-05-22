package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.user.fadhlanhadaina.core.data.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository

class MovieViewModel(private val movieCatalogueRepository: IMovieCatalogueRepository) : ViewModel() {
    private var movieLists: LiveData<ArrayList<Movie>>? = null

    fun getMovies(): LiveData<ArrayList<Movie>>? {
        if(movieLists == null)
            movieLists = movieCatalogueRepository.getMovies()
        return movieLists
    }
}