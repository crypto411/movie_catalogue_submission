package com.user.fadhlanhadaina.core.data.source

import com.user.fadhlanhadaina.core.data.source.remote.RemoteDataSource
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.domain.model.entity.TVSeriesFavoriteEntity
import com.user.fadhlanhadaina.core.data.source.local.LocalDataSource
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository
import com.user.fadhlanhadaina.core.util.Mapper.mapToMovie
import com.user.fadhlanhadaina.core.util.Mapper.mapToTVSeries
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieCatalogueRepository @Inject constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource):
    IMovieCatalogueRepository {

    override fun getMovies(): Flow<ArrayList<Movie>> = flow {
        val flow = remoteDataSource.getMovies()
        val list = flow.first().mapToMovie()
        emit(list)
    }.flowOn(Dispatchers.IO)

    override fun getMovieDetail(id: Int): Flow<Movie> = flow {
        val flow = remoteDataSource.getMovieDetail(id)
        val model = flow.first().mapToMovie()
        emit(model)
    }.flowOn(Dispatchers.IO)

    override fun getTVSeries(): Flow<ArrayList<TVSeries>> = flow {
        val flow = remoteDataSource.getTVSeries()
        val list = flow.first().mapToTVSeries()
        emit(list)
    }.flowOn(Dispatchers.IO)

    override fun getTVSeriesDetail(id: Int): Flow<TVSeries> = flow {
        val flow = remoteDataSource.getTVSeriesDetail(id)
        val model = flow.first().mapToTVSeries()
        emit(model)
    }.flowOn(Dispatchers.IO)

    override fun getFavoriteMovies(): Flow<List<MovieFavoriteEntity>> {
        return localDataSource.getAllFavoriteMovie()
    }

    override fun isFavoriteMovieExist(id: Int): Flow<MovieFavoriteEntity?> {
        return localDataSource.getFavoriteMovieById(id)
    }

    override suspend fun setFavoriteMovie(favoriteMovieEntity: MovieFavoriteEntity) {
        withContext(Dispatchers.IO) {
            localDataSource.insertFavoriteMovie(favoriteMovieEntity)
        }
    }

    override suspend fun deleteFavoriteMovie(favoriteMovieEntity: MovieFavoriteEntity) {
        withContext(Dispatchers.IO) {
            localDataSource.deleteFavoriteMovie(favoriteMovieEntity)
        }
    }

    override fun getFavoriteTVSeries(): Flow<List<TVSeriesFavoriteEntity>> {
        return localDataSource.getAllFavoriteTVSeries()
    }

    override fun isFavoriteTVSeriesExist(id: Int): Flow<TVSeriesFavoriteEntity?> {
        return localDataSource.getFavoriteTVSeriesById(id)
    }

    override suspend fun setFavoriteTVSeries(favoriteTVSeriesFavoriteEntity: TVSeriesFavoriteEntity) {
        withContext(Dispatchers.IO) {
            localDataSource.insertFavoriteTVSeries(favoriteTVSeriesFavoriteEntity)
        }
    }

    override suspend fun deleteFavoriteTVSeries(favoriteTVSeriesFavoriteEntity: TVSeriesFavoriteEntity) {
        withContext(Dispatchers.IO) {
            localDataSource.deleteFavoriteTVSeries(favoriteTVSeriesFavoriteEntity)
        }
    }
}