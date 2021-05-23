package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase

class MovieViewModel @ViewModelInject constructor(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {
    fun getMovies() = movieCatalogueUseCase.getMovies().asLiveData()
}