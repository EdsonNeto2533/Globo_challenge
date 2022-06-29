package com.mctable.globo_challenge.home.domain.sealedclass

import com.mctable.globo_challenge.home.data.response.MovieResponse

sealed class MoviesUIState {
    object Loading : MoviesUIState()

    class Success(val moviesList: List<MovieResponse>) : MoviesUIState()
}
