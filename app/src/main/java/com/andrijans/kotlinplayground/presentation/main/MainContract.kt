package com.andrijans.kotlinplayground.presentation.main

import com.andrijans.kotlinplayground.framework.api.entity.MediaItemDetails
import com.andrijans.kotlinplayground.presentation.common.contract.IBasePresenter
import com.andrijans.kotlinplayground.presentation.common.contract.IBaseView
import com.andrijans.kotlinplayground.presentation.common.views.contract.MediaContract

/**
 * Created by andrijanstankovic on 14/03/2017.
 */
class MainContract {
    interface View : IBaseView {
        fun navigateToMovies()
        fun navigateToShows()
        fun setSelectedNavigationPosition(position: Int)
        fun navigateToDetailsScreen(details: MediaItemDetails, shouldfinish: Boolean)
    }

    interface Presenter : IBasePresenter {
        fun navigationItemClicked(position: Int)
        fun bindChildPresenters(moviesPresenter: MediaContract.MoviesPresenter, showsPresenter: MediaContract.ShowsPresenter)
    }
}