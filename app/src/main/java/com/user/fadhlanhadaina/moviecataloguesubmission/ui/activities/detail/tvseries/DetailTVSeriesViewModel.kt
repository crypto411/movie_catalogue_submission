package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.user.fadhlanhadaina.core.data.source.local.entity.TVSeriesFavoriteEntity
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import kotlinx.coroutines.launch

class DetailTVSeriesViewModel @ViewModelInject constructor(private val movieCatalogueUseCase: MovieCatalogueUseCase): ViewModel() {
    fun getTVSeries(id: Int) = movieCatalogueUseCase.getTVSeriesDetail(id).asLiveData()

    fun insertFavoriteTVSeries(movieFavoriteEntity: TVSeriesFavoriteEntity) = viewModelScope.launch {
        movieCatalogueUseCase.setFavoriteTVSeries(movieFavoriteEntity)
    }

    fun deleteFavoriteTVSeries(movieFavoriteEntity: TVSeriesFavoriteEntity) = viewModelScope.launch {
        movieCatalogueUseCase.deleteFavoriteTVSeries(movieFavoriteEntity)
    }

    fun isFavoriteTVSeries(id: Int) = movieCatalogueUseCase.isFavoriteTVSeriesExist(id).asLiveData()
}