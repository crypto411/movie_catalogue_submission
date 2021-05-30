package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.user.fadhlanhadaina.core.data.source.local.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import kotlinx.coroutines.launch

class DetailMovieViewModel @ViewModelInject constructor(private val movieCatalogueUseCase: MovieCatalogueUseCase): ViewModel() {
    fun getMovie(id: Int) = movieCatalogueUseCase.getMovieDetail(id).asLiveData()
    fun isFavoriteMovie(id: Int) = movieCatalogueUseCase.isFavoriteMovieExist(id).asLiveData()

    suspend fun insertFavoriteMovie(movieFavoriteEntity: MovieFavoriteEntity) = movieCatalogueUseCase.setFavoriteMovie(movieFavoriteEntity)
    suspend fun deleteFavoriteMovie(movieFavoriteEntity: MovieFavoriteEntity) = movieCatalogueUseCase.deleteFavoriteMovie(movieFavoriteEntity)
}