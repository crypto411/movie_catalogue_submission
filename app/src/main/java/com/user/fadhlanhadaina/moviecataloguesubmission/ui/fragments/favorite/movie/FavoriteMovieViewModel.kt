package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.MovieFavorite
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.MovieCatalogueRepository

class FavoriteMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    fun getAllFavoriteMovie(): LiveData<PagedList<MovieFavorite>> =
        movieCatalogueRepository.getFavoriteMovies()
}