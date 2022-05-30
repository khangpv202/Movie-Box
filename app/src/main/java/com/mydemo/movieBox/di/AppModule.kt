package com.mydemo.movieBox.di

import android.content.Context
import com.mydemo.movieBox.R
import com.mydemo.movieBox.data.MovieRepository
import com.mydemo.movieBox.data.network.MovieService
import com.mydemo.movieBox.ui.detail.DetailViewModel
import com.mydemo.movieBox.ui.home.HomeViewModel
import com.mydemo.movieBox.ui.home.MostPopularViewModel
import com.mydemo.movieBox.ui.home.PlayingNowViewModel
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by khangpv
 * FinOs
 */

object AppModule {

    private val dataModule = module {
        single { provideOkHttp3() }
        single { provideMovieService(get(), get()) }
        single { provideMovieRepository(get()) }
    }

    private val viewModelModule = module {
        viewModel { HomeViewModel(get()) }
        viewModel { DetailViewModel(get(), get()) }
        viewModel { PlayingNowViewModel(get(), get()) }
        viewModel { MostPopularViewModel(get(), get()) }
    }

    private fun provideOkHttp3(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor()).build()
    }

    private fun provideMovieService(context: Context, okHttpClient: OkHttpClient): MovieService {
        val retrofit = Retrofit.Builder()
            .baseUrl(context.getString(R.string.base_url))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
        return retrofit.create(MovieService::class.java)
    }

    private fun provideMovieRepository(movieService: MovieService): MovieRepository {
        return MovieRepository(movieService)
    }

    val appModulesDI = mutableListOf(dataModule, viewModelModule)
}