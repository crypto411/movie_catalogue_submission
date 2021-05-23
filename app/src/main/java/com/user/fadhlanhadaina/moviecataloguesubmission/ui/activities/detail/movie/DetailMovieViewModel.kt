package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(private val movieCatalogueUseCase: MovieCatalogueUseCase): ViewModel() {
    private var movie: LiveData<Movie>? = null

    fun getMovie(id: Int): LiveData<Movie>? {
        if(movie == null)
            movie = movieCatalogueUseCase.getMovieDetail(id)
        return movie
    }

    fun insertFavoriteMovie(movieFavoriteEntity: MovieFavoriteEntity) = viewModelScope.launch {
        movieCatalogueUseCase.setFavoriteMovie(movieFavoriteEntity)
    }

    fun deleteFavoriteMovie(movieFavoriteEntity: MovieFavoriteEntity) = viewModelScope.launch {
        movieCatalogueUseCase.deleteFavoriteMovie(movieFavoriteEntity)
    }

    fun isFavoriteMovie(id: Int) = movieCatalogueUseCase.isFavoriteMovieExist(id)
}