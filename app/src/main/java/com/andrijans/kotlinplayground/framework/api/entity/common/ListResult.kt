package com.andrijans.kotlinplayground.framework.api.entity.common

/**
 * Created by andrijanstankovic on 13/03/2017.
 */
abstract class ListResult<T> {
    abstract fun getResults(): T
    abstract fun setResults(results : T)
}