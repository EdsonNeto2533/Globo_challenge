package com.mctable.globo_challenge.moviedetails.domain.sealedclass

import com.mctable.globo_challenge.home.data.response.MovieResponse

sealed class MovieDetailsUIState {

    object Loading : MovieDetailsUIState()

    class Success(val movieDetails: MovieResponse) : MovieDetailsUIState()
}
