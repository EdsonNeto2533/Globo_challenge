package com.mctable.globo_challenge.commons.navigation

sealed class NavigationRoutes(val route: String) {

    companion object {
        private const val SPLASH_ROUTE = "splash_screen"
        private const val HOME_ROUTE = "home_screen"
    }

    object Splash : NavigationRoutes(SPLASH_ROUTE)

    object Home : NavigationRoutes(HOME_ROUTE)
}
