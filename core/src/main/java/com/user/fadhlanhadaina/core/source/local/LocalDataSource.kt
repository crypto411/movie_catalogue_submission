package com.user.fadhlanhadaina.core.source.local

import androidx.paging.DataSource
import com.user.fadhlanhadaina.core.model.MovieFavorite
import com.user.fadhlanhadaina.core.model.TVSeriesFavorite
import com.user.fadhlanhadaina.core.source.local.database.FavoriteDao

class LocalDataSource constructor(private val favoriteDao: FavoriteDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun newInstance(favoriteDao: FavoriteDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(favoriteDao)
    }

    // Favorite Movie
    fun insertFavoriteMovie(movieFavorite: MovieFavorite) = favoriteDao.insert(movieFavorite)
    fun deleteFavoriteMovie(movieFavorite: MovieFavorite) = favoriteDao.delete(movieFavorite)
    fun getAllFavoriteMovie(): DataSource.Factory<Int, MovieFavorite> = favoriteDao.getAllMovies()
    fun getFavoriteMovieById(id: Int): MovieFavorite? = favoriteDao.getMovieById(id)

    // Favorite TVSeries
    fun insertFavoriteTVSeries(tvSeriesFavorite: TVSeriesFavorite) = favoriteDao.insert(tvSeriesFavorite)
    fun deleteFavoriteTVSeries(tvSeriesFavorite: TVSeriesFavorite) = favoriteDao.delete(tvSeriesFavorite)
    fun getAllFavoriteTVSeries(): DataSource.Factory<Int, TVSeriesFavorite> = favoriteDao.getAllTVSeries()
    fun getFavoriteTVSeriesById(id: Int): TVSeriesFavorite? = favoriteDao.getTVSeriesById(id)
}