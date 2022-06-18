package com.mctable.globo_challenge.commons.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mctable.globo_challenge.home.data.response.MovieResponse

@Composable
fun HorizontalMovieList(
    movieList: List<MovieResponse>
) {
    LazyRow(modifier = Modifier.padding(16.dp)) {
        items(items = movieList, itemContent = {
            CardMovie(movieResponse = it)
        })
    }
}