package com.user.fadhlanhadaina.core.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TVSeriesFavorite (
    @PrimaryKey
    var id: Int,

    @ColumnInfo(name = "poster_path")
    var posterUrl: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "genres")
    var stringGenres: String
)
