package com.eonarma.minesweeper.domain.game.di

import com.eonarma.minesweeperkmp.data.game.di.dataGameModule
import com.eonarma.minesweeperkmp.data.settings.di.dataSettingsModule
import org.koin.dsl.module

val domainGameModule = module {
    includes(
        dataSettingsModule,
        dataGameModule
    )
}