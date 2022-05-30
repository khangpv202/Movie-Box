package com.mydemo.movieBox.base

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

/**
 * Created by khangpv
 * FinOs
 */
class TestRunner: AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, BaseTestApplication::class.java.name, context)
    }
}