package com.eonarma.minesweeper.domain.settings.di

import com.eonarma.minesweeperkmp.data.settings.di.dataSettingsModule
import org.koin.dsl.module

val domainSettingsModule = module {
    includes(dataSettingsModule)
}