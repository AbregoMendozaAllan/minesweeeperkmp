package com.eonarma.minesweeperkmp.data.settings.di

import com.eonarma.minesweeperkmp.data.core.di.dataCoreModule
import org.koin.dsl.module

val dataSettingsModule = module {
    includes(
        dataCoreModule
    )
}