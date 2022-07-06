package com.mctable.globo_challenge.moviedetails.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mctable.globo_challenge.commons.components.DefaultAppBar
import com.mctable.globo_challenge.moviedetails.domain.sealedclass.MovieDetailsUIState
import com.mctable.globo_challenge.moviedetails.ui.viewModel.MovieDetailsViewModel

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel,
    movieId: Int,
    navController: NavController
) {
    viewModel.getMovieDetails(movieId)
    val movieState =
        viewModel.movieDetailsState.collectAsState(initial = MovieDetailsUIState.Loading)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DefaultAppBar(title = null,
                hasArrowBack = true,
                backArrowClick = {
                    navController.popBackStack()
                })
        }
    ) {

    }
}
