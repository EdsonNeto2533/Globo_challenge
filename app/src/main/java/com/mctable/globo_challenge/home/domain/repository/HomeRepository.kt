package com.mctable.globo_challenge.home.domain.repository

import com.mctable.globo_challenge.commons.utils.BaseRepository
import com.mctable.globo_challenge.home.data.api.HomeWebService
import com.mctable.globo_challenge.home.data.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeWebService: HomeWebService) :
    BaseRepository() {

    suspend fun getPopularMovies(page: Int): List<MovieResponse>? {
        return withContext(Dispatchers.Default) {
            checkResponse(homeWebService.getPopularMovies(page = page))?.results
        }
    }

    suspend fun getNowPlayingMovies(page: Int): List<MovieResponse>? {
        return withContext(Dispatchers.Default) {
            checkResponse(homeWebService.getNowPlaying(page = page))?.results
        }
    }

    suspend fun getUpcomingMovies(page: Int): List<MovieResponse>? {
        return withContext(Dispatchers.Default) {
            checkResponse(homeWebService.getUpcomingMovies(page = page))?.results
        }
    }
}