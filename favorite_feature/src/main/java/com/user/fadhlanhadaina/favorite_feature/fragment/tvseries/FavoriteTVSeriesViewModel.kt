package com.user.fadhlanhadaina.favorite_feature.fragment.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.domain.model.TVSeriesFavorite
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository

class FavoriteTVSeriesViewModel(private val movieCatalogueRepository: IMovieCatalogueRepository) : ViewModel() {
    fun getAllFavoriteTVSeries(): LiveData<PagedList<TVSeriesFavorite>> =
        movieCatalogueRepository.getFavoriteTVSeries()
}