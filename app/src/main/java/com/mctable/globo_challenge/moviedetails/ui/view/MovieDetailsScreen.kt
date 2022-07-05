package com.mctable.globo_challenge.moviedetails.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mctable.globo_challenge.R
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
        topBar = { DetailsTopBar(navController = navController) }
    ) {

    }
}


@Composable
fun DetailsTopBar(navController: NavController) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        contentAlignment = Alignment.CenterStart
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = context.getString(R.string.content_description_arrow_back),
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)
                    .padding(16.dp)
            )
        }
    }
}
