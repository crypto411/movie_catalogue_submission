package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase

class DetailMovieViewModel @ViewModelInject constructor(private val movieCatalogueUseCase: MovieCatalogueUseCase): ViewModel() {
    fun getMovie(id: Int) = movieCatalogueUseCase.getMovieDetail(id).asLiveData()
    fun isFavoriteMovie(id: Int) = movieCatalogueUseCase.isFavoriteMovieExist(id).asLiveData()

    suspend fun insertFavoriteMovie(movieFavorite: Movie) = movieCatalogueUseCase.setFavoriteMovie(movieFavorite)
    suspend fun deleteFavoriteMovie(movieFavorite: Movie) = movieCatalogueUseCase.deleteFavoriteMovie(movieFavorite)
}