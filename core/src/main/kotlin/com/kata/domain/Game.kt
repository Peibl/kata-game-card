package com.kata.domain

class Game(humanMana: Int = 0) {
    private val human = Human(humanMana)
    private val machine = Machine()
    private var deck = Deck()

    fun start() {
        human.pickCards(deck, 3)
    }

    fun playHumanTurn(cardValues: List<Int>) {
        this.machine.reduceHealth(human.playCards(cardValues))
    }

    fun getStatus(): GameStatus {
        val humanStatus = human.getStatus()
        val machineStatus = machine.getStatus()
        return GameStatus(humanStatus, machineStatus, deck.size())
    }
}




