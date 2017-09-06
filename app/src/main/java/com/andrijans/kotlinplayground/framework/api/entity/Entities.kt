package com.andrijans.kotlinplayground.framework.api.entity

import com.andrijans.kotlinplayground.framework.api.entity.common.ListResult
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by andrijanstankovic on 13/03/2017.
 */

data class Genre(val id: Int, val name: String)

data class GenreResult(val genres: List<Genre>)

data class Cast(@SerializedName("cast_id") val castId: Int,
                val character: String,
                @SerializedName("credit_id") val creditId: String,
                val id: Int,
                val name: String,
                val order: Int
)

data class CastResult(val id: Int, val cast: List<Cast>)


data class SearchData(val page :Int, val results :List<MediaItemDetails>,
                      @SerializedName("total_results") val totalResults : Int,
                      @SerializedName("total_pages") val totalPages : Int)