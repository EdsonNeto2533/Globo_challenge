package com.mctable.globo_challenge.home.ui.views

import android.content.Context
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mctable.globo_challenge.R
import com.mctable.globo_challenge.commons.components.HorizontalMovieList
import com.mctable.globo_challenge.commons.theme.GrayBackground
import com.mctable.globo_challenge.home.data.response.MovieResponse
import com.mctable.globo_challenge.home.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val context = LocalContext.current
    val popularMovies = viewModel.popularsMovies.collectAsState(initial = emptyList())
    val upcomingMovies = viewModel.upcomingMovies.collectAsState(initial = emptyList())
    val nowPlayingMovies = viewModel.nowPlayingMovies.collectAsState(initial = emptyList())
    val scrollStateVertical = rememberScrollState()
    Scaffold(
        modifier = Modifier
            .wrapContentHeight(),
        topBar = {
            HomeAppBar(context = context)
        },
        backgroundColor = GrayBackground
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollStateVertical),
        ) {
            LabelList(
                label = context.getString(R.string.home_screen_populars),
                moviesList = popularMovies.value,
            )
            LabelList(
                label = context.getString(R.string.home_screen_upcoming),
                moviesList = upcomingMovies.value,
            )
            LabelList(
                label = context.getString(R.string.home_screen_now_playing),
                moviesList = nowPlayingMovies.value,
            )
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

@Composable
fun LabelList(label: String, moviesList: List<MovieResponse>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = label,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
    }
    HorizontalMovieList(movieList = moviesList)
}
