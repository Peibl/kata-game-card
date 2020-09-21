package com.kata.domain

class Game(private val activePlayer: Player, private val opponent: Machine) {
    fun start() {
        activePlayer.pickCards(3)
    }

    fun playHumanTurn(cardValues: List<Int>) {
        this.opponent.reduceHealth(activePlayer.playCards(cardValues))
    }

    fun getStatus(): GameStatus {
        val humanStatus = activePlayer.getStatus()
        val machineStatus = opponent.getStatus()
        return GameStatus(humanStatus, machineStatus)
    }

    companion object {
        fun new(): Game {
            val human = Player(0, 30, Deck(), Hand())
            val machine = Machine(30)
            return Game(human, machine)
        }
    }
}





