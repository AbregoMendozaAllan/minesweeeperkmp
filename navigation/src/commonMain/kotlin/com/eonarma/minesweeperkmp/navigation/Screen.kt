package com.eonarma.minesweeperkmp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Menu: Screen()

    @Serializable
    data object Highscores: Screen()

    @Serializable
    data object Play: Screen()

    @Serializable
    data object Settings: Screen()
}