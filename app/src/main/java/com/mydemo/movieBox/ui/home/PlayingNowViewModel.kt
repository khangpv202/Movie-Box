package com.mydemo.movieBox.ui.home

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.mydemo.movieBox.data.MovieRepository
import com.mydemo.movieBox.data.dto.MovieListResponseDTO
import com.mydemo.base.BaseViewModel
import com.mydemo.base.attachToDisposable

/**
 * Created by khangpv.
 * FinOs
 */
class PlayingNowViewModel(application: Application, private val movieRepository: MovieRepository) :
    BaseViewModel(application) {
    val playingNowLiveData = MutableLiveData<MovieListResponseDTO>()
    fun fetchPlayingNowMovies() {
        movieRepository.getListPlayingMovies()
            .compose(applySingleSchedulers())
            .subscribe({
                playingNowLiveData.value = it
            }, {
                handleException(it)
            }).attachToDisposable(this)
    }
}