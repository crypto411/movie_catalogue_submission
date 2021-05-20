package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.favorite.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.TVSeriesFavorite
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.MovieCatalogueRepository

class FavoriteTVSeriesViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    fun getAllFavoriteTVSeries(): LiveData<PagedList<TVSeriesFavorite>> =
        movieCatalogueRepository.getFavoriteTVSeries()
}