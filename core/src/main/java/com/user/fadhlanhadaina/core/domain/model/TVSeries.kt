package com.user.fadhlanhadaina.core.domain.model

data class TVSeries(
    var id: Int,
    var posterUrl: String,
    var title: String,
    var releaseDate: String,
    var genres: String,
    var duration: Int,
    var overview: String
)
