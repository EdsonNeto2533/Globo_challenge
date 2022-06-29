package com.mctable.globo_challenge.moviedetails.domain.repository

import com.mctable.globo_challenge.commons.utils.BaseRepository
import com.mctable.globo_challenge.home.data.response.MovieResponse
import com.mctable.globo_challenge.moviedetails.data.api.MovieDetailsWebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDetailsRepository @Inject constructor(
    private val webService: MovieDetailsWebService
) : BaseRepository() {

    suspend fun getMovieDetails(movieId: Int): MovieResponse? {
        return withContext(Dispatchers.Default) {
            checkResponse(webService.getMovieDetails(movieId = movieId))
        }
    }
}