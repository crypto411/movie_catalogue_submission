package com.user.fadhlanhadaina.moviecataloguesubmission.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.Movie
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.MovieFavorite
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.ResourceData
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.TVSeriesFavorite
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.local.LocalDataSource
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote.RemoteDataSource
import com.user.fadhlanhadaina.moviecataloguesubmission.utils.LiveDataTestUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MovieCatalogueRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var remoteDataSource = mock(RemoteDataSource::class.java)
    private var localDataSource = mock(LocalDataSource::class.java)
    private val movieCatalogueRepository = FakeMovieCatalogueRepository(remoteDataSource, localDataSource)

    private var movieListTest = ResourceData.movieListTest
    private var movieTest = ResourceData.movieTest
    private var tvSeriesListTest = ResourceData.tvSerieListTest
    private var tvSeriesTest = ResourceData.tvSeriesTest


    @Test
    fun getMovies() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.PopularMovieCallback).onMoviesReceived(movieListTest)
            null
        }.`when`(remoteDataSource).getMovies(any())
        val movieLists = LiveDataTestUtils.getValue(movieCatalogueRepository.getMovies())
        verify(remoteDataSource).getMovies(any())
        assertNotNull(movieLists)
        assertEquals(movieListTest.size.toLong(), movieLists.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        doAnswer {
            (it.arguments[1] as RemoteDataSource.MovieDetailCallback).onDetailMovieReceived(movieTest)
            null
        }.`when`(remoteDataSource).getMovieDetail(eq(movieTest.id), any())

        val movie: Movie = LiveDataTestUtils.getValue(movieCatalogueRepository.getMovieDetail(movieTest.id))
        verify(remoteDataSource).getMovieDetail(eq(movieTest.id), any())
        assertNotNull(movie)
        assertEquals(movieTest.title, movie.title)
    }

    @Test
    fun getTVSeries() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.PopularTVSeriesCallback).onTVSeriesReceived(tvSeriesListTest)
            null
        }.`when`(remoteDataSource).getTVSeries(any())
        val tvSeriesList = LiveDataTestUtils.getValue(movieCatalogueRepository.getTVSeries())
        verify(remoteDataSource).getTVSeries(any())
        assertNotNull(tvSeriesList)
        assertEquals(tvSeriesListTest.size.toLong(), tvSeriesList.size.toLong())
    }

    @Test
    fun getTVSeriesDetail() {
        doAnswer {
            (it.arguments[1] as RemoteDataSource.TVSeriesDetailCallback).onTVSeriesReceived(tvSeriesTest)
            null
        }.`when`(remoteDataSource).getTVSeriesDetail(eq(tvSeriesTest.id), any())

        val tvSeries = LiveDataTestUtils.getValue(movieCatalogueRepository.getTVSeriesDetail(tvSeriesTest.id))
        verify(remoteDataSource).getTVSeriesDetail(eq(tvSeriesTest.id), any())
        assertNotNull(tvSeries)
        assertEquals(tvSeriesTest.title, tvSeries.title)
    }

    @Test
    fun getAllFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieFavorite>
        `when`(localDataSource.getAllFavoriteMovie()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getFavoriteMovies()
        verify(localDataSource).getAllFavoriteMovie()
    }

    @Test
    fun setMovieFavorite() = runBlocking {
        val movieFavoriteTest = ResourceData.movieFavoriteTest
        movieCatalogueRepository.setFavoriteMovie(movieFavoriteTest)
        verify(localDataSource, times(1)).insertFavoriteMovie(movieFavoriteTest)
    }

    @Test
    fun deleteMovieFavorite() = runBlocking {
        val movieFavoriteTest = ResourceData.movieFavoriteTest
        movieCatalogueRepository.deleteFavoriteMovie(movieFavoriteTest)
        verify(localDataSource, times(1)).deleteFavoriteMovie(movieFavoriteTest)
    }

    @Test
    fun isMovieFavorited() {
        val movieFavorite = ResourceData.movieFavoriteTest
        movieCatalogueRepository.isFavoriteMovieExist(movieFavorite.id)
        verify(localDataSource).getFavoriteMovieById(movieFavorite.id)
    }

    @Test
    fun getAllFavoriteTVSeries() {
        val dataSourceFactory: DataSource.Factory<Int, TVSeriesFavorite> = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVSeriesFavorite>
        `when`(localDataSource.getAllFavoriteTVSeries()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getFavoriteTVSeries()
        verify(localDataSource).getAllFavoriteTVSeries()
    }

    @Test
    fun setTVSeriesFavorite() = runBlocking {
        val tvSeriesFavoriteTest = ResourceData.tvSeriesFavoriteTest
        movieCatalogueRepository.setFavoriteTVSeries(tvSeriesFavoriteTest)
        verify(localDataSource, times(1)).insertFavoriteTVSeries(tvSeriesFavoriteTest)
    }

    @Test
    fun deleteTVSeriesFavorite() = runBlocking {
        val tvSeriesFavoriteTest = ResourceData.tvSeriesFavoriteTest
        movieCatalogueRepository.deleteFavoriteTVSeries(tvSeriesFavoriteTest)
        verify(localDataSource, times(1)).deleteFavoriteTVSeries(tvSeriesFavoriteTest)
    }

    @Test
    fun isTVSerisFavorited() {
        val tvSeriesFavorite = ResourceData.tvSeriesFavoriteTest
        movieCatalogueRepository.isFavoriteTVSeriesExist(tvSeriesFavorite.id)
        verify(localDataSource).getFavoriteTVSeriesById(tvSeriesFavorite.id)
    }
}