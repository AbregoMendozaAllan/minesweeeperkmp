package com.eonarma.minesweeperkmp.data.game.di

import com.eonarma.minesweeperkmp.data.core.di.dataCoreModule
import org.koin.dsl.module

val dataGameModule = module {
    includes(
        dataCoreModule
    )
}