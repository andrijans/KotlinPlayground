package com.andrijans.kotlinplayground.presentation.common.contract

import com.andrijans.kotlinplayground.framework.api.entity.MediaItemDetails

/**
 * Created by andrijanstankovic on 14/03/2017.
 */
interface IMediaClickListener {
    fun mediaItemClicked(data: MediaItemDetails)
}