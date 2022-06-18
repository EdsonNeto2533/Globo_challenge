package com.mctable.globo_challenge.commons.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
            .height(350.dp)
            .padding(8.dp)
    ) {
        AsyncImage(
            model = movieResponse.getPostUrl(),
            contentDescription = movieResponse.movieName,
            alignment = Alignment.Center
        )
    }
}