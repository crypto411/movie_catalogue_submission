package com.user.fadhlanhadaina.favorite_feature.di

import android.content.Context
import androidx.fragment.app.Fragment
import com.user.fadhlanhadaina.core.di.AppDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [AppDependencies::class])
interface AppComponent {

    fun inject(fragment: Fragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(appDependencies: AppDependencies): Builder
        fun build(): AppComponent
    }
}