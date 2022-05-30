package com.mydemo.base

import android.app.Application
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by khangpv
 * FinOs
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    private var compositeDisposable: CompositeDisposable? = null

    fun addDisposable(disposable: Disposable) {
        if (compositeDisposable == null || compositeDisposable?.isDisposed == true) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable?.add(disposable)
    }

    fun <T> applySingleSchedulers(): SingleTransformer<T, T> {
        return SingleTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
    fun handleException(throwable: Throwable) {
        throwable.printStackTrace()
        val handler = Handler(Looper.getMainLooper())
        handler.post {
            if (throwable is SocketTimeoutException || throwable is SocketException || throwable is UnknownHostException) {
                Toast.makeText(getApplication(), "network error", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(getApplication(), "unknown error", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCleared() {
        compositeDisposable?.dispose()
        super.onCleared()
    }
}