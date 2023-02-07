package com.gh.ghcomposedemo

import androidx.compose.runtime.*
import com.gh.ghcomposedemo.ui.theme.AppTheme

@Composable
fun HomeEntry() {
    //是否闪屏页
    var isSplash by remember {
        mutableStateOf(true)
    }
    AppTheme{
        if (isSplash) {
            SplashPage { isSplash = false }
        } else {
            AppScaffold()
        }
    }
}