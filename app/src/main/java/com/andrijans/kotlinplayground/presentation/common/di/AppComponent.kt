package com.andrijans.kotlinplayground.presentation.common.di

import com.andrijans.kotlinplayground.framework.api.ApiModule
import com.andrijans.kotlinplayground.framework.api.AuthenticationInterceptor
import com.andrijans.kotlinplayground.presentation.main.MainModule
import com.andrijans.kotlinplayground.presentation.main.MainSComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by andrijanstankovic on 13/03/2017.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        ApiModule::class))
interface AppComponent {

    fun plus(module: MainModule): MainSComponent

    fun inject(authenticationInterceptor: AuthenticationInterceptor): AuthenticationInterceptor
}