package com.mctable.globo_challenge.moviedetails.domain.sealedclass

import com.mctable.globo_challenge.moviedetails.data.response.MovieDetailsResponse

sealed class MovieDetailsUIState {

    object Loading : MovieDetailsUIState()

    class Success(val movieDetails: MovieDetailsResponse) : MovieDetailsUIState()
}
