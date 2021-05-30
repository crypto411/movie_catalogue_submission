package com.user.fadhlanhadaina.core.util

import com.user.fadhlanhadaina.core.data.source.local.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.data.source.local.entity.TVSeriesFavoriteEntity
import com.user.fadhlanhadaina.core.data.source.remote.response.DetailMovieResponse
import com.user.fadhlanhadaina.core.data.source.remote.response.DetailTVSeriesResponse
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.TVSeries

object Mapper {
    fun List<DetailMovieResponse>.mapToMovie(): ArrayList<Movie> {
        val arrayList = ArrayList<Movie>()
        this.map { detailMovieResponse ->
            arrayList.add(detailMovieResponse.mapToMovie())
        }
        return arrayList
    }

    fun List<DetailTVSeriesResponse>.mapToTVSeries(): ArrayList<TVSeries> {
        val arrayList = ArrayList<TVSeries>()
        this.map { detailTVSeriesResponse ->
            arrayList.add(detailTVSeriesResponse.mapToTVSeries())
        }
        return arrayList
    }

    fun DetailMovieResponse.mapToMovie(): Movie {
        var genres = ""
        if(!this.genres.isNullOrEmpty())
            this.genres.forEachIndexed { index, genre ->
                genres = when {
                    index == 0 && this.genres.size > 1 ->
                        "${genre.name},"
                    index == 0 ->
                        genre.name
                    index == this.genres.size - 1 ->
                        "$genres ${genre.name}"
                    else ->
                        "$genres ${genre.name},"
                }
            }
        return Movie(
            this.id,
            this.posterPath,
            this.title,
            this.releaseDate,
            genres,
            this.duration,
            this.overview)
    }

    fun DetailTVSeriesResponse.mapToTVSeries(): TVSeries {
        var genres = ""
        if(!this.genres.isNullOrEmpty())
            this.genres.forEachIndexed { index, genre ->
                genres = when {
                    index == 0 && this.genres.size > 1 ->
                        "${genre.name},"
                    index == 0 ->
                        genre.name
                    index == this.genres.size - 1 ->
                        "$genres ${genre.name}"
                    else ->
                        "$genres ${genre.name},"
                }
            }
        return TVSeries(
            this.id,
            this.posterPath,
            this.title,
            this.releaseDate,
            genres,
            when { !this.durationArray.isNullOrEmpty() -> this.durationArray[0] else -> 0 },
            this.overview)
    }
    fun Movie.mapToFavoriteEntity(): MovieFavoriteEntity = MovieFavoriteEntity(this.id, this.posterUrl, this.title, this.releaseDate, this.genres)
    fun TVSeries.mapToFavoriteEntity(): TVSeriesFavoriteEntity = TVSeriesFavoriteEntity(this.id, this.posterUrl, this.title, this.releaseDate, this.genres)

}