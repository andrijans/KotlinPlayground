package com.andrijans.kotlinplayground.framework.api.interactor

import io.reactivex.Observer
import io.reactivex.observers.DisposableObserver

/**
 * Created by andrijanstankovic on 14/03/2017.
 */
open class Listener<T> : DisposableObserver<T>(), Observer<T> {
    override fun onNext(value: T) {
        // empty
    }

    override fun onComplete() {
        // empty
    }

    override fun onError(e: Throwable?) {
        // empty
    }
}