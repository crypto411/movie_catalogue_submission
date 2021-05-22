package com.user.fadhlanhadaina.favorite_feature.fragment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.model.MovieFavorite
import com.user.fadhlanhadaina.core.source.MovieCatalogueRepository

class FavoriteMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    fun getAllFavoriteMovie(): LiveData<PagedList<MovieFavorite>> =
        movieCatalogueRepository.getFavoriteMovies()
}