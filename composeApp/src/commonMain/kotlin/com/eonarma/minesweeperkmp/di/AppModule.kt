package com.eonarma.minesweeperkmp.di

import com.eonarma.minesweeperkmp.highscores.di.highscoresModule
import com.eonarma.minesweeperkmp.menu.di.menuModule
import com.eonarma.minesweeperkmp.play.di.playModule
import com.eonarma.minesweeperkmp.settings.di.settingsModule
import org.koin.dsl.module

val appModule = module {
    includes(
        highscoresModule,
        settingsModule,
        playModule,
        menuModule,
    )
}