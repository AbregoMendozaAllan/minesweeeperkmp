package com.eonarma.minesweeperkmp.play.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.eonarma.minesweeperkmp.play.TileState
import minesweeperkmp.feature.play.generated.resources.Res
import minesweeperkmp.feature.play.generated.resources.mine
import org.jetbrains.compose.resources.painterResource

@Composable
fun Tile(
    state: TileState,
    revealedBorderWidth: Dp,
    hiddenBorderWidth: Dp,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color = LocalMinesweeperBoardColorScheme.current.background)
            .run {
                if (state is TileState.Revealed) {
                    border(width = revealedBorderWidth, color = LocalMinesweeperBoardColorScheme.current.borderDark)
                } else {
                    hiddenTile(
                        borderThickness = hiddenBorderWidth,
                        lightColor = LocalMinesweeperBoardColorScheme.current.borderLight,
                        darkColor = LocalMinesweeperBoardColorScheme.current.borderDark
                    )
                }
            }

    ) {
        when (state) {
            is TileState.Hidden -> if (state.flagged) {
                Icon(
                    imageVector = Icons.Filled.Flag,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(fraction = 0.6f)
                )
            }
            TileState.Revealed.Mine -> {
                Icon(
                    painter = painterResource(Res.drawable.mine),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            is TileState.Revealed.Number -> {
                state.value?.let { number ->
                    val color = when (number) {
                        1 -> LocalMinesweeperBoardColorScheme.current.one
                        2 -> LocalMinesweeperBoardColorScheme.current.two
                        3 -> LocalMinesweeperBoardColorScheme.current.three
                        4 -> LocalMinesweeperBoardColorScheme.current.four
                        5 -> LocalMinesweeperBoardColorScheme.current.five
                        6 -> LocalMinesweeperBoardColorScheme.current.six
                        7 -> LocalMinesweeperBoardColorScheme.current.seven
                        8 -> LocalMinesweeperBoardColorScheme.current.eight
                        else -> Color.Black
                    }
                    Text(
                        text = number.toString(),
                        style = textStyle,
                        textAlign = TextAlign.Center,
                        color = color,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight(
                                align = Alignment.CenterVertically,
                            )
                    )
                }
            }
        }
    }
}

@Composable
private fun Modifier.hiddenTile(
    borderThickness: Dp,
    lightColor: Color,
    darkColor: Color,
): Modifier = drawWithContent {
    drawContent()
    val thicknessPx: Float = borderThickness.toPx()
    val width: Float = size.width
    val height: Float = size.height

    drawPath(
        path = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, height)
            lineTo(thicknessPx, height - thicknessPx)
            lineTo(thicknessPx, thicknessPx)
            lineTo(width - thicknessPx, thicknessPx)
            lineTo(width, 0f)
        },
        color = lightColor,
    )
    drawPath(
        path = Path().apply {
            moveTo(0f, height)
            lineTo(thicknessPx, height - thicknessPx)
            lineTo(width - thicknessPx, height - thicknessPx)
            lineTo(width - thicknessPx, thicknessPx)
            lineTo(width, 0f)
            lineTo(width, height)

        },
        color = darkColor
    )
}

@Immutable
data class MinesweeperBoardColorScheme(
    val background: Color = Color(0xFFCBCBCB),
    val borderLight: Color = Color(0xFFFFFFFF),
    val borderDark: Color = Color(0xFF8F8F8F),
    val mine: Color = Color(0xFF000000),
    val flag: Color = Color(0xFFEB392A),
    val one: Color = Color(0xFF0000F5),
    val two: Color = Color(0xFF377E22),
    val three: Color = Color(0xFFFA3323),
    val four: Color = Color(0xFF00007B),
    val five: Color = Color(0xFF75140C),
    val six: Color = Color(0xFF377E7F),
    val seven: Color = Color(0xFF75147C),
    val eight: Color = Color(0xFF808080),
    val timerText: Color = Color(0xFFEA3324),
)

internal val LocalMinesweeperBoardColorScheme = compositionLocalOf { MinesweeperBoardColorScheme() }

private fun getAllPossibleTileStates() = setOf(
    TileState.Hidden(flagged = true),
    TileState.Hidden(flagged = false),
    TileState.Revealed.Mine,
    TileState.Revealed.Number(value = null),
    TileState.Revealed.Number(value = 1),
    TileState.Revealed.Number(value = 2),
    TileState.Revealed.Number(value = 3),
    TileState.Revealed.Number(value = 4),
    TileState.Revealed.Number(value = 5),
    TileState.Revealed.Number(value = 6),
    TileState.Revealed.Number(value = 7),
    TileState.Revealed.Number(value = 8)
)



