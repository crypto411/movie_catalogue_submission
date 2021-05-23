package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.tvseries

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase

class TVSeriesViewModel @ViewModelInject constructor(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {
    fun getTVSeries() = movieCatalogueUseCase.getTVSeries().asLiveData()
}