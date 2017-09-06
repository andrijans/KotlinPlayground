package com.andrijans.kotlinplayground.presentation.main

import com.andrijans.kotlinplayground.framework.contract.ILogger
import com.andrijans.kotlinplayground.presentation.common.views.contract.MediaContract
import com.andrijans.kotlinplayground.presentation.moviesList.MoviesListInteractor
import com.andrijans.kotlinplayground.presentation.moviesList.MoviesListPresenterImpl
import com.andrijans.kotlinplayground.presentation.showsList.ShowsListInteractor
import com.andrijans.kotlinplayground.presentation.showsList.ShowsListPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by andrijanstankovic on 31/08/2017.
 */
@Module
class MainModule(val view: MainContract.View) {


    @Provides
    fun provideView(): MainContract.View = view

    @Provides
    fun providePresenter(): MainContract.Presenter = MainPresenterImpl(view)

    @Provides
    fun provideShowsListPresenter(logger: ILogger, interactor: MediaContract.ShowsInteractor): MediaContract.ShowsPresenter = ShowsListPresenterImpl(logger, interactor)

    @Provides
    fun provideMoviesListPresenter(logger: ILogger, interactor: MediaContract.MoviesInteractor): MediaContract.MoviesPresenter = MoviesListPresenterImpl(logger, interactor)

    @Provides
    fun provideShowsListInteractor(interactor: ShowsListInteractor): MediaContract.ShowsInteractor = interactor

    @Provides
    fun provideMoviesListInteractor(interactor: MoviesListInteractor): MediaContract.MoviesInteractor = interactor

}