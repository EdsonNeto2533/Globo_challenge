package com.mctable.globo_challenge.splash.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mctable.globo_challenge.R
import com.mctable.globo_challenge.commons.navigation.NavigationRoutes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.Black,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_globoplay_logo),
                contentDescription = context.getString(R.string.content_description_logo),
                modifier = Modifier
                    .padding(48.dp)
                    .height(200.dp)
                    .width(200.dp)
            )
        }
    }

    LaunchedEffect(true) {
        delay(5000)
        navController.navigate(NavigationRoutes.Home.route) {
            popUpTo(NavigationRoutes.Splash.route) {
                inclusive = true
            }
        }
    }

}