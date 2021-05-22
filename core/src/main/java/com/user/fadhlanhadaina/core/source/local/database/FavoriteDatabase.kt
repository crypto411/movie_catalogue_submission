package com.user.fadhlanhadaina.core.source.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.user.fadhlanhadaina.core.model.MovieFavorite
import com.user.fadhlanhadaina.core.model.TVSeriesFavorite

@Database(entities = [MovieFavorite::class, TVSeriesFavorite::class], version = 1, exportSchema = false)
abstract class FavoriteDatabase: RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        private var INSTANCE: FavoriteDatabase? = null

        fun newInstance(context: Context): FavoriteDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    FavoriteDatabase::class.java,
                    "favorite.db"
                )
                .allowMainThreadQueries()
                .build().apply {
                    INSTANCE = this
                }
            }
    }
}