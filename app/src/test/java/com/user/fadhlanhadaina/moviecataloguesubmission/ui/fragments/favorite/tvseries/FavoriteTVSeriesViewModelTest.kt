package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.favorite.tvseries

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.TVSeriesFavorite
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
class FavoriteTVSeriesViewModelTest {
    private lateinit var viewModel: FavoriteTVSeriesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var movieCatalogueRepository: MovieCatalogueRepository = mock(MovieCatalogueRepository::class.java)

    @Mock
    private lateinit var observer: Observer<PagedList<TVSeriesFavorite>>

    @Mock
    private lateinit var pagedList: PagedList<TVSeriesFavorite>

    @Before
    fun before() {
        viewModel = FavoriteTVSeriesViewModel(movieCatalogueRepository)
    }

    @Test
    fun getAllFavoriteTVSeries() {
        val pagedFavoriteTVSeries = pagedList
        val favoriteTVSeriesLiveData = MutableLiveData<PagedList<TVSeriesFavorite>>()
        favoriteTVSeriesLiveData.value = pagedFavoriteTVSeries

        Mockito.`when`(movieCatalogueRepository.getFavoriteTVSeries()).thenReturn(favoriteTVSeriesLiveData)
        val favoriteTVSeries = viewModel.getAllFavoriteTVSeries().value
        verify(movieCatalogueRepository).getFavoriteTVSeries()
        assertNotNull(favoriteTVSeries)

        viewModel.getAllFavoriteTVSeries().observeForever(observer)
        verify(observer).onChanged(pagedFavoriteTVSeries)
    }
}