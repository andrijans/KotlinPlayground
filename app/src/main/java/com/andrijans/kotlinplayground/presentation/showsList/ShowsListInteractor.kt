package com.andrijans.kotlinplayground.presentation.showsList

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
class ShowsListInteractor @Inject
constructor(apiService: IApiService, logger: ILogger, subscriptionBag: SubscriptionBag) : BaseInteractor(apiService, logger, subscriptionBag), MediaContract.ShowsInteractor {
    override fun getPopularShows(page: Int, listener: Listener<ArrayList<MediaItemDetails>>) {
        applyMapErrorAndSubscribe(apiService.getPopularShows(page), listener)
    }
}