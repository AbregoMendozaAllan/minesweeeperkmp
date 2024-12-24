package com.eonarma.minesweeperkmp.play.di

import com.eonarma.minesweeper.domain.game.di.domainGameModule
import com.eonarma.minesweeperkmp.play.presentation.PlayViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val playModule = module {
    includes(domainGameModule)
    viewModel { PlayViewModel() }
}