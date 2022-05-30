package com.mydemo.movieBox

import android.app.Application
import com.mydemo.movieBox.di.AppModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by khangpv
 * FinOs
 */
class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApplication)
            modules(AppModule.appModulesDI)
        }
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }
}