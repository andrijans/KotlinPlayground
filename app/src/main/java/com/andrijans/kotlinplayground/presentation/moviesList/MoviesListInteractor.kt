package com.andrijans.kotlinplayground.presentation.moviesList

import com.andrijans.kotlinplayground.framework.api.IApiService
import com.andrijans.kotlinplayground.framework.api.entity.MediaItemDetails
import com.andrijans.kotlinplayground.framework.api.interactor.BaseInteractor
import com.andrijans.kotlinplayground.framework.api.interactor.Listener
import com.andrijans.kotlinplayground.framework.api.interactor.SubscriptionBag
import com.andrijans.kotlinplayground.framework.contract.ILogger
import com.andrijans.kotlinplayground.presentation.common.views.contract.MediaContract
import javax.inject.Inject

/**
 * Created by andrijanstankovic on 01/09/2017.
 */
class MoviesListInteractor @Inject
constructor(apiService: IApiService, logger: ILogger, subscriptionBag: SubscriptionBag) : BaseInteractor(apiService, logger, subscriptionBag), MediaContract.MoviesInteractor {


    override fun getNowPlayingMovies(page: Int, listener: Listener<ArrayList<MediaItemDetails>>) {
       applyMapErrorAndSubscribe(apiService.getNowPlaying(page),listener)
    }


}