package com.mydemo.movieBox.data.network

import androidx.annotation.StringDef

/**
 * Created by khangpv.
 * FinOs
 */

@StringDef(MovieState.DONE, MovieState.LOADING, MovieState.ERROR)
annotation class MovieState {
    companion object {
        const val DONE = "DONE"
        const val LOADING = "LOADING"
        const val ERROR = "ERROR"

    }
}