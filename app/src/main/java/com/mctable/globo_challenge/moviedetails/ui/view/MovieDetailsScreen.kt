package com.mctable.globo_challenge.moviedetails.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.mctable.globo_challenge.R
import com.mctable.globo_challenge.commons.components.DefaultAppBar
import com.mctable.globo_challenge.moviedetails.data.response.MovieDetailsResponse
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
        },
        backgroundColor = Color.Black
    ) {
        if (movieState.value is MovieDetailsUIState.Success)
            DetailsLayout(movieResponse = (movieState.value as MovieDetailsUIState.Success).movieDetails)
    }
}

@Composable
fun DetailsLayout(movieResponse: MovieDetailsResponse) {
    val context = LocalContext.current
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Black),
        startY = 250.dp.value / 3,  // 1/3
        endY = 250.dp.value
    )
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            AsyncImage(
                model = movieResponse.getPostUrl(),
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.FillBounds
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(gradient)
            )
        }

        Text(
            text = movieResponse.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )

        Text(
            text = context.getString(R.string.movie_details_synopsis),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )

        Text(
            text = movieResponse.description,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
        )
    }

}
