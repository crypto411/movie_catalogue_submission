package com.user.fadhlanhadaina.moviecataloguesubmission.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.Injection
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie.DetailMovieViewModel
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries.DetailTVSeriesViewModel
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.favorite.movie.FavoriteMovieViewModel
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.favorite.tvseries.FavoriteTVSeriesViewModel
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.movie.MovieViewModel
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.tvseries.TVSeriesViewModel

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
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(movieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(movieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(TVSeriesViewModel::class.java) -> {
                TVSeriesViewModel(movieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailTVSeriesViewModel::class.java) -> {
                DetailTVSeriesViewModel(movieCatalogueRepository) as T
            }
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