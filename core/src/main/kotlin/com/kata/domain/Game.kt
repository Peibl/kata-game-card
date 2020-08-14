package com.kata.domain

class Game(val human: Human) {
    var machineHealth = 30
        private set
    var humanHand = mutableListOf<Int>()
        private set
    var desk = mutableListOf(0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8)
        private set
    fun playHumanTurn(cardValue: Int) {
        if (this.human.mana < cardValue) throw Error()
        this.machineHealth -= cardValue
    }

    fun dealInitialHand() {
        pickRandomCard()
        pickRandomCard()
        pickRandomCard()
    }

    private fun pickRandomCard() {
        val card = desk.random()
        humanHand.add(card)
        desk.remove(card)
    }

    fun humanHand(): List<Int> {
        return humanHand
    }

    fun generateStatus(): GameStatus {
        return GameStatus(human.health, human.mana, humanHand(), desk.size)
    }
}
