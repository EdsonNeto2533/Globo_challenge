package com.mctable.globo_challenge.commons.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mctable.globo_challenge.home.data.response.MovieResponse

@Composable
fun CardMovie(movieResponse: MovieResponse) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .wrapContentHeight()
            .padding(end = 8.dp)
    ) {
        AsyncImage(
            model = movieResponse.getPostUrl(),
            contentDescription = movieResponse.movieName,
            alignment = Alignment.Center
        )
    }
}