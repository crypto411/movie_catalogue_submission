package com.user.fadhlanhadaina.core.data.source.remote

import com.user.fadhlanhadaina.core.data.source.remote.network.ApiResource
import com.user.fadhlanhadaina.core.data.source.remote.response.DetailMovieResponse
import com.user.fadhlanhadaina.core.data.source.remote.response.DetailTVSeriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val clientApi: ApiResource) {

    fun getMovies(): Flow<ArrayList<DetailMovieResponse>> = flow {
        val response = clientApi.getMovieLists()
        val results = response.results
        emit(results)
    }.flowOn(Dispatchers.IO)

    fun getMovieDetail(id: Int): Flow<DetailMovieResponse> = flow {
        val results = clientApi.getMovieDetail(id)
        emit(results)
    }.flowOn(Dispatchers.IO)

    fun getTVSeries(): Flow<ArrayList<DetailTVSeriesResponse>> = flow {
        val response = clientApi.getTVSerieLists()
        val results = response.results
        emit(results)
    }.flowOn(Dispatchers.IO)

    fun getTVSeriesDetail(id: Int): Flow<DetailTVSeriesResponse> = flow {
        val results = clientApi.getTVSeriesDetail(id)
        emit(results)
    }.flowOn(Dispatchers.IO)
}