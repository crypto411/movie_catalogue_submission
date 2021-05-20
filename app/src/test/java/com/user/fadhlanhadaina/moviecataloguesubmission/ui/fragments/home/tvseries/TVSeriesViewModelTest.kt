package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.tvseries

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.ResourceData

import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.TVSeries
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVSeriesViewModelTest {
    private lateinit var tvSeriesViewModel: TVSeriesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<ArrayList<TVSeries>>

    @Before
    fun before() {
        tvSeriesViewModel = TVSeriesViewModel(movieCatalogueRepository)
    }

    @Test
    fun getTVSeries() {
        val tvSeriesListDummy = ResourceData.tvSerieListTest
        val tvSeriesLiveData = MutableLiveData<ArrayList<TVSeries>>()

        tvSeriesLiveData.postValue(tvSeriesListDummy)

        `when`(movieCatalogueRepository.getTVSeries()).thenReturn(tvSeriesLiveData)

        tvSeriesViewModel.getTVSeries()?.observeForever(observer)
        verify(observer).onChanged(tvSeriesListDummy)
    }
}