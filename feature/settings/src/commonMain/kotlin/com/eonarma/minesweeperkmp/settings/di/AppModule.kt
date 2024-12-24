package com.eonarma.minesweeperkmp.settings.di

import com.eonarma.minesweeper.domain.settings.di.domainSettingsModule
import com.eonarma.minesweeperkmp.settings.presentation.SettingsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val settingsModule = module {
    includes(
        domainSettingsModule
    )
    viewModel { SettingsViewModel() }
}