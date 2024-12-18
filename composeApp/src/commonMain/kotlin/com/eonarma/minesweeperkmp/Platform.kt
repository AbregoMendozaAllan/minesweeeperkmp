package com.eonarma.minesweeperkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform