package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.Movie
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.ResourceData
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository
    private lateinit var detailMovieViewModel: DetailMovieViewModel
    private var movieTest: Movie? = null
    private var movie: Movie? = null
    private var id: Int = 0

    @Before
    fun before() {
        detailMovieViewModel = DetailMovieViewModel(movieCatalogueRepository)
        id = 460465
        movieTest = ResourceData.movieTest
    }

    @Test
    fun getMovie() {
        val movieLiveData = MutableLiveData<Movie>()

        movieLiveData.postValue(movieTest)

        `when`(movieCatalogueRepository.getMovieDetail(id)).thenReturn(movieLiveData)
        movie = detailMovieViewModel.getMovie(id)?.value
        movie?.id?.let{ verify(movieCatalogueRepository).getMovieDetail(it) }

        assertNotNull(movie)
        assertEquals(movieTest?.id, movie?.id)
        assertEquals(movieTest?.posterUrl, movie?.posterUrl)
        assertEquals(movieTest?.title, movie?.title)
        assertEquals(movieTest?.date, movie?.date)
        assertEquals(movieTest?.genres, movie?.genres)
        assertEquals(movieTest?.duration, movie?.duration)
        assertEquals(movieTest?.overview, movie?.overview)
    }

    @Test
    fun setMovieFavorite() = runBlocking {
        val movieFavoriteTest = ResourceData.movieFavoriteTest
        detailMovieViewModel.insertFavoriteMovie(movieFavoriteTest)
        verify(movieCatalogueRepository).setFavoriteMovie(movieFavoriteTest)
    }

    @Test
    fun deleteMovieFavorite() = runBlocking {
        val movieFavoriteTest = ResourceData.movieFavoriteTest
        detailMovieViewModel.deleteFavoriteMovie(movieFavoriteTest)
        verify(movieCatalogueRepository).deleteFavoriteMovie(movieFavoriteTest)
    }

    @Test
    fun isMovieFavorited() {
        val movieFavoriteTest = ResourceData.movieFavoriteTest
        detailMovieViewModel.isFavoriteMovie(movieFavoriteTest.id)
        verify(movieCatalogueRepository).isFavoriteMovieExist(movieFavoriteTest.id)
    }
}