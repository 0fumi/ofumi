package com.ofumi.ui

import androidx.compose.runtime.Composable
import com.ofumi.navigation.AppNavigation
import com.ofumi.ui.theme.OfumiTheme

@Composable
fun OfumiApp() {
    OfumiTheme {
        AppNavigation()
    }
}