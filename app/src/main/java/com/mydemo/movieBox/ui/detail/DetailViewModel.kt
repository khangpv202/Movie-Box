package com.mydemo.movieBox.ui.detail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.mydemo.movieBox.data.MovieRepository
import com.mydemo.movieBox.data.dto.MovieDetailResponseDTO
import com.mydemo.base.BaseViewModel
import com.mydemo.base.attachToDisposable
import com.mydemo.base.convertDuration

/**
 * Created by khangpv.
 * FinOs
 */
class DetailViewModel(application: Application, private val movieRepository: MovieRepository) :
    BaseViewModel(application) {
    val movieDetailLiveData = MutableLiveData<MovieDetailResponseDTO>()
    fun getMovieDetail(movieId: Int) {
        movieRepository.getMovieDetail(movieId)
            .compose(applySingleSchedulers())
            .subscribe({
                movieDetailLiveData.value = it
            }, { handleException(it) }).attachToDisposable(this)
    }

    fun combineIssueDateAndDuration(it: MovieDetailResponseDTO?): String {
        return (it?.releaseDate ?: "") + " ${it?.runtime?.convertDuration()}"
    }
}