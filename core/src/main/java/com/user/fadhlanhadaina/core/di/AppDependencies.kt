package com.user.fadhlanhadaina.core.di

import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueInteractor
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase
import dagger.Binds
import dagger.BindsInstance
import dagger.Reusable
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@EntryPoint
@InstallIn(FragmentComponent::class)
interface AppDependencies {
    @InjectUseCase
    fun movieCatalogueInteractor(movieCatalogueInteractor: MovieCatalogueInteractor): MovieCatalogueUseCase
}