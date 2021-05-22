package com.user.fadhlanhadaina.core.data.source.local.database

import androidx.paging.DataSource
import androidx.room.*
import com.user.fadhlanhadaina.core.domain.model.MovieFavorite
import com.user.fadhlanhadaina.core.domain.model.TVSeriesFavorite

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM moviefavorite")
    fun getAllMovies(): DataSource.Factory<Int, MovieFavorite>

    @Query("SELECT * FROM moviefavorite WHERE id = :id LIMIT 1")
    fun getMovieById(id: Int): MovieFavorite?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieFavorite)

    @Delete
    fun delete(movie: MovieFavorite)

/*================================================================================================*/
    @Query("SELECT * FROM tvseriesfavorite")
    fun getAllTVSeries(): DataSource.Factory<Int, TVSeriesFavorite>

    @Query("SELECT * FROM tvseriesfavorite WHERE id = :id LIMIT 1")
    fun getTVSeriesById(id: Int): TVSeriesFavorite?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tvSeries: TVSeriesFavorite)

    @Delete
    fun delete(tvSeries: TVSeriesFavorite)
}