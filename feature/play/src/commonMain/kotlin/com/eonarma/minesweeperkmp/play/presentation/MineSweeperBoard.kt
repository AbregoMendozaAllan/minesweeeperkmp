package com.eonarma.minesweeperkmp.play.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.eonarma.minesweeperkmp.play.TileState
import com.eonarma.minesweeperkmp.play.presentation.components.Tile

@Composable
fun MineSweeperBoard(
    tileStates: List<List<TileState>>,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle()
) {
    if (tileStates.isNotEmpty()) {
        val boardHeight: Int = remember { tileStates.first().size }
        val boardWidth: Int = remember { tileStates.size }
        BoxWithConstraints(
            contentAlignment = Alignment.Center,
            modifier = modifier
        ) {
            val requiredRatio: Float = boardWidth / boardHeight.toFloat()
            val currentRatio: Float = maxWidth / maxHeight
            val tileLength: Dp = if (requiredRatio > currentRatio) {
                maxWidth / boardWidth
            } else {
                maxHeight / boardHeight
            }
            val sizeAdjustedTextStyle = textStyle.copy(
                fontSize = tileLength.value.sp * 0.7f
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(tileLength * boardWidth)
                    .height(tileLength * boardHeight)
            ) {
                for (x in tileStates.indices) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        for (y in tileStates[x].indices) {
                            val tileState: TileState = tileStates[x][y]
                            val revealedBorderWidth: Dp = tileLength / 32
                            val hiddenBorderWidth: Dp = tileLength / 8
                            Tile(
                                state = tileState,
                                revealedBorderWidth = revealedBorderWidth,
                                hiddenBorderWidth = hiddenBorderWidth,
                                textStyle = sizeAdjustedTextStyle,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}