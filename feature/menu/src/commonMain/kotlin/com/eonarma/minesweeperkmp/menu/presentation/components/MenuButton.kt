package com.eonarma.minesweeperkmp.menu.presentation.components

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun MenuButton(
    text: String,
    onClick: ()-> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        content = { Text(text = text) }
    )
}