package com.gh.ghcomposedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


@Composable
fun SplashPage(onNextPage: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E)),
        contentAlignment = Alignment.TopCenter
    ) {
        LaunchedEffect(Unit) {
            delay(500)
            onNextPage.invoke()
        }
        Text(
            text = "GHComponseDemo",
            fontSize = 32.sp,
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(0.dp, 150.dp, 0.dp, 0.dp)
        )
    }

}