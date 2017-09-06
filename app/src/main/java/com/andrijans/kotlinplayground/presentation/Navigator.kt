package com.andrijans.kotlinplayground.presentation

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.andrijans.kotlinplayground.framework.api.entity.MediaItemDetails

/**
 * Created by andrijanstankovic on 31/08/2017.
 */
class Navigator {
    private fun startActivity(context: Context,intent:Intent,shouldFinish:Boolean ){
        val activity: Activity = context as Activity
        activity.startActivity(intent)
        if (shouldFinish)activity.finish()
    }

    fun navigateToDetailsScreen(context: Context,data:MediaItemDetails,shouldFinish: Boolean){

    }

}