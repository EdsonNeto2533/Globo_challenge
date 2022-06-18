package com.mctable.globo_challenge.home.ui.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.mctable.globo_challenge.commons.components.HorizontalMovieList
import com.mctable.globo_challenge.home.ui.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.onStart

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    viewModel.getPopularsMovies()
    val moviesList = viewModel.popularsMovies.collectAsState(initial = emptyList())
    HorizontalMovieList(movieList = moviesList.value)
}