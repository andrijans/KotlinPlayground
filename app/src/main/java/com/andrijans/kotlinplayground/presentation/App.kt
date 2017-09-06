package com.andrijans.kotlinplayground.presentation

import android.app.Application
import com.andrijans.kotlinplayground.presentation.common.di.AppComponent
import com.andrijans.kotlinplayground.presentation.common.di.AppModule
import com.andrijans.kotlinplayground.presentation.common.di.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by andrijanstankovic on 13/03/2017.
 */
class App : Application() {
    companion object {
        lateinit var app: App
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        app = this
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

}