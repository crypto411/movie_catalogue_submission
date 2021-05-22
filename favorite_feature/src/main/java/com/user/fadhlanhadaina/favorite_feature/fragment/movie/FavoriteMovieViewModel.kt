package com.user.fadhlanhadaina.favorite_feature.fragment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.domain.model.MovieFavorite
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository

class FavoriteMovieViewModel(private val movieCatalogueRepository: IMovieCatalogueRepository) : ViewModel() {
    fun getAllFavoriteMovie(): LiveData<PagedList<MovieFavorite>> =
        movieCatalogueRepository.getFavoriteMovies()
}