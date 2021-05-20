package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.Movie
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.ResourceData
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<ArrayList<Movie>>

    @Before
    fun before() {
        viewModel = MovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovies() {
        val movieListsDummy = ResourceData.movieListTest
        val moviesLiveData: MutableLiveData<ArrayList<Movie>> = MutableLiveData()

        moviesLiveData.postValue(movieListsDummy)

        `when`(movieCatalogueRepository.getMovies()).thenReturn(moviesLiveData)

        viewModel.getMovies()?.observeForever(observer)
        verify(observer).onChanged(movieListsDummy)
    }
}