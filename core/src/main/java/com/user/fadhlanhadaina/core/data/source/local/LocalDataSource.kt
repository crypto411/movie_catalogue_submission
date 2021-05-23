package com.user.fadhlanhadaina.core.data.source.local

import androidx.paging.DataSource
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.model.entity.TVSeriesFavoriteEntity
import com.user.fadhlanhadaina.core.data.source.local.database.FavoriteDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val favoriteDao: FavoriteDao) {
    // Favorite Movie
    fun insertFavoriteMovie(movieFavoriteEntity: MovieFavoriteEntity) = favoriteDao.insert(movieFavoriteEntity)
    fun deleteFavoriteMovie(movieFavoriteEntity: MovieFavoriteEntity) = favoriteDao.delete(movieFavoriteEntity)
    fun getAllFavoriteMovie(): DataSource.Factory<Int, MovieFavoriteEntity> = favoriteDao.getAllMovies()
    fun getFavoriteMovieById(id: Int): MovieFavoriteEntity? = favoriteDao.getMovieById(id)

    // Favorite TVSeries
    fun insertFavoriteTVSeries(tvSeriesFavoriteEntity: TVSeriesFavoriteEntity) = favoriteDao.insert(tvSeriesFavoriteEntity)
    fun deleteFavoriteTVSeries(tvSeriesFavoriteEntity: TVSeriesFavoriteEntity) = favoriteDao.delete(tvSeriesFavoriteEntity)
    fun getAllFavoriteTVSeries(): DataSource.Factory<Int, TVSeriesFavoriteEntity> = favoriteDao.getAllTVSeries()
    fun getFavoriteTVSeriesById(id: Int): TVSeriesFavoriteEntity? = favoriteDao.getTVSeriesById(id)
}