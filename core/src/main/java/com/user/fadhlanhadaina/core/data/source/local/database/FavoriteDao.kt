package com.user.fadhlanhadaina.core.data.source.local.database

import androidx.room.*
import com.user.fadhlanhadaina.core.data.source.local.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.data.source.local.entity.TVSeriesFavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM moviefavoriteentity")
    fun getAllMovies(): Flow<List<MovieFavoriteEntity>>

    @Query("SELECT * FROM moviefavoriteentity WHERE id = :id LIMIT 1")
    fun getMovieById(id: Int): Flow<MovieFavoriteEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieEntity: MovieFavoriteEntity)

    @Delete
    suspend fun delete(movieEntity: MovieFavoriteEntity)

/*================================================================================================*/
    @Query("SELECT * FROM tvseriesfavoriteentity")
    fun getAllTVSeries(): Flow<List<TVSeriesFavoriteEntity>>

    @Query("SELECT * FROM tvseriesfavoriteentity WHERE id = :id LIMIT 1")
    fun getTVSeriesById(id: Int): Flow<TVSeriesFavoriteEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tvSeriesEntity: TVSeriesFavoriteEntity)

    @Delete
    suspend fun delete(tvSeriesEntity: TVSeriesFavoriteEntity)
}