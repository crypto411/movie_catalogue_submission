package com.user.fadhlanhadaina.core.domain.repository

import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import kotlinx.coroutines.flow.Flow

interface IMovieCatalogueRepository {
    fun getMovies(): Flow<ArrayList<Movie>>
    fun getMovieDetail(id: Int): Flow<Movie>
    fun getTVSeries(): Flow<ArrayList<TVSeries>>
    fun getTVSeriesDetail(id: Int): Flow<TVSeries>

    fun getFavoriteMovies(): Flow<List<Movie>>
    fun isFavoriteMovieExist(id: Int): Flow<Movie?>
    suspend fun setFavoriteMovie(movie: Movie)
    suspend fun deleteFavoriteMovie(movie: Movie)

    fun getFavoriteTVSeries(): Flow<List<TVSeries>>
    fun isFavoriteTVSeriesExist(id: Int): Flow<TVSeries?>
    suspend fun setFavoriteTVSeries(tvSeries: TVSeries)
    suspend fun deleteFavoriteTVSeries(TVSeries: TVSeries)
}