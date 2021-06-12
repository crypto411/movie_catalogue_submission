package com.user.fadhlanhadaina.core.di

import android.content.Context
import androidx.room.Room
import com.user.fadhlanhadaina.core.data.source.local.database.FavoriteDao
import com.user.fadhlanhadaina.core.data.source.local.database.FavoriteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import net.sqlcipher.database.SQLiteDatabase.getBytes
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
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
        .openHelperFactory(SupportFactory(getBytes("onge".toCharArray())))
        .build()

    @Provides
    fun provideDao(database: FavoriteDatabase): FavoriteDao = database.favoriteDao()
}