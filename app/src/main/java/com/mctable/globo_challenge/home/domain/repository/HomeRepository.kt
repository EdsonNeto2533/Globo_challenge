package com.mctable.globo_challenge.home.domain.repository

import com.mctable.globo_challenge.commons.utils.ValidateResponse
import com.mctable.globo_challenge.home.data.api.HomeWebService
import com.mctable.globo_challenge.home.data.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeWebService: HomeWebService) :
    ValidateResponse() {

    suspend fun getPopularMovies(page: Int): List<MovieResponse>? {
        return withContext(Dispatchers.Default) {
            checkResponse(homeWebService.getPopularMovies(page = page))?.results
        }
    }
}