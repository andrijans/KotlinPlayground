package com.andrijans.kotlinplayground.framework.api

import com.andrijans.kotlinplayground.presentation.common.constant.Constants
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by andrijanstankovic on 13/03/2017.
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideHttpClient(): okhttp3.OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val authenticationInterceptor = AuthenticationInterceptor()

        val httpClient = okhttp3.OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(authenticationInterceptor)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .build()

        return httpClient
    }

    @Provides
    @Singleton
    fun provideRestAdapter(httpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.API_URL)
                .client(httpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideApiService(restAdapter: Retrofit): IApiService = restAdapter.create(IApiService::class.java)

}