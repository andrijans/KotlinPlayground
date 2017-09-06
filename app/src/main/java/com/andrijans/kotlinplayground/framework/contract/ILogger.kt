package com.andrijans.kotlinplayground.framework.contract

/**
 * Created by andrijanstankovic on 14/03/2017.
 */
interface ILogger {
    fun d(message : String)
    fun d(t : Throwable)
    fun e(message: String)
    fun e(t: Throwable)
}