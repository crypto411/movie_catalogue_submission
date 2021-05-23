package com.user.fadhlanhadaina.moviecataloguesubmission

import android.app.Application
import com.user.fadhlanhadaina.core.di.InjectUseCase
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueInteractor
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
open class MainApplication: Application() {
    @Inject
    @InjectUseCase
    lateinit var movieCatalogueInteractor: MovieCatalogueInteractor
}