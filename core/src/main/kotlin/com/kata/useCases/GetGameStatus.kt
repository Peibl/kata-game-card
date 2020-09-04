package com.kata.useCases

import com.kata.domain.GameStatus
import com.kata.domain.CurrentGame

class GetGameStatus(val games: CurrentGame) {
    fun execute(): GameStatus {
        return games.current!!.getStatus()
    }
}
