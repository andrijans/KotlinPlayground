package com.andrijans.kotlinplayground.framework.api

import com.andrijans.kotlinplayground.presentation.App
import com.andrijans.kotlinplayground.presentation.common.constant.Constants
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by andrijanstankovic on 13/03/2017.
 */
class AuthenticationInterceptor : Interceptor {
    init {
        App.appComponent.inject(this)
    }

    override fun intercept(chain: Interceptor.Chain?): Response {
        val original = chain!!.request()
        val originalHttpUrl = original!!.url()

        val url = originalHttpUrl.newBuilder().addQueryParameter(Constants.API_KEY_NAME, Constants.API_KEY).build()

        val requestBuilder = original.newBuilder().url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}