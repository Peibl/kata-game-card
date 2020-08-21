package com.kata.useCases

import com.kata.domain.Game

class PlayTurn(private val game: Game) {
    fun execute(cardValues: List<Int>) {
        game.playHumanTurn(cardValues)
    }
}
