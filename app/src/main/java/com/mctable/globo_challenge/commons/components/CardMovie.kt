package com.mctable.globo_challenge.commons.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mctable.globo_challenge.home.data.response.MovieResponse
import com.valentinilk.shimmer.shimmer

@Composable
fun CardMovie(
    movieResponse: MovieResponse,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(200.dp)
            .padding(end = 8.dp)
            .then(modifier)
    ) {
        AsyncImage(
            model = movieResponse.getPostUrl(),
            contentDescription = movieResponse.movieName,
            alignment = Alignment.Center
        )
    }
}

@Composable
fun CardMovieShimmer() {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(200.dp)
            .padding(8.dp)
            .shimmer()
            .background(Color.Gray)
    ) {

    }
}