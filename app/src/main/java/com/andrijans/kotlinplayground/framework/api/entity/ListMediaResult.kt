package com.andrijans.kotlinplayground.framework.api.entity

import com.andrijans.kotlinplayground.framework.api.entity.common.ListResult


/**
 * Created by andrijanstankovic on 13/03/2017.
 */
class ListMediaResult : ListResult<ArrayList<MediaItemDetails>>() {

    private var results: ArrayList<MediaItemDetails> = ArrayList()


    override fun getResults(): ArrayList<MediaItemDetails> {
        return results
    }

    override fun setResults(results: ArrayList<MediaItemDetails>) {
        this.results = results
    }
}
