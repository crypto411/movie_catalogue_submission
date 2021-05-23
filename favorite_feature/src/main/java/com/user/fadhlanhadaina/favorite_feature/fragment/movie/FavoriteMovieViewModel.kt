package com.user.fadhlanhadaina.favorite_feature.fragment.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase

class FavoriteMovieViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {
    fun getAllFavoriteMovie() = movieCatalogueUseCase.getFavoriteMovies().asLiveData()
}