package com.user.fadhlanhadaina.core.data.source.local.database

import androidx.paging.DataSource
import androidx.room.*
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.model.entity.TVSeriesFavoriteEntity

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM moviefavoriteentity")
    fun getAllMovies(): DataSource.Factory<Int, MovieFavoriteEntity>

    @Query("SELECT * FROM moviefavoriteentity WHERE id = :id LIMIT 1")
    fun getMovieById(id: Int): MovieFavoriteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieEntity: MovieFavoriteEntity)

    @Delete
    fun delete(movieEntity: MovieFavoriteEntity)

/*================================================================================================*/
    @Query("SELECT * FROM tvseriesfavoriteentity")
    fun getAllTVSeries(): DataSource.Factory<Int, TVSeriesFavoriteEntity>

    @Query("SELECT * FROM tvseriesfavoriteentity WHERE id = :id LIMIT 1")
    fun getTVSeriesById(id: Int): TVSeriesFavoriteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tvSeriesEntity: TVSeriesFavoriteEntity)

    @Delete
    fun delete(tvSeriesEntity: TVSeriesFavoriteEntity)
}