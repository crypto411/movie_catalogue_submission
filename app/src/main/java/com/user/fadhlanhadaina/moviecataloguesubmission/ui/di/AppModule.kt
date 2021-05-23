package com.user.fadhlanhadaina.moviecataloguesubmission.ui.di

import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueInteractor
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideMovieCatalogueInteractor(movieCatalogueInteractor: MovieCatalogueInteractor): MovieCatalogueUseCase
}