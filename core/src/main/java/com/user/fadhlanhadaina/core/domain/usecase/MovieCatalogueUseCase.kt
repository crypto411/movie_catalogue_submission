package com.user.fadhlanhadaina.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.domain.model.entity.TVSeriesFavoriteEntity

interface MovieCatalogueUseCase {
    fun getMovies(): LiveData<ArrayList<Movie>>
    fun getMovieDetail(id: Int): LiveData<Movie>
    fun getTVSeries(): LiveData<ArrayList<TVSeries>>
    fun getTVSeriesDetail(id: Int): LiveData<TVSeries>

    fun getFavoriteMovies(): LiveData<PagedList<MovieFavoriteEntity>>
    fun isFavoriteMovieExist(id: Int): Boolean
    suspend fun setFavoriteMovie(favoriteMovieEntity: MovieFavoriteEntity)
    suspend fun deleteFavoriteMovie(favoriteMovieEntity: MovieFavoriteEntity)

    fun getFavoriteTVSeries(): LiveData<PagedList<TVSeriesFavoriteEntity>>
    fun isFavoriteTVSeriesExist(id: Int): Boolean
    suspend fun setFavoriteTVSeries(favoriteTVSeriesFavoriteEntity: TVSeriesFavoriteEntity)
    suspend fun deleteFavoriteTVSeries(favoriteTVSeriesFavoriteEntity: TVSeriesFavoriteEntity)
}