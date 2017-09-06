package com.andrijans.kotlinplayground.presentation.common.views

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.RelativeLayout
import butterknife.bindView
import com.andrijans.kotlinplayground.R
import com.andrijans.kotlinplayground.framework.api.entity.MediaItemDetails
import com.andrijans.kotlinplayground.presentation.common.views.adapter.MediaListAdapter
import com.andrijans.kotlinplayground.presentation.common.views.adapter.PagingRecyclerOnScrollListener
import com.andrijans.kotlinplayground.presentation.common.views.contract.MediaContract

/**
 * Created by andrijanstankovic on 31/08/2017.
 */
class MediaListView(context: Context) : RelativeLayout(context), MediaContract.View {
    val mRvShows: RecyclerView by bindView(R.id.rv_shows)

    private lateinit var presenter: MediaContract.Presenter
    private lateinit var adapter: MediaListAdapter

    init {
        initView()
    }

    fun initView() {
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater.inflate(R.layout.view_shows_list, this, true)
    }

    override fun bindPresenter(presenter: MediaContract.Presenter) {
        this.presenter = presenter
    }

    override fun setData(data: ArrayList<MediaItemDetails>) {
        val layoutManager = GridLayoutManager(context, 2)
        mRvShows.layoutManager = layoutManager
        mRvShows.addOnScrollListener(object : PagingRecyclerOnScrollListener(layoutManager) {
            override fun onLoadMore(currentPage: Int) {
                presenter.loadMore(currentPage)
            }
        })
        adapter = MediaListAdapter(presenter, data)
        mRvShows.adapter = adapter

    }

    override fun appendData(data: ArrayList<MediaItemDetails>) {
        adapter.appendData(data)
    }
}