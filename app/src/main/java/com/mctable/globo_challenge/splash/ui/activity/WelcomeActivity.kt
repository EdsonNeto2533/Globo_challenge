package com.mctable.globo_challenge.splash.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mctable.globo_challenge.R
import com.mctable.globo_challenge.commons.theme.Globo_challengeTheme
import com.mctable.globo_challenge.splash.ui.components.SplashScreen
import com.mctable.globo_challenge.splash.ui.viewmodel.WelcomeViewModel

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<WelcomeViewModel>()
            setupObservers(viewModel)
            Globo_challengeTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    backgroundColor = Color.Black,
                ) {
                    SplashScreen()
                }
            }
        }
    }

    private fun setupObservers(viewModel: WelcomeViewModel){
        viewModel.navigateToHome
    }

}