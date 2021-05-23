package com.user.fadhlanhadaina.core.data.source.local

import com.user.fadhlanhadaina.core.data.source.local.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.data.source.local.entity.TVSeriesFavoriteEntity
import com.user.fadhlanhadaina.core.data.source.local.database.FavoriteDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val favoriteDao: FavoriteDao) {
    // Favorite Movie
    suspend fun insertFavoriteMovie(movieFavoriteEntity: MovieFavoriteEntity) = favoriteDao.insert(movieFavoriteEntity)
    suspend fun deleteFavoriteMovie(movieFavoriteEntity: MovieFavoriteEntity) = favoriteDao.delete(movieFavoriteEntity)
    fun getAllFavoriteMovie() = favoriteDao.getAllMovies()
    fun getFavoriteMovieById(id: Int) = favoriteDao.getMovieById(id)

    // Favorite TVSeries
    suspend fun insertFavoriteTVSeries(tvSeriesFavoriteEntity: TVSeriesFavoriteEntity) = favoriteDao.insert(tvSeriesFavoriteEntity)
    suspend fun deleteFavoriteTVSeries(tvSeriesFavoriteEntity: TVSeriesFavoriteEntity) = favoriteDao.delete(tvSeriesFavoriteEntity)
    fun getAllFavoriteTVSeries() = favoriteDao.getAllTVSeries()
    fun getFavoriteTVSeriesById(id: Int) = favoriteDao.getTVSeriesById(id)
}