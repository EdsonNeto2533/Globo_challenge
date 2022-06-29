package com.mctable.globo_challenge.moviedetails.ui.view

import androidx.compose.runtime.Composable
import com.mctable.globo_challenge.moviedetails.ui.viewModel.MovieDetailsViewModel

@Composable
fun MovieDetailsScreen(viewModel: MovieDetailsViewModel, movieId: Int) {
   viewModel.getMovieDetails(movieId)
}
