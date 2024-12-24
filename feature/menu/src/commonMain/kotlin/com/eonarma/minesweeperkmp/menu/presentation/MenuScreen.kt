package com.eonarma.minesweeperkmp.menu.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.eonarma.minesweeperkmp.menu.presentation.components.MenuButton
import com.eonarma.minesweeperkmp.ui.core.LocalDimensions
import com.eonarma.minesweeperkmp.ui.core.LocalPadding

@Composable
fun MenuScreen(
    goToPlay: () -> Unit,
    goToHighscores: () -> Unit,
    goToSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        val buttonModifier = Modifier
            .padding(horizontal = LocalPadding.current.normal)
            .widthIn(max = LocalDimensions.current.maxWidthSmall)
            .fillMaxWidth()
        MenuButton(
            onClick = goToPlay,
            modifier = buttonModifier,
            text = "Go to Play"
        )
        MenuButton(
            onClick = goToHighscores,
            modifier = buttonModifier,
            text = "Go to Highscores"
        )
        MenuButton(
            onClick = goToSettings,
            modifier = buttonModifier,
            text = "Go to Settings"
        )
    }
}