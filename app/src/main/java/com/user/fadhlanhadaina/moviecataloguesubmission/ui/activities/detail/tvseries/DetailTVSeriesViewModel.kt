package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.domain.model.entity.TVSeriesFavoriteEntity
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailTVSeriesViewModel @Inject constructor(private val movieCatalogueUseCase: MovieCatalogueUseCase): ViewModel() {
    private var tvSeries: LiveData<TVSeries>? = null

    fun getTVSeries(id: Int): LiveData<TVSeries>? {
        if(tvSeries == null)
            tvSeries = movieCatalogueUseCase.getTVSeriesDetail(id)
        return tvSeries
    }

    fun insertFavoriteTVSeries(movieFavoriteEntity: TVSeriesFavoriteEntity) = viewModelScope.launch {
        movieCatalogueUseCase.setFavoriteTVSeries(movieFavoriteEntity)
    }

    fun deleteFavoriteTVSeries(movieFavoriteEntity: TVSeriesFavoriteEntity) = viewModelScope.launch {
        movieCatalogueUseCase.deleteFavoriteTVSeries(movieFavoriteEntity)
    }

    fun isFavoriteTVSeries(id: Int) = movieCatalogueUseCase.isFavoriteTVSeriesExist(id)
}