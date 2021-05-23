package com.user.fadhlanhadaina.core.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.model.entity.TVSeriesFavoriteEntity

@Database(entities = [MovieFavoriteEntity::class, TVSeriesFavoriteEntity::class], version = 2, exportSchema = false)
abstract class FavoriteDatabase: RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}