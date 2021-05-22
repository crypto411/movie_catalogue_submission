package com.user.fadhlanhadaina.core.di

import android.content.Context
import com.user.fadhlanhadaina.core.data.source.MovieCatalogueRepository
import com.user.fadhlanhadaina.core.data.source.local.LocalDataSource
import com.user.fadhlanhadaina.core.data.source.local.database.FavoriteDatabase
import com.user.fadhlanhadaina.core.data.source.remote.ClientApi
import com.user.fadhlanhadaina.core.data.source.remote.RemoteDataSource
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueInteractor
import com.user.fadhlanhadaina.core.domain.usecase.MovieCatalogueUseCase

object Injection {
    fun provideRepository(context: Context): IMovieCatalogueRepository {
        val clientApi = ClientApi.client
        val db = FavoriteDatabase.newInstance(context)
        val remoteDataSource = RemoteDataSource.newInstance(clientApi)
        val localDataSource = LocalDataSource.newInstance(db.favoriteDao())
        return MovieCatalogueRepository.newInstance(remoteDataSource, localDataSource)
    }
    fun provideUseCase(context: Context): MovieCatalogueUseCase {
        return MovieCatalogueInteractor(provideRepository(context))
    }
}