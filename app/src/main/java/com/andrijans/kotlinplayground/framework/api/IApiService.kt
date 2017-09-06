package com.andrijans.kotlinplayground.framework.api

import com.andrijans.kotlinplayground.framework.api.entity.CastResult
import com.andrijans.kotlinplayground.framework.api.entity.ListMediaResult
import com.andrijans.kotlinplayground.framework.api.entity.MediaItemDetails
import com.andrijans.kotlinplayground.framework.api.entity.SearchData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by andrijanstankovic on 13/03/2017.
 */
interface IApiService {
    @GET("search/movie")
    fun searchMovies(
            @Query("query") query: String,
            @Query("page") page: Int
    ): Observable<SearchData>

    @GET("movie/{id}")
    fun getMovieDetails(
            @Path("id") id: String
    ): Observable<MediaItemDetails>

    @GET("movie/{movie_id}/credits")
    fun getMovieCast(
            @Path("movie_id") movieId: String
    ): Observable<CastResult>

    @GET("search/tv")
    fun searchSeries(
            @Query("query") query: String,
            @Query("page") page: Int
    ): Observable<SearchData>

    @GET("tv/{tv_id}")
    fun getSeriesDetails(
            @Path("tv_id") id: String
    ): Observable<MediaItemDetails>

    @GET("tv/{tv_id}/credits")
    fun getSeriesCast(
            @Path("tv_id") seriesId: String
    ): Observable<CastResult>

    @GET("movie/now_playing")
    fun getNowPlaying(
            @Query("page") page: Int
    ): Observable<ListMediaResult>

    @GET("tv/popular")
    fun getPopularShows(
            @Query("page") page: Int
    ): Observable<ListMediaResult>
}