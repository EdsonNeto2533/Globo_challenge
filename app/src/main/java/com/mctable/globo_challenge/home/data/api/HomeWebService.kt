package com.mctable.globo_challenge.home.data.api

import com.mctable.globo_challenge.commons.utils.Constants
import com.mctable.globo_challenge.home.data.response.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeWebService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") api_key: String = Constants.API_KEY,
        @Query("page") page: Int,
    ): Response<BaseResponse>

    @GET("/movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") api_key: String = Constants.API_KEY,
        @Query("page") page: Int,
    ): Response<BaseResponse>

    @GET("/movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") api_key: String = Constants.API_KEY,
        @Query("page") page: Int,
    ): Response<BaseResponse>



}