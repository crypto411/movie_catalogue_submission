package com.user.fadhlanhadaina.core.data.source.remote

import android.util.Log
import com.user.fadhlanhadaina.core.data.source.remote.response.DetailMovieResponse
import com.user.fadhlanhadaina.core.data.source.remote.response.DetailTVSeriesResponse
import com.user.fadhlanhadaina.core.data.source.remote.response.MovieResponse
import com.user.fadhlanhadaina.core.data.source.remote.response.TVSeriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(private val clientApi: ApiResource) {
    companion object {
        fun newInstance(clientApi: ApiResource): RemoteDataSource {
            return RemoteDataSource(clientApi)
        }
    }

    fun getMovies(callback: PopularMovieCallback) {

        clientApi.getMovieLists().enqueue(object: Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                response.body().let { it?.results?.let { it1 -> callback.onMoviesReceived(it1) } }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("getMovieLists", t.localizedMessage!!)
            }

        })
    }

    fun getMovieDetail(id: Int, callback: MovieDetailCallback) {

        clientApi.getMovieDetail(id).enqueue(object: Callback<DetailMovieResponse> {
            override fun onResponse(call: Call<DetailMovieResponse>, response: Response<DetailMovieResponse>) {
                response.body().let { movie ->
                    movie?.let {it ->
                        callback.onDetailMovieReceived(it) }
                }
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.d("getMovieDetail", t.localizedMessage!!)
            }
        })
    }

    fun getTVSeries(callback: PopularTVSeriesCallback) {

        clientApi.getTVSerieLists().enqueue(object: Callback<TVSeriesResponse> {
            override fun onResponse(call: Call<TVSeriesResponse>, response: Response<TVSeriesResponse>) {
                response.body().let { tvSerieLists ->
                    tvSerieLists?.let {
                        callback.onTVSeriesReceived(it.results)
                    }
                }
            }

            override fun onFailure(call: Call<TVSeriesResponse>, t: Throwable) {
                Log.d("getTVSeriesList", t.localizedMessage!!)
            }

        })
    }

    fun getTVSeriesDetail(id: Int, callback: TVSeriesDetailCallback) {

        clientApi.getTVSeriesDetail(id).enqueue(object: Callback<DetailTVSeriesResponse> {
            override fun onResponse(call: Call<DetailTVSeriesResponse>, response: Response<DetailTVSeriesResponse>) {
                response.body().let { tvSeries ->
                    tvSeries?.let {
                        callback.onTVSeriesReceived(it)
                    }
                }
            }

            override fun onFailure(call: Call<DetailTVSeriesResponse>, t: Throwable) {
                Log.d("getTVSeriesDetail", t.localizedMessage!!)
            }
        })
    }

    interface PopularMovieCallback {
        fun onMoviesReceived(movieResponse: ArrayList<DetailMovieResponse>)
    }

    interface MovieDetailCallback {
        fun onDetailMovieReceived(detailMovieResponse: DetailMovieResponse)
    }

    interface PopularTVSeriesCallback {
        fun onTVSeriesReceived(tvSeriesResponse: ArrayList<DetailTVSeriesResponse>)
    }

    interface TVSeriesDetailCallback {
        fun onTVSeriesReceived(detailTVSeriesResponse: DetailTVSeriesResponse)
    }
}