package com.user.fadhlanhadaina.core.domain.repository

import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.data.source.local.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.data.source.local.entity.TVSeriesFavoriteEntity
import kotlinx.coroutines.flow.Flow

interface IMovieCatalogueRepository {
    fun getMovies(): Flow<ArrayList<Movie>>
    fun getMovieDetail(id: Int): Flow<Movie>
    fun getTVSeries(): Flow<ArrayList<TVSeries>>
    fun getTVSeriesDetail(id: Int): Flow<TVSeries>

    fun getFavoriteMovies(): Flow<List<MovieFavoriteEntity>>
    fun isFavoriteMovieExist(id: Int): Flow<MovieFavoriteEntity?>
    suspend fun setFavoriteMovie(favoriteMovieEntity: MovieFavoriteEntity)
    suspend fun deleteFavoriteMovie(favoriteMovieEntity: MovieFavoriteEntity)

    fun getFavoriteTVSeries(): Flow<List<TVSeriesFavoriteEntity>>
    fun isFavoriteTVSeriesExist(id: Int): Flow<TVSeriesFavoriteEntity?>
    suspend fun setFavoriteTVSeries(favoriteTVSeriesFavoriteEntity: TVSeriesFavoriteEntity)
    suspend fun deleteFavoriteTVSeries(favoriteTVSeriesFavoriteEntity: TVSeriesFavoriteEntity)
}