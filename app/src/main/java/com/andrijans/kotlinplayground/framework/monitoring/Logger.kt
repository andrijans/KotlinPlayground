package com.andrijans.kotlinplayground.framework.monitoring

import com.andrijans.kotlinplayground.framework.contract.ILogger
import timber.log.Timber

/**
 * Created by andrijanstankovic on 14/03/2017.
 */
class Logger : ILogger {
    override fun d(message: String) {
        Timber.d(message)
    }

    override fun d(t: Throwable) {
        Timber.d(t)
    }

    override fun e(message: String) {
       Timber.d(message)
    }

    override fun e(t: Throwable) {
        Timber.d(t)
    }
}