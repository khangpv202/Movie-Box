package com.mydemo.movieBox.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.mydemo.movieBox.data.dto.MovieListResponseDTO
import com.mydemo.movieBox.data.network.MovieState
import com.mydemo.base.BaseViewModel
import com.mydemo.base.attachToDisposable

/**
 * Created by khangpv
 * FinOs
 */
class MoviePagingSource(
    private val movieRepository: MovieRepository,
    private val baseViewModel: BaseViewModel
) :
    PageKeyedDataSource<Int, MovieListResponseDTO.Result>() {

    private lateinit var retryAction: () -> Unit
    val movieState = MutableLiveData<String>()

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, MovieListResponseDTO.Result>
    ) {
        if (params.key == -1) return
        movieState.postValue(MovieState.LOADING)
        baseViewModel.apply {
            movieRepository.getListPopularMoviesByPage(params.key)
                .compose(applySingleSchedulers())
                .subscribe({
                    movieState.postValue(MovieState.DONE)
                    val nextPage = if (it.totalPages ?: 0 > params.key) params.key + 1 else -1
                    callback.onResult(it.results ?: listOf(), nextPage)
                }, {
                    movieState.postValue(MovieState.ERROR)
                    handleException(it)
                    setRetry { loadAfter(params, callback) }
                }).attachToDisposable(this)
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, MovieListResponseDTO.Result>
    ) {

    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, MovieListResponseDTO.Result>
    ) {
        movieState.postValue(MovieState.LOADING)
        baseViewModel.apply {
            movieRepository.getListPopularMoviesByPage(1)
                .compose(applySingleSchedulers())
                .subscribe({
                    movieState.postValue(MovieState.DONE)
                    val nextPage = if (it.totalPages ?: 0 > 1) 2 else -1
                    callback.onResult(it.results ?: listOf(), null, nextPage)
                }, {
                    movieState.postValue(MovieState.ERROR)
                    handleException(it)
                    setRetry { loadInitial(params, callback) }
                }).attachToDisposable(this)
        }

    }

    private fun setRetry(function: () -> Unit) {
        this.retryAction = function
    }

    fun retry() {
        retryAction.invoke()
    }
}