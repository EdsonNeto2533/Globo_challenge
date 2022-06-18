package com.mctable.globo_challenge.home.ui.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.mctable.globo_challenge.home.ui.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    viewModel.getPopularsMovies()
    LaunchedEffect(true) {
        viewModel.popularsMovies.onStart {
            println()
        }.collect{
            println(it)
        }
    }
    Text(text = "Aloooooo")
}