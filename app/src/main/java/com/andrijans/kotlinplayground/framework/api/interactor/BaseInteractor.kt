package com.andrijans.kotlinplayground.framework.api.interactor

import com.andrijans.kotlinplayground.framework.api.IApiService
import com.andrijans.kotlinplayground.framework.api.entity.common.ListResult
import com.andrijans.kotlinplayground.framework.contract.IBaseInteractor
import com.andrijans.kotlinplayground.framework.contract.ILogger
import io.reactivex.Observable

/**
 * Created by andrijanstankovic on 13/03/2017.
 */
open class BaseInteractor(val apiService: IApiService, val logger: ILogger, val subscriptionBag: SubscriptionBag) : IBaseInteractor {

    protected fun <T> addMapAndError(observable: Observable<out ListResult<T>>): Observable<T> {
        return observable
                .doOnError { error -> logger.e(error) }
                .map { listResult: ListResult<T> -> listResult.getResults() }
    }

    protected fun <T> addError(observable: Observable<T>): Observable<T> {
        return observable
                .doOnError { error -> logger.e(error) }
    }

    protected fun <T> applyErrorAndSubscribe(observable: Observable<T>, listener: Listener<T>) {
        subscriptionBag.add(addError(observable), listener)
    }

    protected fun <T> applyMapErrorAndSubscribe(observable: Observable<out ListResult<T>>, listener: Listener<T>) {
        subscriptionBag.add(addMapAndError(observable), listener)
    }

    override fun unsubscribe() {
        subscriptionBag.unsubscribe()
    }
}