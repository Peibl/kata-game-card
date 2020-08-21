package com.kata.domain

private const val initialHealth = 30

class Game(humanMana: Int = 0) {
    private val human = Human(initialHealth, humanMana)
    var machineHealth = initialHealth
        private set

    private var desk = mutableListOf(0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8)

    fun start() {
        human.pickCards(desk)
    }

    fun playHumanTurn(cardValues: List<Int>) {
        this.machineHealth -= human.playCards(cardValues)
    }

    fun getStatus(): GameStatus {
        val humanStatus = human.getStatus()
        return GameStatus(humanStatus.health, humanStatus.mana, humanStatus.hand, desk.size)
    }
}
