package com.user.fadhlanhadaina.favorite_feature.ui.fragment.tvseries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase

class FavoriteTVSeriesViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {
    fun getAllFavoriteTVSeries() = movieCatalogueUseCase.getFavoriteTVSeries().asLiveData()
}