package com.user.fadhlanhadaina.core.domain.usecase

import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.data.source.local.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.data.source.local.entity.TVSeriesFavoriteEntity
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieCatalogueInteractor @Inject constructor(private val movieCatalogueRepository: IMovieCatalogueRepository): MovieCatalogueUseCase {
    override fun getMovies(): Flow<ArrayList<Movie>> = movieCatalogueRepository.getMovies()
    override fun getMovieDetail(id: Int): Flow<Movie> = movieCatalogueRepository.getMovieDetail(id)

    override fun getTVSeries(): Flow<ArrayList<TVSeries>> = movieCatalogueRepository.getTVSeries()
    override fun getTVSeriesDetail(id: Int): Flow<TVSeries> = movieCatalogueRepository.getTVSeriesDetail(id)

    override fun getFavoriteMovies(): Flow<List<MovieFavoriteEntity>> = movieCatalogueRepository.getFavoriteMovies()
    override fun isFavoriteMovieExist(id: Int): Flow<MovieFavoriteEntity?> = movieCatalogueRepository.isFavoriteMovieExist(id)
    override suspend fun setFavoriteMovie(favoriteMovieEntity: MovieFavoriteEntity) = movieCatalogueRepository.setFavoriteMovie(favoriteMovieEntity)
    override suspend fun deleteFavoriteMovie(favoriteMovieEntity: MovieFavoriteEntity) = movieCatalogueRepository.deleteFavoriteMovie(favoriteMovieEntity)

    override fun getFavoriteTVSeries(): Flow<List<TVSeriesFavoriteEntity>> = movieCatalogueRepository.getFavoriteTVSeries()
    override fun isFavoriteTVSeriesExist(id: Int): Flow<TVSeriesFavoriteEntity?> = movieCatalogueRepository.isFavoriteTVSeriesExist(id)
    override suspend fun setFavoriteTVSeries(favoriteTVSeriesFavoriteEntity: TVSeriesFavoriteEntity) = movieCatalogueRepository.setFavoriteTVSeries(favoriteTVSeriesFavoriteEntity)
    override suspend fun deleteFavoriteTVSeries(favoriteTVSeriesFavoriteEntity: TVSeriesFavoriteEntity) = movieCatalogueRepository.deleteFavoriteTVSeries(favoriteTVSeriesFavoriteEntity)
}