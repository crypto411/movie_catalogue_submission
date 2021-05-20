package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.home

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.ViewPagerActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.user.fadhlanhadaina.moviecataloguesubmission.R
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.movie.MovieListAdapter
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.tvseries.TVSeriesListAdapter
import com.user.fadhlanhadaina.moviecataloguesubmission.utils.EspressoIdlingResource.getIdlingResource
import org.hamcrest.Matchers.endsWith
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {

    @Before
    fun before() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(getIdlingResource())
    }

    @After
    fun after() {
        IdlingRegistry.getInstance().unregister(getIdlingResource())
    }

    @Test
    fun tabViewTest() {
        onView(withId(R.id.tlHome)).check(matches(isDisplayed()))
        onView(withId(R.id.vpHome)).check(matches(isDisplayed()))
        onView(withId(R.id.vpHome)).perform(
            ViewPagerActions.scrollRight()
        )
    }

    @Test
    fun displayMovies() {
        onView(withId(R.id.rvMovieData)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovieData)).perform(
            RecyclerViewActions.scrollToPosition<MovieListAdapter.ViewHolder>(7)
        )
    }

    @Test
    fun displayTVSeries() {
        onView(withId(R.id.vpHome)).perform(
            ViewPagerActions.scrollRight()
        )
        onView(withId(R.id.rvTVSeriesData)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTVSeriesData)).perform(
            RecyclerViewActions.scrollToPosition<TVSeriesListAdapter.ViewHolder>(7)
        )
    }

    @Test
    fun displayMoviesDetail() {
        onView(withId(R.id.rvMovieData)).perform(
            RecyclerViewActions.actionOnItemAtPosition<MovieListAdapter.ViewHolder>(1, click())
        )

        onView(withId(R.id.tvTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.ivMovieDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDurationDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverviewDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenreDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.btnFavorite)).check(matches(isDisplayed()))
    }

    @Test
    fun displayTVSeriesDetail() {
        onView(withId(R.id.vpHome)).perform(
            ViewPagerActions.scrollRight()
        )
        onView(withId(R.id.rvTVSeriesData)).perform(
            RecyclerViewActions.actionOnItemAtPosition<TVSeriesListAdapter.ViewHolder>(3, click())
        )

        onView(withId(R.id.tvTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.ivMovieDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDurationDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverviewDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenreDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.btnFavorite)).check(matches(isDisplayed()))
    }

    @Test
    fun displayFavoriteMovie() {
        onView(withId(R.id.menuFavorite)).check(matches(isDisplayed()))
        onView(withId(R.id.menuFavorite)).perform(
            click()
        )
        onView(withText(endsWith("MOVIES"))).check(matches(isDisplayed()))
        onView(withId(R.id.rvFavMovie)).check(matches(isDisplayed()))
    }

    @Test
    fun displayFavoriteTVSeries() {
        onView(withId(R.id.menuFavorite)).check(matches(isDisplayed()))
        onView(withId(R.id.menuFavorite)).perform(
            click()
        )
        onView(withId(R.id.vpFavorite)).perform(
            ViewPagerActions.scrollRight()
        )
        onView(withText(endsWith("TV SERIES"))).check(matches(isDisplayed()))
        onView(withId(R.id.rvFavTVSeries)).check(matches(isDisplayed()))
    }
}