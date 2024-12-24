package com.eonarma.minesweeperkmp.highscores.di

import com.eonarma.minesweeper.domain.game.di.domainGameModule
import com.eonarma.minesweeperkmp.highscores.presentation.HighScoresViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val highscoresModule = module {
    includes(
        domainGameModule
    )
    viewModel { HighScoresViewModel() }

}