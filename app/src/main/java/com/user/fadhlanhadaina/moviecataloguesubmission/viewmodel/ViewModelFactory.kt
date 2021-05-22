package com.user.fadhlanhadaina.moviecataloguesubmission.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.user.fadhlanhadaina.core.di.Injection
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie.DetailMovieViewModel
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries.DetailTVSeriesViewModel
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.movie.MovieViewModel
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.tvseries.TVSeriesViewModel

class ViewModelFactory(private val movieCatalogueUseCase: MovieCatalogueUseCase): ViewModelProvider.NewInstanceFactory() {
    companion object {
        fun newInstance(application: Application): ViewModelFactory {
            synchronized(ViewModelFactory::class.java) {
                return ViewModelFactory(Injection.provideUseCase(application))
            }
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(movieCatalogueUseCase) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(movieCatalogueUseCase) as T
            }
            modelClass.isAssignableFrom(TVSeriesViewModel::class.java) -> {
                TVSeriesViewModel(movieCatalogueUseCase) as T
            }
            modelClass.isAssignableFrom(DetailTVSeriesViewModel::class.java) -> {
                DetailTVSeriesViewModel(movieCatalogueUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}