package com.user.fadhlanhadaina.favorite_feature.ui.di

import android.content.Context
import com.user.fadhlanhadaina.favorite_feature.ui.fragment.movie.FavoriteMovieFragment
import com.user.fadhlanhadaina.favorite_feature.ui.fragment.tvseries.FavoriteTVSeriesFragment
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