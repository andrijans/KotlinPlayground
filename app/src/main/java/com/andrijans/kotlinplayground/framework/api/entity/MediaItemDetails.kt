package com.andrijans.kotlinplayground.framework.api.entity;

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MediaItemDetails : BaseModel(), Serializable {

    enum class Type {
        Movie, Series
    }

    var type: Type? = null

    var overview: String? = null
    @SerializedName("title")
    var title: String? = null
        get() {
            if (name != null) {
                return name
            }
            return field
        }
    var runtime = 0
    var tagline: String? = null
    var popularity: Double? = null

    @SerializedName("genre_ids")
    val genreIds: List<Int> = ArrayList()

    /** property of series  */
    @SerializedName("name")
    var name: String? = null
    @SerializedName("number_of_episodes")
    var numberOfEpisodes: Int? = null
    @SerializedName("number_of_seasons")
    var numberOfSeasons: Int? = null
    @SerializedName("first_air_date")
    var firstAirDate: String? = null
    @SerializedName("last_air_date")
    var lastAirDate: String? = null
}