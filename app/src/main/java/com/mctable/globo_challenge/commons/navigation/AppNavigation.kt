package com.mctable.globo_challenge.commons.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mctable.globo_challenge.commons.utils.Arguments
import com.mctable.globo_challenge.home.ui.viewmodel.HomeViewModel
import com.mctable.globo_challenge.home.ui.views.HomeScreen
import com.mctable.globo_challenge.moviedetails.ui.view.MovieDetailsScreen
import com.mctable.globo_challenge.splash.ui.components.SplashScreen
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun AppNavGraph() {

    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.Splash.route
    ) {

        composable(route = NavigationRoutes.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = NavigationRoutes.Home.route) {
            HomeScreen(viewModel = hiltViewModel(), navController = navController)
        }

        composable(
            route = NavigationRoutes.Details.route,
            arguments = listOf(navArgument(Arguments.MOVIE_ID_ARG) { type = NavType.StringType })
        ) {
            val movieId = it.arguments?.getString(Arguments.MOVIE_ID_ARG) ?: "0"
            MovieDetailsScreen(viewModel = hiltViewModel(), movieId = movieId.toInt())
        }
    }
}