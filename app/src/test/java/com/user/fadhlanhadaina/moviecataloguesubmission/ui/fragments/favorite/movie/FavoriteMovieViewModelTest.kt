package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.MovieFavorite
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.MovieCatalogueRepository
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class FavoriteMovieViewModelTest {
    private lateinit var viewModel: FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var movieCatalogueRepository: MovieCatalogueRepository = mock(MovieCatalogueRepository::class.java)

    @Mock
    private lateinit var observer: Observer<PagedList<MovieFavorite>>

    @Mock
    private lateinit var pagedList: PagedList<MovieFavorite>

    @Before
    fun before() {
        viewModel = FavoriteMovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun getAllFavoriteMovie() {
        val pagedFavoriteMovie = pagedList
        val favoriteMovieLiveData = MutableLiveData<PagedList<MovieFavorite>>()
        favoriteMovieLiveData.value = pagedFavoriteMovie

        Mockito.`when`(movieCatalogueRepository.getFavoriteMovies()).thenReturn(favoriteMovieLiveData)
        val favoriteMovies = viewModel.getAllFavoriteMovie().value
        verify(movieCatalogueRepository).getFavoriteMovies()
        assertNotNull(favoriteMovies)

        viewModel.getAllFavoriteMovie().observeForever(observer)
        verify(observer).onChanged(pagedFavoriteMovie)
    }
}