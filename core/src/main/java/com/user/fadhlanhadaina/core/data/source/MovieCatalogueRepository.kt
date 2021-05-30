package com.user.fadhlanhadaina.core.data.source

import com.user.fadhlanhadaina.core.data.source.remote.RemoteDataSource
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.data.source.local.LocalDataSource
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository
import com.user.fadhlanhadaina.core.util.Mapper.mapToFavoriteEntity
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

    override fun getFavoriteMovies(): Flow<List<Movie>> = flow {
        val flow = localDataSource.getAllFavoriteMovie()
        val list = flow.first()
        emit(list.mapToMovie())
    }.flowOn(Dispatchers.IO)

    override fun isFavoriteMovieExist(id: Int): Flow<Movie?> = flow {
        val flow = localDataSource.getFavoriteMovieById(id)
        val model = flow.first()
        emit(model?.mapToMovie())
    }.flowOn(Dispatchers.IO)

    override suspend fun setFavoriteMovie(movie: Movie) {
        withContext(Dispatchers.IO) {
            localDataSource.insertFavoriteMovie(movie.mapToFavoriteEntity())
        }
    }

    override suspend fun deleteFavoriteMovie(movie: Movie) {
        withContext(Dispatchers.IO) {
            localDataSource.deleteFavoriteMovie(movie.mapToFavoriteEntity())
        }
    }

    override fun getFavoriteTVSeries(): Flow<List<TVSeries>> = flow {
        val flow = localDataSource.getAllFavoriteTVSeries()
        val list = flow.first()
        emit(list.mapToTVSeries())
    }.flowOn(Dispatchers.IO)

    override fun isFavoriteTVSeriesExist(id: Int): Flow<TVSeries?> = flow {
        val flow = localDataSource.getFavoriteTVSeriesById(id)
        val model = flow.first()
        emit(model?.mapToTVSeries())
    }.flowOn(Dispatchers.IO)

    override suspend fun setFavoriteTVSeries(tvSeries: TVSeries) {
        withContext(Dispatchers.IO) {
            localDataSource.insertFavoriteTVSeries(tvSeries.mapToFavoriteEntity())
        }
    }

    override suspend fun deleteFavoriteTVSeries(tvSeries: TVSeries) {
        withContext(Dispatchers.IO) {
            localDataSource.deleteFavoriteTVSeries(tvSeries.mapToFavoriteEntity())
        }
    }
}