package com.user.fadhlanhadaina.core.data.source.remote.network

import com.user.fadhlanhadaina.core.BuildConfig
import com.user.fadhlanhadaina.core.data.source.remote.response.DetailMovieResponse
import com.user.fadhlanhadaina.core.data.source.remote.response.DetailTVSeriesResponse
import com.user.fadhlanhadaina.core.data.source.remote.response.MovieResponse
import com.user.fadhlanhadaina.core.data.source.remote.response.TVSeriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiResource {
    companion object {
        const val apiKey = BuildConfig.TMDB_API_KEY
    }

    @GET("movie/popular?api_key=$apiKey")
    fun getMovieLists(): Call<MovieResponse>

    @GET("movie/{id}?api_key=$apiKey")
    fun getMovieDetail(@Path("id") id: Int): Call<DetailMovieResponse>

    @GET("tv/popular?api_key=$apiKey")
    fun getTVSerieLists(): Call<TVSeriesResponse>

    @GET("tv/{id}?api_key=$apiKey")
    fun getTVSeriesDetail(@Path("id") id: Int): Call<DetailTVSeriesResponse>
}