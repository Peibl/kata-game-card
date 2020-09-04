package com.kata.useCases

import com.kata.domain.CurrentGame
import com.kata.domain.Game

class StartGame(private val currentGame: CurrentGame) {
    fun execute() {
        val game = Game.new()
        game.start()
        currentGame.current = game
    }
}
