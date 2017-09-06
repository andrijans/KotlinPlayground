package com.andrijans.kotlinplayground.presentation.main

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

/**
 * Created by andrijanstankovic on 31/08/2017.
 */
class MainPagerAdapter(var childViews: Array<View>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        container?.addView(childViews[position])
        return childViews[position]
    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
       return childViews.size
    }
}