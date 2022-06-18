package com.mctable.globo_challenge.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.globo_challenge.home.data.response.MovieResponse
import com.mctable.globo_challenge.home.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private var currentPage = 1

    private val _popularsMovies = MutableSharedFlow<List<MovieResponse>>()
    val popularsMovies = _popularsMovies.asSharedFlow()

    private val _upcomingMovies = MutableSharedFlow<List<MovieResponse>>()
    val upcomingMovies = _upcomingMovies.asSharedFlow()

    private val _nowPlayingMovies = MutableSharedFlow<List<MovieResponse>>()
    val nowPlayingMovies = _nowPlayingMovies.asSharedFlow()

    init {
        getPopularsMovies()
        getUpcomingMovies()
        getNowPlayingMovies()
    }

    private fun getPopularsMovies() {
        viewModelScope.launch {
            val response = homeRepository.getPopularMovies(1)
            response?.let {
                _popularsMovies.emit(it)
            }
        }
    }

    private fun getUpcomingMovies() {
        viewModelScope.launch {
            val response = homeRepository.getPopularMovies(1)
            response?.let {
                _upcomingMovies.emit(it)
            }
        }
    }

    private fun getNowPlayingMovies() {
        viewModelScope.launch {
            val response = homeRepository.getPopularMovies(1)
            response?.let {
                _nowPlayingMovies.emit(it)
            }
        }
    }

}