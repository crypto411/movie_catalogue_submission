package com.user.fadhlanhadaina.favorite_feature.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import com.user.fadhlanhadaina.favorite_feature.ui.fragment.movie.FavoriteMovieViewModel
import com.user.fadhlanhadaina.favorite_feature.ui.fragment.tvseries.FavoriteTVSeriesViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val movieCatalogueUseCase: MovieCatalogueUseCase): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> {
                FavoriteMovieViewModel(movieCatalogueUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteTVSeriesViewModel::class.java) -> {
                FavoriteTVSeriesViewModel(movieCatalogueUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}