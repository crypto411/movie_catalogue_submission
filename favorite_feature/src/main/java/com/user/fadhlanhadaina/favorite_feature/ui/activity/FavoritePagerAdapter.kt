package com.user.fadhlanhadaina.favorite_feature.ui.activity

import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.user.fadhlanhadaina.favorite_feature.R
import com.user.fadhlanhadaina.favorite_feature.ui.fragment.movie.FavoriteMovieFragment
import com.user.fadhlanhadaina.favorite_feature.ui.fragment.tvseries.FavoriteTVSeriesFragment

class FavoritePagerAdapter(private val activity: AppCompatActivity, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.movies,
            R.string.tv_series
        )
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence =
        activity.resources.getString(TAB_TITLES[position])

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = FavoriteMovieFragment.newInstance()
            1 -> fragment = FavoriteTVSeriesFragment.newInstance()
        }
        return fragment as Fragment
    }
}