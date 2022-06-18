package com.mctable.globo_challenge.home.ui.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.mctable.globo_challenge.home.ui.viewmodel.HomeViewModel
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    LaunchedEffect(true) {

    }
    Text(text = "Aloooooo")
}