package com.kata.domain

private const val initialHealth = 30

class Game(humanMana: Int = 0) {
    private val human = Human(initialHealth, humanMana)
    private var machineHealth = initialHealth

    private var deck = Deck()

    fun start() {
        human.pickCards(deck, 3)
    }

    fun playHumanTurn(cardValues: List<Int>) {
        this.machineHealth -= human.playCards(cardValues)
    }

    fun getStatus(): GameStatus {
        val humanStatus = human.getStatus()
        return GameStatus(humanStatus, deck.size(), machineHealth)
    }
}

