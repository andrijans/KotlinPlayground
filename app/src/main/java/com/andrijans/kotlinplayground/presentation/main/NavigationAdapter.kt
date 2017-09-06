package com.andrijans.kotlinplayground.presentation.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.bindView
import com.andrijans.kotlinplayground.R

/**
 * Created by andrijanstankovic on 31/08/2017.
 */
class NavigationAdapter(val presenter: MainContract.Presenter, val titles: Array<String>) : RecyclerView.Adapter<NavigationAdapter.ItemViewHolder>() {
    private lateinit var context: Context
    private var selectedPosition: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        this.context = parent!!.context
        val v = LayoutInflater.from(context).inflate(R.layout.navigation_item, parent, false)
        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        holder?.mTitle!!.text = titles[position]
        holder.currentPosition = position
        if (position == selectedPosition) holder.mTitle.setTextColor(context.resources.getColor(R.color.colorPrimary))
        else holder.mTitle.setTextColor(context.resources.getColor(R.color.textPrimaryDark))
    }

    fun setSelectedPosition(selectedPosition: Int) {
        val previousSelected = this.selectedPosition
        this.selectedPosition = selectedPosition
        notifyItemChanged(previousSelected)
        notifyItemChanged(selectedPosition)
    }

    override fun getItemCount(): Int {
        return titles.size
    }


    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val mTitle: TextView by bindView(R.id.tv_title)
        val mRoot: LinearLayout by bindView(R.id.ll_root)

        var currentPosition: Int = 0

        init {
            mRoot.setOnClickListener({ view -> presenter.navigationItemClicked(currentPosition) })
        }

    }
}