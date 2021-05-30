package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase

class DetailTVSeriesViewModel @ViewModelInject constructor(private val movieCatalogueUseCase: MovieCatalogueUseCase): ViewModel() {
    fun getTVSeries(id: Int) = movieCatalogueUseCase.getTVSeriesDetail(id).asLiveData()
    fun isFavoriteTVSeries(id: Int) = movieCatalogueUseCase.isFavoriteTVSeriesExist(id).asLiveData()

    suspend fun insertFavoriteTVSeries(tvSeriesFavorite: TVSeries) = movieCatalogueUseCase.setFavoriteTVSeries(tvSeriesFavorite)
    suspend fun deleteFavoriteTVSeries(tvSeriesFavorite: TVSeries) = movieCatalogueUseCase.deleteFavoriteTVSeries(tvSeriesFavorite)

}