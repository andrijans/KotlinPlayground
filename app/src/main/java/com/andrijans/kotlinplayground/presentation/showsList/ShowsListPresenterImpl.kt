package com.andrijans.kotlinplayground.presentation.showsList

import com.andrijans.kotlinplayground.framework.api.entity.MediaItemDetails
import com.andrijans.kotlinplayground.framework.api.interactor.Listener
import com.andrijans.kotlinplayground.framework.contract.ILogger
import com.andrijans.kotlinplayground.presentation.common.contract.IMediaClickListener
import com.andrijans.kotlinplayground.presentation.common.views.contract.MediaContract

/**
 * Created by andrijanstankovic on 01/09/2017.
 */
class ShowsListPresenterImpl(val logger: ILogger, val interactor: MediaContract.ShowsInteractor) : MediaContract.ShowsPresenter {
    private lateinit var view: MediaContract.View
    private lateinit var mediaClickListener: IMediaClickListener
    private var data: ArrayList<MediaItemDetails> = ArrayList()
    private var currentPage: Int = 1

    override fun onCreate() {
        interactor.getPopularShows(currentPage, object : Listener<ArrayList<MediaItemDetails>>() {
            override fun onNext(value: ArrayList<MediaItemDetails>) {
                addMediaType(value)
                data = value
                view.setData(data)

            }
        })
    }

    override fun onResume() {
        // empty
    }

    override fun onPause() {
        interactor.unsubscribe()
    }

    override fun onDestroy() {
        // empty
    }

    override fun bindView(view: MediaContract.View) {
        this.view = view
    }

    override fun addMediaClickListener(mediaClickListener: IMediaClickListener) {
        this.mediaClickListener = mediaClickListener
    }

    override fun mediaItemClicked(details: MediaItemDetails) {
        mediaClickListener.mediaItemClicked(details)
    }

    override fun loadMore(currentPage: Int) {
        this.currentPage = currentPage
        interactor.getPopularShows(this.currentPage, object : Listener<ArrayList<MediaItemDetails>>() {
            override fun onNext(value: ArrayList<MediaItemDetails>) {
                addMediaType(value)
                data.addAll(value)
                view.appendData(value)
            }
        })
    }

    private fun addMediaType(data: ArrayList<MediaItemDetails>): ArrayList<MediaItemDetails> {
        for (details in data) {
            details.type = MediaItemDetails.Type.Series
        }
        return data
    }

}