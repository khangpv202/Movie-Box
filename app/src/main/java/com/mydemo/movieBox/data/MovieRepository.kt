package com.mydemo.movieBox.data

import com.mydemo.movieBox.data.dto.MovieListResponseDTO
import com.mydemo.movieBox.data.network.MovieService
import io.reactivex.Single

/**
 * Created by khangpv
 * FinOs
 */
class MovieRepository(private val movieService: MovieService) {
    fun getListPlayingMovies(): Single<MovieListResponseDTO> {
        return movieService.getListPlayingMovies()
    }

    fun getListPopularMoviesByPage(page: Int) = movieService.getListPopularMoviesByPage(page)

    fun getMovieDetail(movieId: Int) = movieService.getMovieDetail(movieId)
}