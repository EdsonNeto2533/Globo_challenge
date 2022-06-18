package com.mctable.globo_challenge.commons.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mctable.globo_challenge.home.ui.viewmodel.HomeViewModel
import com.mctable.globo_challenge.home.ui.views.HomeScreen
import com.mctable.globo_challenge.splash.ui.components.SplashScreen

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
            HomeScreen(viewModel = hiltViewModel())
        }
    }
}