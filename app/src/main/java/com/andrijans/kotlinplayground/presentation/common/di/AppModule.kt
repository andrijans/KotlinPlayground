package com.andrijans.kotlinplayground.presentation.common.di

import android.app.Application
import com.andrijans.kotlinplayground.framework.api.interactor.SubscriptionBag
import com.andrijans.kotlinplayground.framework.contract.ILogger
import com.andrijans.kotlinplayground.framework.contract.IResultThread
import com.andrijans.kotlinplayground.framework.contract.IWorkerThread
import com.andrijans.kotlinplayground.framework.monitoring.Logger
import com.andrijans.kotlinplayground.presentation.Navigator
import com.andrijans.kotlinplayground.presentation.common.executor.IOThread
import com.andrijans.kotlinplayground.presentation.common.executor.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by andrijanstankovic on 13/03/2017.
 */
@Module
class AppModule(val app: Application) {

    @Provides
    @Singleton
    fun getApplication(): Application {
        return app
    }

    @Provides
    @Singleton
    fun provideNavigator(): Navigator = Navigator()

    @Provides
    @Singleton
    fun provideLogger(): ILogger = Logger()

    @Provides
    @Singleton
    fun provideWorkerThread(): IWorkerThread = IOThread()

    @Provides
    @Singleton
    fun provideResultThread(): IResultThread = UIThread()

    @Provides
    fun provideInteractorSubscription(workerThread: IWorkerThread, resultThread: IResultThread): SubscriptionBag = SubscriptionBag(workerThread, resultThread)


}