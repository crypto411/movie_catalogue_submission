package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.user.fadhlanhadaina.core.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.core.model.TVSeries

class TVSeriesViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    private var tvSeriesLists: LiveData<ArrayList<TVSeries>>? = null

    fun getTVSeries(): LiveData<ArrayList<TVSeries>>? {
        if(tvSeriesLists == null)
            tvSeriesLists = movieCatalogueRepository.getTVSeries()
        return tvSeriesLists
    }
}