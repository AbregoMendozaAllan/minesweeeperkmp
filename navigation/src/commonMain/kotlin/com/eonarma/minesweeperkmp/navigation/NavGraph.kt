package com.eonarma.minesweeperkmp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Menu
    ) {
        menuRoutes(
            goToPlay = { navController.navigate(Screen.Play) },
            goToHighscores = { navController.navigate(Screen.Highscores) },
            goToSettings = { navController.navigate(Screen.Settings) }
        )
        settingsRoutes(

        )
        highscoresRoutes(

        )
        playRoutes(

        )
    }
}