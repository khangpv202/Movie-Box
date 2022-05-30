package com.mydemo.movieBox.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.mydemo.movieBox.data.MovieDataSourceFactory
import com.mydemo.movieBox.data.MoviePagingSource
import com.mydemo.movieBox.data.MovieRepository
import com.mydemo.movieBox.data.dto.MovieListResponseDTO
import com.mydemo.base.BaseViewModel

/**
 * Created by khangpv.
 * FinOs
 */
class MostPopularViewModel(application: Application, movieRepository: MovieRepository) :
    BaseViewModel(application) {

    val mostPopularMovieLiveDataResponse: LiveData<PagedList<MovieListResponseDTO.Result>>
    val movieStateLiveData: LiveData<String>
    private val moviePagingSourceFactory = MovieDataSourceFactory(movieRepository, this)

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(40)
            .setEnablePlaceholders(false)
            .build()

        mostPopularMovieLiveDataResponse =
            LivePagedListBuilder<Int, MovieListResponseDTO.Result>(
                moviePagingSourceFactory,
                config
            ).build()
        movieStateLiveData = Transformations.switchMap(
            moviePagingSourceFactory.pagingSourceLiveData,
            MoviePagingSource::movieState
        )
    }

    fun retry() {
        moviePagingSourceFactory.pagingSourceLiveData.value?.retry()
    }
}