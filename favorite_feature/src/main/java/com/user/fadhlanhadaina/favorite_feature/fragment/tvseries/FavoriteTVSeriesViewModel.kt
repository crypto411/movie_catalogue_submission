package com.user.fadhlanhadaina.favorite_feature.fragment.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.model.TVSeriesFavorite
import com.user.fadhlanhadaina.core.source.MovieCatalogueRepository

class FavoriteTVSeriesViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    fun getAllFavoriteTVSeries(): LiveData<PagedList<TVSeriesFavorite>> =
        movieCatalogueRepository.getFavoriteTVSeries()
}