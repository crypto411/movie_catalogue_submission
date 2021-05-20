package com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote

import com.user.fadhlanhadaina.moviecataloguesubmission.BuildConfig
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.Movie
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.TVSeries
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote.response.MoviesResponse
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote.response.TVSeriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiResource {
    companion object {
        const val apiKey = BuildConfig.TMDB_API_KEY
    }

    @GET("movie/popular?api_key=$apiKey")
    fun getMovieLists(): Call<MoviesResponse>

    @GET("movie/{id}?api_key=$apiKey")
    fun getMovieDetail(@Path("id") id: Int): Call<Movie>

    @GET("tv/popular?api_key=$apiKey")
    fun getTVSerieLists(): Call<TVSeriesResponse>

    @GET("tv/{id}?api_key=$apiKey")
    fun getTVSeriesDetail(@Path("id") id: Int): Call<TVSeries>
}