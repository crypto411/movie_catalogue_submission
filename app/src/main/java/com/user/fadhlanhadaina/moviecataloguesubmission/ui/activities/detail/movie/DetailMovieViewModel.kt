package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.user.fadhlanhadaina.core.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.core.model.Movie
import com.user.fadhlanhadaina.core.model.MovieFavorite
import kotlinx.coroutines.launch

class DetailMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel() {
    private var movie: LiveData<Movie>? = null

    fun getMovie(id: Int): LiveData<Movie>? {
        if(movie == null)
            movie = movieCatalogueRepository.getMovieDetail(id)
        return movie
    }

    fun insertFavoriteMovie(movieFavorite: MovieFavorite) = viewModelScope.launch {
        movieCatalogueRepository.setFavoriteMovie(movieFavorite)
    }

    fun deleteFavoriteMovie(movieFavorite: MovieFavorite) = viewModelScope.launch {
        movieCatalogueRepository.deleteFavoriteMovie(movieFavorite)
    }

    fun isFavoriteMovie(id: Int) = movieCatalogueRepository.isFavoriteMovieExist(id)
}