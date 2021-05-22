package com.user.fadhlanhadaina.favorite_feature.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.user.fadhlanhadaina.core.di.Injection
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import com.user.fadhlanhadaina.favorite_feature.fragment.movie.FavoriteMovieViewModel
import com.user.fadhlanhadaina.favorite_feature.fragment.tvseries.FavoriteTVSeriesViewModel

class ViewModelFactory constructor(private val movieCatalogueUseCase: MovieCatalogueUseCase): ViewModelProvider.NewInstanceFactory() {
    companion object {
        fun newInstance(application: Application): ViewModelFactory {
            synchronized(ViewModelFactory::class.java) {
                return ViewModelFactory(Injection.provideUseCase(application))
            }
        }
    }

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