package com.andrijans.kotlinplayground.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

/**
 * Created by andrijanstankovic on 31/08/2017.
 */
abstract class BaseActivity : AppCompatActivity() {
    @Inject
    protected lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectView()
    }

    protected abstract fun injectView()
}