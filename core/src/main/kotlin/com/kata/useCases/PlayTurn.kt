package com.kata.useCases

import com.kata.domain.Game

class PlayTurn(private val game: Game) {
    fun execute(vararg cardValues: Int) {
        if(cardValues.any { it > 8 }) throw Error()
        game.playHumanTurn(cardValues.sumBy { it })
    }
}
