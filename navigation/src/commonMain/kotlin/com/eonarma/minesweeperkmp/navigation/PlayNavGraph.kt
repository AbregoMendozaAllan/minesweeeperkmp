package com.eonarma.minesweeperkmp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.eonarma.minesweeperkmp.play.presentation.PlayScreen

fun NavGraphBuilder.playRoutes() {
    composable<Screen.Play> {
        PlayScreen()
    }
}