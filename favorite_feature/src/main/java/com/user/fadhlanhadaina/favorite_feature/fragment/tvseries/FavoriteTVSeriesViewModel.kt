package com.user.fadhlanhadaina.favorite_feature.fragment.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.domain.model.entity.TVSeriesFavoriteEntity
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase

class FavoriteTVSeriesViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {
    fun getAllFavoriteTVSeries(): LiveData<PagedList<TVSeriesFavoriteEntity>> =
        movieCatalogueUseCase.getFavoriteTVSeries()
}