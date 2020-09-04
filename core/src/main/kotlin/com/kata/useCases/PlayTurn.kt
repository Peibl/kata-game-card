package com.kata.useCases

import com.kata.domain.CurrentGame

class PlayTurn(private val games: CurrentGame) {
    fun execute(cardValues: List<Int>) {
        games.current?.playHumanTurn(cardValues)
    }
}
