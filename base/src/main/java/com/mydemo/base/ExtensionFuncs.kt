package com.mydemo.base

import android.net.Uri
import io.reactivex.disposables.Disposable

/**
 * Created by khangpv
 * FinOs
 */

fun Disposable.attachToDisposable(baseViewModel: BaseViewModel) {
    baseViewModel.addDisposable(this)
}

fun String.convertToUri(): Uri {
    return Uri.parse("https://image.tmdb.org/t/p/original/${this}")
}

fun Int.convertDuration(): String {
    val hour = this / 60
    val min = this % 60
    return if (hour >= 1) {
        StringBuilder().append(hour).append("h ").append(min).append("m").toString()
    } else {
        StringBuilder().append(this).append("m").toString()
    }
}