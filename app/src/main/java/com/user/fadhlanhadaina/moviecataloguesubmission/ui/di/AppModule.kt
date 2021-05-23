package com.user.fadhlanhadaina.moviecataloguesubmission.ui.di

import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueInteractor
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {
    @Binds
    abstract fun provideMovieCatalogueInteractor(movieCatalogueInteractor: MovieCatalogueInteractor): MovieCatalogueUseCase
}