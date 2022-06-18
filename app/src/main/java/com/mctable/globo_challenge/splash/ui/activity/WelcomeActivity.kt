package com.mctable.globo_challenge.splash.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mctable.globo_challenge.commons.navigation.AppNavGraph
import com.mctable.globo_challenge.commons.theme.Globo_challengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Globo_challengeTheme {
                AppNavGraph()
            }
        }
    }

}