package com.andrijans.kotlinplayground.presentation.common.views.contract

import com.andrijans.kotlinplayground.framework.api.entity.MediaItemDetails
import com.andrijans.kotlinplayground.framework.api.interactor.Listener
import com.andrijans.kotlinplayground.framework.contract.IBaseInteractor
import com.andrijans.kotlinplayground.presentation.common.contract.IBasePresenter
import com.andrijans.kotlinplayground.presentation.common.contract.IBaseView
import com.andrijans.kotlinplayground.presentation.common.contract.IMediaClickListener

/**
 * Created by andrijanstankovic on 14/03/2017.
 */
class MediaContract {
    interface View : IBaseView {
        fun bindPresenter(presenter: Presenter)
        fun setData(data: ArrayList<MediaItemDetails>)
        fun appendData(data: ArrayList<MediaItemDetails>)
    }

    interface Presenter : IBasePresenter {
        fun bindView(view: View)
        fun addMediaClickListener(mediaClickListener: IMediaClickListener)
        fun mediaItemClicked(details: MediaItemDetails)
        fun loadMore(currentPage: Int)
    }

    interface MoviesPresenter : Presenter {}

    interface ShowsPresenter : Presenter {}

    interface ShowsInteractor : IBaseInteractor {
        fun getPopularShows(page: Int, listener: Listener<ArrayList<MediaItemDetails>>)
    }

    interface MoviesInteractor :IBaseInteractor{
        fun getNowPlayingMovies(page :Int, listener: Listener<ArrayList<MediaItemDetails>>)
    }
}