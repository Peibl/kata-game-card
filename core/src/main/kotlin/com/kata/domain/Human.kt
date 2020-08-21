package com.kata.domain

class Human(val mana: Int) {
    private var health = 30
    private var hand = mutableListOf<Int>()

    fun pickCards(desk: Deck, amount: Int) {
        hand.addAll(desk.pickCards(amount))
    }

    fun getStatus() = HumanStatus(health, mana, hand)

    fun playCards(cardValues: List<Int>): Int {
        if(cardValues.any { it > 8 }) throw Error()
        val cardValue = cardValues.sumBy { it }
        if (mana < cardValue) throw Error()
        return cardValue
    }
}
