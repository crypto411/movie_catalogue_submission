package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.user.fadhlanhadaina.core.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.core.model.TVSeries
import com.user.fadhlanhadaina.core.model.TVSeriesFavorite
import kotlinx.coroutines.launch

class DetailTVSeriesViewModel(private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel() {
    private var tvSeries: LiveData<TVSeries>? = null

    fun getTVSeries(id: Int): LiveData<TVSeries>? {
        if(tvSeries == null)
            tvSeries = movieCatalogueRepository.getTVSeriesDetail(id)
        return tvSeries
    }

    fun insertFavoriteTVSeries(movieFavorite: TVSeriesFavorite) = viewModelScope.launch {
        movieCatalogueRepository.setFavoriteTVSeries(movieFavorite)
    }

    fun deleteFavoriteTVSeries(movieFavorite: TVSeriesFavorite) = viewModelScope.launch {
        movieCatalogueRepository.deleteFavoriteTVSeries(movieFavorite)
    }

    fun isFavoriteTVSeries(id: Int) = movieCatalogueRepository.isFavoriteTVSeriesExist(id)
}