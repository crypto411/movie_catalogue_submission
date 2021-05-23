package com.user.fadhlanhadaina.favorite_feature.fragment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.di.InjectUseCase
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteMovieViewModel @Inject constructor(val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {
    fun getAllFavoriteMovie(): LiveData<PagedList<MovieFavoriteEntity>> =
        movieCatalogueUseCase.getFavoriteMovies()
}