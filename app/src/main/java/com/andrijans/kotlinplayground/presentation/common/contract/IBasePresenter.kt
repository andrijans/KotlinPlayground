package com.andrijans.kotlinplayground.presentation.common.contract

/**
 * Created by andrijanstankovic on 14/03/2017.
 */
interface IBasePresenter {
    fun onCreate()
    fun onResume()
    fun onPause()
    fun onDestroy()
}