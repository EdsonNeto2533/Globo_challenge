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

    fun getPopularsMovies() {
        viewModelScope.launch {
            val response = homeRepository.getPopularMovies(1)
            response?.let {
                _popularsMovies.emit(it)
            }
        }
    }

}