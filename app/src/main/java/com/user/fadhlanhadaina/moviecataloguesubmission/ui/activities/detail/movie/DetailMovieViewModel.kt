package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.user.fadhlanhadaina.core.data.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.MovieFavorite
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import kotlinx.coroutines.launch

class DetailMovieViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase): ViewModel() {
    private var movie: LiveData<Movie>? = null

    fun getMovie(id: Int): LiveData<Movie>? {
        if(movie == null)
            movie = movieCatalogueUseCase.getMovieDetail(id)
        return movie
    }

    fun insertFavoriteMovie(movieFavorite: MovieFavorite) = viewModelScope.launch {
        movieCatalogueUseCase.setFavoriteMovie(movieFavorite)
    }

    fun deleteFavoriteMovie(movieFavorite: MovieFavorite) = viewModelScope.launch {
        movieCatalogueUseCase.deleteFavoriteMovie(movieFavorite)
    }

    fun isFavoriteMovie(id: Int) = movieCatalogueUseCase.isFavoriteMovieExist(id)
}