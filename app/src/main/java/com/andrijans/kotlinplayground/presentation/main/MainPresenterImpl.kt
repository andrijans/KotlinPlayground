package com.andrijans.kotlinplayground.presentation.main

import com.andrijans.kotlinplayground.framework.api.entity.MediaItemDetails
import com.andrijans.kotlinplayground.presentation.common.contract.IMediaClickListener
import com.andrijans.kotlinplayground.presentation.common.views.contract.MediaContract

/**
 * Created by andrijanstankovic on 31/08/2017.
 */
class MainPresenterImpl(val view: MainContract.View) : MainContract.Presenter, IMediaClickListener {

    lateinit var moviesPresenter: MediaContract.MoviesPresenter
    lateinit var showsPresenter: MediaContract.ShowsPresenter
    override fun onCreate() {
        // empty
    }

    override fun onResume() {
        // empty
    }

    override fun onPause() {
        // empty
    }

    override fun onDestroy() {
        // empty
    }

    override fun navigationItemClicked(position: Int) {
        when (position) {
            0 -> {
                view.setSelectedNavigationPosition(position)
                view.navigateToMovies()
            }
            1 -> {
                view.setSelectedNavigationPosition(position)
                view.navigateToShows()
            }
        }
    }

    override fun bindChildPresenters(moviesPresenter: MediaContract.MoviesPresenter, showsPresenter: MediaContract.ShowsPresenter) {
        this.showsPresenter = showsPresenter
        this.moviesPresenter = moviesPresenter
        this.moviesPresenter.addMediaClickListener(this)
        this.showsPresenter.addMediaClickListener(this)
    }

    override fun mediaItemClicked(data: MediaItemDetails) {
        view.navigateToDetailsScreen(data, false)
    }
}