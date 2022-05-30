package com.mydemo.base

import androidx.appcompat.app.AppCompatActivity

/**
 * Created by khangpv
 * FinOs
 */
abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {
    abstract fun getViewModel(): T
}