package com.kata.useCases

import com.kata.domain.Game
import com.kata.domain.GameStatus
import com.kata.domain.Human

class StartGame {
    fun execute(): GameStatus {
        val human = Human(30, 0)
        val game = Game(human)
        game.dealInitialHand()
        return game.generateStatus()
    }
}
