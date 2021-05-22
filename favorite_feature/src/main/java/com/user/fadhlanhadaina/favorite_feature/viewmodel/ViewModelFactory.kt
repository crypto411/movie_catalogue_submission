package com.user.fadhlanhadaina.favorite_feature.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.user.fadhlanhadaina.core.source.Injection
import com.user.fadhlanhadaina.core.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.favorite_feature.fragment.movie.FavoriteMovieViewModel
import com.user.fadhlanhadaina.favorite_feature.fragment.tvseries.FavoriteTVSeriesViewModel

class ViewModelFactory(private val movieCatalogueRepository: MovieCatalogueRepository): ViewModelProvider.NewInstanceFactory() {
    companion object {
        fun newInstance(application: Application): ViewModelFactory {
            synchronized(ViewModelFactory::class.java) {
                return ViewModelFactory(Injection.provideRepository(application))
            }
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> {
                FavoriteMovieViewModel(movieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTVSeriesViewModel::class.java) -> {
                FavoriteTVSeriesViewModel(movieCatalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}