package com.user.fadhlanhadaina.moviecataloguesubmission.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.Movie
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.MovieFavorite
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.TVSeries
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.TVSeriesFavorite
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.local.LocalDataSource
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieCatalogueRepository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource):
    MovieCatalogueDataSource {

    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null
        fun newInstance(remoteData: RemoteDataSource, localData: LocalDataSource): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData, localData).apply { instance = this }
            }
    }

    override fun getMovies(): LiveData<ArrayList<Movie>> {
        val movieLiveData = MutableLiveData<ArrayList<Movie>>()
        remoteDataSource.getMovies(object: RemoteDataSource.PopularMovieCallback {
            override fun onMoviesReceived(movieResponse: ArrayList<Movie>) {
                movieLiveData.postValue(movieResponse)
            }
        })
        return movieLiveData
    }

    override fun getMovieDetail(id: Int): LiveData<Movie> {
        val movieLiveData = MutableLiveData<Movie>()
        remoteDataSource.getMovieDetail(id, object: RemoteDataSource.MovieDetailCallback {
            override fun onDetailMovieReceived(movie: Movie) {
                movie.genres.forEachIndexed { index, genre ->
                    movie.stringGenres = if(index == 0 && movie.genres.size > 1)
                        "${genre.name},"
                    else if(index == 0)
                        genre.name
                    else if(index == movie.genres.size-1)
                        "${movie.stringGenres} ${genre.name}"
                    else
                        "${movie.stringGenres} ${genre.name},"
                }
                movieLiveData.postValue(movie)
            }

        })
        return movieLiveData
    }

    override fun getTVSeries(): LiveData<ArrayList<TVSeries>> {
        val tvSeriesLiveData = MutableLiveData<ArrayList<TVSeries>>()
        remoteDataSource.getTVSeries(object: RemoteDataSource.PopularTVSeriesCallback {
            override fun onTVSeriesReceived(tvSeriesResponse: ArrayList<TVSeries>) {
                tvSeriesLiveData.postValue(tvSeriesResponse)
            }
        })
        return tvSeriesLiveData
    }

    override fun getTVSeriesDetail(id: Int): LiveData<TVSeries> {
        val tvSeriesLiveData = MutableLiveData<TVSeries>()
        remoteDataSource.getTVSeriesDetail(id, object: RemoteDataSource.TVSeriesDetailCallback {
            override fun onTVSeriesReceived(tvSeries: TVSeries) {
                tvSeries.genres.forEachIndexed { index, genre ->
                    tvSeries.stringGenres = if(index == 0 && tvSeries.genres.size > 1)
                        "${genre.name},"
                    else if(index == 0)
                        genre.name
                    else if(index == tvSeries.genres.size-1)
                        "${tvSeries.stringGenres} ${genre.name}"
                    else
                        "${tvSeries.stringGenres} ${genre.name},"
                }
                tvSeries.duration = if(tvSeries.durationArray.size > 0) tvSeries.durationArray[0] else 0
                tvSeriesLiveData.postValue(tvSeries)
            }

        })
        return tvSeriesLiveData
    }

    override fun getFavoriteMovies(): LiveData<PagedList<MovieFavorite>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getAllFavoriteMovie(), config).build()
    }

    override fun isFavoriteMovieExist(id: Int): Boolean {
        return (localDataSource.getFavoriteMovieById(id) != null)
    }

    override suspend fun setFavoriteMovie(favoriteMovie: MovieFavorite) {
        withContext(Dispatchers.IO) {
            localDataSource.insertFavoriteMovie(favoriteMovie)
        }
    }

    override suspend fun deleteFavoriteMovie(favoriteMovie: MovieFavorite) {
        withContext(Dispatchers.IO) {
            localDataSource.deleteFavoriteMovie(favoriteMovie)
        }
    }

    override fun getFavoriteTVSeries(): LiveData<PagedList<TVSeriesFavorite>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getAllFavoriteTVSeries(), config).build()
    }

    override fun isFavoriteTVSeriesExist(id: Int): Boolean {
        return (localDataSource.getFavoriteTVSeriesById(id) != null)
    }

    override suspend fun setFavoriteTVSeries(favoriteTVSeriesFavorite: TVSeriesFavorite) {
        withContext(Dispatchers.IO) {
            localDataSource.insertFavoriteTVSeries(favoriteTVSeriesFavorite)
        }
    }

    override suspend fun deleteFavoriteTVSeries(favoriteTVSeriesFavorite: TVSeriesFavorite) {
        withContext(Dispatchers.IO) {
            localDataSource.deleteFavoriteTVSeries(favoriteTVSeriesFavorite)
        }
    }
}