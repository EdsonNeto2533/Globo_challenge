package com.mctable.globo_challenge.moviedetails.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.globo_challenge.moviedetails.domain.repository.MovieDetailsRepository
import com.mctable.globo_challenge.moviedetails.domain.sealedclass.MovieDetailsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository
) : ViewModel() {

    private val _movieDetailsUIState = MutableSharedFlow<MovieDetailsUIState>()
    val movieDetailsState = _movieDetailsUIState.asSharedFlow()

    fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            val response = movieDetailsRepository.getMovieDetails(movieId)
            response?.let {
                _movieDetailsUIState.emit(MovieDetailsUIState.Success(it))
            }
        }
    }
}