package com.user.fadhlanhadaina.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.core.domain.model.entity.TVSeriesFavoriteEntity
import com.user.fadhlanhadaina.core.domain.repository.IMovieCatalogueRepository
import javax.inject.Inject

class MovieCatalogueInteractor @Inject constructor(private val movieCatalogueRepository: IMovieCatalogueRepository): MovieCatalogueUseCase {
    override fun getMovies(): LiveData<ArrayList<Movie>> = movieCatalogueRepository.getMovies()
    override fun getMovieDetail(id: Int): LiveData<Movie> = movieCatalogueRepository.getMovieDetail(id)

    override fun getTVSeries(): LiveData<ArrayList<TVSeries>> = movieCatalogueRepository.getTVSeries()
    override fun getTVSeriesDetail(id: Int): LiveData<TVSeries> = movieCatalogueRepository.getTVSeriesDetail(id)

    override fun getFavoriteMovies(): LiveData<PagedList<MovieFavoriteEntity>> = getFavoriteMovies()
    override fun isFavoriteMovieExist(id: Int): Boolean = movieCatalogueRepository.isFavoriteMovieExist(id)
    override suspend fun setFavoriteMovie(favoriteMovieEntity: MovieFavoriteEntity) = movieCatalogueRepository.setFavoriteMovie(favoriteMovieEntity)
    override suspend fun deleteFavoriteMovie(favoriteMovieEntity: MovieFavoriteEntity) = movieCatalogueRepository.deleteFavoriteMovie(favoriteMovieEntity)

    override fun getFavoriteTVSeries(): LiveData<PagedList<TVSeriesFavoriteEntity>> = movieCatalogueRepository.getFavoriteTVSeries()
    override fun isFavoriteTVSeriesExist(id: Int): Boolean = movieCatalogueRepository.isFavoriteTVSeriesExist(id)
    override suspend fun setFavoriteTVSeries(favoriteTVSeriesFavoriteEntity: TVSeriesFavoriteEntity) = movieCatalogueRepository.setFavoriteTVSeries(favoriteTVSeriesFavoriteEntity)
    override suspend fun deleteFavoriteTVSeries(favoriteTVSeriesFavoriteEntity: TVSeriesFavoriteEntity) = movieCatalogueRepository.deleteFavoriteTVSeries(favoriteTVSeriesFavoriteEntity)
}