package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.domain.model.TVSeriesFavorite
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import kotlinx.coroutines.launch

class DetailTVSeriesViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase): ViewModel() {
    private var tvSeries: LiveData<TVSeries>? = null

    fun getTVSeries(id: Int): LiveData<TVSeries>? {
        if(tvSeries == null)
            tvSeries = movieCatalogueUseCase.getTVSeriesDetail(id)
        return tvSeries
    }

    fun insertFavoriteTVSeries(movieFavorite: TVSeriesFavorite) = viewModelScope.launch {
        movieCatalogueUseCase.setFavoriteTVSeries(movieFavorite)
    }

    fun deleteFavoriteTVSeries(movieFavorite: TVSeriesFavorite) = viewModelScope.launch {
        movieCatalogueUseCase.deleteFavoriteTVSeries(movieFavorite)
    }

    fun isFavoriteTVSeries(id: Int) = movieCatalogueUseCase.isFavoriteTVSeriesExist(id)
}