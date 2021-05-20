package com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote

import android.util.Log
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.Movie
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.TVSeries
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote.response.MoviesResponse
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote.response.TVSeriesResponse
import com.user.fadhlanhadaina.moviecataloguesubmission.utils.EspressoIdlingResource
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
        EspressoIdlingResource.increment()

        clientApi.getMovieLists().enqueue(object: Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                response.body().let { it?.movieLists?.let { it1 -> callback.onMoviesReceived(it1) } }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.d("getMovieLists", t.localizedMessage!!)
                EspressoIdlingResource.decrement()
            }

        })
    }

    fun getMovieDetail(id: Int, callback: MovieDetailCallback) {
        EspressoIdlingResource.increment()

        clientApi.getMovieDetail(id).enqueue(object: Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                response.body().let { movie ->
                    movie?.let {it ->
                        callback.onDetailMovieReceived(it) }
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.d("getMovieDetail", t.localizedMessage!!)
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getTVSeries(callback: PopularTVSeriesCallback) {
        EspressoIdlingResource.increment()

        clientApi.getTVSerieLists().enqueue(object: Callback<TVSeriesResponse> {
            override fun onResponse(call: Call<TVSeriesResponse>, response: Response<TVSeriesResponse>) {
                response.body().let { tvSerieLists ->
                    tvSerieLists?.let {
                        callback.onTVSeriesReceived(it.tvSerieLists)
                    }
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TVSeriesResponse>, t: Throwable) {
                Log.d("getTVSeriesList", t.localizedMessage!!)
                EspressoIdlingResource.decrement()
            }

        })
    }

    fun getTVSeriesDetail(id: Int, callback: TVSeriesDetailCallback) {
        EspressoIdlingResource.increment()

        clientApi.getTVSeriesDetail(id).enqueue(object: Callback<TVSeries> {
            override fun onResponse(call: Call<TVSeries>, response: Response<TVSeries>) {
                response.body().let { tvSeries ->
                    tvSeries?.let {
                        callback.onTVSeriesReceived(it)
                    }
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TVSeries>, t: Throwable) {
                Log.d("getTVSeriesDetail", t.localizedMessage!!)
                EspressoIdlingResource.decrement()
            }
        })
    }

    interface PopularMovieCallback {
        fun onMoviesReceived(movieResponse: ArrayList<Movie>)
    }

    interface MovieDetailCallback {
        fun onDetailMovieReceived(movie: Movie)
    }

    interface PopularTVSeriesCallback {
        fun onTVSeriesReceived(tvSeriesResponse: ArrayList<TVSeries>)
    }

    interface TVSeriesDetailCallback {
        fun onTVSeriesReceived(tvSeries: TVSeries)
    }
}