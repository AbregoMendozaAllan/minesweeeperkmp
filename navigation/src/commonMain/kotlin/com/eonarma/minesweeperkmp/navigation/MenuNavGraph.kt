package com.eonarma.minesweeperkmp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.eonarma.minesweeperkmp.menu.presentation.MenuScreen

fun NavGraphBuilder.menuRoutes(
    goToPlay: () -> Unit,
    goToHighscores: () -> Unit,
    goToSettings: () -> Unit
) {

    composable<Screen.Menu> {
        MenuScreen(
            goToPlay = goToPlay,
            goToHighscores = goToHighscores,
            goToSettings = goToSettings,
            modifier = Modifier.fillMaxSize()
        )
    }
}