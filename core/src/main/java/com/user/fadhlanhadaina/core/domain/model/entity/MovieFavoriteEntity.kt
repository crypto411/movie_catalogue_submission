package com.user.fadhlanhadaina.core.domain.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieFavoriteEntity (
    @PrimaryKey
    var id: Int,

    @ColumnInfo(name = "poster_path")
    var posterUrl: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "genres")
    var genres: String
)
