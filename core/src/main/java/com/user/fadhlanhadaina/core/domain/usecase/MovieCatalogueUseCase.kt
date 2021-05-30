package com.user.fadhlanhadaina.core.domain.usecase

import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import kotlinx.coroutines.flow.Flow

interface MovieCatalogueUseCase {
    fun getMovies(): Flow<ArrayList<Movie>>
    fun getMovieDetail(id: Int): Flow<Movie>
    fun getTVSeries(): Flow<ArrayList<TVSeries>>
    fun getTVSeriesDetail(id: Int): Flow<TVSeries>

    fun getFavoriteMovies(): Flow<List<Movie>>
    fun isFavoriteMovieExist(id: Int): Flow<Movie?>
    suspend fun setFavoriteMovie(favoriteMovie: Movie)
    suspend fun deleteFavoriteMovie(favoriteMovie: Movie)

    fun getFavoriteTVSeries(): Flow<List<TVSeries>>
    fun isFavoriteTVSeriesExist(id: Int): Flow<TVSeries?>
    suspend fun setFavoriteTVSeries(favoriteTVSeries: TVSeries)
    suspend fun deleteFavoriteTVSeries(favoriteTVSeries: TVSeries)
}