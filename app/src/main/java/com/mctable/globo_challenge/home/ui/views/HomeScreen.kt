package com.mctable.globo_challenge.home.ui.views

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mctable.globo_challenge.R
import com.mctable.globo_challenge.commons.components.HorizontalMovieList
import com.mctable.globo_challenge.commons.theme.GrayBackground
import com.mctable.globo_challenge.home.ui.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.onStart

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val context = LocalContext.current
    viewModel.getPopularsMovies()
    val moviesList = viewModel.popularsMovies.collectAsState(initial = emptyList())
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            HomeAppBar(context = context)
        },
        backgroundColor = GrayBackground
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp)
            ) {
                Text(
                    text = context.getString(R.string.home_screen_populars),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            HorizontalMovieList(movieList = moviesList.value)
        }
    }
}

@Composable
fun HomeAppBar(context: Context) {
    TopAppBar(
        backgroundColor = Color.Black,
        title = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = context.getString(R.string.app_name),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    )
}