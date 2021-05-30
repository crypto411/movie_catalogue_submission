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
    fun isFavoriteTVSeries(id: Int) = movieCatalogueUseCase.isFavoriteTVSeriesExist(id).asLiveData()

    suspend fun insertFavoriteTVSeries(movieFavoriteEntity: TVSeriesFavoriteEntity) = movieCatalogueUseCase.setFavoriteTVSeries(movieFavoriteEntity)
    suspend fun deleteFavoriteTVSeries(movieFavoriteEntity: TVSeriesFavoriteEntity) = movieCatalogueUseCase.deleteFavoriteTVSeries(movieFavoriteEntity)

}