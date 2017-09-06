package com.andrijans.kotlinplayground.framework.api.entity

import com.google.gson.annotations.SerializedName



/**
 * Created by andrijanstankovic on 13/03/2017.
 */
open class BaseModel {
    @SerializedName("backdrop_path")
    val backdropPath: String? = null
    @SerializedName("genres")
    val genres = ArrayList<Genre>()
    val id: Int? = null
    @SerializedName("poster_path")
    val posterPath: String? = null
    @SerializedName("vote_average")
    val voteAverage: Double? = null

}