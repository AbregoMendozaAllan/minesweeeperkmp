package com.eonarma.minesweeperkmp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.eonarma.minesweeperkmp.settings.presentation.SettingsScreen

fun NavGraphBuilder.settingsRoutes(

) {

    composable<Screen.Settings> {
        SettingsScreen()
    }
}