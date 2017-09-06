package com.andrijans.kotlinplayground.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import butterknife.bindView
import com.andrijans.kotlinplayground.R
import com.andrijans.kotlinplayground.framework.api.entity.MediaItemDetails
import com.andrijans.kotlinplayground.presentation.App
import com.andrijans.kotlinplayground.presentation.BaseActivity
import com.andrijans.kotlinplayground.presentation.common.views.MediaListView
import com.andrijans.kotlinplayground.presentation.common.views.NonSwipeableViewPager
import com.andrijans.kotlinplayground.presentation.common.views.contract.MediaContract
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {
    companion object {
        fun getCallingIntent(context: Context): Intent = Intent(context, MainActivity.javaClass)
    }

    val mToolbar: Toolbar by bindView(R.id.toolbar)
    val mActivityMain: RelativeLayout by bindView(R.id.activity_main)
    val mVpMain: NonSwipeableViewPager by bindView(R.id.vp_main)
    val mIvProfileImage: ImageView by bindView(R.id.ivProfileImage)
    val mTvName: TextView by bindView(R.id.tvName)
    val mView: View by bindView(R.id.view)
    val mRvMenu: RecyclerView by bindView(R.id.rv_menu)
    val mLlNavigation: LinearLayout by bindView(R.id.ll_navigation)
    val mDrawerLayout: DrawerLayout by bindView(R.id.drawer_layout)

    private lateinit var mDrawerToogle: ActionBarDrawerToggle
    private lateinit var navigationAdapter: NavigationAdapter
    private lateinit var moviesListView: MediaListView
    private lateinit var showsListView: MediaListView

    @Inject
    lateinit var presenter: MainContract.Presenter
    @Inject
    lateinit var moviesListpresenter: MediaContract.MoviesPresenter
    @Inject
    lateinit var showsListPresenter: MediaContract.ShowsPresenter


    override fun injectView() {
        App.appComponent.plus(MainModule(this)).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        initDrawer()

        moviesListView = MediaListView(this)
        moviesListView.bindPresenter(moviesListpresenter)

        showsListView = MediaListView(this)
        showsListView.bindPresenter(showsListPresenter)

        moviesListpresenter.bindView(moviesListView)
        showsListPresenter.bindView(showsListView)

        presenter.bindChildPresenters(moviesListpresenter, showsListPresenter)

        mVpMain.adapter = MainPagerAdapter(arrayOf(moviesListView, showsListView))

        presenter.onCreate()
        moviesListpresenter.onCreate()
        showsListPresenter.onCreate()
    }

    override fun onPause() {
        presenter.onPause()
        moviesListpresenter.onPause()
        showsListPresenter.onPause()
        super.onPause()
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
            closeDrawer()
        else
            super.onBackPressed()
    }


    override fun navigateToMovies() {
        mVpMain.currentItem = 0
        closeDrawer()
    }

    override fun navigateToShows() {
        mVpMain.currentItem = 1
        closeDrawer()
    }

    override fun setSelectedNavigationPosition(position: Int) {
        navigationAdapter.setSelectedPosition(position)
    }

    override fun navigateToDetailsScreen(details: MediaItemDetails, shouldfinish: Boolean) {
        navigator.navigateToDetailsScreen(this, details, shouldfinish)
    }

    private fun initToolbar() {
        setSupportActionBar(mToolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mDrawerToogle = setupDrawerToogle()
        mDrawerToogle.drawerArrowDrawable.color = ContextCompat.getColor(this, R.color.textPrimary)
        mDrawerLayout.addDrawerListener(mDrawerToogle)
        mDrawerToogle.syncState()
    }

    private fun initDrawer() {
        mRvMenu.layoutManager = LinearLayoutManager(this)
        navigationAdapter = NavigationAdapter(presenter, resources.getStringArray(R.array.navigation))
        mRvMenu.adapter = navigationAdapter
    }

    private fun closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START)
    }

    private fun setupDrawerToogle(): ActionBarDrawerToggle = ActionBarDrawerToggle(this, mDrawerLayout,mToolbar, R.string.open, R.string.close)
}
