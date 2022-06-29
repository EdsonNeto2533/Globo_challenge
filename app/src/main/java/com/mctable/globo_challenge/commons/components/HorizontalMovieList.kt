package com.mctable.globo_challenge.commons.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mctable.globo_challenge.home.data.response.MovieResponse
import com.mctable.globo_challenge.home.domain.sealedclass.MoviesUIState

@Composable
fun HorizontalMovieList(
    state: MoviesUIState,
    movieClicked: (MovieResponse) -> Unit
) {
    when (state) {
        is MoviesUIState.Success -> {
            LazyRow(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentHeight()
            ) {
                items(items = state.moviesList, itemContent = {
                    CardMovie(movieResponse = it, modifier = Modifier.clickable {
                        movieClicked.invoke(it)
                    })
                })
            }
        }
        MoviesUIState.Loading -> {
            LazyRow(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentHeight()
            ) {
                items(items = listOf(1, 2, 3, 4, 5), itemContent = {
                    CardMovieShimmer()
                })
            }
        }
    }

}