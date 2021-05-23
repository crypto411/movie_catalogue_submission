package com.user.fadhlanhadaina.favorite_feature.di

import android.content.Context
import com.user.fadhlanhadaina.favorite_feature.fragment.movie.FavoriteMovieFragment
import com.user.fadhlanhadaina.favorite_feature.fragment.tvseries.FavoriteTVSeriesFragment
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.di.AppDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [AppDependencies::class])
interface AppComponent {

    fun inject(fragment: FavoriteMovieFragment)
    fun inject(fragment: FavoriteTVSeriesFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(appDependencies: AppDependencies): Builder
        fun build(): AppComponent
    }
}