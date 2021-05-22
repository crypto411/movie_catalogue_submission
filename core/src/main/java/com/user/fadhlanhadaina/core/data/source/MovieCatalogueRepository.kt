package com.user.fadhlanhadaina.core.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.data.source.remote.RemoteDataSource
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.MovieFavorite
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.domain.model.TVSeriesFavorite
import com.user.fadhlanhadaina.core.data.source.local.LocalDataSource
import com.user.fadhlanhadaina.core.data.source.remote.response.DetailMovieResponse
import com.user.fadhlanhadaina.core.data.source.remote.response.DetailTVSeriesResponse
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository
import com.user.fadhlanhadaina.core.util.Mapper.mapToMovie
import com.user.fadhlanhadaina.core.util.Mapper.mapToTVSeries
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieCatalogueRepository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource):
    IMovieCatalogueRepository {

    companion object {
        @Volatile
        private var instance: IMovieCatalogueRepository? = null
        fun newInstance(remoteData: RemoteDataSource, localData: LocalDataSource): IMovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData, localData).apply { instance = this }
            }
    }

    override fun getMovies(): LiveData<ArrayList<Movie>> {
        val movieLiveData = MutableLiveData<ArrayList<Movie>>()
        remoteDataSource.getMovies(object: RemoteDataSource.PopularMovieCallback {
            override fun onMoviesReceived(movieResponse: ArrayList<DetailMovieResponse>) {
                movieLiveData.postValue(movieResponse.mapToMovie())
            }
        })
        return movieLiveData
    }

    override fun getMovieDetail(id: Int): LiveData<Movie> {
        val movieLiveData = MutableLiveData<Movie>()
        remoteDataSource.getMovieDetail(id, object: RemoteDataSource.MovieDetailCallback {
            override fun onDetailMovieReceived(detailMovieResponse: DetailMovieResponse) {
                movieLiveData.postValue(detailMovieResponse.mapToMovie())
            }
        })
        return movieLiveData
    }

    override fun getTVSeries(): LiveData<ArrayList<TVSeries>> {
        val tvSeriesLiveData = MutableLiveData<ArrayList<TVSeries>>()
        remoteDataSource.getTVSeries(object: RemoteDataSource.PopularTVSeriesCallback {
            override fun onTVSeriesReceived(tvSeriesResponse: ArrayList<DetailTVSeriesResponse>) {
                tvSeriesLiveData.postValue(tvSeriesResponse.mapToTVSeries())
            }
        })
        return tvSeriesLiveData
    }

    override fun getTVSeriesDetail(id: Int): LiveData<TVSeries> {
        val tvSeriesLiveData = MutableLiveData<TVSeries>()
        remoteDataSource.getTVSeriesDetail(id, object: RemoteDataSource.TVSeriesDetailCallback {
            override fun onTVSeriesReceived(detailTVSeriesResponse: DetailTVSeriesResponse) {
                tvSeriesLiveData.postValue(detailTVSeriesResponse.mapToTVSeries())
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