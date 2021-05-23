package com.user.fadhlanhadaina.core.di

import android.content.Context
import androidx.room.Room
import com.user.fadhlanhadaina.core.data.source.local.database.FavoriteDao
import com.user.fadhlanhadaina.core.data.source.local.database.FavoriteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): FavoriteDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            FavoriteDatabase::class.java,
            "favorite.db"
        )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideDao(database: FavoriteDatabase): FavoriteDao = database.favoriteDao()
}