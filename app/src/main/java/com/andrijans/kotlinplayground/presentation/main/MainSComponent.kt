package com.andrijans.kotlinplayground.presentation.main

import com.andrijans.kotlinplayground.presentation.common.di.ViewScope
import dagger.Subcomponent

/**
 * Created by andrijanstankovic on 31/08/2017.
 */
@ViewScope
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainSComponent {
    fun inject(activity: MainActivity): MainActivity
}