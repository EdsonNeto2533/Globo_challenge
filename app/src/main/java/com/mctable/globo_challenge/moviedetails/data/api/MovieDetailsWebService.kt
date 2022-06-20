package com.mctable.globo_challenge.moviedetails.data.api

import com.mctable.globo_challenge.commons.utils.Constants
import com.mctable.globo_challenge.home.data.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsWebService {

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int,
        @Query("api_key") api_key: String = Constants.API_KEY
    ): Response<MovieResponse>

}