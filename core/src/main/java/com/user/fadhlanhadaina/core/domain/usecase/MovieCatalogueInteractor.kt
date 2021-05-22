package com.user.fadhlanhadaina.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.MovieFavorite
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.domain.model.TVSeriesFavorite
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository

class MovieCatalogueInteractor constructor(private val movieCatalogueRepository: IMovieCatalogueRepository): MovieCatalogueUseCase {
    override fun getMovies(): LiveData<ArrayList<Movie>> = movieCatalogueRepository.getMovies()
    override fun getMovieDetail(id: Int): LiveData<Movie> = movieCatalogueRepository.getMovieDetail(id)

    override fun getTVSeries(): LiveData<ArrayList<TVSeries>> = movieCatalogueRepository.getTVSeries()
    override fun getTVSeriesDetail(id: Int): LiveData<TVSeries> = movieCatalogueRepository.getTVSeriesDetail(id)

    override fun getFavoriteMovies(): LiveData<PagedList<MovieFavorite>> = getFavoriteMovies()
    override fun isFavoriteMovieExist(id: Int): Boolean = movieCatalogueRepository.isFavoriteMovieExist(id)
    override suspend fun setFavoriteMovie(favoriteMovie: MovieFavorite) = movieCatalogueRepository.setFavoriteMovie(favoriteMovie)
    override suspend fun deleteFavoriteMovie(favoriteMovie: MovieFavorite) = movieCatalogueRepository.deleteFavoriteMovie(favoriteMovie)

    override fun getFavoriteTVSeries(): LiveData<PagedList<TVSeriesFavorite>> = movieCatalogueRepository.getFavoriteTVSeries()
    override fun isFavoriteTVSeriesExist(id: Int): Boolean = movieCatalogueRepository.isFavoriteTVSeriesExist(id)
    override suspend fun setFavoriteTVSeries(favoriteTVSeriesFavorite: TVSeriesFavorite) = movieCatalogueRepository.setFavoriteTVSeries(favoriteTVSeriesFavorite)
    override suspend fun deleteFavoriteTVSeries(favoriteTVSeriesFavorite: TVSeriesFavorite) = movieCatalogueRepository.deleteFavoriteTVSeries(favoriteTVSeriesFavorite)
}