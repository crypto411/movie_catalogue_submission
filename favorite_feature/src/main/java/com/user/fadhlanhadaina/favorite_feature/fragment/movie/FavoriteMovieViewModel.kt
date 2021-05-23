package com.user.fadhlanhadaina.favorite_feature.fragment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase

class FavoriteMovieViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {
    fun getAllFavoriteMovie(): LiveData<PagedList<MovieFavoriteEntity>> =
        movieCatalogueUseCase.getFavoriteMovies()
}