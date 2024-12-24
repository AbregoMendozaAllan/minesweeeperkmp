package com.eonarma.minesweeperkmp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.eonarma.minesweeperkmp.highscores.presentation.HighscoresScreen

fun NavGraphBuilder.highscoresRoutes(

) {

    composable<Screen.Highscores> {
        HighscoresScreen(

        )
    }
}