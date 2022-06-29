package com.mctable.globo_challenge.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.globo_challenge.home.domain.repository.HomeRepository
import com.mctable.globo_challenge.home.domain.sealedclass.MoviesUIState
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

    private val _popularsMovies = MutableSharedFlow<MoviesUIState>()
    val popularsMovies = _popularsMovies.asSharedFlow()

    private val _upcomingMovies = MutableSharedFlow<MoviesUIState>()
    val upcomingMovies = _upcomingMovies.asSharedFlow()

    private val _nowPlayingMovies = MutableSharedFlow<MoviesUIState>()
    val nowPlayingMovies = _nowPlayingMovies.asSharedFlow()

    init {
        getPopularsMovies()
    }

    private fun getPopularsMovies() {
        viewModelScope.launch {
            val response = homeRepository.getPopularMovies(1)
            response?.let {
                _popularsMovies.emit(MoviesUIState.Success(it))
                getUpcomingMovies()
            }
        }
    }

    private fun getUpcomingMovies() {
        viewModelScope.launch {
            val response = homeRepository.getUpcomingMovies(1)
            response?.let {
                _upcomingMovies.emit(MoviesUIState.Success(it))
                getNowPlayingMovies()
            }
        }
    }

    private fun getNowPlayingMovies() {
        viewModelScope.launch {
            val response = homeRepository.getNowPlayingMovies(1)
            response?.let {
                _nowPlayingMovies.emit(MoviesUIState.Success(it))
            }
        }
    }

}