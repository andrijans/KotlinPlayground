package com.andrijans.kotlinplayground.presentation.common.views.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import com.andrijans.kotlinplayground.R
import com.andrijans.kotlinplayground.framework.api.entity.MediaItemDetails
import com.andrijans.kotlinplayground.presentation.common.util.Utils
import com.andrijans.kotlinplayground.presentation.common.views.contract.MediaContract
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by andrijanstankovic on 31/08/2017.
 */
class MediaListAdapter(val presenter: MediaContract.Presenter, val data: ArrayList<MediaItemDetails>) : RecyclerView.Adapter<MediaListAdapter.ViewHolder>() {
    private lateinit var context: Context


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.mIvPoster?.setImageURI(Utils.getPosterUri(data.get(position).posterPath!!))
        holder?.mIvPoster?.setOnClickListener({ v -> presenter.mediaItemClicked(data.get(position)) })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        this.context = parent!!.context
        val v = LayoutInflater.from(context).inflate(R.layout.item_media, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun appendData(data: MutableList<MediaItemDetails>) {
        val lastItemPos = data.size
        this.data.addAll(data)
        notifyItemRangeChanged(lastItemPos, data.size)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mIvPoster: SimpleDraweeView by bindView(R.id.iv_poster)

        init {

        }

    }
}