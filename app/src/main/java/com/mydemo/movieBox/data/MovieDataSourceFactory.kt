package com.mydemo.movieBox.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.mydemo.movieBox.data.dto.MovieListResponseDTO
import com.mydemo.base.BaseViewModel

/**
 * Created by khangpv.
 * FinOs
 */
class MovieDataSourceFactory(
    private val movieRepository: MovieRepository,
    private val baseViewModel: BaseViewModel
) : DataSource.Factory<Int, MovieListResponseDTO.Result>() {
    val pagingSourceLiveData = MutableLiveData<MoviePagingSource>()

    override fun create(): DataSource<Int, MovieListResponseDTO.Result> {
        val moviePagingSource = MoviePagingSource(movieRepository, baseViewModel)
        pagingSourceLiveData.postValue(moviePagingSource)
        return moviePagingSource
    }
}