package com.kata.domain

class Game(val human: Human) {
    var machineHealth = 30
        private set

    fun playHumanTurn(cardValue: Int) {
        if (this.human.mana < cardValue) throw Error()
        this.machineHealth -= cardValue
    }
}
