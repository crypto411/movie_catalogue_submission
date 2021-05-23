package com.user.fadhlanhadaina.moviecataloguesubmission.ui.di

import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface AppDependencies {
    fun movieCatalogueUseCase(): MovieCatalogueUseCase
}