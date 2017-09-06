package com.andrijans.kotlinplayground.presentation.common.executor

import com.andrijans.kotlinplayground.framework.contract.IResultThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by andrijanstankovic on 31/08/2017.
 */
class UIThread : IResultThread {
    override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()
}