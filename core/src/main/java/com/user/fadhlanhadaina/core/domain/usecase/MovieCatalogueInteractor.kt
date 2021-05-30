package com.user.fadhlanhadaina.core.domain.usecase

import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieCatalogueInteractor @Inject constructor(private val movieCatalogueRepository: IMovieCatalogueRepository): MovieCatalogueUseCase {
    override fun getMovies(): Flow<ArrayList<Movie>> = movieCatalogueRepository.getMovies()
    override fun getMovieDetail(id: Int): Flow<Movie> = movieCatalogueRepository.getMovieDetail(id)

    override fun getTVSeries(): Flow<ArrayList<TVSeries>> = movieCatalogueRepository.getTVSeries()
    override fun getTVSeriesDetail(id: Int): Flow<TVSeries> = movieCatalogueRepository.getTVSeriesDetail(id)

    override fun getFavoriteMovies(): Flow<List<Movie>> = movieCatalogueRepository.getFavoriteMovies()
    override fun isFavoriteMovieExist(id: Int): Flow<Movie?> = movieCatalogueRepository.isFavoriteMovieExist(id)
    override suspend fun setFavoriteMovie(favoriteMovie: Movie) = movieCatalogueRepository.setFavoriteMovie(favoriteMovie)
    override suspend fun deleteFavoriteMovie(favoriteMovie: Movie) = movieCatalogueRepository.deleteFavoriteMovie(favoriteMovie)

    override fun getFavoriteTVSeries(): Flow<List<TVSeries>> = movieCatalogueRepository.getFavoriteTVSeries()
    override fun isFavoriteTVSeriesExist(id: Int): Flow<TVSeries?> = movieCatalogueRepository.isFavoriteTVSeriesExist(id)
    override suspend fun setFavoriteTVSeries(favoriteTVSeries: TVSeries) = movieCatalogueRepository.setFavoriteTVSeries(favoriteTVSeries)
    override suspend fun deleteFavoriteTVSeries(favoriteTVSeries: TVSeries) = movieCatalogueRepository.deleteFavoriteTVSeries(favoriteTVSeries)
}