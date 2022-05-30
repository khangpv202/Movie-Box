package com.mydemo.movieBox.data.network

import com.mydemo.movieBox.BuildConfig
import com.mydemo.movieBox.data.dto.MovieDetailResponseDTO
import com.mydemo.movieBox.data.dto.MovieListResponseDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by khangpv
 * FinOs
 */
interface MovieService {
    @GET("now_playing?language=en-US&page=undefined&api_key=${BuildConfig.API_KEY}")
    fun getListPlayingMovies(): Single<MovieListResponseDTO>

    @GET("popular?api_key=${BuildConfig.API_KEY}&language=en-US&")
    fun getListPopularMoviesByPage(@Query("page") page: Int): Single<MovieListResponseDTO>

    @GET("{movieId}?api_key=${BuildConfig.API_KEY}&language=en-US")
    fun getMovieDetail(@Path("movieId") movieId: Int): Single<MovieDetailResponseDTO>
}