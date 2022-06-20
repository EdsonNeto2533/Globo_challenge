package com.mctable.globo_challenge.moviedetails.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.globo_challenge.moviedetails.domain.repository.MovieDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository
) : ViewModel() {

    fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            val aux = movieDetailsRepository.getMovieDetails(movieId)
            println(aux)
        }
    }
}