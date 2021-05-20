package com.user.fadhlanhadaina.moviecataloguesubmission.data.source

import android.content.Context
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.local.LocalDataSource
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.local.database.FavoriteDatabase
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote.ClientApi
import com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote.RemoteDataSource

class Injection {
    companion object {
        fun provideRepository(context: Context): MovieCatalogueRepository {
            val clientApi = ClientApi.client
            val db = FavoriteDatabase.newInstance(context)
            val remoteDataSource = RemoteDataSource.newInstance(clientApi)
            val localDataSource = LocalDataSource.newInstance(db.favoriteDao())
            return MovieCatalogueRepository.newInstance(remoteDataSource, localDataSource)
        }
    }
}