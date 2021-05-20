package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.ResourceData
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.TVSeries
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTVSeriesViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository
    private lateinit var detailTVSeriesViewModel: DetailTVSeriesViewModel
    private var tvSeriesTest: TVSeries? = null
    private var tvSeries: TVSeries? = null
    private var id: Int = 0

    @Before
    fun before() {
        detailTVSeriesViewModel = DetailTVSeriesViewModel(movieCatalogueRepository)
        id = 88396
        tvSeriesTest = ResourceData.tvSeriesTest
    }

    @Test
    fun getTVSeries() {
        val tvSeriesLiveData: MutableLiveData<TVSeries> = MutableLiveData()

        tvSeriesLiveData.postValue(tvSeriesTest)

        `when`(movieCatalogueRepository.getTVSeriesDetail(id)).thenReturn(tvSeriesLiveData)
        tvSeries = detailTVSeriesViewModel.getTVSeries(id)?.value
        tvSeries?.id?.let { verify(movieCatalogueRepository).getTVSeriesDetail(it) }

        assertNotNull(tvSeries)
        assertEquals(tvSeriesTest?.id, tvSeries?.id)
        assertEquals(tvSeriesTest?.posterUrl, tvSeries?.posterUrl)
        assertEquals(tvSeriesTest?.title, tvSeries?.title)
        assertEquals(tvSeriesTest?.date, tvSeries?.date)
        assertEquals(tvSeriesTest?.genres, tvSeries?.genres)
        assertEquals(tvSeriesTest?.duration, tvSeries?.duration)
        assertEquals(tvSeriesTest?.overview, tvSeries?.overview)
    }

    @Test
    fun setTVSeriesFavorite() = runBlocking {
        val tvSeriesFavoriteTest = ResourceData.tvSeriesFavoriteTest
        detailTVSeriesViewModel.insertFavoriteTVSeries(tvSeriesFavoriteTest)
        verify(movieCatalogueRepository).setFavoriteTVSeries(tvSeriesFavoriteTest)
    }

    @Test
    fun deleteTVSeriesFavorite() = runBlocking {
        val tvSeriesFavoriteTest = ResourceData.tvSeriesFavoriteTest
        detailTVSeriesViewModel.deleteFavoriteTVSeries(tvSeriesFavoriteTest)
        verify(movieCatalogueRepository).deleteFavoriteTVSeries(tvSeriesFavoriteTest)
    }

    @Test
    fun isTVSeriesFavorited() {
        val tvSeriesFavoriteTest = ResourceData.tvSeriesFavoriteTest
        detailTVSeriesViewModel.isFavoriteTVSeries(tvSeriesFavoriteTest.id)
        verify(movieCatalogueRepository).isFavoriteTVSeriesExist(tvSeriesFavoriteTest.id)
    }
}
