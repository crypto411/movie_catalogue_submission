package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.tvseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase

class TVSeriesViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {
    private var tvSeriesLists: LiveData<ArrayList<TVSeries>>? = null

    fun getTVSeries(): LiveData<ArrayList<TVSeries>>? {
        if(tvSeriesLists == null)
            tvSeriesLists = movieCatalogueUseCase.getTVSeries()
        return tvSeriesLists
    }
}