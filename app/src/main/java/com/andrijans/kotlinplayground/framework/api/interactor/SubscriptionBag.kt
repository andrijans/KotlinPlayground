package com.andrijans.kotlinplayground.framework.api.interactor

import com.andrijans.kotlinplayground.framework.contract.IResultThread
import com.andrijans.kotlinplayground.framework.contract.IWorkerThread
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

/**
 * Created by andrijanstankovic on 14/03/2017.
 */
class SubscriptionBag(val workerThread: IWorkerThread, val resultThread :IResultThread) {
    private val disposables= CompositeDisposable()

    fun <T> add(observable: Observable<T>, subscriber: DisposableObserver<T>) {
        this.disposables.add(observable
                .subscribeOn(workerThread.getScheduler())
                .observeOn(resultThread.getScheduler())
                .subscribeWith(subscriber)
        )
    }

    fun unsubscribe(){
        disposables.clear()
    }
}