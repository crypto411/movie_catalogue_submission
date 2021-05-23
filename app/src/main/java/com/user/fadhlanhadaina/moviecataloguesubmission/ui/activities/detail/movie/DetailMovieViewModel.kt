package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import kotlinx.coroutines.launch

class DetailMovieViewModel @ViewModelInject constructor(private val movieCatalogueUseCase: MovieCatalogueUseCase): ViewModel() {
    fun getMovie(id: Int) = movieCatalogueUseCase.getMovieDetail(id).asLiveData()

    fun insertFavoriteMovie(movieFavoriteEntity: MovieFavoriteEntity) = viewModelScope.launch {
        movieCatalogueUseCase.setFavoriteMovie(movieFavoriteEntity)
    }

    fun deleteFavoriteMovie(movieFavoriteEntity: MovieFavoriteEntity) = viewModelScope.launch {
        movieCatalogueUseCase.deleteFavoriteMovie(movieFavoriteEntity)
    }

    fun isFavoriteMovie(id: Int) = movieCatalogueUseCase.isFavoriteMovieExist(id).asLiveData()
}