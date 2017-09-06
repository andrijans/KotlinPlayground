package com.andrijans.kotlinplayground.presentation.common.views.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by andrijanstankovic on 14/03/2017.
 */
abstract class PagingRecyclerOnScrollListener(val mLinearLayoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {
    private var previousTotal = 0
    private var loading = true
    private val visibleThreshold = 15
    var firstVisibleItem = -1
    var visibleItemCount = -1
    var totalItemCount = -1
    private var currentPage = 1

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (recyclerView != null) {
            visibleItemCount=recyclerView.childCount
        }
        totalItemCount=mLinearLayoutManager.itemCount
        firstVisibleItem=mLinearLayoutManager.findFirstVisibleItemPosition()

        if (loading){
            if (totalItemCount>previousTotal){
                loading=false
                previousTotal=totalItemCount
            }
        }
        if (!loading && (totalItemCount-visibleItemCount)<=(firstVisibleItem+visibleThreshold)){
            currentPage++
            onLoadMore(currentPage)
            loading=true
        }
    }

    abstract fun onLoadMore(currentPage :Int)
}