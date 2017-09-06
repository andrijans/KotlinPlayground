package com.andrijans.kotlinplayground.framework.contract

import io.reactivex.Scheduler

/**
 * Created by andrijanstankovic on 14/03/2017.
 */
interface IResultThread {
    fun getScheduler() :Scheduler
}