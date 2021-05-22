package com.user.fadhlanhadaina.core.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.MovieFavorite
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.domain.model.TVSeriesFavorite

interface IMovieCatalogueRepository {
    fun getMovies(): LiveData<ArrayList<Movie>>
    fun getMovieDetail(id: Int): LiveData<Movie>
    fun getTVSeries(): LiveData<ArrayList<TVSeries>>
    fun getTVSeriesDetail(id: Int): LiveData<TVSeries>

    fun getFavoriteMovies(): LiveData<PagedList<MovieFavorite>>
    fun isFavoriteMovieExist(id: Int): Boolean
    suspend fun setFavoriteMovie(favoriteMovie: MovieFavorite)
    suspend fun deleteFavoriteMovie(favoriteMovie: MovieFavorite)

    fun getFavoriteTVSeries(): LiveData<PagedList<TVSeriesFavorite>>
    fun isFavoriteTVSeriesExist(id: Int): Boolean
    suspend fun setFavoriteTVSeries(favoriteTVSeriesFavorite: TVSeriesFavorite)
    suspend fun deleteFavoriteTVSeries(favoriteTVSeriesFavorite: TVSeriesFavorite)
}