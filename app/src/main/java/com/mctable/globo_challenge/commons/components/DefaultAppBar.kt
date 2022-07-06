package com.mctable.globo_challenge.commons.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mctable.globo_challenge.R

@Composable
fun DefaultAppBar(
    title: String?,
    hasArrowBack: Boolean,
    backArrowClick: (() -> Unit)? = null
) {
    val context = LocalContext.current
    TopAppBar(
        backgroundColor = Color.Black,
        title = {
            title?.let {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = title,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        },
        navigationIcon = {
            if (hasArrowBack) {
                IconButton(
                    onClick = { backArrowClick?.invoke() },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = context.getString(R.string.content_description_arrow_back),
                        modifier = Modifier
                            .height(48.dp)
                            .width(48.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }
        },
        actions = {
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)
                    .padding(16.dp)
            ) {

            }
        }
    )
}